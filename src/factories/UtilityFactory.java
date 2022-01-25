package factories;

import utilities.*;

public class UtilityFactory {
    public static Utility create(String[] config) {
        switch (config[0]) {
            case "1" -> {
                return new Park(config);
            }
            case "2" -> {
                return new Library(config);
            }
            case "3" -> {
                return new PoliceStation(config);
            }
            case "4" -> {
                return new FireDepartment(config);
            }
            case "5" -> {
                return new Hospital(config);
            }
            default -> throw new IllegalStateException("Unexpected value: " + config[0]);
        }
    }
}
