package KanaTools;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class KanaList {
    private List<Kana> lstKana;
    
    public KanaList() {
        this.lstKana = new ArrayList<Kana>();

        //A I U E O
        this.lstKana.add(new Kana("あ","ア", "a", false));
        this.lstKana.add(new Kana("い","イ", "i", false));
        this.lstKana.add(new Kana("う","ウ", "u", false));
        this.lstKana.add(new Kana("え","エ", "e", false));
        this.lstKana.add(new Kana("お","オ", "o", false));

        //KA KI KU KE KO
        this.lstKana.add(new Kana("か","カ", "ka", false));
        this.lstKana.add(new Kana("き","キ", "ki", true));
        this.lstKana.add(new Kana("く","ク", "ku", false));
        this.lstKana.add(new Kana("け","ケ", "ke", false));
        this.lstKana.add(new Kana("こ","コ", "ko", false));

        //GA GI GU GE GO
        this.lstKana.add(new Kana("が","ガ", "ga", false));
        this.lstKana.add(new Kana("ぎ","ギ", "gi", true));
        this.lstKana.add(new Kana("ぐ","グ", "gu", false));
        this.lstKana.add(new Kana("げ","ゲ", "ge", false));
        this.lstKana.add(new Kana("ご","ゴ", "go", false));

        //SA SHI SU SE SO
        this.lstKana.add(new Kana("さ","サ", "sa", false));
        this.lstKana.add(new Kana("し","シ", "shi", true));
        this.lstKana.add(new Kana("す","ス", "su", false));
        this.lstKana.add(new Kana("せ","セ", "se", false));
        this.lstKana.add(new Kana("そ","ソ", "so", false));

        //ZA JI ZU ZE ZO
        this.lstKana.add(new Kana("ざ","ザ", "za", false));
        this.lstKana.add(new Kana("じ","ジ", "ji", true));
        this.lstKana.add(new Kana("ず","ズ", "zu", false));
        this.lstKana.add(new Kana("ぜ","ゼ", "ze", false));
        this.lstKana.add(new Kana("ぞ","ゾ", "zo", false));

        //TA CHI TSU TE TO
        this.lstKana.add(new Kana("た","タ", "ta", false));
        this.lstKana.add(new Kana("ち","チ", "chi", true));
        this.lstKana.add(new Kana("つ","ツ", "tsu", false));
        this.lstKana.add(new Kana("て","テ", "te", false));
        this.lstKana.add(new Kana("と","ト", "to", false));

        //DA JI ZU DE DO
        this.lstKana.add(new Kana("だ","ダ", "da", false));
        this.lstKana.add(new Kana("ぢ","ヂ", "ji", true));
        this.lstKana.add(new Kana("づ","ヅ", "zu", false));
        this.lstKana.add(new Kana("で","デ", "de", false));
        this.lstKana.add(new Kana("ど","ド", "do", false));

        //NA NI NU NE NO
        this.lstKana.add(new Kana("な","ナ", "na", false));
        this.lstKana.add(new Kana("に","ニ", "ni", true));
        this.lstKana.add(new Kana("ぬ","ヌ", "nu", false));
        this.lstKana.add(new Kana("ね","ネ", "ne", false));
        this.lstKana.add(new Kana("の","ノ", "no", false));

        //HA HI FU HE HO
        this.lstKana.add(new Kana("は","ハ", "ha", false));
        this.lstKana.add(new Kana("ひ","ヒ", "hi", true));
        this.lstKana.add(new Kana("ふ","フ", "fu", false));
        this.lstKana.add(new Kana("へ","ヘ", "he", false));
        this.lstKana.add(new Kana("ほ","ホ", "ho", false));

        //BA BI BU BE BO
        this.lstKana.add(new Kana("ば","バ", "ba", false));
        this.lstKana.add(new Kana("び","ビ", "bi", true));
        this.lstKana.add(new Kana("ぶ","ブ", "bu", false));
        this.lstKana.add(new Kana("べ","ベ", "be", false));
        this.lstKana.add(new Kana("ぼ","ボ", "bo", false));

        //PA PI PU PE PO
        this.lstKana.add(new Kana("ぱ","パ", "pa", false));
        this.lstKana.add(new Kana("ぴ","ピ", "pi", true));
        this.lstKana.add(new Kana("ぷ","プ", "pu", false));
        this.lstKana.add(new Kana("ぺ","ペ", "pe", false));
        this.lstKana.add(new Kana("ぽ","ポ", "po", false));

        //MA MI MU ME MO
        this.lstKana.add(new Kana("ま","マ", "ma", false));
        this.lstKana.add(new Kana("み","ミ", "mi", true));
        this.lstKana.add(new Kana("む","ム", "mu", false));
        this.lstKana.add(new Kana("め","メ", "me", false));
        this.lstKana.add(new Kana("も","モ", "mo", false));

        //YA    YU    YO
        this.lstKana.add(new Kana("や","ヤ", "ya", false));
        this.lstKana.add(new Kana("ゆ","ユ", "yu", false));
        this.lstKana.add(new Kana("よ","ヨ", "yo", false));

        //RA RI RU RE RO
        this.lstKana.add(new Kana("ら","ラ", "ra", false));
        this.lstKana.add(new Kana("り","リ", "ri", true));
        this.lstKana.add(new Kana("る","ル", "ru", false));
        this.lstKana.add(new Kana("れ","レ", "re", false));
        this.lstKana.add(new Kana("ろ","ロ", "ro", false));

        //WA          WO
        this.lstKana.add(new Kana("わ","ワ", "wa", false));
        this.lstKana.add(new Kana("を","ヲ", "wo", false));
        
        //N
        this.lstKana.add(new Kana("ん","ン", "n", false));
    }

    public Kana getKana(String kanaStr) {
        for (Kana k : this.lstKana) {
            if (k.getHiragana().equals(kanaStr) || k.getKatakana().equals(kanaStr)) {
                return k;
            }
        }

        return null;
    }
}
