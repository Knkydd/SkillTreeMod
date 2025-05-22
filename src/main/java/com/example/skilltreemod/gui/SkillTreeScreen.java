package com.example.skilltreemod.gui;

import com.example.skilltreemod.SkillTreeMod;
import com.example.skilltreemod.client.OpenGuiPacket;
import com.example.skilltreemod.gui.other.*;
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
//        this.addRenderableWidget(
//                CloseButton.createTopRight(this, 28, 3)
//        );
//        this.addRenderableWidget(
//                InfoButton.createInfoButton(this, 58, 3)
//        );

        WarriorProgressContainer warriorContainer = new WarriorProgressContainer(
                0,
                0,
                width / 7, height,
                this
        );

        DiggerProgressContainer diggerContainer = new DiggerProgressContainer(width / 7, 0, width / 7, height, this);
        ArcherProgressContainer archerContainer = new ArcherProgressContainer(2 * width / 7, 0, width / 7, height, this);
        FisherProgressContainer fisherContainer = new FisherProgressContainer(3 * width / 7, 0, width / 7, height, this);
        LibrarianProgressContainer librarianContainer = new LibrarianProgressContainer(4 * width / 7, 0, width / 7, height, this);
        SmithProgressContainer smithContainer = new SmithProgressContainer(5 * width / 7, 0, width / 7, height, this);
        TankProgressContainer tankContainer = new TankProgressContainer(6 * width / 7, 0, width / 7, height, this);

        this.addRenderableWidget(warriorContainer);
        this.addRenderableWidget(diggerContainer);
        this.addRenderableWidget(archerContainer);
        this.addRenderableWidget(fisherContainer);
        this.addRenderableWidget(librarianContainer);
        this.addRenderableWidget(smithContainer);
        this.addRenderableWidget(tankContainer);

    }

    @Override
    public void render(@NotNull GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
        this.renderBackground(guiGraphics);

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
