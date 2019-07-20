package com.spartakcore;

import com.spartakcore.bartworksHandler.BacteriaRegistry;
import com.spartakcore.command.*;
import com.spartakcore.config.CoreModConfig;
import com.spartakcore.creativetab.ModTabList;
import com.spartakcore.fluids.FluidList;
import com.spartakcore.galacticgreg.SpaceDimRegisterer;
import com.spartakcore.gthandler.GT_CoreModSupport;
import com.spartakcore.gthandler.GT_CustomLoader;
import com.spartakcore.item.ItemList;
import com.spartakcore.lib.Refstrings;
import com.spartakcore.main.CommonProxy;
import com.spartakcore.oredict.OreDictHandler;

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
import gregtech.api.interfaces.ITexture;
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
		version = "0.2")

public class spartakcore {
	
	@SidedProxy(clientSide = Refstrings.CLIENTSIDE, serverSide = Refstrings.SERVERSIDE)
    public static CommonProxy proxy;
	
	@Mod.Instance(Refstrings.MODID)
    public static spartakcore instance;
	
	public static ModItemManager ItemManager;
	public static CreativeTabsManager TabManager;
	public static ModFluidManager FluidManager;
	public static GT_CustomLoader GTCustomLoader;
	public static CoreModConfig CoreConfig;
	public static IngameErrorLog Module_AdminErrorLogs;
	public static Random Rnd;
	public static LogHelper Logger = new LogHelper(Refstrings.MODID);
	private static SpaceDimRegisterer SpaceDimReg;
	private static BacteriaRegistry BacteriaRegistry;
	
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
        
     // ------------------------------------------------------------
        Logger.debug("PRELOAD Init TexturePage");
        File tFile = new File(new File(PreEvent.getModConfigurationDirectory(), "GregTech"), "GregTech.cfg");
        Configuration tMainConfig = new Configuration(tFile);
        tMainConfig.load();
        
        /*GregTech_API.sUseMachineMetal = tMainConfig.get("machines", "use_machine_metal_tint", true).getBoolean(true);
        if (GregTech_API.sUseMachineMetal)
            {
                // use default in GregTech Dyes enum.
            }
        else
            {
                // Override MACHINE_METAL dye color with white
                MACHINE_METAL.mRGBa[0]= 255;
                MACHINE_METAL.mRGBa[1]= 255;
                MACHINE_METAL.mRGBa[2]= 255;
            }*/

        proxy.addTexturePage();
     // ------------------------------------------------------------

     // ------------------------------------------------------------
        Logger.debug("PRELOAD Init itemmanager");
        ItemManager = new ModItemManager(Refstrings.MODID);
        
     // ------------------------------------------------------------
        Logger.debug("PRELOAD Init Tabmanager");
        TabManager = new CreativeTabsManager();
        ModTabList.InitModTabs(TabManager, ItemManager);
        
      //Materials init
        //if (!GT_Mod.gregtechproxy.mEnableAllMaterials) {
            new GT_CoreModSupport();
        //}
        
     // ------------------------------------------------------------
        Logger.debug("PRELOAD Create Items");
        if (!ItemList.AddToItemManager(ItemManager))
        {
            Logger.warn("Some items failed to register. Check the logfile for details");
            AddLoginError("[SpartakCoreMod-Items] Some items failed to register. Check the logfile for details");
        }
        
     // ------------------------------------------------------------
        Logger.debug("PRELOAD Create Fluids");
        FluidManager = new ModFluidManager(Refstrings.MODID);
        if (!FluidList.AddToItemManager(FluidManager))
        {
            Logger.warn("Some fluids failed to register. Check the logfile for details");
            AddLoginError("[CoreMod-Fluids] Some fluids failed to register. Check the logfile for details");
        }
        
     // register final list with valid items to forge
        Logger.debug("LOAD Register Items");
        ItemManager.RegisterItems(TabManager);
        
        Logger.debug("LOAD Register Fluids");
        FluidManager.RegisterItems(TabManager);
        
        if (Loader.isModLoaded("bartworks"))
        {
        BacteriaRegistry = new BacteriaRegistry();
        }
        
        
    }
	
	@Mod.EventHandler
    public void load(FMLInitializationEvent event)
    {
		// Register additional OreDictionary Names
        if(CoreConfig.OreDictItems_Enabled)
        OreDictHandler.register_all();
        
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
        
        BacteriaRegistry.runAllPostinit();
    }
	
	@Mod.EventHandler
    public void serverLoad(FMLServerStartingEvent pEvent)
    {
		if (CoreConfig.ModItemInHandInfo_Enabled) {
            pEvent.registerServerCommand(new ItemInHandInfoCommand());
        }
    }
}
