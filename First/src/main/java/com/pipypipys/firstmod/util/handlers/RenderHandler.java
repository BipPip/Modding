package com.pipypipys.firstmod.util.handlers;

import com.pipypipys.firstmod.entity.EntityFrog;
import com.pipypipys.firstmod.entity.EntityGioZombie;
import com.pipypipys.firstmod.entity.EntityRat;
import com.pipypipys.firstmod.entity.EntityTurtle;
import com.pipypipys.firstmod.entity.render.RenderFrog;
import com.pipypipys.firstmod.entity.render.RenderGioZombie;
import com.pipypipys.firstmod.entity.render.RenderRat;
import com.pipypipys.firstmod.entity.render.RenderTurtle;

import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraftforge.fml.client.registry.IRenderFactory;
import net.minecraftforge.fml.client.registry.RenderingRegistry;

public class RenderHandler {

	public static void registerEntityRenders() {
		
		RenderingRegistry.registerEntityRenderingHandler(EntityGioZombie.class, new IRenderFactory<EntityGioZombie>() {
			@Override
			public Render<? super EntityGioZombie> createRenderFor(RenderManager manager) {
				// TODO Auto-generated method stub
				return new RenderGioZombie(manager);
			}
		});
		
		RenderingRegistry.registerEntityRenderingHandler(EntityTurtle.class, new IRenderFactory<EntityTurtle>() {
			@Override
			public Render<? super EntityTurtle> createRenderFor(RenderManager manager) {
				// TODO Auto-generated method stub
				return new RenderTurtle(manager);
			}
		});
		RenderingRegistry.registerEntityRenderingHandler(EntityRat.class, new IRenderFactory<EntityRat>() {
			@Override
			public Render<? super EntityRat> createRenderFor(RenderManager manager) {
				// TODO Auto-generated method stub
				return new RenderRat(manager);
			}
		});
		RenderingRegistry.registerEntityRenderingHandler(EntityFrog.class, new IRenderFactory<EntityFrog>() {
			@Override
			public Render<? super EntityFrog> createRenderFor(RenderManager manager) {
				// TODO Auto-generated method stub
				return new RenderFrog(manager);
			}
		});
		
	}
	
}
