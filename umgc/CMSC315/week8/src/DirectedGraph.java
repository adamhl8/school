import java.util.*;

/**
 * @course CMSC 315
 * @assignment Project 4
 * @description Class DirectedGraph: This class represents a directed graph data structure. It
 *              provides methods for adding edges, performing depth-first search, and handling
 *              vertex states.
 * @author Adam Langbert
 * @date Oct 8, 2023
 * @java-version Java 17
 */

public class DirectedGraph<T> {
  private Map<T, List<T>> adjacencyList;
  private Map<T, VertexState> vertexStates;

  public DirectedGraph() {
    adjacencyList = new HashMap<>();
    vertexStates = new HashMap<>();
  }

  // Adds an edge from the source vertex to the destination vertex in the graph. If the source
  // vertex does not exist in the graph, it is added.
  public void addEdge(T source, T destination) {
    adjacencyList.putIfAbsent(source, new ArrayList<>());
    adjacencyList.get(source).add(destination);
  }

  public void depthFirstSearch(T startVertex, DFSActions<T> actions) {
    initializeVertexStates();
    dfsRecursive(startVertex, actions);
  }

  // Performs DFS. Also handles the detections of cycles.
  private void dfsRecursive(T vertex, DFSActions<T> actions) {
    if (vertexStates.get(vertex) == VertexState.DISCOVERED) {
      actions.cycleDetected(vertex);
      return;
    }

    vertexStates.put(vertex, VertexState.DISCOVERED);

    actions.processVertex(vertex);

    List<T> adjacentVertices = adjacencyList.getOrDefault(vertex, Collections.emptyList());
    if (!adjacentVertices.isEmpty()) {
      // When building a ParenthesizedList, we must skip calling descend/ascend or else a set of
      // empty parentheses is appended.
      if (!actions.isCycleDetected()) {
        actions.descend(vertex);
      }
      for (T adjacentVertex : adjacentVertices) {
        dfsRecursive(adjacentVertex, actions);
      }
      if (!actions.isCycleDetected()) {
        actions.ascend(vertex);
      }
      actions.resetCycleDetected();
    }

    vertexStates.put(vertex, VertexState.FINISHED);
  }

  // Sets all vertices to undiscovered.
  private void initializeVertexStates() {
    vertexStates.clear();
    for (T vertex : adjacencyList.keySet()) {
      vertexStates.put(vertex, VertexState.UNDISCOVERED);
    }
  }

  // Returns list of unreachable vertices.
  public List<T> getUnreachableVertices() {
    List<T> unreachableVertices = new ArrayList<>();
    for (Map.Entry<T, VertexState> entry : vertexStates.entrySet()) {
      if (entry.getValue() == VertexState.UNDISCOVERED) {
        unreachableVertices.add(entry.getKey());
      }
    }
    return unreachableVertices;
  }

  private enum VertexState {
    UNDISCOVERED, DISCOVERED, FINISHED
  }
}
