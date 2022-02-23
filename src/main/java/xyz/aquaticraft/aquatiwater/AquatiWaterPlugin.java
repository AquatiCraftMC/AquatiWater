package xyz.aquaticraft.aquatiwater;

import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;
import xyz.aquaticraft.aquatiwater.Commands.*;
import xyz.aquaticraft.aquatiwater.Listeners.PlayerConnect;
import xyz.aquaticraft.aquatiwater.Utils.ServerType;
import xyz.aquaticraft.aquatiwater.Utils.TextUtils;

// ©️AquatiCraft 2021-2022

public class AquatiWaterPlugin extends JavaPlugin {

    ServerType serverType = null;
    //private TextUtils t = new TextUtils(this);

    //public TextUtils getT() {
    //    return t;
    //}

    public static Plugin instance;
    @Override
    public void onEnable() {
        // Plugin startup logic
        saveDefaultConfig();
        instance = this;
        if (getConfig().getString("ServerType") == null) {
            Bukkit.getLogger().severe("Please set ServerType in config.yml to a valid option.");
            getServer().getPluginManager().disablePlugin(this);
        }
        else if (getConfig().getString("ServerType").equalsIgnoreCase("lobby")) {
            serverType = ServerType.Lobby;
            System.out.println("Server registered as a lobby server.");
        }
        else if (getConfig().getString("ServerType").equalsIgnoreCase("SMP")) {
            serverType = ServerType.SMP;
            System.out.println("Registering /wild...");
            getCommand("wild").setExecutor(new WildCommand());
            System.out.println("Registered!");
        }
        else {
            Bukkit.getLogger().severe("Please set ServerType in config.yml to a valid option.");
            getServer().getPluginManager().disablePlugin(this);
        }

        System.out.println("Registering /bedrock...");
        getCommand("bedrock").setExecutor(new BedrockCommand());
        System.out.println("Registered!");
        System.out.println("Registering /store...");
        getCommand("store").setExecutor(new StoreCommand());
        System.out.println("Registered!");
        System.out.println("Registering PlayerConnect listener...");
        getServer().getPluginManager().registerEvents(new PlayerConnect(), this);
        getServer().getMessenger().registerOutgoingPluginChannel(this, "BungeeCord");


    }

   // public void sendPlayerToServer(Player p, String serverName) {
   //     try {
     //       ByteArrayDataOutput out = ByteStreams.newDataOutput();
     //       out.writeUTF("Connect");
     //       out.writeUTF("server");
      //      p.sendPluginMessage(this, "BungeeCord", out.toByteArray());
      //  }
     //   catch (Exception e) {
     //       getT().sendMessage(p, "%second%Error%main% connecting to%second% " + serverName + "%main%!", true);
      //      getT().sendMessage(p, "%main%Make sure you entered the name correctly!", true);
      //      ByteArrayDataOutput out = ByteStreams.newDataOutput();
      //      out.writeUTF("GetServers");
      //      ByteArrayOutputStream b = new ByteArrayOutputStream();
      //      ByteArrayDataInput in = ByteStreams.newDataInput(b.toByteArray());
      //      String[] serverList = in.readUTF().split(", ");
      //      getT().sendMessage(p, "%main%Here is a list of our current servers:%second% " + serverList, true);
      //  }
    //}


    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

}
