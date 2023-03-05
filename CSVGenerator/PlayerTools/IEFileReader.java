package PlayerTools;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.Arrays;
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

    public static void loadDescriptions(List<Player> currentPlayerList) {
        
        //Player that will receive the description
        int currentPlayerId = 0;
        try {
            File descFile = new File("InputFiles/unitbase.STR");
            InputStream in = new FileInputStream(descFile);
            Reader reader = new InputStreamReader(in, "Shift_JIS");
            StringBuilder sb = new StringBuilder();
            int read;
            int bytesRead = 0;
            while ((read = reader.read()) != -1){
                bytesRead += (read > 255 ? 2 : 1); 
                if (read == 0) {
                    
                    String desc = sb.toString();
                    desc = desc.replace(""+((char)0), "");
                    desc = desc.replace("\n", "");
                    currentPlayerList.get(currentPlayerId++).setJapaneseDescription(desc);
                    sb = new StringBuilder();
                    while (bytesRead != 0 && bytesRead%32 != 0) {read = reader.read(); bytesRead += (read > 255 ? 2 : 1);}
                    bytesRead = 0;
                }
                sb.append((char)read);
            }
            reader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void loadStats(List<Player> currentPlayerList) {
        int currentPlayerId = 0;
        try {
            File descFile = new File("InputFiles/unitstat.dat");
            InputStream in = new FileInputStream(descFile);

            while (in.available() >= 64) {
                byte[] statBytes = in.readNBytes(64);

                int GP      = ((int) (statBytes[3 ] & 0xFF) * 256) + (int) (statBytes[2 ] & 0xFF);
                int TP      = ((int) (statBytes[11] & 0xFF) * 256) + (int) (statBytes[10] & 0xFF);
                int kick    =  (int) (statBytes[17] & 0xFF);
                int body    =  (int) (statBytes[21] & 0xFF);
                int control =  (int) (statBytes[29] & 0xFF);
                int guard   =  (int) (statBytes[25] & 0xFF);
                int speed   =  (int) (statBytes[33] & 0xFF);
                int stamina =  (int) (statBytes[41] & 0xFF);
                int guts    =  (int) (statBytes[37] & 0xFF);

                currentPlayerList.get(currentPlayerId++).setStats(GP, TP, kick, body, control, guard, speed, stamina, guts);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
