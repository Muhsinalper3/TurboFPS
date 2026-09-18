package com.turbofps.client;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientLifecycleEvents;
import net.minecraft.client.CloudStatus;
import net.minecraft.client.Minecraft;
import net.minecraft.server.level.ParticleStatus;

public final class TurboFPSClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        ClientLifecycleEvents.CLIENT_STARTED.register(TurboFPSClient::applyOptimizations);
    }

    private static void applyOptimizations(Minecraft client) {
        var options = client.options;

        // Conservative vanilla settings: less rendering work, no gameplay changes.
        options.cloudStatus().set(CloudStatus.OFF);
        options.particles().set(ParticleStatus.MINIMAL);
        options.entityShadows().set(false);
        options.biomeBlendRadius().set(0);

        if (options.renderDistance().get() > 12) {
            options.renderDistance().set(12);
        }
        if (options.simulationDistance().get() > 8) {
            options.simulationDistance().set(8);
        }

        options.save();
    }
}
