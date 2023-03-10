package PlayerTools;

public class Hissatsu {
    public static final String[] headers = new String[] {"japaneseName","japaneseDesc","tpCost","type","element","playerCount","foulRate", "punchForce"};
    
    private String japaneseName;
    private String japaneseDesc;

    private int    tpCost;
    private int    foulRate;
    private String type; //Attack, Defense, Shoot, Catch
    private String element; //Wind, Wood, Fire, Earth
    private int    playerCount;
    private int    punchForce; //For goalkeeper hissatsu


    private int power; /* Not sure if it exists */

    public Hissatsu(String japaneseName, String japaneseDesc) {
        this.japaneseName = japaneseName;
        this.japaneseDesc = japaneseDesc;
        this.type = "";
        this.element = "";
    }

    public void setStats(int tpCost, int type, int element, int playerCount, int foulRate, int punchForce) {
        this.tpCost   = tpCost;
        this.foulRate = foulRate;
        this.playerCount = playerCount+1;
        this.punchForce = punchForce;

        switch (type) {
            case 5  : this.type = "Attack" ; break;
            case 6  : this.type = "Defense"; break;
            case 7  : this.type = "Shoot"  ; break;
            case 8  : this.type = "Catch"  ; break;
        }

        switch (element) {
            case 1: this.element = "Wind" ; break;
            case 2: this.element = "Wood" ; break;
            case 3: this.element = "Fire" ; break;
            case 4: this.element = "Earth"; break;
        }
    }



    public String csvString() {
        return this.japaneseName + "," + this.japaneseDesc + "," + 
               this.tpCost + "," + this.type + "," + this.element + "," + 
               this.playerCount + "," + this.foulRate + "," + this.punchForce;
    }

    public String getJapaneseName() {
        return this.japaneseName;
    }
}
