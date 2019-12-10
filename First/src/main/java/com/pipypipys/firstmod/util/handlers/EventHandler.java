package com.pipypipys.firstmod.util.handlers;

import java.util.ArrayList;
import java.util.List;

import javax.sound.sampled.Port.Info;

import org.jline.utils.Log;

import com.mojang.authlib.GameProfile;
import com.pipypipys.firstmod.client.gui.GuiMana;
import com.pipypipys.firstmod.network.NetworkHandler;
import com.pipypipys.firstmod.network.messages.MessageExplode;
import com.pipypipys.firstmod.network.messages.MessageInvisibilityEffect;
import com.pipypipys.firstmod.network.messages.MessageSpeedEffect;
import com.pipypipys.firstmod.util.KeyBindings;
import com.pipypipys.firstmod.util.Reference;

import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.client.settings.GameSettings;
import net.minecraft.client.settings.KeyBinding;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.init.MobEffects;
import net.minecraft.init.PotionTypes;
import net.minecraft.init.SoundEvents;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.management.PlayerList;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.world.GameType;
import net.minecraft.world.World;
import net.minecraft.world.WorldServer;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.client.event.RenderGameOverlayEvent.ElementType;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import net.minecraftforge.event.entity.living.LivingEntityUseItemEvent.Tick;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.event.entity.living.LivingFallEvent;
import net.minecraftforge.event.entity.living.LivingSetAttackTargetEvent;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.common.eventhandler.Event;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.InputEvent;
import net.minecraftforge.fml.common.gameevent.PlayerEvent.PlayerLoggedInEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.event.entity.player.PlayerSleepInBedEvent;

@EventBusSubscriber (Side.CLIENT)
public class EventHandler {
	


	private static boolean isInvisible = false;
	public static final ResourceLocation RPG = new ResourceLocation(Reference.MOD_ID, "rpg");
	public static boolean ability1Unclicked = true;
	public static boolean ability2Unclicked = true;
	
	
	// PLayer Data
	 @SubscribeEvent
	 public static void playerData(LivingEvent.LivingUpdateEvent event) {
		 if (event.getEntityLiving() instanceof EntityPlayer) {
			 EntityPlayer player = (EntityPlayer) event.getEntityLiving();
			
			 if (!player.getEntityData().hasKey("hasFired") || !player.getEntityData().getBoolean("hasFired")) {
				 player.getEntityData().setBoolean("hasFired", true);
				 // Example playerdata
			 }
			 
			 if (!player.getEntityData().hasKey("mana")) {
				 player.getEntityData().setDouble("mana", 300);
				 
				 
			 }
		
			 
			 if(player.isDead) {
				 //Log.info("EDEEEEEEEEEEEEEAD");
				 //player.removePotionEffect(MobEffects.SPEED);
			 }
			
		 }
	 }
	 
	 
	
		 @SubscribeEvent
		 public static void onPlayerJoin(EntityJoinWorldEvent event) {
			 if (event.getEntity() instanceof EntityPlayer) {
				 EntityPlayer player = (EntityPlayer) event.getEntity();
				 if (player.getEntityData().hasKey("mana")) {
				 Reference.mana = player.getEntityData().getDouble("mana");
				 //Log.info("EEEEEEEEEEEEEEEEEEEEEEEE");
				 }
			 }
		 }
	 
	 
	 // Player GUI Handler
	 @SubscribeEvent
	 public static void onRenderGui(RenderGameOverlayEvent.Post event) {
			if (event.getType() != ElementType.EXPERIENCE) return;
		 	new GuiMana(Minecraft.getMinecraft());
			//Log.info("GUIIIIIIIIII");
		}
	
	
	 @SubscribeEvent
		public static void onPlayerTick(TickEvent.PlayerTickEvent event) {
		 
		 if (!KeyBindings.ability1.isKeyDown()) {
			 ability1Unclicked = true;
		 }
		 if (!KeyBindings.ability2.isKeyDown()) {
			 ability2Unclicked = true;
		 }
		 
		 
		 
	 }
	 

	@SubscribeEvent
	public static void onKeyInput(InputEvent.KeyInputEvent Event) {
		
		PlayerList players = FMLCommonHandler.instance().getMinecraftServerInstance().getPlayerList();
	
		
	
		EntityPlayer player = Minecraft.getMinecraft().player;
		GameProfile profile = player.getGameProfile();
		int playerId = player.getEntityId();
		EntityPlayerMP playerMP = players.getPlayerByUUID(player.getUUID(profile));
		
		boolean isInvisible = player.isInvisible();
		boolean isSpeed = player.isPotionActive(MobEffects.SPEED);
		
		boolean space = Minecraft.getMinecraft().gameSettings.keyBindJump.isKeyDown();
		boolean ability1 = KeyBindings.ability1.isKeyDown();
		boolean ability2 = KeyBindings.ability2.isKeyDown();
	
		
		
		
		// Class abilities
		//EntityPlayerRPG playerRPG = (EntityPlayerRPG) playerMP;
		

	
		//System.out.println(mana.getMana());
		

		//if(player.hasCapability(RPGProvider.CAPABILTIY_RPG, null) && player.getCapability(RPGProvider.CAPABILTIY_RPG, null).getPlayerClass() == 1) {
			
		
		if (ability1 && ability1Unclicked) {
			
		
		
		NetworkHandler.sendToServer(new MessageExplode(3, false));
		Log.info("Ability 1 used");
		//ability1 = false;
		ability1Unclicked = false;
		
		 }
		
		
		//}
		//else if (player.hasCapability(RPGProvider.CAPABILTIY_RPG, null) && player.getCapability(RPGProvider.CAPABILTIY_RPG, null).getPlayerClass() == 2) {
			
		/*
			if (ability1) {
				
				
				if (!isInvisible) {
				
				
					player.playSound(SoundEvents.ENTITY_ENDERMEN_TELEPORT, 10, 1);
						
					List<Entity> entities = Minecraft.getMinecraft().world.getEntitiesWithinAABBExcludingEntity(player, player.getEntityBoundingBox().expand(5.0D, 5.0D, 5.0D));
					NetworkHandler.sendToServer(new MessageInvisibilityEffect(true));	
					
					for(Entity entity: entities) {
						Log.info(entity);
						Log.info(playerMP.getName());
						//entity.removeTrackingPlayer(playerMP);
						entity.setDead();
						
					}
				
					
					Log.info("Ability 1 used");
				}
				else {
					NetworkHandler.sendToServer(new MessageInvisibilityEffect(false));	
					player.playSound(SoundEvents.ENTITY_ENDERMEN_TELEPORT, 10, 1);
				} 
				 } */
				
				if (ability2 && ability2Unclicked) {
				
					if (!isSpeed) {
						
						NetworkHandler.sendToServer(new MessageSpeedEffect(true));	
							//player.playSound(SoundEvents.ENTITY_ENDERMEN_TELEPORT, 10, 1);
								
							Log.info("Ability 1 used");
						}
						else {
							NetworkHandler.sendToServer(new MessageSpeedEffect(false));	
							//player.playSound(SoundEvents.ENTITY_ENDERMEN_TELEPORT, 10, 1);
						}

				
					Log.info("Ability 2 used");	
					ability2Unclicked = false;
				}
			
			
		}
	
		
		
		
	//}
	
	
	@SubscribeEvent
	public static void onSetTarget(LivingSetAttackTargetEvent event) {
	
		
		if(event.getTarget() != null && event.getTarget().isInvisible()) {
		Entity entity = event.getEntity();
		EntityLiving entityliving = (EntityLiving) entity;
		entityliving.setAttackTarget(null);
		
		}
	
	}
	
	 
	
	
	
	
}
