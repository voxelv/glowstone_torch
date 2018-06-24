package com.voxelv.glowstone_torch;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;

public class GlowstoneTorchTab extends CreativeTabs {

    public GlowstoneTorchTab(String label) {
        super(label);
        this.setBackgroundImageName("glowstone_torch_tab.png");
    }

    @Override
    public ItemStack getTabIconItem(){
        return null;
    }
}
