import java.util.*;

/**
 * @course CMSC 315
 * @assignment Project 4
 * @description Class Main: Generates a hierarchy representation of dependency relationships.
 * @author Adam Langbert
 * @date Oct 8, 2023
 * @java-version Java 17
 */

public class Hierarchy<T> implements DFSActions<T> {
  private StringBuilder hierarchy;
  private Set<T> cycleVertices;
  private boolean cycleDetected;
  private int indentLevel;


  public Hierarchy() {
    hierarchy = new StringBuilder();
    cycleVertices = new HashSet<>();
    indentLevel = 0;
  }

  @Override
  public void cycleDetected(T vertex) {
    cycleDetected = true;
    cycleVertices.add(vertex);
    int lastNewline = hierarchy.lastIndexOf("\n");
    hierarchy.insert(lastNewline, "*");
  }

  @Override
  public boolean isCycleDetected() {
    return cycleDetected;
  }

  @Override
  public void resetCycleDetected() {
    cycleDetected = false;
  }

  @Override
  public void processVertex(T vertex) {
    appendIndent();
    hierarchy.append(vertex).append("\n");
  }

  @Override
  public void descend(T vertex) {
    indentLevel++;
  }

  @Override
  public void ascend(T vertex) {
    indentLevel--;
  }

  private void appendIndent() {
    for (int i = 0; i < indentLevel; i++) {
      hierarchy.append("    ");
    }
  }

  @Override
  public String toString() {
    return hierarchy.toString();
  }
}
