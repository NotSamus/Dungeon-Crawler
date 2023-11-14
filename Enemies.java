/**
 * Enemies class that represents enemy in game and has enemies attributes.
 * String name
 * int health
 * int damage 
 * 
 * @author Team 7 : Alejandro Rodriguez, Donritchie Ewane, Isaac Borjon, Jesus Lopez
 */
public class Enemies {

    /**
     * Enemy name.
     */
    private String name;

    /**
     * Enemy health.
     */
    private int health;

    /**
     * Enemy damage.
     */
    private int damage;

    /**
     * Constructs a new enemy object with the given name, health, and damage.
     * 
     * @param name Enemy name.
     * @param health Enemy health.
     * @param damage Enemy damage.
     */
    public Enemies(String name, int health, int damage){
        this.name=name;
        this.health=health;
        this.damage=damage;
    }

    /** 
     * Gets the amount of damage the enemy can deal in an attack.
     * 
     * @return int representing the amount of damage the enemy can deal in one attack.
     */
    public int getDamage() {
		return damage;
	}

    /** 
     * Gets the current enemy health.
     * 
     * @return int representing the enemy health.
     */
    public int getHealth() {
        return health;
    }
    
    /** 
     * Gets the name of the enemy.
     * 
     * @return String representing enemy name.
     */
    public String getName() {
        return name;
    }
}
