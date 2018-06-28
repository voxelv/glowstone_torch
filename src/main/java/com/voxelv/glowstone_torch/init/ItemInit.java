package com.voxelv.glowstone_torch.init;

import com.voxelv.glowstone_torch.objects.armor.ArmorBase;
import com.voxelv.glowstone_torch.objects.items.ItemBase;
import com.voxelv.glowstone_torch.objects.tools.*;
import com.voxelv.glowstone_torch.util.Reference;
import net.minecraft.init.SoundEvents;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraftforge.common.util.EnumHelper;

import java.util.ArrayList;
import java.util.List;

public class ItemInit {
    public static final List<Item> ITEMS = new ArrayList<Item>();

    // Materials
    public static final Item.ToolMaterial TOOL_GLOWSTONE_SOLIDIFIED = EnumHelper.addToolMaterial("tool_glowstone_solidified", 2, 384, 5.0f, 2.8f, 5 );
    public static final ItemArmor.ArmorMaterial ARMOR_GLOWSTONE_SOLIDIFIED = EnumHelper.addArmorMaterial(
            "armor_glowstone_solidified",
            Reference.MODID + ":glowstone_solidified",
            24,
            new int[]{3, 8, 6, 3},
            12,
            SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND,
            0.0F
            );

    // Items
    public static final Item DUST_GLOWSTONE_TINY = new ItemBase("dust_glowstone_tiny");

    // Tools
    public static final Item AXE_GLOWSTONE_SOLIDIFIED       = new ToolAxe("axe_glowstone_solidified", TOOL_GLOWSTONE_SOLIDIFIED);
    public static final Item HOE_GLOWSTONE_SOLIDIFIED       = new ToolHoe("hoe_glowstone_solidified", TOOL_GLOWSTONE_SOLIDIFIED);
    public static final Item PICKAXE_GLOWSTONE_SOLIDIFIED   = new ToolPickaxe("pickaxe_glowstone_solidified", TOOL_GLOWSTONE_SOLIDIFIED);
    public static final Item SHOVEL_GLOWSTONE_SOLIDIFIED    = new ToolShovel("shovel_glowstone_solidified", TOOL_GLOWSTONE_SOLIDIFIED);
    public static final Item SWORD_GLOWSTONE_SOLIDIFIED     = new ToolSword("sword_glowstone_solidified", TOOL_GLOWSTONE_SOLIDIFIED);

    // Armor
    public static final Item HELMET_GLOWSTONE_SOLIDIFIED        = new ArmorBase("helmet_glowstone_solidified", ARMOR_GLOWSTONE_SOLIDIFIED, 1, EntityEquipmentSlot.HEAD);
    public static final Item CHESTPLATE_GLOWSTONE_SOLIDIFIED    = new ArmorBase("chestplate_glowstone_solidified", ARMOR_GLOWSTONE_SOLIDIFIED, 1, EntityEquipmentSlot.CHEST);
    public static final Item LEGGINGS_GLOWSTONE_SOLIDIFIED      = new ArmorBase("leggings_glowstone_solidified", ARMOR_GLOWSTONE_SOLIDIFIED, 2, EntityEquipmentSlot.LEGS);
    public static final Item BOOTS_GLOWSTONE_SOLIDIFIED         = new ArmorBase("boots_glowstone_solidified", ARMOR_GLOWSTONE_SOLIDIFIED, 1, EntityEquipmentSlot.FEET);
}
