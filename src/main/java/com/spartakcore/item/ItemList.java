package com.spartakcore.item;

import com.spartakcore.creativetab.ModTabList;
import com.spartakcore.lib.Refstrings;
import com.spartakcore.spartakcore;
import eu.usrv.yamcore.items.ModItemManager;
import eu.usrv.yamcore.items.ModSimpleBaseItem;
import net.minecraft.item.ItemStack;

public enum ItemList {


	TCetiESeaweedExtract(new ModSimpleBaseItem("TCetiESeaweedExtract",ModTabList.ModSpaceTab)),
	IridiumAlloyItemCasing(new ModSimpleBaseItem("IridiumAlloyItemCasing",ModTabList.ModBarsAndCasingsTab)),
	(new ModSimpleBaseItem("RefinedReinforcedGlassLense",ModTabList.ModGenericTab)),
	(new ModSimpleBaseItem("ChargedGlassLense",ModTabList.ModGenericTab)),
	(new ModSimpleBaseItem("HugeRefinedReinforcedGlassLense",ModTabList.ModGenericTab)),
	(new ModSimpleBaseItem("HugeChargedGlassLense",ModTabList.ModGenericTab)),
	PistonPlate(new ModSimpleBaseItem("PistonPlate",ModTabList.ModGenericTab)),
	SteelBars(new ModSimpleBaseItem("SteelBars",ModTabList.ModBarsAndCasingsTab)),
	(new ModSimpleBaseItem("DustSmallFertilizer",ModTabList.ModGenericTab)),
	new ModSimpleBaseItem("DustTinyFertilizer",ModTabList.ModGenericTab)),
	Empty180SpCell(new ModSimpleBaseItem("Empty180SpCell", ModTabList.ModGenericTab)),
    Empty360SpCell(new ModSimpleBaseItem("Empty360SpCell", ModTabList.ModGenericTab)),
    Empty540SpCell(new ModSimpleBaseItem("Empty540SpCell", ModTabList.ModGenericTab)),
    Empty1080SpCell(new ModSimpleBaseItem("Empty1080SpCell", ModTabList.ModGenericTab)),

	//SpaceDust
	//AsteroidsStoneDust(new ModSimpleBaseItem("AsteroidsStoneDust", ModTabList.ModGenericTab)),
	BarnardaEStoneDust(new ModSimpleBaseItem("BarnardaEStoneDust", ModTabList.ModSpaceTab)),
	BarnardaFStoneDust(new ModSimpleBaseItem("BarnardaFStoneDust", ModTabList.ModSpaceTab)),
	CallistoIceDust(new ModSimpleBaseItem("CallistoIceDust", ModTabList.ModSpaceTab)),
	CallistoStoneDust(new ModSimpleBaseItem("CallistoStoneDust", ModTabList.ModSpaceTab)),
	CentauriASurfaceDust(new ModSimpleBaseItem("CentauriASurfaceDust", ModTabList.ModSpaceTab)),
	CentauriAStoneDust(new ModSimpleBaseItem("CentauriAStoneDust", ModTabList.ModSpaceTab)),
	CeresStoneDust(new ModSimpleBaseItem("CeresStoneDust", ModTabList.ModSpaceTab)),
	DeimosStoneDust(new ModSimpleBaseItem("DeimosStoneDust", ModTabList.ModSpaceTab)),
	EnceladusIceDust(new ModSimpleBaseItem("EnceladusIceDust", ModTabList.ModSpaceTab)),
	EnceladusStoneDust(new ModSimpleBaseItem("EnceladusStoneDust", ModTabList.ModSpaceTab)),
	EuropaIceDust(new ModSimpleBaseItem("EuropaIceDust", ModTabList.ModSpaceTab)),
	EuropaStoneDust(new ModSimpleBaseItem("EuropaStoneDust", ModTabList.ModSpaceTab)),
	GanymedStoneDust(new ModSimpleBaseItem("GanymedStoneDust", ModTabList.ModSpaceTab)),
	IoStoneDust(new ModSimpleBaseItem("IoStoneDust", ModTabList.ModSpaceTab)),
	HaumeaStoneDust(new ModSimpleBaseItem("HaumeaStoneDust", ModTabList.ModSpaceTab)),
	//MarsStoneDust(new ModSimpleBaseItem("MarsStoneDust", ModTabList.ModSpaceTab)),
	MakeMakeStoneDust(new ModSimpleBaseItem("MakeMakeStoneDust", ModTabList.ModSpaceTab)),
	MercuryStoneDust(new ModSimpleBaseItem("MercuryStoneDust", ModTabList.ModSpaceTab)),
	MirandaStoneDust(new ModSimpleBaseItem("MirandaStoneDust", ModTabList.ModSpaceTab)),
	//MoonStoneDust(new ModSimpleBaseItem("MoonStoneDust", ModTabList.ModGenericTab)),
	PhobosStoneDust(new ModSimpleBaseItem("PhobosStoneDust", ModTabList.ModSpaceTab)),
	PlutoIceDust(new ModSimpleBaseItem("PlutoIceDust", ModTabList.ModSpaceTab)),
	PlutoStoneDust(new ModSimpleBaseItem("PlutoStoneDust", ModTabList.ModSpaceTab)),
	ProteusStoneDust(new ModSimpleBaseItem("ProteusStoneDust", ModTabList.ModSpaceTab)),
	OberonStoneDust(new ModSimpleBaseItem("OberonStoneDust", ModTabList.ModSpaceTab)),
	TCetiEStoneDust(new ModSimpleBaseItem("TCetiEStoneDust", ModTabList.ModSpaceTab)),
	TitanStoneDust(new ModSimpleBaseItem("TitanStoneDust", ModTabList.ModSpaceTab)),
	TritonStoneDust(new ModSimpleBaseItem("TritonStoneDust", ModTabList.ModSpaceTab)),
	VegaBStoneDust(new ModSimpleBaseItem("VegaBStoneDust", ModTabList.ModSpaceTab)),
	VenusStoneDust(new ModSimpleBaseItem("VenusStoneDust", ModTabList.ModSpaceTab)),

	OakScheme		(new ModSimpleBaseItem("OakScheme", ModTabList.ModGenericTab)),
	DarkOakScheme	(new ModSimpleBaseItem("DarkOakScheme", ModTabList.ModGenericTab)),
	JungleScheme	(new ModSimpleBaseItem("JungleScheme", ModTabList.ModGenericTab)),
	AcaciaScheme	(new ModSimpleBaseItem("AcaciaScheme", ModTabList.ModGenericTab)),
	SpruceScheme	(new ModSimpleBaseItem("SpruceScheme", ModTabList.ModGenericTab)),
	BirchScheme		(new ModSimpleBaseItem("BirchScheme", ModTabList.ModGenericTab)),
	RubberScheme	(new ModSimpleBaseItem("RubberScheme", ModTabList.ModGenericTab)),

	
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
                    spartakcore.Logger.error(String.format("Item [%s] failed to register", il.toString()));
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
