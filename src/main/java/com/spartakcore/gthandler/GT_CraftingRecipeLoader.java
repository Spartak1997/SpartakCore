package com.spartakcore.gthandler;

import static gregtech.api.util.GT_ModHandler.RecipeBits.DELETE_ALL_OTHER_RECIPES;

import cpw.mods.fml.common.Loader;
import gregtech.GT_Mod;
import gregtech.api.enums.Dyes;
import gregtech.api.enums.GT_Values;
import gregtech.api.enums.ItemList;
import gregtech.api.enums.Materials;
import gregtech.api.enums.OreDictNames;
import gregtech.api.enums.OrePrefixes;
import gregtech.api.enums.ToolDictNames;
import gregtech.api.util.GT_Log;
import gregtech.api.util.GT_ModHandler;
import gregtech.api.util.GT_OreDictUnificator;
import gregtech.common.GT_Proxy;
import ic2.core.Ic2Items;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

public class GT_CraftingRecipeLoader extends gregtech.loaders.postload.GT_CraftingRecipeLoader implements Runnable {

	private static final String aTextWire1 = "wire."; private static final String aTextCable1 = "cable."; private static final String aTextWire2 = " Wire"; private static final String aTextCable2 = " Cable";
    private final static String aTextPlate = "PPP"; private final static String aTextPlateWrench = "PwP"; private final static String aTextPlateMotor = "PMP"; private final static String aTextCableHull = "CMC";
    private final static String aTextWireHull = "WMW"; private final static String aTextWireChest = "WTW"; private final static String aTextWireCoil = "WCW"; private final static String aTextMotorWire = "EWE";
    private final static String aTextWirePump = "WPW";
	private static final String aTextRailcraft = "Railcraft";
    private static final String aTextMachineBeta = "machine.beta";
    private static final String aTextMachineAlpha = "machine.alpha";
    private static final String aTextIron1 = "X X";
    private static final String aTextIron2 = "XXX";
    private final static String aTextForestry = "Forestry";
    private static final long bits = GT_ModHandler.RecipeBits.NOT_REMOVABLE | GT_ModHandler.RecipeBits.REVERSIBLE | GT_ModHandler.RecipeBits.DISMANTLEABLE | GT_ModHandler.RecipeBits.BUFFERED;
    private static final long bits2 = GT_ModHandler.RecipeBits.NOT_REMOVABLE | GT_ModHandler.RecipeBits.REVERSIBLE | GT_ModHandler.RecipeBits.DISMANTLEABLE | GT_ModHandler.RecipeBits.BUFFERED | DELETE_ALL_OTHER_RECIPES;
    private static final long tBitMask = GT_ModHandler.RecipeBits.BUFFERED | GT_ModHandler.RecipeBits.NOT_REMOVABLE | GT_ModHandler.RecipeBits.REVERSIBLE;

    @Override
    public void run() {
    	
    	if (Loader.isModLoaded("miscutils")){
    		
    	}else {
    	GT_ModHandler.addCraftingRecipe(ItemList.Casing_IV.get(1L, new Object[0]), bits, new Object[]{aTextPlate, aTextPlateWrench, aTextPlate, 'P', OrePrefixes.plate.get(Materials.TungstenSteel)});
        GT_ModHandler.addCraftingRecipe(ItemList.Casing_LuV.get(1L, new Object[0]), bits, new Object[]{aTextPlate, aTextPlateWrench, aTextPlate, 'P', OrePrefixes.plate.get(Materials.Chrome)});
        GT_ModHandler.addCraftingRecipe(ItemList.Casing_ZPM.get(1L, new Object[0]), bits, new Object[]{aTextPlate, aTextPlateWrench, aTextPlate, 'P', OrePrefixes.plate.get(Materials.Iridium)});
        GT_ModHandler.addCraftingRecipe(ItemList.Casing_UV.get(1L, new Object[0]), bits, new Object[]{aTextPlate, aTextPlateWrench, aTextPlate, 'P', OrePrefixes.plate.get(Materials.Osmium)});
    	
        GT_ModHandler.addCraftingRecipe(ItemList.Hull_IV.get(1L, new Object[0]),  GT_ModHandler.RecipeBits.REVERSIBLE, new Object[]{aTextCableHull, 'M', ItemList.Casing_IV, 'C', OrePrefixes.cableGt01.get(Materials.Tungsten), 'H', OrePrefixes.plate.get(Materials.TungstenSteel), 'P', OrePrefixes.plate.get(Materials.Polytetrafluoroethylene)});
        GT_ModHandler.addCraftingRecipe(ItemList.Hull_LuV.get(1L, new Object[0]), GT_ModHandler.RecipeBits.REVERSIBLE, new Object[]{aTextCableHull, 'M', ItemList.Casing_LuV, 'C', OrePrefixes.cableGt01.get(Materials.VanadiumGallium), 'H', OrePrefixes.plate.get(Materials.Chrome), 'P', OrePrefixes.plate.get(Materials.Polytetrafluoroethylene)});
        GT_ModHandler.addCraftingRecipe(ItemList.Hull_ZPM.get(1L, new Object[0]), GT_ModHandler.RecipeBits.REVERSIBLE, new Object[]{aTextCableHull, 'M', ItemList.Casing_ZPM, 'C', OrePrefixes.cableGt01.get(Materials.Naquadah), 'H', OrePrefixes.plate.get(Materials.Iridium), 'P', OrePrefixes.plate.get(Materials.Polybenzimidazole)});
        GT_ModHandler.addCraftingRecipe(ItemList.Hull_UV.get(1L, new Object[0]),  GT_ModHandler.RecipeBits.REVERSIBLE, new Object[]{aTextCableHull, 'M', ItemList.Casing_UV, 'C', OrePrefixes.cableGt04.get(Materials.NaquadahAlloy), 'H', OrePrefixes.plate.get(Materials.Osmium), 'P', OrePrefixes.plate.get(Materials.Polybenzimidazole)});
        
        GT_ModHandler.removeRecipeByOutput(ItemList.Hull_IV.get(1L, new Object[0]));
        GT_ModHandler.removeRecipeByOutput(ItemList.Hull_LuV.get(1L, new Object[0]));
        GT_ModHandler.removeRecipeByOutput(ItemList.Hull_ZPM.get(1L, new Object[0]));
        GT_ModHandler.removeRecipeByOutput(ItemList.Hull_UV.get(1L, new Object[0]));
        
        if (GT_Mod.gregtechproxy.mHardMachineCasings) {
        	GT_ModHandler.addCraftingRecipe(ItemList.Hull_IV.get(1L, new Object[0]), GT_ModHandler.RecipeBits.NOT_REMOVABLE | GT_ModHandler.RecipeBits.BUFFERED, new Object[]{"PHP", aTextCableHull, 'M', ItemList.Casing_IV, 'C', OrePrefixes.cableGt01.get(Materials.Tungsten), 'H', OrePrefixes.plate.get(Materials.TungstenSteel), 'P', OrePrefixes.plate.get(Materials.Polytetrafluoroethylene)});
            GT_ModHandler.addCraftingRecipe(ItemList.Hull_LuV.get(1L, new Object[0]), GT_ModHandler.RecipeBits.NOT_REMOVABLE | GT_ModHandler.RecipeBits.BUFFERED, new Object[]{"PHP", aTextCableHull, 'M', ItemList.Casing_LuV, 'C', OrePrefixes.cableGt01.get(Materials.VanadiumGallium), 'H', OrePrefixes.plate.get(Materials.Chrome), 'P', OrePrefixes.plate.get(Materials.Polytetrafluoroethylene)});
            GT_ModHandler.addCraftingRecipe(ItemList.Hull_ZPM.get(1L, new Object[0]), GT_ModHandler.RecipeBits.NOT_REMOVABLE | GT_ModHandler.RecipeBits.BUFFERED, new Object[]{"PHP", aTextCableHull, 'M', ItemList.Casing_ZPM, 'C', OrePrefixes.cableGt01.get(Materials.Naquadah), 'H', OrePrefixes.plate.get(Materials.Iridium), 'P', OrePrefixes.plate.get(Materials.Polybenzimidazole)});
            GT_ModHandler.addCraftingRecipe(ItemList.Hull_UV.get(1L, new Object[0]), GT_ModHandler.RecipeBits.NOT_REMOVABLE | GT_ModHandler.RecipeBits.BUFFERED, new Object[]{"PHP", aTextCableHull, 'M', ItemList.Casing_UV, 'C', OrePrefixes.cableGt04.get(Materials.NaquadahAlloy), 'H', OrePrefixes.plate.get(Materials.Osmium), 'P', OrePrefixes.plate.get(Materials.Polybenzimidazole)});
        }else {
        	GT_ModHandler.addCraftingRecipe(ItemList.Hull_IV.get(1L, new Object[0]), GT_ModHandler.RecipeBits.NOT_REMOVABLE | GT_ModHandler.RecipeBits.BUFFERED, new Object[]{aTextCableHull, 'M', ItemList.Casing_IV, 'C', OrePrefixes.cableGt01.get(Materials.Tungsten)});
            GT_ModHandler.addCraftingRecipe(ItemList.Hull_LuV.get(1L, new Object[0]), GT_ModHandler.RecipeBits.NOT_REMOVABLE | GT_ModHandler.RecipeBits.BUFFERED, new Object[]{aTextCableHull, 'M', ItemList.Casing_LuV, 'C', OrePrefixes.cableGt01.get(Materials.VanadiumGallium)});
            GT_ModHandler.addCraftingRecipe(ItemList.Hull_ZPM.get(1L, new Object[0]), GT_ModHandler.RecipeBits.NOT_REMOVABLE | GT_ModHandler.RecipeBits.BUFFERED, new Object[]{aTextCableHull, 'M', ItemList.Casing_ZPM, 'C', OrePrefixes.cableGt01.get(Materials.Naquadah)});
            GT_ModHandler.addCraftingRecipe(ItemList.Hull_UV.get(1L, new Object[0]), GT_ModHandler.RecipeBits.NOT_REMOVABLE | GT_ModHandler.RecipeBits.BUFFERED, new Object[]{aTextCableHull, 'M', ItemList.Casing_UV, 'C', OrePrefixes.cableGt04.get(Materials.NaquadahAlloy)});
        }
        
    	}
    	
    	Object[] o = new Object[0];
    	
    	//###Components###\\
    	
    	if(GT_Mod.gregtechproxy.mComponentAssembler){
    		//===Motors===\\
        	GT_ModHandler.addCraftingRecipe(CustomItemList.ULVMotor.get(1L, new Object[0]), GT_ModHandler.RecipeBits.DISMANTLEABLE | GT_ModHandler.RecipeBits.NOT_REMOVABLE | GT_ModHandler.RecipeBits.REVERSIBLE, new Object[]{"CWR", "WIW", "RWC", 'I', OrePrefixes.stick.get(Materials.IronMagnetic), 'R', OrePrefixes.stick.get(Materials.Iron), 'W', OrePrefixes.wireGt01.get(Materials.Tin), 'C', OrePrefixes.cableGt01.get(Materials.Lead)});
        	
        	//===Pistons===\\
            GT_ModHandler.addCraftingRecipe(CustomItemList.ULVPiston.get(1L, new Object[0]), GT_ModHandler.RecipeBits.DISMANTLEABLE | GT_ModHandler.RecipeBits.NOT_REMOVABLE | GT_ModHandler.RecipeBits.REVERSIBLE, new Object[]{"PPP", "CSS", "CMG", 'P', OrePrefixes.plate.get(Materials.WroughtIron), 'S', OrePrefixes.stick.get(Materials.WroughtIron), 'G', OrePrefixes.gearGtSmall.get(Materials.WroughtIron), 'M', CustomItemList.ULVMotor, 'C', OrePrefixes.cableGt01.get(Materials.Lead)});
            
    		//===RobotArms===\\
            GT_ModHandler.addCraftingRecipe(CustomItemList.ULVRobotArm.get(1L, new Object[0]), GT_ModHandler.RecipeBits.DISMANTLEABLE | GT_ModHandler.RecipeBits.NOT_REMOVABLE | GT_ModHandler.RecipeBits.REVERSIBLE, new Object[]{"CCC", "MSM", "PES", 'S', OrePrefixes.stick.get(Materials.WroughtIron), 'M', CustomItemList.ULVMotor, 'P', CustomItemList.ULVPiston, 'E', OrePrefixes.circuit.get(Materials.Primitive), 'C', OrePrefixes.cableGt01.get(Materials.Lead)});
            
    	}else {
    	//===Motors===\\
    	GT_ModHandler.addCraftingRecipe(CustomItemList.ULVMotor.get(1L, new Object[0]), GT_ModHandler.RecipeBits.DISMANTLEABLE | GT_ModHandler.RecipeBits.NOT_REMOVABLE | GT_ModHandler.RecipeBits.REVERSIBLE, new Object[]{"CWR", "WIW", "RWC", 'I', OrePrefixes.stick.get(Materials.IronMagnetic), 'R', OrePrefixes.stick.get(Materials.Iron), 'W', OrePrefixes.wireGt01.get(Materials.Tin), 'C', OrePrefixes.cableGt01.get(Materials.Lead)});
    	GT_ModHandler.addCraftingRecipe(ItemList.Electric_Motor_LV.get(1L, new Object[0]), GT_ModHandler.RecipeBits.DISMANTLEABLE | GT_ModHandler.RecipeBits.NOT_REMOVABLE | GT_ModHandler.RecipeBits.REVERSIBLE, new Object[]{"CWR", "WIW", "RWC", 'I', OrePrefixes.stick.get(Materials.IronMagnetic), 'R', OrePrefixes.stick.get(Materials.Iron), 'W', OrePrefixes.wireGt01.get(Materials.Copper), 'C', OrePrefixes.cableGt01.get(Materials.Tin)});
        GT_ModHandler.addCraftingRecipe(ItemList.Electric_Motor_LV.get(1L, new Object[0]), GT_ModHandler.RecipeBits.DISMANTLEABLE | GT_ModHandler.RecipeBits.NOT_REMOVABLE | GT_ModHandler.RecipeBits.REVERSIBLE, new Object[]{"CWR", "WIW", "RWC", 'I', OrePrefixes.stick.get(Materials.SteelMagnetic), 'R', OrePrefixes.stick.get(Materials.Steel), 'W', OrePrefixes.wireGt01.get(Materials.Copper), 'C', OrePrefixes.cableGt01.get(Materials.Tin)});
        GT_ModHandler.addCraftingRecipe(ItemList.Electric_Motor_MV.get(1L, new Object[0]), GT_ModHandler.RecipeBits.DISMANTLEABLE | GT_ModHandler.RecipeBits.NOT_REMOVABLE | GT_ModHandler.RecipeBits.REVERSIBLE, new Object[]{"CWR", "WIW", "RWC", 'I', OrePrefixes.stick.get(Materials.SteelMagnetic), 'R', OrePrefixes.stick.get(Materials.Aluminium), 'W', OrePrefixes.wireGt02.get(Materials.Cupronickel), 'C', OrePrefixes.cableGt01.get(Materials.Copper)});
        GT_ModHandler.addCraftingRecipe(ItemList.Electric_Motor_HV.get(1L, new Object[0]), GT_ModHandler.RecipeBits.DISMANTLEABLE | GT_ModHandler.RecipeBits.NOT_REMOVABLE | GT_ModHandler.RecipeBits.REVERSIBLE, new Object[]{"CWR", "WIW", "RWC", 'I', OrePrefixes.stick.get(Materials.SteelMagnetic), 'R', OrePrefixes.stick.get(Materials.StainlessSteel), 'W', OrePrefixes.wireGt04.get(Materials.Electrum), 'C', OrePrefixes.cableGt02.get(Materials.Silver)});
        GT_ModHandler.addCraftingRecipe(ItemList.Electric_Motor_EV.get(1L, new Object[0]), GT_ModHandler.RecipeBits.DISMANTLEABLE | GT_ModHandler.RecipeBits.NOT_REMOVABLE | GT_ModHandler.RecipeBits.REVERSIBLE, new Object[]{"CWR", "WIW", "RWC", 'I', OrePrefixes.stick.get(Materials.NeodymiumMagnetic), 'R', OrePrefixes.stick.get(Materials.Titanium), 'W', OrePrefixes.wireGt04.get(Materials.AnnealedCopper), 'C', OrePrefixes.cableGt02.get(Materials.Aluminium)});
        GT_ModHandler.addCraftingRecipe(ItemList.Electric_Motor_IV.get(1L, new Object[0]), GT_ModHandler.RecipeBits.DISMANTLEABLE | GT_ModHandler.RecipeBits.NOT_REMOVABLE | GT_ModHandler.RecipeBits.REVERSIBLE, new Object[]{"CWR", "WIW", "RWC", 'I', OrePrefixes.stick.get(Materials.NeodymiumMagnetic), 'R', OrePrefixes.stick.get(Materials.TungstenSteel), 'W', OrePrefixes.wireGt04.get(Materials.Graphene), 'C', OrePrefixes.cableGt02.get(Materials.Tungsten)});

        //===Pumps===\\
        GT_ModHandler.addCraftingRecipe(ItemList.Electric_Pump_LV.get(1L, new Object[0]), GT_ModHandler.RecipeBits.DISMANTLEABLE | GT_ModHandler.RecipeBits.NOT_REMOVABLE | GT_ModHandler.RecipeBits.REVERSIBLE, new Object[]{"SXO", "dPw", "OMW", 'M', ItemList.Electric_Motor_LV, 'O', OrePrefixes.ring.get(Materials.Paper ), 'X', OrePrefixes.rotor.get(Materials.Tin), 'S', OrePrefixes.screw.get(Materials.Tin), 'W', OrePrefixes.cableGt01.get(Materials.Tin), 'P', OrePrefixes.pipeMedium.get(Materials.Bronze)});
        GT_ModHandler.addCraftingRecipe(ItemList.Electric_Pump_LV.get(1L, new Object[0]), GT_ModHandler.RecipeBits.DISMANTLEABLE | GT_ModHandler.RecipeBits.NOT_REMOVABLE | GT_ModHandler.RecipeBits.REVERSIBLE, new Object[]{"SXO", "dPw", "OMW", 'M', ItemList.Electric_Motor_LV, 'O', OrePrefixes.ring.get(Materials.Rubber), 'X', OrePrefixes.rotor.get(Materials.Tin), 'S', OrePrefixes.screw.get(Materials.Tin), 'W', OrePrefixes.cableGt01.get(Materials.Tin), 'P', OrePrefixes.pipeMedium.get(Materials.Bronze)});
        GT_ModHandler.addCraftingRecipe(ItemList.Electric_Pump_LV.get(1L, new Object[0]), GT_ModHandler.RecipeBits.DISMANTLEABLE | GT_ModHandler.RecipeBits.NOT_REMOVABLE | GT_ModHandler.RecipeBits.REVERSIBLE, new Object[]{"SXO", "dPw", "OMW", 'M', ItemList.Electric_Motor_LV, 'O', OrePrefixes.ring.get(Materials.StyreneButadieneRubber), 'X', OrePrefixes.rotor.get(Materials.Tin), 'S', OrePrefixes.screw.get(Materials.Tin), 'W', OrePrefixes.cableGt01.get(Materials.Tin), 'P', OrePrefixes.pipeMedium.get(Materials.Bronze)});
        GT_ModHandler.addCraftingRecipe(ItemList.Electric_Pump_LV.get(1L, new Object[0]), GT_ModHandler.RecipeBits.DISMANTLEABLE | GT_ModHandler.RecipeBits.NOT_REMOVABLE | GT_ModHandler.RecipeBits.REVERSIBLE, new Object[]{"SXO", "dPw", "OMW", 'M', ItemList.Electric_Motor_LV, 'O', OrePrefixes.ring.get(Materials.Silicone), 'X', OrePrefixes.rotor.get(Materials.Tin), 'S', OrePrefixes.screw.get(Materials.Tin), 'W', OrePrefixes.cableGt01.get(Materials.Tin), 'P', OrePrefixes.pipeMedium.get(Materials.Bronze)});
        GT_ModHandler.addCraftingRecipe(ItemList.Electric_Pump_MV.get(1L, new Object[0]), GT_ModHandler.RecipeBits.DISMANTLEABLE | GT_ModHandler.RecipeBits.NOT_REMOVABLE | GT_ModHandler.RecipeBits.REVERSIBLE, new Object[]{"SXO", "dPw", "OMW", 'M', ItemList.Electric_Motor_MV, 'O', OrePrefixes.ring.get(Materials.Rubber), 'X', OrePrefixes.rotor.get(Materials.Bronze), 'S', OrePrefixes.screw.get(Materials.Bronze), 'W', OrePrefixes.cableGt01.get(Materials.Copper), 'P', OrePrefixes.pipeMedium.get(Materials.Steel)});
        GT_ModHandler.addCraftingRecipe(ItemList.Electric_Pump_MV.get(1L, new Object[0]), GT_ModHandler.RecipeBits.DISMANTLEABLE | GT_ModHandler.RecipeBits.NOT_REMOVABLE | GT_ModHandler.RecipeBits.REVERSIBLE, new Object[]{"SXO", "dPw", "OMW", 'M', ItemList.Electric_Motor_MV, 'O', OrePrefixes.ring.get(Materials.StyreneButadieneRubber), 'X', OrePrefixes.rotor.get(Materials.Bronze), 'S', OrePrefixes.screw.get(Materials.Bronze), 'W', OrePrefixes.cableGt01.get(Materials.Copper), 'P', OrePrefixes.pipeMedium.get(Materials.Steel)});
        GT_ModHandler.addCraftingRecipe(ItemList.Electric_Pump_MV.get(1L, new Object[0]), GT_ModHandler.RecipeBits.DISMANTLEABLE | GT_ModHandler.RecipeBits.NOT_REMOVABLE | GT_ModHandler.RecipeBits.REVERSIBLE, new Object[]{"SXO", "dPw", "OMW", 'M', ItemList.Electric_Motor_MV, 'O', OrePrefixes.ring.get(Materials.Silicone), 'X', OrePrefixes.rotor.get(Materials.Bronze), 'S', OrePrefixes.screw.get(Materials.Bronze), 'W', OrePrefixes.cableGt01.get(Materials.Copper), 'P', OrePrefixes.pipeMedium.get(Materials.Steel)});
        GT_ModHandler.addCraftingRecipe(ItemList.Electric_Pump_HV.get(1L, new Object[0]), GT_ModHandler.RecipeBits.DISMANTLEABLE | GT_ModHandler.RecipeBits.NOT_REMOVABLE | GT_ModHandler.RecipeBits.REVERSIBLE, new Object[]{"SXO", "dPw", "OMW", 'M', ItemList.Electric_Motor_HV, 'O', OrePrefixes.ring.get(Materials.Rubber), 'X', OrePrefixes.rotor.get(Materials.Steel), 'S', OrePrefixes.screw.get(Materials.Steel), 'W', OrePrefixes.cableGt01.get(Materials.Gold), 'P', OrePrefixes.pipeMedium.get(Materials.StainlessSteel)});
        GT_ModHandler.addCraftingRecipe(ItemList.Electric_Pump_HV.get(1L, new Object[0]), GT_ModHandler.RecipeBits.DISMANTLEABLE | GT_ModHandler.RecipeBits.NOT_REMOVABLE | GT_ModHandler.RecipeBits.REVERSIBLE, new Object[]{"SXO", "dPw", "OMW", 'M', ItemList.Electric_Motor_HV, 'O', OrePrefixes.ring.get(Materials.StyreneButadieneRubber), 'X', OrePrefixes.rotor.get(Materials.Steel), 'S', OrePrefixes.screw.get(Materials.Steel), 'W', OrePrefixes.cableGt01.get(Materials.Gold), 'P', OrePrefixes.pipeMedium.get(Materials.StainlessSteel)});
        GT_ModHandler.addCraftingRecipe(ItemList.Electric_Pump_HV.get(1L, new Object[0]), GT_ModHandler.RecipeBits.DISMANTLEABLE | GT_ModHandler.RecipeBits.NOT_REMOVABLE | GT_ModHandler.RecipeBits.REVERSIBLE, new Object[]{"SXO", "dPw", "OMW", 'M', ItemList.Electric_Motor_HV, 'O', OrePrefixes.ring.get(Materials.Silicone), 'X', OrePrefixes.rotor.get(Materials.Steel), 'S', OrePrefixes.screw.get(Materials.Steel), 'W', OrePrefixes.cableGt01.get(Materials.Gold), 'P', OrePrefixes.pipeMedium.get(Materials.StainlessSteel)});
        GT_ModHandler.addCraftingRecipe(ItemList.Electric_Pump_EV.get(1L, new Object[0]), GT_ModHandler.RecipeBits.DISMANTLEABLE | GT_ModHandler.RecipeBits.NOT_REMOVABLE | GT_ModHandler.RecipeBits.REVERSIBLE, new Object[]{"SXO", "dPw", "OMW", 'M', ItemList.Electric_Motor_EV, 'O', OrePrefixes.ring.get(Materials.Rubber), 'X', OrePrefixes.rotor.get(Materials.StainlessSteel), 'S', OrePrefixes.screw.get(Materials.StainlessSteel), 'W', OrePrefixes.cableGt01.get(Materials.Aluminium), 'P', OrePrefixes.pipeMedium.get(Materials.Titanium)});
        GT_ModHandler.addCraftingRecipe(ItemList.Electric_Pump_EV.get(1L, new Object[0]), GT_ModHandler.RecipeBits.DISMANTLEABLE | GT_ModHandler.RecipeBits.NOT_REMOVABLE | GT_ModHandler.RecipeBits.REVERSIBLE, new Object[]{"SXO", "dPw", "OMW", 'M', ItemList.Electric_Motor_EV, 'O', OrePrefixes.ring.get(Materials.StyreneButadieneRubber), 'X', OrePrefixes.rotor.get(Materials.StainlessSteel), 'S', OrePrefixes.screw.get(Materials.StainlessSteel), 'W', OrePrefixes.cableGt01.get(Materials.Aluminium), 'P', OrePrefixes.pipeMedium.get(Materials.Titanium)});
        GT_ModHandler.addCraftingRecipe(ItemList.Electric_Pump_EV.get(1L, new Object[0]), GT_ModHandler.RecipeBits.DISMANTLEABLE | GT_ModHandler.RecipeBits.NOT_REMOVABLE | GT_ModHandler.RecipeBits.REVERSIBLE, new Object[]{"SXO", "dPw", "OMW", 'M', ItemList.Electric_Motor_EV, 'O', OrePrefixes.ring.get(Materials.Silicone), 'X', OrePrefixes.rotor.get(Materials.StainlessSteel), 'S', OrePrefixes.screw.get(Materials.StainlessSteel), 'W', OrePrefixes.cableGt01.get(Materials.Aluminium), 'P', OrePrefixes.pipeMedium.get(Materials.Titanium)});
        GT_ModHandler.addCraftingRecipe(ItemList.Electric_Pump_IV.get(1L, new Object[0]), GT_ModHandler.RecipeBits.DISMANTLEABLE | GT_ModHandler.RecipeBits.NOT_REMOVABLE | GT_ModHandler.RecipeBits.REVERSIBLE, new Object[]{"SXO", "dPw", "OMW", 'M', ItemList.Electric_Motor_IV, 'O', OrePrefixes.ring.get(Materials.StyreneButadieneRubber), 'X', OrePrefixes.rotor.get(Materials.TungstenSteel), 'S', OrePrefixes.screw.get(Materials.TungstenSteel), 'W', OrePrefixes.cableGt01.get(Materials.Tungsten), 'P', OrePrefixes.pipeMedium.get(Materials.TungstenSteel)});
        GT_ModHandler.addCraftingRecipe(ItemList.Electric_Pump_IV.get(1L, new Object[0]), GT_ModHandler.RecipeBits.DISMANTLEABLE | GT_ModHandler.RecipeBits.NOT_REMOVABLE | GT_ModHandler.RecipeBits.REVERSIBLE, new Object[]{"SXO", "dPw", "OMW", 'M', ItemList.Electric_Motor_IV, 'O', OrePrefixes.ring.get(Materials.Silicone), 'X', OrePrefixes.rotor.get(Materials.TungstenSteel), 'S', OrePrefixes.screw.get(Materials.TungstenSteel), 'W', OrePrefixes.cableGt01.get(Materials.Tungsten), 'P', OrePrefixes.pipeMedium.get(Materials.TungstenSteel)});

        //===Conveyors===\\
        GT_ModHandler.addCraftingRecipe(ItemList.Conveyor_Module_LV.get(1L, new Object[0]), GT_ModHandler.RecipeBits.DISMANTLEABLE | GT_ModHandler.RecipeBits.NOT_REMOVABLE | GT_ModHandler.RecipeBits.REVERSIBLE, new Object[]{"RRR", "MCM", "RRR", 'M', ItemList.Electric_Motor_LV, 'C', OrePrefixes.cableGt01.get(Materials.Tin), 'R', OrePrefixes.plate.get(Materials.Rubber)});
        GT_ModHandler.addCraftingRecipe(ItemList.Conveyor_Module_LV.get(1L, new Object[0]), GT_ModHandler.RecipeBits.DISMANTLEABLE | GT_ModHandler.RecipeBits.NOT_REMOVABLE | GT_ModHandler.RecipeBits.REVERSIBLE, new Object[]{"RRR", "MCM", "RRR", 'M', ItemList.Electric_Motor_LV, 'C', OrePrefixes.cableGt01.get(Materials.Tin), 'R', OrePrefixes.plate.get(Materials.StyreneButadieneRubber)});
        GT_ModHandler.addCraftingRecipe(ItemList.Conveyor_Module_LV.get(1L, new Object[0]), GT_ModHandler.RecipeBits.DISMANTLEABLE | GT_ModHandler.RecipeBits.NOT_REMOVABLE | GT_ModHandler.RecipeBits.REVERSIBLE, new Object[]{"RRR", "MCM", "RRR", 'M', ItemList.Electric_Motor_LV, 'C', OrePrefixes.cableGt01.get(Materials.Tin), 'R', OrePrefixes.plate.get(Materials.Silicone)});
        GT_ModHandler.addCraftingRecipe(ItemList.Conveyor_Module_MV.get(1L, new Object[0]), GT_ModHandler.RecipeBits.DISMANTLEABLE | GT_ModHandler.RecipeBits.NOT_REMOVABLE | GT_ModHandler.RecipeBits.REVERSIBLE, new Object[]{"RRR", "MCM", "RRR", 'M', ItemList.Electric_Motor_MV, 'C', OrePrefixes.cableGt01.get(Materials.Copper), 'R', OrePrefixes.plate.get(Materials.Rubber)});
        GT_ModHandler.addCraftingRecipe(ItemList.Conveyor_Module_MV.get(1L, new Object[0]), GT_ModHandler.RecipeBits.DISMANTLEABLE | GT_ModHandler.RecipeBits.NOT_REMOVABLE | GT_ModHandler.RecipeBits.REVERSIBLE, new Object[]{"RRR", "MCM", "RRR", 'M', ItemList.Electric_Motor_MV, 'C', OrePrefixes.cableGt01.get(Materials.Copper), 'R', OrePrefixes.plate.get(Materials.StyreneButadieneRubber)});
        GT_ModHandler.addCraftingRecipe(ItemList.Conveyor_Module_MV.get(1L, new Object[0]), GT_ModHandler.RecipeBits.DISMANTLEABLE | GT_ModHandler.RecipeBits.NOT_REMOVABLE | GT_ModHandler.RecipeBits.REVERSIBLE, new Object[]{"RRR", "MCM", "RRR", 'M', ItemList.Electric_Motor_MV, 'C', OrePrefixes.cableGt01.get(Materials.Copper), 'R', OrePrefixes.plate.get(Materials.Silicone)});
        GT_ModHandler.addCraftingRecipe(ItemList.Conveyor_Module_HV.get(1L, new Object[0]), GT_ModHandler.RecipeBits.DISMANTLEABLE | GT_ModHandler.RecipeBits.NOT_REMOVABLE | GT_ModHandler.RecipeBits.REVERSIBLE, new Object[]{"RRR", "MCM", "RRR", 'M', ItemList.Electric_Motor_HV, 'C', OrePrefixes.cableGt01.get(Materials.Gold), 'R', OrePrefixes.plate.get(Materials.Rubber)});
        GT_ModHandler.addCraftingRecipe(ItemList.Conveyor_Module_HV.get(1L, new Object[0]), GT_ModHandler.RecipeBits.DISMANTLEABLE | GT_ModHandler.RecipeBits.NOT_REMOVABLE | GT_ModHandler.RecipeBits.REVERSIBLE, new Object[]{"RRR", "MCM", "RRR", 'M', ItemList.Electric_Motor_HV, 'C', OrePrefixes.cableGt01.get(Materials.Gold), 'R', OrePrefixes.plate.get(Materials.StyreneButadieneRubber)});
        GT_ModHandler.addCraftingRecipe(ItemList.Conveyor_Module_HV.get(1L, new Object[0]), GT_ModHandler.RecipeBits.DISMANTLEABLE | GT_ModHandler.RecipeBits.NOT_REMOVABLE | GT_ModHandler.RecipeBits.REVERSIBLE, new Object[]{"RRR", "MCM", "RRR", 'M', ItemList.Electric_Motor_HV, 'C', OrePrefixes.cableGt01.get(Materials.Gold), 'R', OrePrefixes.plate.get(Materials.Silicone)});
        GT_ModHandler.addCraftingRecipe(ItemList.Conveyor_Module_EV.get(1L, new Object[0]), GT_ModHandler.RecipeBits.DISMANTLEABLE | GT_ModHandler.RecipeBits.NOT_REMOVABLE | GT_ModHandler.RecipeBits.REVERSIBLE, new Object[]{"RRR", "MCM", "RRR", 'M', ItemList.Electric_Motor_EV, 'C', OrePrefixes.cableGt01.get(Materials.Aluminium), 'R', OrePrefixes.plate.get(Materials.Rubber)});
        GT_ModHandler.addCraftingRecipe(ItemList.Conveyor_Module_EV.get(1L, new Object[0]), GT_ModHandler.RecipeBits.DISMANTLEABLE | GT_ModHandler.RecipeBits.NOT_REMOVABLE | GT_ModHandler.RecipeBits.REVERSIBLE, new Object[]{"RRR", "MCM", "RRR", 'M', ItemList.Electric_Motor_EV, 'C', OrePrefixes.cableGt01.get(Materials.Aluminium), 'R', OrePrefixes.plate.get(Materials.StyreneButadieneRubber)});
        GT_ModHandler.addCraftingRecipe(ItemList.Conveyor_Module_EV.get(1L, new Object[0]), GT_ModHandler.RecipeBits.DISMANTLEABLE | GT_ModHandler.RecipeBits.NOT_REMOVABLE | GT_ModHandler.RecipeBits.REVERSIBLE, new Object[]{"RRR", "MCM", "RRR", 'M', ItemList.Electric_Motor_EV, 'C', OrePrefixes.cableGt01.get(Materials.Aluminium), 'R', OrePrefixes.plate.get(Materials.Silicone)});
        GT_ModHandler.addCraftingRecipe(ItemList.Conveyor_Module_IV.get(1L, new Object[0]), GT_ModHandler.RecipeBits.DISMANTLEABLE | GT_ModHandler.RecipeBits.NOT_REMOVABLE | GT_ModHandler.RecipeBits.REVERSIBLE, new Object[]{"RRR", "MCM", "RRR", 'M', ItemList.Electric_Motor_IV, 'C', OrePrefixes.cableGt01.get(Materials.Tungsten), 'R', OrePrefixes.plate.get(Materials.StyreneButadieneRubber)});
        GT_ModHandler.addCraftingRecipe(ItemList.Conveyor_Module_IV.get(1L, new Object[0]), GT_ModHandler.RecipeBits.DISMANTLEABLE | GT_ModHandler.RecipeBits.NOT_REMOVABLE | GT_ModHandler.RecipeBits.REVERSIBLE, new Object[]{"RRR", "MCM", "RRR", 'M', ItemList.Electric_Motor_IV, 'C', OrePrefixes.cableGt01.get(Materials.Tungsten), 'R', OrePrefixes.plate.get(Materials.Silicone)});

        //===Pistons===\\
        GT_ModHandler.addCraftingRecipe(CustomItemList.ULVPiston.get(1L, new Object[0]), GT_ModHandler.RecipeBits.DISMANTLEABLE | GT_ModHandler.RecipeBits.NOT_REMOVABLE | GT_ModHandler.RecipeBits.REVERSIBLE, new Object[]{"PPP", "CSS", "CMG", 'P', OrePrefixes.plate.get(Materials.WroughtIron), 'S', OrePrefixes.stick.get(Materials.WroughtIron), 'G', OrePrefixes.gearGtSmall.get(Materials.WroughtIron), 'M', CustomItemList.ULVMotor, 'C', OrePrefixes.cableGt01.get(Materials.Lead)});
        GT_ModHandler.addCraftingRecipe(ItemList.Electric_Piston_LV.get(1L, new Object[0]), GT_ModHandler.RecipeBits.DISMANTLEABLE | GT_ModHandler.RecipeBits.NOT_REMOVABLE | GT_ModHandler.RecipeBits.REVERSIBLE, new Object[]{"PPP", "CSS", "CMG", 'P', OrePrefixes.plate.get(Materials.Steel), 'S', OrePrefixes.stick.get(Materials.Steel), 'G', OrePrefixes.gearGtSmall.get(Materials.Steel), 'M', ItemList.Electric_Motor_LV, 'C', OrePrefixes.cableGt01.get(Materials.Tin)});
        GT_ModHandler.addCraftingRecipe(ItemList.Electric_Piston_MV.get(1L, new Object[0]), GT_ModHandler.RecipeBits.DISMANTLEABLE | GT_ModHandler.RecipeBits.NOT_REMOVABLE | GT_ModHandler.RecipeBits.REVERSIBLE, new Object[]{"PPP", "CSS", "CMG", 'P', OrePrefixes.plate.get(Materials.Aluminium), 'S', OrePrefixes.stick.get(Materials.Aluminium), 'G', OrePrefixes.gearGtSmall.get(Materials.Aluminium), 'M', ItemList.Electric_Motor_MV, 'C', OrePrefixes.cableGt01.get(Materials.Copper)});
        GT_ModHandler.addCraftingRecipe(ItemList.Electric_Piston_HV.get(1L, new Object[0]), GT_ModHandler.RecipeBits.DISMANTLEABLE | GT_ModHandler.RecipeBits.NOT_REMOVABLE | GT_ModHandler.RecipeBits.REVERSIBLE, new Object[]{"PPP", "CSS", "CMG", 'P', OrePrefixes.plate.get(Materials.StainlessSteel), 'S', OrePrefixes.stick.get(Materials.StainlessSteel), 'G', OrePrefixes.gearGtSmall.get(Materials.StainlessSteel), 'M', ItemList.Electric_Motor_HV, 'C', OrePrefixes.cableGt01.get(Materials.Gold)});
        GT_ModHandler.addCraftingRecipe(ItemList.Electric_Piston_EV.get(1L, new Object[0]), GT_ModHandler.RecipeBits.DISMANTLEABLE | GT_ModHandler.RecipeBits.NOT_REMOVABLE | GT_ModHandler.RecipeBits.REVERSIBLE, new Object[]{"PPP", "CSS", "CMG", 'P', OrePrefixes.plate.get(Materials.Titanium), 'S', OrePrefixes.stick.get(Materials.Titanium), 'G', OrePrefixes.gearGtSmall.get(Materials.Titanium), 'M', ItemList.Electric_Motor_EV, 'C', OrePrefixes.cableGt01.get(Materials.Aluminium)});
        GT_ModHandler.addCraftingRecipe(ItemList.Electric_Piston_IV.get(1L, new Object[0]), GT_ModHandler.RecipeBits.DISMANTLEABLE | GT_ModHandler.RecipeBits.NOT_REMOVABLE | GT_ModHandler.RecipeBits.REVERSIBLE, new Object[]{"PPP", "CSS", "CMG", 'P', OrePrefixes.plate.get(Materials.TungstenSteel), 'S', OrePrefixes.stick.get(Materials.TungstenSteel), 'G', OrePrefixes.gearGtSmall.get(Materials.TungstenSteel), 'M', ItemList.Electric_Motor_IV, 'C', OrePrefixes.cableGt01.get(Materials.Tungsten)});

        //===RobotArms===\\
        GT_ModHandler.addCraftingRecipe(CustomItemList.ULVRobotArm.get(1L, new Object[0]), GT_ModHandler.RecipeBits.DISMANTLEABLE | GT_ModHandler.RecipeBits.NOT_REMOVABLE | GT_ModHandler.RecipeBits.REVERSIBLE, new Object[]{"CCC", "MSM", "PES", 'S', OrePrefixes.stick.get(Materials.WroughtIron), 'M', CustomItemList.ULVMotor, 'P', CustomItemList.ULVPiston, 'E', OrePrefixes.circuit.get(Materials.Primitive), 'C', OrePrefixes.cableGt01.get(Materials.Lead)});
        GT_ModHandler.addCraftingRecipe(ItemList.Robot_Arm_LV.get(1L, new Object[0]), GT_ModHandler.RecipeBits.DISMANTLEABLE | GT_ModHandler.RecipeBits.NOT_REMOVABLE | GT_ModHandler.RecipeBits.REVERSIBLE, new Object[]{"CCC", "MSM", "PES", 'S', OrePrefixes.stick.get(Materials.Steel), 'M', ItemList.Electric_Motor_LV, 'P', ItemList.Electric_Piston_LV, 'E', OrePrefixes.circuit.get(Materials.Basic), 'C', OrePrefixes.cableGt01.get(Materials.Tin)});
        GT_ModHandler.addCraftingRecipe(ItemList.Robot_Arm_MV.get(1L, new Object[0]), GT_ModHandler.RecipeBits.DISMANTLEABLE | GT_ModHandler.RecipeBits.NOT_REMOVABLE | GT_ModHandler.RecipeBits.REVERSIBLE, new Object[]{"CCC", "MSM", "PES", 'S', OrePrefixes.stick.get(Materials.Aluminium), 'M', ItemList.Electric_Motor_MV, 'P', ItemList.Electric_Piston_MV, 'E', OrePrefixes.circuit.get(Materials.Good), 'C', OrePrefixes.cableGt01.get(Materials.Copper)});
        GT_ModHandler.addCraftingRecipe(ItemList.Robot_Arm_HV.get(1L, new Object[0]), GT_ModHandler.RecipeBits.DISMANTLEABLE | GT_ModHandler.RecipeBits.NOT_REMOVABLE | GT_ModHandler.RecipeBits.REVERSIBLE, new Object[]{"CCC", "MSM", "PES", 'S', OrePrefixes.stick.get(Materials.StainlessSteel), 'M', ItemList.Electric_Motor_HV, 'P', ItemList.Electric_Piston_HV, 'E', OrePrefixes.circuit.get(Materials.Advanced), 'C', OrePrefixes.cableGt01.get(Materials.Gold)});
        GT_ModHandler.addCraftingRecipe(ItemList.Robot_Arm_EV.get(1L, new Object[0]), GT_ModHandler.RecipeBits.DISMANTLEABLE | GT_ModHandler.RecipeBits.NOT_REMOVABLE | GT_ModHandler.RecipeBits.REVERSIBLE, new Object[]{"CCC", "MSM", "PES", 'S', OrePrefixes.stick.get(Materials.Titanium), 'M', ItemList.Electric_Motor_EV, 'P', ItemList.Electric_Piston_EV, 'E', OrePrefixes.circuit.get(Materials.Data), 'C', OrePrefixes.cableGt01.get(Materials.Aluminium)});
        GT_ModHandler.addCraftingRecipe(ItemList.Robot_Arm_IV.get(1L, new Object[0]), GT_ModHandler.RecipeBits.DISMANTLEABLE | GT_ModHandler.RecipeBits.NOT_REMOVABLE | GT_ModHandler.RecipeBits.REVERSIBLE, new Object[]{"CCC", "MSM", "PES", 'S', OrePrefixes.stick.get(Materials.TungstenSteel), 'M', ItemList.Electric_Motor_IV, 'P', ItemList.Electric_Piston_IV, 'E', OrePrefixes.circuit.get(Materials.Elite), 'C', OrePrefixes.cableGt01.get(Materials.Tungsten)});

        //===Emitters===\\
        GT_ModHandler.addCraftingRecipe(ItemList.Emitter_LV.get(1L, new Object[0]), GT_ModHandler.RecipeBits.DISMANTLEABLE | GT_ModHandler.RecipeBits.NOT_REMOVABLE | GT_ModHandler.RecipeBits.REVERSIBLE, new Object[]{"SSC", "WQS", "CWS", 'Q', OrePrefixes.gem.get(Materials.CertusQuartz), 'S', OrePrefixes.stick.get(Materials.Brass), 'C', OrePrefixes.circuit.get(Materials.Basic), 'W', OrePrefixes.cableGt01.get(Materials.Tin)});
        GT_ModHandler.addCraftingRecipe(ItemList.Emitter_MV.get(1L, new Object[0]), GT_ModHandler.RecipeBits.DISMANTLEABLE | GT_ModHandler.RecipeBits.NOT_REMOVABLE | GT_ModHandler.RecipeBits.REVERSIBLE, new Object[]{"SSC", "WQS", "CWS", 'Q', OrePrefixes.gem.get(Materials.NetherQuartz), 'S', OrePrefixes.stick.get(Materials.Electrum), 'C', OrePrefixes.circuit.get(Materials.Good), 'W', OrePrefixes.cableGt01.get(Materials.Copper)});
        GT_ModHandler.addCraftingRecipe(ItemList.Emitter_HV.get(1L, new Object[0]), GT_ModHandler.RecipeBits.DISMANTLEABLE | GT_ModHandler.RecipeBits.NOT_REMOVABLE | GT_ModHandler.RecipeBits.REVERSIBLE, new Object[]{"SSC", "WQS", "CWS", 'Q', OrePrefixes.gemFlawed.get(Materials.Emerald), 'S', OrePrefixes.stick.get(Materials.Chrome), 'C', OrePrefixes.circuit.get(Materials.Advanced), 'W', OrePrefixes.cableGt01.get(Materials.Gold)});
        GT_ModHandler.addCraftingRecipe(ItemList.Emitter_EV.get(1L, new Object[0]), GT_ModHandler.RecipeBits.DISMANTLEABLE | GT_ModHandler.RecipeBits.NOT_REMOVABLE | GT_ModHandler.RecipeBits.REVERSIBLE, new Object[]{"SSC", "WQS", "CWS", 'Q', CustomItemList.ChargedGlassLense.get(1L), 'S', OrePrefixes.stick.get(Materials.Platinum), 'C', OrePrefixes.circuit.get(Materials.Data), 'W', OrePrefixes.cableGt01.get(Materials.Aluminium)});
        GT_ModHandler.addCraftingRecipe(ItemList.Emitter_IV.get(1L, new Object[0]), GT_ModHandler.RecipeBits.DISMANTLEABLE | GT_ModHandler.RecipeBits.NOT_REMOVABLE | GT_ModHandler.RecipeBits.REVERSIBLE, new Object[]{"SSC", "WQS", "CWS", 'Q', CustomItemList.HugeChargedGlassLense.get(1L), 'S', OrePrefixes.stick.get(Materials.Iridium), 'C', OrePrefixes.circuit.get(Materials.Elite), 'W', OrePrefixes.cableGt01.get(Materials.Tungsten)});

        //===Sensors===\\
        GT_ModHandler.addCraftingRecipe(ItemList.Sensor_LV.get(1L, new Object[0]), GT_ModHandler.RecipeBits.DISMANTLEABLE | GT_ModHandler.RecipeBits.NOT_REMOVABLE | GT_ModHandler.RecipeBits.REVERSIBLE, new Object[]{"P Q", "PS ", "CPP", 'Q', OrePrefixes.gem.get(Materials.CertusQuartz), 'S', OrePrefixes.stick.get(Materials.Brass), 'P', OrePrefixes.plate.get(Materials.Steel), 'C', OrePrefixes.circuit.get(Materials.Basic)});
        GT_ModHandler.addCraftingRecipe(ItemList.Sensor_MV.get(1L, new Object[0]), GT_ModHandler.RecipeBits.DISMANTLEABLE | GT_ModHandler.RecipeBits.NOT_REMOVABLE | GT_ModHandler.RecipeBits.REVERSIBLE, new Object[]{"P Q", "PS ", "CPP", 'Q', OrePrefixes.gem.get(Materials.NetherQuartz), 'S', OrePrefixes.stick.get(Materials.Electrum), 'P', OrePrefixes.plate.get(Materials.Aluminium), 'C', OrePrefixes.circuit.get(Materials.Good)});
        GT_ModHandler.addCraftingRecipe(ItemList.Sensor_HV.get(1L, new Object[0]), GT_ModHandler.RecipeBits.DISMANTLEABLE | GT_ModHandler.RecipeBits.NOT_REMOVABLE | GT_ModHandler.RecipeBits.REVERSIBLE, new Object[]{"P Q", "PS ", "CPP", 'Q', OrePrefixes.gemFlawed.get(Materials.Emerald), 'S', OrePrefixes.stick.get(Materials.Chrome), 'P', OrePrefixes.plate.get(Materials.StainlessSteel), 'C', OrePrefixes.circuit.get(Materials.Advanced)});
        GT_ModHandler.addCraftingRecipe(ItemList.Sensor_EV.get(1L, new Object[0]), GT_ModHandler.RecipeBits.DISMANTLEABLE | GT_ModHandler.RecipeBits.NOT_REMOVABLE | GT_ModHandler.RecipeBits.REVERSIBLE, new Object[]{"P Q", "PS ", "CPP", 'Q', CustomItemList.ChargedGlassLense.get(1L), 'S', OrePrefixes.stick.get(Materials.Platinum), 'P', OrePrefixes.plate.get(Materials.Titanium), 'C', OrePrefixes.circuit.get(Materials.Data)});
        GT_ModHandler.addCraftingRecipe(ItemList.Sensor_IV.get(1L, new Object[0]), GT_ModHandler.RecipeBits.DISMANTLEABLE | GT_ModHandler.RecipeBits.NOT_REMOVABLE | GT_ModHandler.RecipeBits.REVERSIBLE, new Object[]{"P Q", "PS ", "CPP", 'Q', CustomItemList.HugeChargedGlassLense.get(1L), 'S', OrePrefixes.stick.get(Materials.Iridium), 'P', OrePrefixes.plate.get(Materials.TungstenSteel), 'C', OrePrefixes.circuit.get(Materials.Elite)});

        //===FieldGenerators===\\
        GT_ModHandler.addCraftingRecipe(ItemList.Field_Generator_LV.get(1L), GT_ModHandler.RecipeBits.DISMANTLEABLE | GT_ModHandler.RecipeBits.NOT_REMOVABLE | GT_ModHandler.RecipeBits.REVERSIBLE, new Object[]{"WCW", "CGC", "WCW", 'G', ItemList.Emitter_LV, 'C', OrePrefixes.circuit.get(Materials.Advanced), 'W', OrePrefixes.plate.get(Materials.RedSteel)});
        GT_ModHandler.addCraftingRecipe(ItemList.Field_Generator_MV.get(1L), GT_ModHandler.RecipeBits.DISMANTLEABLE | GT_ModHandler.RecipeBits.NOT_REMOVABLE | GT_ModHandler.RecipeBits.REVERSIBLE, new Object[]{"WCW", "CGC", "WCW", 'G', ItemList.Emitter_MV, 'C', OrePrefixes.circuit.get(Materials.Data), 'W', OrePrefixes.plate.get(Materials.TungstenSteel)});
        GT_ModHandler.addCraftingRecipe(ItemList.Field_Generator_HV.get(1L), GT_ModHandler.RecipeBits.DISMANTLEABLE | GT_ModHandler.RecipeBits.NOT_REMOVABLE | GT_ModHandler.RecipeBits.REVERSIBLE, new Object[]{"WCW", "CGC", "WCW", 'G', ItemList.Emitter_HV, 'C', OrePrefixes.circuit.get(Materials.Elite), 'W', OrePrefixes.plateDouble.get(Materials.NiobiumTitanium)});
        GT_ModHandler.addCraftingRecipe(ItemList.Field_Generator_EV.get(1L), GT_ModHandler.RecipeBits.DISMANTLEABLE | GT_ModHandler.RecipeBits.NOT_REMOVABLE | GT_ModHandler.RecipeBits.REVERSIBLE, new Object[]{"WCW", "CGC", "WCW", 'G', ItemList.Emitter_EV, 'C',  OrePrefixes.circuit.get(Materials.Master), 'W', OrePrefixes.plateDouble.get(Materials.HSSG)});
        GT_ModHandler.addCraftingRecipe(ItemList.Field_Generator_IV.get(1L), GT_ModHandler.RecipeBits.DISMANTLEABLE | GT_ModHandler.RecipeBits.NOT_REMOVABLE | GT_ModHandler.RecipeBits.REVERSIBLE, new Object[]{"WCW", "CGC", "WCW", 'G', ItemList.Emitter_IV, 'C',  OrePrefixes.circuit.get(Materials.Ultimate), 'W', OrePrefixes.plateTriple.get(Materials.HSSS)});
    	}
        
    }
}
