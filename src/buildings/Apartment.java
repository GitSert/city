package buildings;

public class Apartment implements Building {
    protected int inhabitants;
    protected String[] config;
    private int amountOfStories;
    private int amountOfRooms;

    public Apartment(String[] config) {
        this.setConfig(config);
    }

    @Override
    public String[] getConfig() {
        return config;
    }

    @Override
    public void setConfig(String[] config) {
        this.inhabitants = Integer.parseInt(config[3]);
        this.config = config;
        amountOfStories = Integer.parseInt(config[1]);
        amountOfRooms = Integer.parseInt(config[2]);
    }

    @Override
    public void printStats() {
        System.out.println("Building type: apartment");
        System.out.println("Inhabitants: " + inhabitants);
        System.out.println("Amount of stories: " + amountOfStories);
        System.out.println("Amount of rooms: " + amountOfRooms);
    }
}
