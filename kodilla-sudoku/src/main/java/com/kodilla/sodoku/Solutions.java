package com.kodilla.sodoku;

import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Getter(AccessLevel.PACKAGE)
@ToString
@EqualsAndHashCode
final class Solutions {
    private Set<Board> solutionsCollector;

    Solutions() {
        this.solutionsCollector = new HashSet<>();
    }
}
