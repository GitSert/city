package buildings;

import java.util.Objects;

public class House implements Building {
    protected int inhabitants;
    protected String[] config;
    private boolean garage;
    private int roof;

    public House(String[] config) {
        this.setConfig(config);
    }

    @Override
    public String[] getConfig() {
        return config;
    }

    @Override
    public void setConfig(String[] config) {
        inhabitants = Integer.parseInt(config[3]);
        this.config = config;
        // Option 1 means true, 2 means false
        garage = Objects.equals(config[1], "1");
        // Option 1 for flat, 2 for arched and 3 for pointed
        roof = Integer.parseInt(config[2]);
    }

    @Override
    public void printStats() {
        System.out.println("Building type: detached house");
        System.out.println("Inhabitants: " + inhabitants);
        System.out.println("Has a garage: " + garage);
        switch (roof) {
            case 1 -> System.out.println("Roof is flat");
            case 2 -> System.out.println("Roof is arched");
            case 3 -> System.out.println("Roof is pointed");
        }
    }
}
