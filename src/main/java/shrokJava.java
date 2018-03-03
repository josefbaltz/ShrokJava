import commandPackages.rollCommand.diceRollHandler;
import sx.blah.discord.api.IDiscordClient;
import commandPackages.*;

public class shrokJava {
    public static void main(String[] args) {

        IDiscordClient bot = coreUtils.getBuiltDiscordClient();

        bot.getDispatcher().registerListener(new coreUtils());
        bot.getDispatcher().registerListener(new diceRollHandler());

        bot.login();
    }
}
