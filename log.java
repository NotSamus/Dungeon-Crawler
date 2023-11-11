import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;
import java.util.Calendar;
public class log{
    
    /**
     * This method is to add the things to the log 
     * @param x 
     * @throws IOException handle the file 
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
    public static boolean write_on_log(String a){
        return true;
    }
}




