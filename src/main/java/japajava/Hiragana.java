package japajava;

import java.util.HashMap;
import java.util.Map;

import com.google.common.collect.ImmutableMap;

public enum Hiragana {

    // --- SEION ---

    A("あ", Consonant.NONE, Vowel.A),
    I("い", Consonant.NONE, Vowel.I),
    U("う", Consonant.NONE, Vowel.U),
    E("え", Consonant.NONE, Vowel.E),
    O("お", Consonant.NONE, Vowel.O),

    KA("か", Consonant.K, Vowel.A),
    KI("き", Consonant.K, Vowel.I),
    KU("く", Consonant.K, Vowel.U),
    KE("け", Consonant.K, Vowel.E),
    KO("こ", Consonant.K, Vowel.O),

    SA("さ", Consonant.S, Vowel.A),
    SHI("し", Consonant.S, Vowel.I),
    SU("す", Consonant.S, Vowel.U),
    SE("せ", Consonant.S, Vowel.E),
    SO("そ", Consonant.S, Vowel.O),

    TA("た", Consonant.T, Vowel.A),
    CHI("ち", Consonant.T, Vowel.I),
    TSU("つ", Consonant.T, Vowel.U),
    TE("て", Consonant.T, Vowel.E),
    TO("と", Consonant.T, Vowel.O),

    NA("な", Consonant.N, Vowel.A),
    NI("に", Consonant.N, Vowel.I),
    NU("ぬ", Consonant.N, Vowel.U),
    NE("ね", Consonant.N, Vowel.E),
    NO("の", Consonant.N, Vowel.O),

    HA("は", Consonant.H, Vowel.A),
    HI("ひ", Consonant.H, Vowel.I),
    HU("ふ", Consonant.H, Vowel.U),
    HE("へ", Consonant.H, Vowel.E),
    HO("ほ", Consonant.H, Vowel.O),

    MA("ま", Consonant.M, Vowel.A),
    MI("み", Consonant.M, Vowel.I),
    MU("む", Consonant.M, Vowel.U),
    ME("め", Consonant.M, Vowel.E),
    MO("も", Consonant.M, Vowel.O),

    YA("や", Consonant.Y, Vowel.A),
    YU("ゆ", Consonant.Y, Vowel.U),
    YO("よ", Consonant.Y, Vowel.O),

    RA("ら", Consonant.R, Vowel.A),
    RI("り", Consonant.R, Vowel.I),
    RU("る", Consonant.R, Vowel.U),
    RE("れ", Consonant.R, Vowel.E),
    RO("ろ", Consonant.R, Vowel.O),

    WA("わ", Consonant.W, Vowel.A),
    WO("を", Consonant.W, Vowel.O),

    NN("ん", Consonant.NN, Vowel.NONE),

    // --- DAKUON ---

    GA("が", Consonant.G, Vowel.A),
    GI("ぎ", Consonant.G, Vowel.I),
    GU("ぐ", Consonant.G, Vowel.U),
    GE("げ", Consonant.G, Vowel.E),
    GO("ご", Consonant.G, Vowel.O),

    ZA("ざ", Consonant.Z, Vowel.A),
    JI("じ", Consonant.Z, Vowel.I),
    ZU("ず", Consonant.Z, Vowel.U),
    ZE("ぜ", Consonant.Z, Vowel.E),
    ZO("ぞ", Consonant.Z, Vowel.O),

    DA("だ", Consonant.D, Vowel.A),
    DI("ぢ", Consonant.D, Vowel.I),
    DU("づ", Consonant.D, Vowel.U),
    DE("で", Consonant.D, Vowel.E),
    DO("ど", Consonant.D, Vowel.O),

    BA("ば", Consonant.B, Vowel.A),
    BI("び", Consonant.B, Vowel.I),
    BU("ぶ", Consonant.B, Vowel.U),
    BE("べ", Consonant.B, Vowel.E),
    BO("ぼ", Consonant.B, Vowel.O),

    // --- HANDAKUON ---

    PA("ぱ", Consonant.P, Vowel.A),
    PI("ぴ", Consonant.P, Vowel.I),
    PU("ぷ", Consonant.P, Vowel.U),
    PE("ぺ", Consonant.P, Vowel.E),
    PO("ぽ", Consonant.P, Vowel.O);

    public final String character;
    public final Consonant consonant;
    public final Vowel vowel;

    public static final ImmutableMap<String, Hiragana> LOOKUP_BY_STR;
    static {
        Map<String, Hiragana> m = new HashMap<>();
        for (Hiragana h : Hiragana.values()) {
            m.put(h.character, h);
        }
        LOOKUP_BY_STR = ImmutableMap.copyOf(m);
    }

    public static final ImmutableMap<Parts, Hiragana> LOOKUP_BY_PARTS;
    static {
        Map<Parts, Hiragana> m = new HashMap<>();
        for (Hiragana h : Hiragana.values()) {
            m.put(new Parts(h.consonant, h.vowel), h);
        }
        LOOKUP_BY_PARTS = ImmutableMap.copyOf(m);
    }

    public static Hiragana fromString(String s) {
        final Hiragana result = LOOKUP_BY_STR.get(s);
        if (result != null) {
            return result;
        }
        throw new RuntimeException("The string is not a hiragana character! : " + s);
    }

    public static Hiragana fromParts(Consonant c, Vowel v) {
        final Hiragana result = LOOKUP_BY_PARTS.get(new Parts(c, v));
        if (result != null) {
            return result;
        }
        throw new RuntimeException("The parts don't form a hiragana character! : " + c + " + " + v);
    }

    private Hiragana(String character, Consonant consonant, Vowel vowel) {
        this.character = character;
        this.consonant = consonant;
        this.vowel = vowel;
    }

    public static enum Consonant {
        NONE, K, S, T, N, H, M, Y, R, W, G, Z, D, B, P, NN;
    }

    public static enum Vowel {
        A, I, U, E, O, NONE;
    }

    private record Parts(Consonant c, Vowel v) {}
}
