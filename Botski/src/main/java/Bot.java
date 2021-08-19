import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.entities.MessageChannel;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;

import javax.security.auth.login.LoginException;

public class Bot extends ListenerAdapter {

    private static final Bot instance = new Bot();

    public static Bot getInstance() {
        return instance;
    }

    public static void main(String[] args) throws LoginException {

        String token = " ";
        JDABuilder builder = JDABuilder.createDefault(token)
                .setActivity(Activity.listening("?"));

        JDA jda = builder.build();
        jda.addEventListener(getInstance());
    }

    @Override
    public void onMessageReceived(@NotNull MessageReceivedEvent event) {

        //hier gern rumspielen...es ist einfach in eine nachmittag zusammengebastelt worden :D
        MessageChannel channel = event.getChannel();

        if (event.getAuthor().isBot()) {
            return;
        }

        if (event.getMessage().getContentRaw().equals("?ping")) {
            channel.sendMessage("pong").queue();
        }
    }
}
