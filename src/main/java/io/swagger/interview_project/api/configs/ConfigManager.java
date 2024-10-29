package io.swagger.interview_project.api.configs;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.aeonbits.owner.ConfigCache;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class ConfigManager {
    private static final AppConfig APP_CONFIG = ConfigCache.getOrCreate(AppConfig.class);

    public static AppConfig appConfig() {
        return APP_CONFIG;
    }
}
