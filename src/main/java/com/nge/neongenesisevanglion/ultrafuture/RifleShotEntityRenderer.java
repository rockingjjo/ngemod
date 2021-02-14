package com.nge.neongenesisevanglion.ultrafuture;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.render.OverlayTexture;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRenderDispatcher;
import net.minecraft.client.render.entity.EntityRenderer;
import net.minecraft.client.render.model.json.ModelTransformation.Mode;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.Identifier;

public class RifleShotEntityRenderer extends EntityRenderer<RifleShot> {

    public static final ItemStack STACK = new ItemStack(Items.TNT);

    public RifleShotEntityRenderer(EntityRenderDispatcher dispatcher) {
        super(dispatcher);
    }

    @Override
    public void render(RifleShot entity, float yaw, float tickDelta, MatrixStack matrices,
            VertexConsumerProvider vertexConsumers, int light) {
        
                MinecraftClient.getInstance().getItemRenderer().renderItem(STACK, Mode.FIXED, light, OverlayTexture.DEFAULT_UV, matrices, vertexConsumers);

        super.render(entity, yaw, tickDelta, matrices, vertexConsumers, light);
    }

    @Override
    public Identifier getTexture(RifleShot entity) {
        return null;
    }
}
