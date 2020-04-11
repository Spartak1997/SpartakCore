package com.spartakcore.gthandler;

import com.spartakcore.gthandler.tileentities.basic.GT_MetaTileEntity_WaterTank;
import com.spartakcore.gthandler.tileentities.generators.GT_MetaTileEntity_SemifluidGenerator;
import com.spartakcore.gthandler.tileentities.hatches.GT_MetaTileEntity_Primitive_Hatch_Output;
import com.spartakcore.gthandler.tileentities.hatches.GT_MetaTileEntity_Primitive_InputBus;
import com.spartakcore.gthandler.tileentities.hatches.GT_MetaTileEntity_Primitive_OutputBus;
import com.spartakcore.gthandler.tileentities.multi.GT_MetaTileEntity_CokeOven;
import com.spartakcore.gthandler.tileentities.multi.GT_MetaTileEntity_Farm;

import cpw.mods.fml.common.Loader;
import gregtech.GT_Mod;
import gregtech.api.GregTech_API;
import gregtech.api.enums.*;
import gregtech.api.metatileentity.implementations.*;
import gregtech.api.util.GT_ModHandler;
import gregtech.api.util.GT_OreDictUnificator;
import gregtech.api.util.GT_Recipe;
import gregtech.api.util.GT_Utility;
import gregtech.common.tileentities.automation.GT_MetaTileEntity_ChestBuffer;
import gregtech.common.tileentities.generators.*;
import gregtech.common.tileentities.machines.basic.*;
import gregtech.loaders.preload.GT_Loader_MetaTileEntities;
import gtPlusPlus.core.material.gregtech.CustomGTMaterials;
import gtPlusPlus.xmod.gregtech.api.metatileentity.implementations.base.GregtechMetaTransformerHiAmp;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

public class GT_Loader_Machines {
	private static final String aTextWire1 = "wire."; private static final String aTextCable1 = "cable."; private static final String aTextWire2 = " Wire"; private static final String aTextCable2 = " Cable";
	private final static String aTextPlate = "PPP"; private final static String aTextPlateWrench = "PwP"; private final static String aTextPlateMotor = "PMP"; private final static String aTextCableHull = "CMC";
	private final static String aTextWireHull = "WMW"; private final static String aTextWireChest = "WTW"; private final static String aTextWireCoil = "WCW"; private final static String aTextMotorWire = "EWE";
	private final static String aTextWirePump = "WPW";
	private final static boolean aBoolConst_0 = false;
	public void run()
	{
		registerMachines();
	}

	private void registerMachines()
	{
		long bitsd = GT_ModHandler.RecipeBits.DISMANTLEABLE | GT_ModHandler.RecipeBits.NOT_REMOVABLE
				| GT_ModHandler.RecipeBits.REVERSIBLE | GT_ModHandler.RecipeBits.BUFFERED;

	}
}
