public class StudentWFiIS3 extends Student {
    private StudentUSOS stud;

    StudentWFiIS3(String n, String s, int id, int y, String sub1, double g1, String sub2, double g2,
                  String sub3, double g3){
        super(n, s, id, g1, g2, g3);
        stud = new StudentUSOS() {
            private String[] przedmioty;

            {
                przedmioty = new String[3];
                przedmioty[0] = sub1;
                przedmioty[1] = sub2;
                przedmioty[2] = sub3;
            }

            private int rok = y;

            public double srednia() {
                return average();
            }

            public void listaPrzedmiotow() {
                System.out.println("\t1. " + przedmioty[0] + ": " + getGrade(0) + "\n" +
                        "\t2. " + przedmioty[1] + ": " + getGrade(1) + "\n" +
                        "\t3. " + przedmioty[2] + ": " + getGrade(2));
            }

            public String toString(){
                return "[" + rok + "] " + StudentWFiIS3.super.toString();
            }
        };
    }
    public double srednia(){
        return stud.srednia();
    }

    public void listaPrzedmiotow(){
        stud.listaPrzedmiotow();
    }

    public String toString(){
        return stud.toString();
    }

}