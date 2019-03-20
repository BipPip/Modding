package com.pipypipys.firstmod.init;

import java.util.ArrayList;
import java.util.List;

import com.pipypipys.firstmod.blocks.BlockBase;
import com.pipypipys.firstmod.blocks.KoichiBlock;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;

public class ModBlocks {

	public static final List<Block> BLOCKS = new ArrayList<Block>();
	
	public static final Block MARC_BLOCK = new BlockBase("marc_block", Material.CLAY, CreativeTabs.BUILDING_BLOCKS);
	
	public static final Block COLTON_BLOCK = new BlockBase("colton_block", Material.CLAY, CreativeTabs.BUILDING_BLOCKS);
	
	public static final Block JOSUKE_BLOCK = new BlockBase("josuke_block", Material.CLAY, CreativeTabs.BUILDING_BLOCKS);
	
	public static final Block KOICHI_BLOCK = new KoichiBlock("koichi_block", Material.CLAY, CreativeTabs.BUILDING_BLOCKS);
}
