package commandPackages;

import sx.blah.discord.api.ClientBuilder;
import sx.blah.discord.api.IDiscordClient;
import sx.blah.discord.api.events.EventSubscriber;
import sx.blah.discord.handle.impl.events.guild.channel.message.MessageReceivedEvent;
import sx.blah.discord.handle.obj.IChannel;
import sx.blah.discord.util.DiscordException;
import sx.blah.discord.util.RequestBuffer;
import sx.blah.discord.util.EmbedBuilder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
            try {
                channel.sendMessage(message);
            } catch (DiscordException error){
                System.err.println("[ERROR] Message Failed to send: ");
                error.printStackTrace();
            }
        });
    }
    public static void sendHelp(IChannel channel, String syntaxText, String exampleText){
        EmbedBuilder builder = new EmbedBuilder();
        builder.withTitle("Help");
        builder.withColor(20, 60, 255);
        builder.appendField("Syntax", syntaxText, true);
        builder.appendField("Example", exampleText, true);
        builder.withFooterText("ShrokBot (c) 2018");
        RequestBuffer.request(() -> {
            try {
                channel.sendMessage(builder.build());
            } catch (DiscordException error) {
                System.err.println("[ERROR] Message Failed to send: ");
                error.printStackTrace();
            }
        });
    }
    @EventSubscriber
    public void onMessageReceived(MessageReceivedEvent event){
        String[] argArray = event.getMessage().getContent().split(" ");
        if (argArray.length == 0)
            return;
        if (!argArray[0].startsWith(coreUtils.BOT_PREFIX))
            return;
        String commandStr = argArray[0].substring(1).toLowerCase();
        List<String> argsList = new ArrayList<>(Arrays.asList(argArray));
        argsList.remove(0);

        switch(commandStr){
            case "help":
                helpCommand(argsList, event);
                System.out.println("[INFO] help command received");
                System.out.println("    Command sent by " + event.getAuthor().getDisplayName(event.getGuild()));
        }
    }
    private void helpCommand(List<String> args, MessageReceivedEvent event){
        if (args.isEmpty() || args.size() >= 2) {
            sendHelp(event.getChannel(), "]help {Command}", "]help roll");
            sendMessage(event.getChannel(), "Avaliable Commands: ```help, roll, cswep```");
        } else {
            switch (args.get(0).toLowerCase()) {
                case "roll": {
                    sendHelp(event.getChannel(), "]roll {1-5} d{Dice Type}", "]roll 5 d20");
                    break;
                }
                case "help": {
                    sendHelp(event.getChannel(), "]help {Command}", "]help roll");
                    break;
                }
                case "cswep": {
                    sendHelp(event.getChannel(), "]cswep {Weapon}", "]cswep awp");
                    break;
                }
                default: {
                    sendMessage(event.getChannel(), "```[ERROR] Unknown Command!```");
                    break;
                }
            }
        }
    }
}
