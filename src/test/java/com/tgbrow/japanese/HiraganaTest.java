package com.tgbrow.japanese;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import com.google.common.collect.ImmutableList;

import com.tgbrow.japanese.Hiragana.Consonant;
import com.tgbrow.japanese.Hiragana.Vowel;;

public class HiraganaTest {

    private final ImmutableList<String> SEION = ImmutableList.of(
        "あ", "い", "う", "え", "お",
        "か", "き", "く", "け", "こ",
        "さ", "し", "す", "せ", "そ",
        "た", "ち", "つ", "て", "と",
        "な", "に", "ぬ", "ね", "の",
        "は", "ひ", "ふ", "へ", "ほ",
        "ま", "み", "む", "め", "も",
        "や",       "ゆ",      "よ",
        "ら", "り", "る", "れ", "ろ",
        "わ",                  "を",
        "ん"
    );

    private final ImmutableList<String> DAKUON = ImmutableList.of(
        "が", "ぎ", "ぐ", "げ", "ご",
        "ざ", "じ", "ず", "ぜ", "ぞ",
        "だ", "ぢ", "づ", "で", "ど",
        "ば", "び", "ぶ", "べ", "ぼ" 
    );

    private final ImmutableList<String> HANDAKUON = ImmutableList.of(
        "ぱ", "ぴ", "ぷ", "ぺ", "ぽ"
    );

    private final ImmutableList<String> ALL =
        new ImmutableList.Builder<String>().addAll(SEION).addAll(DAKUON).addAll(HANDAKUON).build();

    @Test
    public void fromString_ka_comprehensive() {
        final Hiragana h = Hiragana.fromString("か");
        assertEquals("か", h.character);
        assertEquals(Consonant.K, h.consonant);
        assertEquals(Vowel.A, h.vowel);
    }

    @Test
    public void fromString_invalidInput_throws() {
        assertThrows(RuntimeException.class, () -> Hiragana.fromString("invalid"));
    }

    @Test
    public void fromString_allValidInputs_success() {
        for (String s : ALL) {
            // Not throwing is a success.
            Hiragana.fromString(s);
        }
    }

    @Test
    public void fromParts_ka_comprehensive() {
        final Hiragana h = Hiragana.fromParts(Consonant.K, Vowel.A);
        assertEquals("か", h.character);
        assertEquals(Consonant.K, h.consonant);
        assertEquals(Vowel.A, h.vowel);
    }

    @Test
    public void fromParts_invalidInput_throws() {
        assertThrows(RuntimeException.class, () -> Hiragana.fromParts(Consonant.Y, Vowel.I));
    }

    @Test
    public void fromParts_various_success() {
        final Hiragana tsu = Hiragana.fromParts(Consonant.T, Vowel.U);
        assertEquals(Hiragana.TSU, tsu);

        final Hiragana ga = Hiragana.fromParts(Consonant.G, Vowel.A);
        assertEquals(Hiragana.GA, ga);

        final Hiragana wo = Hiragana.fromParts(Consonant.W, Vowel.O);
        assertEquals(Hiragana.WO, wo);
    }
    
}
