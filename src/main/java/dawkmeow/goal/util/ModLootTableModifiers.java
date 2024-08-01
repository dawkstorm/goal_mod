package dawkmeow.goal.util;

import dawkmeow.goal.block.ModBlocks;
import dawkmeow.goal.item.ModItems;
import net.fabricmc.fabric.api.loot.v2.LootTableEvents;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.condition.RandomChanceLootCondition;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.function.SetCountLootFunction;
import net.minecraft.loot.provider.number.ConstantLootNumberProvider;
import net.minecraft.loot.provider.number.UniformLootNumberProvider;
import net.minecraft.util.Identifier;

public class ModLootTableModifiers {

    private static final Identifier MINESHAFT_ID = new Identifier("minecraft", "chests/abandoned_mineshaft");
    private static final Identifier PILLAGER_OUTPOST_ID = new Identifier("minecraft", "chests/pillager_outpost");
    private static final Identifier STRONGHOLD_LIBRARY_ID = new Identifier("minecraft", "chests/stronghold_library");

    public static void modifyLootTables(){
        LootTableEvents.MODIFY.register((key, tableBuilder, source) -> {
            if(MINESHAFT_ID.equals(key.getValue())){
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(0.3f))
                        .with(ItemEntry.builder(ModBlocks.СARDS_STACK))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 1.0f)));

                tableBuilder.pool(poolBuilder.build());
            }

            if(PILLAGER_OUTPOST_ID.equals(key.getValue())){
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(0.3f))
                        .with(ItemEntry.builder(ModBlocks.СARDS_STACK))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 1.0f)));

                tableBuilder.pool(poolBuilder.build());
            }

            if(STRONGHOLD_LIBRARY_ID.equals(key.getValue())){
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(0.3f))
                        .with(ItemEntry.builder(ModBlocks.СARDS_STACK))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 1.0f)));

                tableBuilder.pool(poolBuilder.build());
            }
        });
    }

}
