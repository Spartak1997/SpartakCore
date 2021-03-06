package com.spartakcore.gthandler;

import gregtech.api.interfaces.IItemContainer;
import gregtech.api.util.GT_ModHandler;
import gregtech.api.util.GT_OreDictUnificator;
import gregtech.api.util.GT_Utility;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

import static gregtech.api.enums.GT_Values.W;

public enum CustomItemList implements IItemContainer {

	//Machines
	Hatch_Input_UEV, Hatch_Input_UIV, Hatch_Input_UMV, Hatch_Input_UXV, Hatch_Input_OPV,Hatch_Input_MAX,
	Hatch_Output_UEV, Hatch_Output_UIV, Hatch_Output_UMV, Hatch_Output_UXV, Hatch_Output_OPV,Hatch_Output_MAX,
	Bus_Input_UEV, Bus_Input_UIV, Bus_Input_UMV, Bus_Input_UXV, Bus_Input_OPV,Bus_Input_MAX,
	Bus_Output_UEV, Bus_Output_UIV, Bus_Output_UMV, Bus_Output_UXV, Bus_Output_OPV,Bus_Output_MAX, Bus_Output_Prim, Bus_Input_Prim,Hatch_Output_Prim,
	
	Machine_ULV_ComponentAssembler, Machine_LV_ComponentAssembler, Machine_MV_ComponentAssembler, Machine_HV_ComponentAssembler, Machine_EV_ComponentAssembler, Machine_IV_ComponentAssembler, Machine_LuV_ComponentAssembler, Machine_ZPM_ComponentAssembler, Machine_UV_ComponentAssembler, Machine_UHV_ComponentAssembler, Machine_UEV_ComponentAssembler, Machine_UIV_ComponentAssembler, Machine_UMV_ComponentAssembler, Machine_UXV_ComponentAssembler, Machine_OpV_ComponentAssembler,

	DustWasherULV, DustWasherLV, 	DustWasherMV, 	DustWasherHV, 	DustWasherEV, 	DustWasherIV, 	DustWasherLuV , 	DustWasherZPM, 	DustWasherUV, 	DustWasherUHV, 	DustWasherUEV,

	Generator_Steam_Turbine_ULV, Generator_Diesel_ULV, Generator_Gas_Turbine_ULV, Machine_ULV_Assembler, Machine_ULV_CircuitAssembler, Generator_Semi_Turbine_ULV, Generator_Semi_Turbine_LV, Generator_Semi_Turbine_MV, Generator_Semi_Turbine_HV, Water_Tank,
	
	//Casings
	Casing_Farm,
	
	//Multimachines
	Machine_Multi_Farm, Machine_CokeOven,
	
	//Schematics
	SchematicsTier1, SchematicsTier2, SchematicsTier3, SchematicsTier4, SchematicsTier5, SchematicsTier6, SchematicsTier7, SchematicsTier8,SchematicsAstroMiner,SchematicsCargoRocket,SchematicsMoonBuggy,
	
	//Plates
	HeavyDutyPlateTier4,HeavyDutyPlateTier5,HeavyDutyPlateTier6,HeavyDutyPlateTier7,HeavyDutyPlateTier8,
	
	//Ingots
	HeavyDutyAlloyIngotT4,HeavyDutyAlloyIngotT5,HeavyDutyAlloyIngotT6,HeavyDutyAlloyIngotT7,HeavyDutyAlloyIngotT8,
	
	//Components
	HeavyDutyNoseConeTier4,HeavyDutyNoseConeTier5,HeavyDutyNoseConeTier6,HeavyDutyNoseConeTier7,HeavyDutyNoseConeTier8,
	HeavyDutyRocketEngineTier4,HeavyDutyRocketEngineTier5,HeavyDutyRocketEngineTier6,HeavyDutyRocketEngineTier7,HeavyDutyRocketEngineTier8,
	HeavyDutyRocketFinsTier4,HeavyDutyRocketFinsTier5,HeavyDutyRocketFinsTier6,HeavyDutyRocketFinsTier7,HeavyDutyRocketFinsTier8,
	Tier4Booster,Tier5Booster,Tier6Booster,Tier7Booster,Tier8Booster,
	IridiumAlloyItemCasing,
	ULVMotor, ULVPiston, ULVRobotArm, ULVConveyorModule, ULVPump,
	PistonBlock, PistonPlate,
	SteelBars,
	Empty180SpCell, Empty360SpCell, Empty540SpCell, Empty1080SpCell,
	
	//Crystal
	QuantumCrystal,
	
	//Lens
	RefinedReinforcedGlassLense, ChargedGlassLense, HugeRefinedReinforcedGlassLense, HugeChargedGlassLense,
	
	//Armor
	QuantumPartBoots, QuantumPartChestplate, QuantumPartHelmetEmpty, QuantumPartHelmet, QuantumPartLeggings,
	
	//Dusts
	TCetiESeaweedExtract, DustSmallFertilizer, DustTinyFertilizer,

	//SpaceDusts
	AsteroidsStoneDust, BarnardaEStoneDust, BarnardaFStoneDust, CallistoIceDust, CallistoStoneDust, CentauriASurfaceDust,
	CentauriAStoneDust, CeresStoneDust, DeimosStoneDust, EnceladusIceDust, EnceladusStoneDust, EuropaIceDust, EuropaStoneDust,
	GanymedStoneDust, IoStoneDust, HaumeaStoneDust, MarsStoneDust, MakeMakeStoneDust, MercuryStoneDust,
	MirandaStoneDust, MoonStoneDust, PhobosStoneDust, PlutoIceDust, PlutoStoneDust, ProteusStoneDust, OberonStoneDust,
	TCetiEStoneDust, TitanStoneDust, TritonStoneDust, VegaBStoneDust, VenusStoneDust,

	OakScheme, DarkOakScheme, JungleScheme, AcaciaScheme, SpruceScheme, BirchScheme, RubberScheme,

    CokeOvenBrick,BlockCokeCoal

	;
	private ItemStack mStack;
	private boolean mHasNotBeenSet = true;

	//public static Fluid sOilExtraHeavy, sOilHeavy, sOilMedium, sOilLight, sNaturalGas;

	@Override
	public IItemContainer set(Item aItem) {
		mHasNotBeenSet = false;
		if (aItem == null) {
            return this;
        }
		ItemStack aStack = new ItemStack(aItem, 1, 0);
		mStack = GT_Utility.copyAmount(1, aStack);
		return this;
	}

	@Override
	public IItemContainer set(ItemStack aStack) {
		mHasNotBeenSet = false;
		mStack = GT_Utility.copyAmount(1, aStack);
		return this;
	}

	@Override
	public Item getItem() {
		if (mHasNotBeenSet) {
            throw new IllegalAccessError("The Enum '" + name() + "' has not been set to an Item at this time!");
        }
		if (GT_Utility.isStackInvalid(mStack)) {
            return null;
        }
		return mStack.getItem();
	}

	@Override
	public Block getBlock() {
		if (mHasNotBeenSet) {
            throw new IllegalAccessError("The Enum '" + name() + "' has not been set to an Item at this time!");
        }
		return GT_Utility.getBlockFromItem(getItem());
	}

	@Override
	public final boolean hasBeenSet() {
		return !mHasNotBeenSet;
	}

	@Override
	public boolean isStackEqual(Object aStack) {
		return isStackEqual(aStack, false, false);
	}

	@Override
	public boolean isStackEqual(Object aStack, boolean aWildcard, boolean aIgnoreNBT) {
		return !GT_Utility.isStackInvalid(aStack) && GT_Utility.areUnificationsEqual((ItemStack) aStack, aWildcard ? getWildcard(1) : get(1), aIgnoreNBT);
	}

	@Override
	public ItemStack get(long aAmount, Object... aReplacements) {
		if (mHasNotBeenSet) {
            throw new IllegalAccessError("The Enum '" + name() + "' has not been set to an Item at this time!");
        }
		if (GT_Utility.isStackInvalid(mStack)) {
            return GT_Utility.copyAmount(aAmount, aReplacements);
        }
		return GT_Utility.copyAmount(aAmount, GT_OreDictUnificator.get(mStack));
	}

	@Override
	public ItemStack getWildcard(long aAmount, Object... aReplacements) {
		if (mHasNotBeenSet) {
            throw new IllegalAccessError("The Enum '" + name() + "' has not been set to an Item at this time!");
        }
		if (GT_Utility.isStackInvalid(mStack)) {
            return GT_Utility.copyAmount(aAmount, aReplacements);
        }
		return GT_Utility.copyAmountAndMetaData(aAmount, W, GT_OreDictUnificator.get(mStack));
	}

	@Override
	public ItemStack getUndamaged(long aAmount, Object... aReplacements) {
		if (mHasNotBeenSet) {
            throw new IllegalAccessError("The Enum '" + name() + "' has not been set to an Item at this time!");
        }
		if (GT_Utility.isStackInvalid(mStack)) {
            return GT_Utility.copyAmount(aAmount, aReplacements);
        }
		return GT_Utility.copyAmountAndMetaData(aAmount, 0, GT_OreDictUnificator.get(mStack));
	}

	@Override
	public ItemStack getAlmostBroken(long aAmount, Object... aReplacements) {
		if (mHasNotBeenSet) {
            throw new IllegalAccessError("The Enum '" + name() + "' has not been set to an Item at this time!");
        }
		if (GT_Utility.isStackInvalid(mStack)) {
            return GT_Utility.copyAmount(aAmount, aReplacements);
        }
		return GT_Utility.copyAmountAndMetaData(aAmount, mStack.getMaxDamage() - 1, GT_OreDictUnificator.get(mStack));
	}

	@Override
	public ItemStack getWithName(long aAmount, String aDisplayName, Object... aReplacements) {
		ItemStack rStack = get(1, aReplacements);
		if (GT_Utility.isStackInvalid(rStack)) {
            return null;
        }
		rStack.setStackDisplayName(aDisplayName);
		return GT_Utility.copyAmount(aAmount, rStack);
	}

	@Override
	public ItemStack getWithCharge(long aAmount, int aEnergy, Object... aReplacements) {
		ItemStack rStack = get(1, aReplacements);
		if (GT_Utility.isStackInvalid(rStack)) {
            return null;
        }
		GT_ModHandler.chargeElectricItem(rStack, aEnergy, Integer.MAX_VALUE, true, false);
		return GT_Utility.copyAmount(aAmount, rStack);
	}

	@Override
	public ItemStack getWithDamage(long aAmount, long aMetaValue, Object... aReplacements) {
		if (mHasNotBeenSet) {
            throw new IllegalAccessError("The Enum '" + name() + "' has not been set to an Item at this time!");
        }
		if (GT_Utility.isStackInvalid(mStack)) {
            return GT_Utility.copyAmount(aAmount, aReplacements);
        }
		return GT_Utility.copyAmountAndMetaData(aAmount, aMetaValue, GT_OreDictUnificator.get(mStack));
	}

	@Override
	public IItemContainer registerOre(Object... aOreNames) {
		if (mHasNotBeenSet) {
            throw new IllegalAccessError("The Enum '" + name() + "' has not been set to an Item at this time!");
        }
		for (Object tOreName : aOreNames) {
            GT_OreDictUnificator.registerOre(tOreName, get(1));
        }
		return this;
	}

	@Override
	public IItemContainer registerWildcardAsOre(Object... aOreNames) {
		if (mHasNotBeenSet) {
            throw new IllegalAccessError("The Enum '" + name() + "' has not been set to an Item at this time!");
        }
		for (Object tOreName : aOreNames) {
            GT_OreDictUnificator.registerOre(tOreName, getWildcard(1));
        }
		return this;
	}
}
