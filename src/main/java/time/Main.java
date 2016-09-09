package time;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.io.UnsupportedEncodingException;
import java.time.LocalDateTime;
import java.util.Locale;
import java.util.ResourceBundle;


/**
 * Created by Saniye on 08.09.16.
 */
public class Main {
    private static ResourceBundle labels = ResourceBundle.getBundle("bundle.MyBundle", Locale.getDefault());
    final static Logger log = LoggerFactory.getLogger(Main.class);


    public static void timeOfTheDay() throws UnsupportedEncodingException {
        log.info("Detected user locale as {}", Locale.getDefault());
        LocalDateTime today = LocalDateTime.now();
        int hour = today.getHour();
        String message = choseGreetingMessage(hour);
        log.info("Returned message {}", message);
        printText(message);
    }

    protected static void printText(String message) {
        System.out.println(labels.getString(message));
    }

    protected static String choseGreetingMessage(int hours) {
        log.info("Current time is {}", hours);
        String str;
        if (hours >= 6 && hours < 9) {
            str = "morningMessage";
        } else if (hours >= 9 && hours < 19) {
            str = "dayMessage";
        } else if (hours >= 19 && hours < 23) {
            str = "eveningMessage";
        } else {
            str = "nightMessage";
        }
        log.info("Message \"{}\" will be printed", str);
        return str;
    }

    public static void main(String[] args) throws UnsupportedEncodingException {
        timeOfTheDay();
    }

}
