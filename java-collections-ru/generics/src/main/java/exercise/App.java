package exercise;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.Map.Entry;

// BEGIN
class App {
    public static List<Map<String, String>> findWhere(List<Map<String, String>> books, Map<String, String> where) {
        List<Map<String, String>> findedBooks = new ArrayList<>();
        for (Map<String, String> book : books) {
            var counter = 0;
            for (String attribute : where.keySet()) {

                if (book.get(attribute).equals(where.get(attribute))) {
                    counter += 1;
                }
                if (counter == where.keySet().size()) {
                    findedBooks.add(book);
                }
            }
        }
        return findedBooks;
    }
}
//END
