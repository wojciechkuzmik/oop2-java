public class Main {

    public static void main(String[] args) {
        String[] input = args[0].split("");
        Stack<String> stack = new Stack<>(input.length);
        String a, b, result;
        try{
            for (String s : input) {
                if (s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/")) {
                    a = stack.pop();
                    b = stack.pop();
                    stack.push("(" + b + s + a + ")");
                }
                else stack.push(s);
            }
            result = stack.pop();
            if (!stack.isEmpty()) {
                System.out.println("BLAD DANYCH WEJSCIOWYCH! Koniec algorytmu, a stos nie jest pusty: " + stack + ", " + result);
            } else System.out.println("Wynik: " + result);
        } catch (StackUnderflowException e){
            System.out.println("BLAD DANYCH WEJSCIOWYCH! Na stosie jest za malo elementow, zeby wykonac operacje!\n");
        } catch (StackOverflowException e){
            System.out.println("Stos przepelniony!");
        }
    }
}
