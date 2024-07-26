package org.example.annotation;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;

public class TagTest {

    @Test
    @DisplayName("태그 사용하기 fast 1")
    @Tag("fast")
    void use_tag_1() {
        System.out.println("태그 사용하기 fase 1");
    }

    @Test
    @DisplayName("태그 사용하기 fast 2")
    @Tag("fast")
    void use_tag_2() {
        System.out.println("태그 사용하기 fase 2");
    }

    @Test
    @DisplayName("태그 사용하기 slwo 1")
    @Tag("slow")
    void use_tag_3() {
        System.out.println("태그 사용하기 slow 1");
    }

    @Test
    @DisplayName("태그 사용하기 fast, high")
    @Tags({
            @Tag("fast"),
            @Tag("high")
    })
    void use_tag_4() {
        System.out.println("태그 사용하기 fast, high");
    }
}
