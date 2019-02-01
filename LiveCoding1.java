import java.util.*;
import java.util.function.Predicate;

public class LiveCoding1 {

    interface Trier {

        boolean garder(Integer n);
    }

    public static void main(String[] args) {

        List<Integer> numbers = new ArrayList<>(Arrays.asList(0,1,2,3,4,5,6,7,8,9,10,11,12,13,14));

        Trier pair = new Trier() {
            @Override
            public boolean garder(Integer n) {
                return n % 2 == 0;
            }
        };
        Trier premier = new Trier() {
            @Override
            public boolean garder(Integer num) {
                boolean notPrime = false;
                for (int i = 2; i <= num/2; ++i) {
                    // condition for nonprime number
                    if (num % i == 0)  {
                        notPrime = true;
                        break;
                    }
                }
                return num > 0 && !notPrime;
            }
        };

        // interfaces fonctionnelles
        Predicate<Integer> multipleTrois = new Predicate<Integer>() {
            @Override
            public boolean test(Integer n) {
                return n % 3 == 0;
            }
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
