package com.voxelv.glowstone_torch.objects.blocks;

import com.voxelv.glowstone_torch.GlowstoneTorch;
import com.voxelv.glowstone_torch.init.BlockInit;
import com.voxelv.glowstone_torch.util.IHasModel;
import net.minecraft.block.Block;
import net.minecraft.block.BlockDirectional;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.Item;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.Mirror;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockGlowstoneTorch extends BlockDirectional implements IHasModel {
    protected String name;

    protected static final AxisAlignedBB AABB_DOWN = new AxisAlignedBB( 0.3125D,    0.1875D,    0.3125D,
                                                                        0.6875D,    1.0D,       0.6875D);
    protected static final AxisAlignedBB AABB_UP = new AxisAlignedBB(   0.3125D,    0.0D,       0.3125D,
                                                                        0.6875D,    0.8125D,    0.6875D);
    protected static final AxisAlignedBB AABB_NORTH = new AxisAlignedBB(0.3125D,    0.3125D,    1.0D,
                                                                        0.6875D,    0.6875D,    0.1875D);
    protected static final AxisAlignedBB AABB_SOUTH = new AxisAlignedBB(0.3125D,    0.3125D,    0.0D,
                                                                        0.6875D,    0.6875D,    0.8125D);
    protected static final AxisAlignedBB AABB_WEST = new AxisAlignedBB( 1.0D,       0.3125D,    0.3125D,
                                                                        0.1875D,    0.6875D,    0.6875D);
    protected static final AxisAlignedBB AABB_EAST = new AxisAlignedBB( 0.0D,       0.3125D,    0.3125D,
                                                                        0.8125D,    0.6875D,    0.6875D);

    public BlockGlowstoneTorch(String name) {
        super(Material.CIRCUITS);
        this.name = name;
        setRegistryName(this.name);
        setUnlocalizedName(this.name);
        setCreativeTab(CreativeTabs.MATERIALS);

        BlockInit.BLOCKS.add(this);
    }

    /*******************************************************************************************************************
     * Bounding Box Methods
     ******************************************************************************************************************/
    @Override
    public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos) {
        EnumFacing enumFacing = state.getValue(FACING);
        switch(enumFacing) {
            case UP:
                return AABB_UP;
            case DOWN:
                return AABB_DOWN;
            case NORTH:
                return AABB_NORTH;
            case SOUTH:
                return AABB_SOUTH;
            case EAST:
                return AABB_EAST;
            case WEST:
                return AABB_WEST;
            default:
                return AABB_UP;
        }
    }

    private boolean checkForDrop(World worldIn, BlockPos pos, IBlockState state)
    {
        if (this.canPlaceBlockAt(worldIn, pos))
        {
            return true;
        }
        else
        {
            this.dropBlockAsItem(worldIn, pos, state, 0);
            worldIn.setBlockToAir(pos);
            return false;
        }
    }

    /*******************************************************************************************************************
     * Make it Not a Full Cube Methods
     ******************************************************************************************************************/
    @Override
    public boolean isOpaqueCube(IBlockState state) {
        return false;
    }

    @Override
    public boolean isFullCube(IBlockState state) {
        return false;
    }

    @Override
    public BlockRenderLayer getBlockLayer() {
        return BlockRenderLayer.CUTOUT;
    }

    /*******************************************************************************************************************
     * Can it be Placed Methods
     ******************************************************************************************************************/
    @Override
    public boolean canPlaceBlockOnSide(World worldIn, BlockPos pos, EnumFacing side)
    {
        return canPlaceBlock(worldIn, pos, side.getOpposite());
    }

    @Override
    public boolean canPlaceBlockAt(World worldIn, BlockPos pos)
    {
        for (EnumFacing enumfacing : EnumFacing.values())
        {
            if (canPlaceBlock(worldIn, pos, enumfacing))
            {
                return true;
            }
        }

        return false;
    }

    protected static boolean canPlaceBlock(World worldIn, BlockPos pos, EnumFacing direction)
    {
        BlockPos blockpos = pos.offset(direction);
        return worldIn.getBlockState(blockpos).isSideSolid(worldIn, blockpos, direction.getOpposite());
    }

    /*******************************************************************************************************************
     * Different Rotation Methods
     ******************************************************************************************************************/
    @Override
    public IBlockState getStateFromMeta(int meta)
    {
        EnumFacing enumfacing;

        switch (meta & 7)
        {
            case 0:
                enumfacing = EnumFacing.DOWN;
                break;
            case 1:
                enumfacing = EnumFacing.EAST;
                break;
            case 2:
                enumfacing = EnumFacing.WEST;
                break;
            case 3:
                enumfacing = EnumFacing.SOUTH;
                break;
            case 4:
                enumfacing = EnumFacing.NORTH;
                break;
            case 5:
            default:
                enumfacing = EnumFacing.UP;
        }

        return this.getDefaultState().withProperty(FACING, enumfacing);
    }

    public int getMetaFromState(IBlockState state)
    {
        int i;

        switch (state.getValue(FACING))
        {
            case EAST:
                i = 1;
                break;
            case WEST:
                i = 2;
                break;
            case SOUTH:
                i = 3;
                break;
            case NORTH:
                i = 4;
                break;
            case UP:
            default:
                i = 5;
                break;
            case DOWN:
                i = 0;
        }

        return i;
    }

    @Override
    public IBlockState withRotation(IBlockState state, Rotation rot)
    {
        return state.withProperty(FACING, rot.rotate(state.getValue(FACING)));
    }

    @Override
    public IBlockState withMirror(IBlockState state, Mirror mirrorIn)
    {
        return state.withRotation(mirrorIn.toRotation(state.getValue(FACING)));
    }

    protected BlockStateContainer createBlockState()
    {
        return new BlockStateContainer(this, FACING);
    }

    /*******************************************************************************************************************
     * Registration Methods
     ******************************************************************************************************************/
    @Override
    public void registerModels() {
        GlowstoneTorch.proxy.registerItemRenderer(Item.getItemFromBlock(this), 0, this.name);
    }
}
