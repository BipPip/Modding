package com.pipypipys.firstmod.init;

import com.pipypipys.firstmod.Main;
import com.pipypipys.firstmod.entity.EntityGioZombie;
import com.pipypipys.firstmod.entity.EntityRat;
import com.pipypipys.firstmod.entity.EntityTurtle;
import com.pipypipys.firstmod.util.Reference;


import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.registry.EntityRegistry;

public class ModEntities {

	
	public static void registerEntities() {
		
		registerEntity("giozombie", EntityGioZombie.class, Reference.ENTITY_GIO_ZOMBIE, 50, 39680, 11437146);
		registerEntity("turtle", EntityTurtle.class, Reference.ENTITY_TURTLE, 50, 1403904, 6962944);
		registerEntity("rat", EntityRat.class, Reference.ENTITY_RAT, 50, 4013629, 16752383);
		
	}
	
	private static void registerEntity(String name, Class<? extends Entity> entity, int id, int range, int color1, int color2) {
		
		EntityRegistry.registerModEntity(new ResourceLocation(Reference.MOD_ID + ":" + name), entity, name, id, Main.instance, range, 1, true, color1, color2);
		
	}
	
}
