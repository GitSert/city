package utilities;

public class Library implements Utility {
    protected String[] config;
    private int booksAmount;

    public Library(String[] config) {
        this.setConfig(config);
    }

    @Override
    public String[] getConfig() {
        return this.config;
    }

    @Override
    public void setConfig(String[] config) {
        this.config = config;
        booksAmount = Integer.parseInt(config[1]);
    }

    @Override
    public void printStats() {
        System.out.println("Utility type: library");
        System.out.println("Amount of books: " + booksAmount);
    }
}
