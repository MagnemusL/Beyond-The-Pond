package net.kawadw.beyondthepond.entities;

import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.tags.FluidTags;
import net.minecraft.util.Mth;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.EntitySelector;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.MoverType;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.control.MoveControl;
import net.minecraft.world.entity.ai.goal.AvoidEntityGoal;
import net.minecraft.world.entity.ai.goal.PanicGoal;
import net.minecraft.world.entity.ai.goal.RandomSwimmingGoal;
import net.minecraft.world.entity.ai.navigation.PathNavigation;
import net.minecraft.world.entity.ai.navigation.WaterBoundPathNavigation;
import net.minecraft.world.entity.animal.AbstractFish;
import net.minecraft.world.entity.animal.Bucketable;
import net.minecraft.world.entity.animal.WaterAnimal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.Vec3;

public abstract class AbstractWaterAnimal extends WaterAnimal {
    private static final EntityDataAccessor<Boolean> PLAYER_BRED = SynchedEntityData.defineId(AbstractWaterAnimal.class, EntityDataSerializers.BOOLEAN);
    public AbstractWaterAnimal(EntityType<? extends AbstractWaterAnimal> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
        this.moveControl = new AbstractWaterAnimal.FishMoveControl(this);
    }

    public static AttributeSupplier.Builder createAttributes() {
        return Mob.createMobAttributes().add(Attributes.MAX_HEALTH, 3.0);
    }

    public void setPlayerBred(boolean playerBred) {
        entityData.set(PLAYER_BRED, playerBred);
    }

    public boolean isPlayerBred() {
        return entityData.get(PLAYER_BRED);
    }

    @Override
    public boolean requiresCustomPersistence() {
        return super.requiresCustomPersistence() || this.isPlayerBred();
    }

    @Override
    public boolean removeWhenFarAway(double pDistanceToClosestPlayer) {
        return !isPlayerBred() && !this.hasCustomName();
    }

    @Override
    public int getMaxSpawnClusterSize() {
        return 8;
    }

    @Override
    protected void registerGoals() {
        super.registerGoals();
        this.goalSelector.addGoal(0, new PanicGoal(this, 1.25));
        this.goalSelector.addGoal(2, new AvoidEntityGoal<>(this, Player.class, 8.0F, 1.6, 1.4, EntitySelector.NO_SPECTATORS::test));
        this.goalSelector.addGoal(4, new AbstractWaterAnimal.FishSwimGoal(this));
    }

    @Override
    protected PathNavigation createNavigation(Level pLevel) {
        return new WaterBoundPathNavigation(this, pLevel);
    }

    @Override
    public void travel(Vec3 pTravelVector) {
        if (this.isEffectiveAi() && this.isInWater()) {
            this.moveRelative(0.01F, pTravelVector);
            this.move(MoverType.SELF, this.getDeltaMovement());
            this.setDeltaMovement(this.getDeltaMovement().scale(0.9));
            if (this.getTarget() == null) {
                this.setDeltaMovement(this.getDeltaMovement().add(0.0, -0.005, 0.0));
            }
        } else {
            super.travel(pTravelVector);
        }
    }

    @Override
    public void aiStep() {
        if (!this.isInWater() && this.onGround() && this.verticalCollision) {
            this.setDeltaMovement(
                    this.getDeltaMovement()
                            .add((double)((this.random.nextFloat() * 2.0F - 1.0F) * 0.05F), 0.4F, (double)((this.random.nextFloat() * 2.0F - 1.0F) * 0.05F))
            );
            this.setOnGround(false);
            this.hasImpulse = true;
            this.makeSound(this.getFlopSound());
        }

        super.aiStep();
    }

    protected boolean canRandomSwim() {
        return true;
    }

    protected abstract SoundEvent getFlopSound();

    @Override
    protected SoundEvent getSwimSound() {
        return SoundEvents.FISH_SWIM;
    }

    @Override
    protected void playStepSound(BlockPos pPos, BlockState pBlock) {
    }

    static class FishMoveControl extends MoveControl {
        private final AbstractWaterAnimal fish;

        FishMoveControl(AbstractWaterAnimal pFish) {
            super(pFish);
            this.fish = pFish;
        }

        @Override
        public void tick() {
            if (this.fish.isEyeInFluid(FluidTags.WATER)) {
                this.fish.setDeltaMovement(this.fish.getDeltaMovement().add(0.0, 0.005, 0.0));
            }

            if (this.operation == MoveControl.Operation.MOVE_TO && !this.fish.getNavigation().isDone()) {
                float f = (float)(this.speedModifier * this.fish.getAttributeValue(Attributes.MOVEMENT_SPEED));
                this.fish.setSpeed(Mth.lerp(0.125F, this.fish.getSpeed(), f));
                double d0 = this.wantedX - this.fish.getX();
                double d1 = this.wantedY - this.fish.getY();
                double d2 = this.wantedZ - this.fish.getZ();
                if (d1 != 0.0) {
                    double d3 = Math.sqrt(d0 * d0 + d1 * d1 + d2 * d2);
                    this.fish.setDeltaMovement(this.fish.getDeltaMovement().add(0.0, (double)this.fish.getSpeed() * (d1 / d3) * 0.1, 0.0));
                }

                if (d0 != 0.0 || d2 != 0.0) {
                    float f1 = (float)(Mth.atan2(d2, d0) * 180.0F / (float)Math.PI) - 90.0F;
                    this.fish.setYRot(this.rotlerp(this.fish.getYRot(), f1, 90.0F));
                    this.fish.yBodyRot = this.fish.getYRot();
                }
            } else {
                this.fish.setSpeed(0.0F);
            }
        }
    }

    static class FishSwimGoal extends RandomSwimmingGoal {
        private final AbstractWaterAnimal fish;

        public FishSwimGoal(AbstractWaterAnimal pFish) {
            super(pFish, 1.0, 40);
            this.fish = pFish;
        }

        @Override
        public boolean canUse() {
            return this.fish.canRandomSwim() && super.canUse();
        }
    }
}
