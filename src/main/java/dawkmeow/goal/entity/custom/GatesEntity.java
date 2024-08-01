package dawkmeow.goal.entity.custom;

import dawkmeow.goal.GoalMod;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.decoration.ArmorStandEntity;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

public class GatesEntity extends ArmorStandEntity {

    public GatesEntity(EntityType<? extends ArmorStandEntity> entityType, World world) {
        super(entityType, world);
        GoalMod.LOGGER.info(shouldRenderName()+"");
    }

    public static DefaultAttributeContainer.Builder createGatesAttributes(){
        return MobEntity.createMobAttributes()
                .add(EntityAttributes.GENERIC_FLYING_SPEED, 5)
                ;
    }


    @Override
    public boolean canEquip(ItemStack stack) {
        return false;
    }

    @Override
    public ActionResult interactAt(PlayerEntity player, Vec3d hitPos, Hand hand) {
        return ActionResult.PASS;
    }
}
