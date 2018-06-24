package com.voxelv.glowstone_torch;

import com.voxelv.glowstone_torch.proxy.CommonProxy;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import org.apache.logging.log4j.Logger;

@Mod(modid = com.voxelv.glowstone_torch.GlowstoneTorch.MODID,
        name = com.voxelv.glowstone_torch.GlowstoneTorch.MODNAME,
        version = com.voxelv.glowstone_torch.GlowstoneTorch.VERSION,
        dependencies =
                "after:Forge@[14.22.0.2464,)", useMetadata = true)
public class GlowstoneTorch {

    public static final String MODID = "glowstone_torch";
    public static final String MODNAME = "Glowstone Torch";
    public static final String VERSION = "0.0";

    @SidedProxy(clientSide = "com.voxelv.glowstone_torch.proxy.ClientProxy", serverSide = "com.voxelv.glowstone_torch.proxy.ServerProxy")
    public static CommonProxy proxy;

    @Mod.Instance
    public static com.voxelv.glowstone_torch.GlowstoneTorch instance;

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