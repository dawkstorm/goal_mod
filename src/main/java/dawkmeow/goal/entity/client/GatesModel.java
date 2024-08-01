package dawkmeow.goal.entity.client;

import dawkmeow.goal.entity.custom.GatesEntity;
import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.client.render.entity.model.SinglePartEntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.Entity;

public class GatesModel<T extends GatesEntity> extends SinglePartEntityModel<T> {
	private final ModelPart gates;
	public GatesModel(ModelPart root) {
		this.gates = root.getChild("gates");
	}
	public static TexturedModelData getTexturedModelData() {
		ModelData modelData = new ModelData();
		ModelPartData modelPartData = modelData.getRoot();
		ModelPartData gates = modelPartData.addChild("gates", ModelPartBuilder.create().uv(0, 39).cuboid(-32.0F, -3.0F, 24.0F, 48.0F, 3.0F, 2.0F, new Dilation(0.0F))
				.uv(0, 44).cuboid(-31.0F, -33.0F, 0.0F, 46.0F, 2.0F, 2.0F, new Dilation(0.0F)), ModelTransform.pivot(8.0F, 24.0F, -8.0F));

		ModelPartData right_side2 = gates.addChild("right_side2", ModelPartBuilder.create().uv(24, 48).cuboid(-5.0F, -29.0F, -15.0F, 2.0F, 32.0F, 2.0F, new Dilation(0.0F)), ModelTransform.pivot(-28.0F, -3.0F, 15.0F));

		ModelPartData cube_r1 = right_side2.addChild("cube_r1", ModelPartBuilder.create().uv(0, 48).cuboid(0.0F, -38.0F, 0.0F, 2.0F, 38.0F, 2.0F, new Dilation(0.0F)), ModelTransform.of(-5.0F, 3.0F, 9.0F, 0.6545F, 0.0F, 0.0F));

		ModelPartData left_side = gates.addChild("left_side", ModelPartBuilder.create().uv(16, 48).cuboid(3.0F, -30.0F, -15.0F, 2.0F, 33.0F, 2.0F, new Dilation(0.0F)), ModelTransform.pivot(12.0F, -3.0F, 15.0F));

		ModelPartData cube_r2 = left_side.addChild("cube_r2", ModelPartBuilder.create().uv(8, 48).cuboid(-2.0F, -38.0F, 0.0F, 2.0F, 38.0F, 2.0F, new Dilation(0.0F)), ModelTransform.of(5.0F, 3.0F, 9.0F, 0.6545F, 0.0F, 0.0F));

		ModelPartData net2 = gates.addChild("net2", ModelPartBuilder.create(), ModelTransform.pivot(-16.0F, 0.0F, 0.0F));

		ModelPartData cube_r3 = net2.addChild("cube_r3", ModelPartBuilder.create().uv(0, 0).cuboid(-40.0F, -37.0F, -1.0F, 46.0F, 38.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(-9.0F, -3.0F, 23.1F, 2.4871F, 0.0F, 3.1416F));
		return TexturedModelData.of(modelData, 128, 128);
	}
	@Override
	public void setAngles(GatesEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
	}
	@Override
	public void render(MatrixStack matrices, VertexConsumer vertexConsumer, int light, int overlay, float red, float green, float blue, float alpha) {
		gates.render(matrices, vertexConsumer, light, overlay, red, green, blue, alpha);
	}

	@Override
	public ModelPart getPart() {
		return gates;
	}

}