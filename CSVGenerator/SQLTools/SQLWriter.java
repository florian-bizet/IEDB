package SQLTools;

import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.List;

import PlayerTools.Player;

public class SQLWriter {
    public static void exportSQL(List<Player> playerList) {
        try {
            FileOutputStream os = new FileOutputStream("Insert.sql");
            PrintWriter pw = new PrintWriter(new OutputStreamWriter(os, "UTF-8"));

            //Player Queries
            pw.println("INSERT INTO Player VALUES");

            for (int i = 0; i < playerList.size(); i++) {
                pw.println(playerList.get(i).sqlString(i) + (i == playerList.size()-1 ? ";" : ","));
            }

            pw.close();


        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}