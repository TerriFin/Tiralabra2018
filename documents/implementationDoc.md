# Overall program structure

All labyrinth are two dimensional Node-arrays.

Nodes contain x and y values (their place in labyrinth), a value (showing if the node is open space, wall, visited, etc..), a parent (Node from which we arrived to this one), distance to goal (used as heuristic in A*) and shortest path (showing shortest found path so far to this node)

The program is started from gui, the gui uses labyrinth generator to generate labyrinths, which are stored in two-dimensional Node-arrays.

This labyrinth is then passed into an LabyrinthDrawer, that returns a container containing a drawn labyrinth. It also offers a method to update only the updated nodes so as to not draw the whole labyrinth again every time.

After this the labyrinth is passed into a LabyrinthAnimator that passes the labyrinth into solver manager which manages all the steps of the different solving algorithms.

LabyrinthAnimator then periodically updates what user sees by calling LabyrinthDrawers update method and applying the correct step from solver manager.

## TO DO

### FINISH THIS DOCUMENT
