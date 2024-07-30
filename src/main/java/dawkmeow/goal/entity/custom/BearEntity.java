package dawkmeow.goal.entity.custom;

import dawkmeow.goal.GoalMod;
import dawkmeow.goal.entity.ai.BearAttackGoal;
import net.minecraft.entity.AnimationState;
import net.minecraft.entity.EntityPose;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.damage.DamageType;
import net.minecraft.entity.damage.DamageTypes;
import net.minecraft.entity.data.DataTracker;
import net.minecraft.entity.data.TrackedData;
import net.minecraft.entity.data.TrackedDataHandlerRegistry;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.registry.tag.DamageTypeTags;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

public class BearEntity extends HostileEntity {

    private static final TrackedData<Boolean> ATTACKING =
            DataTracker.registerData(BearEntity.class, TrackedDataHandlerRegistry.BOOLEAN);
    private static final TrackedData<Boolean> JUMPING_TO_EXPLODE =
            DataTracker.registerData(BearEntity.class, TrackedDataHandlerRegistry.BOOLEAN);

    @Override
    public boolean isInvulnerableTo(DamageSource damageSource) {
        return super.isInvulnerableTo(damageSource) || damageSource.isIn(DamageTypeTags.IS_PROJECTILE);
    }

    public BearEntity(EntityType<? extends HostileEntity> entityType, World world) {
        super(entityType, world);
    }

    public final AnimationState attackAnimationState = new AnimationState();
    public int attackAnimationTimeout = 0;

    private void setupAnimationStates(){
        if(this.isAttacking() && attackAnimationTimeout <= 0){
            attackAnimationTimeout = 40;
            attackAnimationState.start(this.age);
        }
        else{
            --this.attackAnimationTimeout;
        }

        if(!this.isAttacking()){
            attackAnimationState.stop();
        }
    }



    @Override
    public void tick() {
        super.tick();
        if(this.getWorld().isClient()){
            setupAnimationStates();
        }
    }

    public void setAttacking(boolean attacking) {
        dataTracker.set(ATTACKING, attacking);
    }

    public void setJumpingToExplode(boolean jumping) {
        dataTracker.set(JUMPING_TO_EXPLODE, jumping);
    }

    public boolean isAttacking(){
        return dataTracker.get(ATTACKING);
    }

    public boolean isJumpingToExplode(){
        return dataTracker.get(JUMPING_TO_EXPLODE);
    }

    @Override
    protected void initDataTracker(DataTracker.Builder builder) {
        super.initDataTracker(builder);
        builder.add(ATTACKING, false);
        builder.add(JUMPING_TO_EXPLODE, false);
    }

    @Override
    protected void updateLimbs(float posDelta) {
        float f;
        if (this.getPose() == EntityPose.STANDING) {
            f = Math.min(posDelta * 6.0F, 1.0F);
        } else {
            f = 0.0F;
        }

        this.limbAnimator.updateLimbs(f, 0.2F);
    }

    @Override
    protected void initGoals() {
        this.goalSelector.add(0, new SwimGoal(this));
        this.goalSelector.add(1, new LookAtEntityGoal(this, PlayerEntity.class, 50f));
        this.goalSelector.add(1, new BearAttackGoal(this, 0.4D, true));
        this.goalSelector.add(3, new WanderAroundGoal(this, 0.2D));

        this.targetSelector.add(1, new RevengeGoal(this));
        this.targetSelector.add(1, new ActiveTargetGoal(this, PlayerEntity.class, true));
    }

    public static DefaultAttributeContainer.Builder createBearAttributes(){
        return MobEntity.createMobAttributes()
                .add(EntityAttributes.GENERIC_MAX_HEALTH, 100)
                .add(EntityAttributes.GENERIC_STEP_HEIGHT, 1)
                .add(EntityAttributes.GENERIC_KNOCKBACK_RESISTANCE, 1)
                .add(EntityAttributes.GENERIC_ATTACK_DAMAGE, 20)
                .add(EntityAttributes.GENERIC_SAFE_FALL_DISTANCE, 400)
                ;
    }

    @Override
    protected SoundEvent getDeathSound() {
        return SoundEvents.ENTITY_HORSE_DEATH;
    }

    @Nullable
    @Override
    protected SoundEvent getAmbientSound() {
        return SoundEvents.ENTITY_ZOMBIE_AMBIENT;
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource source) {
        return SoundEvents.BLOCK_AMETHYST_BLOCK_BREAK;
    }

    @Override
    protected void applyDamage(DamageSource source, float amount) {
        super.applyDamage(source, amount);

    }
}
