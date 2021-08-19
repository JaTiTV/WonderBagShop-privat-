// This claas was created by JaTiTV

// ___________________________________________________________________________________
//  __          __             _           ____               _____ _
//  \ \        / /            | |         |  _ \             / ____| |
//   \ \  /\  / /__  _ __   __| | ___ _ __| |_) | __ _  __ _| (___ | |__   ___  _ __
//    \ \/  \/ / _ \| '_ \ / _` |/ _ \ '__|  _ < / _` |/ _` |\___ \| '_ \ / _ \| '_ \
//     \  /\  / (_) | | | | (_| |  __/ |  | |_) | (_| | (_| |____) | | | | (_) | |_) |
//      \/  \/ \___/|_| |_|\__,_|\___|_|  |____/ \__,_|\__, |_____/|_| |_|\___/| .__/
//                                                      __/ |                  | |
//                                                     |___/                   |_|
// ___________________________________________________________________________________

package de.jatitv.wonderbagshop.system;

import de.jatitv.wonderbagshop.commands.cmdManagement.TabComplete;
import de.jatitv.wonderbagshop.defaultValue.DefaultValue;
import de.jatitv.wonderbagshop.listeners.*;
import de.jatitv.wonderbagshop.commands.cmdManagement.CmdExecuter;
import de.jatitv.wonderbagshop.listeners.settingsGUI.*;
import de.jatitv.wonderbagshop.listeners.useWonderBag.chest.UseChestWB1;
import de.jatitv.wonderbagshop.listeners.useWonderBag.chest.UseChestWB2;
import de.jatitv.wonderbagshop.listeners.useWonderBag.chest.UseChestWB3;
import de.jatitv.wonderbagshop.listeners.useWonderBag.item.UseItemWB1;
import de.jatitv.wonderbagshop.listeners.useWonderBag.item.UseItemWB2;
import de.jatitv.wonderbagshop.listeners.useWonderBag.item.UseItemWB3;
import net.milkbowl.vault.economy.Economy;
import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;

import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;


import java.util.List;
import java.util.logging.Logger;

public final class Main extends JavaPlugin {

    // Debug Settings


    public static String Prefix = "§8[§2Wonder§6Bag§9Shop§8]";

    public static String Version;

    public static List<String> Autor;
    public static Integer SpigotID = 89234;
    public static Integer BstatsID = 10342;
    public static String Spigot = "https://www.spigotmc.org/resources/" + SpigotID;
    public static String Discord = "http://dc.t2code.net";


    public static Boolean Bstats = true;

    public static Boolean Snapshot = false;

    // ---------------------------------------------

    public static Main plugin;
    public static Plugin a;
    public static Economy eco = null;
    public static String update_version = null;
    public static boolean minecraft1_8;
    public static boolean minecraft1_9;
    public static boolean minecraft1_10;
    public static boolean minecraft1_11;
    public static boolean minecraft1_12;
    public static boolean minecraft1_13;
    public static boolean minecraft1_14;
    public static boolean minecraft1_15;
    public static boolean minecraft1_16;

    public static Main getPlugin() {
        return plugin;
    }

    @Override
    public void onEnable() {
        // Plugin startup logic
        Logger logger = this.getLogger();

        plugin = this;
        a = this;
        Autor = plugin.getDescription().getAuthors();
        Version = plugin.getDescription().getVersion();

        minecraft1_8 = Bukkit.getServer().getClass().getPackage().getName().contains("1_8");
        minecraft1_9 = Bukkit.getServer().getClass().getPackage().getName().contains("1_9");
        minecraft1_10 = Bukkit.getServer().getClass().getPackage().getName().contains("1_10");
        minecraft1_11 = Bukkit.getServer().getClass().getPackage().getName().contains("1_11");
        minecraft1_12 = Bukkit.getServer().getClass().getPackage().getName().contains("1_12");
        minecraft1_13 = Bukkit.getServer().getClass().getPackage().getName().contains("1_13");
        minecraft1_14 = Bukkit.getServer().getClass().getPackage().getName().contains("1_14");
        minecraft1_15 = Bukkit.getServer().getClass().getPackage().getName().contains("1_15");
        minecraft1_16 = Bukkit.getServer().getClass().getPackage().getName().contains("1_16");

        if (minecraft1_8 | minecraft1_9 | minecraft1_10 | minecraft1_11 | minecraft1_12) {
            NotSupportedVersion.notSupportedVersion(getDescription().getVersion());
            Bukkit.getServer().getPluginManager().disablePlugin(this);
            return;
        }
        try {
            Load.LoadSend(Prefix, Autor, Version, Spigot, Discord);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        getCommand("wonderbagshop").setExecutor(new CmdExecuter());
        getCommand("wonderbagshop").setTabCompleter(new TabComplete());


        Bukkit.getServer().getPluginManager().registerEvents(new JoinEvent(), this);

        Bukkit.getServer().getPluginManager().registerEvents(new ShopEvent(), this);
        Bukkit.getServer().getPluginManager().registerEvents(new GiftEvent(), this);
        Bukkit.getServer().getPluginManager().registerEvents(new GiveEvent(), this);
        Bukkit.getServer().getPluginManager().registerEvents(new GiveAllEvent(), this);

        Bukkit.getServer().getPluginManager().registerEvents(new UseChestWB1(), this);
        Bukkit.getServer().getPluginManager().registerEvents(new UseChestWB2(), this);
        Bukkit.getServer().getPluginManager().registerEvents(new UseChestWB3(), this);
        Bukkit.getServer().getPluginManager().registerEvents(new BreakChest(), this);

        Bukkit.getServer().getPluginManager().registerEvents(new UseItemWB1(), this);
        Bukkit.getServer().getPluginManager().registerEvents(new UseItemWB2(), this);
        Bukkit.getServer().getPluginManager().registerEvents(new UseItemWB3(), this);

        Bukkit.getServer().getPluginManager().registerEvents(new GUI_Settings_Listener(), this);
        Bukkit.getServer().getPluginManager().registerEvents(new GUI_Config_Listener(), this);

        Bukkit.getServer().getPluginManager().registerEvents(new GUI_Chest1_Listener(), this);
        Bukkit.getServer().getPluginManager().registerEvents(new GUI_Chest2_Listener(), this);
        Bukkit.getServer().getPluginManager().registerEvents(new GUI_Chest3_Listener(), this);

        Bukkit.getServer().getPluginManager().registerEvents(new GUI_Item1_Listener(), this);
        Bukkit.getServer().getPluginManager().registerEvents(new GUI_Item2_Listener(), this);
        Bukkit.getServer().getPluginManager().registerEvents(new GUI_Item3_Listener(), this);

        Bukkit.getServer().getPluginManager().registerEvents(new GUI_ConfigSound_Listener(), this);
        Bukkit.getServer().getPluginManager().registerEvents(new GUI_ConfigTitle_Listener(), this);
        Bukkit.getServer().getPluginManager().registerEvents(new GUI_Chat_Listener(), this);


        if (Main.Bstats) {
            int pluginId = BstatsID; // <-- Replace with the id of your plugin!
            Metrics metrics = new Metrics(this, pluginId);
            metrics.addCustomChart(new Metrics.SimplePie("updatecheckonjoin", () -> String.valueOf(DefaultValue.UpdateCheckOnJoin)));
            metrics.addCustomChart(new Metrics.SimplePie("itemnumbers", () -> String.valueOf(DefaultValue.ItemNumbers)));
            metrics.addCustomChart(new Metrics.SimplePie("usechest", () -> String.valueOf(DefaultValue.UseChest)));
            metrics.addCustomChart(new Metrics.SimplePie("usechest_and_item", () -> String.valueOf(DefaultValue.UseChest_and_Item)));
            metrics.addCustomChart(new Metrics.SimplePie("chestdrop", () -> String.valueOf(DefaultValue.ChestDrop)));
            metrics.addCustomChart(new Metrics.SimplePie("sound_shop_buy_enable", () -> String.valueOf(DefaultValue.Sound_Shop_Buy_Enable)));
            metrics.addCustomChart(new Metrics.SimplePie("sound_shop_nomoney_enable", () -> String.valueOf(DefaultValue.Sound_Shop_NoMoney_Enable)));
            metrics.addCustomChart(new Metrics.SimplePie("sound_shop_noinventoryspace_enable", () -> String.valueOf(DefaultValue.Sound_Shop_NoInventorySpace_Enable)));
            metrics.addCustomChart(new Metrics.SimplePie("sound_give_enable", () -> String.valueOf(DefaultValue.Sound_Give_Enable)));
            metrics.addCustomChart(new Metrics.SimplePie("sound_gift_enable", () -> String.valueOf(DefaultValue.Sound_Gift_Enable)));
            metrics.addCustomChart(new Metrics.SimplePie("sound_playernotfound_enable", () -> String.valueOf(DefaultValue.Sound_PlayerNotFound_Enable)));
        } else {
            new BukkitRunnable() {
                @Override
                public void run() {
                    Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + " ");
                    Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + " ");
                    Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + " ");
                    Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + " ");
                    Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4\n" + DefaultValue.PrefixHC + "§4Bstats is disabled!");
                    Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + " ");
                    Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + " ");
                    Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + " ");
                    Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + " ");
                }
            }.runTaskLater(Main.getPlugin(), 200L);
        }


        // Optional: Add custom charts
        // metrics.addCustomChart(new Metrics.SimplePie("chart_id", () -> "My value"));

    }

    public static Plugin thisp() {
        return plugin;
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        send.console(Main.Prefix + "§4============================= §8[§2Wonder§6Bag§9Shop§8] §4=============================");
        send.console(Prefix + " §2Autor: §6" + String.valueOf(Autor).replace("[", "").replace("]", "") );
        send.console(Prefix + " §2Version: §6" + Version);
        send.console(Prefix + " §2Spigot: §6" + Spigot);
        send.console(Prefix + " §2Discord: §6" + Discord);
        send.console(Main.Prefix + " §4Plugin successfully disabled.");
        send.console(Main.Prefix + "§4========================================================================");
    }
}