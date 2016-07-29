

import java.time.*;

import java.util.*;


/**
 * @author Hugh Glykod
 */
public class Restaurant {

    private String name;
    private Map<DayOfWeek, OpenHours> opening = new HashMap<>();
    private Clock clockNow;


    public Restaurant(String name) {
        this.name = name;
        clockNow = Clock.systemDefaultZone();
        opening.put(DayOfWeek.MONDAY, new OpenHours("09:00", "18:00"));
        opening.put(DayOfWeek.TUESDAY, new OpenHours("09:00", "18:00"));
        opening.put(DayOfWeek.WEDNESDAY, new OpenHours("09:00", "18:00"));
        opening.put(DayOfWeek.THURSDAY, new OpenHours("09:00", "18:00"));
        opening.put(DayOfWeek.FRIDAY, new OpenHours("09:00", "18:00"));
        opening.put(DayOfWeek.SATURDAY, new OpenHours("09:00", "18:00"));
        opening.put(DayOfWeek.SUNDAY, new OpenHours("00:00", "00:00", true));
    }



    public boolean isOpen(DayOfWeek day, Clock c) {
            if (opening.get(day).isAlwaysClosed()) {
                return false;
            }
            else if (LocalTime.now(c).isAfter(LocalTime.parse(opening.get(day).getOpenHour()))
                        && LocalTime.now(c).isBefore(LocalTime.parse(opening.get(day).getCloseHour()))) {
                    return true;
            } else {
                    return false;
                }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Map<DayOfWeek, OpenHours> getOpening() {
        return opening;
    }

    public void setOpening(Map<DayOfWeek, OpenHours> opening) {
        this.opening = opening;
    }

    public Clock getClockNow() {
        return clockNow;
    }

    public void setClockNow(Clock clockNow) {
        this.clockNow = clockNow;
    }
}
