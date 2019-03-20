package com.pipypipys.firstmod;

import com.pipypipys.firstmod.proxy.CommonProxy;
import com.pipypipys.firstmod.util.KeyBindings;
import com.pipypipys.firstmod.util.Reference;
import com.pipypipys.firstmod.util.handlers.RegistryHandler;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = Reference.MOD_ID, name = Reference.NAME, version = Reference.VERSION)
public class Main {

	@Instance
	public static Main instance;
	
	@SidedProxy(clientSide = Reference.CLIENT_PROXY_CLASS, serverSide = Reference.COMMON_PROXY_CLASS)
	public static CommonProxy proxy;
	
	@EventHandler
	public static void PreInit(FMLPreInitializationEvent event)
	{
		 proxy.preInit();
	}
	
	@EventHandler
	 public static void init(FMLInitializationEvent event) {
	
		proxy.init();
	 
	}
	 @EventHandler
	 public static void postInit(FMLPostInitializationEvent event) {
		 
		 //MinecraftForge.EVENT_BUS.register(new EventHandler());
		 RegistryHandler.postInitRegistries();
		 
		 
	 }
	 
	
	
}
