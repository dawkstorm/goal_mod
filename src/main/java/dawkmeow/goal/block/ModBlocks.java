package dawkmeow.goal.block;
import dawkmeow.goal.GoalMod;
import dawkmeow.goal.block.custom.CardsStackBlock;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModBlocks {

    public static final Block СARDS_STACK = registerBlock("cards_stack",
            new CardsStackBlock(AbstractBlock.Settings.copy(Blocks.WHITE_CARPET)));

    private static Block registerBlock(String name, Block block){
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, new Identifier(GoalMod.MOD_ID, name), block);
    }

    private static Item registerBlockItem(String name, Block block){
        return Registry.register(Registries.ITEM, new Identifier(GoalMod.MOD_ID, name), new BlockItem(block, new Item.Settings()));
    }

    public static void registerBlocks(){
        GoalMod.LOGGER.info("Registering blocks for " + GoalMod.MOD_ID);
    }
}
