package PlayerTools;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.List;
import java.util.Scanner;

public class IEFileReader {
    /**
     * This method reads the PlayerList.txt file, which is a simplified version of unitbase.dat
     * This will get replaced someday to read the original file, as it might contain more info
     * @param currentPlayerList 
     */
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

    /**
     * This method reads the unitbase.STR, which is structured with zones of 32 bytes of data.
     * Each description is separated with at least one 00 byte, so when this method reads one,
     * it saves the current description to its player and goes to the next 32 byte zone
     * @param currentPlayerList
     */
    public static void loadDescriptions(List<Player> currentPlayerList) {
        
        //Player that will receive the description
        int currentPlayerId = 0;
        try {
            //Opening File
            File descFile = new File("InputFiles/unitbase.STR");
            InputStream in = new FileInputStream(descFile);
            Reader reader = new InputStreamReader(in, "Shift_JIS");
            
            StringBuilder sb = new StringBuilder();

            int read; //Current value
            int bytesRead = 0; //Used to count 32 byte zones

            while ((read = reader.read()) != -1){
                //Some characters might take 2 bytes instead of only 1, 
                //so we must have this in mind when keeping track of our position in the file
                bytesRead += (read > 255 ? 2 : 1); 
                
                if (read == 0) {
                    String desc = sb.toString();
                    desc = desc.replace("\n", "");

                    currentPlayerList.get(currentPlayerId++).setJapaneseDescription(desc);
                    
                    //Navigating to the next 32 byte zone
                    while (bytesRead != 0 && bytesRead%32 != 0) {read = reader.read(); bytesRead += (read > 255 ? 2 : 1);}

                    //Resetting values
                    sb = new StringBuilder();
                    bytesRead = 0;
                    continue;
                }
                sb.append((char)read);
            }
            reader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    /**
     * This method reads the unitstat.dat file, which is structured with zones of 64 bytes of data.
     * It reads specific bytes that are used in the game to get the players statistics.
     * @param currentPlayerList
     */
    public static void loadStats(List<Player> currentPlayerList, List<Hissatsu> hissatsuList) {
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

                currentPlayerList.get(currentPlayerId).setStats(GP, TP, kick, body, control, guard, speed, stamina, guts);

                for (int i = 0; i < 8; i += 2) {
                    int hissatsuID = (int) (statBytes[44+i] & 0xFF);
                    currentPlayerList.get(currentPlayerId).setHissatsu(hissatsuList.get(hissatsuID), i/2);
                } 

                currentPlayerId++;
            }

            in.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * This method reads the command.STR file, 
     * which contains data for the soccer mode actions and for the hissatsu techniques.
     * It is organized in a way that an action has 2 main sections : 
     * The first one contains the action name stored with 32 bytes, and the next section contains the description, 
     * splitted in 32 byte zones like player descriptions
     * @param currentHissatsuList
     */
    public static void loadHissatsu(List<Hissatsu> currentHissatsuList) {
        try {
            //Opening File
            File descFile = new File("InputFiles/command.STR");
            InputStream in = new FileInputStream(descFile);
            Reader reader = new InputStreamReader(in, "Shift_JIS");
            
            StringBuilder sb = new StringBuilder();

            int section = 0; //0 = name; 1 = description
            String name = "";
            String desc = "";

            int read; //Current value
            int bytesRead = 0; //Used to count 32 byte zones

            while ((read = reader.read()) != -1){
                //Some characters might take 2 bytes instead of only 1, 
                //so we must have this in mind when keeping track of our position in the file
                bytesRead += (read > 255 ? 2 : 1); 
                
                if (read == 0) {
                    String text = sb.toString();
                    text = text.replace("\n", "");

                    if (section == 0) {name = text;}
                    else {
                        desc = text;
                        currentHissatsuList.add(new Hissatsu(name, desc));
                        name = "";
                        desc = "";
                    }
                    
                    //Navigating to the next 32 byte zone
                    while (bytesRead != 0 && bytesRead%32 != 0) {read = reader.read(); bytesRead += (read > 255 ? 2 : 1);}

                    //Resetting values
                    section = (section+1)%2;
                    sb = new StringBuilder();
                    bytesRead = 0;
                    continue;
                }
                sb.append((char)read);
            }
            reader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void loadHissatsuStats(List<Hissatsu> hissatsuList) {
        int currentHissatsuId = 0;
        try {
            File descFile = new File("InputFiles/command.dat");
            InputStream in = new FileInputStream(descFile);

            while (in.available() >= 24) {
                if (currentHissatsuId >= hissatsuList.size()) {return;}
                byte[] statBytes = in.readNBytes(24);
                Hissatsu h = hissatsuList.get(currentHissatsuId++);

                int tpCost      = (int) (statBytes[4 ] & 0xFF);
                int type        = (int) (statBytes[0 ] & 0xFF);
                int element     = (int) (statBytes[8 ] & 0xFF);
                int playerCount = (int) (statBytes[10] & 0xFF);
                int foulRate    = (int) (statBytes[1 ] & 0xFF);
                int punchForce  = (int) (statBytes[14] & 0xFF); 

                h.setStats(tpCost, type, element, playerCount, foulRate, punchForce);
            }

            in.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
