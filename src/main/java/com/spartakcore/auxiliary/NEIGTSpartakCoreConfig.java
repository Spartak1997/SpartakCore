package com.spartakcore.auxiliary;

import codechicken.nei.api.API;
import codechicken.nei.api.IConfigureNEI;
import com.spartakcore.lib.Refstrings;
import com.spartakcore.spartakcore;
import net.minecraft.item.ItemStack;

public class NEIGTSpartakCoreConfig implements IConfigureNEI
{
	@Override
    public void loadConfig()
    {
        // Hide metaID 0, as this is the generic item for trash bags
        spartakcore.Logger.info("Added NEI Config");
    }

    @Override
    public String getName()
    {
        return "GTSpartakCore-NEIConfig";
    }

    @Override
    public String getVersion()
    {
        return Refstrings.VERSION;
    }

}
