package dawkmeow.goal;

import dawkmeow.goal.block.ModBlocks;
import dawkmeow.goal.entity.ModEntities;
import dawkmeow.goal.entity.custom.BearEntity;
import dawkmeow.goal.entity.custom.GatesEntity;
import dawkmeow.goal.item.ModItems;
import dawkmeow.goal.item.ModItemGroups;
import dawkmeow.goal.sound.ModSounds;
import dawkmeow.goal.util.ModLootTableModifiers;
import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class GoalMod implements ModInitializer {
    public static final String MOD_ID = "goal_mod";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    @Override
    public void onInitialize() {
        LOGGER.info("Hello Fabric world!");
        ModItemGroups.registerItemGroups();
        ModItems.registerModItems();
        ModBlocks.registerBlocks();
        ModEntities.registerModEntities();
        FabricDefaultAttributeRegistry.register(ModEntities.BEAR, BearEntity.createBearAttributes());
        FabricDefaultAttributeRegistry.register(ModEntities.GATES, GatesEntity.createGatesAttributes());
        ModSounds.registerSounds();
        ModLootTableModifiers.modifyLootTables();
    }
}