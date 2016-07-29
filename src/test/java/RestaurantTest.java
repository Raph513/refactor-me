
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.time.*;


import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

/**
 * @author Hugh Glykod
 */
public class RestaurantTest {

    private Restaurant myRestaurant;

    @Before
    public void setup() {
        myRestaurant = new Restaurant("sushiShop");
    }

    @After
    public void tearDown() {

    }

    @Test
    public void testClockNowIsNotNull(){
        assertNotNull(myRestaurant.getClockNow());
    }

    @Test
    public void testClockNowIsRealTime(){
        assertTrue(myRestaurant.getClockNow().equals(Clock.systemDefaultZone()));
    }

    @Test
    public void testDefaultOpeningHours() {

        Clock clockFixedShouldBeOpen = Clock.fixed(Instant.parse("2016-07-06T12:00:00Z"), ZoneId.systemDefault());
        Clock clockFixedShouldBeClose = Clock.fixed(Instant.parse("2016-07-06T00:00:00Z"), ZoneId.systemDefault());

        assertThat("restaurant is open", myRestaurant.isOpen(DayOfWeek.MONDAY, clockFixedShouldBeOpen), is(true));
        assertThat("restaurant is open", myRestaurant.isOpen(DayOfWeek.MONDAY, clockFixedShouldBeClose), is(false));

        assertThat("restaurant is open", myRestaurant.isOpen(DayOfWeek.FRIDAY, clockFixedShouldBeOpen), is(true));
        assertThat("restaurant is open", myRestaurant.isOpen(DayOfWeek.FRIDAY, clockFixedShouldBeClose), is(false));

        assertThat("restaurant is open", myRestaurant.isOpen(DayOfWeek.SUNDAY, clockFixedShouldBeOpen), is(false));

    }
}
