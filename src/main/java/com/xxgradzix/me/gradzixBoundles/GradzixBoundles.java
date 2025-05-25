package com.xxgradzix.me.gradzixBoundles;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;

public final class GradzixBoundles extends JavaPlugin {

    @Override
    public void onEnable() {
        BagManager bagManager = new BagManager();
        BagOpener bagOpener = new BagOpener();

        getServer().getPluginManager().registerEvents(new BagListener(bagManager, bagOpener), this);

        getCommand("getBag").setExecutor(new GetBagCommand(bagManager));

        Bag exampleBag = new Bag("exampleBag", new ItemStack(Material.CHEST_MINECART), null);
        exampleBag.addItem(new ItemStack(Material.DIAMOND), 50.0);
        exampleBag.addItem(new ItemStack(Material.GOLD_INGOT), 30.0);

        bagManager.registerBag(exampleBag);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
