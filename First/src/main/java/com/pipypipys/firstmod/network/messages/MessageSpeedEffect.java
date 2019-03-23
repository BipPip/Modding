package com.pipypipys.firstmod.network.messages;

import com.pipypipys.firstmod.network.MessageBase;

import io.netty.buffer.ByteBuf;
import net.minecraft.client.Minecraft;
import net.minecraft.client.audio.Sound;
import net.minecraft.entity.Entity;
import net.minecraft.entity.monster.EntityEnderman;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.MobEffects;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.sound.SoundEvent;
import net.minecraft.init.SoundEvents;

public class MessageSpeedEffect extends MessageBase<MessageSpeedEffect> {

	
	private boolean add;
	
	//Anti constructor
	public MessageSpeedEffect(){}
	
	public MessageSpeedEffect(boolean addOrRemove) {
		
		this.add = addOrRemove;
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
	public void handleClientSide(MessageSpeedEffect message, EntityPlayer player) {
		//Minecraft.getMinecraft().thePlayer --- Gets the player on client side, but EntityPlayer player covers that
		
		
	}

	@Override
	public void handleServerSide(MessageSpeedEffect message, EntityPlayer player) {
		
		/*
		 * If using this in a scenario like if you were to have a block explode when clicked, you have to make sure only the server is doing the explosion.
		 * To do this do if(world.isRemote) to prevent it form happening on the clientside
		 */
		
		if(message.add) {
		
		player.addPotionEffect(new PotionEffect(MobEffects.SPEED, 300, 4));
		
		} else
		{
		player.removePotionEffect(MobEffects.SPEED);
	
		}
		
	}

}
