public class Main {

    // https://learn.hz.nl/mod/assign/view.php?id=279778
    // https://refactoring.guru/design-patterns/behavioral-patterns

    //Design patterns:
    // Facade 2x
    // Factories 2x
    // Observer

    public static void main(String[] args) {
        // Ask the user how many residential and utility buildings they want
        int cityBuildingAmount = Integer.parseInt(askQuestion("How many residential buildings do you want in your city?"));
        int cityUtilityAmount = Integer.parseInt(askQuestion("How many utility buildings do you want in your city?"));

        // Create a city
        City city = new City(cityBuildingAmount, cityUtilityAmount);

        // Print city stats
        city.printStats();
    }

    /**
     * ask the user a question and return their response
     * @param question the question to ask the user
     * @return response the user put in
     */
    public static String askQuestion(String question) {
        ConsoleReader reader = new ConsoleReader();
        ConsoleWriter writer = new ConsoleWriter();

        writer.write(question);
        return reader.readLine();
    }
}
