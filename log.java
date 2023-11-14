import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;
import java.util.Calendar;
/**
 * This class is meant to log actions taken by the user.
 */
public class log{ 
    /**
     * Appends the given string to a log file. 
     * @param x is the string to append to the log file.
     * @throws IOException if there is an error writing to the log file. 
     */
    public static void loger(String x) throws IOException{ 
        File file = new File("log.txt");
        FileWriter fileWriter = new FileWriter(file,true);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        Date date = new Date();
        Calendar calendar = Calendar.getInstance();
        bufferedWriter.write(x+" "+date.toString()+ " "+"\n");
        bufferedWriter.close();
        fileWriter.close();
    }
    /**
     * Checks if the given string should be written to the log file.
     *
     * @param a The string to check.
     * @return True if the string should be written to the log file, false otherwise.
     */
    public static boolean write_on_log(String a){
        return true;
    }
}




