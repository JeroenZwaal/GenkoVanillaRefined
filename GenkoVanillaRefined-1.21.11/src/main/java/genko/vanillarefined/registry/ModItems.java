package genko.vanillarefined.registry;

import genko.vanillarefined.Genko;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;

public final class ModItems {

    public static final Item SlingShot = registerItem("slingshot",
            settings -> settings.maxCount(1)
    );

    private static Item registerItem(String path, java.util.function.UnaryOperator<Item.Settings> settingsOp) {
        Identifier id = Identifier.of(Genko.MOD_ID, path);
        Item.Settings settings = new Item.Settings()
                .registryKey(RegistryKey.of(RegistryKeys.ITEM, id));

        settings = settingsOp.apply(settings);

        return Registry.register(Registries.ITEM, id, new Item(settings));
    }

    public static void registerModItems() {
        Genko.LOGGER.info("Registering Mod items for " + Genko.MOD_ID);
    }
}
