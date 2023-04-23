package EnumsAndExceptions;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws NoActivityException, NoActivitiesForDayException {
        DailyPlanner planner = new DailyPlanner();
        String sc=null;
        do {
            System.out.println("Menu:");
            System.out.println("1.Add an activity");
            System.out.println("2.Remove an activity");
            System.out.println(("3.List al activities"));
            System.out.println("4.End planning");
            Scanner scanner = new Scanner(System.in);
            sc = scanner.nextLine();
            switch ( sc) {
                case "1":
                    System.out.println("ziua");
                    Day sc2 = Day.valueOf(scanner.nextLine());
                    System.out.println("Activitatea:");
                    String sc3 = scanner.nextLine();
                    try{planner.addActivity(sc2, sc3);}
                    catch (NoActivityException e){
                        System.out.println("Nicio activitate");
                    }
                    break;

                case "2":
                    System.out.println("ziua:");
                    Day sc4 = Day.valueOf(scanner.nextLine());
                    System.out.println("Activitatea:");
                    String sc5 = scanner.nextLine();
                    try {
                        planner.removeActivity(sc4, sc5);
                    } catch (NoActivityException e){
                        System.out.println("Nicio activitate");
                    }

                        break;

                    case "3":
                        System.out.println("ziua:");
                        Day sc6 = Day.valueOf(scanner.nextLine());
                            System.out.println(planner.printActivities(sc6));
                        break;
                case "4":
                    System.out.println("ziua");
                    Day sc7=Day.valueOf(scanner.nextLine());
                    try{System.out.println(planner.endPlanning());}
                    catch(NoActivitiesForDayException e){
                        System.out.println("Nicio activitate pentru acea zi ");
                    }
                    default:
                        System.exit(0);
                }
        } while (!sc.equals("4"));
    }
}