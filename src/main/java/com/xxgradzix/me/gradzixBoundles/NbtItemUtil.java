package com.xxgradzix.me.gradzixBoundles;

import org.bukkit.NamespacedKey;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataType;

import java.util.Optional;

public class NbtItemUtil {


    private static final NamespacedKey ITEM_CUSTOM_ID_KEY = new NamespacedKey("gradzix_bundle", "custom_bundle_id");

    static NamespacedKey getItemCustomIdKey() {
        return ITEM_CUSTOM_ID_KEY;
    }



//    public static int calcItemAmount(Player player, ItemStack customItem) {
//
//        int totalAmount = 0;
//        for (ItemStack itemStack : player.getInventory()) {
//            if (itemStack != null && (isSameNBT(customItem, itemStack) || itemStack.isSimilar(customItem))) {
//                totalAmount += itemStack.getAmount();
//            }
//        }
//        return totalAmount;
//    }
//
//    public static void removeItemsWithCustomItemNBT(Player player, ItemStack targetItem, int amountToRemove)  {
//
//
//        for (ItemStack itemStack : player.getInventory()) {
//            if (amountToRemove <= 0) {
//                break;
//            }
//
//            if (itemStack != null && (isSameNBT(targetItem, itemStack) || itemStack.isSimilar(targetItem)) && itemStack.getType() != Material.AIR) {
//                int currentAmount = itemStack.getAmount();
//
//                if (currentAmount <= amountToRemove) {
//                    amountToRemove -= currentAmount;
//                    itemStack.setAmount(0);
//                } else {
//                    itemStack.setAmount(currentAmount - amountToRemove);
//                    amountToRemove = 0;
//                }
//            }
//        }
//    }

//    public static boolean isSameNBT(ItemStack item, ItemStack stack) {
//
//        if (item.isSimilar(stack)) return true;
//
//        Optional<String> customId = CustomItem.getCustomId(item.getItemMeta());
//        Optional<String> customId1 = CustomItem.getCustomId(stack.getItemMeta());
//
//        if (customId.isEmpty() || customId1.isEmpty()) return false;
//        if(!customId.get().equals(customId1.get())) return false;
//
//        CustomItem weaponType1 = CustomItemManager.getCustomItem(item);
//        CustomItem weaponType2 = CustomItemManager.getCustomItem(stack);
//
//        return true;
//    }

//    public static List<ItemStack> getItemWithCustomId(Player player, NamespacedKey key, String customId) {
//
//        List<ItemStack> items = new ArrayList<>();
//
//        for (ItemStack itemStack : player.getInventory()) {
//            if (itemStack == null || !isCustomItem(itemStack)) continue;
//
//            ItemMeta meta = itemStack.getItemMeta();
//            if (meta == null) continue;
//
//            if (customId.equals(meta.getPersistentDataContainer().get(key, PersistentDataType.STRING))) {
//                items.add(itemStack);
//            }
//        }
//        return items;
//
//    }



    public static void setItemCustomId(ItemMeta meta, String value) {
        meta.getPersistentDataContainer().set(getItemCustomIdKey(), PersistentDataType.STRING, value);
    }


    static Optional<String> getCustomId(ItemMeta meta) {
        if(meta == null) return Optional.empty();
        return Optional.ofNullable(meta.getPersistentDataContainer().get(getItemCustomIdKey(), PersistentDataType.STRING));
    }

}
