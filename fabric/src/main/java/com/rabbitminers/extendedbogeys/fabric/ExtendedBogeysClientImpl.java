package com.rabbitminers.extendedbogeys.fabric;

import com.rabbitminers.extendedbogeys.ExtendedBogeys;
import com.rabbitminers.extendedbogeys.ExtendedBogeysClient;

import com.simibubi.create.foundation.utility.Components;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.resource.ResourceManagerHelper;
import net.fabricmc.fabric.api.resource.ResourcePackActivationType;
import net.fabricmc.loader.api.FabricLoader;
import net.fabricmc.loader.api.ModContainer;

public class ExtendedBogeysClientImpl implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        ExtendedBogeysClient.init();
    }

    public static void registerBuiltinPack(String id, String name) {
        ModContainer mod = FabricLoader.getInstance().getModContainer(ExtendedBogeys.MOD_ID).orElseThrow();
        ResourceManagerHelper.registerBuiltinResourcePack(ExtendedBogeys.asResource(id), mod, Components.literal(name), ResourcePackActivationType.NORMAL);
    }
}
