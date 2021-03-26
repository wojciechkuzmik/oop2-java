//Uwaga: wszystkie pola powinny być prywatne. Proszę też korzystać z napisanych przez siebie metod oraz dziedziczenia --
//        jeśli dana funkcjonalność jest już zaimplementowana, to nie powtarzamy jej (np. jeśli klasa Man potrafi zwrócić
//        poprzez toString() napis zawierający imię i nazwisko, to niech klasy potomne to wykorzystują).
//        Niezastosowanie się do tych wymagań będzie miało wpływ na ocenę (3 pkt.).
//
//        (1 pkt.) Pobierz klasę abstrakcyjną Man z pliku i uzupełnij ją o jeden odpowiedni konstruktor,
//        metody typu "get" (zwracające referencje do pól) oraz metodę toString(). Nie edytuj reszty klasy.
//        Dopisz kolejne klasy: Student, Graduate oraz Dean tak, żeby klasa testująca Lab5 kompilowała się
//        i wypisywała dokładnie to, co podano w pliku. Warto na koniec przekierować wyjście do pliku
//        i porównać je przy pomocy polecenia diff.
//        Wskazówki:
//        (2. pkt.) Student
//        dziedziczy po Man,
//        przechowuje informację o numerze albumu oraz trzy oceny,
//        implementuje metodę compare, która zwraca studenta o wyższej średniej.
//        (1 pkt.) Graduate (absolwent)
//        dziedziczy po Student,
//        przechowuje informację o roku ukończenia studiów oraz uzyskany stopień.
//        (2. pkt.) Dean (dziekan)
//        dziedziczy po Man,
//        przechowuje informację o roku rozpoczęcia i zakończenia kadencji oraz stopień naukowy,
//        implementuje metodę compare, która zwraca dziekana, którego kadencja skończyła/kończy się później.
//        (1 pkt.) Proszę przygotować dokumentacje za pomocą JavaDoc.



public class Main {
    public static void main(String[] args) {
        Man[] staff = new Man[6];
        staff[0] = new Student("Jan", "Kowalski", 211152, 3.5, 4.0, 5.0);
        staff[1] = new Student("Marek", "Styczen", 211150, 4.5, 3.5, 5.0);
        staff[2] = new Graduate("inz.", "Franciszek", "Nowak", 223123, 2018, 5.0, 4.5, 4.0);
        staff[3] = new Graduate("mgr inz.", "Lukasz", "Maj", 200122, 2012, 5.0, 4.5, 3.0);
        staff[4] = new Dean("prof.", "Wojciech", "Luzny", 2008, 2012);
        staff[5] = new Dean("prof.", "Janusz", "Wolny", 2012, 2020);

        printStaff(staff);

        System.out.println();
        System.out.println(staff[0].compare(staff[1]));
        System.out.println(staff[1].compare(staff[0]));
        System.out.println(staff[1].compare(staff[2]));
        System.out.println(staff[1].compare(staff[4]));

        System.out.println();
        System.out.println(staff[4].compare(staff[5]));
        System.out.println(staff[5].compare(staff[4]));
        System.out.println(staff[5].compare(staff[0]));
    }

    public static void printStaff(Man[] tab) {
        for (var c : tab)
            if (c != null) {
                System.out.println(c.getClass().getName() + ": " + c);
                System.out.println("  Average = " + c.average());
                System.out.println();
            } else
                break;
    }
}


