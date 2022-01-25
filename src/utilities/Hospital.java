package utilities;

import java.util.Objects;

public class Hospital implements Utility {
    protected String[] config;
    private int bedAmount;
    private int doctorAmount;

    public Hospital(String[] config) {
        this.setConfig(config);
    }

    @Override
    public String[] getConfig() {
        return this.config;
    }

    @Override
    public void setConfig(String[] config) {
        this.config = config;
        bedAmount = Integer.parseInt(config[1]);
        doctorAmount = Integer.parseInt(config[2]);
    }

    @Override
    public void printStats() {
        System.out.println("Utility type: hospital");
        System.out.println("Amount of beds: " + bedAmount);
        System.out.println("Amount of doctors: " + doctorAmount);
    }
}
