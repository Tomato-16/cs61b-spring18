package hw2;

import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;

public class PercolationStats {
    private double[] results;
    private int length;
    private int number;

    // perform T independent experiments on an N-by-N grid
    public PercolationStats(int N, int T, PercolationFactory pf) {
        if (N <= 0 || T <= 0) {
            throw new IllegalArgumentException("N and T must both > 0");
        }
        results = new double[T];
        length = N;
        number = T;
        // perform T experiments and add the result to the array
        for (int i = 0; i < T; i += 1) {
            // for each time perform an experiment
            Percolation percolation = pf.make(N);
            while (!percolation.percolates()) {
                // pay attention to the two bounds of uniform
                int row = StdRandom.uniform(0, length);
                int col = StdRandom.uniform(0, length);
                percolation.open(row, col);
            }
            results[i] = 1.0 * percolation.numberOfOpenSites() / (length * length);
        }
    }
    // sample mean of percolation threshold
    public double mean() {
        return StdStats.mean(results);
    }
    // sample standard deviation of percolation threshold
    public double stddev() {
        return StdStats.stddev(results);
    }
    // low endpoint of 95% confidence interval
    public double confidenceLow() {
        return mean() - 1.96 * stddev() / Math.sqrt(number);
    }
    // high endpoint of 95% confidence interval
    public double confidenceHigh() {
        return mean() + 1.96 * stddev() / Math.sqrt(number);
    }
}
