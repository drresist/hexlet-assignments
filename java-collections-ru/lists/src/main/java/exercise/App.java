package exercise;

import java.util.Arrays;
import java.util.ArrayList;

// BEGIN

class App {
  public static boolean scrabble(String symbols, String word) {
    if (symbols.length() == 0 || symbols.length() < word.length())
      return false;
    int counter = 0;
    String lowerWord = word.toLowerCase();
    var symbolList = new ArrayList<String>(Arrays.asList(symbols.toLowerCase().split("")));
    for (String w : lowerWord.split("")) {
      if (symbolList.contains(w)) {
        symbolList.remove(w);
        counter += 1;
      }
    }

    if (counter >= word.length())
      return true;
    return false;
  }
}

// END
