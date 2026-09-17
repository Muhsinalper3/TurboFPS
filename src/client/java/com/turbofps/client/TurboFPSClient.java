package com.turbofps.client;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientLifecycleEvents;
import net.minecraft.client.MinecraftClient;

public class TurboFPSClient implements ClientModInitializer {
    private static final String MOD_NAME = "TurboFPS";

    @Override
    public void onInitializeClient() {
        ClientLifecycleEvents.CLIENT_STARTED.register(client -> applyOptimizations(client));
    }

    private static void applyOptimizations(MinecraftClient client) {
        // Keep the mod lightweight: only safe client-side settings are changed.
        // The player can still change these values manually at any time.
        client.options.getCloudRenderMode().setValue(net.minecraft.client.option.CloudRenderMode.OFF);
        client.options.getParticles().setValue(net.minecraft.client.option.ParticlesMode.DECREASED);
    }
}
