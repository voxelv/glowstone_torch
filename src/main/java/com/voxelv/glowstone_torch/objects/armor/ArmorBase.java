package com.voxelv.glowstone_torch.objects.armor;

import com.voxelv.glowstone_torch.GlowstoneTorch;
import com.voxelv.glowstone_torch.init.ItemInit;
import com.voxelv.glowstone_torch.util.IHasModel;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemArmor;

public class ArmorBase extends ItemArmor implements IHasModel {
    public ArmorBase(String name, ArmorMaterial materialIn, int renderIndexIn, EntityEquipmentSlot equipmentSlotIn) {
        super(materialIn, renderIndexIn, equipmentSlotIn);
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
