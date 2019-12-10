package com.pipypipys.firstmod.entity.render;

import com.pipypipys.firstmod.util.Reference;
import com.pipypipys.firstmod.entity.EntityFrog;
import com.pipypipys.firstmod.entity.EntityRat;
import com.pipypipys.firstmod.entity.model.ModelFrog;
import com.pipypipys.firstmod.entity.model.ModelRat;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;

public class RenderFrog extends RenderLiving<EntityFrog> {
	
	
	public static final ResourceLocation TEXTURES = new ResourceLocation(Reference.MOD_ID + ":textures/entities/frog.png");
	
	public RenderFrog(RenderManager manager) {
		super(manager, new ModelFrog(), 0.5F /*Shadow Size*/);
		
	}
	
	@Override
	protected ResourceLocation getEntityTexture(EntityFrog entity) {
		return TEXTURES;
		
	}
	
	@Override
	protected void applyRotations(EntityFrog entityLiving, float p_77043_2_, float rotationYaw,
			float partialTicks) {
		// TODO Auto-generated method stub
		super.applyRotations(entityLiving, p_77043_2_, rotationYaw, partialTicks);
	}
	

}
