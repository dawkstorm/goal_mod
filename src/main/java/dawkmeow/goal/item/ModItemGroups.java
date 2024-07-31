package dawkmeow.goal.item;

import dawkmeow.goal.GoalMod;
import dawkmeow.goal.block.ModBlocks;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItemGroups {

    public static final ItemGroup GOAL_GROUP = Registry.register(Registries.ITEM_GROUP,
            new Identifier(GoalMod.MOD_ID, "goal_group"),
            FabricItemGroup.builder().displayName(Text.translatable("itemGroup.goal_mod.goal_group")).icon(() -> new ItemStack(ModItems.BALL)).entries((displayContext, entries) -> {
                entries.add(ModItems.BALL);
                entries.add(ModItems.GATES);
                entries.add(ModBlocks.СARDS_STACK);
                entries.add(ModItems.VODKA_BOTTLE);
                entries.add(ModItems.EMPTY_VODKA_BOTTLE);
                entries.add(ModItems.BROKEN_VODKA_BOTTLE);
            }).build());

    public static void registerItemGroups(){
        GoalMod.LOGGER.info("Registering item groups...");
    }

}
