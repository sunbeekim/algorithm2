package basic.algorithm2.dataalgorithm.interface_a;

public interface MachineLearning {
    double[] linearRegression(double[][] data, double[] targets); // 선형 회귀
    int[] kMeansClustering(double[][] data, int k);               // K-평균 클러스터링
    boolean supportVectorMachine(double[][] data, int[] labels);  // SVM 학습

}
