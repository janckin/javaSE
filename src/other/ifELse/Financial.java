package other.ifELse;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.function.Function;
import java.util.function.Predicate;

/**
 * use lambda to improve calTaxIfElse method
 */
public class Financial {
    public static double calTaxIfElse(int income) {
        double tax;
        if (income <= 2200) {
            tax = 0;
        } else if (income <= 2700) {
            tax = 0.14 * (income - 2200);
        } else if (income <= 3200) {
            tax = 70 + 0.15 * (income - 2700);
        } else if (income <= 3700) {
            tax = 145 + 0.16 * (income - 3200);
        } else {
            tax = 53090 + 0.70 * (income - 102200);
        }
        return tax;
    }

    public static double calTaxHashMap(int income) {
        //build up the map to store the condition
        Map<Predicate<Integer>, Function<Double, Double>> map = initCondition(income);

        double tax = 0;
        Set<Map.Entry<Predicate<Integer>, Function<Double, Double>>> set = map.entrySet();
        for (Map.Entry<Predicate<Integer>, Function<Double, Double>> entry : set) {
            if (entry.getKey().test(income)) {
                return entry.getValue().apply(tax);
            }
        }
        return tax;
    }


    private static Map<Predicate<Integer>, Function<Double, Double>> initCondition(int income) {
        //build up the map to store the condition
        Map<Predicate<Integer>, Function<Double, Double>> map = new HashMap<>();
        map.put((x) -> x <= 2200, (tax) -> (double) 0);
        map.put((x) -> 2200 < x && x <= 2700, (tax) -> 0.14 * (income - 2200));
        map.put((x) -> 2700 < x && x <= 3200, (tax) -> 70 + 0.15 * (income - 2700));
        map.put((x) -> 3200 < x && x <= 3700, (tax) -> 145 + 0.16 * (income - 3200));
        map.put((x) -> x > 3700, (tax) -> 53090 + 0.70 * (income - 102200));
        return map;
    }

    /**
     * use simple factory pattern to solve the if-else
     * @param income income from customer
     * @return factory in map interface
     */
    public static double calTaxTreeMap(int income) {
        //build up the map to store the condition
        Map<Integer, Function<Double, Double>> map = new TreeMap<>();
        map.put(2200, (tax) -> (double) 0);
        map.put(2700, (tax) -> 0.14 * (income - 2200));
        map.put(3200, (tax) -> 70 + 0.15 * (income - 2700));
        map.put(3700, (tax) -> 145 + 0.16 * (income - 3200));
        map.put(Integer.MAX_VALUE, (tax) -> 53090 + 0.70 * (income - 102200));

        double tax = 0;
        Set<Map.Entry<Integer, Function<Double, Double>>> set = map.entrySet();
        for (Map.Entry<Integer, Function<Double, Double>> entry : set) {
            if (income <= entry.getKey()) {
                return entry.getValue().apply(tax);
            }
        }
        return tax;
    }


    public static void main(String[] args) {
        System.out.println("--------test calTaxHashMap------");

        System.out.println(calTaxIfElse(1000) == calTaxHashMap(1000));
        System.out.println(calTaxIfElse(2700) == calTaxHashMap(2700));
        System.out.println(calTaxIfElse(3200) == calTaxHashMap(3200));
        System.out.println(calTaxIfElse(3700) == calTaxHashMap(3700));
        System.out.println(calTaxIfElse(4000) == calTaxHashMap(4000));

        System.out.println("--------test calTaxTreeMap------");
        System.out.println(calTaxIfElse(1000) == calTaxTreeMap(1000));
        System.out.println(calTaxIfElse(2700) == calTaxTreeMap(2700));
        System.out.println(calTaxIfElse(3200) == calTaxTreeMap(3200));
        System.out.println(calTaxIfElse(3700) == calTaxTreeMap(3700));
        System.out.println(calTaxIfElse(4000) == calTaxTreeMap(4000));
    }
}
