import java.util.Arrays;

/**
 * Abstract class representing a man - containing two private final Strings - name and surname.
 */
abstract class Man {
    /**
     * man's name
     */
    private final String name;
    /**
     * man's surname
     */
    private final String surname;

    /**
     * Constructor
     * @param name man's name
     * @param surname man's surname
     */
    Man(String name, String surname){
        this.name = name;
        this.surname = surname;
    }

    /**
     * Name getter
     * @return returns a man's name
     */
    public String getName(){
        return name;
    }

    /**
     * Surname getter
     * @return returns a man's surname
     */
    public String getSurname(){
        return surname;
    }

    /**
     * @return returns a man's name + surname
     */
    @Override
    public String toString(){
        return name + " " + surname;
    }

    /**
     * @param ob object to compare with
     * @return returns one of two compared objects
     */
    abstract public Man compare(Man ob);

    /**
     * @return returns an average
     */
    public double average() {
        return 0.0;
    }
}

/**
 * Class Student extending class Man - representing a student,
 * containing a name, a surname, an index number and three grades.
 */
class Student extends Man {
    /**
     * An index number of the student
     */
    final private int indexNumber;
    /**
     * An array containing three grades
     */
    final private double[] grades;

    /**
     * Constructor
     * @param name student's name
     * @param surname student's surname
     * @param indexNumber student's index number
     * @param grade1 student's first grade
     * @param grade2 student's second grade
     * @param grade3 student's third grade
     */
    Student(String name, String surname, int indexNumber, double grade1, double grade2, double grade3){
        super(name, surname);
        this.indexNumber = indexNumber;
        grades = new double[3];
        grades[0] = grade1;
        grades[1] = grade2;
        grades[2] = grade3;
    }

    /**
     * @return returns an arithmetical average of student's grades
     */
    @Override
    public double average(){
        return (grades[0]+grades[1]+grades[2])/3;
    }

    /**
     * @param ob object to compare with
     * @return returns an object which average is greater
     */
    @Override
    public Man compare(Man ob){
        if (!(ob instanceof Student)) {
            return null;
        }
        Student d = (Student) ob;
        if(this.average() > d.average()) return this;
        else return ob;
    }

    /**
     * @return returns String containing student's name and surname, his index number and his grades
     */
    @Override
    public String toString(){
        return super.toString() + ", id number: " + this.indexNumber + ", grades: " + Arrays.toString(grades);
    }
}

/**
 * Class Graduate extending class Student - contains additionally a degree and a graduation year
 */
class Graduate extends Student {
    /**
     * A graduate's degree
     */
    final private String degree;
    /**
     * A graduate's graduation year
     */
    final private int graduationYear;

    /**
     * Constructor
     * @param degree graduate's degree
     * @param name graduate's name
     * @param surname graduate's surname
     * @param indexNumber graduate's index number
     * @param year graduate's gradution year
     * @param grade1 graduate's first grade
     * @param grade2 graduate's second grade
     * @param grade3 graduate's third grade
     */
    Graduate(String degree, String name, String surname, int indexNumber, int year, double grade1, double grade2,
             double grade3){
        super(name, surname, indexNumber, grade1, grade2, grade3);
        this.degree = degree;
        this.graduationYear = year;
    }

    /**
     * @return returns String containing graduate's degree, his name and surname and his year of graduation
     */
    @Override
    public String toString(){
        return degree + " " + super.toString() + ", year of graduation: " + graduationYear;
    }

}

/**
 * Class Dean extending class Man - contains additionally dean's degree, dean's first year of office
 * and dean's last year of office
 */
class Dean extends Man {
    /**
     * Dean's degree
     */
    final private String degree;
    /**
     * Dean's first year of office
     */
    final private int firstYear;
    /**
     * Dean's last year of office
     */
    final private int lastYear;

    /**
     * Constructor
     * @param degree dean's degree
     * @param name dean's name
     * @param surname dean's surname
     * @param firstYear dean's first year of office
     * @param lastYear dean's last year of office
     */
    Dean(String degree, String name, String surname, int firstYear, int lastYear){
        super(name, surname);
        this.degree = degree;
        this.firstYear = firstYear;
        this.lastYear = lastYear;
    }

    /**
     * @return returns dean's last year of office
     */
    public int getLastYear(){
        return lastYear;
    }

    /**
     * @return String returns a String containing dean's degree, dean's name and surname
     * + ", Dean of the Faculty from " + firstYear + " to " + lastYear.
     */
    @Override
    public String toString(){
        return degree + " " + super.toString() + ", Dean of the Faculty from " + firstYear + " to " + lastYear + ".";
    }

    /**
     * @param ob object to compare with
     * @return returns a Dean which last year of office is further
     */
    @Override
    public Man compare(Man ob){
        if (!(ob instanceof Dean)) {
            return null;
        }
        Dean d = (Dean) ob;
        if(this.getLastYear() > d.getLastYear()) return this;
        else return ob;
    }

    /**
     * You cannot calculate an average of Dean object. Method prints "[Average not applicable]"
     * @return returns 0.0
     */
    @Override
    public double average(){
        System.out.print("[Average not applicable]");
        return 0.0;
    }
}

