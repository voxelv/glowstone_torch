package com.voxelv.glowstone_torch;

import com.voxelv.glowstone_torch.proxy.CommonProxy;
import net.minecraftforge.common.config.Configuration;
import org.apache.logging.log4j.Level;

public class GlowstoneTorchConfig {
    public static final String CATEGORY_GENERAL = "general";

    public static String cfg_version = "0.0";

    public static void readConfig() {
        Configuration cfg = CommonProxy.config;
        try{
            cfg.load();
            initGeneralConfig(cfg);
        }
        catch (Exception e1)
        {
            GlowstoneTorch.logger.log(Level.ERROR, "Problem loading config file!", e1);
        }
        finally {
            if(cfg.hasChanged()) {
                cfg.save();
            }
        }
    }

    public static void initGeneralConfig(Configuration cfg) {
        cfg.addCustomCategoryComment(CATEGORY_GENERAL, "General Configuration");
        cfg_version = cfg.getString("cfg_version", CATEGORY_GENERAL, cfg_version,"Do not manually change this.");
    }
}
