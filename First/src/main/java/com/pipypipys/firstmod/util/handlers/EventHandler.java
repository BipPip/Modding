package com.pipypipys.firstmod.util.handlers;

import java.util.ArrayList;
import java.util.List;

import org.jline.utils.Log;

import com.mojang.authlib.GameProfile;
import com.sun.glass.events.KeyEvent;
import com.pipypipys.firstmod.network.NetworkHandler;
import com.pipypipys.firstmod.network.messages.MessageExplode;
import com.pipypipys.firstmod.network.messages.MessageInvisibilityEffect;
import com.pipypipys.firstmod.network.messages.MessageSpeedEffect;
import com.pipypipys.firstmod.util.KeyBindings;

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
import net.minecraft.world.GameType;
import net.minecraft.world.World;
import net.minecraft.world.WorldServer;
import net.minecraftforge.event.entity.living.LivingSetAttackTargetEvent;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.InputEvent;

@EventBusSubscriber (Side.CLIENT)
public class EventHandler {
	

	private static String PlayerClass = "rogue";
	private static boolean isInvisible = false;
	
	

	@SubscribeEvent
	public static void onKeyInput(InputEvent.KeyInputEvent event) {
		
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
		
		
		if(PlayerClass == "warrior") {
	
		
		if (ability1) {
			
		
		
		NetworkHandler.sendToServer(new MessageExplode(3, false));
			
			
		Log.info("Ability 1 used");
		 }
		
		if (ability2) {
		
			
		Log.info("Ability 2 used");	
		}
		
		}
		else if (PlayerClass == "rogue" ) {
			
			if (ability1) {
				
				
				if (!isInvisible) {
				
				
					player.playSound(SoundEvents.ENTITY_ENDERMEN_TELEPORT, 10, 1);
						
					List<Entity> entities = Minecraft.getMinecraft().world.getEntitiesWithinAABBExcludingEntity(player, player.getEntityBoundingBox().expand(5.0D, 5.0D, 5.0D));
					NetworkHandler.sendToServer(new MessageInvisibilityEffect(true));	
					
					/*for(Entity entity: entities) {
						Log.info(entity);
						Log.info(playerMP.getName());
						//entity.removeTrackingPlayer(playerMP);
						entity.setDead();
						
					}*/
				
					
					Log.info("Ability 1 used");
				}
				else {
					NetworkHandler.sendToServer(new MessageInvisibilityEffect(false));	
					player.playSound(SoundEvents.ENTITY_ENDERMEN_TELEPORT, 10, 1);
				}
				 }
				
				if (ability2) {
				
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
				}
			
			
		}
	
		
		
		
	}
	
	
	@SubscribeEvent
	public static void onSetTarget(LivingSetAttackTargetEvent event) {
	
		
		if(event.getTarget() != null && event.getTarget().isInvisible()) {
		Entity entity = event.getEntity();
		EntityLiving entityliving = (EntityLiving) entity;
		entityliving.setAttackTarget(null);
		
		}
	
	}
	
}
