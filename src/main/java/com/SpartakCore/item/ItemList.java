package com.SpartakCore.item;

import com.SpartakCore.creativetab.ModTabList;
import com.SpartakCore.lib.Refstrings;
import com.SpartakCore.SpartakCore;
import eu.usrv.yamcore.items.ModItemManager;
import eu.usrv.yamcore.items.ModSimpleBaseItem;
import net.minecraft.item.ItemStack;

public enum ItemList {

	SchematicsTier1(new ModSimpleBaseItem("SchematicsTier1",ModTabList.ModSpaceTab)),
	
	// Do not delete this
    EndOfList(null);

    // ################################################################################
    public ModSimpleBaseItem Item;

    ItemList(ModSimpleBaseItem pItem)
    {
        Item = pItem;
        if (Item != null) {
            Item.setModIDName(Refstrings.MODID);
        }
    }

    public static boolean AddToItemManager(ModItemManager pItemManager)
    {
        boolean tResult = true;
        for (ItemList il : ItemList.values())
        {
            if (il.Item != null) {
                if (!pItemManager.AddItemToManagedRegistry(il.Item)) {
                    SpartakCore.Logger.error(String.format("Item [%s] failed to register", il.toString()));
                    tResult = false;
                }
            }
        }

        return tResult;
    }

    public ItemStack getIS()
    {
        return new ItemStack(Item.getConstructedItem(), 1);
    }
    
    public ItemStack getIS(int amount)
    {
        return new ItemStack(Item.getConstructedItem(), amount);
    }

}
