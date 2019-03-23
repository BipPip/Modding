package com.pipypipys.firstmod.proxy;

import java.util.ArrayList;

import com.pipypipys.firstmod.util.KeyBindings;
import com.pipypipys.firstmod.util.handlers.EventHandler;
import com.pipypipys.firstmod.util.handlers.RegistryHandler;
import com.pipypipys.firstmod.util.handlers.RenderHandler;

import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.client.settings.KeyBinding;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.FMLCommonHandler;

public class ClientProxy extends CommonProxy {

	public void registerItemRenderer(Item item, int meta, String id) {
		
		ModelLoader.setCustomModelResourceLocation(item, meta, new ModelResourceLocation(item.getRegistryName(), id));
		
		
		
	}
	
	@Override
	public void preInit() {
		RegistryHandler.preInitRegistries();
		KeyBindings.init();
		//FMLCommonHandler.instance().bus().register(new EventHandler());
		
		
	}
	
	
	@Override
	public void init() {
		
		RegistryHandler.initRegistries();
		
		
		
		
	}
	
	
}
