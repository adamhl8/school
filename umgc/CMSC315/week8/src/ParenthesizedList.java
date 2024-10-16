import java.util.*;

/**
 * @course CMSC 315
 * @assignment Project 4
 * @description Class ParenthesizedList: Generates a parenthesized list representing dependency
 *              relationships.
 * @author Adam Langbert
 * @date Oct 8, 2023
 * @java-version Java 17
 */

public class ParenthesizedList<T> implements DFSActions<T> {
  private StringBuilder list;
  private Set<T> cycleVertices;
  private boolean cycleDetected;

  public ParenthesizedList() {
    list = new StringBuilder();
    cycleVertices = new HashSet<>();
    cycleDetected = false;
  }

  @Override
  public void cycleDetected(T vertex) {
    cycleDetected = true;
    cycleVertices.add(vertex);
    int lastSpace = list.lastIndexOf(" ");
    list.insert(lastSpace, "*");
  }

  public boolean isCycleDetected() {
    return cycleDetected;
  }

  public void resetCycleDetected() {
    cycleDetected = false;
  }

  @Override
  public void processVertex(T vertex) {
    if (cycleVertices.contains(vertex)) {
      list.append(vertex).append("* ");
    } else {
      list.append(vertex).append(" ");
    }
  }

  @Override
  public void descend(T vertex) {
    list.append("(");
  }

  @Override
  public void ascend(T vertex) {
    // Trim the trailing space before appending the closing parenthesis
    if (list.charAt(list.length() - 1) == ' ') {
      list.deleteCharAt(list.length() - 1);
    }
    list.append(") ");
  }

  @Override
  public String toString() {
    String trimmedList = list.toString().trim();
    return "(" + trimmedList + ")";
  }
}
