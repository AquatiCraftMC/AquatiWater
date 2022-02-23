package xyz.aquaticraft.aquatiwater.Commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import xyz.aquaticraft.aquatiwater.AquatiWaterPlugin;
import xyz.aquaticraft.aquatiwater.Utils.MessageType;
import xyz.aquaticraft.aquatiwater.Utils.TextUtils;

public class BedrockCommand implements CommandExecutor {
    TextUtils t = new TextUtils();


    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) {
            t.sendMessage(sender, MessageType.ONLYPLAYERS, true);
            return true;
        }
        t.sendMessage(sender, "&bOur server also supports the &3&lBEDROCK EDITION&b version of the game.", true);
        t.sendMessage(sender, "&bIf you want to &3connect&b and play cross play, read the info below!", true);
        t.sendMessage(sender, "&f", false);
        t.sendMessage(sender, "&bIP: &fplay.aquaticraft.xyz", true);
        t.sendMessage(sender, "&bPORT: &f25565", true);
        return true;
    }
}
