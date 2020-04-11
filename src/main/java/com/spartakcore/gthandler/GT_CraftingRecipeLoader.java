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
    private final static long bitsd = GT_ModHandler.RecipeBits.DISMANTLEABLE | bits;
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
    	
    	GT_ModHandler.addCraftingRecipe(CustomItemList.SteelBars.get(3L, o), GT_ModHandler.RecipeBits.NOT_REMOVABLE | GT_ModHandler.RecipeBits.REVERSIBLE, new Object[]{" h ", "SSS", "SSS", 'S', GT_OreDictUnificator.get(OrePrefixes.stick, Materials.Steel, 1)});

    	GT_ModHandler.addCraftingRecipe(CustomItemList.Casing_Farm.get(1L), bits, new Object[]{"ThT", "TFT", "TwT", 'T', CustomItemList.SteelBars, 'F', OrePrefixes.frameGt.get(Materials.Steel)});
        
    	//Fertilizer
    	GT_ModHandler.addCraftingRecipe(CustomItemList.DustSmallFertilizer.get(4L), bits, new Object[]{" D", "  ", 'D', GT_ModHandler.getModItem("IC2", "itemFertilizer", 1L,0)});
    	GT_ModHandler.addCraftingRecipe(CustomItemList.DustTinyFertilizer.get(9L), bits, new Object[]{"D ", "  ", 'D', GT_ModHandler.getModItem("IC2", "itemFertilizer", 1L,0)});
        
    	GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem("IC2", "itemFertilizer", 1L,0), bits, new Object[]{"DD", "DD", 'D', CustomItemList.DustSmallFertilizer.get(1L)});
    	GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem("IC2", "itemFertilizer", 1L,0), bits, new Object[]{"DDD", "DDD", "DDD", 'D', CustomItemList.DustTinyFertilizer.get(1L)});
        
    	//###Components###\\

        //CokeOvenBrick Block

    }
}
