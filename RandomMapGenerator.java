import java.util.Random;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class RandomMapGenerator {

    
    private static int MAP_SIZE;
    private static int MAX_TUNNELS = MAP_SIZE+35;
    /**
     * This is the Procedural Generation
     * @param size
     * @return
     */
    private static String[][] proceduralGeneration(int size) {
        String[][] map = createArray(size);
        Random random = new Random();

        int startX = random.nextInt(size);
        int startY = random.nextInt(size);
        int tunnelsCreated = 0;
        int MAX_LENGTH = 40;

            while (tunnelsCreated < MAX_TUNNELS) {
                int length = random.nextInt(MAX_LENGTH);
                int direction = random.nextInt(4);
                int newX = startX;
                int newY = startY;
        
                for (int i = 0; i < length; i++) {
                    switch (direction) {
                        case 0: newY--; break; // North
                        case 1: newX++; break; // East
                        case 2: newY++; break; // South
                        case 3: newX--; break; // West
                    }
        
                    if (isValidMove(map, newX, newY)) {
                        map[startY][startX] = "0,";
                        map[newY][newX] = "0,";
        
                        startX = newX;
                        startY = newY;
                    } else {
                        break;
                    }
                }
        
                tunnelsCreated++;
            }

        return map;
    }
    /**
     * Checks if the move is valid
     * @param map
     * @param x
     * @param y
     * @return
     */
    private static boolean isValidMove(String[][] map, int x, int y) {
        return x >= 0 && x < MAP_SIZE && y >= 0 && y < MAP_SIZE && !map[y][x].equals("0,");
    }
    /**
     * Creates the array
     * @param size
     * @return
     */
    private static String[][] createArray(int size) {
        String[][] array = new String[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                array[i][j] = "-1,";
            }
        }
        return array;
    }
        /**
         * This is to initiate the randomMapGenerator
         * @param x
         * @param y
         * @param c
         * @throws IOException
         */
        public static void RandomMapGenerator1(String [][]z,BufferedWriter c)throws IOException{
        for (int i = 0; i < z.length; i++) {
            for (int j = 0; j < z[i].length-1; j++) {
                c.write(z[i][j]+ " ");
            }
            c.write("-1");
            c.newLine();
        }
        c.close();
    }

    /**
     * This is the method that will create a new map and added to the subdirectory maps
     * @param a is the number of the map
     * @param x is the size
     * @throws IOException
     */
    public static void createNewMap(int a, int x)throws IOException{
        MAP_SIZE = x;
        String[][] map = proceduralGeneration(MAP_SIZE);
        File file = new File("maps/CustomDungeonLayout"+a + ".csv");
        FileWriter fileWriter = new FileWriter(file);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        //call RandomMapGenerator, pass the x and the y, the a is for the name of the map
        RandomMapGenerator1(map, bufferedWriter);
        bufferedWriter.close();
        
    }
}