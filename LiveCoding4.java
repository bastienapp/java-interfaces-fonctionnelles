import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class LiveCoding4 {

    public static void main(String... args) {

        List<Integer> numbers = new ArrayList<>(Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14));
        // TODO : filtrer avec des streams, puis multiplier le résultat par deux

        numbers.stream()
                // TODO : Opérations intermédiares (ex: filter, map)
                .filter(n -> isPrime(n))
                .map(n -> n * 2)
                // TODO : Opérations terminales (ex: forEach, count, collect, reduce)
                .forEach(n -> System.out.println(n));

        // TODO : récupérer la liste des nom des utilisateurs
        // TODO : trier par nom, puis par age
        User b = new User("b", 14);
        User a = new User("a", 16);
        User c = new User("c", 15);

        List<User> users = new ArrayList<>(Arrays.asList(b, a, c));
        users.stream()
                /*.sorted((user1, user2) -> {
                    // 1 : après
                    // 0 : identique
                    // -1 : avant
                    return user1.getName().compareTo(user2.getName());
                })*/
                .sorted((user, t1) -> Integer.compare(t1.getAge(), user.getAge()))
                .forEach(u -> System.out.println(u.getName()));

        List<String> userNames = users.stream()
                .map(user -> user.getName())
                .collect(Collectors.toList());
        userNames.forEach(s -> System.out.println(s));
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