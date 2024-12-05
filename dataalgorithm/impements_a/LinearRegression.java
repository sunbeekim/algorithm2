package basic.algorithm2.dataalgorithm.impements_a;

public class LinearRegression {
    private double[] weights;
    private double bias;

    public void train(double[][] data, double[] targets, double learningRate, int epochs) {
        int nFeatures = data[0].length;
        int nSamples = data.length;

        // Initialize weights and bias
        weights = new double[nFeatures];
        bias = 0.0;

        for (int epoch = 0; epoch < epochs; epoch++) {
            for (int i = 0; i < nSamples; i++) {
                double prediction = predict(data[i]);
                double error = prediction - targets[i];

                // Gradient descent updates
                for (int j = 0; j < nFeatures; j++) {
                    weights[j] -= learningRate * error * data[i][j];
                }
                bias -= learningRate * error;
            }
        }
    }

    public double predict(double[] features) {
        double result = bias;
        for (int i = 0; i < features.length; i++) {
            result += weights[i] * features[i];
        }
        return result;
    }
}
