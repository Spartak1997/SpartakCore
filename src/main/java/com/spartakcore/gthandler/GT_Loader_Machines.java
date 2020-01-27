package com.spartakcore.gthandler;

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
import gregtech.common.tileentities.generators.GT_MetaTileEntity_DieselGenerator;
import gregtech.common.tileentities.generators.GT_MetaTileEntity_GasTurbine;
import gregtech.common.tileentities.generators.GT_MetaTileEntity_PlasmaGenerator;
import gregtech.common.tileentities.generators.GT_MetaTileEntity_SteamTurbine;
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
		
		        // ===================================================================================================
				// Input Hatches
				// ===================================================================================================
				
				CustomItemList.Hatch_Input_UEV.set(new GT_MetaTileEntity_Hatch_Input(12250, "hatch.input.tier.10", "Input Hatch (UEV)",10).getStackForm(1L));
				CustomItemList.Hatch_Input_UIV.set(new GT_MetaTileEntity_Hatch_Input(12251, "hatch.input.tier.11", "Input Hatch (UIV)",11).getStackForm(1L));
				CustomItemList.Hatch_Input_UMV.set(new GT_MetaTileEntity_Hatch_Input(12252, "hatch.input.tier.12", "Input Hatch (UMV)",12).getStackForm(1L));
				CustomItemList.Hatch_Input_UXV.set(new GT_MetaTileEntity_Hatch_Input(12253, "hatch.input.tier.13", "Input Hatch (UXV)",13).getStackForm(1L));
				CustomItemList.Hatch_Input_OPV.set(new GT_MetaTileEntity_Hatch_Input(12254, "hatch.input.tier.14", "Input Hatch (OpV)",14).getStackForm(1L));
				CustomItemList.Hatch_Input_MAX.set(new GT_MetaTileEntity_Hatch_Input(12255, "hatch.input.tier.15", "Input Hatch (MAX)",15).getStackForm(1L));


				// ===================================================================================================
				// Output Hatches
				// ===================================================================================================

				CustomItemList.Hatch_Output_UEV.set(new GT_MetaTileEntity_Hatch_Output(12256, "hatch.output.tier.10", "Output Hatch (UEV)",10).getStackForm(1L));
				CustomItemList.Hatch_Output_UIV.set(new GT_MetaTileEntity_Hatch_Output(12257, "hatch.output.tier.11", "Output Hatch (UIV)",11).getStackForm(1L));
				CustomItemList.Hatch_Output_UMV.set(new GT_MetaTileEntity_Hatch_Output(12258, "hatch.output.tier.12", "Output Hatch (UMV)",12).getStackForm(1L));
				CustomItemList.Hatch_Output_UXV.set(new GT_MetaTileEntity_Hatch_Output(12259, "hatch.output.tier.13", "Output Hatch (UXV)",13).getStackForm(1L));
				CustomItemList.Hatch_Output_OPV.set(new GT_MetaTileEntity_Hatch_Output(12260, "hatch.output.tier.14", "Output Hatch (OpV)",14).getStackForm(1L));
				CustomItemList.Hatch_Output_MAX.set(new GT_MetaTileEntity_Hatch_Output(12261, "hatch.output.tier.15", "Output Hatch (MAX)",15).getStackForm(1L));

				ItemStack[] inHatches = {
								CustomItemList.Hatch_Input_UEV.get(1),
								CustomItemList.Hatch_Input_UIV.get(1),
								CustomItemList.Hatch_Input_UMV.get(1),
								CustomItemList.Hatch_Input_UXV.get(1),
								CustomItemList.Hatch_Input_OPV.get(1),
								CustomItemList.Hatch_Input_MAX.get(1)
				};
				ItemStack[] outHatches = {
								CustomItemList.Hatch_Output_UEV.get(1),
								CustomItemList.Hatch_Output_UIV.get(1),
								CustomItemList.Hatch_Output_UMV.get(1),
								CustomItemList.Hatch_Output_UXV.get(1),
								CustomItemList.Hatch_Output_OPV.get(1),
								CustomItemList.Hatch_Output_MAX.get(1)
				};
				ItemStack[][] flInputs = new ItemStack[6][3];
				ItemStack[][] flInputs2 = new ItemStack[6][3];
				ItemStack[] tanks = {
						GT_ModHandler.getModItem("gregtech","gt.blockmachines",1,142),
						GT_ModHandler.getModItem("gregtech","gt.blockmachines",1,143),
						GT_ModHandler.getModItem("gregtech","gt.blockmachines",1,144),
						GT_ModHandler.getModItem("gregtech","gt.blockmachines",1,120),
						GT_ModHandler.getModItem("gregtech","gt.blockmachines",1,121),
						GT_ModHandler.getModItem("gregtech","gt.blockmachines",1,122),
				};
				ItemStack[] hulls = {
						ItemList.Hull_UEV.get(1),
						ItemList.Hull_UIV.get(1),
						ItemList.Hull_UMV.get(1),
						ItemList.Hull_UXV.get(1),
						ItemList.Hull_OPV.get(1),
						ItemList.Hull_MAXV.get(1),
				};
				for (int i = 0; i < 6; i++) {
					flInputs[i]= new ItemStack[]{hulls[i].copy(), tanks[i].copy(), GT_Utility.getIntegratedCircuit(1)};
					flInputs2[i]= new ItemStack[]{hulls[i].copy(), tanks[i].copy(), GT_Utility.getIntegratedCircuit(2)};
				}
				//10-15 since MAX crashes., change to 16 somwhen the NEI handler is fixed and MAX is optainable
				for (int aTier = 10; aTier < 15; aTier++) {
					if (Loader.isModLoaded("bartworks"))
			        {
					GT_Values.RA.addAssemblerRecipe(flInputs[aTier-10], GT_CoreModSupport.RadoxPolymer.getMolten((long) (2.25 * Math.pow(2,(aTier-9)))), inHatches[aTier-10], 480, (int) (30 * Math.pow(4, (aTier - 1))), false);
					GT_Values.RA.addAssemblerRecipe(flInputs2[aTier-10], GT_CoreModSupport.RadoxPolymer.getMolten((long) (2.25 * Math.pow(2,(aTier-9)))), outHatches[aTier-10], 480, (int) (30 * Math.pow(4, (aTier - 1))), false);
			        }else {
			        	GT_Values.RA.addAssemblerRecipe(flInputs[aTier-10], Materials.PerroxPolymer.getMolten((long) (2.25 * Math.pow(2,(aTier-9)))), inHatches[aTier-10], 480, (int) (30 * Math.pow(4, (aTier - 1))), false);
						GT_Values.RA.addAssemblerRecipe(flInputs2[aTier-10], Materials.PerroxPolymer.getMolten((long) (2.25 * Math.pow(2,(aTier-9)))), outHatches[aTier-10], 480, (int) (30 * Math.pow(4, (aTier - 1))), false);
			        }
				}
				
				// ===================================================================================================
				// Input Buses
				// ===================================================================================================
				
				CustomItemList.Bus_Input_UEV.set(new GT_MetaTileEntity_Hatch_InputBus(12262, "bus.input.tier.10", "Input Bus (UEV)",10).getStackForm(1L));
				CustomItemList.Bus_Input_UIV.set(new GT_MetaTileEntity_Hatch_InputBus(12263, "bus.input.tier.11", "Input Bus (UIV)",11).getStackForm(1L));
				CustomItemList.Bus_Input_UMV.set(new GT_MetaTileEntity_Hatch_InputBus(12264, "bus.input.tier.12", "Input Bus (UMV)",12).getStackForm(1L));
				CustomItemList.Bus_Input_UXV.set(new GT_MetaTileEntity_Hatch_InputBus(12265, "bus.input.tier.13", "Input Bus (UXV)",13).getStackForm(1L));
				CustomItemList.Bus_Input_OPV.set(new GT_MetaTileEntity_Hatch_InputBus(12266, "bus.input.tier.14", "Input Bus (OpV)",14).getStackForm(1L));
				CustomItemList.Bus_Input_MAX.set(new GT_MetaTileEntity_Hatch_InputBus(12267, "bus.input.tier.15", "Input Bus (MAX)",15).getStackForm(1L));


				// ===================================================================================================
				// Output Buses
				// ===================================================================================================

				CustomItemList.Bus_Output_UEV.set(new GT_MetaTileEntity_Hatch_OutputBus(12268, "bus.output.tier.10", "Output Bus (UEV)",10).getStackForm(1L));
				CustomItemList.Bus_Output_UIV.set(new GT_MetaTileEntity_Hatch_OutputBus(12269, "bus.output.tier.11", "Output Bus (UIV)",11).getStackForm(1L));
				CustomItemList.Bus_Output_UMV.set(new GT_MetaTileEntity_Hatch_OutputBus(12270, "bus.output.tier.12", "Output Bus (UMV)",12).getStackForm(1L));
				CustomItemList.Bus_Output_UXV.set(new GT_MetaTileEntity_Hatch_OutputBus(12271, "bus.output.tier.13", "Output Bus (UXV)",13).getStackForm(1L));
				CustomItemList.Bus_Output_OPV.set(new GT_MetaTileEntity_Hatch_OutputBus(12272, "bus.output.tier.14", "Output Bus (OpV)",14).getStackForm(1L));
				CustomItemList.Bus_Output_MAX.set(new GT_MetaTileEntity_Hatch_OutputBus(12273, "bus.output.tier.15", "Output Bus (MAX)",15).getStackForm(1L));
				
				ItemStack[] inBuses = {
						CustomItemList.Bus_Input_UEV.get(1),
						CustomItemList.Bus_Input_UIV.get(1),
						CustomItemList.Bus_Input_UMV.get(1),
						CustomItemList.Bus_Input_UXV.get(1),
						CustomItemList.Bus_Input_OPV.get(1),
						CustomItemList.Bus_Input_MAX.get(1)
		        };
		        ItemStack[] outBuses = {
						CustomItemList.Bus_Output_UEV.get(1),
						CustomItemList.Bus_Output_UIV.get(1),
						CustomItemList.Bus_Output_UMV.get(1),
						CustomItemList.Bus_Output_UXV.get(1),
						CustomItemList.Bus_Output_OPV.get(1),
						CustomItemList.Bus_Output_MAX.get(1)
		        };
		        ItemStack[][] itInputs = new ItemStack[6][3];
		        ItemStack[][] itInputs2 = new ItemStack[6][3];
		        ItemStack[] chests = {
				        GT_ModHandler.getModItem("gregtech","gt.blockmachines",1,147),
				        GT_ModHandler.getModItem("gregtech","gt.blockmachines",1,148),
				        GT_ModHandler.getModItem("gregtech","gt.blockmachines",1,149),
				        GT_ModHandler.getModItem("gregtech","gt.blockmachines",1,127),
				        GT_ModHandler.getModItem("gregtech","gt.blockmachines",1,128),
				        GT_ModHandler.getModItem("gregtech","gt.blockmachines",1,129),
		        };
		        for (int i = 0; i < 6; i++) {
			            itInputs[i]= new ItemStack[]{hulls[i].copy(), chests[i].copy(), GT_Utility.getIntegratedCircuit(1)};
			            itInputs2[i]= new ItemStack[]{hulls[i].copy(), chests[i].copy(), GT_Utility.getIntegratedCircuit(2)};
		        }
		        for (int aTier = 10; aTier < 15; aTier++) {
		        	if (Loader.isModLoaded("bartworks"))
			        {
			            GT_Values.RA.addAssemblerRecipe(itInputs[aTier-10], GT_CoreModSupport.RadoxPolymer.getMolten((long) (2.25 * Math.pow(2,(aTier-9)))), inBuses[aTier-10], 480, (int) (30 * Math.pow(4, (aTier - 1))), false);
			            GT_Values.RA.addAssemblerRecipe(itInputs2[aTier-10], GT_CoreModSupport.RadoxPolymer.getMolten((long) (2.25 * Math.pow(2,(aTier-9)))), outBuses[aTier-10], 480, (int) (30 * Math.pow(4, (aTier - 1))), false);
			        }else {
			        	GT_Values.RA.addAssemblerRecipe(itInputs[aTier-10], Materials.PerroxPolymer.getMolten((long) (2.25 * Math.pow(2,(aTier-9)))), inBuses[aTier-10], 480, (int) (30 * Math.pow(4, (aTier - 1))), false);
			            GT_Values.RA.addAssemblerRecipe(itInputs2[aTier-10], Materials.PerroxPolymer.getMolten((long) (2.25 * Math.pow(2,(aTier-9)))), outBuses[aTier-10], 480, (int) (30 * Math.pow(4, (aTier - 1))), false);
			        }
		        }
				
		        // ===================================================================================================
				// Component Assembler
				// ===================================================================================================

		        if(GT_Mod.gregtechproxy.mComponentAssembler){
		        	CustomItemList.Machine_LV_ComponentAssembler.set(new GT_MetaTileEntity_BasicMachine_GT_Recipe(13010, "basicmachine.componentassembler.tier.01", "Basic Component Assembling Machine", 1, "Components, Assemble!", GT_Recipe.GT_Recipe_Map.sComponentAssemblerRecipes,6, 1, 16000, 0, 1, "Assembler.png", GregTech_API.sSoundList.get(204), false, false, 0, "COMPONENTASSEMBLER", null).getStackForm(1L));
			        CustomItemList.Machine_MV_ComponentAssembler.set(new GT_MetaTileEntity_BasicMachine_GT_Recipe(13011, "basicmachine.componentassembler.tier.02", "Advanced Component Assembling Machine", 2, "Components, Assemble!", GT_Recipe.GT_Recipe_Map.sComponentAssemblerRecipes,6, 1, 24000, 0, 1, "Assembler.png", GregTech_API.sSoundList.get(204), false, false, 0, "COMPONENTASSEMBLER", null).getStackForm(1L));
			        CustomItemList.Machine_HV_ComponentAssembler.set(new GT_MetaTileEntity_BasicMachine_GT_Recipe(13012, "basicmachine.componentassembler.tier.03", "Advanced Component Assembling Machine II", 3, "Components, Assemble!", GT_Recipe.GT_Recipe_Map.sComponentAssemblerRecipes,6, 1, 32000, 0, 1, "Assembler.png", GregTech_API.sSoundList.get(204), false, false, 0, "COMPONENTASSEMBLER", null).getStackForm(1L));
			        CustomItemList.Machine_EV_ComponentAssembler.set(new GT_MetaTileEntity_BasicMachine_GT_Recipe(13013, "basicmachine.componentassembler.tier.04", "Advanced Component Assembling Machine III", 4, "Components, Assemble!", GT_Recipe.GT_Recipe_Map.sComponentAssemblerRecipes,6, 1, 48000, 0, 1, "Assembler.png", GregTech_API.sSoundList.get(204), false, false, 0, "COMPONENTASSEMBLER", null).getStackForm(1L));
			        CustomItemList.Machine_IV_ComponentAssembler.set(new GT_MetaTileEntity_BasicMachine_GT_Recipe(13014, "basicmachine.componentassembler.tier.05", "Advanced Component Assembling Machine IV", 5, "Components, Assemble!", GT_Recipe.GT_Recipe_Map.sComponentAssemblerRecipes,6, 1, 64000, 0, 1, "Assembler.png", GregTech_API.sSoundList.get(204), false, false, 0, "COMPONENTASSEMBLER", null).getStackForm(1L));
			        CustomItemList.Machine_LuV_ComponentAssembler.set(new GT_MetaTileEntity_BasicMachine_GT_Recipe(13015, "basicmachine.componentassembler.tier.06", "Extreme Component Assembling Machine", 6, "Components, Assemble!", GT_Recipe.GT_Recipe_Map.sComponentAssemblerRecipes,6, 1, 64000, 0, 1, "Assembler.png", GregTech_API.sSoundList.get(204), false, false, 0, "COMPONENTASSEMBLER", null).getStackForm(1L));
			        CustomItemList.Machine_ZPM_ComponentAssembler.set(new GT_MetaTileEntity_BasicMachine_GT_Recipe(13016, "basicmachine.componentassembler.tier.07", "Extreme Component Assembling Machine II", 7, "Components, Assemble!", GT_Recipe.GT_Recipe_Map.sComponentAssemblerRecipes,6, 1, 64000, 0, 1, "Assembler.png", GregTech_API.sSoundList.get(204), false, false, 0, "COMPONENTASSEMBLER", null).getStackForm(1L));
			        CustomItemList.Machine_UV_ComponentAssembler.set(new GT_MetaTileEntity_BasicMachine_GT_Recipe(13017, "basicmachine.componentassembler.tier.08", "Extreme Component Assembling Machine III", 8, "Components, Assemble!", GT_Recipe.GT_Recipe_Map.sComponentAssemblerRecipes,6, 1, 64000, 0, 1, "Assembler.png", GregTech_API.sSoundList.get(204), false, false, 0, "COMPONENTASSEMBLER", null).getStackForm(1L));
			        CustomItemList.Machine_UHV_ComponentAssembler.set(new GT_MetaTileEntity_BasicMachine_GT_Recipe(13018, "basicmachine.componentassembler.tier.09", "Epic Component Assembling Machine", 9, "Components, Assemble!", GT_Recipe.GT_Recipe_Map.sComponentAssemblerRecipes,6, 1, 64000, 0, 1, "Assembler.png", GregTech_API.sSoundList.get(204), false, false, 0, "COMPONENTASSEMBLER", null).getStackForm(1L));
			        CustomItemList.Machine_UEV_ComponentAssembler.set(new GT_MetaTileEntity_BasicMachine_GT_Recipe(13019, "basicmachine.componentassembler.tier.10", "Epic Component Assembling Machine II", 10, "Components, Assemble!", GT_Recipe.GT_Recipe_Map.sComponentAssemblerRecipes,6, 1, 64000, 0, 1, "Assembler.png", GregTech_API.sSoundList.get(204), false, false, 0, "COMPONENTASSEMBLER", null).getStackForm(1L));
					
			        GT_ModHandler.addCraftingRecipe(CustomItemList.Machine_LV_ComponentAssembler.get(1L),bitsd,new Object[]{"PCP", "RHR", "WCW",
							'P', CustomItemList.ULVPiston,
							'R', CustomItemList.ULVRobotArm,
							'H', ItemList.Hull_LV,
							'C', OrePrefixes.circuit.get(Materials.Basic),
							'W', OrePrefixes.cableGt01.get(Materials.Tin)});
			        GT_ModHandler.addCraftingRecipe(CustomItemList.Machine_MV_ComponentAssembler.get(1L),bitsd,new Object[]{"PCP", "RHR", "WCW",
							'P', ItemList.Electric_Piston_LV,
							'R', ItemList.Robot_Arm_LV,
							'H', ItemList.Hull_MV,
							'C', OrePrefixes.circuit.get(Materials.Good),
							'W', OrePrefixes.cableGt01.get(Materials.Copper)});
			        GT_ModHandler.addCraftingRecipe(CustomItemList.Machine_HV_ComponentAssembler.get(1L),bitsd,new Object[]{"PCP", "RHR", "WCW",
							'P', ItemList.Electric_Piston_MV,
							'R', ItemList.Robot_Arm_MV,
							'H', ItemList.Hull_HV,
							'C', OrePrefixes.circuit.get(Materials.Advanced),
							'W', OrePrefixes.cableGt02.get(Materials.Gold)});
			        GT_ModHandler.addCraftingRecipe(CustomItemList.Machine_EV_ComponentAssembler.get(1L),bitsd,new Object[]{"PCP", "RHR", "WCW",
							'P', ItemList.Electric_Piston_HV,
							'R', ItemList.Robot_Arm_HV,
							'H', ItemList.Hull_EV,
							'C', OrePrefixes.circuit.get(Materials.Data),
							'W', OrePrefixes.cableGt02.get(Materials.Aluminium)});
			        GT_ModHandler.addCraftingRecipe(CustomItemList.Machine_IV_ComponentAssembler.get(1L),bitsd,new Object[]{"PCP", "RHR", "WCW",
							'P', ItemList.Electric_Piston_EV,
							'R', ItemList.Robot_Arm_EV,
							'H', ItemList.Hull_IV,
							'C', OrePrefixes.circuit.get(Materials.Elite),
							'W', OrePrefixes.cableGt04.get(Materials.TungstenSteel)});
			        GT_ModHandler.addCraftingRecipe(CustomItemList.Machine_LuV_ComponentAssembler.get(1L),bitsd,new Object[]{"PCP", "RHR", "WCW",
							'P', ItemList.Electric_Piston_IV,
							'R', ItemList.Robot_Arm_IV,
							'H', ItemList.Hull_LuV,
							'C', OrePrefixes.circuit.get(Materials.Master),
							'W', OrePrefixes.cableGt04.get(Materials.VanadiumGallium)});
			        GT_ModHandler.addCraftingRecipe(CustomItemList.Machine_ZPM_ComponentAssembler.get(1L),bitsd,new Object[]{"PCP", "RHR", "WCW",
							'P', ItemList.Electric_Piston_LuV,
							'R', ItemList.Robot_Arm_LuV,
							'H', ItemList.Hull_ZPM,
							'C', OrePrefixes.circuit.get(Materials.Ultimate),
							'W', OrePrefixes.cableGt08.get(Materials.Naquadah)});
			        GT_ModHandler.addCraftingRecipe(CustomItemList.Machine_UV_ComponentAssembler.get(1L),bitsd,new Object[]{"PCP", "RHR", "WCW",
							'P', ItemList.Electric_Piston_ZPM,
							'R', ItemList.Robot_Arm_ZPM,
							'H', ItemList.Hull_UV,
							'C', OrePrefixes.circuit.get(Materials.Superconductor),
							'W', OrePrefixes.cableGt08.get(Materials.NaquadahAlloy)});
			        GT_ModHandler.addCraftingRecipe(CustomItemList.Machine_UHV_ComponentAssembler.get(1L),bitsd,new Object[]{"PCP", "RHR", "WCW",
							'P', ItemList.Electric_Piston_UV,
							'R', ItemList.Robot_Arm_UV,
							'H', ItemList.Hull_MAX,
							'C', OrePrefixes.circuit.get(Materials.Infinite),
							'W', OrePrefixes.wireGt12.get(Materials.Europium)});
			        GT_ModHandler.addCraftingRecipe(CustomItemList.Machine_UEV_ComponentAssembler.get(1L),bitsd,new Object[]{"PCP", "RHR", "WCW",
							'P', ItemList.Electric_Piston_UHV,
							'R', ItemList.Robot_Arm_UHV,
							'H', ItemList.Hull_UEV,
							'C', OrePrefixes.circuit.get(Materials.Bio),
							'W', OrePrefixes.wireGt12.get(Materials.Diamericiumtitanium)});
		        }else {
		        
		        }
		        
		        // ===================================================================================================
				// ULV Generators
				// ===================================================================================================

		        CustomItemList.Generator_Steam_Turbine_ULV.set(new GT_MetaTileEntity_SteamTurbine(13025, "basicgenerator.steamturbine.tier.00", "First Steam Turbine", 0).getStackForm(1L));
		        CustomItemList.Generator_Diesel_ULV.set(new GT_MetaTileEntity_DieselGenerator(13026, "basicgenerator.diesel.tier.00", "First Combustion Generator", 0).getStackForm(1L));
		        CustomItemList.Generator_Gas_Turbine_ULV.set(new GT_MetaTileEntity_GasTurbine(13027, "basicgenerator.gasturbine.tier.00", "First Gas Turbine", 0).getStackForm(1L));

				GT_ModHandler.addCraftingRecipe(CustomItemList.Generator_Steam_Turbine_ULV.get(1L, new Object[0]), bitsd, new Object[]{"PCP", "RHR", "EWE", 'H', ItemList.Hull_ULV, 'E', CustomItemList.ULVMotor, 'R', OrePrefixes.rotor.get(Materials.Lead), 'C', OrePrefixes.circuit.get(Materials.Primitive), 'W', OrePrefixes.cableGt01.get(Materials.Lead), 'P', OrePrefixes.pipeSmall.get(Materials.Lead)});
		        GT_ModHandler.addCraftingRecipe(CustomItemList.Generator_Diesel_ULV.get(1L, new Object[0]), bitsd, new Object[]{"PCP", "EME", "GWG", 'M', ItemList.Hull_ULV, 'P', CustomItemList.ULVPiston, 'E', CustomItemList.ULVMotor, 'C', OrePrefixes.circuit.get(Materials.Primitive), 'W', OrePrefixes.cableGt01.get(Materials.Lead), 'G', OrePrefixes.gearGt.get(Materials.WroughtIron)});
		        GT_ModHandler.addCraftingRecipe(CustomItemList.Generator_Gas_Turbine_ULV.get(1L, new Object[0]), bitsd, new Object[]{"CRC", "RHR", "EWE", 'H', ItemList.Hull_ULV, 'E', CustomItemList.ULVMotor, 'R', OrePrefixes.rotor.get(Materials.Lead), 'C', OrePrefixes.circuit.get(Materials.Primitive), 'W', OrePrefixes.cableGt01.get(Materials.Lead)});


				// ===================================================================================================
				// Primitive Assemblers
				// ===================================================================================================

				CustomItemList.Machine_ULV_Assembler.set(new GT_MetaTileEntity_BasicMachine_GT_Recipe(13028, "basicmachine.assembler.tier.00", "Primitive Assembler", 0, "Avengers, Assemble!", GT_Recipe.GT_Recipe_Map.sAssemblerRecipes, 3, 1, 8000, 0, 1, "Assembler0.png", GregTech_API.sSoundList.get(204), false, false, 0, "ASSEMBLER", null).getStackForm(1L));
				CustomItemList.Machine_ULV_CircuitAssembler.set(new GT_MetaTileEntity_BasicMachine_GT_Recipe( 13029, "basicmachine.circuitassembler.tier.00", "Primitive Circuit Assembler", 0, "Pick-n-Place all over the place", GT_Recipe.GT_Recipe_Map.sCircuitAssemblerRecipes, 6, 1, 8000, 0, 1, "CircuitAssembler0.png", GregTech_API.sSoundList.get(204), false, false, 0, "CIRCUITASSEMBLER", null).getStackForm(1L));


				// ===================================================================================================
				// MULTIBLOCKS
				// ===================================================================================================
				CustomItemList.Machine_Multi_Farm.set(new GT_MetaTileEntity_Farm(13001, "multimachine.farm", "Multiblock Farm").getStackForm(1L));

				GT_ModHandler.addCraftingRecipe(CustomItemList.Machine_Multi_Farm.get(1L),
						bitsd,
						new Object[]{"ROR", "CHC", "PWP",
								'H', ItemList.Hull_MV,
								'W', OrePrefixes.cableGt02.get(Materials.Copper),
								'C', OrePrefixes.circuit.get(Materials.Good),
								'P', ItemList.Electric_Pump_MV,
								'R', ItemList.Robot_Arm_MV,
								'O', OreDictNames.craftingDiamondBlade});

		        
	}

}
