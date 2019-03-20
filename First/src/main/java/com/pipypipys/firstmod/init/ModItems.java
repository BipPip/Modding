package com.pipypipys.firstmod.init;

import java.util.List;

import com.pipypipys.firstmod.items.ItemBase;
import com.pipypipys.firstmod.items.tools.MasterSword;

import java.util.ArrayList;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemSword;
import net.minecraftforge.common.util.EnumHelper;

public class ModItems {

	public static final List<Item> ITEMS = new ArrayList<Item>();
	
	//Materials
	public static final ToolMaterial MATERIAL_MASTER_SWORD = EnumHelper.addToolMaterial("material_master_sword", 3, 100000, 16.0F, 15.0F, 20);
	
	//Items
	public static final Item RUBY = new ItemBase("ruby", CreativeTabs.MATERIALS);
	
	
	
	
	//Tools
	
	public static final ItemSword MASTER_SWORD = new MasterSword("master_sword", MATERIAL_MASTER_SWORD);
	
	
}
