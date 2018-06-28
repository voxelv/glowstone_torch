package com.voxelv.glowstone_torch.tabs;

import com.voxelv.glowstone_torch.init.BlockInit;
import com.voxelv.glowstone_torch.init.ItemInit;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class GlowstoneTorchTab extends CreativeTabs {

    public GlowstoneTorchTab() {
        super("glowstone_torch");
        this.setBackgroundImageName("glowstone_torch.png");
    }

    @Override
    public ItemStack getTabIconItem() {
        return new ItemStack(Item.getItemFromBlock(BlockInit.BLOCK_GLOWSTONE_SOLIDIFIED));
    }
}
