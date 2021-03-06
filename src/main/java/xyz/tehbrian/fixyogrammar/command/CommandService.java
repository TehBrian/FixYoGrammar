package xyz.tehbrian.fixyogrammar.command;

import cloud.commandframework.execution.CommandExecutionCoordinator;
import cloud.commandframework.paper.PaperCommandManager;
import com.google.inject.Inject;
import dev.tehbrian.tehlib.paper.cloud.PaperCloudService;
import org.bukkit.command.CommandSender;
import org.checkerframework.checker.nullness.qual.NonNull;
import xyz.tehbrian.fixyogrammar.FixYoGrammar;

import java.util.function.Function;

public final class CommandService extends PaperCloudService<CommandSender> {

    private final FixYoGrammar fixYoGrammar;

    @Inject
    public CommandService(
            final @NonNull FixYoGrammar fixYoGrammar
    ) {
        this.fixYoGrammar = fixYoGrammar;
    }

    /**
     * Instantiates {@link #commandManager}.
     *
     * @throws IllegalStateException if {@link #commandManager} is already instantiated
     * @throws Exception             if something goes wrong during instantiation
     */
    public void init() throws Exception {
        if (this.commandManager != null) {
            throw new IllegalStateException("The CommandManager is already instantiated.");
        }

        this.commandManager = new PaperCommandManager<>(
                this.fixYoGrammar,
                CommandExecutionCoordinator.simpleCoordinator(),
                Function.identity(),
                Function.identity()
        );
    }

}
