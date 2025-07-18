package com.tgbrow.japanese;

import com.tgbrow.japanese.Hiragana.Vowel;

public class GodanVerb extends Verb {
    public final String base;
    public final Hiragana endingHiragana;

    public GodanVerb(String dictForm) {
        this.base = getBaseFromDictForm(dictForm);
        this.endingHiragana = getLastHiragana(dictForm);

        // Validations
        if (endingHiragana.vowel != Vowel.U) {
            throw new RuntimeException(
                "FAILURE: The final character (" + endingHiragana.character + ") does not end with う sound.");
        }
    }

    @Override
    public String dictionary() {
        final Hiragana uEnding = Hiragana.fromParts(endingHiragana.consonant, Vowel.U);
        return base + uEnding.character;
    }

    @Override
    public String polite() {
        return politeStem() + "ます";
    }

    @Override
    public String past() {
        return base + pastTenseSuffix();
    }

    @Override
    public String pastPolite() {
        return politeStem() + "ました";
    }

    @Override
    public String te() {
        return base + teSuffix();
    }

    private String politeStem() {
        final Hiragana iEnding = Hiragana.fromParts(endingHiragana.consonant, Vowel.I);
        return base + iEnding.character;
    }

    private final String pastTenseSuffix() {
        return switch (endingHiragana.consonant) {
            case NONE, T, R -> "った";
            case S -> "した";
            case K -> "いた";
            case G -> "いだ";
            case N, B, M -> "んだ";
            default -> "ø"; // TODO: throw instead
        };
    }

    private final String teSuffix() {
        return switch (endingHiragana.consonant) {
            case NONE, T, R -> "って";
            case S -> "して";
            case K -> "いて";
            case G -> "いで";
            case N, B, M -> "んで";
            default -> "ø"; // TODO: throw instead
        };
    }
}