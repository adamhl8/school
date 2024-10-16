/**
 * @course CMSC 315
 * @assignment Project 4
 * @description Interface DFSActions: Defines the actions that are performed during a depth-first
 *              search (DFS) on a graph.
 * @author Adam Langbert
 * @date Oct 8, 2023
 * @java-version Java 17
 */

public interface DFSActions<T> {
  // Called when a cycle is detected during the depth-first search.
  void cycleDetected(T vertex);

  // Checks if a cycle has been detected during the depth-first search.
  boolean isCycleDetected();

  // Resets the cycle detection status during the depth-first search.
  void resetCycleDetected();

  // Called when a vertex is processed during the depth-first search.
  void processVertex(T vertex);

  // called when the depth-first search descends to a new level of the graph.
  void descend(T vertex);

  // Called when the depth-first search ascends back up a level of the graph.
  void ascend(T vertex);
}
