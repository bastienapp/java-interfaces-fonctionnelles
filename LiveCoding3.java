import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class LiveCoding3 {

    private static Boolean mIsChecked = false;

    public static void main(String... args) {

        // TODO 1 : classe anonyme ?

        // TODO 2 : par dérivation
        User user = new User() {

            @Override
            public void sayMyName() {
                System.out.println("Salut " + this.getName());
            }
        };

        // TODO 3 : par implémentation d'interface
        Human humanPrevious = new Human() {
            @Override
            public String parler() {
                return "bla bla";
            }
        };

        Human human = () -> "bla bla";

        // TODO 4 : les lambdas, les différents types d'appels
        // (arguments) -> { corps de la méthode }

        // argument -> { ... }

        // () -> { ... }

        // argument -> retour de la méthode

        // interfaces fonctionnelles
        Consumer<String> testConsumer = s -> {
            if (s != null) {
                System.out.printf("Hello %s", s);
            } else {
                System.out.print("Hello World!");
            }
        };

        Supplier<Boolean> testSupplier = () -> mIsChecked;

        Function<String, Boolean> testFunction = s -> s.length() > 7;

        Predicate<Integer> predicate = num -> isPrime(num);

        List<Integer> numbers = new ArrayList<>(Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14));
        numbers = filter(numbers, predicate);
        for (int n : numbers) {
            System.out.println(n);
        }
    }

    private static <T> List<T> filter(List<T> list, Predicate trier) {
        List<T> result = new ArrayList<>();
        // TODO : forEach
        list.forEach(t -> {
            if (trier.test(t)) {
                result.add(t);
            }
        });
        return result;
    }

    private static Boolean isPrime(Integer num) {
        // TODO : create method
        boolean notPrime = false;
        for (int i = 2; i <= num / 2; ++i) {
            // condition for nonprime number
            if (num % i == 0) {
                notPrime = true;
                break;
            }
        }
        return num > 0 && !notPrime;
    }
}
