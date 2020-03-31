package other.ifELse.strategy;

import java.util.function.Predicate;

public class RegionManager {
    public static Region getRegionByIncome(int income) throws RuntimeException{
        Region result = null;
        Region[] regions = Region.values();
        for (Region region :regions){
            Predicate<Integer> predicate = region.getCondition();
            if(predicate.test(income)){
                result = region;
                break;
            }
        }
        if(result == null){
            throw new RuntimeException();
        }
        return result;
    }
}
