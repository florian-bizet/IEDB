import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

import KanaTools.*;

public class Main 
{
    public static void main(String[] args) {
        try {
            FileOutputStream os = new FileOutputStream("output.txt");
            PrintWriter pw = new PrintWriter(new OutputStreamWriter(os, "UTF-8"));
        
            String str = "さかながだいすきです";
            pw.println("Input String    : " + str);
            pw.println("Expected output : sakanagadaisukidesu");
            pw.println("Output          : " + new KanaToRomaji().romanizeString(str));

            pw.close();
        } catch (Exception e) {
            // TODO: handle exception
        }
        
        
    }
}
