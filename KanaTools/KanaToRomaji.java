package KanaTools;

public class KanaToRomaji 
{
    private KanaList kanaList;

    public KanaToRomaji() {
        this.kanaList = new KanaList();
    }

    public String romanizeString(String str) {
        String sRet = "";

        for (int i = 0; i < str.length();i++) {
            Kana currentKana = this.kanaList.getKana(str.substring(i, i+1));
            if (currentKana == null) {sRet += str.substring(i, i+1); continue;}
            String nextKana = (i == str.length()-1 ? null : str.substring(i+1, i+2));
            String romanized = currentKana.getHepburn(nextKana);
            sRet += romanized; 
        }

        return sRet;
    }
}
