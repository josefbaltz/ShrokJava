package commandPackages.rollCommand;

import sx.blah.discord.handle.impl.events.guild.channel.message.MessageReceivedEvent;

import java.util.concurrent.ThreadLocalRandom;

import static commandPackages.coreUtils.sendHelp;

public class randomService {
    public static int randomNumber(int dieSize, MessageReceivedEvent event) throws IllegalArgumentException, IndexOutOfBoundsException, InterruptedException {
        try {
            int number = ThreadLocalRandom.current().nextInt(1, dieSize + 1);
        } catch (IllegalArgumentException e) {
            sendHelp(event.getChannel(), "]roll {1-5} d{Dice Type}", "]roll 5 d20");
            throw e;
        } catch (IndexOutOfBoundsException e){
            sendHelp(event.getChannel(), "]roll {1-5} d{Dice Type}", "]roll 5 d20");
            throw e;
        }
        Thread.sleep(5);
        int number = ThreadLocalRandom.current().nextInt(1, dieSize + 1);
        return number;
    }
}
