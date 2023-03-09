package CSVTools;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import PlayerTools.Player;

public class CSVReader 
{
    public static List<Player> loadPlayers(String sourcePath) 
    {
        List<Player> playerList = new ArrayList<Player>();

        try {
            Scanner sc = new Scanner(new FileInputStream(sourcePath));

            //Skipping Headers
            sc.nextLine();

            while (sc.hasNextLine()) {
                String[] playerData = sc.nextLine().split(",");
                playerList.add(new Player(playerData[0],
                                          playerData[1],
                                          playerData[2],
                                          playerData[3],
                                          playerData[4],
                                          playerData[5],
                                          Integer.parseInt(playerData[6]),
                                          Integer.parseInt(playerData[7]),
                                          Integer.parseInt(playerData[8]),
                                          Integer.parseInt(playerData[9]),
                                          Integer.parseInt(playerData[10]),
                                          Integer.parseInt(playerData[11]),
                                          Integer.parseInt(playerData[12]),
                                          Integer.parseInt(playerData[13]),
                                          Integer.parseInt(playerData[14])));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return playerList;
    }
}