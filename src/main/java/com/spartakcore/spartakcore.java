package com.spartakcore;

import com.spartakcore.bartworksHandler.BacteriaRegistry;
import com.spartakcore.block.BlockList;
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
import com.spartakcore.modctt.CustomToolTipsHandler;
import com.spartakcore.network.CoreModDispatcher;
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
        version = Refstrings.VERSION,
        dependencies = 
        	"required-after:Forge@[10.13.2.1291,);"
        +	"required-after:YAMCore@[0.5.76,);")

public class spartakcore {
	
	@SidedProxy(clientSide = Refstrings.CLIENTSIDE, serverSide = Refstrings.SERVERSIDE)
    public static CommonProxy proxy;
	
	@Mod.Instance(Refstrings.MODID)
    public static spartakcore instance;
	
	public static ModItemManager ItemManager;
	public static CreativeTabsManager TabManager;
	public static ModFluidManager FluidManager;
	public static ModBlockManager BlockManager;
	public static CustomToolTipsHandler Module_CustomToolTips;
	public static IngameErrorLog Module_AdminErrorLogs;
	public static GT_CustomLoader GTCustomLoader;
	public static CoreModConfig CoreConfig;
	public static CoreModDispatcher NW;
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
        
        proxy.addTexturePage();
        // ------------------------------------------------------------
        
        // ------------------------------------------------------------
        Logger.debug("PRELOAD Init NetworkChannel");
        NW = new CoreModDispatcher();
        NW.registerPackets();
        // ------------------------------------------------------------
        
        // ------------------------------------------------------------
        Logger.debug("PRELOAD Init itemmanager");
        ItemManager = new ModItemManager(Refstrings.MODID);
        BlockManager = new ModBlockManager(Refstrings.MODID);
        
     // ------------------------------------------------------------
        Logger.debug("PRELOAD Init Tabmanager");
        TabManager = new CreativeTabsManager();
        ModTabList.InitModTabs(TabManager, ItemManager);
        
      //Materials init
        if (!GT_Mod.gregtechproxy.mEnableAllMaterials) {
            new GT_CoreModSupport();
        }
        
     // ------------------------------------------------------------
        Logger.debug("PRELOAD Create Items");
        if (!ItemList.AddToItemManager(ItemManager))
        {
            Logger.warn("Some items failed to register. Check the logfile for details");
            AddLoginError("[SpartakCoreMod-Items] Some items failed to register. Check the logfile for details");
        }
     // ------------------------------------------------------------

     // ------------------------------------------------------------
        Logger.info("PRELOAD Create Blocks");
        if (!BlockList.AddToItemManager(BlockManager))
        {
            Logger.warn("Some blocks failed to register. Check the logfile for details");
            AddLoginError("[CoreMod-Blocks] Some blocks failed to register. Check the logfile for details");
        }
     // ------------------------------------------------------------

        
     // ------------------------------------------------------------
        // Init Modules
        Logger.debug("PRELOAD Init Modules");

        if (CoreConfig.ModCustomToolTips_Enabled)
        {
            //Logger.debug("Module_HazardousItems is enabled");
            Module_CustomToolTips = new CustomToolTipsHandler();
            // Module_CustomToolTips.LoadConfig();
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
        
        Logger.debug("LOAD Register Blocks");
        BlockManager.RegisterItems(TabManager);
        
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
		// register events in modules
        RegisterModuleEvents();
        
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
		
		if (CoreConfig.ModCustomToolTips_Enabled)
        {
            MinecraftForge.EVENT_BUS.register(Module_CustomToolTips);
            FMLCommonHandler.instance().bus().register(Module_CustomToolTips);
        }
    }
	@Mod.EventHandler
    public void PostLoad(FMLPostInitializationEvent PostEvent)
    {
		
		if (CoreConfig.ModCustomToolTips_Enabled) {
            Module_CustomToolTips.LoadConfig();
        }
		
		GTCustomLoader = new GT_CustomLoader();
        GTCustomLoader.run();
        
        if (Loader.isModLoaded("bartworks")) {
            BacteriaRegistry.runAllPostinit();
	    }
    }
	
	@Mod.EventHandler
    public void serverLoad(FMLServerStartingEvent pEvent)
    {
		if (CoreConfig.ModCustomToolTips_Enabled) {
            pEvent.registerServerCommand(new CustomToolTipsCommand());
        }
		
		if (CoreConfig.ModItemInHandInfo_Enabled) {
            pEvent.registerServerCommand(new ItemInHandInfoCommand());
        }
		
    }
}
