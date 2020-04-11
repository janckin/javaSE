package generic;

import java.lang.reflect.InvocationTargetException;
import java.util.Objects;
import java.util.function.Supplier;

public class Pair<T> {
    private T first;
    private T second;

    public Pair() {

    }

    public Pair(T first, T second) {
        this.first = first;
        this.second = second;
    }

    public T getFirst() {
        return first;
    }

    public void setFirst(T first) {
        this.first = first;
    }

    public T getSecond() {
        return second;
    }

    public void setSecond(T second) {
        this.second = second;
    }

    public static <U> Pair<U> init(Supplier<U> supplier) {
        return new Pair<>(supplier.get(), supplier.get());
    }

    public static <U> Pair<U> initByReflect(Class<U> uClass) {
        try {
            return new Pair<>(uClass.getDeclaredConstructor().newInstance(), uClass.getDeclaredConstructor().newInstance());
        } catch (IllegalAccessException | InstantiationException | NoSuchMethodException | InvocationTargetException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static boolean hasNull(Pair<?> pair) {
        return pair.getFirst() == null || pair.getSecond() == null;
    }

    public <U extends String> boolean equals(U value) {
        return first.equals(value) && second.equals(value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(first, second);
    }
}
