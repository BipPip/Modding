package com.pipypipys.firstmod.entity.model;


import org.lwjgl.opengl.GL11;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelBox;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;

public class ModelRat extends ModelBase {
	private final ModelRenderer rat;
	private final ModelRenderer feet;
	private final ModelRenderer frontLeftFoot;
	private final ModelRenderer frontRightFoot;
	private final ModelRenderer backLeftFoot;
	private final ModelRenderer backRightFoot;
	private final ModelRenderer body;
	private final ModelRenderer tail;
	private final ModelRenderer head;
	private final ModelRenderer ears;
	private final ModelRenderer eyes;
	private final ModelRenderer skull;

	public ModelRat() {
		textureWidth = 64;
		textureHeight = 64;

		rat = new ModelRenderer(this);
		rat.setRotationPoint(0.0F, 24.0F, 0.0F);

		feet = new ModelRenderer(this);
		feet.setRotationPoint(0.0F, 0.0F, 0.0F);
		rat.addChild(feet);

		frontLeftFoot = new ModelRenderer(this);
		frontLeftFoot.setRotationPoint(0.0F, 0.0F, 0.0F);
		feet.addChild(frontLeftFoot);
		frontLeftFoot.cubeList.add(new ModelBox(frontLeftFoot, 0, 0, 1.0F, -2.0F, -5.0F, 3, 2, 4, 0.0F, false));

		frontRightFoot = new ModelRenderer(this);
		frontRightFoot.setRotationPoint(0.0F, 0.0F, 0.0F);
		feet.addChild(frontRightFoot);
		frontRightFoot.cubeList.add(new ModelBox(frontRightFoot, 0, 0, -5.0F, -2.0F, -5.0F, 3, 2, 4, 0.0F, false));

		backLeftFoot = new ModelRenderer(this);
		backLeftFoot.setRotationPoint(0.0F, 0.0F, 0.0F);
		feet.addChild(backLeftFoot);
		backLeftFoot.cubeList.add(new ModelBox(backLeftFoot, 0, 0, -6.0F, -2.0F, 3.0F, 3, 2, 4, 0.0F, false));

		backRightFoot = new ModelRenderer(this);
		backRightFoot.setRotationPoint(0.0F, 0.0F, 0.0F);
		feet.addChild(backRightFoot);
		backRightFoot.cubeList.add(new ModelBox(backRightFoot, 0, 0, 2.0F, -2.0F, 3.0F, 3, 2, 4, 0.0F, false));

		body = new ModelRenderer(this);
		body.setRotationPoint(0.0F, 0.0F, 0.0F);
		rat.addChild(body);
		body.cubeList.add(new ModelBox(body, 0, 22, -5.0F, -7.0F, -4.0F, 9, 6, 7, 0.0F, false));
		body.cubeList.add(new ModelBox(body, 0, 37, -6.0F, -8.0F, 1.0F, 11, 7, 6, 0.0F, false));
		body.cubeList.add(new ModelBox(body, 0, 6, -5.0F, -7.0F, 7.0F, 9, 5, 2, 0.0F, false));
		body.cubeList.add(new ModelBox(body, 0, 6, -3.0F, -6.0F, 8.0F, 5, 3, 3, 0.0F, false));

		tail = new ModelRenderer(this);
		tail.setRotationPoint(0.0F, 0.0F, 0.0F);
		body.addChild(tail);
		tail.cubeList.add(new ModelBox(tail, 28, 6, -1.0F, -5.0F, 11.0F, 1, 1, 2, 0.0F, false));
		tail.cubeList.add(new ModelBox(tail, 28, 6, -2.0F, -5.0F, 13.0F, 1, 1, 2, 0.0F, false));
		tail.cubeList.add(new ModelBox(tail, 28, 6, -2.0F, -4.0F, 15.0F, 1, 1, 3, 0.0F, false));

		head = new ModelRenderer(this);
		head.setRotationPoint(0.0F, 0.0F, 0.0F);
		rat.addChild(head);

		ears = new ModelRenderer(this);
		ears.setRotationPoint(0.0F, 0.0F, 0.0F);
		head.addChild(ears);
		ears.cubeList.add(new ModelBox(ears, 51, 46, -4.0F, -7.0F, -7.0F, 2, 2, 1, 0.0F, false));
		ears.cubeList.add(new ModelBox(ears, 0, 51, 1.0F, -7.0F, -7.0F, 2, 2, 1, 0.0F, false));

		eyes = new ModelRenderer(this);
		eyes.setRotationPoint(0.0F, 0.0F, 0.0F);
		head.addChild(eyes);
		eyes.cubeList.add(new ModelBox(eyes, 50, 57, -3.0F, -6.0F, -7.0F, 1, 1, 1, 0.0F, false));
		eyes.cubeList.add(new ModelBox(eyes, 50, 57, 1.0F, -6.0F, -7.0F, 1, 1, 1, 0.0F, false));

		skull = new ModelRenderer(this);
		skull.setRotationPoint(0.0F, 0.0F, 0.0F);
		head.addChild(skull);
		skull.cubeList.add(new ModelBox(skull, 24, 55, -3.0F, -6.0F, -7.0F, 5, 4, 5, 0.0F, false));
		skull.cubeList.add(new ModelBox(skull, 24, 55, -2.0F, -5.0F, -9.0F, 3, 3, 2, 0.0F, false));
		skull.cubeList.add(new ModelBox(skull, 51, 46, -1.0F, -4.0F, -10.0F, 1, 1, 1, 0.0F, false));
	}

	@Override
	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
		rat.render(f5);
	}
public void setRotationAngles(float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor, Entity entityIn) {
		
		//Animations
		
		this.frontRightFoot.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 0.5F * limbSwingAmount;
		this.frontLeftFoot.rotateAngleX = -1 * (MathHelper.cos(limbSwing * 0.6662F) * 0.5F * limbSwingAmount);
		
		this.backLeftFoot.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 0.2F * limbSwingAmount;
		this.backRightFoot.rotateAngleX = -1 * (MathHelper.cos(limbSwing * 0.6662F) * 0.5F * limbSwingAmount);
		
		
		this.tail.rotateAngleY = (MathHelper.cos(limbSwing * 0.6662F) * 0.5F * limbSwingAmount) / 5;
		
		
		this.head.rotateAngleY = (netHeadYaw * 0.017453292F) / 4;

		this.head.rotateAngleX = (headPitch * 0.017453292F) / 2;

		
	}
}