package net.kawadw.beyondthepond.registry.datagen;

import net.kawadw.beyondthepond.BeyondThePond;
import net.kawadw.beyondthepond.registry.BTPItems;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.client.model.generators.ItemModelProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

public class BTPItemModelProvider extends ItemModelProvider {
    public BTPItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, BeyondThePond.MODID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        basicItem(BTPItems.RAW_COOKIECUTTER.get());
        basicItem(BTPItems.RAW_CUDDLEFISH.get());
        basicItem(BTPItems.RAW_ISOPOD.get());
        basicItem(BTPItems.RAW_LARGE_CRAB.get());
        basicItem(BTPItems.RAW_LOBSTER.get());
        basicItem(BTPItems.RAW_MEDIUM_CRAB.get());
        basicItem(BTPItems.RAW_SAILFISH.get());
        basicItem(BTPItems.RAW_SHARK.get());
        basicItem(BTPItems.RAW_SMALL_CRAB.get());
        basicItem(BTPItems.RAW_SPIDERCRAB.get());
        basicItem(BTPItems.RAW_STINGRAY.get());
        basicItem(BTPItems.RAW_SUNFISH.get());
        basicItem(BTPItems.RAW_TURTLE.get());

        basicItem(BTPItems.COOKED_COOKIECUTTER.get());
        basicItem(BTPItems.COOKED_CUDDLEFISH.get());
        basicItem(BTPItems.COOKED_ISOPOD.get());
        basicItem(BTPItems.COOKED_LARGE_CRAB.get());
        basicItem(BTPItems.COOKED_LOBSTER.get());
        basicItem(BTPItems.COOKED_MEDIUM_CRAB.get());
        basicItem(BTPItems.COOKED_SAILFISH.get());
        basicItem(BTPItems.COOKED_SHARK.get());
        basicItem(BTPItems.COOKED_SMALL_CRAB.get());
        basicItem(BTPItems.COOKED_SPIDERCRAB.get());
        basicItem(BTPItems.COOKED_STINGRAY.get());
        basicItem(BTPItems.COOKED_SUNFISH.get());
        basicItem(BTPItems.COOKED_TURTLE.get());
    }
}
