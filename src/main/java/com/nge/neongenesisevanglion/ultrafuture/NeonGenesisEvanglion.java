package com.nge.neongenesisevanglion.ultrafuture;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.rendereregistry.v1.EntityRendererRegistry;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.item.BowItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import software.bernie.example.registry.EntityRegistry;
import software.bernie.geckolib3.GeckoLib;

public class NeonGenesisEvanglion implements ModInitializer {

    public static final String ModID = "ngeuf";


    public static final EntityType<RifleShot> RIFLESHOT = Registry.register(
            Registry.ENTITY_TYPE,
            new Identifier(ModID, "rifle_shot"),

            FabricEntityTypeBuilder.<RifleShot>create(SpawnGroup.MISC, RifleShot::new).dimensions(EntityDimensions.fixed(0.75f, 0.75f)).build()
    );

    public static final EntityType<Unit01Entity> UNIT01 = Registry.register(
            Registry.ENTITY_TYPE,
            new Identifier(ModID, "unit-01"),

            FabricEntityTypeBuilder.<Unit01Entity>create(SpawnGroup.CREATURE, Unit01Entity::new).dimensions(EntityDimensions.fixed(50.0f, 75.0f)).build()
    );

    public static final Item PALLET_RIFLE = new PalletRifleItem(new Item.Settings().group(ItemGroup.COMBAT));

    @Override
    public void onInitialize(){
        GeckoLib.initialize();
        Registry.register(Registry.ITEM, new Identifier(ModID, "pallet_rifle"), PALLET_RIFLE);
        EntityRendererRegistry.INSTANCE.register(NeonGenesisEvanglion.RIFLESHOT, (dispatcher, context) -> new RifleShotEntityRenderer(dispatcher));
        EntityRendererRegistry.INSTANCE.register(NeonGenesisEvanglion.UNIT01,
                (entityRenderDispatcher, context) -> new Unit01Renderer(entityRenderDispatcher));
        FabricDefaultAttributeRegistry.register(UNIT01, Unit01Entity.createMobAttributes());
    }

}