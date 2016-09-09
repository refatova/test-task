package time;

import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDateTime;
import java.util.Locale;
import java.util.ResourceBundle;

/**
 * Created by Saniye on 09.09.16.
 */


public class TimeTest extends Assert {


    @Test
    public void defaultLocaleTest() {
        Locale china = new Locale("zh");
        Locale.setDefault(china);
        ResourceBundle labels = ResourceBundle.getBundle(Main.LOCALISATION_BUNDLE, china);
        assertEquals("Good morning, World!", labels.getString(Main.MORNING_MESSAGE));
        assertEquals("Good day, World!", labels.getString(Main.DAY_MESSAGE));
        assertEquals("Good evening, World!", labels.getString(Main.EVENING_MESSAGE));
        assertEquals("Good night, World!", labels.getString(Main.NIGHT_MESSAGE));
    }

    @Test
    public void morningGreetingTest() {
        Main m = new Main();
        assertEquals(Main.MORNING_MESSAGE, m.chooseGreetingMessage(6));
        assertFalse(Main.MORNING_MESSAGE.equals(m.chooseGreetingMessage(9)));
    }

    @Test
    public void dayGreetingTest() {
        Main m = new Main();
        assertEquals(Main.DAY_MESSAGE, m.chooseGreetingMessage(9));
        assertFalse(Main.DAY_MESSAGE.equals(m.chooseGreetingMessage(19)));
    }

    @Test
    public void eveningGreetingTest() {
        Main m = new Main();
        assertEquals(Main.EVENING_MESSAGE, m.chooseGreetingMessage(19));
        assertFalse(Main.EVENING_MESSAGE.equals(m.chooseGreetingMessage(23)));
    }

    @Test
    public void nightGreetingTest() {
        Main m = new Main();
        assertEquals(Main.NIGHT_MESSAGE, m.chooseGreetingMessage(23));
        assertTrue(Main.NIGHT_MESSAGE.equals(m.chooseGreetingMessage(5)));
        assertFalse("6 a.m isn't included to night time", Main.NIGHT_MESSAGE.equals(m.chooseGreetingMessage(6)));
    }

    @Test
    public void getMessageByTimeTest() {
        Main m = new Main();
        LocalDateTime time = LocalDateTime.now();
        time = time.withHour(9);   //Set time in range [9,19)
        assertEquals(Main.DAY_MESSAGE, m.getMessageByTime(time));

        time = time.withHour(7);  //Set time in range [6,9)
        assertEquals(Main.MORNING_MESSAGE, m.getMessageByTime(time));

        time = time.withHour(9);  //Set time in range [6,9)
        assertFalse(Main.MORNING_MESSAGE.equals(m.getMessageByTime(time)));

        time = time.withHour(19);//Set time in range [19,23)
        assertEquals(Main.EVENING_MESSAGE, m.getMessageByTime(time));

        time = time.withHour(5);//Set time in range [23,6)
        assertEquals(Main.NIGHT_MESSAGE, m.getMessageByTime(time));

        time = time.withHour(23);//Set time in range [23,6)
        assertEquals(Main.NIGHT_MESSAGE, m.getMessageByTime(time));
    }

}
