package net.kawadw.beyondthepond.registry;

import net.kawadw.beyondthepond.BeyondThePond;
import net.minecraft.client.renderer.item.ItemProperties;
import net.minecraft.world.item.Item;
import net.neoforged.bus.EventBus;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.NeoForgeRegistries;

public class BTPItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(BeyondThePond.MODID);

    public static final DeferredItem<Item> RAW_COOKIECUTTER = ITEMS.registerSimpleItem("raw_cookiecutter");
    public static final DeferredItem<Item> RAW_CUDDLEFISH = ITEMS.registerSimpleItem("raw_cuddlefish");
    public static final DeferredItem<Item> RAW_ISOPOD = ITEMS.registerSimpleItem("raw_isopod");
    public static final DeferredItem<Item> RAW_LARGE_CRAB = ITEMS.registerSimpleItem("raw_large_crab");
    public static final DeferredItem<Item> RAW_LOBSTER = ITEMS.registerSimpleItem("raw_lobster");
    public static final DeferredItem<Item> RAW_MEDIUM_CRAB = ITEMS.registerSimpleItem("raw_medium_crab");
    public static final DeferredItem<Item> RAW_SAILFISH = ITEMS.registerSimpleItem("raw_sailfish");
    public static final DeferredItem<Item> RAW_SHARK = ITEMS.registerSimpleItem("raw_shark");
    public static final DeferredItem<Item> RAW_SHRIMP = ITEMS.registerSimpleItem("raw_shrimp");
    public static final DeferredItem<Item> RAW_SMALL_CRAB = ITEMS.registerSimpleItem("raw_small_crab");
    public static final DeferredItem<Item> RAW_SPIDERCRAB = ITEMS.registerSimpleItem("raw_spidercrab");
    public static final DeferredItem<Item> RAW_STINGRAY = ITEMS.registerSimpleItem("raw_stingray");
    public static final DeferredItem<Item> RAW_SUNFISH = ITEMS.registerSimpleItem("raw_sunfish");
    public static final DeferredItem<Item> RAW_TURTLE = ITEMS.registerSimpleItem("raw_turtle");

    public static final DeferredItem<Item> COOKED_COOKIECUTTER = ITEMS.registerSimpleItem("cooked_cookiecutter");
    public static final DeferredItem<Item> COOKED_CUDDLEFISH = ITEMS.registerSimpleItem("cooked_cuddlefish");
    public static final DeferredItem<Item> COOKED_ISOPOD = ITEMS.registerSimpleItem("cooked_isopod");
    public static final DeferredItem<Item> COOKED_LARGE_CRAB = ITEMS.registerSimpleItem("cooked_large_crab");
    public static final DeferredItem<Item> COOKED_LOBSTER = ITEMS.registerSimpleItem("cooked_lobster");
    public static final DeferredItem<Item> COOKED_MEDIUM_CRAB = ITEMS.registerSimpleItem("cooked_medium_crab");
    public static final DeferredItem<Item> COOKED_SAILFISH = ITEMS.registerSimpleItem("cooked_sailfish");
    public static final DeferredItem<Item> COOKED_SHARK = ITEMS.registerSimpleItem("cooked_shark");
    public static final DeferredItem<Item> COOKED_SHRIMP = ITEMS.registerSimpleItem("cooked_shrimp");
    public static final DeferredItem<Item> COOKED_SMALL_CRAB = ITEMS.registerSimpleItem("cooked_small_crab");
    public static final DeferredItem<Item> COOKED_SPIDERCRAB = ITEMS.registerSimpleItem("cooked_spidercrab");
    public static final DeferredItem<Item> COOKED_STINGRAY = ITEMS.registerSimpleItem("cooked_stingray");
    public static final DeferredItem<Item> COOKED_SUNFISH = ITEMS.registerSimpleItem("cooked_sunfish");
    public static final DeferredItem<Item> COOKED_TURTLE = ITEMS.registerSimpleItem("cooked_turtle");

    public static void register(IEventBus bus) {
        ITEMS.register(bus);
    }
}
