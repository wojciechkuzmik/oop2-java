public class StudentWFiIS1 extends Student implements StudentUSOS {
    private String[] przedmioty;
    private int rok;

    StudentWFiIS1(String n, String s, int id, int y, String sub1, double g1, String sub2, double g2,
                  String sub3, double g3){
        super(n, s, id, g1, g2, g3);
        rok = y;
        przedmioty = new String[3];
        przedmioty[0] = sub1;
        przedmioty[1] = sub2;
        przedmioty[2] = sub3;
    }
    
    public double srednia(){
        return super.average();
    }
    
    public void listaPrzedmiotow(){
        System.out.println("\t1. " + przedmioty[0] + ": " + getGrade(0) + "\n" +
                "\t2. " + przedmioty[1] + ": " + getGrade(1) + "\n" +
                "\t3. " + przedmioty[2] + ": " + getGrade(2));
    }

    public String toString(){
        return "[" + rok + "] " + super.toString();
    }

}
