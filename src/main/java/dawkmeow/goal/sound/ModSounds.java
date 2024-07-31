package dawkmeow.goal.sound;

import dawkmeow.goal.GoalMod;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;

public class ModSounds {

    public static final SoundEvent GOAL_BEAR_ATTACK = registerSoundEvent("goal_bear_attack");
    public static final SoundEvent GOAL_BEAR_JUMP = registerSoundEvent("goal_bear_jump");
    public static final SoundEvent GOAL_BEAR_AMBIENT = registerSoundEvent("goal_bear_ambient");
    public static final SoundEvent GOAL_BEAR_DEATH = registerSoundEvent("goal_bear_death");

    private static SoundEvent registerSoundEvent(String name){
        Identifier id = new Identifier(GoalMod.MOD_ID, name);
        return Registry.register(Registries.SOUND_EVENT, id, SoundEvent.of(id));

    }

    public static void registerSounds(){
        GoalMod.LOGGER.info("Registering sounds...");
    }
}
