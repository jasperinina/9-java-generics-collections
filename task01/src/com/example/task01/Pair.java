package com.example.task01;

import java.util.Objects;
import java.util.function.BiConsumer;

public class Pair<F, S> {
    private final F FirstValue;
    private final S SecondValue;

    private Pair(F firstValue, S secondValue) {
        FirstValue = firstValue;
        SecondValue = secondValue;
    }

    public static <F, S> Pair<F, S> of(F firstValue, S secondValue) {
        return new Pair<>(firstValue, secondValue);
    }

    public F getFirst() {
        return FirstValue;
    }

    public S getSecond() {
        return SecondValue;
    }

    public void ifPresent(BiConsumer<? super F, ? super S> biConsumer) {
        if (FirstValue != null && SecondValue != null) biConsumer.accept(FirstValue, SecondValue);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || this.getClass() != obj.getClass()) return false;

        Pair<?, ?> pair = (Pair<?, ?>) obj;

        return Objects.equals(FirstValue, pair.FirstValue) && Objects.equals(SecondValue, pair.SecondValue);
    }

    @Override
    public int hashCode() {
        return Objects.hash(FirstValue, SecondValue);
    }
}