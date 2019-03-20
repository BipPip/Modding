package com.pipypipys.firstmod.entity.render;

import com.pipypipys.firstmod.util.Reference;

import com.pipypipys.firstmod.entity.EntityGioZombie;
import com.pipypipys.firstmod.entity.model.ModelGioZombie;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;

public class RenderGioZombie extends RenderLiving<EntityGioZombie> {
	
	
	public static final ResourceLocation TEXTURES = new ResourceLocation(Reference.MOD_ID + ":textures/entities/giozombie.png");
	
	public RenderGioZombie(RenderManager manager) {
		super(manager, new ModelGioZombie(), 0.5F /*Shadow Size*/);
		
	}
	
	@Override
	protected ResourceLocation getEntityTexture(EntityGioZombie entity) {
		return TEXTURES;
		
	}
	
	@Override
	protected void applyRotations(EntityGioZombie entityLiving, float p_77043_2_, float rotationYaw,
			float partialTicks) {
		// TODO Auto-generated method stub
		super.applyRotations(entityLiving, p_77043_2_, rotationYaw, partialTicks);
	}
	

}
