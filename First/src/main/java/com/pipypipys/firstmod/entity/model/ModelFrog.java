package com.pipypipys.firstmod.entity.model;
//Made with Blockbench


import org.lwjgl.opengl.GL11;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelBox;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.Entity;

public class ModelFrog extends ModelBase {
	private final ModelRenderer frog;
	private final ModelRenderer head;
	private final ModelRenderer body;
	private final ModelRenderer frontRightLeg;
	private final ModelRenderer frontLeftLeg;
	private final ModelRenderer backLeftLeg;
	private final ModelRenderer backRightLeg;
	private final ModelRenderer bone;
	private final ModelRenderer bone2;
	private final ModelRenderer bone3;

	public ModelFrog() {
		textureWidth = 64;
		textureHeight = 64;

		frog = new ModelRenderer(this);
		frog.setRotationPoint(0.0F, 24.0F, -1.0F);

		head = new ModelRenderer(this);
		head.setRotationPoint(0.0F, 0.0F, 0.0F);
		frog.addChild(head);

		body = new ModelRenderer(this);
		body.setRotationPoint(0.0F, 0.0F, 0.0F);
		setRotationAngle(body, -0.2618F, 0.0F, 0.0F);
		frog.addChild(body);
		body.cubeList.add(new ModelBox(body, 0, 17, -2.0F, -4.0F, -3.0F, 4, 2, 8, 0.0F, false));

		frontRightLeg = new ModelRenderer(this);
		frontRightLeg.setRotationPoint(0.0F, 0.0F, 0.0F);
		frog.addChild(frontRightLeg);
		frontRightLeg.cubeList.add(new ModelBox(frontRightLeg, 0, 8, -2.0F, -3.0F, -1.0F, 1, 3, 1, 0.0F, false));

		frontLeftLeg = new ModelRenderer(this);
		frontLeftLeg.setRotationPoint(0.0F, 0.0F, 0.0F);
		frog.addChild(frontLeftLeg);
		frontLeftLeg.cubeList.add(new ModelBox(frontLeftLeg, 0, 8, 1.0F, -3.0F, -1.0F, 1, 3, 1, 0.0F, false));

		backLeftLeg = new ModelRenderer(this);
		backLeftLeg.setRotationPoint(0.0F, 0.0F, 0.0F);
		setRotationAngle(backLeftLeg, 0.0F, -0.1745F, 0.0F);
		frog.addChild(backLeftLeg);
		backLeftLeg.cubeList.add(new ModelBox(backLeftLeg, 0, 8, 2.0F, -1.0F, 2.0F, 2, 1, 3, 0.0F, false));

		backRightLeg = new ModelRenderer(this);
		backRightLeg.setRotationPoint(0.0F, 0.0F, 0.0F);
		setRotationAngle(backRightLeg, 0.0F, 0.1745F, 0.0F);
		frog.addChild(backRightLeg);
		backRightLeg.cubeList.add(new ModelBox(backRightLeg, 0, 8, -4.0F, -1.0F, 2.0F, 2, 1, 3, 0.0F, false));

		bone = new ModelRenderer(this);
		bone.setRotationPoint(0.0F, 0.0F, 0.0F);
		frog.addChild(bone);

		bone2 = new ModelRenderer(this);
		bone2.setRotationPoint(0.0F, 0.0F, 0.0F);
		frog.addChild(bone2);

		bone3 = new ModelRenderer(this);
		bone3.setRotationPoint(0.0F, 0.0F, 0.0F);
		frog.addChild(bone3);
	}

	@Override
	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
		frog.render(f5);
	}
	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}
}