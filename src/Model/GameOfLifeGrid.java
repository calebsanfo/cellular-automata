package Model;

/**
 * Facilitates a simulation of the Game of Life
 * @author Achilles Dabrowski 
 */
public class GameOfLifeGrid extends Grid{

  public static final int maxAliveNeighbors = 3;
  public static final int minAliveNeighbors = 2;

  /**
   * Create a grid to run the Game of Life simulation
   * @param initConfig an array of Strings corresponding to each cell's initial state. "ALIVE" = cell with living person.
   *                   "DEAD" = cell with dead person
   */
  public GameOfLifeGrid(String[][] initConfig, String edgeType, String neighborType){
    super(initConfig, edgeType, neighborType);
    myCellsCopy = copyCells();
  }

  public void setCellState(int i, int j, String state){
    myCells[i][j] = GameOfLifeCell.valueOf(state);
  }

  protected void updateCellState(int i, int j){
    int aliveCount = findNeighborIndices(i, j, GameOfLifeCell.ALIVE).size();
    if(myCellsCopy[i][j] == GameOfLifeCell.ALIVE && ( (aliveCount > maxAliveNeighbors) || (aliveCount < minAliveNeighbors) )){
      myCells[i][j] = GameOfLifeCell.DEAD;
    }
    else if(aliveCount == maxAliveNeighbors){
      myCells[i][j] = GameOfLifeCell.ALIVE;
    }
  }

}
