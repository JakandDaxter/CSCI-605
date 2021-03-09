public class Patron implements Comparable<Patron> {

    private String name;
    private int coolness;
    private boolean regular;

    public Patron(int coolness, boolean regular, String name) {
        this.coolness = coolness;
        this.regular = regular;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCoolness() {
        return coolness;
    }

    public void setCoolness(int coolness) {
        this.coolness = coolness;
    }

    public boolean isRegular() {
        return regular;
    }

    public void setRegular(boolean regular) {
        this.regular = regular;
    }

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
