package com.pipypipys.firstmod.network.messages;

import java.util.List;

import org.jline.utils.Log;

import com.mojang.authlib.GameProfile;
import com.pipypipys.firstmod.network.MessageBase;

import io.netty.buffer.ByteBuf;
import net.minecraft.client.Minecraft;
import net.minecraft.client.audio.Sound;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.monster.EntityEnderman;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.init.MobEffects;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.server.management.PlayerList;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.sound.SoundEvent;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraft.init.SoundEvents;

public class MessageInvisibilityEffect extends MessageBase<MessageInvisibilityEffect> {

	
	private boolean add;
	
	
	
	//Anti constructor
	public MessageInvisibilityEffect(){}
	
	public MessageInvisibilityEffect(boolean add) {
		
		this.add = add;
		//this.entities = entities;
		//this.playerMP = playerMP;
		
		
		
	}
	
	
	
	@Override // Holds extra package information
	public void fromBytes(ByteBuf buf) {
		
		
		add = buf.readBoolean();
		
		
	}

	@Override
	public void toBytes(ByteBuf buf) {
	
		buf.writeBoolean(add);
		
		
		
	}

	@Override
	public void handleClientSide(MessageInvisibilityEffect message, EntityPlayer player) {
		//Minecraft.getMinecraft().thePlayer --- Gets the player on client side, but EntityPlayer player covers that
		
		
	}

	@Override
	public void handleServerSide(MessageInvisibilityEffect message, EntityPlayer player) {
		
		/*
		 * If using this in a scenario like if you were to have a block explode when clicked, you have to make sure only the server is doing the explosion.
		 * To do this do if(world.isRemote) to prevent it form happening on the clientside
		 */
		
		PlayerList players = FMLCommonHandler.instance().getMinecraftServerInstance().getPlayerList();
		GameProfile profile = player.getGameProfile();
		EntityPlayerMP playerMP = players.getPlayerByUUID(player.getUUID(profile));
		
		if(message.add) {
		
	
		player.addPotionEffect(new PotionEffect(MobEffects.INVISIBILITY, 300, 0));
		//player.capabilities.disableDamage = true;
		
		List<Entity> entities = Minecraft.getMinecraft().world.getEntitiesWithinAABBExcludingEntity(player, player.getEntityBoundingBox().grow(20.0D));
		
		
		for(Entity entity: entities) {
			//Log.info(entity);
			//Log.info(playerMP.getName());
			
			
		/*	if(entity instanceof EntityLivingBase) {
				EntityLiving entityliving = (EntityLiving) entity;
				if (entityliving.getAttackTarget() == player) {
					
					System.out.println(entityliving.getName());
					System.out.println(((EntityLiving) entityliving).getAttackTarget());
					System.out.println(entityliving.getAttackingEntity());
					
					
				}
			}*/
			
		} 
		
		
		} else
		{
		player.removePotionEffect(MobEffects.INVISIBILITY);
		
		
		
	
		}
		
	}

}
