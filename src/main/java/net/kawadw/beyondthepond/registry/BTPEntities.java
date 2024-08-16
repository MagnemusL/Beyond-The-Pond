package net.kawadw.beyondthepond.registry;

import net.kawadw.beyondthepond.BeyondThePond;
import net.kawadw.beyondthepond.entities.sailfish.SailfishEntity;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class BTPEntities {
    public static final DeferredRegister<EntityType<?>> ENTITIES = DeferredRegister.create(BuiltInRegistries.ENTITY_TYPE, BeyondThePond.MODID);

    public static final Supplier<EntityType<SailfishEntity>> SAILFISH = ENTITIES.register("sailfish", () -> EntityType.Builder.of(SailfishEntity::new, MobCategory.WATER_CREATURE).sized(1.0F, 1.0F).build("sailfish"));

    public static void register(IEventBus bus) {
        ENTITIES.register(bus);
    }
}
