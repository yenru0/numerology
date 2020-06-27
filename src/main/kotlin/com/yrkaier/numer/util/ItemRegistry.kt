package com.yrkaier.numer.util

import com.yrkaier.numer.Numer
import com.yrkaier.numer.item.One
import net.minecraft.item.Item
import net.minecraftforge.fml.RegistryObject
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext
import net.minecraftforge.registries.DeferredRegister
import net.minecraftforge.registries.ForgeRegistries

class ItemRegistry {
    companion object {
        @JvmStatic val ITEMS: DeferredRegister<Item> = DeferredRegister.create(ForgeRegistries.ITEMS, Numer.MOD_ID)
        @JvmStatic val uno: RegistryObject<Item> = ITEMS.register("uno") {
            One(Item.Properties().group(ItemGroupNumerical.instance).maxStackSize(16))
        }
        @JvmStatic val gyeseong: RegistryObject<Item> = ITEMS.register("gyeseong") {
            One(Item.Properties().group(ItemGroupNumerical.instance).maxStackSize(16))
        }
        init {
            ITEMS.register(FMLJavaModLoadingContext.get().modEventBus)
        }
    }
}