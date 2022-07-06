package org.example.commands;

import me.koply.kcommando.integration.impl.jda.JDACommand;
import me.koply.kcommando.integration.impl.jda.JRunnable;
import me.koply.kcommando.internal.annotations.Argument;
import me.koply.kcommando.internal.annotations.Commando;
import net.dv8tion.jda.api.entities.emoji.Emoji;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

@Commando(name = "Ping!",
        aliases = "ping",
        description = "Pong!", /* "-"   default */
        guildOnly = false,     /* false default */
        ownerOnly = false,     /* false default */
        privateOnly = false,   /* false default */
        sync = false,          /* false default */
        onlyArguments = false  /* false default */)
public class BasicCommand extends JDACommand {

    public BasicCommand() {

        // when handle method returns false, runs the declared callback like this
        getInfo().setOnFalseCallback( (JRunnable) e -> e.getMessage().addReaction(Emoji.fromFormatted("⛔")).queue() );
    }

    @Override
    public boolean handle(MessageReceivedEvent e /* optionally String[] args*/ ) {
        e.getChannel().sendMessage( "Pong!" ).queue();
        return true;
        // if your command is completed successfully, you must return "true"
    }

    @Argument(arg = "test")
    public boolean test(MessageReceivedEvent e) {
        e.getChannel().sendMessage( "Test!" ).queue();
        return true;
    }
}
