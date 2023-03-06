package KanaTools;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Kana {
    private String  hiragana;
    private String  katakana;
    private String  hepburn;
    private boolean canCombine;

    private boolean wasCombined;

    public Kana(String hiragana, String katakana, String hepburn, boolean canCombine) {
        this.hiragana = hiragana;
        this.katakana = katakana;
        this.hepburn = hepburn;
        this.canCombine = canCombine;
    }

    public String getHepburn(String nextKana) {
        this.wasCombined = false;
        
        if (!canCombine) return this.hepburn;
        
        HashMap<String,String> yayuyo = new HashMap<String,String>();
        yayuyo.put("ゃ","ya");
        yayuyo.put("ャ","ya");
        yayuyo.put("ゅ","yu");
        yayuyo.put("ュ","yu");
        yayuyo.put("ょ","yo");
        yayuyo.put("ョ","yo");
        yayuyo.put("ァ","a");
        yayuyo.put("ィ","i");
        yayuyo.put("ゥ","u");
        yayuyo.put("ェ","e");
        yayuyo.put("ォ","o");

        HashMap<String,String> exceptions = new HashMap<String,String>();
        exceptions.put("しゃ","sha");
        exceptions.put("シャ","sha");
        exceptions.put("しゅ","shu");
        exceptions.put("シュ","shu");
        exceptions.put("しょ","sho");
        exceptions.put("ショ","sho");
        exceptions.put("ちゃ","cha");
        exceptions.put("チャ","cha");
        exceptions.put("ちゅ","chu");
        exceptions.put("チュ","chu");
        exceptions.put("ちょ","cho");
        exceptions.put("チョ","cho");
        exceptions.put("じゃ","ja");
        exceptions.put("ジャ","ja");
        exceptions.put("じゅ","ju");
        exceptions.put("ジュ","ju");
        exceptions.put("じょ","jo");
        exceptions.put("ジョ","jo");
        exceptions.put("ディ","di");

        
        if (!yayuyo.containsKey(nextKana)) {return this.hepburn;}
        this.wasCombined = true;
        if (exceptions.containsKey((this.hiragana+nextKana))) {
            return exceptions.get(this.hiragana+nextKana);
        }
        if (exceptions.containsKey((this.katakana+nextKana))) {
            return exceptions.get(this.katakana+nextKana);
        }

        return "" + this.hepburn.charAt(0) + yayuyo.get(nextKana);
    }

    public String getHiragana() {return this.hiragana;}
    public String getKatakana() {return this.katakana;}

    public boolean wasCombined() {return this.wasCombined;}
    
}
