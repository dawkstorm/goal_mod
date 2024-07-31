package dawkmeow.goal.item;

import net.fabricmc.yarn.constants.MiningLevels;
import net.minecraft.block.Block;
import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;
import net.minecraft.registry.tag.TagKey;

import java.util.function.Supplier;

public enum ModToolMaterials implements ToolMaterial {
    BOTTLE(75, MiningLevels.HAND, 1f, 15f, 0, ()-> null);

    private final int durability;
    private final int miningLevel;
    private final float miningSpeed;
    private final float attackDamage;
    private final int enchantability;
    private final Supplier<Ingredient> ingredientSupplier;

    ModToolMaterials(int durability, int miningLevel, float miningSpeed, float attackDamage, int enchantability, Supplier<Ingredient> ingredientSupplier) {
        this.durability = durability;
        this.miningLevel = miningLevel;
        this.miningSpeed = miningSpeed;
        this.attackDamage = attackDamage;
        this.enchantability = enchantability;
        this.ingredientSupplier = ingredientSupplier;
    }


    @Override
    public int getDurability() {
        return durability;
    }

    @Override
    public float getMiningSpeedMultiplier() {
        return miningSpeed;
    }

    @Override
    public float getAttackDamage() {
        return attackDamage;
    }

    @Override
    public TagKey<Block> getInverseTag() {
        return null;
    }

    @Override
    public int getEnchantability() {
        return enchantability;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return getRepairIngredient();
    }
}
