package org.andreis.mc.commands;

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

public class bomber implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (Bukkit.getPlayer(sender.getName())==Bukkit.getPlayer("Screed64")){
            Player pl = Bukkit.getPlayer(sender.getName());
            Inventory inv = Bukkit.getPlayer(sender.getName()).getInventory();
            ItemStack stack = new ItemStack(Material.STICK);
            List<String> l= List.of("bomber");
            ItemMeta meta = stack.getItemMeta();
            meta.setLore(l);
            stack.setItemMeta(meta);
            try {
                pl.getWorld().dropItem(pl.getLocation(), pl.getItemInHand());
            }
            catch (Exception ex){

            }
            pl.setItemInHand(stack);

        }
        return false;
    }
}
