package com.tgbrow.japanese;

public class IrregularVerb extends Verb {
    public final static IrregularVerb IKU = new IrregularVerb(
        "行く",
        "行きます",
        "行った",
        "行きました",
        "行って");
    public final static IrregularVerb KURU = new IrregularVerb(
        "来る",
        "来ます",
        "来た",
        "来ました",
        "来て");
    public final static IrregularVerb SURU = new IrregularVerb(
        "する",
        "します",
        "した",
        "しました",
        "して");

    private final String dictionary;
    private final String polite;
    private final String past;
    private final String pastPolite;
    private final String te;

    private IrregularVerb(String dictionary, String polite, String past, String pastPolite, String te) {
        this.dictionary = dictionary;
        this.polite = polite;
        this.past = past;
        this.pastPolite = pastPolite;
        this.te = te;
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

    @Override
    public String te() {
        return te;
    }
    
}
