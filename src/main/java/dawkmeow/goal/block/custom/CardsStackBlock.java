package dawkmeow.goal.block.custom;

import dawkmeow.goal.GoalMod;
import dawkmeow.goal.entity.ModEntities;
import dawkmeow.goal.entity.custom.BearEntity;
import dawkmeow.goal.entity.custom.GatesEntity;
import net.minecraft.block.Block;
import net.minecraft.block.BlockRenderType;
import net.minecraft.block.BlockState;
import net.minecraft.block.ShapeContext;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.minecraft.world.event.GameEvent;
import org.jetbrains.annotations.Nullable;

import java.util.function.Consumer;

public class CardsStackBlock extends Block {
    private static final VoxelShape SHAPE = Block.createCuboidShape(4,0,2, 11, 8, 13);

    public CardsStackBlock(Settings settings) {
        super(settings);
    }

    @Override
    protected VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return SHAPE;
    }

    @Override
    protected BlockRenderType getRenderType(BlockState state) {
        return BlockRenderType.MODEL;
    }

    @Override
    public void onPlaced(World world, BlockPos pos, BlockState state, @Nullable LivingEntity placer, ItemStack itemStack) {
        super.onPlaced(world, pos, state, placer, itemStack);
        Vec3d vec3d = new Vec3d(pos.getX(), pos.getY() + 1, pos.getZ());
        BlockPos position1Up = new BlockPos(pos.getX(), pos.getY() + 1, pos.getZ());
        Box box = ModEntities.BEAR.getDimensions().getBoxAt(vec3d.getX(), vec3d.getY(), vec3d.getZ());
        if(world.isSpaceEmpty(null, box)){
            if(world instanceof ServerWorld serverWorld){
                if(placer instanceof PlayerEntity player){
                    GoalMod.LOGGER.info("nyaa");
                    Consumer<BearEntity> consumer = EntityType.copier(serverWorld, itemStack, player);
                    BearEntity bear = ModEntities.BEAR.create(serverWorld, consumer, position1Up, SpawnReason.SPAWN_EGG, true, true);

                    serverWorld.spawnEntityAndPassengers(bear);
                    bear.emitGameEvent(GameEvent.ENTITY_PLACE, player);
                }
            }
        }
    }
}
