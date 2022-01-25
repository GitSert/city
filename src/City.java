import buildings.Building;
import factories.*;
import utilities.Utility;

public class City {
    Observer observer = new Observer();
    Building[] cityBuildings;
    Utility[] cityUtilities;

    public City(int cityBuildingAmount, int cityUtilityAmount) {
        cityBuildings = new Building[cityBuildingAmount];
        cityUtilities = new Utility[cityUtilityAmount];

        // Add a building for each item in the array.
        for (int i = 0; i < cityBuildingAmount; i++) {
            cityBuildings[i] = addBuilding();
        }

        // Add a utility for each item in the array.
        for (int i = 0; i < cityUtilityAmount; i++) {
            cityUtilities[i] = addUtility();
        }
    }

    /**
     * if the user chose to have holding cells, ask them how many
     * @param cells If the user chose NOT to have cells, this will be 2.
     * @return the amount of cells the user wants
     */
    private String getCells(String cells) {
        return switch (cells) {
            case "1" -> Main.askQuestion("How many cells do you want?");
            case "2" -> "0";
            default -> "0";
        };
    }

    /**
     * ask the user which building they want, ask their config and return the building with applied config
     * @return building with applied config
     */
    public Building addBuilding() {
        // ask which type of building the user wants
        String buildingType = Main.askQuestion("Which type of building do you want? Type 1 for a cottage, 2 for a detached house, 3 for an apartment and 4 for a mansion.");

        // Tell the observer the building was successfully chosen.
        observer.buildingChosen(buildingType);
        System.out.println();

        // ask which configuration of the building the user wants and how many inhabitants
        String[] config = askBuildingConfig(buildingType);

        // make the building, with the configuration and amount of inhabitants, the user wants and return it
        return buildBuilding(config);
    }

    /**
     * ask the user which utility they want, ask their config and return the utility with applied config
     * @return utility with applied config
     */
    public Utility addUtility() {
        // ask which type of utility the user wants
        String utilityType = Main.askQuestion("Which type of utility do you want? Type 1 for a park, 2 for a library, 3 for a police station, 4 for a fire department or 5 for a hospital.");

        // Tell the observer the utility was successfully chosen.
        observer.utilityChosen(utilityType);
        System.out.println();

        // ask which configuration of the utility the user wants
        String[] config = askUtilityConfig(utilityType);

        // make the utility with the configuration the user wants and return it
        return buildUtility(config);
    }

    /**
     * ask the user for the configuration of the building they chose
     * @param buildingResponse the building the user chose
     * @return config the user made
     */
    private String[] askBuildingConfig(String buildingResponse) {
        String[] config;

        // Based on the building chosen, let the user customize their config.
        switch (buildingResponse) {
            case "1" -> config = new String[] {
                    "1",
                    Main.askQuestion("Do you want windows? Press 1 for yes and 2 for no."),
                    Main.askQuestion("Do you want a log furnace? Press 1 for yes and 2 for no."),
                    Main.askQuestion("How many inhabitants do you want in your building?")
            };
            case "2" -> config = new String[] {
                    "2",
                    Main.askQuestion("Do you want a garage? Press 1 for yes and 2 for no."),
                    Main.askQuestion("What type of roof do you want? Press 1 for flat, 2 for arched and 3 for pointed."),
                    Main.askQuestion("How many inhabitants do you want in your building?")
            };
            case "3" -> config = new String[] {
                    "3",
                    Main.askQuestion("How many stories do you want?"),
                    Main.askQuestion("How many rooms do you want per floor?"),
                    Main.askQuestion("How many inhabitants do you want in your building?")
            };
            case "4" -> config = new String[] {
                    "4",
                    Main.askQuestion("Do you want a golden statue? Press 1 for yes and 2 for no."),
                    Main.askQuestion("Do you want a fountain? Press 1 for yes and 2 for no."),
                    Main.askQuestion("How many inhabitants do you want in your building?")
            };
            default -> throw new IllegalStateException("Unexpected value: " + buildingResponse);
        }

        // Tell the observer the config was chosen.
        observer.configChosen(config);
        System.out.println();

        return config;
    }

    /**
     * ask the user for the configuration of the utility they chose
     * @param utilityResponse the utility the user chose
     * @return config the user made
     */
    private String[] askUtilityConfig(String utilityResponse) {
        String[] config;
        String cells;

        switch (utilityResponse) {
            case "1" -> config = new String[] {
                    "1",
                    Main.askQuestion("Do you want a fountain? Press 1 for yes and 2 for no."),
                    Main.askQuestion("How many trees do you want in your park?")
            };
            case "2" -> config = new String[] {
                    "2",
                    Main.askQuestion("How many books do you want in the library?")
            };
            case "3" -> config = new String[] {
                    "3",
                    Main.askQuestion("How many officers do you want in the police station?"),
                    cells = Main.askQuestion("Do you want holding cells? Type 1 for yes and 2 for no."),
                    getCells(cells)
            };
            case "4" -> config = new String[] {
                    "4",
                    Main.askQuestion("Do you want a helicopter?"),
                    Main.askQuestion("How many firetrucks do you want in the fire department?")
            };
            case "5" -> config = new String[] {
                    "5",
                    Main.askQuestion("How many beds do you want in the hospital?"),
                    Main.askQuestion("How many doctors do you want in the hospital?")
            };
            default -> throw new IllegalStateException("Unexpected value: " + utilityResponse);
        }

        // Tell the observer the config was chosen.
        observer.configChosen(config);
        System.out.println();

        return config;
    }

    /**
     * Build the building the user wants with their chosen config and inhabitants. Uses BuildingFactory.
     * @param config the configuration of the building
     * @return the building with applied config
     */
    private Building buildBuilding(String[] config) {
        // Instantiate building
        Building building;

        // Build the building with the chosen config and inhabitants
        building = BuildingFactory.create(config);

        // Tell the observer the building was built.
        observer.buildingBuilt();
        System.out.println();

        return building;
    }

    /**
     * Build the utility the user wants with their chosen config. Uses UtilityFactory.
     * @param config the configuration of the utility
     * @return the utility with applied config
     */
    private Utility buildUtility(String[] config) {
        // Instantiate utility
        Utility utility;

        // Build the utility with the chosen config
        utility = UtilityFactory.create(config);

        // Tell the observer the utility was built.
        observer.utilityBuilt();
        System.out.println();

        return utility;
    }

    /**
     * print all the stats for the city
     */
    public void printStats() {
        printBuildingStats();
        printUtilityStats();
    }

    /**
     * print the stats for the buildings in the city
     */
    private void printBuildingStats() {
        int inhabitants = 0;

        // for each building in the city, add the inhabitants to the total
        for (Building building : cityBuildings) {
            inhabitants += Integer.parseInt(building.getConfig()[3]);
        }

        System.out.println("This total inhabitants of the city: " + inhabitants);
        System.out.println("The buildings in the city:");
        System.out.println();

        if (cityBuildings.length == 0) {
            System.out.println("None");
        }

        // for each building in the city print the number and stats
        for (int i = 0; i < cityBuildings.length; i++) {
            System.out.println("Building " + (i+1) + ":");
            cityBuildings[i].printStats();
            System.out.println();
        }
    }

    /**
     * print the stats for the utilities in the city
     */
    private void printUtilityStats() {
        System.out.println("The utilities in the city:");
        System.out.println();

        if (cityUtilities.length == 0) {
            System.out.println("None");
        }

        // for each utility in the city print the number and stats
        for (int i = 0; i < cityUtilities.length; i++) {
            System.out.println("Utility " + (i+1) + ":");
            cityUtilities[i].printStats();
            System.out.println();
        }
    }
}
