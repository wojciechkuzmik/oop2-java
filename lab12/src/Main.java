import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Podaj nazwę pierwszego pliku:");
        String file1Name = bufferedReader.readLine();
        System.out.println("\nPodaj nazwę drugiego pliku:");
        String file2Name = bufferedReader.readLine();
        HashMap<Double, Double> data1 = new HashMap<>();
        HashMap<Double, Double> data2 = new HashMap<>();
        BufferedReader br1 = Files.newBufferedReader(Path.of(file1Name), StandardCharsets.UTF_8);
        String line;
        String[] tmp;
        while((line = br1.readLine()) != null){
            tmp = line.split(" ");
            data1.put(Double.parseDouble(tmp[0]), Double.parseDouble(tmp[1]));
        }
        BufferedReader br2 = Files.newBufferedReader(Path.of(file2Name), StandardCharsets.UTF_8);
        while((line = br2.readLine()) != null){
            tmp = line.split(" ");
            data1.put(Double.parseDouble(tmp[0]), Double.parseDouble(tmp[1]));
        }
        



//        String line1, line2;
//
//        line1 = br1.readLine();
//        String[] tmp = new String[2];
//        tmp = line1.split(" ");
//        System.out.println(tmp[0]);
//        System.out.println(tmp[1]);
//        Double.parseDouble()

        


    }
}
