package com.example.skilltreemod.gui;

import com.example.skilltreemod.SkillTreeMod;
import com.example.skilltreemod.client.OpenGuiPacket;
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
        super(Component.literal("My GUI"));
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
                0, // ID пакета
                OpenGuiPacket.class, // Класс пакета
                OpenGuiPacket::encode, // Метод для кодирования пакета
                OpenGuiPacket::new, // Конструктор для декодирования пакета
                OpenGuiPacket::handle // Метод для обработки пакета
        );
    }

    @Override
    protected void init() {
        // Инициализация кнопок и других элементов GUI
        this.addRenderableWidget(
                Button.builder(Component.literal("X"), button -> {
                    onClose();
                })
                        .bounds(
                                this.width - 25, // Позиция X
                                0, // Позиция Y
                                25, // Ширина
                                25 // Высота
                        )
                        .build() // Создание кнопки
        );
        this.addRenderableWidget(
                Button.builder(Component.literal("?"), button -> {
                    System.out.println("G");
                })
                        .bounds(
                                this.width - 65,
                                0,
                                25,
                                25
                        )
                        .build()
        );

    }

    @Override
    public void render(@NotNull GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
        this.renderBackground(guiGraphics); // Отрисовка фона

        super.render(guiGraphics, mouseX, mouseY, partialTicks); // Вызов рендера родительского класса
    }

    @Override
    public boolean isPauseScreen() {
        return false; // Чтобы игра не ставилась на паузу при открытии GUI
    }

    public void onClose() {
        super.onClose();
    }
}
