import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    System.out.println("==== Adam Langbert | July 8, 2023 | CMIS 242 ====\n");

    // We use an ArrayList (dynamic size) because we don't know how many rows of data there are.
    List<List<String>> data = new ArrayList<>();

    try {
      File inputFile = new File("data.txt");
      Scanner scanner = new Scanner(inputFile);

      while (scanner.hasNextLine()) {
        String line = scanner.nextLine();
        String[] values = line.split(" ");

        List<String> rowData = new ArrayList<>();
        for (String value : values) {
          rowData.add(value);
        }
        data.add(rowData);
      }
      scanner.close();

    } catch (FileNotFoundException e) {
      System.out.println("data.txt not found.");
      e.printStackTrace();
    }

    // Now we can convert our ArrayList into a 2D array.
    String[][] dataArray = new String[data.size()][];
    for (int i = 0; i < data.size(); i++) {
      List<String> row = data.get(i);
      // The `new String[0]` argument tells toArray what type the array should be (String[]).
      // Also, by setting the size to 0, toArray will automatically expand the created array to fit the size of the row.
      dataArray[i] = row.toArray(new String[0]);
    }

    // Iterate over 2D array to print all the values.
    for (int i = 0; i < dataArray.length; i++) {
      for (int j = 0; j < dataArray[i].length; j++) {
        System.out.print(dataArray[i][j] + " ");
      }
      System.out.println();
    }
  }
}
