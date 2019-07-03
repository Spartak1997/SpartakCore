package com.SpartakCore;

import com.SpartakCore.galacticgreg.SpaceDimRegisterer;
import com.SpartakCore.gthandler.GT_CustomLoader;
import com.SpartakCore.lib.Refstrings;

import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.Loader;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.*;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;

import eu.usrv.yamcore.YAMCore;
import eu.usrv.yamcore.auxiliary.LogHelper;
import eu.usrv.yamcore.auxiliary.IngameErrorLog;
import gregtech.api.GregTech_API;
import gregtech.GT_Mod;

@Mod (
		modid = Refstrings.MODID,
		name = Refstrings.NAME,
		version = "0.1")
public class SpartakCore {
	
	@Mod.Instance(Refstrings.MODID)
    public static SpartakCore instance;
	
	public static GT_CustomLoader GTCustomLoader;
	public static IngameErrorLog Module_AdminErrorLogs;
	public static LogHelper Logger = new LogHelper(Refstrings.MODID);
	private static SpaceDimRegisterer SpaceDimReg;
	
	public static void AddLoginError(String pMessage)
    {
        if (Module_AdminErrorLogs != null) {
            Module_AdminErrorLogs.AddErrorLogOnAdminJoin(pMessage);
        }
    }
	
	@Mod.EventHandler
    public void load(FMLInitializationEvent event)
    {
        // Register Dimensions in GalacticGregGT5
		if (Loader.isModLoaded("galacticgreg"))
        {
            SpaceDimReg = new SpaceDimRegisterer();
            if (!SpaceDimReg.Init())
            {
                Logger.error("Unable to register SpaceDimensions; You are probably using the wrong Version of GalacticGreg");
                AddLoginError("[SpaceDim] Unable to register SpaceDimensions. Wrong Version of GGreg found!");
            }
            else
            {
                Logger.debug("Registering SpaceDimensions");
                SpaceDimReg.Register();
            }

        }
    }

	@Mod.EventHandler
    public void PostLoad(FMLPostInitializationEvent PostEvent)
    {
		GTCustomLoader = new GT_CustomLoader();
        GTCustomLoader.run();
    }
	
	@Mod.EventHandler
    public void serverLoad(FMLServerStartingEvent pEvent)
    {
		
    }
}
