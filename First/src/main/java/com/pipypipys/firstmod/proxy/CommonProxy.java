package com.pipypipys.firstmod.proxy;

import com.pipypipys.firstmod.util.handlers.RegistryHandler;

import net.minecraft.item.Item;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class CommonProxy {

	public void registerItemRenderer(Item item, int meta, String id) {
		
	}

	public void preInit() {
		



		
		
	}
	
	public void init() {
		

		RegistryHandler.initRegistries();

		
		
	}
	
	
}
