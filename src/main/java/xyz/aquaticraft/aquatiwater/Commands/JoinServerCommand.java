package xyz.aquaticraft.aquatiwater.Commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import xyz.aquaticraft.aquatiwater.AquatiWaterPlugin;
import xyz.aquaticraft.aquatiwater.Utils.MessageType;
import xyz.aquaticraft.aquatiwater.Utils.TextUtils;

public class JoinServerCommand implements CommandExecutor {
    TextUtils t = new TextUtils();

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) {
            t.sendMessage(sender, MessageType.ONLYPLAYERS, true);
            return true;
        }
        Player p = (Player) sender;
        if (!p.hasPermission("aquaticraft.joinserver")) {
            t.sendMessage(p, MessageType.NOPERMISSION, true);
            return true;
        }
        if (args.length != 1) {
            t.sendMessage(p, "%main%Incorrect syntax! Try this: %second%/joinserver (serverName)", true);
            return true;
        }
        //plugin.sendPlayerToServer(p, args[0]);
        return true;
    }
}
