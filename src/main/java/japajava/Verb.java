package japajava;

public abstract class Verb {
    public abstract String dictionary();
    public abstract String polite();
    public abstract String past();
    public abstract String pastPolite();
    public abstract String te();

    protected static String getBaseFromDictForm(String dictFormClean) {
        return dictFormClean.substring(0, indexOfLastCodePoint(dictFormClean));
    }

    public static Hiragana getLastHiragana(String dictFormClean) {
        final String lastChar = dictFormClean.substring(indexOfLastCodePoint(dictFormClean));
        return Hiragana.fromString(lastChar);
    }

    private static int indexOfLastCodePoint(String s) {
        final int numCodePoints = s.codePointCount(0, s.length());
        return s.offsetByCodePoints(0, numCodePoints - 1);
    }
}
