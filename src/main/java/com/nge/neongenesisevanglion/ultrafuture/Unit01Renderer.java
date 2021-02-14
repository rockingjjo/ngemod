package com.nge.neongenesisevanglion.ultrafuture;

import net.minecraft.client.render.entity.EntityRenderDispatcher;
import software.bernie.geckolib3.renderer.geo.GeoEntityRenderer;

public class Unit01Renderer extends GeoEntityRenderer<Unit01Entity>
{
    public Unit01Renderer(EntityRenderDispatcher renderManager)
    {
        super(renderManager, new Unit01Model());
        this.shadowRadius = 0.7F; //change 0.7 to the desired shadow size.
    }
}
