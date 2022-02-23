package xyz.aquaticraft.aquatiwater.Commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import xyz.aquaticraft.aquatiwater.AquatiWaterPlugin;
import xyz.aquaticraft.aquatiwater.Utils.MessageType;
import xyz.aquaticraft.aquatiwater.Utils.TextUtils;

public class GamemodeCommand implements CommandExecutor {



    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage("a");
            return true;
        }
        Player p = (Player) sender;
        if (!(args.length <= 1)) {
            p.sendMessage("a");
        }


        return true;
    }
}
