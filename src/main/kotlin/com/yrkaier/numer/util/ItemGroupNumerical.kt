package com.yrkaier.numer.util

import net.minecraft.client.renderer.ItemRenderer
import net.minecraft.item.ItemGroup
import net.minecraft.item.ItemStack
import net.minecraft.item.Items

class ItemGroupNumerical(index: Int, label: String) : ItemGroup(index, label) {

    companion object {
        @JvmStatic val instance = ItemGroupNumerical(ItemGroup.GROUPS.size, "recognition")
    }

    override fun createIcon(): ItemStack {
        return ItemStack(Items.DIAMOND)
    }

}