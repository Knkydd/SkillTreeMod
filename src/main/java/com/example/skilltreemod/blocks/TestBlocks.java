package com.example.skilltreemod.blocks;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.registries.ObjectHolder;

public class TestBlocks{
    @ObjectHolder(registryName = "minecraft:blocks", value = "minecraft:test_block")
    public static Block testBlock = new Block(BlockBehaviour.Properties.of());


}
