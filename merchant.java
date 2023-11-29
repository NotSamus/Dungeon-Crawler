import java.util.*;
public class merchant{
    private static HashMap<String, Integer> inventory = new HashMap<>(){
        {
            put("Heart Upgrade", 5);
            put("Sword Upgrade", 3);
            put("Smoke Bomb", 10);
        }
    };
    // private HashMap<String, Integer> prices = new HashMap<>();
    public static Scanner in = new Scanner(System.in);
    player Player = new player();

    // public merchant() {
    //     inventory.put("Heart Upgrade", 5);
    //     inventory.put("Sword Upgrade", 3);
    //     inventory.put("Smoke Bomb", 10);
    // }
    public static void interact(player player) {
        System.out.println("Welcome to the merchant's shop!");
        System.out.println("Items available for purchase:");
        for (String item : inventory.keySet()) {
            if (inventory.get(item) > 0) {
                System.out.println("- " + item + ": " + inventory.get(item) + " available");
            }
        }
        
        String selection = "";
        while (!selection.equals("exit")) {
            System.out.print("Choose an item to purchase (or type 'exit' to leave): ");
            selection = in.nextLine();

            if (!inventory.containsKey(selection)) {
                System.out.println("Invalid item selection.");
            } else if (inventory.get(selection) == 0) {
                System.out.println("Sorry, " + selection + " is out of stock.");
            } else {
                int purchasePrice = (int) (Math.random() * 20) + 10;
                if (player.get_coins() >= purchasePrice) {
                    System.out.println("You purchased " + selection + " for " + purchasePrice + " coins.");
                    player.set_coins(player.get_coins() - purchasePrice);
                    inventory.put(selection, inventory.get(selection) - 1);
                    player.gItem_inventory().add(selection);
                } else {
                    System.out.println("Insufficient coins to purchase this item.");
                }
            }
        }

        System.out.println("Thank you for shopping!");
    }
    public static void showInventory() {
        System.out.println("Merchant's Inventory:");
        // inventory.forEach( (key, value) -> {System.out.printf("%s: %d", key, value);} );
        for (String item : inventory.keySet()) {
            if (inventory.get(item) > 0) {
                System.out.println("- " + item + ": " + inventory.get(item) + " available");
            }
        }
        System.out.println();
    }
}