package exercise;

import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

// BEGIN
class App {
    private static boolean checkFreeMail(String mail) {
        var freeMailList = List.of("gmail.com", "yandex.ru", "hotmail.com");
        for (String freeMail: freeMailList) {
            if (mail.endsWith(freeMail)) return true;
        }
        return false;
    }
    public static int getCountOfFreeEmails(List<String> emails) {
        return (int) emails.stream()
                .filter(App::checkFreeMail)
                .count();
    }
}
// END
