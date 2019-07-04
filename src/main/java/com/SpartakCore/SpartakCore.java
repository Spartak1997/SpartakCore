package com.SpartakCore;

import com.SpartakCore.config.CoreModConfig;
import com.SpartakCore.creativetab.ModTabList;
import com.SpartakCore.galacticgreg.SpaceDimRegisterer;
import com.SpartakCore.gthandler.GT_CustomLoader;
import com.SpartakCore.item.ItemList;
import com.SpartakCore.lib.Refstrings;
import com.SpartakCore.main.CommonProxy;

import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.Loader;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.*;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import eu.usrv.yamcore.YAMCore;
import eu.usrv.yamcore.auxiliary.IngameErrorLog;
import eu.usrv.yamcore.auxiliary.LogHelper;
import eu.usrv.yamcore.blocks.ModBlockManager;
import eu.usrv.yamcore.client.NotificationTickHandler;
import eu.usrv.yamcore.creativetabs.CreativeTabsManager;
import eu.usrv.yamcore.fluids.ModFluidManager;
import eu.usrv.yamcore.items.ModItemManager;
import gregtech.api.GregTech_API;
import gregtech.GT_Mod;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.common.MinecraftForge;

import static gregtech.api.enums.Dyes.*;

import java.io.*;
import java.util.Random;

@Mod (
		modid = Refstrings.MODID,
		name = Refstrings.NAME,
		version = "0.1")

public class SpartakCore {
	
	@SidedProxy(clientSide = Refstrings.CLIENTSIDE, serverSide = Refstrings.SERVERSIDE)
    public static CommonProxy proxy;
	
	@Mod.Instance(Refstrings.MODID)
    public static SpartakCore instance;
	
	public static ModItemManager ItemManager;
	public static CreativeTabsManager TabManager;
	public static GT_CustomLoader GTCustomLoader;
	public static CoreModConfig CoreConfig;
	public static IngameErrorLog Module_AdminErrorLogs;
	public static Random Rnd;
	public static LogHelper Logger = new LogHelper(Refstrings.MODID);
	private static SpaceDimRegisterer SpaceDimReg;
	
	public static void AddLoginError(String pMessage)
    {
		if (Module_AdminErrorLogs != null) {
            Module_AdminErrorLogs.AddErrorLogOnAdminJoin(pMessage);
        }
    }
	
	@Mod.EventHandler
    public void PreLoad(FMLPreInitializationEvent PreEvent)
    {
		Logger.setDebugOutput(true);

	    Rnd = new Random(System.currentTimeMillis());
	    
	 // ------------------------------------------------------------
        // Init coremod config file. Create it if it's not there
        CoreConfig = new CoreModConfig(PreEvent.getModConfigurationDirectory(), Refstrings.COLLECTIONID, Refstrings.MODID);
        if (!CoreConfig.LoadConfig()) {
            Logger.error(String.format("%s could not load its config file. Things are going to be weird!", Refstrings.MODID));
        }
        // ------------------------------------------------------------

        if (CoreConfig.ModAdminErrorLogs_Enabled)
        {
            Logger.debug("Module_AdminErrorLogs is enabled");
            Module_AdminErrorLogs = new IngameErrorLog();
        }
        
        proxy.addTexturePage();
        
     // ------------------------------------------------------------
        Logger.debug("PRELOAD Init itemmanager");
        ItemManager = new ModItemManager(Refstrings.MODID);
        
     // ------------------------------------------------------------
        Logger.debug("PRELOAD Init Tabmanager");
        TabManager = new CreativeTabsManager();
        ModTabList.InitModTabs(TabManager, ItemManager);
        
     // ------------------------------------------------------------
        Logger.debug("PRELOAD Create Items");
        if (!ItemList.AddToItemManager(ItemManager))
        {
            Logger.warn("Some items failed to register. Check the logfile for details");
            AddLoginError("[SpartakCoreMod-Items] Some items failed to register. Check the logfile for details");
        }
        
     // register final list with valid items to forge
        Logger.debug("LOAD Register Items");
        ItemManager.RegisterItems(TabManager);
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

	private void RegisterModuleEvents()
    {
		if (CoreConfig.ModAdminErrorLogs_Enabled) {
            FMLCommonHandler.instance().bus().register(Module_AdminErrorLogs);
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
