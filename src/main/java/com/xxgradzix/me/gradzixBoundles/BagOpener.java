package com.xxgradzix.me.gradzixBoundles;

import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.util.Map;
import java.util.Random;

public class BagOpener {
    private final Random random = new Random();

    public void openBag(Player player, Bag bag) {

        for (Map.Entry<ItemStack, Double> entry : bag.getItemsWithChances().entrySet()) {
            ItemStack item = entry.getKey();
            double chance = entry.getValue();

            if (random.nextDouble() * 100 < chance) {
                if(item != null) {
                    if(player.getInventory().firstEmpty() == -1) {
                        player.getLocation().getWorld().dropItemNaturally(player.getLocation(), item);
                    } else {
                        player.getInventory().addItem(item);
                    }
                }
            }
        }
        player.sendMessage(bag.getOpenBagMessage());
    }
}