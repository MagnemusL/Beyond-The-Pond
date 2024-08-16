package net.kawadw.beyondthepond.entities.sailfish;

import net.kawadw.beyondthepond.entities.AbstractWaterAnimal;
import net.kawadw.beyondthepond.registry.BTPEntities;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.entity.AnimationState;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.animal.AbstractFish;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import software.bernie.geckolib.animatable.GeoAnimatable;
import software.bernie.geckolib.animatable.GeoEntity;
import software.bernie.geckolib.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.animatable.instance.SingletonAnimatableInstanceCache;
import software.bernie.geckolib.animation.AnimatableManager;
import software.bernie.geckolib.animation.AnimationController;
import software.bernie.geckolib.animation.PlayState;
import software.bernie.geckolib.util.GeckoLibUtil;

public class SailfishEntity extends AbstractWaterAnimal implements GeoEntity {
    private AnimatableInstanceCache cache = new SingletonAnimatableInstanceCache(this);

    public SailfishEntity(Level pLevel) {
        super(BTPEntities.SAILFISH.get(), pLevel);
    }

    @Override
    public int getMaxSpawnClusterSize() {
        return super.getMaxSpawnClusterSize();
    }

    @Override
    protected SoundEvent getFlopSound() {
        return null;
    }

    /* GECKOLIB */

    @Override
    public void registerControllers(AnimatableManager.ControllerRegistrar controllers) {
        controllers.add(new AnimationController<>(this, "controller", 0, this::predicate));
    }

    private <T extends GeoAnimatable> PlayState predicate(AnimationState<T> animationState) {
        if(animationState.isMoving() && this.isInWater()) {
            animationState.getController().setAnimation(RawAnimation.begin().then("swim", Animation.LoopType.LOOP));
            return PlayState.CONTINUE;
        }
        if(!this.isInWater()) {
            animationState.getController().setAnimation(RawAnimation.begin().then("flop", Animation.LoopType.LOOP));
            return PlayState.CONTINUE;
        }

        animationState.getController().setAnimation(RawAnimation.begin().then("idle", Animation.LoopType.LOOP));
        return PlayState.CONTINUE;
    }

    @Override
    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return cache;
    }
}
