package CSVTools;

import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.List;

import PlayerTools.Hissatsu;
import PlayerTools.Player;

public class CSVWriter 
{
    public static void exportPlayers(List<Player> playerList) 
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

    public static void exportHissatsu(List<Hissatsu> hissatsuList) 
    {
        try {
            FileOutputStream os = new FileOutputStream("hissatsu.csv");
            PrintWriter pw = new PrintWriter(new OutputStreamWriter(os, "UTF-8"));

            //Writing Headers
            for (String s: Hissatsu.headers) {
                pw.print(s+(s.equals(Hissatsu.headers[Hissatsu.headers.length-1]) ? "\n" : ","));
            }

            //Writing Hissatsu Data
            for (Hissatsu h : hissatsuList) {
                pw.println(h.csvString());
            }

            pw.close();
        } catch (Exception e) {
            // TODO: handle exception
        }
        
    }
}
