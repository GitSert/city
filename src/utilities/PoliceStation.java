package utilities;

import java.util.Objects;

public class PoliceStation implements Utility {
    protected String[] config;
    private int officersAmount;
    private boolean holdingCell;
    private int cellsAmount;

    public PoliceStation(String[] config) {
        this.setConfig(config);
    }

    @Override
    public String[] getConfig() {
        return this.config;
    }

    @Override
    public void setConfig(String[] config) {
        this.config = config;
        officersAmount = Integer.parseInt(config[1]);
        holdingCell = Objects.equals(config[2], "1");
        cellsAmount = Integer.parseInt(config[3]);
    }

    @Override
    public void printStats() {
        System.out.println("Utility type: police station");
        System.out.println("Amount of officers: " + officersAmount);
        System.out.println("Has a holding cell: " + holdingCell);
        System.out.println("Amount of cells: " + cellsAmount);
    }
}
