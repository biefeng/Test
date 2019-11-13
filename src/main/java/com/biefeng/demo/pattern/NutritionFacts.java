package com.biefeng.demo.pattern;

public final class NutritionFacts {

    private final int servingSize;
    private final int servings;
    private final int fat;

    public static class Builder {
        private int servingSize;
        private int servings;
        private int fat;

        public Builder(int servingSize, int servings) {
            this.servings = servings;
            this.servingSize = servingSize;
        }

        public Builder fat(int fat) {
            this.fat = fat;
            return this;
        }

        public NutritionFacts build() {
            return new NutritionFacts(this);
        }
    }

    public NutritionFacts(Builder builder) {
        servings = builder.servings;
        servingSize = builder.servingSize;
        fat = builder.fat;
    }

    public static void main(String[] args) {
        NutritionFacts nutritionFacts = new NutritionFacts.Builder(1, 2).build();
    }
}
