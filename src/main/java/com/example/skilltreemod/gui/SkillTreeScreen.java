package com.example.skilltreemod.gui;

import com.example.skilltreemod.SkillTreeMod;
import com.example.skilltreemod.client.OpenGuiPacket;
import com.example.skilltreemod.gui.subscreens.InfoScreen;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.network.NetworkRegistry;
import net.minecraftforge.network.simple.SimpleChannel;
import org.jetbrains.annotations.NotNull;


/**
 * Описывает вызываемый графический интерфейс дерева умений
 */
public class SkillTreeScreen extends Screen {

    public SkillTreeScreen() {
        super(Component.literal("SkillTreeScreen"));
    }

    private static final String PROTOCOL_VERSION = "1";
    public static final SimpleChannel INSTANCE = NetworkRegistry.newSimpleChannel(
            new ResourceLocation(SkillTreeMod.MODID, "main"),
            () -> PROTOCOL_VERSION,
            PROTOCOL_VERSION::equals,
            PROTOCOL_VERSION::equals
    );

    public static void register() {
        INSTANCE.registerMessage(
                0,
                OpenGuiPacket.class,
                OpenGuiPacket::encode,
                OpenGuiPacket::new,
                OpenGuiPacket::handle
        );
    }

    @Override
    protected void init() {
        this.addRenderableWidget(
                Button.builder(Component.literal("X"), button -> {
                    onClose();
                })
                        .bounds(
                                this.width - 30,
                                3,
                                25,
                                25
                        )
                        .build()
        );
        this.addRenderableWidget(
                Button.builder(Component.literal("?"), button -> {
                    {
                        this.minecraft.setScreen(new InfoScreen(this));
                    }
                })
                        .bounds(
                                this.width - 60,
                                3,
                                25,
                                25
                        )
                        .build()
        );

        this.addRenderableWidget(
                Button.builder(Component.literal("≡"), button -> {

                })
                        .bounds(
                                5,
                                3,
                                25,
                                25
                        )
                        .build()
        );
    }

    @Override
    public void render(@NotNull GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
        this.renderBackground(guiGraphics); // Отрисовка фона

        super.render(guiGraphics, mouseX, mouseY, partialTicks);
    }

    @Override
    public boolean isPauseScreen() {
        return false;
    }

    public void onClose() {
        super.onClose();
    }
}
