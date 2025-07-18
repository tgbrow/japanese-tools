package japajava;

public class IrregularVerb extends Verb {
    public final static IrregularVerb IKU = new IrregularVerb(
        "行く",
        "行きます",
        "行った",
        "行きました");
    public final static IrregularVerb KURU = new IrregularVerb(
        "来る",
        "来ます",
        "来た",
        "来ました");
    public final static IrregularVerb SURU = new IrregularVerb(
        "する",
        "します",
        "した",
        "しました");

    private final String dictionary;
    private final String polite;
    private final String past;
    private final String pastPolite;

    private IrregularVerb(String dictionary, String polite, String past, String pastPolite) {
        this.dictionary = dictionary;
        this.polite = polite;
        this.past = past;
        this.pastPolite = pastPolite;
    }

    @Override
    public String dictionary() {
        return dictionary;
    }

    @Override
    public String polite() {
        return polite;
    }

    @Override
    public String past() {
        return past;
    }

    @Override
    public String pastPolite() {
        return pastPolite;
    }
    
}
