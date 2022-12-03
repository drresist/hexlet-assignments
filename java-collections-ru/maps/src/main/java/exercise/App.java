package exercise;

import java.util.HashMap;
import java.util.Map;

// BEGIN
public class App {

  public static Map<String, Integer> getWordCount(String words) {
    Map<String, Integer> wordCounter = new HashMap<>();
    if (words.length() == 0) return wordCounter; 
    String[] wordList = words.split(" ");

    for (String w : wordList) {
      int counter = 0;
      for (String wString : wordList) {
        if (w.equals(wString)) {
          counter += 1;
        }
      }
      wordCounter.put(w, counter);
    }
    return wordCounter;
  }

  public static String toString(Map<String, Integer> wordCount) {
    if (wordCount.isEmpty()) return "{}"; 
    StringBuilder stBuilder = new StringBuilder();
    stBuilder.append("{\n");
    for (Map.Entry<String, Integer> word : wordCount.entrySet()) {
      stBuilder.append("  ").append(word.getKey()).append(": ").append(word.getValue()+"\n");
    } 
    stBuilder.append("}");
    System.out.println(stBuilder.toString());
    return stBuilder.toString();
  }

}
// END
