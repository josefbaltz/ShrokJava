package commandPackages;

import sx.blah.discord.api.ClientBuilder;
import sx.blah.discord.api.IDiscordClient;
import sx.blah.discord.handle.obj.IChannel;
import sx.blah.discord.util.DiscordException;
import sx.blah.discord.util.RequestBuffer;

public class coreUtils {
    public static String BOT_TOKEN = "MzYxNjQyNzIxNzc5MTIyMTg3.DKnQvA.8CbY3sHLZc178ew7UzQUC8PHTgs";
    public static String BOT_PREFIX = "]";
    public static IDiscordClient getBuiltDiscordClient(){
        return new ClientBuilder()
                .withToken(BOT_TOKEN)
                .build();
    }
    public static void sendMessage(IChannel channel, String message){
        RequestBuffer.request(() -> {
            try{
                channel.sendMessage(message);
            } catch (DiscordException error){
                System.err.println("[ERROR] Message Failed to send: ");
                error.printStackTrace();
            }
        });
    }
}
