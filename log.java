import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;
import java.util.Calendar;




public class log{
    
public static void loger(String x) throws IOException{
    
    File file = new File("log.txt");
    FileWriter fileWriter = new FileWriter(file);
    BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
    Date date = new Date();
    Calendar calendar = Calendar.getInstance();
   // System.out.println(date.toString());
    //System.out.println(date.getHours());
    //Sistem.out.println(" "+date.toString()+" "+date.getHours()+" "+string+"\n");
    bufferedWriter.write(x+" "+Calendar.HOUR_OF_DAY+" "+date.toString()+ " "+"\n");
    bufferedWriter.close();
    fileWriter.close();
}
    
    

    public static boolean write_on_log(String a){
        return true;
    }
}




