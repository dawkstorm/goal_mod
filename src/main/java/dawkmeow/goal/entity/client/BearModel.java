package dawkmeow.goal.entity.client;

import dawkmeow.goal.entity.animation.ModAnimations;
import dawkmeow.goal.entity.custom.BearEntity;
import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.SinglePartEntityModel;
import net.minecraft.client.util.math.MatrixStack;

// Made with Blockbench 4.10.4
// Exported for Minecraft version 1.17+ for Yarn
// Paste this class into your mod and generate all required imports
public class BearModel<T extends BearEntity> extends SinglePartEntityModel<T> {
	private final ModelPart Bear;
	public BearModel(ModelPart root) {
		this.Bear = root.getChild("Bear");
	}
	public static TexturedModelData getTexturedModelData() {
		ModelData modelData = new ModelData();
		ModelPartData modelPartData = modelData.getRoot();
		ModelPartData Bear = modelPartData.addChild("Bear", ModelPartBuilder.create(), ModelTransform.of(0.0F, 24.0F, 0.0F, 0.0F, 3.1416F, 0.0F));

		ModelPartData head = Bear.addChild("head", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, -8.0F, 0.0F));

		ModelPartData ear_right_r1 = head.addChild("ear_right_r1", ModelPartBuilder.create().uv(0, 0).cuboid(-2.0F, -2.5F, -2.0F, 4.0F, 2.0F, 2.0F, new Dilation(0.0F)), ModelTransform.of(2.0F, -23.0F, 0.0F, 0.0F, -1.5708F, 0.0F));

		ModelPartData ear_left_r1 = head.addChild("ear_left_r1", ModelPartBuilder.create().uv(0, 4).cuboid(-2.0F, -2.5F, -2.0F, 4.0F, 2.0F, 2.0F, new Dilation(0.0F)), ModelTransform.of(-2.0F, -23.0F, 0.0F, 0.0F, 1.5708F, 0.0F));

		ModelPartData head_r1 = head.addChild("head_r1", ModelPartBuilder.create().uv(34, 0).cuboid(-3.0F, -4.0F, -3.0F, 6.0F, 5.0F, 6.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, -21.0F, 0.0F, 0.0F, 1.5708F, 0.0F));

		ModelPartData leg_right = Bear.addChild("leg_right", ModelPartBuilder.create().uv(0, 49).cuboid(1.0F, 0.0F, -3.0F, 5.0F, 13.0F, 6.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, -13.0F, 0.0F));

		ModelPartData leg_left = Bear.addChild("leg_left", ModelPartBuilder.create().uv(22, 52).cuboid(-6.0F, 0.0F, -3.0F, 5.0F, 13.0F, 6.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, -13.0F, 0.0F));

		ModelPartData arm_right = Bear.addChild("arm_right", ModelPartBuilder.create(), ModelTransform.pivot(7.0F, -22.0F, 0.0F));

		ModelPartData arm_right_r1 = arm_right.addChild("arm_right_r1", ModelPartBuilder.create().uv(27, 36).cuboid(-1.0F, 0.0F, -6.0F, 3.0F, 3.0F, 13.0F, new Dilation(0.0F)), ModelTransform.of(4.0F, 2.0F, 12.0F, -2.8505F, 0.3394F, -2.7573F));

		ModelPartData shoulder_right_r1 = arm_right.addChild("shoulder_right_r1", ModelPartBuilder.create().uv(33, 14).cuboid(-2.0F, -1.0F, -8.0F, 5.0F, 5.0F, 15.0F, new Dilation(0.0F)), ModelTransform.of(2.0F, -1.0F, 2.0F, -2.7489F, -0.7854F, 3.1416F));

		ModelPartData arm_left = Bear.addChild("arm_left", ModelPartBuilder.create(), ModelTransform.pivot(-7.0F, -22.0F, 0.0F));

		ModelPartData shoulder_left_r1 = arm_left.addChild("shoulder_left_r1", ModelPartBuilder.create().uv(0, 29).cuboid(-3.0F, -1.0F, -8.0F, 5.0F, 5.0F, 15.0F, new Dilation(0.0F)), ModelTransform.of(-2.0F, -1.0F, 2.0F, -2.7489F, 0.7854F, -3.1416F));

		ModelPartData arm_left_r1 = arm_left.addChild("arm_left_r1", ModelPartBuilder.create().uv(46, 39).cuboid(-2.0F, 0.0F, -6.0F, 3.0F, 3.0F, 13.0F, new Dilation(0.0F)), ModelTransform.of(-4.0F, 2.0F, 12.0F, -2.8505F, -0.3394F, 2.7573F));

		ModelPartData body = Bear.addChild("body", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, -8.0F, 0.0F));

		ModelPartData body_r1 = body.addChild("body_r1", ModelPartBuilder.create().uv(0, 0).cuboid(-5.0F, -6.0F, -7.0F, 10.0F, 15.0F, 14.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, -14.0F, 0.0F, 0.0F, -1.5708F, 0.0F));
		return TexturedModelData.of(modelData, 128, 128);
	}
	@Override
	public void setAngles(BearEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.getPart().traverse().forEach(ModelPart::resetTransform);

		this.animateMovement(ModAnimations.WALKING, limbSwing, limbSwingAmount, 2f, 2.5f);
		this.updateAnimation(entity.attackAnimationState, ModAnimations.THROW_UP_ATTACK, ageInTicks, 1f);
	}

	@Override
	public void render(MatrixStack matrices, VertexConsumer vertexConsumer, int light, int overlay, float red, float green, float blue, float alpha) {
		Bear.render(matrices, vertexConsumer, light, overlay, red, green, blue, alpha);
	}

	@Override
	public ModelPart getPart() {
		return Bear;
	}
}