package exercise;

import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

// BEGIN
class App {
	public static void main(String[] args) {
		Map<String, Object> data1 = new HashMap<>(Map.of("one", "eon", "two", "two", "four", true));
		Map<String, Object> data2 = new HashMap<>(Map.of("two", "own", "zero", 4, "four", true));
		Map<String, String> result = App.genDiff(data1, data2);
		System.out.println(result);
	}

	public static Map<String, String> genDiff(Map<String,Object> data1, Map<String,Object> data2) {
		Map<String, String> result = new TreeMap<>(Comparator.naturalOrder());
		for (String k1 : data1.keySet()) {
			for (String k2: data2.keySet()) {
				if(data1.containsKey(k2) && data2.containsKey(k1) && data1.get(k1).equals(data2.get(k2))) {
					result.put(k1, "unchanged");
				} else if (data1.containsKey(k2) && data2.containsKey(k1) && !data1.get(k1).equals(data2.get(k2))) {
					result.put(k1, "changed");
				}
				if (!data1.containsKey(k2) && data2.containsKey(k2)) result.put(k2, "added");
				if (data1.containsKey(k1) && !data2.containsKey(k1)) result.put(k1, "deleted");
			}
		}
		return result;
	}
}
//END
