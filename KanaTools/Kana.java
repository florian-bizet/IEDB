package KanaTools;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Kana {
    private String  hiragana;
    private String  katakana;
    private String  hepburn;
    private boolean canCombine;

    public Kana(String hiragana, String katakana, String hepburn, boolean canCombine) {
        this.hiragana = hiragana;
        this.katakana = katakana;
        this.hepburn = hepburn;
        this.canCombine = canCombine;
    }

    public String getHepburn(String nextKana) {
        if (!canCombine) return this.hepburn;
        
        HashMap<String,String> yayuyo = new HashMap<String,String>();
        yayuyo.put("ゃ","ya");
        yayuyo.put("ャ","ya");
        yayuyo.put("ゅ","yu");
        yayuyo.put("ュ","yu");
        yayuyo.put("ょ","yo");
        yayuyo.put("ョ","yo");

        if (!yayuyo.containsKey(nextKana)) {return this.hepburn;}
        return "" + this.hepburn.charAt(0) + yayuyo.get(nextKana);
    }

    public String getHiragana() {return this.hiragana;}
    public String getKatakana() {return this.katakana;}

    private String extendHepburn() {
        return this.hepburn + this.hepburn.charAt(this.hepburn.length()-1);
    }

    
}
