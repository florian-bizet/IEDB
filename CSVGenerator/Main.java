import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import CSVTools.CSVReader;
import CSVTools.CSVWriter;
import KanaTools.*;
import PlayerTools.IEFileReader;
import PlayerTools.Player;
import SQLTools.SQLWriter;

public class Main 
{
    private List<Player> playerList;
    private KanaToRomaji kanaConverter;
    
    public Main() {
        this.playerList    = new ArrayList<Player>();
        this.kanaConverter = new KanaToRomaji();
    }

    public void sourceToCSV() {
        IEFileReader.loadPlayers     (this.playerList);
        IEFileReader.loadDescriptions(this.playerList);
        IEFileReader.loadStats       (this.playerList);
        for (Player p : this.playerList) {
            p.romanize(kanaConverter);
        }
        CSVWriter.exportCSV(playerList);
    }

    public void csvToSQL() {
        this.playerList = CSVReader.loadPlayers("players.csv");
        SQLWriter.exportSQL(playerList);
    }

    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Invalid arguments !"              );
            System.out.println("How to use : java Main -option"   );
            System.out.println("Option list : "                   );
            System.out.println("\t--csv : Source Files -> CSV"    );
            System.out.println("\t--sql : CSV -> SQL Data Records");
            return;
        }

        if (args[0].equals("--csv")) {
            new Main().sourceToCSV();
            return;
        }

        if (args[0].equals("--sql")) {
            new Main().csvToSQL();
            return;
        }

        System.out.println("Invalid arguments !"              );
        System.out.println("How to use : java Main --option"  );
        System.out.println("Option list : "                   );
        System.out.println("\t--csv : Source Files -> CSV"    );
        System.out.println("\t--sql : CSV -> SQL Data Records");
    }
}
