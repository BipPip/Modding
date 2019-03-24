package com.pipypipys.firstmod.network.messages;

import com.pipypipys.firstmod.capabilities.IRPG;
import com.pipypipys.firstmod.capabilities.RPGProvider;
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
import net.minecraftforge.fml.common.network.ByteBufUtils;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraft.init.SoundEvents;

public class MessageCapabilities extends MessageBase<MessageCapabilities> {

	
	private IRPG value;
	
	
	//Anti constructor
	public MessageCapabilities(){}
	
	public MessageCapabilities(IRPG value) {
		
		this.value = value;
		
	}
	
	
	
	@Override // Holds extra package information
	public void fromBytes(ByteBuf buf) {
		if(this.value != null) {
		this.value.setPlayerClass(ByteBufUtils.readUTF8String(buf));
		
			
		
		}
	}

	@Override
	public void toBytes(ByteBuf buf) {
		if(this.value != null) {
		ByteBufUtils.writeUTF8String(buf, this.value.getPlayerClass());
	
		
		}	
	}

	public void setValue(IRPG value) {
		this.value = value;
	}

	public IRPG getValue() {
		return this.value;
	}

	@Override
	public void handleClientSide(MessageCapabilities message, EntityPlayer player) {
		
		
	}

	@Override
	public void handleServerSide(MessageCapabilities message, EntityPlayer player) {

		this.value = player.getCapability(RPGProvider.CAPABILTIY_RPG, null);
		this.value.setPlayerClass("Rogue");
	}

}
