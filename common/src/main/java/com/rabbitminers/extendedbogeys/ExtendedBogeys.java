package com.rabbitminers.extendedbogeys;

import com.rabbitminers.extendedbogeys.data.ExtendedBogeysLanguageProvider;
import com.rabbitminers.extendedbogeys.registry.ExtendedBogeysBlocks;
import com.rabbitminers.extendedbogeys.registry.ExtendedBogeysBogeySizes;
import com.rabbitminers.extendedbogeys.registry.ExtendedBogeysBogeyStyles;
import com.simibubi.create.foundation.data.CreateRegistrate;
import com.tterrag.registrate.providers.ProviderType;
import net.minecraft.data.DataGenerator;
import net.minecraft.resources.ResourceLocation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ExtendedBogeys {
    public static final String MOD_ID = "extendedbogeys";
    public static final String MOD_NAME = "Extended Bogeys";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);
    public static final CreateRegistrate REGISTRATE = CreateRegistrate.create(ExtendedBogeys.MOD_ID);

    public static void init() {
        ExtendedBogeysBlocks.register();
        ExtendedBogeysBogeyStyles.register();
        ExtendedBogeysBogeySizes.register();
    }

    public static void gatherData(DataGenerator.PackGenerator gen) {
        REGISTRATE.addDataGenerator(ProviderType.LANG, ExtendedBogeysLanguageProvider::generate);
    }

    public static ResourceLocation asResource(String path) {
        return new ResourceLocation(MOD_ID, path);
    }

    public static CreateRegistrate registrate() {
        return REGISTRATE;
    }
}
