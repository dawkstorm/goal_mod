package dawkmeow.goal.entity.ai;

import dawkmeow.goal.GoalMod;
import dawkmeow.goal.entity.custom.BearEntity;
import dawkmeow.goal.event.EventLandCallback;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.goal.Goal;
import net.minecraft.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.entity.mob.PathAwareEntity;
import net.minecraft.server.command.SetBlockCommand;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import net.minecraft.world.chunk.WorldChunk;

public class BearAttackGoal extends MeleeAttackGoal {

    private final BearEntity entity;
    private int attackDelay = 10;
    private int ticksUntilNextAttack = 20;
    private boolean shouldCountTillNextAttack = false;

    private int ticksUntilNextJump = 300;
    private boolean shoudCountTillNextJump = true;

    public BearAttackGoal(BearEntity mob, double speed, boolean pauseWhenMobIdle) {
        super(mob, speed, pauseWhenMobIdle);
        entity = mob;
    }

    @Override
    public void start() {
        super.start();
        attackDelay = 10;
        ticksUntilNextAttack = 20;
        EventLandCallback.EVENT.register((e) -> {
            if(e == entity && entity.isJumpingToExplode()){
                entity.setJumpingToExplode(false);
                mob.getWorld().createExplosion(mob, mob.getX(),mob.getY(), mob.getZ(), 5, false, World.ExplosionSourceType.TNT);
                shoudCountTillNextJump = true;
            }
        });
    }

    private boolean isEnemyWithinTheAttackRange(LivingEntity lEntity){
        return this.entity.distanceTo(lEntity) <= 4.5f;
    }

    protected void resetAttackCooldown(){
        this.ticksUntilNextAttack = this.getTickCount(attackDelay * 2);
    }

    protected void resetJumpCooldown(){
        this.ticksUntilNextJump = 300;
    }

    protected boolean isTimeToStartAttackAnimation(){
        return this.ticksUntilNextAttack <= attackDelay;
    }

    protected boolean isTimeToAttack(){
        return this.ticksUntilNextAttack <= 0;
    }

    protected boolean isTimeToJump(){
        return this.ticksUntilNextJump <= 0;
    }

    protected void performJumpAndExplode(){
        shoudCountTillNextJump = false;
        resetJumpCooldown();
        entity.travel(new Vec3d(0, 2, 0));
        entity.addVelocity(0, 1.5d, 0);
        entity.setJumpingToExplode(true);
    }

    protected void performAttack(LivingEntity lEntity){
        resetAttackCooldown();
        mob.swingHand(Hand.MAIN_HAND);
        mob.getWorld().breakBlock(new BlockPos(lEntity.getBlockX(), lEntity.getBlockY() - 1, lEntity.getBlockZ()), false);
        lEntity.travel(new Vec3d(0, 2, 0));
        lEntity.addVelocity(0, 2, 0);
        mob.tryAttack(lEntity);
    }

    protected void attack(LivingEntity lEntity){
        if(isTimeToJump()){
            performJumpAndExplode();
        }

        if(isEnemyWithinTheAttackRange(lEntity)) {
            shouldCountTillNextAttack = true;

            if(isTimeToStartAttackAnimation()){
                entity.setAttacking(true);
            }

            if(isTimeToAttack()){
                this.mob.getLookControl().lookAt(lEntity.getX(), lEntity.getY(), lEntity.getZ());
                performAttack(lEntity);
            }
        } else {
            resetAttackCooldown();
            shouldCountTillNextAttack = false;
            entity.setAttacking(false);
            entity.attackAnimationTimeout = 0;
        }

    }

    @Override
    public void tick() {
        super.tick();
        if(shoudCountTillNextJump){
            this.ticksUntilNextJump = Math.max(this.ticksUntilNextJump - 1, 0);
        }
        //GoalMod.LOGGER.info("" + ticksUntilNextJump);
        if(shouldCountTillNextAttack){
            this.ticksUntilNextAttack = Math.max(this.ticksUntilNextAttack - 1, 0);
        }
    }

    @Override
    public void stop() {
        entity.setAttacking(false);
        super.stop();

    }
}
