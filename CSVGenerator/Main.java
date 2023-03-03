import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import CSVExport.CSVWriter;
import KanaTools.*;
import PlayerTools.IEFileReader;
import PlayerTools.Player;

public class Main 
{
    private List<Player> playerList;
    private KanaToRomaji kanaConverter;
    
    public Main() {
        this.playerList    = new ArrayList<Player>();
        this.kanaConverter = new KanaToRomaji();
    }

    public void process() {
        IEFileReader.loadPlayers(this.playerList);
        for (Player p : this.playerList) {
            p.romanize(kanaConverter);
        }
        CSVWriter.exportCSV(playerList);
    }

    public static void main(String[] args) {
        new Main().process();
    }
}
