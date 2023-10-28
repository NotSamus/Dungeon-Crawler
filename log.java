import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.Calendar;
public class log{
    
public static void loger(String x) throws IOException{ 
    File file = new File("log.txt");
    // PrintWriter writer = new PrintWriter(file);
    FileWriter fileWriter = new FileWriter(file,true);
    BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
    Date date = new Date();
    Calendar calendar = Calendar.getInstance();
    // writer.append(x +" " +date.toString() +" " +date.getHours()+"\n");
   // System.out.println(date.toString());
    //System.out.println(date.getHours());
    //Sistem.out.println(" "+date.toString()+" "+date.getHours()+" "+string+"\n");
    bufferedWriter.write(x+" "+date.toString()+ " "+"\n");
    bufferedWriter.close();
    fileWriter.close();
    // writer.close();
}
    public static boolean write_on_log(String a){
        return true;
    }
}




