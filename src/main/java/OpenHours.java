import java.time.DayOfWeek;
import java.util.*;

/**
 * Created by Raph513 on 28/07/16.
 */
public class OpenHours {

    private String openHour;
    private String closeHour;
    private boolean alwaysClosed;

    public OpenHours(String openHour, String closeHour){
        this.openHour = openHour;
        this.closeHour = closeHour;
        this.alwaysClosed = false;
    }

    public OpenHours(String openHour, String closeHour, boolean alwaysClosed){
        this.openHour = openHour;
        this.closeHour = closeHour;
        this.alwaysClosed = alwaysClosed;
    }

    public String getOpenHour() {
        return openHour;
    }

    public void setOpenHour(String openHour) {
        this.openHour = openHour;
    }

    public String getCloseHour() {
        return closeHour;
    }

    public void setCloseHour(String closeHour) {
        this.closeHour = closeHour;
    }

    public boolean isAlwaysClosed() {
        return alwaysClosed;
    }

    public void setAlwaysClosed(boolean alwaysClosed) {
        this.alwaysClosed = alwaysClosed;
    }
}
