package com.xxgradzix.me.gradzixBoundles;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

public class BagListener implements Listener {
    private final BagManager bagManager;
    private final BagOpener bagOpener;

    public BagListener(BagManager bagManager, BagOpener bagOpener) {
        this.bagManager = bagManager;
        this.bagOpener = bagOpener;
    }

    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent event) {
        Player player = event.getPlayer();
        ItemStack item = event.getItem();

        if (item == null || item.getType() == Material.AIR) {
            return;
        }
        String bagID = bagManager.getBagID(item);

        Bag bag = bagManager.getBag(bagID);

        if( bag == null) return;

        bagOpener.openBag(player, bag);

        if (player.getInventory().getItemInHand().getAmount() == 1) {
            player.getInventory().setItemInHand(new ItemStack(Material.AIR));
        } else {
            player.getInventory().getItemInHand().setAmount(player.getInventory().getItemInHand().getAmount()-1);
        }
    }
}