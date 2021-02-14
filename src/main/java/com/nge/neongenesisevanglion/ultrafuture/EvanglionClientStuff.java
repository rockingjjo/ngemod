package com.nge.neongenesisevanglion.ultrafuture;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.impl.networking.ClientSidePacketRegistryImpl;
import net.minecraft.client.MinecraftClient;

import java.util.UUID;

public class EvanglionClientStuff implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        ClientSidePacketRegistryImpl.INSTANCE.register(RifleShot.SPAWN_PACKET,((packetContext, packetByteBuf) ->{
            double x = packetByteBuf.readDouble();
            double y = packetByteBuf.readDouble();
            double z = packetByteBuf.readDouble();

            int entityID = packetByteBuf.readInt();
            UUID entityUUID = packetByteBuf.readUuid();

            packetContext.getTaskQueue().execute(() ->{
                RifleShot proj = new RifleShot(MinecraftClient.getInstance().world, x, y, z, entityID, entityUUID);
                MinecraftClient.getInstance().world.addEntity(entityID, proj);
            });
        }));
    }

}
