package net.kawadw.beyondthepond.registry;

import net.kawadw.beyondthepond.BeyondThePond;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class BTPCreativeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister.create(BuiltInRegistries.CREATIVE_MODE_TAB, BeyondThePond.MODID);

    public static final Supplier<CreativeModeTab> BEYOND_THE_POND = CREATIVE_MODE_TABS.register("beyond_the_pond", () -> CreativeModeTab.builder()
            .title(Component.translatable("itemGroup." + BeyondThePond.MODID + ".beyond_the_pond"))
            .icon(() -> new ItemStack(BTPItems.RAW_TURTLE.get()))
            .displayItems((params, output) -> {
                output.accept(BTPItems.RAW_COOKIECUTTER.get());
                output.accept(BTPItems.RAW_CUDDLEFISH.get());
                output.accept(BTPItems.RAW_ISOPOD.get());
                output.accept(BTPItems.RAW_LARGE_CRAB.get());
                output.accept(BTPItems.RAW_LOBSTER.get());
                output.accept(BTPItems.RAW_MEDIUM_CRAB.get());
                output.accept(BTPItems.RAW_SAILFISH.get());
                output.accept(BTPItems.RAW_SHARK.get());
                output.accept(BTPItems.RAW_SMALL_CRAB.get());
                output.accept(BTPItems.RAW_SPIDERCRAB.get());
                output.accept(BTPItems.RAW_STINGRAY.get());
                output.accept(BTPItems.RAW_SUNFISH.get());
                output.accept(BTPItems.RAW_TURTLE.get());

                output.accept(BTPItems.COOKED_COOKIECUTTER.get());
                output.accept(BTPItems.COOKED_CUDDLEFISH.get());
                output.accept(BTPItems.COOKED_ISOPOD.get());
                output.accept(BTPItems.COOKED_LARGE_CRAB.get());
                output.accept(BTPItems.COOKED_LOBSTER.get());
                output.accept(BTPItems.COOKED_MEDIUM_CRAB.get());
                output.accept(BTPItems.COOKED_SAILFISH.get());
                output.accept(BTPItems.COOKED_SHARK.get());
                output.accept(BTPItems.COOKED_SMALL_CRAB.get());
                output.accept(BTPItems.COOKED_SPIDERCRAB.get());
                output.accept(BTPItems.COOKED_STINGRAY.get());
                output.accept(BTPItems.COOKED_SUNFISH.get());
                output.accept(BTPItems.COOKED_TURTLE.get());
            })
            .build()
    );

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
