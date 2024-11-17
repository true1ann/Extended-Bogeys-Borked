package com.rabbitminers.extendedbogeys.forge;

import com.rabbitminers.extendedbogeys.ExtendedBogeys;
import com.rabbitminers.extendedbogeys.ExtendedBogeysClient;
import com.simibubi.create.foundation.ModFilePackResources;
import net.minecraft.network.chat.Component;
import net.minecraft.server.packs.PackType;
import net.minecraft.server.packs.repository.Pack;
import net.minecraft.server.packs.repository.PackSource;
import net.minecraft.world.flag.FeatureFlagSet;
import net.minecraftforge.event.AddPackFindersEvent;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.forgespi.locating.IModFile;

import java.util.*;

public class ExtendedBogeysClientImpl {
    public static void init() {
        ExtendedBogeysClient.init();
        ExtendedBogeysImpl.bus.addListener(ExtendedBogeysClientImpl::onBuiltinPackRegistration);
    }

    private record PackInfo(String id, String name) {}

    private static final List<PackInfo> packs = new ArrayList<>();

    public static void registerBuiltinPack(String id, String name) {
        packs.add(new PackInfo(id, name));
    }

    // based on Create's impl
    public static void onBuiltinPackRegistration(AddPackFindersEvent event) {
        if (event.getPackType() != PackType.CLIENT_RESOURCES)
            return;
        IModFile modFile = ModList.get().getModFileById(ExtendedBogeys.MOD_ID).getFile();

        packs.forEach(pack -> event.addRepositorySource((consumer) -> consumer.accept(
                Pack.create(ExtendedBogeys.asResource(pack.id).toString(),
                        Component.literal(pack.name),
                        false,
                        (a) -> new ModFilePackResources(pack.name, modFile, "resourcepacks/" + pack.id),
                        new Pack.Info(Component.empty(), 10, FeatureFlagSet.of()),
                        PackType.CLIENT_RESOURCES,
                        Pack.Position.TOP,
                        false,
                        PackSource.DEFAULT
                )
        )));
        packs.clear();
    }
}
