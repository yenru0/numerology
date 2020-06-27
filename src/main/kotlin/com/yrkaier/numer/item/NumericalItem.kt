package com.yrkaier.numer.item

import net.minecraft.entity.player.PlayerEntity
import net.minecraft.entity.projectile.FireballEntity
import net.minecraft.item.Item
import net.minecraft.item.ItemStack
import net.minecraft.stats.Stats
import net.minecraft.util.ActionResult
import net.minecraft.util.Hand
import net.minecraft.util.SoundCategory
import net.minecraft.util.SoundEvents
import net.minecraft.util.math.MathHelper
import net.minecraft.util.math.RayTraceContext
import net.minecraft.util.math.RayTraceContext.FluidMode
import net.minecraft.util.math.RayTraceResult
import net.minecraft.util.math.vector.Vector3d
import net.minecraft.world.World
import net.minecraftforge.event.entity.ProjectileImpactEvent


class One(properties: Properties) : Item(properties) {

    private fun rayTrace(world: World, player: PlayerEntity): RayTraceResult? {
        val rotationPitch = player.rotationPitch
        val rotationYaw = player.rotationYaw
        val eyePosition: Vector3d = player.getEyePosition(1.0f)
        //Normalize the look vector
        val f2 = MathHelper.cos(-rotationYaw * (Math.PI.toFloat() / 180f) - Math.PI.toFloat())
        val f3 = MathHelper.sin(-rotationYaw * (Math.PI.toFloat() / 180f) - Math.PI.toFloat())
        val f4 = MathHelper.cos(-rotationPitch * (Math.PI.toFloat() / 180f))
        val f5 = MathHelper.sin(-rotationPitch * (Math.PI.toFloat() / 180f))
        val f6 = f3 * f4
        val f7 = f2 * f4
        val rayTraceDistance = 32.0
        //Take the start position and add the look vector multiplied by the rayTraceDistance
        val endPosition: Vector3d = eyePosition.add(f6.toDouble() * rayTraceDistance, f5.toDouble() * rayTraceDistance, f7.toDouble() * rayTraceDistance)
        return world.rayTraceBlocks(RayTraceContext(eyePosition, endPosition, RayTraceContext.BlockMode.OUTLINE, FluidMode.NONE, player))
    }

    override fun onItemRightClick(worldIn: World, playerIn: PlayerEntity, handIn: Hand): ActionResult<ItemStack> {
        val itemstack = playerIn.getHeldItem(handIn)
        val result = this.rayTrace(worldIn, playerIn)
        worldIn.playSound(null as PlayerEntity?, playerIn.posX, playerIn.posY, playerIn.posZ, SoundEvents.ENTITY_GHAST_SHOOT, SoundCategory.NEUTRAL, 0.5f, 0.4f / (random.nextFloat() * 0.4f + 0.8f))
        if (!worldIn.isRemote) {
            if (result is RayTraceResult) {

                val fireballentity = FireballEntity(worldIn, playerIn, playerIn.lookVec.x, playerIn.lookVec.y, playerIn.lookVec.z)
                worldIn.addEntity(fireballentity)
            }
        }

        playerIn.addStat(Stats.ITEM_USED.get(this))
        if (!playerIn.abilities.isCreativeMode) {
            itemstack.shrink(1)
        }

        return ActionResult.resultSuccess(itemstack)
    }
}