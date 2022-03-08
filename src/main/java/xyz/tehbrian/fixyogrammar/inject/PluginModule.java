package xyz.tehbrian.fixyogrammar.inject;

import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import org.bukkit.Server;
import org.bukkit.plugin.java.JavaPlugin;
import org.checkerframework.checker.nullness.qual.NonNull;
import xyz.tehbrian.fixyogrammar.FixYoGrammar;

import java.util.logging.Logger;

public final class PluginModule extends AbstractModule {

    private final FixYoGrammar fixYoGrammar;

    public PluginModule(
            final @NonNull FixYoGrammar fixYoGrammar
    ) {
        this.fixYoGrammar = fixYoGrammar;
    }

    @Override
    protected void configure() {
        this.bind(FixYoGrammar.class).toInstance(this.fixYoGrammar);
        this.bind(JavaPlugin.class).toInstance(this.fixYoGrammar);
    }

    @Provides
    @PluginLogger
    public Logger providePluginLogger() {
        return this.fixYoGrammar.getLogger();
    }

    @Provides
    public Server provideServer() {
        return this.fixYoGrammar.getServer();
    }

}
