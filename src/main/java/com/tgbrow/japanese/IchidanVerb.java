package com.tgbrow.japanese;

public class IchidanVerb extends Verb {
    public final String base;

    public IchidanVerb(String dictForm) {
        this.base = getBaseFromDictForm(dictForm);

        // Validations
        final Hiragana endingHiragana = getLastHiragana(dictForm);
        if (endingHiragana != Hiragana.RU) {
            throw new RuntimeException(
                "FAILURE: The final character for an ichidan verb must be る (actual: " + endingHiragana.character + ").");
        }
    }

    @Override
    public String dictionary() {
        return base + "る";
    }

    @Override
    public String polite() {
        return base + "ます";
    }

    @Override
    public String past() {
        return base + "た";
    }

    @Override
    public String pastPolite() {
        return base + "ました";
    }

    @Override
    public String te() {
        return base + "て";
    }
    
}
