package io.swagger.interview_project.api.configs;

import org.aeonbits.owner.Config.Sources;
import org.aeonbits.owner.Mutable;

@Sources({
    "classpath:app.properties"
})
public interface AppConfig extends Mutable {
    // Common
    @Key("base.url")
    String baseUrl();
}
