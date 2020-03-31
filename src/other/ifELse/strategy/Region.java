package other.ifELse.strategy;

import java.util.function.Predicate;

public enum Region {
    LEVEL1((x) -> x <= 2200, (income) -> (double) 0),
    LEVEL2((x) -> 2200 < x && x <= 2700, (income) -> 0.14 * (income - 2200)),
    LEVEL3((x) -> 2700 < x && x <= 3200, (income) -> 70 + 0.15 * (income - 2700)),
    LEVEL4((x) -> 3200 < x && x <= 3700, (income) -> 145 + 0.16 * (income - 3200)),
    LEVEL5((x) -> x > 3700, (income) -> 53090 + 0.70 * (income - 102200));

    private Predicate<Integer> condition;
    private CountTax countTax;

    Region(Predicate<Integer> condition, CountTax countTax) {
        this.condition = condition;
        this.countTax = countTax;
    }

    public CountTax getCountTax() {
        return countTax;
    }

    public Predicate<Integer> getCondition() {
        return condition;
    }
}
