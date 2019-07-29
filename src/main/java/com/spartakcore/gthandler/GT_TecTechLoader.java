package com.spartakcore.gthandler;

import com.github.technus.tectech.recipe.TT_recipeAdder;
import com.github.technus.tectech.thing.CustomItemList;
import com.github.technus.tectech.thing.block.QuantumGlassBlock;
import gregtech.api.enums.GT_Values;
import gregtech.api.enums.ItemList;
import gregtech.api.enums.Materials;
import gregtech.api.enums.OrePrefixes;
import gregtech.api.util.GT_ModHandler;
import gregtech.api.util.GT_OreDictUnificator;
import gregtech.api.util.GT_Utility;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fluids.FluidStack;

public class GT_TecTechLoader implements Runnable{
	
	 @Override
	    public void run() {
		 
		  //Dynamo Hatches UEV-UIV
	        GT_Values.RA.addAssemblerRecipe(new ItemStack[]{ItemList.Hatch_Dynamo_UEV.get(1), GT_OreDictUnificator.get(OrePrefixes.wireGt04, Materials.SuperconductorUEV, 2), GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Phoenixite, 2)}, Materials.Silver.getMolten(4608), CustomItemList.eM_dynamoMulti4_UEV.get(1), 100, 2000000);
	        GT_Values.RA.addAssemblerRecipe(new ItemStack[]{ItemList.Transformer_UIV_UEV.get(1), CustomItemList.eM_dynamoMulti4_UEV.get(1), GT_OreDictUnificator.get(OrePrefixes.wireGt08, Materials.SuperconductorUEV, 2), GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Phoenixite, 4)}, Materials.Electrum.getMolten(4608), CustomItemList.eM_dynamoMulti16_UEV.get(1), 200, 2000000);
	        GT_Values.RA.addAssemblerRecipe(new ItemStack[]{ItemList.WetTransformer_UIV_UEV.get(1), CustomItemList.eM_dynamoMulti16_UEV.get(1), GT_OreDictUnificator.get(OrePrefixes.wireGt12, Materials.SuperconductorUEV, 2), GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Phoenixite, 6)}, Materials.Tungsten.getMolten(4608), CustomItemList.eM_dynamoMulti64_UEV.get(1), 400, 2000000);

	        GT_Values.RA.addAssemblerRecipe(new ItemStack[]{ItemList.Hatch_Dynamo_UIV.get(1), GT_OreDictUnificator.get(OrePrefixes.wireGt04, Materials.Neutronium, 2), GT_OreDictUnificator.get(OrePrefixes.plate, Materials.BlackPlutonium, 2)}, Materials.Silver.getMolten(8000), CustomItemList.eM_dynamoMulti4_UIV.get(1), 100, 8000000);
	        GT_Values.RA.addAssemblerRecipe(new ItemStack[]{ItemList.Transformer_UMV_UIV.get(1), CustomItemList.eM_dynamoMulti4_UIV.get(1), GT_OreDictUnificator.get(OrePrefixes.wireGt08, Materials.Neutronium, 2), GT_OreDictUnificator.get(OrePrefixes.plate, Materials.BlackPlutonium, 4)}, Materials.Electrum.getMolten(8000), CustomItemList.eM_dynamoMulti16_UIV.get(1), 200, 8000000);
	        GT_Values.RA.addAssemblerRecipe(new ItemStack[]{ItemList.WetTransformer_UMV_UIV.get(1), CustomItemList.eM_dynamoMulti16_UIV.get(1), GT_OreDictUnificator.get(OrePrefixes.wireGt12, Materials.Neutronium, 2), GT_OreDictUnificator.get(OrePrefixes.plate, Materials.BlackPlutonium, 6)}, Materials.Tungsten.getMolten(8000), CustomItemList.eM_dynamoMulti64_UIV.get(1), 400, 8000000);
	        
	      //Energy Hatches 4A-64A  IV-UHV
	        GT_Values.RA.addAssemblerRecipe(new ItemStack[]{ItemList.Hatch_Energy_UEV.get(1), GT_OreDictUnificator.get(OrePrefixes.wireGt04, Materials.SuperconductorUEV, 2), GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Phoenixite, 2)}, Materials.Silver.getMolten(4000), CustomItemList.eM_energyMulti4_UEV.get(1), 100, 2000000);
	        GT_Values.RA.addAssemblerRecipe(new ItemStack[]{ItemList.Transformer_UIV_UEV.get(1), CustomItemList.eM_energyMulti4_UEV.get(1), GT_OreDictUnificator.get(OrePrefixes.wireGt08, Materials.SuperconductorUEV, 2), GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Phoenixite, 2)}, Materials.Electrum.getMolten(4000), CustomItemList.eM_energyMulti16_UEV.get(1), 200, 2000000);
	        GT_Values.RA.addAssemblerRecipe(new ItemStack[]{ItemList.WetTransformer_UIV_UEV.get(1), CustomItemList.eM_energyMulti16_UEV.get(1), GT_OreDictUnificator.get(OrePrefixes.wireGt12, Materials.SuperconductorUEV, 2), GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Phoenixite, 2)}, Materials.Tungsten.getMolten(4000), CustomItemList.eM_energyMulti64_UEV.get(1), 400, 2000000);

	        GT_Values.RA.addAssemblerRecipe(new ItemStack[]{ItemList.Hatch_Energy_UIV.get(1), GT_OreDictUnificator.get(OrePrefixes.wireGt04, Materials.NetherStar, 2), GT_OreDictUnificator.get(OrePrefixes.plate, Materials.BlackPlutonium, 2)}, Materials.Silver.getMolten(8000), CustomItemList.eM_energyMulti4_UIV.get(1), 100, 8000000);
	        GT_Values.RA.addAssemblerRecipe(new ItemStack[]{ItemList.Transformer_UMV_UIV.get(1), CustomItemList.eM_energyMulti4_UIV.get(1), GT_OreDictUnificator.get(OrePrefixes.wireGt08, Materials.NetherStar, 2), GT_OreDictUnificator.get(OrePrefixes.plate, Materials.BlackPlutonium, 4)}, Materials.Electrum.getMolten(8000), CustomItemList.eM_energyMulti16_UIV.get(1), 200, 8000000);
	        GT_Values.RA.addAssemblerRecipe(new ItemStack[]{ItemList.WetTransformer_UMV_UIV.get(1), CustomItemList.eM_energyMulti16_UIV.get(1), GT_OreDictUnificator.get(OrePrefixes.wireGt12, Materials.NetherStar, 2), GT_OreDictUnificator.get(OrePrefixes.plate, Materials.BlackPlutonium, 6)}, Materials.Tungsten.getMolten(8000), CustomItemList.eM_energyMulti64_UIV.get(1), 400, 8000000);

//####################################################################################################################################################################################################################################################################################################################################################################################################
	      
	        //Laser Dynamo IV-UEV 256/t
	        GT_Values.RA.addAssemblerRecipe(new ItemStack[]{ItemList.Hull_MAX.get(1), GT_OreDictUnificator.get(OrePrefixes.lens, Materials.Diamond, 1), ItemList.Emitter_UHV.get(1), ItemList.Electric_Pump_UHV.get(1), GT_OreDictUnificator.get(OrePrefixes.wireGt01, Materials.Europium, 2), GT_Utility.getIntegratedCircuit(1)}, null, CustomItemList.eM_dynamoTunnel1_UHV.get(1), 1000, 2000000);
	        GT_Values.RA.addAssemblerRecipe(new ItemStack[]{ItemList.Hull_UEV.get(1), GT_OreDictUnificator.get(OrePrefixes.lens, Materials.Diamond, 1), ItemList.Emitter_UEV.get(1), ItemList.Electric_Pump_UEV.get(1), GT_OreDictUnificator.get(OrePrefixes.wireGt01, Materials.Diamericiumtitanium, 2), GT_Utility.getIntegratedCircuit(1)}, null, CustomItemList.eM_dynamoTunnel1_UEV.get(1), 1000, 8000000);
	        
	        //Laser Dynamo IV-UEV 1024/t
	        GT_Values.RA.addAssemblerRecipe(new ItemStack[]{ItemList.Hull_MAX.get(1), GT_OreDictUnificator.get(OrePrefixes.lens, Materials.Diamond, 2), ItemList.Emitter_UHV.get(2), ItemList.Electric_Pump_UHV.get(2), GT_OreDictUnificator.get(OrePrefixes.wireGt02, Materials.Europium, 4), GT_Utility.getIntegratedCircuit(2)}, null, CustomItemList.eM_dynamoTunnel2_UHV.get(1), 2000, 2000000);
	        GT_Values.RA.addAssemblerRecipe(new ItemStack[]{ItemList.Hull_UEV.get(1), GT_OreDictUnificator.get(OrePrefixes.lens, Materials.Diamond, 2), ItemList.Emitter_UEV.get(2), ItemList.Electric_Pump_UEV.get(2), GT_OreDictUnificator.get(OrePrefixes.wireGt02, Materials.Diamericiumtitanium, 4), GT_Utility.getIntegratedCircuit(2)}, null, CustomItemList.eM_dynamoTunnel2_UEV.get(1), 2000, 8000000);
	        
	        //Laser Dynamo IV-UEV 4096/t
	        GT_Values.RA.addAssemblerRecipe(new ItemStack[]{ItemList.Hull_MAX.get(1), GT_OreDictUnificator.get(OrePrefixes.lens, Materials.Diamond, 4), ItemList.Emitter_UHV.get(4), ItemList.Electric_Pump_UHV.get(4), GT_OreDictUnificator.get(OrePrefixes.wireGt04, Materials.Europium, 4), GT_Utility.getIntegratedCircuit(3)}, null, CustomItemList.eM_dynamoTunnel3_UHV.get(1), 4000, 2000000);
	        GT_Values.RA.addAssemblerRecipe(new ItemStack[]{ItemList.Hull_UEV.get(1), GT_OreDictUnificator.get(OrePrefixes.lens, Materials.Diamond, 4), ItemList.Emitter_UEV.get(4), ItemList.Electric_Pump_UEV.get(4), GT_OreDictUnificator.get(OrePrefixes.wireGt04, Materials.Diamericiumtitanium, 4), GT_Utility.getIntegratedCircuit(3)}, null, CustomItemList.eM_dynamoTunnel3_UEV.get(1), 4000, 8000000);
	        
	        //Laser Dynamo IV-UEV 16384/t
	        GT_Values.RA.addAssemblerRecipe(new ItemStack[]{ItemList.Hull_MAX.get(1), GT_OreDictUnificator.get(OrePrefixes.lens, Materials.Diamond, 8), ItemList.Emitter_UHV.get(8), ItemList.Electric_Pump_UHV.get(8), GT_OreDictUnificator.get(OrePrefixes.wireGt04, Materials.Europium, 8), GT_Utility.getIntegratedCircuit(4)}, null, CustomItemList.eM_dynamoTunnel4_UHV.get(1), 8000, 2000000);
	        GT_Values.RA.addAssemblerRecipe(new ItemStack[]{ItemList.Hull_UEV.get(1), GT_OreDictUnificator.get(OrePrefixes.lens, Materials.Diamond, 8), ItemList.Emitter_UEV.get(8), ItemList.Electric_Pump_UEV.get(8), GT_OreDictUnificator.get(OrePrefixes.wireGt04, Materials.Diamericiumtitanium, 8), GT_Utility.getIntegratedCircuit(4)}, null, CustomItemList.eM_dynamoTunnel4_UEV.get(1), 8000, 8000000);
	        
	        //Laser Dynamo IV-UEV 65536/t
	        GT_Values.RA.addAssemblerRecipe(new ItemStack[]{ItemList.Hull_MAX.get(1), GT_OreDictUnificator.get(OrePrefixes.lens, Materials.Diamond, 16), ItemList.Emitter_UHV.get(16), ItemList.Electric_Pump_UHV.get(16), GT_OreDictUnificator.get(OrePrefixes.wireGt08, Materials.Europium, 8), GT_Utility.getIntegratedCircuit(5)}, null, CustomItemList.eM_dynamoTunnel5_UHV.get(1), 16000, 2000000);
	        GT_Values.RA.addAssemblerRecipe(new ItemStack[]{ItemList.Hull_UEV.get(1), GT_OreDictUnificator.get(OrePrefixes.lens, Materials.Diamond, 16), ItemList.Emitter_UEV.get(16), ItemList.Electric_Pump_UEV.get(16), GT_OreDictUnificator.get(OrePrefixes.wireGt08, Materials.Diamericiumtitanium, 8), GT_Utility.getIntegratedCircuit(5)}, null, CustomItemList.eM_dynamoTunnel5_UEV.get(1), 16000, 8000000);
	        
	        //Laser Dynamo IV-UEV 262144/t
	        GT_Values.RA.addAssemblerRecipe(new ItemStack[]{ItemList.Hull_MAX.get(1), GT_OreDictUnificator.get(OrePrefixes.lens, Materials.Diamond, 32), ItemList.Emitter_UHV.get(32), ItemList.Electric_Pump_UHV.get(32), GT_OreDictUnificator.get(OrePrefixes.wireGt08, Materials.Europium, 16), GT_Utility.getIntegratedCircuit(6)}, null, CustomItemList.eM_dynamoTunnel6_UHV.get(1), 32000, 2000000);
	        GT_Values.RA.addAssemblerRecipe(new ItemStack[]{ItemList.Hull_UEV.get(1), GT_OreDictUnificator.get(OrePrefixes.lens, Materials.Diamond, 32), ItemList.Emitter_UEV.get(32), ItemList.Electric_Pump_UEV.get(32), GT_OreDictUnificator.get(OrePrefixes.wireGt08, Materials.Diamericiumtitanium, 16), GT_Utility.getIntegratedCircuit(6)}, null, CustomItemList.eM_dynamoTunnel6_UEV.get(1), 32000, 8000000);
	        
	        //Laser Dynamo IV-UEV 1048576/t
	        GT_Values.RA.addAssemblerRecipe(new ItemStack[]{ItemList.Hull_MAX.get(1), GT_OreDictUnificator.get(OrePrefixes.lens, Materials.Diamond, 64), ItemList.Emitter_UHV.get(64), ItemList.Electric_Pump_UHV.get(64), GT_OreDictUnificator.get(OrePrefixes.wireGt16, Materials.Europium, 16), GT_Utility.getIntegratedCircuit(7)}, null, CustomItemList.eM_dynamoTunnel7_UHV.get(1), 64000, 2000000);
	        GT_Values.RA.addAssemblerRecipe(new ItemStack[]{ItemList.Hull_UEV.get(1), GT_OreDictUnificator.get(OrePrefixes.lens, Materials.Diamond, 64), ItemList.Emitter_UEV.get(64), ItemList.Electric_Pump_UEV.get(64), GT_OreDictUnificator.get(OrePrefixes.wireGt16, Materials.Diamericiumtitanium, 16), GT_Utility.getIntegratedCircuit(7)}, null, CustomItemList.eM_dynamoTunnel7_UEV.get(1), 64000, 8000000);
	        
	        //Laser Target IV-UEV 256/t
	        GT_Values.RA.addAssemblerRecipe(new ItemStack[]{ItemList.Hull_MAX.get(1), GT_OreDictUnificator.get(OrePrefixes.lens, Materials.Diamond, 1), ItemList.Sensor_UHV.get(1), ItemList.Electric_Pump_UHV.get(1), GT_OreDictUnificator.get(OrePrefixes.wireGt01, Materials.Europium, 2), GT_Utility.getIntegratedCircuit(1)}, null, CustomItemList.eM_energyTunnel1_UHV.get(1), 1000, 2000000);
	        GT_Values.RA.addAssemblerRecipe(new ItemStack[]{ItemList.Hull_UEV.get(1), GT_OreDictUnificator.get(OrePrefixes.lens, Materials.Diamond, 1), ItemList.Sensor_UEV.get(1), ItemList.Electric_Pump_UEV.get(1), GT_OreDictUnificator.get(OrePrefixes.wireGt01, Materials.Diamericiumtitanium, 2), GT_Utility.getIntegratedCircuit(1)}, null, CustomItemList.eM_energyTunnel1_UEV.get(1), 1000, 8000000);
	        
	        //Laser Target IV-UEV 1024/t
	        GT_Values.RA.addAssemblerRecipe(new ItemStack[]{ItemList.Hull_MAX.get(1), GT_OreDictUnificator.get(OrePrefixes.lens, Materials.Diamond, 2), ItemList.Sensor_UHV.get(2), ItemList.Electric_Pump_UHV.get(2), GT_OreDictUnificator.get(OrePrefixes.wireGt02, Materials.Europium, 4), GT_Utility.getIntegratedCircuit(2)}, null, CustomItemList.eM_energyTunnel2_UHV.get(1), 2000, 2000000);
	        GT_Values.RA.addAssemblerRecipe(new ItemStack[]{ItemList.Hull_UEV.get(1), GT_OreDictUnificator.get(OrePrefixes.lens, Materials.Diamond, 2), ItemList.Sensor_UEV.get(2), ItemList.Electric_Pump_UEV.get(2), GT_OreDictUnificator.get(OrePrefixes.wireGt02, Materials.Diamericiumtitanium, 4), GT_Utility.getIntegratedCircuit(2)}, null, CustomItemList.eM_energyTunnel2_UEV.get(1), 2000, 8000000);
	        
	        //Laser Target IV-UEV 4096/t
	        GT_Values.RA.addAssemblerRecipe(new ItemStack[]{ItemList.Hull_MAX.get(1), GT_OreDictUnificator.get(OrePrefixes.lens, Materials.Diamond, 4), ItemList.Sensor_UHV.get(4), ItemList.Electric_Pump_UHV.get(4), GT_OreDictUnificator.get(OrePrefixes.wireGt04, Materials.Europium, 4), GT_Utility.getIntegratedCircuit(3)}, null, CustomItemList.eM_energyTunnel3_UHV.get(1), 4000, 2000000);
	        GT_Values.RA.addAssemblerRecipe(new ItemStack[]{ItemList.Hull_UEV.get(1), GT_OreDictUnificator.get(OrePrefixes.lens, Materials.Diamond, 4), ItemList.Sensor_UEV.get(4), ItemList.Electric_Pump_UEV.get(4), GT_OreDictUnificator.get(OrePrefixes.wireGt04, Materials.Diamericiumtitanium, 4), GT_Utility.getIntegratedCircuit(3)}, null, CustomItemList.eM_energyTunnel3_UEV.get(1), 4000, 8000000);
	        
	        //Laser Target IV-UEV 16384/t
	        GT_Values.RA.addAssemblerRecipe(new ItemStack[]{ItemList.Hull_MAX.get(1), GT_OreDictUnificator.get(OrePrefixes.lens, Materials.Diamond, 8), ItemList.Sensor_UHV.get(8), ItemList.Electric_Pump_UHV.get(8), GT_OreDictUnificator.get(OrePrefixes.wireGt04, Materials.Europium, 8), GT_Utility.getIntegratedCircuit(4)}, null, CustomItemList.eM_energyTunnel4_UHV.get(1), 8000, 2000000);
	        GT_Values.RA.addAssemblerRecipe(new ItemStack[]{ItemList.Hull_UEV.get(1), GT_OreDictUnificator.get(OrePrefixes.lens, Materials.Diamond, 8), ItemList.Sensor_UEV.get(8), ItemList.Electric_Pump_UEV.get(8), GT_OreDictUnificator.get(OrePrefixes.wireGt04, Materials.Diamericiumtitanium, 8), GT_Utility.getIntegratedCircuit(4)}, null, CustomItemList.eM_energyTunnel4_UEV.get(1), 8000, 8000000);
	        
	        //Laser Target IV-UEV 65536/t
	        GT_Values.RA.addAssemblerRecipe(new ItemStack[]{ItemList.Hull_MAX.get(1), GT_OreDictUnificator.get(OrePrefixes.lens, Materials.Diamond, 16), ItemList.Sensor_UHV.get(16), ItemList.Electric_Pump_UHV.get(16), GT_OreDictUnificator.get(OrePrefixes.wireGt08, Materials.Europium, 8), GT_Utility.getIntegratedCircuit(5)}, null, CustomItemList.eM_energyTunnel5_UHV.get(1), 16000, 2000000);
	        GT_Values.RA.addAssemblerRecipe(new ItemStack[]{ItemList.Hull_UEV.get(1), GT_OreDictUnificator.get(OrePrefixes.lens, Materials.Diamond, 16), ItemList.Sensor_UEV.get(16), ItemList.Electric_Pump_UEV.get(16), GT_OreDictUnificator.get(OrePrefixes.wireGt08, Materials.Diamericiumtitanium, 8), GT_Utility.getIntegratedCircuit(5)}, null, CustomItemList.eM_energyTunnel5_UEV.get(1), 16000, 8000000);
	        
	        //Laser Target IV-UEV 262144/t
	        GT_Values.RA.addAssemblerRecipe(new ItemStack[]{ItemList.Hull_MAX.get(1), GT_OreDictUnificator.get(OrePrefixes.lens, Materials.Diamond, 32), ItemList.Sensor_UHV.get(32), ItemList.Electric_Pump_UHV.get(32), GT_OreDictUnificator.get(OrePrefixes.wireGt08, Materials.Europium, 16), GT_Utility.getIntegratedCircuit(6)}, null, CustomItemList.eM_energyTunnel6_UHV.get(1), 32000, 2000000);
	        GT_Values.RA.addAssemblerRecipe(new ItemStack[]{ItemList.Hull_UEV.get(1), GT_OreDictUnificator.get(OrePrefixes.lens, Materials.Diamond, 32), ItemList.Sensor_UEV.get(32), ItemList.Electric_Pump_UEV.get(32), GT_OreDictUnificator.get(OrePrefixes.wireGt08, Materials.Diamericiumtitanium, 16), GT_Utility.getIntegratedCircuit(6)}, null, CustomItemList.eM_energyTunnel6_UEV.get(1), 32000, 8000000);
	        
	        //Laser Target IV-UEV 1048576/t
	        GT_Values.RA.addAssemblerRecipe(new ItemStack[]{ItemList.Hull_MAX.get(1), GT_OreDictUnificator.get(OrePrefixes.lens, Materials.Diamond, 64), ItemList.Sensor_UHV.get(64), ItemList.Electric_Pump_UHV.get(64), GT_OreDictUnificator.get(OrePrefixes.wireGt16, Materials.Europium, 16), GT_Utility.getIntegratedCircuit(7)}, null, CustomItemList.eM_energyTunnel7_UHV.get(1), 64000, 2000000);
	        GT_Values.RA.addAssemblerRecipe(new ItemStack[]{ItemList.Hull_UEV.get(1), GT_OreDictUnificator.get(OrePrefixes.lens, Materials.Diamond, 64), ItemList.Sensor_UEV.get(64), ItemList.Electric_Pump_UEV.get(64), GT_OreDictUnificator.get(OrePrefixes.wireGt16, Materials.Diamericiumtitanium, 16), GT_Utility.getIntegratedCircuit(7)}, null, CustomItemList.eM_energyTunnel7_UEV.get(1), 64000, 8000000);
	        
//####################################################################################################################################################################################################################################################################################################################################################################################################

	      //region multi blocks
	        
	      //Active Transformer
	        GT_Values.RA.addAssemblerRecipe(new ItemStack[]{
	        		ItemList.WetTransformer_ZPM_LuV.get(1),
	        		GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Energy, 1),
	                GT_OreDictUnificator.get(OrePrefixes.wireGt01, Materials.SuperconductorLuV, 16),
	                ItemList.Circuit_Chip_UHPIC.get(2),
	        }, Materials.TungstenSteel.getMolten(576), CustomItemList.Machine_Multi_Transformer.get(1), 400, 30720);
	        
	      //Essentia Quantizer
	        TT_recipeAdder.addResearchableAssemblylineRecipe(CustomItemList.Machine_Multi_MatterToEM.get(1),
	                15000,32, 500000, 8, new ItemStack[]{
	                CustomItemList.Machine_Multi_MatterToEM.get(1),
	                GT_OreDictUnificator.get(OrePrefixes.pipeMedium, Materials.Neutronium, 4),
	                ItemList.Emitter_UV.get(2),
	                ItemList.Circuit_Wetwaresupercomputer.get(1),
	                GT_OreDictUnificator.get(OrePrefixes.cableGt02, Materials.Diamericiumtitanium, 2),
	        }, new FluidStack[]{
	                Materials.UUMatter.getFluid(2000),
	                Materials.Silver.getMolten(2592),
	                new FluidStack(FluidRegistry.getFluid("ic2coolant"), 4000),
	                Materials.Osmium.getMolten(1296),
	        }, CustomItemList.Machine_Multi_EssentiaToEM.get(1), 24000, 500000);

	        //Essentia DeQuantizer
	        TT_recipeAdder.addResearchableAssemblylineRecipe(CustomItemList.Machine_Multi_EMToMatter.get(1),
	                15000,32, 500000, 8,  new ItemStack[]{
	                CustomItemList.Machine_Multi_EMToMatter.get(1),
	                GT_OreDictUnificator.get(OrePrefixes.pipeMedium, Materials.Neutronium, 4),
	                ItemList.Sensor_UV.get(2),
	                ItemList.Circuit_Wetwaresupercomputer.get(1),
	                GT_OreDictUnificator.get(OrePrefixes.cableGt02, Materials.Diamericiumtitanium, 2),
	        }, new FluidStack[]{
	                Materials.UUMatter.getFluid(2000),
	                Materials.Silver.getMolten(2592),
	                new FluidStack(FluidRegistry.getFluid("ic2coolant"), 4000),
	                Materials.Osmium.getMolten(1296),
	        }, CustomItemList.Machine_Multi_EMToEssentia.get(1), 24000, 500000);

	        //EM Scanner
	        TT_recipeAdder.addResearchableAssemblylineRecipe(CustomItemList.Machine_Multi_Research.get(1),
	                150000,128, 500000, 16,  new ItemStack[]{
	                        CustomItemList.Machine_Multi_EMjunction.get(1),
	                        CustomItemList.eM_Computer_Bus.get(4),
	                        ItemList.Field_Generator_UV.get(4),
	                        ItemList.Sensor_UV.get(4),
	                        GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Nano, 4),
	                        GT_OreDictUnificator.get(OrePrefixes.lens, Materials.MysteriousCrystal, 4),
	                        GT_OreDictUnificator.get(OrePrefixes.cableGt02, Materials.Diamericiumtitanium, 4),
	                }, new FluidStack[]{
	                        Materials.UUMatter.getFluid(2000),
	                        Materials.Neutronium.getMolten(2592),
	                        new FluidStack(FluidRegistry.getFluid("ic2coolant"), 4000),
	                        Materials.Osmiridium.getMolten(1296),
	                }, CustomItemList.Machine_Multi_Scanner.get(1), 24000, 500000);
	        

	 }	 
}
