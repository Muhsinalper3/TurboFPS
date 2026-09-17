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
        // Safe vanilla settings that reduce GPU/CPU work without changing gameplay.
        client.options.cloudStatus().set(CloudStatus.OFF);
        client.options.particles().set(ParticleStatus.MINIMAL);
        client.options.save();
    }
}
