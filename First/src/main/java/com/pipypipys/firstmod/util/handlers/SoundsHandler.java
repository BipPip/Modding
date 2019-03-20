package com.pipypipys.firstmod.util.handlers;

import com.pipypipys.firstmod.util.Reference;

import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.fml.common.registry.ForgeRegistries;

public class SoundsHandler {

	
	public static SoundEvent ENTITY_RAT_HURT;
	
	public static void registerSounds() {
		
		ENTITY_RAT_HURT = registerSound("entity.rat.hurt");
		
		
		
		
	}
	
	private static SoundEvent registerSound(String name) {
		
		ResourceLocation location = new ResourceLocation(Reference.MOD_ID, name);
		SoundEvent event = new SoundEvent(location);
		event.setRegistryName(name);
		ForgeRegistries.SOUND_EVENTS.register(event);
		return event;
	}
	
}
