package basic.algorithm2.dataalgorithm.interface_a;

import java.util.List;

public interface GraphAlgorithm<T> {
    void addEdge(T from, T to);              // 그래프의 간선 추가
    List<T> depthFirstSearch(T start);      // DFS 구현
    List<T> breadthFirstSearch(T start);    // BFS 구현
    int shortestPath(T start, T end);       // 최단 경로 계산 (가중치 포함 가능)
}
