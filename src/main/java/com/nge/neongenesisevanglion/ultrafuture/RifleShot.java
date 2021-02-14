package com.nge.neongenesisevanglion.ultrafuture;

import io.netty.buffer.Unpooled;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.impl.networking.ServerSidePacketRegistryImpl;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.mob.BlazeEntity;
import net.minecraft.entity.projectile.thrown.ThrownEntity;
import net.minecraft.network.Packet;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.util.Identifier;
import net.minecraft.util.hit.EntityHitResult;
import net.minecraft.util.hit.HitResult;
import net.minecraft.world.World;
import net.minecraft.world.explosion.Explosion;

import java.util.UUID;

public class RifleShot extends ThrownEntity{

    public static final Identifier SPAWN_PACKET = new Identifier("ngeuf", "rifle_shot");
    
    public RifleShot(EntityType<? extends ThrownEntity> entityType, World world){
        super(entityType, world);
    }

    @Environment(EnvType.CLIENT)
    public RifleShot(World world, double x, double y, double z, int id, UUID uuid){
        super(NeonGenesisEvanglion.RIFLESHOT, world);
        updatePosition(x,y,z);
        updateTrackedPosition(x, y, z);
        setEntityId(id);
        setUuid(uuid);
    }

    @Override
    public void initDataTracker() {
        
    }

    @Override
    public Packet<?> createSpawnPacket() {
        PacketByteBuf packetByteBuf = new PacketByteBuf(Unpooled.buffer());


        // entity position
        packetByteBuf.writeDouble(getX());
        packetByteBuf.writeDouble(getY());
        packetByteBuf.writeDouble(getZ());


        // entity id and uuid
        packetByteBuf.writeInt(getEntityId());
        packetByteBuf.writeUuid(getUuid());


        return ServerSidePacketRegistryImpl.INSTANCE.toPacket(SPAWN_PACKET, packetByteBuf);
    }

    protected void onEntityHit(EntityHitResult entityHitResult) {
        super.onEntityHit(entityHitResult);
        Entity entity = entityHitResult.getEntity();
        int i = entity instanceof BlazeEntity ? 3 : 0;
        entity.damage(DamageSource.thrownProjectile(this, this.getOwner()), (float)i);
    }

    @Override
    protected void onCollision(HitResult hitResult) {

        super.onCollision(hitResult);
        if (!this.world.isClient) {
            world.createExplosion(this, getX(), getY(), getZ(), 200, Explosion.DestructionType.DESTROY);
            this.world.sendEntityStatus(this, (byte)3);
            this.remove();
        }

    }

}
