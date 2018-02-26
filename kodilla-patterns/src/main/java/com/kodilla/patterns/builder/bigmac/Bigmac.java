package com.kodilla.patterns.builder.bigmac;

import lombok.Getter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Getter
@ToString
public final class Bigmac {
    private final String roll;
    private final int burgers;
    private final String sauce;
    private final List<String> ingredients;

    public static class BigmacBuilder {
        private String roll;
        private int burgers;
        private String sauce;
        private List<String> ingredients = new ArrayList<>();

        public BigmacBuilder roll(String roll) {
            this.roll = roll;
            return this;
        }

        public BigmacBuilder burgers(int number) {
            this.burgers = number;
            return this;
        }

        public BigmacBuilder sauce(SauceEnum sauce) {
            this.sauce = sauce.toString().toLowerCase();
            return this;
        }

        public BigmacBuilder ingredients(IngredientsEnum ingredient) {
            this.ingredients.add(ingredient.toString().toLowerCase());
            return this;
        }

        public Bigmac build() {
            return new Bigmac(roll, burgers, sauce, ingredients);
        }
    }

    public enum IngredientsEnum {
        LETTUCE, ONION, BACON, CUCUMBER, CHILLI, MUSHROOMS, SHRIMPS, CHEES;
    }

    public enum SauceEnum {
        STANDARD, _1000ISLAND, BARBECUE, GARLICKY
    }

    private Bigmac(String roll, int burgers, String sauce, List<String> ingredients) {
        this.roll = roll;
        this.burgers = burgers;
        this.sauce = sauce;
        this.ingredients = new ArrayList<>(ingredients);
    }
}
