package xyz.aquaticraft.aquatiwater.Commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import xyz.aquaticraft.aquatiwater.AquatiWaterPlugin;
import xyz.aquaticraft.aquatiwater.Utils.MessageType;
import xyz.aquaticraft.aquatiwater.Utils.TextUtils;

public class StoreCommand implements CommandExecutor {
    TextUtils t = new TextUtils();

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) {
            t.sendMessage(sender, MessageType.ONLYPLAYERS, true);
            return true;
        }
        Player p = (Player) sender;
        t.sendMessage(p, "&bIf you are interested in supporting this custom coded server, you can purchase ranks and other items at our store: &3&nhttps://www.aquaticraft.xyz", true);



        return true;
    }
}
