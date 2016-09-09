package time;

import org.junit.Assert;
import org.junit.Test;

import java.util.Locale;
import java.util.ResourceBundle;

/**
 * Created by Saniye on 09.09.16.
 */


public class TimeTest extends Assert {
    Locale defaultLoc = Locale.getDefault();
    Locale ukr_loc = new Locale("uk", "UA");
    Locale ru_loc = new Locale("ru");
    Locale ko_loc = new Locale("ko");

    @Test
    public void defaultLocaleTest() {
        Locale china = new Locale("zh");
        Locale.setDefault(china);
        ResourceBundle labels = ResourceBundle.getBundle("bundle.MyBundle", china);

        assertEquals("Good morning, World!", labels.getString("morningMessage"));
        assertEquals("Good day, World!", labels.getString("dayMessage"));
        assertEquals("Good evening, World!", labels.getString("eveningMessage"));
        assertEquals("Good night, World!", labels.getString("nightMessage"));
    }

//    @Test
//    public void enLocaleTest() {
//        Locale eng = new Locale("en");
//        ResourceBundle labels = ResourceBundle.getBundle("bundle.MyBundle", eng);
//        assertEquals("Good morning, World!", labels.getString("1"));
//        assertEquals("Good day, World!", labels.getString("2"));
//        assertEquals("Good evening, World!", labels.getString("3"));
//        assertEquals("Good night, World!", labels.getString("4"));
//    }

//    @Test
//    public void ruLocaleTest() {
//        Locale ru_loc = new Locale("ru");
//        ResourceBundle labels = ResourceBundle.getBundle("bundle.MyBundle", ru_loc);
//        assertEquals("Доброе утро, земляне!", labels.getString("1"));
//        assertEquals("Добрый день, земляне!", labels.getString("2"));
//        assertEquals("Добрый вечер, земляне!", labels.getString("3"));
//        assertEquals("Доброй ночи, земляне!", labels.getString("4"));
//    }

//    @Test
//    public void uaLocaleTest() {
//        Locale ukr_loc = new Locale("uk", "UA");
//        ResourceBundle labels = ResourceBundle.getBundle("bundle.MyBundle", ukr_loc);
//        assertEquals("Доброго ранку!", labels.getString("1"));
//        assertEquals("Добрий день!", labels.getString("2"));
//        assertEquals("Добрий вечiр!", labels.getString("3"));
//        assertEquals("Надобранiч!", labels.getString("4"));
//
//    }

    @Test
    public void morningGreetingTest() {
        Main m = new Main();
        assertEquals("morningMessage", m.choseGreetingMessage(6));
        assertFalse("morningMessage".equals(m.choseGreetingMessage(9)));
    }

    @Test
    public void dayGreetingTest() {
        Main m = new Main();
        assertEquals("dayMessage", m.choseGreetingMessage(9));
        assertFalse("dayMessage".equals(m.choseGreetingMessage(19)));
    }

    @Test
    public void eveningGreetingTest() {
        Main m = new Main();
        assertEquals("eveningMessage", m.choseGreetingMessage(19));
        assertFalse("eveningMessage".equals(m.choseGreetingMessage(23)));
    }

    @Test
    public void nightGreetingTest() {
        Main m = new Main();
        assertEquals("nightMessage", m.choseGreetingMessage(23));
        assertTrue("nightMessage".equals(m.choseGreetingMessage(5)));
        assertFalse("6 a.m isn't included to night time","nightMessage".equals(m.choseGreetingMessage(6)));
    }
}
