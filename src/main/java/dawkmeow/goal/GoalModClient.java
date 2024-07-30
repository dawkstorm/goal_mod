package dawkmeow.goal;

import dawkmeow.goal.entity.ModEntities;
import dawkmeow.goal.entity.client.BearModel;
import dawkmeow.goal.entity.client.BearRenderer;
import dawkmeow.goal.entity.client.ModModelLayers;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;

public class GoalModClient implements ClientModInitializer
{
    @Override
    public void onInitializeClient() {
        EntityRendererRegistry.register(ModEntities.BEAR, BearRenderer::new);
        EntityModelLayerRegistry.registerModelLayer(ModModelLayers.BEAR, BearModel::getTexturedModelData);
    }
}
