package com.henry.servercrash;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import java.util.Random;


public class Commanders implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender,Command cmd,String label,  String[] args) {
//lets anyone crash the server with a random error message and a random error code
        if (cmd.getName().equalsIgnoreCase("crash")) {
            if (sender instanceof Player) {
                Player p = (Player) sender;
                Random r = new Random();
                int i = r.nextInt(100);
                Bukkit.getServer().getConsoleSender().sendMessage(ChatColor.DARK_RED + "[server-crasher]" + "crashed with error code " + i);
                String randomString = "";
                for (int j = 0; j < r.nextInt(100); j++) {
                    randomString += (char) (r.nextInt(26) + 97);
                }
                Bukkit.getServer().getConsoleSender().sendMessage(ChatColor.DARK_RED + "[server-crasher]" + "crashed with error code " + i + " and with the error " + randomString);


                Bukkit.getServer().getPluginManager().disablePlugin(Bukkit.getServer().getPluginManager().getPlugin("Servercrash"));
                Bukkit.getServer().getPluginManager().enablePlugin(Bukkit.getServer().getPluginManager().getPlugin("Servercrash"));
            }
        }
        return true;
    }
}