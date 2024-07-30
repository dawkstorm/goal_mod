package dawkmeow.goal.event;

import net.fabricmc.fabric.api.event.Event;
import net.fabricmc.fabric.api.event.EventFactory;
import net.minecraft.entity.Entity;

public interface EventLandCallback {
    Event<EventLandCallback> EVENT = EventFactory.createArrayBacked(EventLandCallback.class,
            (listeners) -> (entity) -> {
                for (EventLandCallback listener : listeners) {
                    listener.onEntityLand(entity);
                }
            });

    void onEntityLand(Entity entity);
}
