package commandPackages.rollCommand;

import commandPackages.coreUtils;
import sx.blah.discord.api.events.EventSubscriber;
import sx.blah.discord.handle.impl.events.guild.channel.message.MessageReceivedEvent;
import sx.blah.discord.util.DiscordException;
import sx.blah.discord.util.EmbedBuilder;
import sx.blah.discord.util.RequestBuffer;

import java.util.*;

import static commandPackages.coreUtils.sendHelp;

public class diceRollHandler {
    @EventSubscriber
    public void onMessageReceived(MessageReceivedEvent event) throws IllegalArgumentException, IndexOutOfBoundsException, InterruptedException {
        String[] argArray = event.getMessage().getContent().split(" ");
        if (argArray.length == 0)
            return;
        if (!argArray[0].startsWith(coreUtils.BOT_PREFIX))
            return;
        String commandStr = argArray[0].substring(1).toLowerCase();
        List<String> argsList = new ArrayList<>(Arrays.asList(argArray));
        argsList.remove(0);

        switch(commandStr){
            case "roll":
                try {
                    Integer.parseInt(argsList.get(1).substring(1));
                } catch (IllegalArgumentException e) {
                    sendHelp(event.getChannel(), "]roll {1-5} d{Dice Type} (+/-#)", "]roll 5 d20 +6");
                    throw e;
                } catch (IndexOutOfBoundsException e){
                    sendHelp(event.getChannel(), "]roll {1-5} d{Dice Type} (+/-#)", "]roll 5 d20 +6");
                    throw e;
                }
                rollInit(event, argsList);
                System.out.println("[INFO] roll command received");
                System.out.println("    Command sent by " + event.getAuthor().getDisplayName(event.getGuild()));
                break;
        }
    }
    private void rollInit(MessageReceivedEvent event, List<String> args) throws InterruptedException {
        if (args.isEmpty() || args.size() <=1 || args.size() >= 4 || Integer.parseInt(args.get(0)) >= 6 ||
                Integer.parseInt(args.get(0)) <= 0) {
            sendHelp(event.getChannel(), "]roll {1-5} d{Dice Type} (+/-#)", "]roll 5 d20 +6");
        } else {
            dieCall(Integer.parseInt(args.get(0)), args, event);
        }
    }
    private void dieCall(int i, List<String> args, MessageReceivedEvent event) throws InterruptedException {
        EmbedBuilder builder = new EmbedBuilder();
        builder.withTitle(event.getAuthor().getDisplayName(event.getGuild()) + " Roll Results");
        builder.withColor(20, 60, 255);
        ArrayList<Integer> RandomList = new ArrayList<Integer>();
        try {
            if (args.get(2).startsWith("+")) {
                for (int x = 0; x <= Integer.parseInt(args.get(0)) - 1; x++) {
                    int dieSize = Integer.parseInt(args.get(1).substring(1));
                    RandomList.add(randomService.randomNumber(dieSize, event));
                }
                switch (Integer.parseInt(args.get(0))) {
                    case 1:
                        builder.appendField("Roll", Integer.toString(RandomList.get(0) + Integer.parseInt(args.get(2).replace("+", ""))), true);
                        break;
                    case 2:
                        builder.appendField("Roll", Integer.toString((RandomList.get(0) + RandomList.get(1)) + Integer.parseInt(args.get(2).replace("+", ""))), true);
                        break;
                    case 3:
                        builder.appendField("Roll", Integer.toString((RandomList.get(0) + RandomList.get(1) + RandomList.get(2)) + Integer.parseInt(args.get(2).replace("+", ""))), true);
                        break;
                    case 4:
                        builder.appendField("Roll", Integer.toString((RandomList.get(0) + RandomList.get(1) + RandomList.get(2) + RandomList.get(3)) + Integer.parseInt(args.get(2).replace("+", ""))), true);
                        break;
                    case 5:
                        builder.appendField("Roll", Integer.toString((RandomList.get(0) + RandomList.get(1) + RandomList.get(2) + RandomList.get(3) + RandomList.get(4)) + Integer.parseInt(args.get(2).replace("+", ""))), true);
                        break;
                    default:
                        sendHelp(event.getChannel(), "]roll {1-5} d{Dice Type} (+/-#)", "]roll 5 d20 +6");
                        break;
                }
            } else if (args.get(2).startsWith("-")) {
                for (int x = 0; x <= Integer.parseInt(args.get(0)) - 1; x++) {
                    int dieSize = Integer.parseInt(args.get(1).substring(1));
                    RandomList.add(randomService.randomNumber(dieSize, event));
                }
                switch (Integer.parseInt(args.get(0))) {
                    case 1:
                        builder.appendField("Roll", Integer.toString(RandomList.get(0) - Integer.parseInt(args.get(2).replace("-", ""))), true);
                        break;
                    case 2:
                        builder.appendField("Roll", Integer.toString((RandomList.get(0) + RandomList.get(1)) - Integer.parseInt(args.get(2).replace("-", ""))), true);
                        break;
                    case 3:
                        builder.appendField("Roll", Integer.toString((RandomList.get(0) + RandomList.get(1) + RandomList.get(2)) - Integer.parseInt(args.get(2).replace("-", ""))), true);
                        break;
                    case 4:
                        builder.appendField("Roll", Integer.toString((RandomList.get(0) + RandomList.get(1) + RandomList.get(2) + RandomList.get(3)) - Integer.parseInt(args.get(2).replace("-", ""))), true);
                        break;
                    case 5:
                        builder.appendField("Roll", Integer.toString((RandomList.get(0) + RandomList.get(1) + RandomList.get(2) + RandomList.get(3) + RandomList.get(4)) - Integer.parseInt(args.get(2).replace("-", ""))), true);
                        break;
                    default:
                        sendHelp(event.getChannel(), "]roll {1-5} d{Dice Type} (+/-#)", "]roll 5 d20 +6");
                        break;
                }
            }
        } catch (java.lang.IndexOutOfBoundsException e) {
            for (int x = 0; x <= Integer.parseInt(args.get(0)) - 1; x++) {
                int dieSize = Integer.parseInt(args.get(1).substring(1));
                builder.appendField("Roll", Integer.toString(randomService.randomNumber(dieSize, event)), true);
            }
        }
        builder.withFooterText("ShrokBot (c) 2018");
        RequestBuffer.request(() -> {
            try {
                event.getChannel().sendMessage(builder.build());
            } catch (DiscordException error) {
                System.err.println("[ERROR] Message Failed to send: ");
                error.printStackTrace();
            }
        });
    }
}
