package buildings;

public interface Building {
    int inhabitants = 0;
    
    String[] getConfig();

    void setConfig(String[] config);
    void printStats();
}
