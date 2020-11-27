package hw2;

import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class Percolation {
    private WeightedQuickUnionUF weightedQuickUnionUF;
    private boolean[][] siteStatus;
    private int length;
    private int upSite;
    private int downSite;
    private int numOfOpen;

    // create N-by-N grid, with all sites initially blocked
    public Percolation(int N) {
        if (N <= 0) {
            throw new IllegalArgumentException("N must > 0 ");
        }
        weightedQuickUnionUF = new WeightedQuickUnionUF(N*N + 2);
        siteStatus = new boolean[N][N];
        length = N;
        upSite = N*N;
        downSite = N*N + 1;
        numOfOpen = 0;
    }

    // private helper method used to convert the ideal indices in matrix to actual indices in UF
    private int UFNumber(int row, int col) {
        return row * length + col;
    }
/*
    // open the site (row, col) if it is not open already
    public void open(int row, int col) {
        if (siteStatus[row][col]) {
            return;
        } else {
            // open this site
            siteStatus[row][col] = true;
            // check the surrounding sites and connect each other

            // update numOfOpen
            numOfOpen += 1;
        }
    }
*/
    // is the site (row, col) open?
    public boolean isOpen(int row, int col) {
        return siteStatus[row][col];
    }

    // is the site (row, col) full?
    public boolean isFull(int row, int col) {
        int thisSite = UFNumber(row, col);
        return weightedQuickUnionUF.connected(thisSite, upSite);
    }

    // number of open sites
    public int numberOfOpenSites() {
        return numOfOpen;
    }

    // does the system percolate?
    public boolean percolates() {
        return weightedQuickUnionUF.connected(upSite, downSite);
    }

    // use for unit testing (not required)
    public static void main(String[] args) {

    }
}
