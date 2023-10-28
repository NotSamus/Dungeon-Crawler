class player extends user {
    private String[][] dungeon;

    public player(String firstName, String lastName, String username, String state, long lastSignIn, long loginTime, String pin, String city, String zip, String dateOfBirth, String[][] dungeon) {
        super(firstName, lastName, username, dateOfBirth, dateOfBirth, dateOfBirth, dateOfBirth, dateOfBirth, dateOfBirth, dateOfBirth, dateOfBirth);
        this.dungeon = dungeon;
    }
    public String[][] getDungeon() {
        return dungeon;
    }

    public void setDungeon(String[][] dungeon) {
        this.dungeon = dungeon;
    }
}

// dungeon dungeon = new Dungeon();
// player player = new player(dungeon);

// System.out.println(player.getDungeon()); // Outputs the dungeon object
