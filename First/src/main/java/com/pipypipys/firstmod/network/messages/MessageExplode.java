package com.pipypipys.firstmod.network.messages;

import org.jline.utils.Log;

import com.pipypipys.firstmod.client.gui.GuiMana;
import com.pipypipys.firstmod.network.MessageBase;
import com.pipypipys.firstmod.network.NetworkHandler;
import com.pipypipys.firstmod.util.Reference;

import io.netty.buffer.ByteBuf;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.MoverType;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.text.TextComponentString;

public class MessageExplode extends MessageBase<MessageExplode> {

	
	private float explosionSize;
	private boolean breakblocks;
	
	//Anti constructor
	public MessageExplode(){}
	
	public MessageExplode(float explosionSize, boolean breakblocks) {
		this.explosionSize = explosionSize;
		this.breakblocks = breakblocks;
	}
	
	
	
	@Override // Holds extra package information
	public void fromBytes(ByteBuf buf) {
		
		explosionSize = buf.readFloat();
		breakblocks = buf.readBoolean();
		
	}

	@Override
	public void toBytes(ByteBuf buf) {
	
		buf.writeFloat(explosionSize);
		buf.writeBoolean(breakblocks);
		
		
	}

	@Override
	public void handleClientSide(MessageExplode message, EntityPlayer player) {
		//Minecraft.getMinecraft().thePlayer --- Gets the player on client side, but EntityPlayer player covers that
		
		
	}

	@Override
	public void handleServerSide(MessageExplode message, EntityPlayer player) {
		
		/*
		 * If using this in a scenario like if you were to have a block explode when clicked, you have to make sure only the server is doing the explosion.
		 * To do this do if(world.isRemote) to prevent it form happening on the clientside
		 */
		
		if ((player.getEntityData().getDouble("mana") - 20) < 0) {
			player.sendMessage(new TextComponentString("You do not have enough mana"));
			
		}
		else {
		
			

		player.world.createExplosion(player, player.posX, player.posY, player.posZ, message.explosionSize, message.breakblocks);
		player.getEntityData().setDouble("mana", (player.getEntityData().getDouble("mana") - 20));
		Reference.mana = player.getEntityData().getDouble("mana");
		//player.sendMessage(new TextComponentString("You have " + player.getEntityData().getDouble("mana") + "  mana left"));
	
		
		}
		
	}

}
