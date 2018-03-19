package com.kodilla.sodoku;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@ToString
@EqualsAndHashCode
class Solutions {
    private Set<SudokuBoard> solutionsCollector;

    Solutions() {
        this.solutionsCollector = new HashSet<>();
    }
}
