package com.pipypipys.firstmod.entity.model;

import org.lwjgl.opengl.GL11;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelBox;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;

public class ModelTurtle extends ModelBase {
	private final ModelRenderer turtle;
	private final ModelRenderer head;
	private final ModelRenderer body;
	private final ModelRenderer frontRightLeg;
	private final ModelRenderer frontLeftLeg;
	private final ModelRenderer backLeftLeg;
	private final ModelRenderer backRightLeg;

	public ModelTurtle() {
		textureWidth = 64;
		textureHeight = 64;

		turtle = new ModelRenderer(this);
		turtle.setRotationPoint(0.0F, 24.0F, 0.0F);

		head = new ModelRenderer(this);
		head.setRotationPoint(0.0F, 0.0F, 0.0F);
		turtle.addChild(head);
		head.cubeList.add(new ModelBox(head, 54, 0, 1.0F, -5.0F, -8.0F, 1, 2, 1, 0.0F, false));
		head.cubeList.add(new ModelBox(head, 60, 0, -2.0F, -5.0F, -8.0F, 1, 2, 1, 0.0F, false));
		head.cubeList.add(new ModelBox(head, 0, 0, -2.0F, -5.0F, -8.0F, 4, 4, 3, 0.0F, false));

		body = new ModelRenderer(this);
		body.setRotationPoint(0.0F, 0.0F, 0.0F);
		turtle.addChild(body);
		body.cubeList.add(new ModelBox(body, 0, 17, -4.0F, -4.0F, -5.0F, 8, 2, 10, 0.0F, false));
		body.cubeList.add(new ModelBox(body, 0, 17, -3.0F, -5.0F, -4.0F, 6, 1, 8, 0.0F, false));
		body.cubeList.add(new ModelBox(body, 0, 17, -2.0F, -6.0F, -3.0F, 4, 1, 6, 0.0F, false));

		frontRightLeg = new ModelRenderer(this);
		frontRightLeg.setRotationPoint(0.0F, 0.0F, 0.0F);
		turtle.addChild(frontRightLeg);
		frontRightLeg.cubeList.add(new ModelBox(frontRightLeg, 0, 8, -4.0F, -2.0F, -5.0F, 2, 2, 2, 0.0F, false));

		frontLeftLeg = new ModelRenderer(this);
		frontLeftLeg.setRotationPoint(0.0F, 0.0F, 0.0F);
		turtle.addChild(frontLeftLeg);
		frontLeftLeg.cubeList.add(new ModelBox(frontLeftLeg, 0, 8, 2.0F, -2.0F, -5.0F, 2, 2, 2, 0.0F, false));

		backLeftLeg = new ModelRenderer(this);
		backLeftLeg.setRotationPoint(0.0F, 0.0F, 0.0F);
		turtle.addChild(backLeftLeg);
		backLeftLeg.cubeList.add(new ModelBox(backLeftLeg, 0, 8, 2.0F, -2.0F, 3.0F, 2, 2, 2, 0.0F, false));

		backRightLeg = new ModelRenderer(this);
		backRightLeg.setRotationPoint(0.0F, 0.0F, 0.0F);
		turtle.addChild(backRightLeg);
		backRightLeg.cubeList.add(new ModelBox(backRightLeg, 0, 8, -4.0F, -2.0F, 3.0F, 2, 2, 2, 0.0F, false));
	}

	@Override
	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
		turtle.render(f5);
	}
public void setRotationAngles(float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor, Entity entityIn) {
		
		//Animations
		
		this.frontRightLeg.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 0.5F * limbSwingAmount;
		this.frontLeftLeg.rotateAngleX = -1 * (MathHelper.cos(limbSwing * 0.6662F) * 0.5F * limbSwingAmount);
		
		this.backLeftLeg.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 0.2F * limbSwingAmount;
		this.backRightLeg.rotateAngleX = -1 * (MathHelper.cos(limbSwing * 0.6662F) * 0.5F * limbSwingAmount);
		
		
		this.head.rotateAngleY = (netHeadYaw * 0.017453292F) / 4;

		this.head.rotateAngleX = (headPitch * 0.017453292F) / 2;

		
	}
}