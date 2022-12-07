package exercise;

import java.util.*;
import java.time.LocalDate;
import java.util.stream.Collectors;

// BEGIN
class Sorter {


    public static List<String> takeOldestMans(List<Map<String, String>> users) {
        return users.stream()
                .filter(user -> user.get("gender").equals("male"))
                .sorted(Comparator.comparing(
                        m -> LocalDate.parse(m.get("birthday")),
                        Comparator.nullsLast(Comparator.naturalOrder())))
                .map(e -> e.get("name"))
                .toList();
    }
}
// END
