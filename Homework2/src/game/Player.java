package game;

/*
This class is an enumeration for representing the players in the Dots And Boxes game
 */
public enum Player {

    RED("R"),
    BLUE("B"),
    NONE(" ");

    String name;
    String label;

    //Contructor
    Player(String label){

        this.label = label;
    }

    //return label
    public String getLabel(){
        return this.label;
    }

    /*
        Returns an array containing the constants of this enum type,
        in the order they are declared.
    */
    public static Player[] allValues(){
        return Player.values();
    }

    /*
        Returns the enum constant of this type with the specified name.
        The string must match exactly an identifier used to declare an enum
        constant in this type. (Extraneous whitespace characters are not permitted.)
    */
        public static Player parse(String name){

            for(Player p : allValues()){ //content driven
                if(p.getLabel().equals(name)){
                    return p;
                }
            }
            throw new IllegalArgumentException();
        }


    }


