package other.ifELse.strategy;

import other.ifELse.Financial;

/**
 * use strategy patter to solve the if-else problem
 */
public class Financial2 {
    public static void main(String[] args) {
        int income1 = 1000;
        int income2 = 2700;
        int income3 = 3200;
        int income4 = 3700;
        int income5 = 4000;

        System.out.println(Financial.calTaxIfElse(1000) == RegionManager.getRegionByIncome(income1).getCountTax().count(income1));
        System.out.println(Financial.calTaxIfElse(2700) == RegionManager.getRegionByIncome(income2).getCountTax().count(income2));
        System.out.println(Financial.calTaxIfElse(3200) == RegionManager.getRegionByIncome(income3).getCountTax().count(income3));
        System.out.println(Financial.calTaxIfElse(3700) == RegionManager.getRegionByIncome(income4).getCountTax().count(income4));
        System.out.println(Financial.calTaxIfElse(4000) == RegionManager.getRegionByIncome(income5).getCountTax().count(income5));
    }
}
