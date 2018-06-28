package com.voxelv.glowstone_torch.objects.tools;

import com.voxelv.glowstone_torch.GlowstoneTorch;
import com.voxelv.glowstone_torch.init.ItemInit;
import com.voxelv.glowstone_torch.util.IHasModel;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemPickaxe;

public class ToolPickaxe extends ItemPickaxe implements IHasModel {
    public ToolPickaxe(String name, ToolMaterial material) {
        super(material);
        setUnlocalizedName(name);
        setRegistryName(name);
        setCreativeTab(GlowstoneTorch.glowstone_torch_tab);

        ItemInit.ITEMS.add(this);
    }

    @Override
    public void registerModels() {
        GlowstoneTorch.proxy.registerItemRenderer(this, 0, "inventory");
    }
}