package dawkmeow.goal.item.custom;

import dawkmeow.goal.entity.ModEntities;
import dawkmeow.goal.entity.custom.GatesEntity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnReason;
import net.minecraft.item.*;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.ActionResult;
import net.minecraft.util.math.*;
import net.minecraft.world.World;
import net.minecraft.world.event.GameEvent;

import java.util.function.Consumer;

public class GatesSpawnItem extends Item {

    public GatesSpawnItem(Settings settings) {
        super(settings);
    }

    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {
        Direction direction = context.getSide();
        if (direction == Direction.DOWN) {
            return ActionResult.FAIL;
        } else {
            World world = context.getWorld();
            ItemPlacementContext itemPlacementContext = new ItemPlacementContext(context);
            BlockPos blockPos = itemPlacementContext.getBlockPos();
            ItemStack itemStack = context.getStack();
            Vec3d vec3d = Vec3d.ofBottomCenter(blockPos);
            Box box = ModEntities.GATES.getDimensions().getBoxAt(vec3d.getX(), vec3d.getY(), vec3d.getZ());
            if (world.isSpaceEmpty(null, box) && world.getOtherEntities(null, box).isEmpty()) {
                if (world instanceof ServerWorld serverWorld) {
                    Consumer<GatesEntity> consumer = EntityType.copier(serverWorld, itemStack, context.getPlayer());
                    GatesEntity gatesEntity = ModEntities.GATES.create(serverWorld, consumer, blockPos, SpawnReason.SPAWN_EGG, true, true);
                    if (gatesEntity == null) {
                        return ActionResult.FAIL;
                    }

                    float f = (float) MathHelper.floor((MathHelper.wrapDegrees(context.getPlayerYaw() - 180.0F) + 22.5F) / 45.0F) * 45.0F;
                    gatesEntity.refreshPositionAndAngles(gatesEntity.getX(), gatesEntity.getY(), gatesEntity.getZ(), f, 0.0F);
                    serverWorld.spawnEntityAndPassengers(gatesEntity);
                    world.playSound(
                            null, gatesEntity.getX(), gatesEntity.getY(), gatesEntity.getZ(), SoundEvents.ENTITY_ARMOR_STAND_PLACE, SoundCategory.BLOCKS, 0.75F, 0.8F
                    );
                    gatesEntity.emitGameEvent(GameEvent.ENTITY_PLACE, context.getPlayer());
                }

                itemStack.decrement(1);
                return ActionResult.success(world.isClient);
            } else {
                return ActionResult.FAIL;
            }
        }
    }
}
