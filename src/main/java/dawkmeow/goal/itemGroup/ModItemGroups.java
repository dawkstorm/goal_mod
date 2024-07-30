package dawkmeow.goal.itemGroup;

import dawkmeow.goal.GoalMod;
import dawkmeow.goal.block.ModBlocks;
import dawkmeow.goal.item.ModItems;
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
            }).build());

    public static void registerItemGroups(){
        GoalMod.LOGGER.info("Registering item groups...");
    }

}
