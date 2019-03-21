package com.pipypipys.firstmod.util.handlers;

import java.util.ArrayList;

import com.mojang.authlib.GameProfile;
import com.sun.glass.events.KeyEvent;
import com.pipypipys.firstmod.util.KeyBindings;
import com.pipypipys.firstmod.entity.player.EntityUser;
import com.pipypipys.firstmod.entity.player.EntityUserSP;

import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.client.settings.GameSettings;
import net.minecraft.client.settings.KeyBinding;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.init.PotionTypes;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.GameType;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.InputEvent;

@EventBusSubscriber (Side.CLIENT)
public class EventHandler {
	
	static boolean isInvisible = false;
	
	
	
	

	@SubscribeEvent
	public static void onKeyInput(InputEvent.KeyInputEvent event) {
		
		EntityPlayer player = Minecraft.getMinecraft().player;
	
		
		
		
		boolean space = Minecraft.getMinecraft().gameSettings.keyBindJump.isKeyDown();
		boolean ability1 = KeyBindings.ability1.isKeyDown();
		
		
		
		
		
		//System.out.println(player.capabilities.disableDamage);
		System.out.println(player.isCreative());
		//System.out.println(abilities.isCreative());
		
		if (ability1) {
			
			//System.out.println(player.getLookVec());
			//player.setLocationAndAngles(player.posX, player.posY, player.posZ + 1, player.rotationYaw, player.rotationPitch);
			//player.addPotionEffect(new PotionEffect(Potion.getPotionById(14), 300, 1));
			if (!isInvisible) {
			player.setInvisible(true);
			
			
			//player.capabilities.disableDamage = true;
			//player.capabilities.isCreativeMode = true;
			//player.capabilities.isFlying = true;
			 
			
			
			GameType abilities = GameType.CREATIVE;
			abilities.configurePlayerCapabilities(player.capabilities);
			
			
			
			
			isInvisible = true;
			
			}
			else {
				player.setInvisible(false);
				
				/*
				player.capabilities.disableDamage = false;
				player.capabilities.isCreativeMode = false;
				player.capabilities.isFlying = false;
				*/
				
				
				GameType abilities = GameType.SURVIVAL;
				abilities.configurePlayerCapabilities(player.capabilities);
				
				isInvisible = false;
				}
			
			
			
		 }
		
	
		
		
		
	}
	
	
	
	
	 
	
}
