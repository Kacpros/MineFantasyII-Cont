package minefantasy.mf2.item.weapon;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.util.DamageSource;

public abstract class ItemGladiusStats extends ItemWeaponMF {

    public ItemGladiusStats(ToolMaterial material, String named, int rarity, float weight) {
        super(material, named, rarity, weight);
        setMaxDamage((int) (getMaxDamage() * 1.0F));
    }

    @Override
    public boolean sheatheOnBack(ItemStack item) {
        return true;
    }

    @Override
    public boolean isHeavyWeapon() {
        return false;
    }

    @Override
    public boolean isOffhandHandDual(ItemStack off) {
        return false;
    }

    @Override
    public boolean allowOffhand(ItemStack mainhand, ItemStack offhand) {
        return true;
    }

    public int getParryCooldown(EntityLivingBase user) {
        return 18;
    }

    /**
     * Gets the angle the weapon can parry
     */
    @Override
    public float getParryAngleModifier(EntityLivingBase user) {
        return 1.0F;
    }

    @Override
    public float getBalance() {
        return 0.75F;
    }

    @Override
    protected float getKnockbackStrength() {
        return 0.0F;
    }

    @Override
    public float getDecayModifier(EntityLivingBase user, ItemStack item) {
        return 1.25F;
    }

    @Override
    protected boolean canAnyMobParry() {
        return false;
    }

    @Override
    public int modifyHitTime(EntityLivingBase user, ItemStack item) {
        return super.modifyHitTime(user, item) + speedModGladius;
    }

    @Override
    protected float[] getWeaponRatio(ItemStack implement) {
        return slashingDamage;
    }

    @Override
    public float getParryStaminaDecay(DamageSource source, ItemStack weapon) {
        return heavyParryFatigue;
    }

    /**
     * gets the time after being hit your guard will be let down
     */
    @Override
    public int getParryCooldown(DamageSource source, float dam, ItemStack weapon) {
        return daggerParryTime;
    }

    @Override
    public int getParryModifier(ItemStack weapon, EntityLivingBase user, Entity target) {
        return 50;
    }

    @Override
    protected float getStaminaMod() {
        return gladiusStaminacost;
    }

    @Override
    protected float getMeleeDamage(ItemStack item) {
        return super.getMeleeDamage(item) * 0.8F;
    }

    @Override
    public float getScale(ItemStack itemstack) {
        return 2.0F;
    }
}
