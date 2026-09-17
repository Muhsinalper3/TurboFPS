package com.turbofps;

import net.fabricmc.api.ClientModInitializer;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.option.CloudRenderMode;

public class TurboFPSClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        MinecraftClient client = MinecraftClient.getInstance();
        client.execute(() -> client.options.getCloudRenderMode().setValue(CloudRenderMode.OFF));
    }
}
