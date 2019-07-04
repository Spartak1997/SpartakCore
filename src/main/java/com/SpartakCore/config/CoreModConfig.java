package com.SpartakCore.config;

import eu.usrv.yamcore.config.ConfigManager;

import java.io.File;


public class CoreModConfig extends ConfigManager{
	
	public CoreModConfig( File pConfigBaseDirectory, String pModCollectionDirectory, String pModID )
	  {
	    super( pConfigBaseDirectory, pModCollectionDirectory, pModID );

	  }
	
	public boolean ModAdminErrorLogs_Enabled;
	
	@Override
	  protected void PreInit()
	  {
		ModAdminErrorLogs_Enabled = true;
	  }

	@Override
	  protected void Init()
	  {
		ModAdminErrorLogs_Enabled = _mainConfig.getBoolean( "AdminErrorLog", "Modules", ModAdminErrorLogs_Enabled, "If set to true, every op/admin will receive all errors occoured during the startup phase as ingame message on join" );
	  }
	
	@Override
	  protected void PostInit()
	  {

	  }
}
