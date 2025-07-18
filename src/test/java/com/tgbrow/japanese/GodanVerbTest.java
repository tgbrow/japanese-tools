package com.tgbrow.japanese;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class GodanVerbTest {
    @Test
    public void uEnding_allForms_success() {
        final GodanVerb v = new GodanVerb("会う");

        assertThat(v.dictionary()).isEqualTo("会う");
        assertThat(v.polite()).isEqualTo("会います");
        assertThat(v.past()).isEqualTo("会った");
        assertThat(v.pastPolite()).isEqualTo("会いました");
        assertThat(v.te()).isEqualTo("会って");
    }

    @Test
    public void tuEnding_allForms_success() {
        final GodanVerb v = new GodanVerb("立つ");

        assertThat(v.dictionary()).isEqualTo("立つ");
        assertThat(v.polite()).isEqualTo("立ちます");
        assertThat(v.past()).isEqualTo("立った");
        assertThat(v.pastPolite()).isEqualTo("立ちました");
        assertThat(v.te()).isEqualTo("立って");
    }

    @Test
    public void ruEnding_allForms_success() {
        final GodanVerb v = new GodanVerb("分かる");

        assertThat(v.dictionary()).isEqualTo("分かる");
        assertThat(v.polite()).isEqualTo("分かります");
        assertThat(v.past()).isEqualTo("分かった");
        assertThat(v.pastPolite()).isEqualTo("分かりました");
        assertThat(v.te()).isEqualTo("分かって");
    }

    @Test
    public void suEnding_allForms_success() {
        final GodanVerb v = new GodanVerb("写す");

        assertThat(v.dictionary()).isEqualTo("写す");
        assertThat(v.polite()).isEqualTo("写します");
        assertThat(v.past()).isEqualTo("写した");
        assertThat(v.pastPolite()).isEqualTo("写しました");
        assertThat(v.te()).isEqualTo("写して");
    }

    @Test
    public void kuEnding_allForms_success() {
        final GodanVerb v = new GodanVerb("聞く");

        assertThat(v.dictionary()).isEqualTo("聞く");
        assertThat(v.polite()).isEqualTo("聞きます");
        assertThat(v.past()).isEqualTo("聞いた");
        assertThat(v.pastPolite()).isEqualTo("聞きました");
        assertThat(v.te()).isEqualTo("聞いて");
    }

    @Test
    public void guEnding_allForms_success() {
        final GodanVerb v = new GodanVerb("泳ぐ");

        assertThat(v.dictionary()).isEqualTo("泳ぐ");
        assertThat(v.polite()).isEqualTo("泳ぎます");
        assertThat(v.past()).isEqualTo("泳いだ");
        assertThat(v.pastPolite()).isEqualTo("泳ぎました");
        assertThat(v.te()).isEqualTo("泳いで");
    }

    @Test
    public void nuEnding_allForms_success() {
        final GodanVerb v = new GodanVerb("死ぬ");

        assertThat(v.dictionary()).isEqualTo("死ぬ");
        assertThat(v.polite()).isEqualTo("死にます");
        assertThat(v.past()).isEqualTo("死んだ");
        assertThat(v.pastPolite()).isEqualTo("死にました");
        assertThat(v.te()).isEqualTo("死んで");
    }

    @Test
    public void buEnding_allForms_success() {
        final GodanVerb v = new GodanVerb("学ぶ");

        assertThat(v.dictionary()).isEqualTo("学ぶ");
        assertThat(v.polite()).isEqualTo("学びます");
        assertThat(v.past()).isEqualTo("学んだ");
        assertThat(v.pastPolite()).isEqualTo("学びました");
        assertThat(v.te()).isEqualTo("学んで");
    }

    @Test
    public void muEnding_allForms_success() {
        final GodanVerb v = new GodanVerb("飲む");

        assertThat(v.dictionary()).isEqualTo("飲む");
        assertThat(v.polite()).isEqualTo("飲みます");
        assertThat(v.past()).isEqualTo("飲んだ");
        assertThat(v.pastPolite()).isEqualTo("飲みました");
        assertThat(v.te()).isEqualTo("飲んで");
    }

    @Test
    public void riEnding_throws() {
        assertThatThrownBy(() -> new GodanVerb("のり"))
            .isInstanceOf(RuntimeException.class)
            .hasMessageContaining("does not end with う");
    }
}
