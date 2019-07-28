package com.spartakcore.gthandler;

import gregtech.api.enums.GT_Values;
import gregtech.api.enums.Materials;
import gregtech.api.enums.OrePrefixes;
import gregtech.api.enums.TC_Aspects;
import gregtech.api.objects.ItemData;
import gregtech.api.util.GT_ModHandler;
import gregtech.api.util.GT_OreDictUnificator;
import gregtech.common.items.GT_MetaGenerated_Item_03;

/*
 * 
 */
public class GT_Loader_Batteries
{
	public void run()
	{
		GT = GT_MetaGenerated_Item_03.INSTANCE;
		registerBatteries();
	}

	private GT_MetaGenerated_Item_03 GT;
	
	private void registerBatteries()
	{
		// Range 300 to 700 is free, as of GT 5.09.34.49
		// 700+ Are old circuits, etc.
		int tLastID;
		
		CustomItemList.BatteryHull_UMV.set(GT.addItem(300, "Medium Plasma Battery (Empty)", "An empty UMV Energy Storage", new Object[] { new ItemData(Materials.Neutronium, OrePrefixes.plate.mMaterialAmount * 56L), new TC_Aspects.TC_AspectStack(TC_Aspects.ELECTRUM, 2048L), new TC_Aspects.TC_AspectStack(TC_Aspects.METALLUM, 2048L), new TC_Aspects.TC_AspectStack(TC_Aspects.VACUOS, 2048L) }));
		CustomItemList.BatteryHull_UxV.set(GT.addItem(301, "Large Plasma Battery (Empty)", "An empty UXV Energy Storage", new Object[] { new ItemData(Materials.DraconiumAwakened, OrePrefixes.plate.mMaterialAmount * 64L), new TC_Aspects.TC_AspectStack(TC_Aspects.ELECTRUM, 4096L), new TC_Aspects.TC_AspectStack(TC_Aspects.METALLUM, 4096L), new TC_Aspects.TC_AspectStack(TC_Aspects.VACUOS, 4096L) }));
		
		//Recipes
		GT_Values.RA.addAssemblerRecipe(GT_OreDictUnificator.get(OrePrefixes.wireGt16, Materials.Superconductor, 2L),
				GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Neutronium, 56L), Materials.Polybenzimidazole.getMolten(9216L),
				CustomItemList.BatteryHull_UMV.get(1L), 600, 2000000);
		GT_Values.RA.addAssemblerRecipe(GT_OreDictUnificator.get(OrePrefixes.wireGt16, Materials.SuperconductorUEV, 2L),
				GT_OreDictUnificator.get(OrePrefixes.plate, Materials.DraconiumAwakened, 64L), Materials.Polybenzimidazole.getMolten(18432L),
				CustomItemList.BatteryHull_UxV.get(1L), 1200, 8000000);
		
		// Actually filled hulls.
		CustomItemList.BatteryHull_UMV_Full.set(GT.addItem(tLastID = 500, "Medium Infinity Battery", "Reusable", new Object[]{new TC_Aspects.TC_AspectStack(TC_Aspects.ELECTRUM, 2048L), new TC_Aspects.TC_AspectStack(TC_Aspects.METALLUM, 2048L), new TC_Aspects.TC_AspectStack(TC_Aspects.POTENTIA, 2048L)}));
		GT.setElectricStats(32000 + tLastID, 419430400000L, GT_Values.V[12], 12L, -3L, true);

		CustomItemList.BatteryHull_UxV_Full.set(GT.addItem(tLastID = 505, "Large Infinity Battery", "Reusable", new Object[]{new TC_Aspects.TC_AspectStack(TC_Aspects.ELECTRUM, 4096L), new TC_Aspects.TC_AspectStack(TC_Aspects.METALLUM, 4096L), new TC_Aspects.TC_AspectStack(TC_Aspects.POTENTIA, 4096L)}));
		GT.setElectricStats(32000 + tLastID, 1677721600000L, GT_Values.V[13], 13L, -3L, true);
		
		// Just to be complete, extractor recipes for the filled hulls
		GT_ModHandler.addExtractionRecipe(CustomItemList.BatteryHull_UMV_Full.get(1L), CustomItemList.BatteryHull_UMV.get(1L));
		GT_ModHandler.addExtractionRecipe(CustomItemList.BatteryHull_UxV_Full.get(1L), CustomItemList.BatteryHull_UxV.get(1L));
		
		// Recipes to actually fill the empty hulls with content
		// UMV 134217728
				GT_Values.RA.addCannerRecipe(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Infinity, 4L),
						CustomItemList.BatteryHull_UMV.get(1L),
						CustomItemList.BatteryHull_UMV_Full.get(1L),
						null, 500, 122880);

				// UxV 536870912
				GT_Values.RA.addCannerRecipe(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Infinity, 8L),
						CustomItemList.BatteryHull_UxV.get(1L),
						CustomItemList.BatteryHull_UxV_Full.get(1L),
						null, 600, 500000);
	}
}
