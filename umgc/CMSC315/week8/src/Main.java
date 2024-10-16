import javax.swing.*;
import java.io.*;
import java.util.*;

/**
 * @course CMSC 315
 * @assignment Project 4
 * @description Class Main: Allows the user to select an input file and generates hierarchy and
 *              parenthesized list displays to show dependency relationships.
 * @author Adam Langbert
 * @date Oct 8, 2023
 * @java-version Java 17
 */

public class Main {

  public static void main(String[] args) {
    JFileChooser fileChooser = new JFileChooser();
    fileChooser.setCurrentDirectory(new File("./input_files"));
    int returnValue = fileChooser.showOpenDialog(null);

    if (returnValue == JFileChooser.APPROVE_OPTION) {
      File selectedFile = fileChooser.getSelectedFile();
      try {
        DirectedGraph<String> graph = buildGraphFromFile(selectedFile);
        DFSActions<String> hierarchy = new Hierarchy<>();
        DFSActions<String> parenthesizedList = new ParenthesizedList<>();

        String startVertex = getFirstVertexFromFile(selectedFile);

        graph.depthFirstSearch(startVertex, hierarchy);
        System.out.println("Dependency Hierarchy:\n" + hierarchy);

        graph.depthFirstSearch(startVertex, parenthesizedList);
        System.out.println("Dependency Parenthesized List:\n" + parenthesizedList + "\n");

        List<String> unreachableVertices = graph.getUnreachableVertices();
        if (!unreachableVertices.isEmpty()) {
          System.out.println("Unreachable Vertices:");
          for (String vertex : unreachableVertices) {
            System.out.println(vertex + " is unreachable");
          }
        }
      } catch (IOException e) {
        System.out.println("Error reading input file: " + e.getMessage());
      }
    }
  }

  // Reads the input file and builds a directed graph from it. Each line in the file represents a
  // vertex and its edges.
  private static DirectedGraph<String> buildGraphFromFile(File file) throws IOException {
    DirectedGraph<String> graph = new DirectedGraph<>();

    try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
      String line;
      while ((line = reader.readLine()) != null) {
        String[] vertices = line.split(" ");
        for (int i = 1; i < vertices.length; i++) {
          graph.addEdge(vertices[0], vertices[i]);
        }
      }
    }
    return graph;
  }

  // Reads the first line of the input file and returns the first vertex.
  private static String getFirstVertexFromFile(File file) throws IOException {
    try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
      String firstLine = reader.readLine();
      if (firstLine != null) {
        return firstLine.split(" ")[0];
      } else {
        throw new IOException("First line of input file is empty.");
      }
    }
  }
}
