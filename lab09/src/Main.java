import java.lang.reflect.*;
import java.util.Arrays;


public class Main {

    public static void main(String[] args) {

        Class<Math> cls = Math.class;

        try{
            String[] array = splitArgs(args[0]);
            if(array.length == 2){
                Class[] arg = new Class[1];
                arg[0] = double.class;
                Method method = cls.getMethod(array[0], arg);
                System.out.println("Wynik: " + method.invoke(cls, Double.parseDouble(array[1])));
            }
            else if(array.length == 3){
                Class[] arg = new Class[2];
                arg[0] = double.class;
                arg[1] = double.class;
                Method method = cls.getMethod(array[0], arg);
                System.out.println("Wynik: " + method.invoke(cls, Double.parseDouble(array[1]), Double.parseDouble(array[2])));
            }
            else{
                System.out.println("Zla liczba argumentow funkcji! Podaj jedna lub dwie liczby.");
                System.exit(-1);
            }

        } catch(NoSuchMethodException e) {
            System.out.println("Nie ma takiej metody!");
        } catch (IllegalAccessException | InvocationTargetException e) {
            System.out.println(e.getMessage());
        } catch (NumberFormatException e){
            System.out.println("Argumenty funkcji musza byc liczbami!");
        } catch (ArrayIndexOutOfBoundsException e){
            System.out.println("Nie podano nic do obliczenia!");
        }

    }

    public static String[] splitArgs(String arg) {
        return Arrays.stream(arg.split("[\\s+(),]")).filter(w -> w.isEmpty() == false).toArray(String[]::new);
    }
}
