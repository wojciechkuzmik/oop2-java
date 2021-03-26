public enum Option {
    RESET('0', "Reset planszy", null),
    LEFT('a', "Przesun w lewo", Direction.LEFT),
    RIGHT('d', "Przesun w prawo", Direction.RIGHT),
    UP('w', "Przesun w gore", Direction.UP),
    DOWN('s', "Przesun w dol", Direction.DOWN),
    EXIT('q', "Zakonczenie gry", null);

    private char c;
    private String description;
    private Direction direction;

    Option(char c, String desc, Direction dir){
        this.c = c;
        this.description = desc;
        this.direction = dir;
    }

    public char getC(){
        return this.c;
    }

    public String getDescription(){
        return this.description;
    }

    public Direction getDirection(){
        return this.direction;
    }

    @Override
    public String toString(){
        if(direction == null)
            return "'" + this.c + "' ==> opcja " + super.toString() + ", opis: " + description;
        else
            return "'" + this.c + "' ==> opcja " + super.toString() + ", opis: " + description
                    + ", wektor przesuniecia: " + direction;
    }
}
