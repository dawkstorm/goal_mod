package dawkmeow.goal.entity.client;

import dawkmeow.goal.GoalMod;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.util.Identifier;

public class ModModelLayers {
    public static final EntityModelLayer BEAR =
            new EntityModelLayer(new Identifier(GoalMod.MOD_ID, "bear"), "main");
}
