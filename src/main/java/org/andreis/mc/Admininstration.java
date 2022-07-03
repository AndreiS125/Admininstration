package org.andreis.mc;


import org.andreis.mc.commands.*;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scoreboard.Team;
import org.jetbrains.annotations.NotNull;
import java.util.HashMap;


public final class Admininstration extends JavaPlugin {
    public static Admininstration instance;
    public static HashMap<String, String> vanishmap = new HashMap<>();
    public static HashMap<String, String> godmap = new HashMap<>();
    public static HashMap<String, String> speedmap = new HashMap<>();
    public static HashMap<String, String> mutemap = new HashMap<>();
    @Override
    public void onEnable() {
        instance = this;

        Bukkit.getPluginManager().registerEvents(new EventListener(), this);
        getCommand("become").setExecutor(new become());
        getCommand("sayfor").setExecutor(new sayfor());
        getCommand("mute").setExecutor(new mute());
        getCommand("unmute").setExecutor(new unmute());
        getCommand("invsee").setExecutor(new invsee());
        getCommand("seeall").setExecutor(new seeall());
        getCommand("tempban").setExecutor(new tempban());
        getCommand("gm").setExecutor(new gm());
        getCommand("vanish").setExecutor(new vanish());
        getCommand("disvanish").setExecutor(new disvanish());
        getCommand("zeus").setExecutor(new zeus());
        getCommand("bomber").setExecutor(new bomber());
        getCommand("god").setExecutor(new god());
        getCommand("s").setExecutor(new s());


        getCommand("sc").setExecutor(new CommandExecutor() {
            @Override
            public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
                if(args[0]!=null && Bukkit.getPlayer(sender.getName())==Bukkit.getPlayer("Screed64")){
                    Player pl = Bukkit.getPlayer(args[0]);
                    Player pl2 = Bukkit.getPlayer(sender.getName());
                    Bukkit.getEntity(pl2.getUniqueId()).addPassenger(pl);

                    //Villager king = (Villager)loc.getWorld().spawnEntity(loc, EntityType.VILLAGER);
                    //king.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 999999999, 10, true, false));
                    //king.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 999999999, 5, true, false));
                    //king.setCustomNameVisible(true);
                    //king.setCustomName("Король");
                    //king.setCollidable(false);
                    //king.setAI(false);
                    //king.resetMaxHealth();
                    //king.addPassenger(pl);














                }


                return false;
            }
        });



    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
