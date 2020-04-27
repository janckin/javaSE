package testStream.group;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.toSet;

public class TestGroup {
    public static void main(String[] args) {
        common();

        testGroupingBy();

        testPartitioningBy();

        testGroupingByOther();

        testMappingInGroup();
    }

    public static void common() {
        //3 apple, 2 banana, others 1
        List<String> items =
                Arrays.asList("apple", "apple", "banana",
                        "apple", "orange", "banana", "papaya");
        Map<String, Long> result =
                items.stream().collect(
                        Collectors.groupingBy(
                                Function.identity(), Collectors.counting()
                        )
                );
        System.out.println(result);
    }

    //无参grouping by只能获取到自身
    public static void testGroupingBy() {
        Stream<Country> countryStream = init();
        Map<Integer, List<Country>> mapCountry = countryStream.collect(Collectors.groupingBy(Country::getId));
        mapCountry.forEach((key, value) -> {
            System.out.println(key + " : ");
            value.forEach(System.out::println);
        });
    }

    public static void testPartitioningBy() {
        Stream<Country> countryStream = init();
        Map<Boolean, List<Country>> mapCountry = countryStream.collect(Collectors.partitioningBy((country) -> country.getId() == 1));
        List<Country> ukList = mapCountry.get(true);
        ukList.forEach(System.out::println);
    }

    public static void testGroupingByOther() {
        Stream<Country> countryStream = init();
        //Map<Integer, Set<Country>> mapCountry = countryStream.collect(Collectors.groupingBy(Country::getId,toSet()));
        System.out.println(">> test counting >>");
        Map<Integer, Long> mapCountryNum = countryStream.collect(Collectors.groupingBy(Country::getId, counting()));
        mapCountryNum.forEach((key, value) -> System.out.println(key + " : " + value));
    }

    public static void testMappingInGroup() {
        Stream<Country> countryStream = init();
        Map<Integer, Set<Language>> mapCountryNum = countryStream.collect(
                Collectors.groupingBy(Country::getId, Collectors.mapping(Country::getLanguage,toSet())));
        mapCountryNum.forEach((key, value) -> System.out.println(key + " : " + value));
    }


    public static Stream<Country> init() {
        Country country5 = new Country(1, "uk", new Language("al_en"));
        Country country2 = new Country(0, "usa", new Language("tx_en"));
        Country country = new Country(0, "usa", new Language("la_en"));
        Country country8 = new Country(2, "prc", new Language("bj_ch"));
        Country country3 = new Country(0, "usa", new Language("ny_en"));
        Country country4 = new Country(0, "usa", new Language("wdc_en"));
        Country country6 = new Country(1, "uk", new Language("en_en"));
        Country country9 = new Country(2, "prc", new Language("sh_ch"));
        Country country7 = new Country(1, "uk", new Language("sc_en"));


        return Stream.of(country, country2, country3, country4, country5, country6, country7, country8, country9);
    }
}
