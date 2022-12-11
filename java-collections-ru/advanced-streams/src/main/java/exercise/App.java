package exercise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;

// BEGIN
class App {
    
    public static String getForwardedVariables(String config) {
        var finalEnv = new ArrayList<String>();
        Arrays.stream(config.split("\n"))
                .filter(x -> x.startsWith("environment"))
                .map(x -> x.replaceAll("(environment=|\")", ""))
                .map(x -> Arrays.stream(x.split(",")).collect(Collectors.toList()))
                .flatMap(Collection::stream).toList()
                .stream().filter(x -> x.startsWith("X_FORWARDED_"))
                .map(x -> x.replace("X_FORWARDED_", ""))
                .forEach(finalEnv::add);
        System.out.println(finalEnv);
        if (finalEnv.size() == 1) return String.join("", finalEnv);
        return String.join(",", finalEnv);
    }
}
//END
