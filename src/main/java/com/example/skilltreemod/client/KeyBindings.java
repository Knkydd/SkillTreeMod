package com.example.skilltreemod.client;

import com.mojang.blaze3d.platform.InputConstants;
import net.minecraft.client.KeyMapping;
import net.minecraftforge.client.settings.KeyConflictContext;
import org.lwjgl.glfw.GLFW;

/**
 * Привязывает данные, поступающие от периферйных устройств
 */
public class KeyBindings {
    public static final KeyMapping OPEN_GUI_KEY = new KeyMapping(
            "key.skilltreemod.open_gui", // Уникальный ID для привязки
            KeyConflictContext.IN_GAME, // Контекст, в котором клавиша активна
            InputConstants.Type.KEYSYM,
            GLFW.GLFW_KEY_G, // Код клавиши (G)
            "key.category.skilltreemod" // Категория клавиш (отображается в настройках управления)
    );
}
