package com.nge.neongenesisevanglion.ultrafuture;

import  com.nge.neongenesisevanglion.ultrafuture.NeonGenesisEvanglion;
import net.minecraft.util.Identifier;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class Unit01Model extends AnimatedGeoModel<Unit01Entity>
{


    @Override
    public Identifier getModelLocation(Unit01Entity  object)
    {
        return new Identifier(NeonGenesisEvanglion.ModID, "geo/unit01Entity.geo.json");
    }

    @Override
    public Identifier getTextureLocation(Unit01Entity object)
    {
        return new Identifier(NeonGenesisEvanglion.ModID, "textures/model/unit01.png");
    }

    @Override
    public Identifier getAnimationFileLocation(Unit01Entity object)
    {
        return new Identifier(NeonGenesisEvanglion.ModID, "animations/unit01.animation.json");
    }
}
