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

    private static final ResourceLocation TEXTURE = new ResourceLocation(SkillTreeMod.MODID, "textures/gui/background.png");
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
                Button.builder(Component.literal("Click Me"), button -> {
                            // Действие при нажатии на кнопку
                            System.out.println("Кнопка нажата!");
                        })
                        .bounds(
                                this.width / 2 - 50, // Позиция X
                                this.height / 2 - 10, // Позиция Y
                                100, // Ширина
                                20 // Высота
                        )
                        .build() // Создание кнопки
        );
    }

    @Override
    public void render(@NotNull GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
        this.renderBackground(guiGraphics); // Отрисовка фона

        // Отрисовка текстуры
        guiGraphics.blit(
                TEXTURE, // Ресурс текстуры
                this.width / 2 - 80, // Позиция X (центр экрана)
                this.height / 2 - 80, // Позиция Y (центр экрана)
                0, // Смещение текстуры по X
                0, // Смещение текстуры по Y
                160, // Ширина текстуры
                160 // Высота текстуры
        );

        super.render(guiGraphics, mouseX, mouseY, partialTicks); // Вызов рендера родительского класса
    }

    @Override
    public boolean isPauseScreen() {
        return false; // Чтобы игра не ставилась на паузу при открытии GUI
    }
}
