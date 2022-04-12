package com.hjae.findme.proxy;

import com.hjae.findme.FindMe;
import net.minecraftforge.common.config.Config;
import net.minecraftforge.common.config.ConfigManager;
import net.minecraftforge.fml.client.event.ConfigChangedEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Config(modid = FindMe.MOD_ID)
public class FindMeConfig {

    @Config.Comment("Checking radius centered on the player")
    @Config.RangeInt(min = 0)
    public static int RADIUS_RANGE = 8;

    @Mod.EventBusSubscriber(modid = FindMe.MOD_ID)
    private static class EventHandler {
        @SubscribeEvent
        public static void onConfigChanged(final ConfigChangedEvent.OnConfigChangedEvent event) {
            if (event.getModID().equals(FindMe.MOD_ID)) {
                ConfigManager.sync(FindMe.MOD_ID, Config.Type.INSTANCE);
            }
        }
    }
}
