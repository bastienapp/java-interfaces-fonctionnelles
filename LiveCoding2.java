import java.util.*;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class LiveCoding2 {

    public static void main(String... args) {

        List<Integer> numbers = new ArrayList<>(Arrays.asList(0,1,2,3,4,5,6,7,8,9,10,11,12,13,14));

        Consumer<String> testConsumer = new Consumer<String>() {
            @Override
            public void accept(String s) {

            }
        };

        Supplier<Boolean> testSupplier = new Supplier<Boolean>() {
            @Override
            public Boolean get() {
                return null;
            }
        };

        Function<String, Boolean> testFunction = new Function<String, Boolean>() {
            @Override
            public Boolean apply(String s) {
                return null;
            }
        };

        // interfaces fonctionnelles
        Predicate<Integer> multipleTrois = num -> {

            boolean notPrime = false;
            for (int i = 2; i <= num/2; ++i) {
                // condition for nonprime number
                if (num % i == 0)  {
                    notPrime = true;
                    break;
                }
            }
            return num > 0 && !notPrime;
        };

        numbers = filter(numbers, multipleTrois);
        for (int n : numbers) {
            System.out.println(n);
        }
    }

    public static <T> List<T> filter(List<T> list, Predicate trier) {
        List<T> result = new ArrayList<>();
        for (T n : list) {
            if (trier.test(n)) {
                result.add(n);
            }
        }
        return result;
    }
}
