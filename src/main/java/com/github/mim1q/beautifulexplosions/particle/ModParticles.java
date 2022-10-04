package com.github.mim1q.beautifulexplosions.particle;

import com.github.mim1q.beautifulexplosions.BeautifulExplosions;
import net.fabricmc.fabric.api.client.particle.v1.ParticleFactoryRegistry;
import net.fabricmc.fabric.api.event.client.ClientSpriteRegistryCallback;
import net.fabricmc.fabric.api.particle.v1.FabricParticleTypes;
import net.minecraft.particle.DefaultParticleType;
import net.minecraft.screen.PlayerScreenHandler;
import net.minecraft.util.registry.Registry;

public class ModParticles {

  public static final DefaultParticleType EXPLOSION_FIREBALL = FabricParticleTypes.simple();

  public static void init() {
    Registry.register(Registry.PARTICLE_TYPE, BeautifulExplosions.id("explosion_fireball"), EXPLOSION_FIREBALL);

    ClientSpriteRegistryCallback.event(PlayerScreenHandler.BLOCK_ATLAS_TEXTURE).register((atlasTexture, registry) -> {
      registry.register(BeautifulExplosions.id("particle/explosion_fireball"));
    });

    ParticleFactoryRegistry.getInstance().register(EXPLOSION_FIREBALL, ExplosionFireballParticle.Factory::new);
  }
}
