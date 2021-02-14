package com.nge.neongenesisevanglion.ultrafuture;
import com.mojang.authlib.yggdrasil.response.User;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

public class PalletRifleItem extends Item{

    public PalletRifleItem(Settings settings) {
        super(settings);
    }
    
    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity playerEntity, Hand hand){
        playerEntity.playSound(SoundEvents.BLOCK_WOOL_BREAK, 1.0F, 1.0F);
        RifleShot proj = new RifleShot(NeonGenesisEvanglion.RIFLESHOT, world);
        proj.setPos(playerEntity.getX(),playerEntity.getY(),playerEntity.getZ());
        proj.setOwner(playerEntity);
        proj.setProperties(playerEntity, playerEntity.pitch, playerEntity.yaw, 0, 3,0f);
        world.spawnEntity(proj);
        return new TypedActionResult<ItemStack>(ActionResult.SUCCESS, playerEntity.getStackInHand(hand));

    }

}
