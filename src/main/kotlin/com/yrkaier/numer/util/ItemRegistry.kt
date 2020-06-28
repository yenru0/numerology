package com.yrkaier.numer.util

import com.yrkaier.numer.Numer
import com.yrkaier.numer.item.ItemNumeric
import com.yrkaier.numer.item.ItemSchoolBron
import net.minecraft.item.Item
import net.minecraftforge.fml.RegistryObject
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext
import net.minecraftforge.registries.DeferredRegister
import net.minecraftforge.registries.ForgeRegistries

class ItemRegistry {
    companion object {
        @JvmStatic val ITEMS: DeferredRegister<Item> = DeferredRegister.create(ForgeRegistries.ITEMS, Numer.MOD_ID)
        @JvmStatic val uno: RegistryObject<Item> = ITEMS.register("uno") {
            ItemSchoolBron(Item.Properties().group(ItemGroupRecognitive.instance).maxStackSize(16))
        }
        @JvmStatic val gyeseong: RegistryObject<Item> = ITEMS.register("gyeseong") {
            ItemSchoolBron(Item.Properties().group(ItemGroupRecognitive.instance).maxStackSize(16))
        }
        @JvmStatic val numerics: List<RegistryObject<Item>> = List<RegistryObject<Item>>(10) {
            ITEMS.register("numeric${it+1}") {
                ItemNumeric(Item.Properties().group(ItemGroupNumerical.instance).maxDamage((0.25*it+1).toInt()), it+1)
            }
        }
        init {
            ITEMS.register(FMLJavaModLoadingContext.get().modEventBus)
        }
    }
}