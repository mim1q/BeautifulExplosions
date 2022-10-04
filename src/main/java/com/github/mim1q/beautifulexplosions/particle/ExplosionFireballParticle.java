package com.github.mim1q.beautifulexplosions.particle;

import net.minecraft.client.particle.*;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.particle.DefaultParticleType;
import org.jetbrains.annotations.Nullable;

public class ExplosionFireballParticle extends SpriteBillboardParticle {

  private final SpriteProvider spriteProvider;

  protected ExplosionFireballParticle(
    ClientWorld world,
    double x,
    double y,
    double z,
    SpriteProvider spriteProvider
  ) {
    super(world, x, y, z);
    this.spriteProvider = spriteProvider;
    this.setSprite(spriteProvider);
    this.setSpriteForAge(spriteProvider);
    this.setAlpha(1.0F);
    this.scale = 0.25F;

    this.maxAge = 10;
  }

  @Override
  public void tick() {
    super.tick();
    float f = (float) this.age / (float) this.maxAge;
    this.scale = 0.25F + f;
    this.setAlpha(f < 0.75F ? 1.0F : 1.0F - (f - 0.75F) / 0.25F);
    this.setSpriteForAge(this.spriteProvider);
  }

  @Override
  public ParticleTextureSheet getType() {
    return ParticleTextureSheet.PARTICLE_SHEET_TRANSLUCENT;
  }

  public static class Factory implements ParticleFactory<DefaultParticleType> {
    private final SpriteProvider spriteProvider;

    public Factory(SpriteProvider spriteProvider) {
      this.spriteProvider = spriteProvider;
    }

    @Nullable
    @Override
    public Particle createParticle(
      DefaultParticleType parameters,
      ClientWorld world,
      double x,
      double y,
      double z,
      double velocityX,
      double velocityY,
      double velocityZ
    ) {
      return new ExplosionFireballParticle(world, x, y, z, spriteProvider);
    }
  }
}
