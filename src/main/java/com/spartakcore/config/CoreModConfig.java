package com.spartakcore.config;

import eu.usrv.yamcore.config.ConfigManager;

import java.io.File;


public class CoreModConfig extends ConfigManager{
	
	public CoreModConfig( File pConfigBaseDirectory, String pModCollectionDirectory, String pModID )
	  {
	    super( pConfigBaseDirectory, pModCollectionDirectory, pModID );

	  }
	
	public boolean OreDictItems_Enabled;
	
	public boolean ModCustomToolTips_Enabled;
	public boolean ModAdminErrorLogs_Enabled;
	public boolean ModItemInHandInfo_Enabled;
	
	@Override
	  protected void PreInit()
	  {
		ModCustomToolTips_Enabled = false;
		ModAdminErrorLogs_Enabled = true;
		ModItemInHandInfo_Enabled = false;
		OreDictItems_Enabled = true;

	  }

	@Override
	  protected void Init()
	  {
		ModCustomToolTips_Enabled = _mainConfig.getBoolean( "CustomToolTips", "Modules", ModCustomToolTips_Enabled, "Set to true to enable CustomToolTips module. This needs a separate config file which is created once you start with this setting enabled" );
		OreDictItems_Enabled = _mainConfig.getBoolean( "OreDictItems", "Modules", OreDictItems_Enabled, "Set to false to prevent the OreDict register for SpaceStones and SpaceDusts");
		ModItemInHandInfo_Enabled = _mainConfig.getBoolean( "ItemInHandInfo", "Modules", ModItemInHandInfo_Enabled, "Set to true to enable ItemInHandInfo module. If enabled, type /iih to display the item's name-info" );
		ModAdminErrorLogs_Enabled = _mainConfig.getBoolean( "AdminErrorLog", "Modules", ModAdminErrorLogs_Enabled, "If set to true, every op/admin will receive all errors occoured during the startup phase as ingame message on join" );
	  }
	
	@Override
	  protected void PostInit()
	  {

	  }
}
