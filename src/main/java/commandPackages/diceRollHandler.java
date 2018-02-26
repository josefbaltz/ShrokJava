package commandPackages;

import sx.blah.discord.api.events.EventSubscriber;
import sx.blah.discord.handle.impl.events.guild.channel.message.MessageReceivedEvent;
import sx.blah.discord.util.RequestBuffer;

import java.util.*;

//TODO Allow any type of dice

public class diceRollHandler {
    @EventSubscriber
    public void onMessageReceived(MessageReceivedEvent event){
        String[] argArray = event.getMessage().getContent().split(" ");
        if (argArray.length == 0)
            return;
        if (!argArray[0].startsWith(coreUtils.BOT_PREFIX))
            return;
        String commandStr = argArray[0].substring(1);
        List<String> argsList = new ArrayList<>(Arrays.asList(argArray));
        argsList.remove(0);

        switch(commandStr){
            case "roll":
                rollInit(event, argsList);
                System.out.println("[INFO] roll command received");
                System.out.println("    Command sent by " + event.getAuthor().getDisplayName(event.getGuild()));
        }
    }
    private void rollInit(MessageReceivedEvent event, List<String> args) {
        if (args.isEmpty() || args.size() <=1 ) {
            coreUtils.sendMessage(event.getChannel(), "Not Enough Arguments Received!");
            coreUtils.sendMessage(event.getChannel(), "    ```" + coreUtils.BOT_PREFIX + "roll {rolls 1-4} {dice}```");
        } else if (args.size() >= 3) {
            coreUtils.sendMessage(event.getChannel(), "Too Many Arguments Received!");
            coreUtils.sendMessage(event.getChannel(), "    ```" + coreUtils.BOT_PREFIX + "roll {rolls 1-4} {dice}```");

        } else if (args.get(0).equals("1")){
            RequestBuffer.request(() -> {
                dieCall(1, args, event);
            });

        } else if (args.get(0).equals("2")){
            RequestBuffer.request(() -> {
                dieCall(2, args, event);
            });

        } else if (args.get(0).equals("3")){
            RequestBuffer.request(() -> {
                dieCall(3, args, event);
            });

        } else if (args.get(0).equals("4")){
            RequestBuffer.request(() -> {
                dieCall(4, args, event);
            });

        } else if (!args.get(0).equals("1") && !args.get(0).equals("2") && !args.get(0).equals("3") && !args.get(0).equals("4")){
            coreUtils.sendMessage(event.getChannel(), "Roll Count Error!");
            coreUtils.sendMessage(event.getChannel(), "    ```Maximum is 4 AND Must be a Number```");
        } else { coreUtils.sendMessage(event.getChannel(), "```Unknown Error```"); }
    }
    private void dieCall(int i, List<String> args, MessageReceivedEvent event){
        switch (args.get(1)) {
            case "d2":
                for (int x = 0; x <= Integer.parseInt(args.get(0))-1; x++) {
                    coreUtils.sendMessage(event.getChannel(), "```" +
                            event.getAuthor().getDisplayName(event.getGuild()) + " rolled a " +
                            randomService.randomNumber(2) + "```");
                }
                break;
            case "d4":
                for (int x = 0; x <= Integer.parseInt(args.get(0))-1; x++) {
                    coreUtils.sendMessage(event.getChannel(), "```" +
                            event.getAuthor().getDisplayName(event.getGuild()) + " rolled a " +
                            randomService.randomNumber(4) + "```");
                }
                break;
            case "d6":
                for (int x = 0; x <= Integer.parseInt(args.get(0))-1; x++) {
                    coreUtils.sendMessage(event.getChannel(), "```" +
                            event.getAuthor().getDisplayName(event.getGuild()) + " rolled a " +
                            randomService.randomNumber(6) + "```");
                }
                break;
            case "d8":
                    for (int x = 0; x <= Integer.parseInt(args.get(0))-1; x++) {
                        coreUtils.sendMessage(event.getChannel(), "```" +
                                event.getAuthor().getDisplayName(event.getGuild()) + " rolled a " +
                                randomService.randomNumber(8) + "```");
                    }
                break;
            case "d10":
                for (int x = 0; x <= Integer.parseInt(args.get(0))-1; x++) {
                    coreUtils.sendMessage(event.getChannel(), "```" +
                            event.getAuthor().getDisplayName(event.getGuild()) + " rolled a " +
                            randomService.randomNumber(10) + "```");
                }
                break;
            case "d12":
                for (int x = 0; x <= Integer.parseInt(args.get(0))-1; x++) {
                    coreUtils.sendMessage(event.getChannel(), "```" +
                            event.getAuthor().getDisplayName(event.getGuild()) + " rolled a " +
                            randomService.randomNumber(12) + "```");
                }
                break;
            case "d20":
                for (int x = 0; x <= Integer.parseInt(args.get(0))-1; x++) {
                    coreUtils.sendMessage(event.getChannel(), "```" +
                            event.getAuthor().getDisplayName(event.getGuild()) + " rolled a " +
                            randomService.randomNumber(20) + "```");
                }
                break;
            case "d100":
                for (int x = 0; x <= Integer.parseInt(args.get(0))-1; x++) {
                    coreUtils.sendMessage(event.getChannel(), "```" +
                            event.getAuthor().getDisplayName(event.getGuild()) + " rolled a " +
                            randomService.randomNumber(100) + "```");
                }
                break;
            default:
                coreUtils.sendMessage(event.getChannel(), "Improper Dice Type!");
                break;
        }
    }
}
