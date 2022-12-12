package exercise;

import java.util.*;

// BEGIN
class App {


    public static Map<String, String> genDiff(Map<String, Object> data1, Map<String, Object> data2) {
        Map<String, String> result = new TreeMap<>(Comparator.naturalOrder());
        HashSet<String> keySet = new HashSet<>();
        keySet.addAll(data1.keySet());
        keySet.addAll(data2.keySet());

        for (String k : keySet) {
            if (data1.containsKey(k) && data2.containsKey(k) && data1.get(k).equals(data2.get(k)))
                result.put(k, "unchanged");
            if (data1.containsKey(k) && data2.containsKey(k) && !data1.get(k).equals(data2.get(k)))
                result.put(k, "changed");
            if (data1.containsKey(k) && !data2.containsKey(k)) result.put(k, "deleted");
            if (data2.containsKey(k) && !data1.containsKey(k)) result.put(k, "added");
        }

        return result;
    }
}
//END
