package com.example.skilltreemod.client;

import com.example.skilltreemod.gui.SkillTreeScreen;
import net.minecraft.client.Minecraft;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraftforge.network.NetworkEvent;

import java.util.function.Supplier;

/**
 * Открывает пакет GUI на клиенте
 */
public class OpenGuiPacket {
    public OpenGuiPacket() {}

    public OpenGuiPacket(FriendlyByteBuf buf) {}

    public void encode(FriendlyByteBuf buf) {}

    public void handle(Supplier<NetworkEvent.Context> ctx) {
        ctx.get().enqueueWork(() -> {
            // Открываем GUI на клиенте
            Minecraft.getInstance().setScreen(new SkillTreeScreen());
        });
        ctx.get().setPacketHandled(true);
    }
}
