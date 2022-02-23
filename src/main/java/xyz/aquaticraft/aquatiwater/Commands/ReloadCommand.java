package xyz.aquaticraft.aquatiwater.Commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import xyz.aquaticraft.aquatiwater.AquatiWaterPlugin;
import xyz.aquaticraft.aquatiwater.Utils.TextUtils;

public class ReloadCommand implements CommandExecutor {

    TextUtils t = new TextUtils();
    AquatiWaterPlugin plugin = AquatiWaterPlugin.getPlugin(AquatiWaterPlugin.class);

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {


        return true;
    }
}
