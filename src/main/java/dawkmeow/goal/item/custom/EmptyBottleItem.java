package dawkmeow.goal.item.custom;

import dawkmeow.goal.item.ModItems;
import dawkmeow.goal.sound.ModSounds;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsage;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.UseAction;
import net.minecraft.world.World;

public class EmptyBottleItem extends Item {

    public EmptyBottleItem(Settings settings) {
        super(settings);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        ItemUsage.consumeHeldItem(world, user, hand);
        return super.use(world, user, hand);
    }

    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {
        context.getStack().setCount(0);
        context.getWorld().playSound(context.getPlayer(), context.getPlayer().getBlockPos(), SoundEvents.BLOCK_GLASS_BREAK, SoundCategory.BLOCKS);
        context.getPlayer().setStackInHand(Hand.MAIN_HAND, new ItemStack(ModItems.BROKEN_VODKA_BOTTLE));
        return super.useOnBlock(context);
    }

    @Override
    public ItemStack finishUsing(ItemStack stack, World world, LivingEntity user) {
        return new ItemStack(ModItems.BROKEN_VODKA_BOTTLE);
    }
}
