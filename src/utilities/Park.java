package utilities;

import java.util.Objects;

public class Park implements Utility {
    protected String[] config;
    private boolean fountain;
    private int treesAmount;

    public Park(String[] config) {
        this.setConfig(config);
    }

    @Override
    public String[] getConfig() {
        return this.config;
    }

    @Override
    public void setConfig(String[] config) {
        this.config = config;
        fountain = Objects.equals(config[1], "1");
        treesAmount = Integer.parseInt(config[2]);
    }

    @Override
    public void printStats() {
        System.out.println("Utility type: park");
        System.out.println("Has a fountain: " + fountain);
        System.out.println("Amount of trees: " + treesAmount);
    }
}
