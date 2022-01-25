package buildings;

import java.util.Objects;

public class Cottage implements Building {
    protected int inhabitants;
    protected String[] config;
    private boolean windows;
    private boolean furnace;

    public Cottage(String[] config) {
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
        // Option 1 means true, 2 means false
        windows = Objects.equals(config[1], "1");
        furnace = Objects.equals(config[2], "1");
    }

    @Override
    public void printStats() {
        System.out.println("Building type: cottage");
        System.out.println("Inhabitants: " + inhabitants);
        System.out.println("Has windows: " + windows);
        System.out.println("Has a furnace: " + furnace);
    }
}
