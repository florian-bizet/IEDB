package CSVTools;

import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.List;

import PlayerTools.Player;

public class CSVWriter 
{
    public static void exportCSV(List<Player> playerList) 
    {
        try {
            FileOutputStream os = new FileOutputStream("players.csv");
            PrintWriter pw = new PrintWriter(new OutputStreamWriter(os, "UTF-8"));

            //Writing Headers
            for (String s: Player.headers) {
                pw.print(s+(s.equals(Player.headers[Player.headers.length-1]) ? "\n" : ","));
            }

            //Writing Player Data
            for (Player p: playerList) {
                pw.println(p.csvString());
            }

            pw.close();
        } catch (Exception e) {
            // TODO: handle exception
        }
        
    }
}
