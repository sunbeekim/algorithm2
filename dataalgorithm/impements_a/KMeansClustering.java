package basic.algorithm2.dataalgorithm.impements_a;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class KMeansClustering {
    private double[][] centroids;

    public void train(double[][] data, int k, int maxIterations) {
        int nSamples = data.length;
        int nFeatures = data[0].length;

        // Initialize centroids randomly
        centroids = new double[k][nFeatures];
        for (int i = 0; i < k; i++) {
            centroids[i] = data[i].clone();
        }

        for (int iteration = 0; iteration < maxIterations; iteration++) {
            // Assign clusters
            int[] clusters = new int[nSamples];
            for (int i = 0; i < nSamples; i++) {
                clusters[i] = findClosestCentroid(data[i]);
            }

            // Update centroids
            double[][] newCentroids = new double[k][nFeatures];
            int[] counts = new int[k];
            for (int i = 0; i < nSamples; i++) {
                int cluster = clusters[i];
                for (int j = 0; j < nFeatures; j++) {
                    newCentroids[cluster][j] += data[i][j];
                }
                counts[cluster]++;
            }

            for (int i = 0; i < k; i++) {
                if (counts[i] > 0) {
                    for (int j = 0; j < nFeatures; j++) {
                        newCentroids[i][j] /= counts[i];
                    }
                }
            }

            if (Arrays.deepEquals(centroids, newCentroids)) {
                break;
            }
            centroids = newCentroids;
        }
    }

    private int findClosestCentroid(double[] sample) {
        int closest = 0;
        double minDistance = Double.MAX_VALUE;

        for (int i = 0; i < centroids.length; i++) {
            double distance = 0.0;
            for (int j = 0; j < sample.length; j++) {
                distance += Math.pow(sample[j] - centroids[i][j], 2);
            }
            if (distance < minDistance) {
                minDistance = distance;
                closest = i;
            }
        }
        return closest;
    }

    public double[][] getCentroids() {
        return centroids;
    }
}
