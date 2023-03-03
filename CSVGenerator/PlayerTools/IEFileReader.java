package PlayerTools;

import java.io.FileInputStream;
import java.util.List;
import java.util.Scanner;

public class IEFileReader {
    public static void loadPlayers(List<Player> currentPlayerList) {
        try {
            Scanner sc = new Scanner(new FileInputStream("./InputFiles/PlayerList.txt"), "UTF-8");

            while (sc.hasNextLine()) {
                String kanjiName = sc.nextLine();
                String shortName = sc.nextLine();
                String longName  = sc.nextLine();

                currentPlayerList.add(new Player(kanjiName, longName, shortName));
            }

            sc.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
