package PlayerTools;

import KanaTools.KanaToRomaji;

public class Player {
    public static final String[] headers = new String[] {"kanjiName","longKanaName","shortKanaName",
                                                         "longRomajiName","shortRomajiName",
                                                         "japaneseDescription",
                                                         "GP","TP","Kick","Body","Control","Guard","Speed","Stamina","Guts"};
    
    /* Player Name */
    private String kanjiName;
    private String longKanaName;
    private String shortKanaName;
    
    private String longRomajiName;
    private String shortRomajiName;

    /* Player Description */
    private String japaneseDescription;

    /* Player Stats */
    private int GP;
    private int TP;
    private int kick;
    private int body;
    private int control;
    private int guard;
    private int speed;
    private int stamina;
    private int guts;
    private int freedom;


    
    public Player(String kanjiName, String longKanaName, String shortKanaName, String longRomajiName,
            String shortRomajiName, String japaneseDescription, int gP, int tP, int kick, int body, int control,
            int guard, int speed, int stamina, int guts) {
        this.kanjiName = kanjiName;
        this.longKanaName = longKanaName;
        this.shortKanaName = shortKanaName;
        this.longRomajiName = longRomajiName;
        this.shortRomajiName = shortRomajiName;
        this.japaneseDescription = japaneseDescription;
        GP = gP;
        TP = tP;
        this.kick = kick;
        this.body = body;
        this.control = control;
        this.guard = guard;
        this.speed = speed;
        this.stamina = stamina;
        this.guts = guts;
    }

    public Player(String kanji, String longName, String shortName) {
        this.kanjiName     = kanji;
        this.longKanaName  = longName;
        this.shortKanaName = shortName;
    }

    public void romanize(KanaToRomaji converter) {
        this.longRomajiName  = converter.romanizeString(longKanaName );
        this.shortRomajiName = converter.romanizeString(shortKanaName);
        this.capitalize();
    }

    private void capitalize() {
        String newLongName = (""+this.longRomajiName.charAt(0)).toUpperCase();

        for (int i = 1; i < this.longRomajiName.length(); i++) {
            if (this.longRomajiName.charAt(i) == ' ') {
                i++;
                if (i >= this.longRomajiName.length()) break;
                newLongName += (" "+this.longRomajiName.charAt(i)).toUpperCase();
                continue;
            }

            newLongName += this.longRomajiName.charAt(i);
        }

        this.longRomajiName = newLongName;

        String newShortName = (""+this.shortRomajiName.charAt(0)).toUpperCase();

        for (int i = 1; i < this.shortRomajiName.length(); i++) {
            if (this.shortRomajiName.charAt(i) == ' ') {
                i++;
                if (i >= this.shortRomajiName.length()) break;
                newShortName += (" "+this.shortRomajiName.charAt(i)).toUpperCase();
                continue;
            }

            newShortName += this.shortRomajiName.charAt(i);
        }

        this.shortRomajiName = newShortName;
    }

    public String toString() {
        return this.longRomajiName + ", " + this.shortRomajiName;
    }

    public String csvString() {
        return this.kanjiName          +","+
               this.longKanaName       +","+ 
               this.shortKanaName      +","+
               this.longRomajiName     +","+
               this.shortRomajiName    +","+
               this.japaneseDescription+","+
               this.GP                 +","+
               this.TP                 +","+
               this.kick               +","+
               this.body               +","+
               this.control            +","+
               this.guard              +","+
               this.speed              +","+
               this.stamina            +","+
               this.guts    ;
    }

    public String sqlString(int id) {
        return "(" + id + ",'" + 
                     this.kanjiName          +"','"+
                     this.longKanaName       +"','"+ 
                     this.shortKanaName      +"','"+
                     this.longRomajiName     +"','"+
                     this.shortRomajiName    +"','"+
                     this.japaneseDescription+"',"+
                     this.GP                 +","+
                     this.TP                 +","+
                     this.kick               +","+
                     this.body               +","+
                     this.control            +","+
                     this.guard              +","+
                     this.speed              +","+
                     this.stamina            +","+
                     this.guts               +")";
    }

    public String getKanjiName          () {return this.kanjiName;          }
    public String getLongKanaName       () {return this.longKanaName;       }
    public String getShortKanaName      () {return this.shortKanaName;      }
    public String getLongRomajiName     () {return this.longRomajiName;     }
    public String getShortRomajiName    () {return this.shortRomajiName;    }
    public String getJapaneseDescription() {return this.japaneseDescription;}

    public void   setJapaneseDescription(String s) {this.japaneseDescription = s;}
    public void   setStats(int GP, int TP, int kick, int body, int control, int guard, int speed, int stamina, int guts) {
        this.GP      = GP;
        this.TP      = TP;
        this.kick    = kick    ;
        this.body    = body    ;
        this.control = control ;
        this.guard   = guard   ;
        this.speed   = speed   ;
        this.stamina = stamina ;
        this.guts    = guts    ;
    }
}
