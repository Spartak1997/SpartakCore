package com.spartakcore.block;

import com.spartakcore.creativetab.ModTabList;
import com.spartakcore.lib.Refstrings;
import com.spartakcore.spartakcore;
import eu.usrv.yamcore.blocks.ModBlockManager;
import eu.usrv.yamcore.blocks.ModSimpleBaseBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.block.*;

public enum BlockList {

	PistonBlock(new ModSimpleBaseBlock(new PistonBlockProperties(), ModTabList.ModBlocksTab)),
	BlockCokeCoal(new ModSimpleBaseBlock(new CokeCoalBlock(), ModTabList.ModBlocksTab)),
		// A simple basic block. Not enabled, as it doesn't have a texture
	//BoringDefaultBlock(new ModSimpleBaseBlock(Material.rock, "BoringBlock", ModTabList.ModBlocksTab)), 
	
	// fancy admin lamp noone will take! Shows how to use other's mod's textures for blocks without stealing them
	// also not enabled, to prevent blockID spam on the server. (They ARE limited..)
	//AdminsBedrockLamp(new ModSimpleBaseBlock(new AdminsBedrockLampProperties(), ModTabList.ModBlocksTab)), 
	
	// Do not delete this
	EndOfList(null);
	
	// ################################################################################
	public ModSimpleBaseBlock Block;
	BlockList(ModSimpleBaseBlock pBlock)
	{
		Block = pBlock;
		if (Block != null) {
            Block.setModIDName(Refstrings.MODID);
        }
	}
	
	public static boolean AddToItemManager(ModBlockManager pBlockManager)
	{
		boolean tResult = true;
		for (BlockList bl : BlockList.values())
		{
			if (bl.Block != null) {
                if (!pBlockManager.AddItemToManagedRegistry(bl.Block)) {
                    spartakcore.Logger.error(String.format("Block [%s] failed to register", bl.toString()));
                    tResult = false;
                }
            }
		}
		
		return tResult;
	}
	
	public Block getBlock() {
		return Block.getConstructedBlock();
	}
	
	public ItemStack getIS() {
		return new ItemStack(Block.getConstructedBlock(),1);
	}
	
	public ItemStack getIS(int amount) {
		return new ItemStack(Block.getConstructedBlock(),amount);
	}
}
