package PlayerTools;

import KanaTools.KanaToRomaji;

public class Player {
    public static final String[] headers = new String[] {"kanjiName","longKanaName","shortKanaName","longRomajiName","shortRomajiName"};
    
    private String kanjiName;
    private String longKanaName;
    private String shortKanaName;
    
    private String longRomajiName;
    private String shortRomajiName;

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
        return this.kanjiName+","+this.longKanaName+","+this.shortKanaName+","+this.longRomajiName+","+this.shortRomajiName;
    }

    public String getKanjiName      () {return this.kanjiName;      }
    public String getLongKanaName   () {return this.longKanaName;   }
    public String getShortKanaName  () {return this.shortKanaName;  }
    public String getLongRomajiName () {return this.longRomajiName; }
    public String getShortRomajiName() {return this.shortRomajiName;}
}
