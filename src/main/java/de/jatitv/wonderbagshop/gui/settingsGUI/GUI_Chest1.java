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

package de.jatitv.wonderbagshop.gui.settingsGUI;

import de.jatitv.wonderbagshop.defaultValue.wonderBags.chest.DefaultValueChest_1;
import de.jatitv.wonderbagshop.system.Main;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.io.File;
import java.util.ArrayList;

public class GUI_Chest1 {

    public static String GUI_Chest1_name;

    public static void openConfigChest1(Player player) {
        if (Main.minecraft1_13){
            GUI_Chest1_name= "WBS | Settings | WBChest: small";
        } else {
            GUI_Chest1_name= "§2W§6B§9S §7| §4Settings §7| §2W§6B§7§9Chest: §9small";
        }
        Inventory inventory = Bukkit.createInventory((InventoryHolder) null, 9 * 3, GUI_Chest1_name);
        File WB1ChestYML = new File(Bukkit.getServer().getPluginManager().getPlugin("WonderBagShop").getDataFolder() + "/WonderBags/Chest/" + "small.yml");
        YamlConfiguration yamlConfiguration_WB1_Chest = YamlConfiguration.loadConfiguration(WB1ChestYML);
        ItemStack glass = new ItemStack(Material.BLACK_STAINED_GLASS_PANE);
        ItemMeta itemMetaglass = glass.getItemMeta();
        itemMetaglass.setDisplayName(" ");
        glass.setItemMeta(itemMetaglass);
        glass.setAmount(1);
        for (int i = 0; i < 9 * 3; i++) {
            inventory.setItem(i, glass);
        }


        ItemStack Name = new ItemStack(Material.YELLOW_WOOL);
        ItemMeta itemMetaName = Name.getItemMeta();
        itemMetaName.setDisplayName("§6Shop Name");
        ArrayList<String> loreName = new ArrayList<>();
        loreName.add("§8-------------");
        loreName.add("§7Set the §6Shop Name");
        loreName.add("§8-------------");
        loreName.add("§2Current:");
        loreName.add(DefaultValueChest_1.Name);
        itemMetaName.setLore(loreName);
        Name.setItemMeta(itemMetaName);
        Name.setAmount(1);
        inventory.setItem(2, Name);

        ItemStack Price = new ItemStack(Material.BLUE_WOOL);
        ItemMeta itemMetaPrice = Price.getItemMeta();
        itemMetaPrice.setDisplayName("§6Shop Price");
        ArrayList<String> lorePrice = new ArrayList<>();
        lorePrice.add("§8-------------");
        lorePrice.add("§2Current:");
        lorePrice.add(String.valueOf(yamlConfiguration_WB1_Chest.getInt("Shop.price")));
        lorePrice.add("§7Set the §6Shop Price");
        lorePrice.add("§2Right click to increase");
        lorePrice.add("§2Left click to decrease");
        lorePrice.add("§7With shift in steps of 10");
        itemMetaPrice.setLore(lorePrice);
        Price.setItemMeta(itemMetaPrice);
        Price.setAmount(1);
        inventory.setItem(3, Price);

        ItemStack DisplayName = new ItemStack(Material.YELLOW_WOOL);
        ItemMeta itemMetaDisplayName = DisplayName.getItemMeta();
        itemMetaDisplayName.setDisplayName("§6WonderBag DisplayName");
        ArrayList<String> loreDisplayName = new ArrayList<>();
        loreDisplayName.add("§8-------------");
        loreDisplayName.add("§7Set the §6WonderBag DisplayName");
        loreDisplayName.add("§8-------------");
        loreDisplayName.add("§2Current:");
        loreDisplayName.add(DefaultValueChest_1.DisplayName);
        itemMetaDisplayName.setLore(loreDisplayName);
        DisplayName.setItemMeta(itemMetaDisplayName);
        DisplayName.setAmount(1);
        inventory.setItem(5, DisplayName);

        ItemStack Item_amount = new ItemStack(Material.BLUE_WOOL);
        ItemMeta itemMetaItem_amount = Item_amount.getItemMeta();
        itemMetaItem_amount.setDisplayName("§6WonderBag Item_amount");
        ArrayList<String> loreItem_amount = new ArrayList<>();
        loreItem_amount.add("§8-------------");
        loreItem_amount.add("§7Set the §6Shop Item_amount");
        loreItem_amount.add("§2Right click to increase");
        loreItem_amount.add("§2Left click to decrease");
        itemMetaItem_amount.setLore(loreItem_amount);
        Item_amount.setItemMeta(itemMetaItem_amount);
        Item_amount.setAmount(yamlConfiguration_WB1_Chest.getInt("WonderBag.Item_amount_(1-9)"));
        inventory.setItem(6, Item_amount);

        if (Main.minecraft1_13) {
            ItemStack item2 = new ItemStack(Material.JUKEBOX);
            ItemMeta itemMeta2 = item2.getItemMeta();
            itemMeta2.setDisplayName("§6Settings");
            ArrayList<String> lore2 = new ArrayList<>();
            lore2.add("§8-------------");
            lore2.add("§7Back to §6Settings");
            itemMeta2.setLore(lore2);
            item2.setItemMeta(itemMeta2);
            item2.setAmount(1);
            inventory.setItem(22, item2);
        }else {
            ItemStack item2 = new ItemStack(Material.valueOf("LOOM") );
            ItemMeta itemMeta2 = item2.getItemMeta();
            itemMeta2.setDisplayName("§6Settings");
            ArrayList<String> lore2 = new ArrayList<>();
            lore2.add("§8-------------");
            lore2.add("§7Back to §6Settings");
            itemMeta2.setLore(lore2);
            item2.setItemMeta(itemMeta2);
            item2.setAmount(1);
            inventory.setItem(22, item2);
        }
/*
        ItemStack back = new ItemStack(Material.PLAYER_HEAD);
        SkullMeta itemMetaback = (SkullMeta) back.getItemMeta();
        itemMetaback.setDisplayName("§6Back");
        ArrayList<String> loreback = new ArrayList<>();
        loreback.add("§8-------------");
        loreback.add("§4Switch to the back");
        itemMetaback.setLore(loreback);
        itemMetaback.setOwner("MHF_ArrowLeft");
        back.setItemMeta(itemMetaback);
        back.setAmount(1);
        inventory.setItem(18, back);

        ItemStack next = new ItemStack(Material.PLAYER_HEAD);
        SkullMeta itemMetanext = (SkullMeta) next.getItemMeta();
        itemMetanext.setDisplayName("§6Next");
        ArrayList<String> lorenext = new ArrayList<>();
        lorenext.add("§8-------------");
        lorenext.add("§4Switch to the next");
        itemMetanext.setLore(lorenext);
        itemMetanext.setOwner("MHF_ArrowRight");
        next.setItemMeta(itemMetanext);
        next.setAmount(1);
        inventory.setItem(26, next);
 */

        player.openInventory(inventory);
    }
}