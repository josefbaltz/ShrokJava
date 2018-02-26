package commandPackages;

import sx.blah.discord.api.events.EventSubscriber;
import sx.blah.discord.handle.impl.events.guild.channel.message.MessageReceivedEvent;

import java.util.*;

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
            randomorgCall(1, args, event);

        } else if (args.get(0).equals("2")){
            randomorgCall(2, args, event);

        } else if (args.get(0).equals("3")){
            randomorgCall(3, args, event);

        } else if (args.get(0).equals("4")){
            randomorgCall(4, args, event);

        } else { coreUtils.sendMessage(event.getChannel(), "```[Unknown Error]```"); }
    }
    private void randomorgCall(int i, List<String> args, MessageReceivedEvent event){
        switch (args.get(1)) {
            case "d2":
                coreUtils.sendMessage(event.getChannel(), "d2 Received");
            case "d4":
                coreUtils.sendMessage(event.getChannel(), "d4 Received");
            case "d6":
                coreUtils.sendMessage(event.getChannel(), "d6 Received");
            case "d8":
                coreUtils.sendMessage(event.getChannel(), "d8 Received");
            case "d10":
                coreUtils.sendMessage(event.getChannel(), "d10 Received");
            case "d12":
                coreUtils.sendMessage(event.getChannel(), "d12 Received");
            case "d20":
                coreUtils.sendMessage(event.getChannel(), "d20 Received");
            case "d100":
                coreUtils.sendMessage(event.getChannel(), "d100 Received");
        }
        coreUtils.sendMessage(event.getChannel(), "Improper Dice Type!");
    }
}
