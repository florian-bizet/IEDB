package KanaTools;

public class KanaToRomaji 
{
    private KanaList kanaList;

    public KanaToRomaji() {
        this.kanaList = new KanaList();
    }

    public String romanizeString(String str) {
        String sRet = "";
        boolean extend = false;
        boolean pause = false;

        for (int i = 0; i < str.length();i++) {
            Kana currentKana = this.kanaList.getKana(str.substring(i, i+1));
            if (currentKana == null) {sRet += str.substring(i, i+1); continue;} //Skip character

            String nextKana = (i == str.length()-1 ? null : str.substring(i+1, i+2));
            String romanized = currentKana.getHepburn(nextKana);

            if (currentKana.wasCombined()) {
                i++; 
                nextKana = (i == str.length()-1 ? null : str.substring(i+1, i+2));
            }
            extend = (nextKana != null && nextKana.equals("ー"));
            pause  = (nextKana != null && (nextKana.equals("っ") || nextKana.equals("ッ")));

            if (pause) {i++; nextKana = (i == str.length()-1 ? null : str.substring(i+1, i+2));}

            sRet += romanized + (extend ? romanized.charAt(romanized.length()-1) : "") + (pause ? this.romanizeString(nextKana).charAt(0) : "");
            if (extend && !pause) i++;
        }

        return sRet;
    }
}
