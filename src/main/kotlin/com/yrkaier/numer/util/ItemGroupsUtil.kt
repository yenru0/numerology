package com.yrkaier.numer.util

import net.minecraft.item.ItemGroup
import net.minecraft.item.ItemStack
import net.minecraft.item.Items

class ItemGroupRecognitive(index: Int, label: String) : ItemGroup(index, label) {

    companion object {
        @JvmStatic val instance = ItemGroupNumerical(ItemGroup.GROUPS.size, "recognition")
    }

    override fun createIcon(): ItemStack {
        return ItemStack(Items.DIAMOND)
    }

}

class ItemGroupNumerical(index: Int, label: String) : ItemGroup(index, label) {

    companion object {
        @JvmStatic val instance = ItemGroupNumerical(ItemGroup.GROUPS.size, "numeric")
    }

    override fun createIcon(): ItemStack {
        return ItemStack(Items.DIAMOND)
    }

}