public class Enemies {
    private String name;
    private int health;
    private int damage;

    public Enemies(String name, int health, int damage){
        this.name=name;
        this.health=health;
        this.damage=damage;
    }

	public int getDamage() {
		return damage;
	}

    public int getHealth() {
        return health;
    }

    public String getName() {
        return name;
    }
}
