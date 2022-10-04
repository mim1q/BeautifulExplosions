package com.github.mim1q.beautifulexplosions;

import net.fabricmc.api.ClientModInitializer;
import net.minecraft.util.Identifier;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class BeautifulExplosions implements ClientModInitializer {
  public static final String MOD_ID = "beautiful_explosions";
  public static final Logger LOGGER = LogManager.getLogger(MOD_ID);

  @Override
  public void onInitializeClient() {
    LOGGER.info("Initializing Beautiful Explosions by mim1q");
  }

  public Identifier id(String path) {
    return new Identifier(MOD_ID, path);
  }
}
