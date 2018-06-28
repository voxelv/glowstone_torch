package com.voxelv.glowstone_torch.init;

import com.voxelv.glowstone_torch.objects.blocks.BlockBase;
import com.voxelv.glowstone_torch.objects.blocks.BlockGlowstoneTorch;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;

import java.util.ArrayList;
import java.util.List;

public class BlockInit {
    public static final List<Block> BLOCKS = new ArrayList<Block>();

    public static final Block BLOCK_GLOWSTONE_SOLIDIFIED = new BlockBase("block_glowstone_solidified", Material.ROCK).setLightLevel(1.0F).setHardness(2.0F).setResistance(10.0F);
    public static final Block BLOCK_GLOWSTONE_TORCH = new BlockGlowstoneTorch("block_glowstone_torch").setLightLevel(1.0F).setHardness(0.4F);
}
