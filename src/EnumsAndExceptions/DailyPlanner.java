package EnumsAndExceptions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DailyPlanner {
    private List<DaySchedule> planner = new ArrayList<>();

    public DailyPlanner() {
        this.planner = planner;
    }

    public void addActivity(Day day, String action) {
        if (action == null || action.isEmpty()) {
            throw new NoActivityException("Nicio activitate");
        }
        DaySchedule daySchedule = null;
        for (DaySchedule daySchedule1 : planner) {
            if (daySchedule1.getDays().equals(day)) {
                daySchedule = daySchedule1;
                break;
            }
        }
        if (daySchedule == null) {
            daySchedule = new DaySchedule(day);
            planner.add(daySchedule);
        }
        daySchedule.getActivities().add(action);
    }

    public void removeActivity(Day day, String action) {
        if (action == null || action.isEmpty()) {
            throw new NoActivityException("Nicio activitate");
        }
        for (DaySchedule daySchedule : planner) {
            if (daySchedule.getDays().equals(day)) {
                daySchedule.getActivities().remove(action);
                break;
            }
        }
    }

    public List<String> printActivities(Day day) {
        List<String> myList = new ArrayList<>();
        for (DaySchedule schedule : planner) {
            if (schedule.getDays() == day) {
                myList.addAll(schedule.getActivities());
            }
        }
        return myList;
    }

    public Map<Day, List<String>> endPlanning() throws NoActivitiesForDayException {
        Map<Day, List<String>> myMap = new HashMap<>();
        for (DaySchedule m1 : planner) {
            myMap.put(m1.getDays(), m1.getActivities());
            if(m1.getActivities().isEmpty()){
                throw new NoActivitiesForDayException("Nicio activitate");
            }
        }
        return myMap;
    }
}




