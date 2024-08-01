package dawkmeow.goal.item;

import dawkmeow.goal.GoalMod;
import dawkmeow.goal.entity.ModEntities;
import dawkmeow.goal.item.custom.GatesSpawnItem;
import dawkmeow.goal.item.custom.BrokenBottleItem;
import dawkmeow.goal.item.custom.EmptyBottleItem;
import dawkmeow.goal.item.custom.VodkaBottleItem;
import net.minecraft.item.Item;
import net.minecraft.item.SpawnEggItem;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;


public class ModItems {
    public static final Item BALL = registerItem("ball", new Item(new Item.Settings()));
    public static final Item GATES = registerItem("gates", new GatesSpawnItem(new Item.Settings()));
    public static final Item BEAR_SPAWN_EGG = registerItem("bear_spawn_egg", new SpawnEggItem(ModEntities.BEAR, 0x0b962e, 0xffffff, new Item.Settings()));

    public static final Item EMPTY_VODKA_BOTTLE = registerItem("empty_vodka_bottle",
            new EmptyBottleItem(new Item.Settings().maxCount(1)));
    public static final Item BROKEN_VODKA_BOTTLE = registerItem("broken_vodka_bottle",
            new BrokenBottleItem(new Item.Settings().maxDamage(75)
            .attributeModifiers(BrokenBottleItem.createAttributeModifiers(15)).maxCount(1)));
    public static final Item VODKA_BOTTLE = registerItem("vodka_bottle",
            new VodkaBottleItem(new Item.Settings().maxCount(1)));


    private static Item registerItem(String itemName, Item item){
        return Registry.register(Registries.ITEM, new Identifier(GoalMod.MOD_ID, itemName), item);
    }

    public static void registerModItems(){
        GoalMod.LOGGER.info("Registering items in " + GoalMod.MOD_ID + "...");
    }
}
