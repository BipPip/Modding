package com.pipypipys.firstmod.network.messages;

import java.util.Timer;
import java.util.TimerTask;

import org.jline.utils.Log;

import com.pipypipys.firstmod.network.MessageBase;
import com.pipypipys.firstmod.util.Reference;

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
import net.minecraft.util.text.TextComponentString;
import net.minecraftforge.client.event.sound.SoundEvent;
import net.minecraft.init.SoundEvents;

public class MessageSpeedEffect extends MessageBase<MessageSpeedEffect> {

	
	private boolean add;
	//Timer timer = null;
	
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
	Timer timer = new Timer("Timer");
	@Override
	public void handleServerSide(MessageSpeedEffect message, EntityPlayer player) {
		
		/*
		 * If using this in a scenario like if you were to have a block explode when clicked, you have to make sure only the server is doing the explosion.
		 * To do this do if(world.isRemote) to prevent it form happening on the clientside
		 */
		player.getEntityData().setDouble("mana", 300);
		Reference.mana = player.getEntityData().getDouble("mana");
		
		if(message.add) {
			
		
		TimerTask repeatedTask = new TimerTask() {

			@Override
			public void run() {
				//Log.info("Tick");
				if ((player.getEntityData().getDouble("mana") - 5) < 0) {
					player.sendMessage(new TextComponentString("You do not have enough mana"));
					cancel();
					player.removePotionEffect(MobEffects.SPEED);
					
				}
				else if (player.isDead) {
					cancel();
					player.removePotionEffect(MobEffects.SPEED);
				}
				else {
				player.addPotionEffect(new PotionEffect(MobEffects.SPEED, 50, 40));
				player.getEntityData().setDouble("mana", (player.getEntityData().getDouble("mana") - 5));
				Reference.mana = player.getEntityData().getDouble("mana");
				}
			}
			
		};
		
	     
	    long delay  = 300L;
	    long period = 300L;
	    timer.scheduleAtFixedRate(repeatedTask, delay, period);
		
		} else
		{
		
		timer.cancel();
		timer = new Timer("Timer");
		player.removePotionEffect(MobEffects.SPEED);
	
		}
		
	}

}
