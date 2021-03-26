import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Random;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in); // klasa z pakietu java.util
        int nx;
        while(true){
            try{
                System.out.println("> Podaj liczbe calkowita wieksza od 1:");
                nx = sc.nextInt();
                if(nx <= 1){
                    throw new Exception("BLAD: Zbyt mala wartosc nx: " + nx + "!");
                }
                else break;
            }
            catch(InputMismatchException e){
                System.out.println("BLAD: Podaj liczbe calkowita!");
                sc.nextLine();
            }
            catch(Exception e){
                System.out.println(e.getMessage());
                sc.nextLine();
            }
        }

        System.out.println("\n\nDostepne opcje:");
        for(Option o:Option.values()){
            System.out.println(o);
        }
        int positionX = nx-2;
        int positionY = 1;
        double probability = 0.3;
        Direction direction = null;

        char[][] board = newBoard(nx, nx, probability);
        printBoard(board);

        CheckStep checkStep = (char[][] b, int i0, int j0, Direction dir) -> {
            if (dir == null) return false;
            int i1, j1;
            i1 = i0 - dir.getY();
            j1 = j0 + dir.getX();
            return b[i1][j1] == ' ';
        };

        char z = ' ';
        while(z != 'q'){
            try {
                System.out.print("Wybierz opcje: ");
                z = sc.next().charAt(0);
                switch (z) {
                    case '0' -> board = newBoard(nx, nx, probability);
                    case 'a' -> direction = Direction.LEFT;
                    case 'd' -> direction = Direction.RIGHT;
                    case 'w' -> direction = Direction.UP;
                    case 's' -> direction = Direction.DOWN;
                    case 'q' -> { break; }
                    default -> throw new OptionNotRecognizedException("NIE ROZPOZNANO ZNAKU");
                }
                if (checkStep.test(board, positionX, positionY, direction)) {
                    board[positionX][positionY] = ' ';
                    positionX -= direction.getY();
                    positionY += direction.getX();
                    board[positionX][positionY] = 'o';
                } else throw new WallException("NIE UDALO SIE WYKONAC TAKIEGO RUCHU");
            }
            catch(OptionNotRecognizedException | WallException e){
                System.out.println(e.getMessage());
            }
            printBoard(board);
            if(positionX == 0 && positionY == nx/2){
                System.out.println("GRATULACJE, WYGRALES!");
                break;
            }
            System.out.println();
        }

        sc.close();
    }

    public static void printBoard(char[][] board){
        int i, j;
        for(i = 0; i < board.length; i++){
            for(j = 0; j < board[0].length; j++){
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static char[][] newBoard(int sizeX, int sizeY, double prob){
        char[][] board = new char[sizeY][sizeX];
        Random rand = new Random();
        for(int i = 0; i < sizeX; i++){
            for(int j = 0; j < sizeY; j++){
                if(i == 0 || i == sizeX-1 || j == 0 || j == sizeY-1 || rand.nextDouble() > prob){
                    board[i][j] = 'X';
                }
                else board[i][j] = ' ';
            }
        }
        board[0][sizeX/2] = ' ';
        board[sizeX-2][1] = 'o';
        return board;
    }
}
