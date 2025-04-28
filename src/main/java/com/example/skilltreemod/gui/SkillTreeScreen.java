package com.example.skilltreemod.gui;

import com.example.skilltreemod.gui.buttons.CloseButton;
import com.example.skilltreemod.SkillTreeMod;
import com.example.skilltreemod.client.OpenGuiPacket;
import com.example.skilltreemod.gui.buttons.InfoButton;
import com.example.skilltreemod.gui.buttons.ProgressStatsButton;
import com.example.skilltreemod.gui.buttons.SkillsButton;
import com.example.skilltreemod.gui.subscreens.SkillPointsScreen;
import net.minecraft.client.gui.GuiGraphics;
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
    private final SkillPointsScreen skillPointsScreen;
    public SkillTreeScreen() {
        super(Component.literal("SkillTreeScreen"));
        this.skillPointsScreen = new SkillPointsScreen();
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
                CloseButton.createTopRight(this, 28, 3)
        );
        this.addRenderableWidget(
                InfoButton.createTopRight(this, 58, 3)
        );

        this.addRenderableWidget(
                SkillsButton.createMiddle(this));

        this.addRenderableWidget(
                ProgressStatsButton.createDown(this));

    }

    @Override
    public void render(@NotNull GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
        this.renderBackground(guiGraphics);

        skillPointsScreen.render(guiGraphics, mouseX, mouseY, partialTicks);
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
