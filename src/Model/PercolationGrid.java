package Model;

import java.util.ArrayList;

/**
 * Facilitates a simulation of Percolation
 * @author Achilles Dabrowski
 */
public class PercolationGrid extends Grid {

    /**
     * Create a grid to run the Percolation simulation
     * @param initConfig an array of Strings corresponding to each cell's initial state.
     *                   "FULL" = filled cell. "EMPTY" = empty cell. "PERCOLATED" = percolated cell
     */
    public PercolationGrid(String[][] initConfig){
        super(initConfig, SQUARE_INDEX_DELTA);
        myCellsCopy = copyCells();
    }

    public void setCellState(int i, int j, String state){
        myCells[i][j] = PercolationCell.valueOf(state);
    }

    protected void updateCellState(int i, int j){
        ArrayList<IndexPair> percolatedCellIndices = findNeighborIndices(i, j, PercolationCell.PERCOLATED);
        if(myCellsCopy[i][j] == PercolationCell.EMPTY && (!percolatedCellIndices.isEmpty()) ) {
            myCells[i][j] = PercolationCell.PERCOLATED;
        }
    }
}