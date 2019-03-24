package com.pipypipys.firstmod.capabilities;


import org.jline.utils.Log;

import com.pipypipys.firstmod.network.NetworkHandler;
import com.pipypipys.firstmod.network.messages.MessageCapabilities;
import com.pipypipys.firstmod.util.Reference;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

/**
 * Capability handler
 * 
 * This class is responsible for attaching our capabilities
 */
@EventBusSubscriber
public class CapabilityHandler
{
    public static final ResourceLocation RPG = new ResourceLocation(Reference.MOD_ID, "rpg");
	
	@SubscribeEvent
    public void attachCapability(AttachCapabilitiesEvent event)
    {
    	
    	
    	 if (event.getObject() instanceof EntityPlayer) {
    		
 	        event.addCapability(RPG, new RPGProvider());
 	        
 	      	
 	        //Log.info(event.getCapabilities());
 	        }
    }
}