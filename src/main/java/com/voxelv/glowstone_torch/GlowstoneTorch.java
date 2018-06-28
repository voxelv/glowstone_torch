package com.voxelv.glowstone_torch;

import com.voxelv.glowstone_torch.proxy.CommonProxy;
import com.voxelv.glowstone_torch.tabs.GlowstoneTorchTab;
import com.voxelv.glowstone_torch.util.Reference;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import org.apache.logging.log4j.Logger;

@Mod(modid = Reference.MODID,
        name = Reference.MODNAME,
        version = Reference.VERSION,
        dependencies =
                "after:Forge@[14.22.0.2464,)", useMetadata = true)
public class GlowstoneTorch {

    public static final CreativeTabs glowstone_torch_tab = new GlowstoneTorchTab();

    @SidedProxy(clientSide = "com.voxelv.glowstone_torch.proxy.ClientProxy", serverSide = "com.voxelv.glowstone_torch.proxy.ServerProxy")
    public static CommonProxy proxy;

    @Mod.Instance
    public static GlowstoneTorch instance;

    public static Logger logger;

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        logger = event.getModLog();
        proxy.preInit(event);
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent e) {
        proxy.init(e);
    }

    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent e) {
        proxy.postInit(e);
    }
}