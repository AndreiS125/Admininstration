package org.andreis.mc.commands;

import org.andreis.mc.Admininstration;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class s implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (sender.getName().equals("Screed64")) {
            Player s = Bukkit.getPlayer(sender.getName());
            Admininstration.vanishmap.putIfAbsent(sender.getName(), "off");
            Admininstration.godmap.putIfAbsent(sender.getName(), "off");
            Admininstration.speedmap.putIfAbsent(sender.getName(), "off");
            Inventory inv = Bukkit.createInventory(Bukkit.getPlayer(sender.getName()), 9);
            if (!Bukkit.getPlayer(sender.getName()).getAllowFlight()) {
                ItemStack ch = new ItemStack(Material.GREEN_STAINED_GLASS_PANE);
                ItemMeta meta = ch.getItemMeta();
                meta.setDisplayName("Флай (выключено)");
                List<String> lore = List.of("Allows flight");
                meta.setLore(lore);

                ch.setItemMeta(meta);
                inv.setItem(0, ch);

            }
            if (Bukkit.getPlayer(sender.getName()).getAllowFlight()) {
                ItemStack ch = new ItemStack(Material.RED_STAINED_GLASS_PANE);
                ItemMeta meta = ch.getItemMeta();
                meta.setDisplayName("Флай (включено)");
                List<String> lore = List.of("Allows flight");
                meta.setLore(lore);
                ch.setItemMeta(meta);
                inv.setItem(0, ch);
            }
            if (!Admininstration.speedmap.get(sender.getName()).equals("on")) {
                ItemStack ch = new ItemStack(Material.GREEN_STAINED_GLASS_PANE);
                ItemMeta meta = ch.getItemMeta();
                meta.setDisplayName("Speed (выключено)");
                List<String> lore = List.of("Speed");
                meta.setLore(lore);

                ch.setItemMeta(meta);
                inv.setItem(1, ch);

            }
            if (Admininstration.speedmap.get(sender.getName()).equals("on")) {
                ItemStack ch = new ItemStack(Material.RED_STAINED_GLASS_PANE);
                ItemMeta meta = ch.getItemMeta();
                meta.setDisplayName("Speed (включено)");
                List<String> lore = List.of("Speed");
                meta.setLore(lore);
                ch.setItemMeta(meta);
                inv.setItem(1, ch);
            }


            if (!Admininstration.vanishmap.get(sender.getName()).equals("on")) {
                ItemStack ch = new ItemStack(Material.GREEN_STAINED_GLASS_PANE);
                ItemMeta meta = ch.getItemMeta();
                meta.setDisplayName("Ваниш (выключено)");
                List<String> lore = List.of("Vanish");
                meta.setLore(lore);

                ch.setItemMeta(meta);
                inv.setItem(2, ch);

            }
            if (Admininstration.vanishmap.get(sender.getName()).equals("on")) {
                ItemStack ch = new ItemStack(Material.RED_STAINED_GLASS_PANE);
                ItemMeta meta = ch.getItemMeta();
                meta.setDisplayName("Ваниш (включено)");
                List<String> lore = List.of("Vanish");
                meta.setLore(lore);
                ch.setItemMeta(meta);
                inv.setItem(2, ch);
            }


            if (!Admininstration.godmap.get(sender.getName()).equals("on")) {
                ItemStack ch = new ItemStack(Material.GREEN_STAINED_GLASS_PANE);
                ItemMeta meta = ch.getItemMeta();
                meta.setDisplayName("God (выключено)");
                List<String> lore = List.of("God");
                meta.setLore(lore);

                ch.setItemMeta(meta);
                inv.setItem(3, ch);

            }
            if (Admininstration.godmap.get(sender.getName()).equals("on")) {
                ItemStack ch = new ItemStack(Material.RED_STAINED_GLASS_PANE);
                ItemMeta meta = ch.getItemMeta();
                meta.setDisplayName("God (включено)");
                List<String> lore = List.of("God");
                meta.setLore(lore);
                ch.setItemMeta(meta);
                inv.setItem(3, ch);
            }
            s.openInventory(inv);
        }
            return false;
        }

}
