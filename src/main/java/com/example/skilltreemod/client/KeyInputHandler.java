package com.example.skilltreemod.client;

import com.example.skilltreemod.SkillTreeMod;
import com.example.skilltreemod.gui.SkillTreeScreen;
import net.minecraft.client.Minecraft;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.InputEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

/**
 * Обрабатывает поступающие данные от периферийных устройств
 */
@Mod.EventBusSubscriber(modid = SkillTreeMod.MODID, value = Dist.CLIENT)
public class KeyInputHandler {
    @SubscribeEvent
    public static void onKeyInput(InputEvent.Key event) {
        Minecraft minecraft = Minecraft.getInstance();
        if (minecraft.player == null) return; // Проверка, что игрок существует

        // Проверка, нажата ли клавиша G
        if (KeyBindings.OPEN_GUI_KEY.consumeClick()) {
            // Открываем GUI
            minecraft.setScreen(new SkillTreeScreen());
        }
    }
}