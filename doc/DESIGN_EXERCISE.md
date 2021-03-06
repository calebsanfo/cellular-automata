## Inheritance Review

#### Bricks
```java
class Brick {
    // get the Image of the brick to dispaly on the screen
    pubic ImageView getView()

    // return the health of the brick
    public int getBrickHealth ()

    // this decreases the brick health
    public int updateHealth ()
} 
```

#### Power Ups
```java
class Power {
    // get the Image of the brick to dispaly on the screen
    pubic ImageView getView()

    // drop a powerup from a brick
    public void drop (ImageView Brick)

    // return false when time is up
    public boolean checkTimeout ()
    
    // change the position of the powerup on the screen.
    public void move (int elapsedTime)
} 
```

#### Levels
```java
class Level {
    // read the brick config txt file
    public Brick[] readLevelConfig (File textFile)
} 
```


## Simulation High Level Design
1. The simulation copies the 2D matrix of cell information before updating each cells, 
and thus can refer to the old copy for each neighbor calculation. To know its neighbours, it can hold pointers
to its neighbours above, below, and to its left and right if they exist. 

2. The main method gets the input for the type of simulation and creates the subclasses accordingly. Thus each cell,
 can call update() method to update their state accordingly based on te simulation rules set out when creating the simulation.

3. Within the methods, team seemed to agree that we can use 2D array to implement the grid. However to allow flexibility within classes,
 and methods, those methods can return Iterable of Iterable object. Thus, developers only need to know that the return object is of Iterable type.

4. Everything specific to the simulation should be on configuration file. These can be the size of the grid, the start position, the probability of taking on a certain state in the next step given its neighbours, etc.

5. Simulation is updated by using the grid output 
(or the updated grid) with the simulator method. Simulator method should accept (or use the instance variable) of the grid information, thus once updated
it can be called again easily. 

## Java Signatures (CRC Cards)
````java
class Grid{
   //returns a reference to the cell at row i and column j of the simulaton grid
   public Cell get(int i, int j)
   
   //updates the state of all cells in the grid for 1 step using the simulation rules
   public void update()
   
   //update the state of all cells in the grid for i steps using the simulation rules
   public void update(int i)
   
}

class Cell{
    //Return a String indicating the state of the cell 
    public String getState()
}
