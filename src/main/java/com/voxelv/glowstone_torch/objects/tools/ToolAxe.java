package com.voxelv.glowstone_torch.objects.tools;

import com.google.common.collect.Sets;
import com.voxelv.glowstone_torch.GlowstoneTorch;
import com.voxelv.glowstone_torch.init.ItemInit;
import com.voxelv.glowstone_torch.util.IHasModel;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemTool;

import javax.annotation.Nullable;
import java.util.Set;

public class ToolAxe extends ItemTool implements IHasModel {
    private static final Set<Block> EFFECTIVE_ON = Sets.newHashSet(Blocks.PLANKS, Blocks.BOOKSHELF, Blocks.LOG, Blocks.LOG2, Blocks.CHEST, Blocks.PUMPKIN, Blocks.MELON_BLOCK, Blocks.LADDER, Blocks.WOODEN_BUTTON, Blocks.WOODEN_PRESSURE_PLATE);

    public ToolAxe(String name, Item.ToolMaterial material) {
        super(material, EFFECTIVE_ON);

        setUnlocalizedName(name);
        setRegistryName(name);
        setCreativeTab(GlowstoneTorch.glowstone_torch_tab);

        ItemInit.ITEMS.add(this);
    }

    @Override
    public float getDestroySpeed(@Nullable ItemStack stack, IBlockState state) {
        Material material = state.getMaterial();
        return material != Material.WOOD && material != Material.PLANTS && material != Material.VINE ? super.getDestroySpeed(stack, state) : this.efficiency;
    }

    @Override
    public void registerModels() {
        GlowstoneTorch.proxy.registerItemRenderer(this, 0, "inventory");
    }
}