
public class Item {
    private String name;
    private String description;
    private int effectValue;

    public Item(String name, String description, int effectValue) {
        this.name = name;
        this.description = description;
        this.effectValue = effectValue;
    }

    public void use(Player player) {
        switch (name) {
            case "Sword Upgrade":
                player.increaseDamage(effectValue);
                break;
            case "Heart Upgrade":
                player.increaseMaxHealth(effectValue);
                player.heal(effectValue);
                break;
            case "Clear Potion":
                player.clearStatusEffects();
                break;
            case "Smoke Bomb":
                player.increaseEscapeChance(effectValue);
                break;
            case "Coin":
                player.addCoins(effectValue);
                break;
            default:
                System.out.println("Invalid item name");
        }
    }
}
