package utilities;

import java.util.Objects;

public class FireDepartment implements Utility {
    protected String[] config;
    private boolean helicopter;
    private int trucksAmount;

    public FireDepartment(String[] config) {
        this.setConfig(config);
    }

    @Override
    public String[] getConfig() {
        return this.config;
    }

    @Override
    public void setConfig(String[] config) {
        this.config = config;
        helicopter = Objects.equals(config[1], "1");;
        trucksAmount = Integer.parseInt(config[2]);
    }

    @Override
    public void printStats() {
        System.out.println("Utility type: fire department");
        System.out.println("Has a helicopter: " + helicopter);
        System.out.println("Amount of trucks: " + trucksAmount);
    }
}
