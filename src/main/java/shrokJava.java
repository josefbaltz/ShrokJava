import commandPackages.csgoStatistics.csgoWeapons;
import commandPackages.rollCommand.diceRollHandler;
import sx.blah.discord.api.IDiscordClient;
import commandPackages.*;

public class shrokJava {
    public static void main(String[] args) {
        if (args.length != 1) {
            System.err.println("No API Token was Provided!");
            System.err.println("    In the startup script please add API token after jar Ex: 'java -jar shrokjava.jar TokenHere'");
            return;
        }

        IDiscordClient bot = coreUtils.getBuiltDiscordClient(args[0]);

        bot.getDispatcher().registerListener(new coreUtils());
        bot.getDispatcher().registerListener(new diceRollHandler());
        bot.getDispatcher().registerListener(new csgoWeapons());

        bot.login();
    }
}
