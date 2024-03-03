package org.geysermc.hydraulic.pack.modules;

import com.google.auto.service.AutoService;
import org.geysermc.hydraulic.pack.PackModule;
import org.geysermc.hydraulic.pack.context.PackPostProcessContext;
import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.util.UUID;

@AutoService(PackModule.class)
public class MetadataPackModule extends PackModule<MetadataPackModule> {
    public MetadataPackModule() {
        this.postProcess(context -> {
            // Set the pack name and description
            context.bedrockResourcePack().manifest().header().name(context.mod().name().trim() + " Resource Pack");
            context.bedrockResourcePack().manifest().header().description(context.mod().name().trim() + " " + context.mod().version() + " - Generated by Hydraulic");

            // Generate the pack uuid from the mod file
            try {
                context.bedrockResourcePack().manifest().header().uuid(UUID.nameUUIDFromBytes(Files.readAllBytes(context.mod().modFile())).toString());
            } catch (IOException ignored) { }

            // Copy the icon if it exists or copy the fallback icon
            try {
                if (!context.mod().iconPath().isEmpty() && Files.exists(context.mod().modPath().resolve(context.mod().iconPath()))) {
                    context.bedrockResourcePack().icon(Files.readAllBytes(context.mod().modPath().resolve(context.mod().iconPath())));
                } else {
                    try (InputStream stream = MetadataPackModule.class.getClassLoader().getResourceAsStream("unknown.png")) {
                        context.bedrockResourcePack().icon(stream.readAllBytes());
                    }
                }
            } catch (IOException ignored) {
            }
        });
    }

    @Override
    public boolean test(@NotNull PackPostProcessContext<MetadataPackModule> context) {
        return true;
    }
}
