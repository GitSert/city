import java.util.Arrays;

public class Observer {
    ConsoleWriter writer = new ConsoleWriter();
    String building;
    String utility;

    /**
     * Notify the user that they successfully chose a building
     * Set the building in this class
     * @param building the building the user chose
     */
    public void buildingChosen(String building) {
        switch (building) {
            case "1" -> building = "Cottage";
            case "2" -> building = "House";
            case "3" -> building = "Apartment";
            case "4" -> building = "Mansion";
        }

        writer.write("Building (" + building + ") was chosen");
        this.building = building;
    }

    /**
     * Notify the user that they successfully chose a utility
     * Set the utility in this class
     * @param utility the building the user chose
     */
    public void utilityChosen(String utility) {
        switch (utility) {
            case "1" -> utility = "Cottage";
            case "2" -> utility = "House";
            case "3" -> utility = "Apartment";
            case "4" -> utility = "Mansion";
        }

        writer.write("utility (" + utility + ") was chosen");
        this.utility = utility;
    }

    /**
     * Notify the user that they successfully chose a config
     * @param config the config the user made
     */
    public void configChosen(String[] config) {
        writer.write("Config was chosen: [building, options..., inhabitants] = " + Arrays.toString(config));
    }

    /**
     * Notify the user the building they chose was built
     */
    public void buildingBuilt() {
        writer.write("Building (" + building + ") was built");
    }

    /**
     * Notify the user the building they chose was built
     */
    public void utilityBuilt() {
        writer.write("Utility (" + utility + ") was built");
    }

}
