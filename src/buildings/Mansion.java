package buildings;

import java.util.Objects;

public class Mansion implements Building {
    protected int inhabitants;
    protected String[] config;
    private boolean statue;
    private boolean fountain;

    public Mansion(String[] config) {
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
        statue = Objects.equals(config[1], "1");
        fountain = Objects.equals(config[2], "1");
    }

    @Override
    public void printStats() {
        System.out.println("Building type: mansion");
        System.out.println("Inhabitants: " + inhabitants);
        System.out.println("Has a statue: " + statue);
        System.out.println("Has a fountain: " + fountain);
    }
}
