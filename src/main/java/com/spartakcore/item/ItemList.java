package com.spartakcore.item;

import com.spartakcore.creativetab.ModTabList;
import com.spartakcore.lib.Refstrings;
import com.spartakcore.spartakcore;
import eu.usrv.yamcore.items.ModItemManager;
import eu.usrv.yamcore.items.ModSimpleBaseItem;
import net.minecraft.item.ItemStack;

public enum ItemList {

	SchematicsTier1(new ModSimpleBaseItem("SchematicsTier1",ModTabList.ModSpaceTab)),
	SchematicsTier2(new ModSimpleBaseItem("SchematicsTier2",ModTabList.ModSpaceTab)),
	SchematicsTier3(new ModSimpleBaseItem("SchematicsTier3",ModTabList.ModSpaceTab)),
	SchematicsTier4(new ModSimpleBaseItem("SchematicsTier4",ModTabList.ModSpaceTab)),
	SchematicsTier5(new ModSimpleBaseItem("SchematicsTier5",ModTabList.ModSpaceTab)),
	SchematicsTier6(new ModSimpleBaseItem("SchematicsTier6",ModTabList.ModSpaceTab)),
	SchematicsTier7(new ModSimpleBaseItem("SchematicsTier7",ModTabList.ModSpaceTab)),
	SchematicsTier8(new ModSimpleBaseItem("SchematicsTier8",ModTabList.ModSpaceTab)),
	SchematicsAstroMiner(new ModSimpleBaseItem("SchematicsAstroMiner",ModTabList.ModSpaceTab)),
	SchematicsCargoRocket(new ModSimpleBaseItem("SchematicsCargoRocket",ModTabList.ModSpaceTab)),
	SchematicsMoonBuggy(new ModSimpleBaseItem("SchematicsMoonBuggy",ModTabList.ModSpaceTab)),
	HeavyDutyPlateTier4(new ModSimpleBaseItem("HeavyDutyPlateTier4",ModTabList.ModSpaceTab)),
	HeavyDutyPlateTier5(new ModSimpleBaseItem("HeavyDutyPlateTier5",ModTabList.ModSpaceTab)),
	HeavyDutyPlateTier6(new ModSimpleBaseItem("HeavyDutyPlateTier6",ModTabList.ModSpaceTab)),
	HeavyDutyPlateTier7(new ModSimpleBaseItem("HeavyDutyPlateTier7",ModTabList.ModSpaceTab)),
	HeavyDutyPlateTier8(new ModSimpleBaseItem("HeavyDutyPlateTier8",ModTabList.ModSpaceTab)),
	HeavyDutyAlloyIngotT4(new ModSimpleBaseItem("HeavyDutyAlloyIngotT4",ModTabList.ModSpaceTab)),
	HeavyDutyAlloyIngotT5(new ModSimpleBaseItem("HeavyDutyAlloyIngotT5",ModTabList.ModSpaceTab)),
	HeavyDutyAlloyIngotT6(new ModSimpleBaseItem("HeavyDutyAlloyIngotT6",ModTabList.ModSpaceTab)),
	HeavyDutyAlloyIngotT7(new ModSimpleBaseItem("HeavyDutyAlloyIngotT7",ModTabList.ModSpaceTab)),
	HeavyDutyAlloyIngotT8(new ModSimpleBaseItem("HeavyDutyAlloyIngotT8",ModTabList.ModSpaceTab)),
	HeavyDutyNoseConeTier4(new ModSimpleBaseItem("HeavyDutyNoseConeTier4",ModTabList.ModSpaceTab)),
	HeavyDutyNoseConeTier5(new ModSimpleBaseItem("HeavyDutyNoseConeTier5",ModTabList.ModSpaceTab)),
	HeavyDutyNoseConeTier6(new ModSimpleBaseItem("HeavyDutyNoseConeTier6",ModTabList.ModSpaceTab)),
	HeavyDutyNoseConeTier7(new ModSimpleBaseItem("HeavyDutyNoseConeTier7",ModTabList.ModSpaceTab)),
	HeavyDutyNoseConeTier8(new ModSimpleBaseItem("HeavyDutyNoseConeTier8",ModTabList.ModSpaceTab)),
	HeavyDutyRocketEngineTier4(new ModSimpleBaseItem("HeavyDutyRocketEngineTier4",ModTabList.ModSpaceTab)),
	HeavyDutyRocketEngineTier5(new ModSimpleBaseItem("HeavyDutyRocketEngineTier5",ModTabList.ModSpaceTab)),
	HeavyDutyRocketEngineTier6(new ModSimpleBaseItem("HeavyDutyRocketEngineTier6",ModTabList.ModSpaceTab)),
	HeavyDutyRocketEngineTier7(new ModSimpleBaseItem("HeavyDutyRocketEngineTier7",ModTabList.ModSpaceTab)),
	HeavyDutyRocketEngineTier8(new ModSimpleBaseItem("HeavyDutyRocketEngineTier8",ModTabList.ModSpaceTab)),
	HeavyDutyRocketFinsTier4(new ModSimpleBaseItem("HeavyDutyRocketFinsTier4",ModTabList.ModSpaceTab)),
	HeavyDutyRocketFinsTier5(new ModSimpleBaseItem("HeavyDutyRocketFinsTier5",ModTabList.ModSpaceTab)),
	HeavyDutyRocketFinsTier6(new ModSimpleBaseItem("HeavyDutyRocketFinsTier6",ModTabList.ModSpaceTab)),
	HeavyDutyRocketFinsTier7(new ModSimpleBaseItem("HeavyDutyRocketFinsTier7",ModTabList.ModSpaceTab)),
	HeavyDutyRocketFinsTier8(new ModSimpleBaseItem("HeavyDutyRocketFinsTier8",ModTabList.ModSpaceTab)),
	Tier4Booster(new ModSimpleBaseItem("Tier4Booster",ModTabList.ModSpaceTab)),
	Tier5Booster(new ModSimpleBaseItem("Tier5Booster",ModTabList.ModSpaceTab)),
	Tier6Booster(new ModSimpleBaseItem("Tier6Booster",ModTabList.ModSpaceTab)),
	Tier7Booster(new ModSimpleBaseItem("Tier7Booster",ModTabList.ModSpaceTab)),
	Tier8Booster(new ModSimpleBaseItem("Tier8Booster",ModTabList.ModSpaceTab)),
	TCetiESeaweedExtract(new ModSimpleBaseItem("TCetiESeaweedExtract",ModTabList.ModSpaceTab)),
	QuantumPartBoots(new ModSimpleBaseItem("QuantumPartBoots",ModTabList.ModGenericTab)),
	QuantumPartChestplate(new ModSimpleBaseItem("QuantumPartChestplate",ModTabList.ModGenericTab)),
	QuantumPartHelmetEmpty(new ModSimpleBaseItem("QuantumPartHelmetEmpty",ModTabList.ModGenericTab)),
	QuantumPartHelmet(new ModSimpleBaseItem("QuantumPartHelmet",ModTabList.ModGenericTab)),
	QuantumPartLeggings(new ModSimpleBaseItem("QuantumPartLeggings",ModTabList.ModGenericTab)),
	QuantumCrystal(new ModSimpleBaseItem("QuantumCrystal",ModTabList.ModGenericTab)),
	IridiumAlloyItemCasing(new ModSimpleBaseItem("IridiumAlloyItemCasing",ModTabList.ModBarsAndCasingsTab)),
	RefinedReinforcedGlassLense(new ModSimpleBaseItem("RefinedReinforcedGlassLense",ModTabList.ModGenericTab)),
	ChargedGlassLense(new ModSimpleBaseItem("ChargedGlassLense",ModTabList.ModGenericTab)),
	HugeRefinedReinforcedGlassLense(new ModSimpleBaseItem("HugeRefinedReinforcedGlassLense",ModTabList.ModGenericTab)),
	HugeChargedGlassLense(new ModSimpleBaseItem("HugeChargedGlassLense",ModTabList.ModGenericTab)),
	ULVMotor(new ModSimpleBaseItem("ULVMotor",ModTabList.ModGenericTab)),
	ULVPiston(new ModSimpleBaseItem("ULVPiston",ModTabList.ModGenericTab)),
	ULVRobotArm(new ModSimpleBaseItem("ULVRobotArm",ModTabList.ModGenericTab)),
	PistonPlate(new ModSimpleBaseItem("PistonPlate",ModTabList.ModGenericTab)),
	SteelBars(new ModSimpleBaseItem("SteelBars",ModTabList.ModBarsAndCasingsTab)),
	DustSmallFertilizer(new ModSimpleBaseItem("DustSmallFertilizer",ModTabList.ModGenericTab)),
	DustTinyFertilizer(new ModSimpleBaseItem("DustTinyFertilizer",ModTabList.ModGenericTab)),
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
