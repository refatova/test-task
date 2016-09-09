package time;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDateTime;
import java.util.Locale;
import java.util.ResourceBundle;


/**
 * Created by Saniye on 08.09.16.
 */
public class Main {
    static final String MORNING_MESSAGE = "morningMessage";
    static final String DAY_MESSAGE = "dayMessage";
    static final String EVENING_MESSAGE = "eveningMessage";
    static final String NIGHT_MESSAGE = "nightMessage";
    static final String LOCALISATION_BUNDLE = "bundle.MyBundle";
    private static ResourceBundle labels = ResourceBundle.getBundle(LOCALISATION_BUNDLE, Locale.getDefault());
    private static final Logger log = LoggerFactory.getLogger(Main.class);


    String getMessageByTime(LocalDateTime today) {
        int hour = today.getHour();
        String message = chooseGreetingMessage(hour);
        log.info("Returned message {}", message);
        return message;
    }

    private void printLocalisedText(String message) {
        System.out.println(labels.getString(message));
    }

    String chooseGreetingMessage(int hours) {
        log.info("Choose message for {} hour(s)", hours);
        String str;
        if (hours >= 6 && hours < 9) {
            str = MORNING_MESSAGE;
        } else if (hours >= 9 && hours < 19) {
            str = DAY_MESSAGE;
        } else if (hours >= 19 && hours < 23) {
            str = EVENING_MESSAGE;
        } else {
            str = NIGHT_MESSAGE;
        }
        log.info("Message \"{}\" will be printed", str);
        return str;
    }

    public static void main(String[] args) {
        Main main = new Main();
        log.info("Detected user locale is {}", Locale.getDefault());
        String key = main.getMessageByTime(LocalDateTime.now());
        main.printLocalisedText(key);
    }

}
