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

package de.jatitv.wonderbagshop.config;

import de.jatitv.wonderbagshop.defaultValue.DefaultValue;
import de.jatitv.wonderbagshop.system.Main;
import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;

public class Config{
    public static Integer ConfigVersion = 2;

    public static void configCreate() throws InterruptedException {
        Long long_ = Long.valueOf(System.currentTimeMillis());

        File configYML = new File(Main.thisp().getDataFolder().getPath(), "Config.yml");
        YamlConfiguration yamlConfiguration = YamlConfiguration.loadConfiguration(configYML);

        Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Config.yml load...");


        if (!yamlConfiguration.contains("Do_not_remove_or_change.Created")) {
            yamlConfiguration.set("Do_not_remove_or_change.Created", "This file was created with version " + Main.getPlugin().getDescription().getVersion());
        }

        yamlConfiguration.set("Do_not_remove_or_change.Version", Main.getPlugin().getDescription().getVersion());

        yamlConfiguration.set("Do_not_remove_or_change.Autor", Main.Autor);

        yamlConfiguration.set("Do_not_remove_or_change.Spigot", Main.Spigot);

        yamlConfiguration.set("Do_not_remove_or_change.Discord", Main.Discord);


        yamlConfiguration.set("ConfigVersion", ConfigVersion);


        if (yamlConfiguration.contains("Plugin.UpdateCheckOnJoin")) {
            DefaultValue.UpdateCheckOnJoin = yamlConfiguration.getBoolean("Plugin.UpdateCheckOnJoin");
        } else {
            yamlConfiguration.set("Plugin.UpdateCheckOnJoin", true);
            if (configYML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6UpdateCheckOnJoin §4was added to §9Config.yml§4!");
        }
        if (yamlConfiguration.contains("Plugin.language")) {
            DefaultValue.language = yamlConfiguration.getString("Plugin.language");
        } else {
            yamlConfiguration.set("Plugin.language", DefaultValue.language);
            if (configYML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6language §4was added to §9Config.yml§4!");
        }

        if (yamlConfiguration.contains("Plugin.Debug.Enable")) {
            DefaultValue.Debug = yamlConfiguration.getBoolean("Plugin.Debug.Enable");
        } else {
            yamlConfiguration.set("Plugin.Debug.Enable", false);
            if (configYML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Debug Enable §4was added to §9Config.yml§4!");
        }

        if (yamlConfiguration.contains("Plugin.Debug.DebugStage_(1-3)")) {
            DefaultValue.DebugStage = yamlConfiguration.getInt("Plugin.Debug.DebugStage_(1-3)");
        } else {
            yamlConfiguration.set("Plugin.Debug.DebugStage_(1-3)", 1);
            if (configYML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6DebugStage §4was added to §9Config.yml§4!");
        }
        if (yamlConfiguration.getInt("Plugin.Debug.DebugStage_(1-3)") > 3) {
            yamlConfiguration.set("Plugin.Debug.DebugStage_(1-3)", 3);
        }
        if (yamlConfiguration.getInt("Plugin.Debug.DebugStage_(1-3)") < 1) {
            yamlConfiguration.set("Plugin.Debug.DebugStage_(1-3)", 1);
        }

        if (yamlConfiguration.contains("Shop.GUI_Name")) {
            DefaultValue.GUI_Name = replace(yamlConfiguration.getString("Shop.GUI_Name"));
        } else {
            yamlConfiguration.set("Shop.GUI_Name", "&2Wonder&6Bag&9Shop");
            if (configYML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6ShopName_GUI §4was added to §9Config.yml§4!");
        }

        if (yamlConfiguration.contains("Shop.Currency")) {
            DefaultValue.Currency = yamlConfiguration.getString("Shop.Currency");
        } else {
            yamlConfiguration.set("Shop.Currency", "$");
            if (configYML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Currency §4was added to §9Config.yml§4!");
        }

        if (yamlConfiguration.contains("Shop.ItemNumbers")) {
            DefaultValue.ItemNumbers = yamlConfiguration.getBoolean("Shop.ItemNumbers");
        } else {
            yamlConfiguration.set("Shop.ItemNumbers", true);
            if (configYML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6ItemNumbers §4was added to §9Config.yml§4!");
        }

        if (yamlConfiguration.contains("WonderBags.UseChest")) {
            DefaultValue.UseChest = yamlConfiguration.getBoolean("WonderBags.UseChest");
        } else {
            yamlConfiguration.set("WonderBags.UseChest", true);
            if (configYML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6UseChest §4was added to §9Config.yml§4!");
        }

        if (yamlConfiguration.contains("WonderBags.UseChest_and_Item")) {
            DefaultValue.UseChest_and_Item = yamlConfiguration.getBoolean("WonderBags.UseChest_and_Item");
        } else {
            yamlConfiguration.set("WonderBags.UseChest_and_Item", true);
            if (configYML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6UseChest_and_Item §4was added to §9Config.yml§4!");
        }

        if (yamlConfiguration.contains("WonderBags.ChestDrop")) {
            DefaultValue.ChestDrop = yamlConfiguration.getBoolean("WonderBags.ChestDrop");
        } else {
            yamlConfiguration.set("WonderBags.ChestDrop", false);
            if (configYML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6ChestDrop §4was added to §9Config.yml§4!");
        }

        if (yamlConfiguration.contains("WonderBags.RemoveChestInCreativemode")) {
            DefaultValue.RemoveChestInCreativemode = yamlConfiguration.getBoolean("WonderBags.RemoveChestInCreativemode");
        } else {
            yamlConfiguration.set("WonderBags.RemoveChestInCreativemode", true);
            if (configYML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6RemoveChestInCreativemode §4was added to §9Config.yml§4!");
        }

        if (yamlConfiguration.contains("WonderBags.RemoveUseItemByUse")) {
            DefaultValue.RemoveUseItemByUse = yamlConfiguration.getBoolean("WonderBags.RemoveUseItemByUse");
        } else {
            yamlConfiguration.set("WonderBags.RemoveUseItemByUse", true);
            if (configYML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6RemoveUseItemByUse §4was added to §9Config.yml§4!");
        }

        /**
         *Sound
         */

        if (yamlConfiguration.contains("Sound.Enable")) {
            DefaultValue.Sound_Enable = yamlConfiguration.getBoolean("Sound.Enable");
        } else {
            yamlConfiguration.set("Sound.Enable", true);
            if (configYML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Sound Enable §4was added to §9Config.yml§4!");
        }

        if (yamlConfiguration.contains("Sound.Buy.Enable")) {
            DefaultValue.Sound_Shop_Buy_Enable = yamlConfiguration.getBoolean("Sound.Buy.Enable");
        } else {
            yamlConfiguration.set("Sound.Buy.Enable", true);
            if (configYML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Sound Buy Enable §4was added to §9Config.yml§4!");
        }
        if (yamlConfiguration.contains("Sound.Buy.Sound")) {
            DefaultValue.Sound_Shop_Buy_input = replace(yamlConfiguration.getString("Sound.Buy.Sound").toUpperCase().replace(".", "_"));
        } else {
            yamlConfiguration.set("Sound.Buy.Sound", "ENTITY_PLAYER_LEVELUP");
            if (configYML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Sound Buy §4was added to §9Config.yml§4!");
        }


        if (yamlConfiguration.contains("Sound.NoMoney.Enable")) {
            DefaultValue.Sound_Shop_NoMoney_Enable = yamlConfiguration.getBoolean("Sound.NoMoney.Enable");
        } else {
            yamlConfiguration.set("Sound.NoMoney.Enable", true);
            if (configYML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Sound NoMoney Enable §4was added to §9Config.yml§4!");
        }
        if (yamlConfiguration.contains("Sound.NoMoney.Sound")) {
            DefaultValue.Sound_Shop_NoMoney_input = replace(yamlConfiguration.getString("Sound.NoMoney.Sound").toUpperCase().replace(".", "_"));
        } else {
            yamlConfiguration.set("Sound.NoMoney.Sound", "BLOCK_NOTE_BLOCK_HARP");
            if (configYML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Sound NoMoney §4was added to §9Config.yml§4!");
        }


        if (yamlConfiguration.contains("Sound.NoInventorySpace.Enable")) {
            DefaultValue.Sound_Shop_NoInventorySpace_Enable = yamlConfiguration.getBoolean("Sound.NoInventorySpace.Enable");
        } else {
            yamlConfiguration.set("Sound.NoInventorySpace.Enable", true);
            if (configYML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Sound NoInventorySpace Enable §4was added to §9Config.yml§4!");
        }
        if (yamlConfiguration.contains("Sound.NoInventorySpace.Sound")) {
            DefaultValue.Sound_Shop_NoInventorySpace_input = replace(yamlConfiguration.getString("Sound.NoInventorySpace.Sound").toUpperCase().replace(".", "_"));
        } else {
            yamlConfiguration.set("Sound.NoInventorySpace.Sound", "BLOCK_NOTE_BLOCK_GUITAR");
            if (configYML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Sound NoInventorySpace §4was added to §9Config.yml§4!");
        }


        if (yamlConfiguration.contains("Sound.Give.Enable")) {
            DefaultValue.Sound_Give_Enable = yamlConfiguration.getBoolean("Sound.Give.Enable");
        } else {
            yamlConfiguration.set("Sound.Give.Enable", true);
            if (configYML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Sound Give Enable §4was added to §9Config.yml§4!");
        }
        if (yamlConfiguration.contains("Sound.Give.Sound")) {
            DefaultValue.Sound_Give_input = replace(yamlConfiguration.getString("Sound.Give.Sound").toUpperCase().replace(".", "_"));
        } else {
            yamlConfiguration.set("Sound.Give.Sound", "ENTITY_PLAYER_LEVELUP");
            if (configYML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Sound Give §4was added to §9Config.yml§4!");
        }


        if (yamlConfiguration.contains("Sound.Gift.Enable")) {
            DefaultValue.Sound_Gift_Enable = yamlConfiguration.getBoolean("Sound.Gift.Enable");
        } else {
            yamlConfiguration.set("Sound.Gift.Enable", true);
            if (configYML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Sound Gift Enable §4was added to §9Config.yml§4!");
        }
        if (yamlConfiguration.contains("Sound.Gift.Sound")) {
            DefaultValue.Sound_Gift_input = replace(yamlConfiguration.getString("Sound.Gift.Sound").toUpperCase().replace(".", "_"));
        } else {
            yamlConfiguration.set("Sound.Gift.Sound", "ENTITY_PLAYER_LEVELUP");
            if (configYML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Sound Gift §4was added to §9Config.yml§4!");
        }


        if (yamlConfiguration.contains("Sound.PlayerNotFound.Enable")) {
            DefaultValue.Sound_PlayerNotFound_Enable = yamlConfiguration.getBoolean("Sound.PlayerNotFound.Enable");
        } else {
            yamlConfiguration.set("Sound.PlayerNotFound.Enable", true);
            if (configYML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Sound PlayerNotFound Enable §4was added to §9Config.yml§4!");
        }
        if (yamlConfiguration.contains("Sound.PlayerNotFound.Sound")) {
            DefaultValue.Sound_PlayerNotFound_input = replace(yamlConfiguration.getString("Sound.PlayerNotFound.Sound").toUpperCase().replace(".", "_"));
        } else {
            yamlConfiguration.set("Sound.PlayerNotFound.Sound", "BLOCK_NOTE_BLOCK_HARP");
            if (configYML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Sound Send §4was added to §9Config.yml§4!");
        }

        /**
         * Title
         */

        if (yamlConfiguration.contains("Title.Enable")) {
            DefaultValue.Title_Enable = yamlConfiguration.getBoolean("Title.Enable");
        } else {
            yamlConfiguration.set("Title.Enable", true);
            if (configYML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Title Enable §4was added to §9Config.yml§4!");
        }

        if (yamlConfiguration.contains("Title.Reload.Enable")) {
            DefaultValue.Title_Reload_Enable = yamlConfiguration.getBoolean("Title.Reload.Enable");
        } else {
            yamlConfiguration.set("Title.Reload.Enable", true);
            if (configYML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Title Reload Enable §4was added to §9Config.yml§4!");
        }

        if (yamlConfiguration.contains("Title.Buy.Enable")) {
            DefaultValue.Title_Buy_Enable = yamlConfiguration.getBoolean("Title.Buy.Enable");
        } else {
            yamlConfiguration.set("Title.Buy.Enable", true);
            if (configYML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Title Buy Enable §4was added to §9Config.yml§4!");
        }

        if (yamlConfiguration.contains("Title.NoMoney.Enable")) {
            DefaultValue.Title_No_money_Enable = yamlConfiguration.getBoolean("Title.NoMoney.Enable");
        } else {
            yamlConfiguration.set("Title.NoMoney.Enable", true);
            if (configYML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Title NoM oney Enable §4was added to §9Config.yml§4!");
        }
        if (yamlConfiguration.contains("Title.NoInventorySpace.Enable")) {
            DefaultValue.Title_NoInventorySpace_Enable = yamlConfiguration.getBoolean("Title.NoInventorySpace.Enable");
        } else {
            yamlConfiguration.set("Title.NoInventorySpace.Enable", true);
            if (configYML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Title NoInventorySpace Enable §4was added to §9Config.yml§4!");
        }
        if (yamlConfiguration.contains("Title.Give.Enable")) {
            DefaultValue.Title_Give_Enable = yamlConfiguration.getBoolean("Title.Give.Enable");
        } else {
            yamlConfiguration.set("Title.Give.Enable", true);
            if (configYML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Title Give Enable §4was added to §9Config.yml§4!");
        }
        if (yamlConfiguration.contains("Title.GiveReceived.Enable")) {
            DefaultValue.Title_GiveReceived_Enable = yamlConfiguration.getBoolean("Title.GiveReceived.Enable");
        } else {
            yamlConfiguration.set("Title.GiveReceived.Enable", true);
            if (configYML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Title GiveReceived Enable §4was added to §9Config.yml§4!");
        }
        if (yamlConfiguration.contains("Title.Gift.Enable")) {
            DefaultValue.Title_Gift_Enable = yamlConfiguration.getBoolean("Title.Gift.Enable");
        } else {
            yamlConfiguration.set("Title.Gift.Enable", true);
            if (configYML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Title Gift Enable §4was added to §9Config.yml§4!");
        }
        if (yamlConfiguration.contains("Title.GiftReceived.Enable")) {
            DefaultValue.Title_GiftReceived_Enable = yamlConfiguration.getBoolean("Title.GiftReceived.Enable");
        } else {
            yamlConfiguration.set("Title.GiftReceived.Enable", true);
            if (configYML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Title GiftReceived Enable §4was added to §9Config.yml§4!");
        }
        if (yamlConfiguration.contains("Title.PlayerNoInventorySpace.Enable")) {
            DefaultValue.Title_PlayerNoInventorySpace_Enable = yamlConfiguration.getBoolean("Title.PlayerNoInventorySpace.Enable");
        } else {
            yamlConfiguration.set("Title.PlayerNoInventorySpace.Enable", true);
            if (configYML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Title PlayerNoInventorySpace Enable §4was added to §9Config.yml§4!");
        }
        if (yamlConfiguration.contains("Title.PlayerNotFound.Enable")) {
            DefaultValue.Title_PlayerNotFound_Enable = yamlConfiguration.getBoolean("Title.PlayerNotFound.Enable");
        } else {
            yamlConfiguration.set("Title.PlayerNotFound.Enable", true);
            if (configYML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Title PlayerNotFound Enable §4was added to §9Config.yml§4!");
        }

        try {
            yamlConfiguration.save(configYML);
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            Sound sound_Buy = Sound.valueOf(DefaultValue.Sound_Shop_Buy_input);
            if (sound_Buy != null) {
                DefaultValue.Sound_Shop_Buy = sound_Buy;
            }
        } catch (Exception e) {
            Bukkit.getConsoleSender().sendMessage("§4\n§4\n§4\n" + DefaultValue.SoundNotFound.replace("[prefix]", DefaultValue.Prefix)
                    .replace("[sound]", "§8Buy: §6" + DefaultValue.Sound_Shop_Buy_input) + "§4\n§4\n§4\n");
            DefaultValue.Sound_Shop_Buy = Sound.ENTITY_PLAYER_LEVELUP;
        }

        try {
            Sound sound_NoMoney = Sound.valueOf(DefaultValue.Sound_Shop_NoMoney_input);
            if (sound_NoMoney != null) {
                DefaultValue.Sound_Shop_NoMoney = sound_NoMoney;
            }
        } catch (Exception e) {
            Bukkit.getConsoleSender().sendMessage("§4\n§4\n§4\n" + DefaultValue.SoundNotFound.replace("[prefix]", DefaultValue.Prefix)
                    .replace("[sound]", "§8NoMoney: §6" + DefaultValue.Sound_Shop_NoMoney_input) + "§4\n§4\n§4\n");
            DefaultValue.Sound_Shop_NoMoney = Sound.BLOCK_NOTE_BLOCK_BASS;
        }

        try {
            Sound sound_NoInventorySpace = Sound.valueOf(DefaultValue.Sound_Shop_NoInventorySpace_input);
            if (sound_NoInventorySpace != null) {
                DefaultValue.Sound_Shop_NoInventorySpace = sound_NoInventorySpace;
            }
        } catch (Exception e) {
            Bukkit.getConsoleSender().sendMessage("§4\n§4\n§4\n" + DefaultValue.SoundNotFound.replace("[prefix]", DefaultValue.Prefix)
                    .replace("[sound]", "§8NoInventorySpace: §6" + DefaultValue.Sound_Shop_NoInventorySpace_input) + "§4\n§4\n§4\n");
            DefaultValue.Sound_Shop_NoInventorySpace = Sound.BLOCK_NOTE_BLOCK_GUITAR;
        }

        try {
            Sound sound_Give = Sound.valueOf(DefaultValue.Sound_Give_input);
            if (sound_Give != null) {
                DefaultValue.Sound_Give = sound_Give;
            }
        } catch (Exception e) {
            Bukkit.getConsoleSender().sendMessage("§4\n§4\n§4\n" + DefaultValue.SoundNotFound.replace("[prefix]", DefaultValue.Prefix)
                    .replace("[sound]", "§8Give: §6" + DefaultValue.Sound_Give_input) + "§4\n§4\n§4\n");
            DefaultValue.Sound_Give = Sound.ENTITY_PLAYER_LEVELUP;
        }

        try {
            Sound sound_Gift = Sound.valueOf(DefaultValue.Sound_Gift_input);
            if (sound_Gift != null) {
                DefaultValue.Sound_Gift = sound_Gift;
            }
        } catch (Exception e) {
            Bukkit.getConsoleSender().sendMessage("§4\n§4\n§4\n" + DefaultValue.SoundNotFound.replace("[prefix]", DefaultValue.Prefix)
                    .replace("[sound]", "§8Gift: §6" + DefaultValue.Sound_Gift_input) + "§4\n§4\n§4\n");
            DefaultValue.Sound_Gift = Sound.ENTITY_PLAYER_LEVELUP;
        }

        try {
            Sound sound_PlayerNotFound = Sound.valueOf(DefaultValue.Sound_PlayerNotFound_input);
            if (sound_PlayerNotFound != null) {
                DefaultValue.Sound_PlayerNotFound = sound_PlayerNotFound;
            }
        } catch (Exception e) {
            Bukkit.getConsoleSender().sendMessage("§4\n§4\n§4\n" + DefaultValue.SoundNotFound.replace("[prefix]", DefaultValue.Prefix)
                    .replace("[sound]", "§8PlayerNotFound: §6" + DefaultValue.Sound_PlayerNotFound_input) + "§4\n§4\n§4\n");
            DefaultValue.Sound_PlayerNotFound = Sound.ENTITY_PLAYER_LEVELUP;
        }

        Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§2Config.yml loaded successfully.");

    }

    public static void configDisable() {
        Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Config.yml successfully deactivated.");
    }

    private static String replace(String Text) {
        return Text.replace("&", "§").replace("%ue%", "ü").replace("%UE%", "Ü").replace("%oe%", "ö")
                .replace("%OE%", "Ö").replace("%ae%", "ä").replace("%AE%", "Ä");
    }
}