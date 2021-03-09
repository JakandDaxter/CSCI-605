
/**
 * The Patron class implements the Comparable interface
 * It stores all patron details and compares patrons based on their coolness factor
 * Patrons with higher coolness factors are prioritized
 */

public class Patron implements Comparable<Patron> {

    private String name;
    private int coolness;
    private boolean regular;

    /**
     * Constructor for Patron class
     * @param coolness
     * @param regular
     * @param name
     */

    public Patron(int coolness, boolean regular, String name) {
        this.coolness = coolness;
        this.regular = regular;
        this.name = name;
    }

    /**
     * Get the Patron name
     * @return name
     */

    public String getName() { return name; }

    /**
     * Set the Patron name
     * @return name
     */

    public void setName(String name) {
        this.name = name;
    }

    /**
     * Get the coolness factor
     * @return coolness
     */

    public int getCoolness() {
        return coolness;
    }

    /**
     * Set the coolness factor
     * @return coolness
     */

    public void setCoolness(int coolness) {
        this.coolness = coolness;
    }

    /**
     * Check Patron regularity
     * @return regular
     */

    public boolean isRegular() {
        return regular;
    }

    /**
     * Set Patron regularity
     * @return regular
     */

    public void setRegular(boolean regular) {
        this.regular = regular;
    }

    /**
     * Method to compare Patrons to each other based on coolness factor
     * Patrons with higher coolness factors are prioritized for admittance
     */

    @Override
    public int compareTo(Patron o) {
        if(this.coolness == o.coolness){
            if(this.regular){
                return -1;
            }else return 1;
        }
        return Integer.compare(this.coolness,o.coolness);
    }
}
