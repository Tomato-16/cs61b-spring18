package hw2;

import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class Percolation {
    private WeightedQuickUnionUF weightedQuickUnionUF;
    private boolean[][] siteStatus;
    private int length;
    private int topSite;
    private int bottomSite;
    private int numOfOpen;

    // private helper method used to convert the ideal indices in matrix to actual indices in UF
    private int xy2Uf(int row, int col) {
        return row * length + col;
    }

    // create N-by-N grid, with all sites initially blocked
    public Percolation(int N) {
        if (N <= 0) {
            throw new IllegalArgumentException("N must > 0 ");
        }
        weightedQuickUnionUF = new WeightedQuickUnionUF(N * N + 2);
        siteStatus = new boolean[N][N];
        length = N;
        topSite = N * N;
        bottomSite = N * N + 1;
        numOfOpen = 0;
    }

    // open the site (row, col) if it is not open already
    public void open(int row, int col) {
        if (row < 0 || row > length - 1 || col < 0 || col > length - 1) {
            throw new IndexOutOfBoundsException("row and col must between 0 and N-1");
        }
        if (!siteStatus[row][col]) {
            // open this site
            siteStatus[row][col] = true;
            // check the surrounding sites and connect each other
            connectSurroundOpen(row, col);
            // update numOfOpen
            numOfOpen += 1;
        }
    }

    // private helper method used to connect surrounding open sites
    // no need to BFS search through the array!!
    private void connectSurroundOpen(int row, int col) {
        int thisSite = xy2Uf(row, col);
        // check upSite
        if (row == 0) {
            weightedQuickUnionUF.union(thisSite, topSite);
        } else if (siteStatus[row - 1][col]) {
            int upSite = xy2Uf(row - 1, col);
            weightedQuickUnionUF.union(thisSite, upSite);
        }
        // check downSite
        if (row == length - 1) {
            weightedQuickUnionUF.union(thisSite, bottomSite);
        } else if (siteStatus[row + 1][col]) {
            int downSite = xy2Uf(row + 1, col);
            weightedQuickUnionUF.union(thisSite, downSite);
        }
        // check leftSite
        if (col != 0 && siteStatus[row][col - 1]) {
            int leftSite = xy2Uf(row, col - 1);
            weightedQuickUnionUF.union(thisSite, leftSite);
        }
        // check rightSite
        if (col != length - 1 && siteStatus[row][col + 1]) {
            int rightSite = xy2Uf(row, col + 1);
            weightedQuickUnionUF.union(thisSite, rightSite);
        }
    }

    // is the site (row, col) open?
    public boolean isOpen(int row, int col) {
        if (row >= 0 && row <= length - 1 && col >= 0 && col <= length - 1) {
            return siteStatus[row][col];
        } else {
            throw new IndexOutOfBoundsException("row and col must between 0 and N-1");
        }
    }

    // is the site (row, col) full?
    public boolean isFull(int row, int col) {
        if (row >= 0 && row <= length - 1 && col >= 0 && col <= length - 1) {
            int thisSite = xy2Uf(row, col);
            return weightedQuickUnionUF.connected(thisSite, topSite);
        } else {
            throw new IndexOutOfBoundsException("row and col must between 0 and N-1");
        }
    }

    // number of open sites
    public int numberOfOpenSites() {
        return numOfOpen;
    }

    // does the system percolate?
    public boolean percolates() {
        return weightedQuickUnionUF.connected(topSite, bottomSite);
    }

    // use for unit testing (not required)
    public static void main(String[] args) {

    }
}
