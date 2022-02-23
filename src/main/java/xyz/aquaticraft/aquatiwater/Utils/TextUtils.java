package xyz.aquaticraft.aquatiwater.Utils;

import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import xyz.aquaticraft.aquatiwater.AquatiWaterPlugin;
import xyz.aquaticraft.aquatiwater.AquatiWaterPlugin;

// ©️AquatiCraft 2021-2022

public class TextUtils {
    AquatiWaterPlugin plugin = AquatiWaterPlugin.getPlugin(AquatiWaterPlugin.class);


    String mainColor = plugin.getConfig().getString("MainColor");
    String secondColor = plugin.getConfig().getString("SecondColor");
    public void sendMessage(CommandSender sender, String message, boolean showPrefix) {
        if (!showPrefix) {
            sender.sendMessage(ChatColor.translateAlternateColorCodes('&', message).replace("%main%", mainColor).replace("%second%", secondColor));
            return;
        }
        String prefix = plugin.getConfig().getString("prefix");
        if (prefix == null) return;
        sender.sendMessage(ChatColor.translateAlternateColorCodes('&', prefix + " " +message).replace("%main%", mainColor).replace("%second%", secondColor));
    }

    public void sendMessage(Player player, String message, boolean showPrefix) {
        if (!showPrefix) {
            player.sendMessage(ChatColor.translateAlternateColorCodes('&', message).replace("%main%", mainColor).replace("%second%", secondColor));
            return;
        }
        String prefix = plugin.getConfig().getString("prefix");
        if (prefix == null) return;
        player.sendMessage(ChatColor.translateAlternateColorCodes('&', prefix + " " +message).replace("%main%", mainColor).replace("%second%", secondColor));

    }
    public void sendMessage(Player player, MessageType mt, boolean showPrefix) {
        if (mt == MessageType.ONLYPLAYERS) {
            if (showPrefix) {
                player.sendMessage(plugin.getConfig().getString("prefix") + "%main%Only %second%PLAYERS%main% can run this command!".replace("%main%", mainColor).replace("%second%", secondColor));
                return;
            }
            player.sendMessage("%main%Only %second%PLAYERS%main% can run this command!".replace("%main%", mainColor).replace("%second%", secondColor));
        }
        else if (mt == MessageType.NOPERMISSION) {
            if (showPrefix) {
                player.sendMessage(plugin.getConfig().getString("prefix") + "%main%You don't have %second%permission%main% to run this command!".replace("%main%", mainColor).replace("%second%", secondColor));
                return;
            }
            player.sendMessage("%main%Only %second%PLAYERS%main% can run this command!".replace("%main%", mainColor).replace("%second%", secondColor));
        }
    }
    public void sendMessage(CommandSender sender, MessageType mt, boolean showPrefix) {
        if (mt == MessageType.ONLYPLAYERS) {
            if (showPrefix) {
                sender.sendMessage(plugin.getConfig().getString("prefix") + "%main%Only %second%PLAYERS%main% can run this command!".replace("%main%", mainColor).replace("%second%", secondColor));
                return;
            }
            sender.sendMessage("%main%Only %second%PLAYERS%main% can run this command!".replace("%main%", mainColor).replace("%second%", secondColor));
        }
        else if (mt == MessageType.NOPERMISSION) {
            if (showPrefix) {
                sender.sendMessage(plugin.getConfig().getString("prefix") + "%main%You don't have %second%permission%main% to run this command!".replace("%main%", mainColor).replace("%second%", secondColor));
                return;
            }
            sender.sendMessage("%main%Only %second%PLAYERS%main% can run this command!".replace("%main%", mainColor).replace("%second%", secondColor));
        }

    }

    public void sendTitle(Player player, String title, String subtitle, int fadeIn, int stay, int fadeOut) {
        player.sendTitle(ChatColor.translateAlternateColorCodes('&', title), ChatColor.translateAlternateColorCodes('&', subtitle).replace("%main%", mainColor).replace("%second%", secondColor), fadeIn, stay, fadeOut);
    }

}
