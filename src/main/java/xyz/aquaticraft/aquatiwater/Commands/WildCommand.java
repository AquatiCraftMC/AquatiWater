package xyz.aquaticraft.aquatiwater.Commands;

import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import xyz.aquaticraft.aquatiwater.AquatiWaterPlugin;
import xyz.aquaticraft.aquatiwater.Utils.MessageType;
import xyz.aquaticraft.aquatiwater.Utils.RandomLocation;
import xyz.aquaticraft.aquatiwater.Utils.TextUtils;

// ©️AquatiCraft 2021-2022

public class WildCommand implements CommandExecutor {

    AquatiWaterPlugin plugin = AquatiWaterPlugin.getPlugin(AquatiWaterPlugin.class);

    TextUtils t = new TextUtils();
    RandomLocation l = new RandomLocation(plugin);
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (!(sender instanceof Player)) {
            t.sendMessage(sender, MessageType.ONLYPLAYERS, true);
            return true;
        }
        Player p = (Player) sender;
        t.sendMessage(p, "&bFinding &3 random location&b...", true);
        Location rl = l.findSafeLocation();
        t.sendMessage(p, "&bLocation found! &3Teleporting...", true);
        p.teleport(rl);
        t.sendTitle(p, "&3⚔️", "&bTeleported to a random location!", 2, 2, 2);



        return true;
    }
}
