package game;

/*
This class is an enumeration for representing the players in the Dots And Boxes game
 */
public enum Player {

    RED("RED","Red"),
    BLUE("BLUE","Blue"),
    NONE("NONE","None");

    String name;
    String label;

    //Contructor
    Player(String name, String label){
        this.name = name;
        this.label = label;
    }

    //return name
    public String getName(){
        return this.name;
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
                if(p.getName().equals(name)){
                    return p;
                }
            }
            throw new IllegalArgumentException();
        }


    }


