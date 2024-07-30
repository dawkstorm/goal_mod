package dawkmeow.goal.item;

import dawkmeow.goal.GoalMod;
import dawkmeow.goal.block.ModBlocks;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;


public class ModItems {
    public static final Item BALL = registerItem("ball", new Item(new Item.Settings()));
    public static final Item GATES = registerItem("gates", new Item(new Item.Settings()));


    private static Item registerItem(String itemName, Item item){
        return Registry.register(Registries.ITEM, new Identifier(GoalMod.MOD_ID, itemName), item);
    }

    public static void registerModItems(){
        GoalMod.LOGGER.info("Registering items in " + GoalMod.MOD_ID + "...");
    }
}
