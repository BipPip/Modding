package com.pipypipys.firstmod.entity.render;

import com.pipypipys.firstmod.util.Reference;

import com.pipypipys.firstmod.entity.EntityTurtle;
import com.pipypipys.firstmod.entity.model.ModelTurtle;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;

public class RenderTurtle extends RenderLiving<EntityTurtle> {
	
	
	public static final ResourceLocation TEXTURES = new ResourceLocation(Reference.MOD_ID + ":textures/entities/turtle.png");
	
	public RenderTurtle(RenderManager manager) {
		super(manager, new ModelTurtle(), 0.5F /*Shadow Size*/);
		
	}
	
	@Override
	protected ResourceLocation getEntityTexture(EntityTurtle entity) {
		return TEXTURES;
		
	}
	
	@Override
	protected void applyRotations(EntityTurtle entityLiving, float p_77043_2_, float rotationYaw,
			float partialTicks) {
		// TODO Auto-generated method stub
		super.applyRotations(entityLiving, p_77043_2_, rotationYaw, partialTicks);
	}
	

}
