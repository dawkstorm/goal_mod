package dawkmeow.goal.entity;

import dawkmeow.goal.GoalMod;
import dawkmeow.goal.entity.custom.BearEntity;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModEntities {

    public static final EntityType<BearEntity> BEAR = Registry.register(Registries.ENTITY_TYPE,
            new Identifier(GoalMod.MOD_ID, "bear"),
            FabricEntityTypeBuilder.create(SpawnGroup.MONSTER, BearEntity::new).dimensions(EntityDimensions.fixed(1f, 2.1f)).build());

    public static void registerModEntities() {
        GoalMod.LOGGER.info("Registering Entities for " + GoalMod.MOD_ID);
    }
}
