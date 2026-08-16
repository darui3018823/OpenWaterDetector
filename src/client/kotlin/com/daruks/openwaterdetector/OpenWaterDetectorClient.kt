package com.daruks.openwaterdetector

import net.fabricmc.api.ClientModInitializer
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents
import net.minecraft.client.Minecraft
import net.minecraft.network.chat.Component
import net.minecraft.network.chat.Style
import net.minecraft.ChatFormatting
import net.minecraft.world.entity.projectile.FishingHook

private const val CHECK_INTERVAL_TICKS = 5

class OpenWaterDetectorClient : ClientModInitializer {
    override fun onInitializeClient() {
        ClientTickEvents.END_CLIENT_TICK.register(::onClientTick)
    }

    private fun onClientTick(client: Minecraft) {
        if (client.level == null || client.player == null || client.tickCount % CHECK_INTERVAL_TICKS != 0) {
            return
        }

        val hook = client.player!!.fishing
        if (hook == null) {
            trackedHook = null
            lastOpenWater = null
            return
        }

        if (hook !== trackedHook) {
            trackedHook = hook
            lastOpenWater = null
        }

        val openWater = hook.isOpenWaterFishing
        if (openWater != lastOpenWater) {
            lastOpenWater = openWater
            sendStatus(client, openWater)
        }
    }

    private fun sendStatus(client: Minecraft, openWater: Boolean) {
        val status = if (openWater) "Open Water" else "Not Open Water"
        val color = if (openWater) ChatFormatting.GREEN else ChatFormatting.RED
        val message = Component.literal("[OWD] ")
            .withStyle(Style.EMPTY.withColor(ChatFormatting.AQUA))
            .append(Component.literal(status).withStyle(Style.EMPTY.withColor(color)))

        client.player?.displayClientMessage(message, false)
    }

    private var trackedHook: FishingHook? = null
    private var lastOpenWater: Boolean? = null
}
