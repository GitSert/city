package factories;

import buildings.*;

    public class BuildingFactory {
        public static Building create(String[] config) {
            switch (config[0]) {
                case "1" -> {
                    return new Cottage(config);
                }
                case "2" -> {
                    return new House(config);
                }
                case "3" -> {
                    return new Apartment(config);
                }
                case "4" -> {
                    return new Mansion(config);
                }
                default -> throw new IllegalStateException("Unexpected value: " + config[0]);
            }
        }
}
