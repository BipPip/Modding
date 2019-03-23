package com.pipypipys.firstmod;

import org.lwjgl.opengl.GL11;

import com.pipypipys.firstmod.network.NetworkHandler;
import com.pipypipys.firstmod.proxy.CommonProxy;
import com.pipypipys.firstmod.util.KeyBindings;
import com.pipypipys.firstmod.util.Reference;
import com.pipypipys.firstmod.util.handlers.RegistryHandler;

import net.minecraftforge.client.event.RenderPlayerEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

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
		 NetworkHandler.init();
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
	 
	 
	 @SubscribeEvent
	 public void renderPlayerPre(RenderPlayerEvent.Pre e) {
		 //Change what the player looks like
		 GL11.glPushMatrix();
		 
		 
		 
	 }
	 
	 @SubscribeEvent
	 public void renderPLayerPost(RenderPlayerEvent.Post e) {
		 GL11.glPopMatrix();
		 
	 }
	
	
}
