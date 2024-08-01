package dawkmeow.goal.entity.client;

import dawkmeow.goal.GoalMod;
import dawkmeow.goal.entity.custom.GatesEntity;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.LivingEntityRenderer;
import net.minecraft.util.Identifier;

public class GatesRenderer extends LivingEntityRenderer<GatesEntity, GatesModel<GatesEntity>> {
    private static final Identifier TEXTURE = new Identifier(GoalMod.MOD_ID, "textures/entity/gates_texture.png");

    public GatesRenderer(EntityRendererFactory.Context context) {
        super(context, new GatesModel<>(context.getPart(ModModelLayers.GATES)), 1.5f);
    }

    @Override
    protected boolean hasLabel(GatesEntity livingEntity) {
        return false;
    }

    @Override
    public Identifier getTexture(GatesEntity entity) {
        return TEXTURE;
    }
}
