package dawkmeow.goal.mixin;

import dawkmeow.goal.event.EventLandCallback;
import net.minecraft.entity.Entity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Entity.class)
public abstract class EntityMixin {
    private boolean wasOnGround;

    @Inject(method = "tick", at = @At("HEAD"))
    public void tick(CallbackInfo ci){
        boolean isOnGround = ((Entity)(Object)this).isOnGround();
        if (!wasOnGround && isOnGround) {
            EventLandCallback.EVENT.invoker().onEntityLand((Entity)(Object)this);
        }
        wasOnGround = isOnGround;
    }
}
