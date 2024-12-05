package basic.algorithm2.dataalgorithm.interface_a;

public interface Dynamic{//DynamicProgramming
    int knapsack(int capacity, int[] weights, int[] values); // 배낭 문제
    int longestCommonSubsequence(String str1, String str2);  // 최장 공통 부분 수열
    int fibonacci(int n);                                   // 피보나치 수열
}
