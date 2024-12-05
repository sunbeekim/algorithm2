package basic.algorithm2.dataalgorithm.interface_a;

public interface BranchAndBound {
    int solveKnapsack(int capacity, int[] weights, int[] values); // 배낭 문제 최적해
    int solveTSP(int[][] distances);                             // 외판원 문제 최적해
}
