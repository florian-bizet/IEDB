package PlayerTools;

public class Hissatsu {
    public static final String[] headers = new String[] {"japaneseName","japaneseDesc"};
    
    private String japaneseName;
    private String japaneseDesc;

    private int tpCost;
    private int foulRate;
    private int power; /* Not sure if it exists */

    public Hissatsu(String japaneseName, String japaneseDesc) {
        this.japaneseName = japaneseName;
        this.japaneseDesc = japaneseDesc;
    }

    public String csvString() {
        return this.japaneseName + "," + this.japaneseDesc;
    }
}
