import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

public class Board {

    private ArrayList<Property> properties;

    Board(String settings){
        try{
            properties = new ArrayList<Property>();
            Scanner scanner = new Scanner(new FileReader(settings));
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] values = line.split(" ");      
                properties.add(new Property(Integer.parseInt(values[0]), Integer.parseInt(values[1])));
            }
            scanner.close();
        } catch (Exception e) {
            System.err.println(e);
        }
    }

    public ArrayList<Property> getProperties() {
        return properties;
    }
}
