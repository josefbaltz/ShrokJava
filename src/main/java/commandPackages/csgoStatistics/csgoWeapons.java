package commandPackages.csgoStatistics;

import commandPackages.coreUtils;
import sx.blah.discord.api.events.EventSubscriber;
import sx.blah.discord.handle.impl.events.guild.channel.message.MessageReceivedEvent;
import sx.blah.discord.handle.obj.IChannel;
import sx.blah.discord.util.DiscordException;
import sx.blah.discord.util.EmbedBuilder;
import sx.blah.discord.util.RequestBuffer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static commandPackages.coreUtils.sendHelp;
import static commandPackages.coreUtils.sendMessage;

public class csgoWeapons {
    @EventSubscriber
    public void onMessageReceived(MessageReceivedEvent event) throws IllegalArgumentException, IndexOutOfBoundsException{
        String[] argArray = event.getMessage().getContent().split(" ");
        if (argArray.length == 0)
            return;
        if (!argArray[0].startsWith(coreUtils.BOT_PREFIX))
            return;
        String commandStr = argArray[0].substring(1).toLowerCase();
        List<String> argsList = new ArrayList<>(Arrays.asList(argArray));
        argsList.remove(0);

        switch(commandStr){
            case "cswep":
                cswep(event, argsList);
                System.out.println("[INFO] cswep command received");
                System.out.println("    Command sent by " + event.getAuthor().getDisplayName(event.getGuild()));
        }
    }
    private void sendEmbed(IChannel channel, EmbedBuilder builder){
        RequestBuffer.request(() -> {
            try {
                channel.sendMessage(builder.build());
            } catch (DiscordException error) {
                System.err.println("[ERROR] Message Failed to send: ");
                error.printStackTrace();
            }
        });
    }
    private void cswep(MessageReceivedEvent event, List<String> args){
        EmbedBuilder builder = new EmbedBuilder();
        if (args.isEmpty() || args.size() == 0) {
            sendMessage(event.getChannel(), "```deserteagle, r8revolver, dualberettas, fiveseven, glock18, " +
                    "p2000, usps, p250, cz75auto, tec9, mag7, nova, sawedoff, xm1014, ppbizon, mac10, mp7, mp9, " +
                    "p90, ump45, ak47, aug, famas, galilar, m4a4, m4a1s, sg553, m249, negev, awp, g3sg1, scar20, " +
                    "ssg08```");
        } else if (args.size() != 1) {
            sendHelp(event.getChannel(), "]cswep {Weapon}", "]cswep awp");
        } else {
            switch(args.get(0).toLowerCase()){
                case "awp": {
                    builder.withTitle("CS:GO Weapon");
                    builder.appendField("Name", "AWP", true);
                    builder.appendField("Price", "$4,750", true);
                    builder.appendField("Kill Award", "$100", true);
                    builder.appendField("Damage", "115", true);
                    builder.appendField("Armor Penetration", "97.50%", true);
                    builder.appendField("Firerate", "41.24", true);
                    builder.withFooterText("ShrokBot (c) 2018");
                    sendEmbed(event.getChannel(), builder);
                    break;
                }
                case "g3sg1": {
                    builder.withTitle("CS:GO Weapon");
                    builder.appendField("Name", "G3SG1", true);
                    builder.appendField("Price", "$5,000", true);
                    builder.appendField("Kill Award", "$300", true);
                    builder.appendField("Damage", "80", true);
                    builder.appendField("Armor Penetration", "82.50%", true);
                    builder.appendField("Firerate", "240", true);
                    builder.withFooterText("ShrokBot (c) 2018");
                    sendEmbed(event.getChannel(), builder);
                    break;
                }
                case "scar-20": {
                    builder.withTitle("CS:GO Weapon");
                    builder.appendField("Name", "SCAR-20", true);
                    builder.appendField("Price", "$5,000", true);
                    builder.appendField("Kill Award", "$300", true);
                    builder.appendField("Damage", "80", true);
                    builder.appendField("Armor Penetration", "82.50%", true);
                    builder.appendField("Firerate", "240", true);
                    builder.withFooterText("ShrokBot (c) 2018");
                    sendEmbed(event.getChannel(), builder);
                    
                    break;
                }
                case "ssg08": {
                    builder.withTitle("CS:GO Weapon");
                    builder.appendField("Name", "SSG 08", true);
                    builder.appendField("Price", "$1,700", true);
                    builder.appendField("Kill Award", "$300", true);
                    builder.appendField("Damage", "80", true);
                    builder.appendField("Armor Penetration", "85.00%", true);
                    builder.appendField("Firerate", "48.00", true);
                    builder.withFooterText("ShrokBot (c) 2018");
                    sendEmbed(event.getChannel(), builder);
                    
                    break;
                }
                case "ak47": {
                    builder.withTitle("CS:GO Weapon");
                    builder.appendField("Name", "AK-47", true);
                    builder.appendField("Price", "$2,700", true);
                    builder.appendField("Kill Award", "$300", true);
                    builder.appendField("Damage", "36", true);
                    builder.appendField("Armor Penetration", "77.50%", true);
                    builder.appendField("Firerate", "600.00", true);
                    builder.withFooterText("ShrokBot (c) 2018");
                    sendEmbed(event.getChannel(), builder);
                    
                    break;
                }
                case "aug": {
                    builder.withTitle("CS:GO Weapon");
                    builder.appendField("Name", "AUG", true);
                    builder.appendField("Price", "$3,300", true);
                    builder.appendField("Kill Award", "$300", true);
                    builder.appendField("Damage", "28", true);
                    builder.appendField("Armor Penetration", "90.00%", true);
                    builder.appendField("Firerate", "666.67", true);
                    builder.withFooterText("ShrokBot (c) 2018");
                    sendEmbed(event.getChannel(), builder);
                    
                    break;
                }
                case "famas": {
                    builder.withTitle("CS:GO Weapon");
                    builder.appendField("Name", "FAMAS", true);
                    builder.appendField("Price", "$2,250", true);
                    builder.appendField("Kill Award", "$300", true);
                    builder.appendField("Damage", "30", true);
                    builder.appendField("Armor Penetration", "70.00%", true);
                    builder.appendField("Firerate", "666.67", true);
                    builder.withFooterText("ShrokBot (c) 2018");
                    sendEmbed(event.getChannel(), builder);
                    
                    break;
                }
                case "galil": {
                    builder.withTitle("CS:GO Weapon");
                    builder.appendField("Name", "Galil AR", true);
                    builder.appendField("Price", "$2,000", true);
                    builder.appendField("Kill Award", "$300", true);
                    builder.appendField("Damage", "30", true);
                    builder.appendField("Armor Penetration", "77.50%", true);
                    builder.appendField("Firerate", "666.67", true);
                    builder.withFooterText("ShrokBot (c) 2018");
                    sendEmbed(event.getChannel(), builder);
                    
                    break;
                }
                case "m4a4": {
                    builder.withTitle("CS:GO Weapon");
                    builder.appendField("Name", "M4A4", true);
                    builder.appendField("Price", "$3,100", true);
                    builder.appendField("Kill Award", "$300", true);
                    builder.appendField("Damage", "33", true);
                    builder.appendField("Armor Penetration", "70.00%", true);
                    builder.appendField("Firerate", "666.67", true);
                    builder.withFooterText("ShrokBot (c) 2018");
                    sendEmbed(event.getChannel(), builder);
                    
                    break;
                }
                case "m4a1s": {
                    builder.withTitle("CS:GO Weapon");
                    builder.appendField("Name", "M4A1-S", true);
                    builder.appendField("Price", "$3,100", true);
                    builder.appendField("Kill Award", "$300", true);
                    builder.appendField("Damage", "33", true);
                    builder.appendField("Armor Penetration", "70.00%", true);
                    builder.appendField("Firerate", "600", true);
                    builder.withFooterText("ShrokBot (c) 2018");
                    sendEmbed(event.getChannel(), builder);
                    
                    break;
                }
                case "sg553": {
                    builder.withTitle("CS:GO Weapon");
                    builder.appendField("Name", "SG 553", true);
                    builder.appendField("Price", "$3,000", true);
                    builder.appendField("Kill Award", "$300", true);
                    builder.appendField("Damage", "30", true);
                    builder.appendField("Armor Penetration", "100.00%", true);
                    builder.appendField("Firerate", "666.67", true);
                    builder.withFooterText("ShrokBot (c) 2018");
                    sendEmbed(event.getChannel(), builder);
                    
                    break;
                }
                case "m249": {
                    builder.withTitle("CS:GO Weapon");
                    builder.appendField("Name", "M249", true);
                    builder.appendField("Price", "$5,200", true);
                    builder.appendField("Kill Award", "$300", true);
                    builder.appendField("Damage", "32", true);
                    builder.appendField("Armor Penetration", "80.00%", true);
                    builder.appendField("Firerate", "750.00", true);
                    builder.withFooterText("ShrokBot (c) 2018");
                    sendEmbed(event.getChannel(), builder);
                    
                    break;
                }
                case "negev": {
                    builder.withTitle("CS:GO Weapon");
                    builder.appendField("Name", "Negev", true);
                    builder.appendField("Price", "$2,000", true);
                    builder.appendField("Kill Award", "$300", true);
                    builder.appendField("Damage", "35", true);
                    builder.appendField("Armor Penetration", "75.00%", true);
                    builder.appendField("Firerate", "800.00", true);
                    builder.withFooterText("ShrokBot (c) 2018");
                    sendEmbed(event.getChannel(), builder);
                    
                    break;
                }
                case "ppbizon": {
                    builder.withTitle("CS:GO Weapon");
                    builder.appendField("Name", "PP-Bizon", true);
                    builder.appendField("Price", "$1,400", true);
                    builder.appendField("Kill Award", "$600", true);
                    builder.appendField("Damage", "27", true);
                    builder.appendField("Armor Penetration", "57.50%", true);
                    builder.appendField("Firerate", "750", true);
                    builder.withFooterText("ShrokBot (c) 2018");
                    sendEmbed(event.getChannel(), builder);
                    
                    break;
                }
                case "mac10": {
                    builder.withTitle("CS:GO Weapon");
                    builder.appendField("Name", "MAC-10", true);
                    builder.appendField("Price", "$1,050", true);
                    builder.appendField("Kill Award", "$600", true);
                    builder.appendField("Damage", "29", true);
                    builder.appendField("Armor Penetration", "57.50%", true);
                    builder.appendField("Firerate", "800.00", true);
                    builder.withFooterText("ShrokBot (c) 2018");
                    sendEmbed(event.getChannel(), builder);
                    
                    break;
                }
                case "mp7": {
                    builder.withTitle("CS:GO Weapon");
                    builder.appendField("Name", "MP7", true);
                    builder.appendField("Price", "$1,700", true);
                    builder.appendField("Kill Award", "$600", true);
                    builder.appendField("Damage", "29", true);
                    builder.appendField("Armor Penetration", "62.50%", true);
                    builder.appendField("Firerate", "750.00", true);
                    builder.withFooterText("ShrokBot (c) 2018");
                    sendEmbed(event.getChannel(), builder);
                    
                    break;
                }
                case "mp9": {
                    builder.withTitle("CS:GO Weapon");
                    builder.appendField("Name", "MP9", true);
                    builder.appendField("Price", "$1,250", true);
                    builder.appendField("Kill Award", "$600", true);
                    builder.appendField("Damage", "26", true);
                    builder.appendField("Armor Penetration", "60.00%", true);
                    builder.appendField("Firerate", "857.14", true);
                    builder.withFooterText("ShrokBot (c) 2018");
                    sendEmbed(event.getChannel(), builder);
                    
                    break;
                }
                case "p90": {
                    builder.withTitle("CS:GO Weapon");
                    builder.appendField("Name", "P90", true);
                    builder.appendField("Price", "$2,350", true);
                    builder.appendField("Kill Award", "$300", true);
                    builder.appendField("Damage", "26", true);
                    builder.appendField("Armor Penetration", "69.00%", true);
                    builder.appendField("Firerate", "857.14", true);
                    builder.withFooterText("ShrokBot (c) 2018");
                    sendEmbed(event.getChannel(), builder);
                    
                    break;
                }
                case "ump45": {
                    builder.withTitle("CS:GO Weapon");
                    builder.appendField("Name", "UMP-45", true);
                    builder.appendField("Price", "$1,200", true);
                    builder.appendField("Kill Award", "$600", true);
                    builder.appendField("Damage", "35", true);
                    builder.appendField("Armor Penetration", "65.00%", true);
                    builder.appendField("Firerate", "666.67", true);
                    builder.withFooterText("ShrokBot (c) 2018");
                    sendEmbed(event.getChannel(), builder);
                    
                    break;
                }
                case "xm1014": {
                    builder.withTitle("CS:GO Weapon");
                    builder.appendField("Name", "XM1014", true);
                    builder.appendField("Price", "$2,000", true);
                    builder.appendField("Kill Award", "$900", true);
                    builder.appendField("Damage", "20", true);
                    builder.appendField("Bullets", "6", true);
                    builder.appendField("Armor Penetration", "80.00%", true);
                    builder.appendField("Firerate", "171.43", true);
                    builder.withFooterText("ShrokBot (c) 2018");
                    sendEmbed(event.getChannel(), builder);
                    
                    break;
                }
                case "sawedoff": {
                    builder.withTitle("CS:GO Weapon");
                    builder.appendField("Name", "Sawed-Off", true);
                    builder.appendField("Price", "$1,200", true);
                    builder.appendField("Kill Award", "$900", true);
                    builder.appendField("Damage", "32", true);
                    builder.appendField("Bullets", "8", true);
                    builder.appendField("Armor Penetration", "75.00%", true);
                    builder.appendField("Firerate", "70.59", true);
                    builder.withFooterText("ShrokBot (c) 2018");
                    sendEmbed(event.getChannel(), builder);
                    
                    break;
                }
                case "nova": {
                    builder.withTitle("CS:GO Weapon");
                    builder.appendField("Name", "Nova", true);
                    builder.appendField("Price", "$1,200", true);
                    builder.appendField("Kill Award", "$900", true);
                    builder.appendField("Damage", "26", true);
                    builder.appendField("Bullets", "9", true);
                    builder.appendField("Armor Penetration", "50.00%", true);
                    builder.appendField("Firerate", "68.18", true);
                    builder.withFooterText("ShrokBot (c) 2018");
                    sendEmbed(event.getChannel(), builder);
                    
                    break;
                }
                case "mag7": {
                    builder.withTitle("CS:GO Weapon");
                    builder.appendField("Name", "Mag-7", true);
                    builder.appendField("Price", "$1,700", true);
                    builder.appendField("Kill Award", "$900", true);
                    builder.appendField("Damage", "30", true);
                    builder.appendField("Bullets", "8", true);
                    builder.appendField("Armor Penetration", "75.00%", true);
                    builder.appendField("Firerate", "70.59", true);
                    builder.withFooterText("ShrokBot (c) 2018");
                    sendEmbed(event.getChannel(), builder);
                    
                    break;
                }
                case "tec9": {
                    builder.withTitle("CS:GO Weapon");
                    builder.appendField("Name", "Tec-9", true);
                    builder.appendField("Price", "$500", true);
                    builder.appendField("Kill Award", "$300", true);
                    builder.appendField("Damage", "33", true);
                    builder.appendField("Armor Penetration", "90.60%", true);
                    builder.appendField("Firerate", "500.00", true);
                    builder.withFooterText("ShrokBot (c) 2018");
                    sendEmbed(event.getChannel(), builder);
                    
                    break;
                }
                case "cz75auto": {
                    builder.withTitle("CS:GO Weapon");
                    builder.appendField("Name", "CZ75 Auto", true);
                    builder.appendField("Price", "$500", true);
                    builder.appendField("Kill Award", "$300", true);
                    builder.appendField("Damage", "33", true);
                    builder.appendField("Armor Penetration", "77.65%", true);
                    builder.appendField("Firerate", "600.00", true);
                    builder.withFooterText("ShrokBot (c) 2018");
                    sendEmbed(event.getChannel(), builder);
                    
                    break;
                }
                case "p250": {
                    builder.withTitle("CS:GO Weapon");
                    builder.appendField("Name", "P250", true);
                    builder.appendField("Price", "$300", true);
                    builder.appendField("Kill Award", "$300", true);
                    builder.appendField("Damage", "38", true);
                    builder.appendField("Armor Penetration", "64.00%", true);
                    builder.appendField("Firerate", "400.00", true);
                    builder.withFooterText("ShrokBot (c) 2018");
                    sendEmbed(event.getChannel(), builder);
                    
                    break;
                }
                case "usps": {
                    builder.withTitle("CS:GO Weapon");
                    builder.appendField("Name", "USP-S", true);
                    builder.appendField("Price", "$200", true);
                    builder.appendField("Kill Award", "$300", true);
                    builder.appendField("Damage", "35", true);
                    builder.appendField("Armor Penetration", "50.50%", true);
                    builder.appendField("Firerate", "352.94", true);
                    builder.withFooterText("ShrokBot (c) 2018");
                    sendEmbed(event.getChannel(), builder);
                    
                    break;
                }
                case "p2000": {
                    builder.withTitle("CS:GO Weapon");
                    builder.appendField("Name", "p2000", true);
                    builder.appendField("Price", "$200", true);
                    builder.appendField("Kill Award", "$300", true);
                    builder.appendField("Damage", "35", true);
                    builder.appendField("Armor Penetration", "50.50%", true);
                    builder.appendField("Firerate", "352.94", true);
                    builder.withFooterText("ShrokBot (c) 2018");
                    sendEmbed(event.getChannel(), builder);
                    
                    break;
                }
                case "glock18": {
                    builder.withTitle("CS:GO Weapon");
                    builder.appendField("Name", "Glock-18", true);
                    builder.appendField("Price", "$200", true);
                    builder.appendField("Kill Award", "$300", true);
                    builder.appendField("Damage", "30", true);
                    builder.appendField("Armor Penetration", "47.00%", true);
                    builder.appendField("Firerate", "400.00", true);
                    builder.withFooterText("ShrokBot (c) 2018");
                    sendEmbed(event.getChannel(), builder);
                    
                    break;
                }
                case "fiveseven": {
                    builder.withTitle("CS:GO Weapon");
                    builder.appendField("Name", "Five-SeveN", true);
                    builder.appendField("Price", "$500", true);
                    builder.appendField("Kill Award", "$300", true);
                    builder.appendField("Damage", "32", true);
                    builder.appendField("Armor Penetration", "91.15%", true);
                    builder.appendField("Firerate", "400.00", true);
                    builder.withFooterText("ShrokBot (c) 2018");
                    sendEmbed(event.getChannel(), builder);
                    
                    break;
                }
                case "dualberettas": {
                    builder.withTitle("CS:GO Weapon");
                    builder.appendField("Name", "Dual Berettas", true);
                    builder.appendField("Price", "$400", true);
                    builder.appendField("Kill Award", "$300", true);
                    builder.appendField("Damage", "38", true);
                    builder.appendField("Armor Penetration", "57.50%", true);
                    builder.appendField("Firerate", "500.00", true);
                    builder.withFooterText("ShrokBot (c) 2018");
                    sendEmbed(event.getChannel(), builder);
                    
                    break;
                }
                case "r8revolver": {
                    builder.withTitle("CS:GO Weapon");
                    builder.appendField("Name", "R8 Revolver", true);
                    builder.appendField("Price", "$600", true);
                    builder.appendField("Kill Award", "$300", true);
                    builder.appendField("Damage", "86", true);
                    builder.appendField("Armor Penetration", "93.20%", true);
                    builder.appendField("Firerate", "120", true);
                    builder.appendField("Firerate (Rapid Fire)", "150", true);
                    builder.withFooterText("ShrokBot (c) 2018");
                    sendEmbed(event.getChannel(), builder);
                    
                    break;
                }
                case "deserteagle": {
                    builder.withTitle("CS:GO Weapon");
                    builder.appendField("Name", "Desert Eagle", true);
                    builder.appendField("Price", "$700", true);
                    builder.appendField("Kill Award", "$300", true);
                    builder.appendField("Damage", "63", true);
                    builder.appendField("Armor Penetration", "93.20%", true);
                    builder.appendField("Firerate", "266.67", true);
                    builder.withFooterText("ShrokBot (c) 2018");
                    sendEmbed(event.getChannel(), builder);
                    
                    break;
                }
                default: {
                    sendMessage(event.getChannel(), "Invalid Weapon Type!");
                }
            }
        }
    }
}
