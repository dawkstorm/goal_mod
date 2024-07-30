package dawkmeow.goal.entity.client;

import dawkmeow.goal.GoalMod;
import dawkmeow.goal.entity.custom.BearEntity;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.util.Identifier;

public class BearRenderer extends MobEntityRenderer<BearEntity, BearModel<BearEntity>> {
    private static final Identifier TEXTURE = new Identifier(GoalMod.MOD_ID, "textures/entity/bear_texture.png");

    public BearRenderer(EntityRendererFactory.Context context) {
        super(context, new BearModel<>(context.getPart(ModModelLayers.BEAR)), 1.5f);
    }

    @Override
    public Identifier getTexture(BearEntity entity) {
        return TEXTURE;
    }
}
