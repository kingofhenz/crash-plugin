package com.henry.servercrash;

import org.bukkit.ChatColor;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

public final class Servercrash extends JavaPlugin implements Listener {
    @Override
    public void onEnable() {
        // Plugin startup logic
        getServer().getPluginManager().registerEvents(this, this);
        getServer().getConsoleSender().sendMessage(ChatColor.DARK_RED + "[server-crasher]" + "ready to smash and crash");
        getCommand("crash").setExecutor(new Commanders());
    }
    @Override
    public void onDisable() {
        // Plugin shutdown logic
        System.out.println(ChatColor.DARK_GRAY + "[Inv-Manager]" + "bye");
    }
}