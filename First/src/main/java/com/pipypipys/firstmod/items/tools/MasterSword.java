package com.pipypipys.firstmod.items.tools;


import com.pipypipys.firstmod.Main;
import com.pipypipys.firstmod.init.ModItems;
import com.pipypipys.firstmod.util.IHasModel;

import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;



public class MasterSword extends ItemSword implements IHasModel {
    
	

	public MasterSword(String name, ToolMaterial material) {
		
		super(material);
		
		
		
		setUnlocalizedName(name);
		setRegistryName(name);
		setCreativeTab(CreativeTabs.COMBAT);
		
		
		ModItems.ITEMS.add(this);
		
	}
	
	
	
	
	
	@Override
	public void registerModels() {
		
		Main.proxy.registerItemRenderer(this, 0, "inventory");
		
	}

}
