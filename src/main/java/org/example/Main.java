package org.example;
import me.koply.kcommando.KCommando;
import me.koply.kcommando.integration.impl.jda.JDAIntegration;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import io.github.cdimascio.dotenv.Dotenv;

public class Main extends JDAIntegration {
    public Main(JDA jda) {super(jda);}

    public static void main(String[] args) throws Exception {
        Dotenv dotenv = Dotenv.load();
        String token = dotenv.get("TOKEN");
        String ownerID = dotenv.get("OWNERID");
        String prefix = dotenv.get("PREFIX");

        JDA jda = JDABuilder.createDefault(token).build();
        jda.awaitReady();

        KCommando<MessageReceivedEvent> kcommando = new KCommando<>(new Main(jda))
                .setCooldown(5000L)
                .setOwners(ownerID)
                .setPackage("org.example.commands")
                .setPrefix(prefix)
                .setReadBotMessages(false)
                .build();
    }
}