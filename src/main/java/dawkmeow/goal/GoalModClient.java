package dawkmeow.goal;

import dawkmeow.goal.entity.ModEntities;
import dawkmeow.goal.entity.client.*;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;

public class GoalModClient implements ClientModInitializer
{
    @Override
    public void onInitializeClient() {
        EntityRendererRegistry.register(ModEntities.BEAR, BearRenderer::new);
        EntityModelLayerRegistry.registerModelLayer(ModModelLayers.BEAR, BearModel::getTexturedModelData);

        EntityRendererRegistry.register(ModEntities.GATES, GatesRenderer::new);
        EntityModelLayerRegistry.registerModelLayer(ModModelLayers.GATES, GatesModel::getTexturedModelData);

    }
}
