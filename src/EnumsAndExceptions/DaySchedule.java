package EnumsAndExceptions;

import java.util.ArrayList;
import java.util.List;

public class DaySchedule {
    DaySchedule(Day days) {
        this.days = days;
    }
    private Day days;
    private List<String> activities = new ArrayList<>();

    public Day getDays() {
        return days;
    }

    public List<String> getActivities() {
        return activities;
    }
}
