# Overall program structure

All labyrinth are two dimensional Node-arrays.

Nodes contain x and y values (their place in labyrinth), a value (showing if the node is open space, wall, visited, etc..), a parent (Node from which we arrived to this one), distance to goal (used as heuristic in A*) and shortest path (showing shortest found path so far to this node)

The program is started from gui, the gui uses labyrinth generator to generate labyrinths, which are stored in two-dimensional Node-arrays.

This labyrinth is then passed into an LabyrinthDrawer, that returns a container containing a drawn labyrinth. It also offers a method to update only the updated nodes so as to not draw the whole labyrinth again every time.

After this the labyrinth is passed into a LabyrinthAnimator that passes the labyrinth into solver manager which manages all the steps of the different solving algorithms.

LabyrinthAnimator then periodically updates what user sees by calling LabyrinthDrawers update method and applying the correct step from solver manager.

Solver manager also holds finished labyrinths to use for when all alogrithms are done.

Animator uses javafx timelines for animation, and they are passed lambda-methods that they process every step. In these methods, they call managers next step, drawers update, etc..

When a new labyrinth is made, old animator and IO is replaced by new ones, and all references between them are cut, leaving the animator and IO waiting garbage collection.


GUI-class holds both the labyrinth, and IO below it. From it new labyrinths are made.


# Achieved time and space complexities

As stated in previous documents, there are three hand-made data-structures in this project, them being a heap, a queue and a stack. I will now go throught their complexities one at a time;



* Heap

Heap has six methods available to classes using it, them being add, poll, getSize, isEmpty, remove and toString. Additionally, some of these methods call private methods that are interesting. I will go 

into these private methods as i go through the public ones. 


- add

Functionally add-method has a time-complexity of O(log(n)), since 99% of the time all it does is insert a given object into an array, add to a head pointer and sort the given object up (heapify), but since it sometimes calls a private method called doubleArraySize(),

it essentially has a O(n), since the private method parses through all the stored values. Since the private method doubles array sizes, it is called less and less frequently the more it is called, and therefore

the funtional time complexity is much lower.


- poll

Only part of poll that does more work than O(1), is the private sortDown-method. all it does, is check the children of the polled object, check if their values are smaller than the current one, and switch their places if needed.

This is done recursively, and can be done till the object that was at the top is at the bottom. This can take at max O(log(n)), since it parses throught one arm of the so far perfect tree.


- getSize

All this method does is return head, so it is O(1).


- isEmpty

All this method does is return the boolean value of head == 0, so it is O(1).


- remove

This method parses through the array, and removes the first object that is equal to the given one. 


- toString

Returns string represantion of the data-structure, O(1).


All meta-data this implementation uses, is a head pointer pointing to the top of this array, length int-value for size memory and a Class-modifier to remember what the new bigger array needs to be. These do not

contribute to the size-complexity, since they are static and do not change in required space the more objects are added. So this data-structure has essentially size-complexity of O(n).



* Queue

queue has five methods available to the classes using it, them being put, poll getSize, isEmpty and toString.

getSize, isEmpty and toString work exactly like they do in heap.


- put

This method doubles array size if it is needed, the doubling again needs O(n) time, but the more it is called the less it is needed to be called since it always doubles the array, the rest of the put-method

had a time-complexity of O(1) since it does not have any other work that is relative to the size of the array or the input.


- poll

This method does not call any other methods, and does not do any work relative to the size of the input or the array. It has a time-complexity of O(1).


Space complexity of this data-structure is O(n), since all meta-data it uses is again singular values that do not affect the big picture.


* Stack

Stack has five methods available to the classes using it, them being add, poll, getSize, isEmpty and toString.

Once again, getSize, isEmpty and toString work the same way.

- add

add-method checks if more memory is needed, and doubles the array size if needed. This once again takes O(n), but is called rarely. Otherwise this method just adds the given object into the array raising the head-pointer.

- poll

all poll method does, is return the current top value and reduces the head-pointer by one. It has time-complexity of O(1).


once again the space complexity is O(n) since the stored meta-data is negligible.

# Time and space complexities for search algorithms

- Width-first

This implementation of Width-first always checks the four adjacent nodes next to it, and it can check from each available node, so if V is the number of nodes, and E is the number of connections, then the big o of this

search should be O(4*|V|)



-Depth-first

This implementation of Depth-first always checks the four adjacent nodes next to the active node, so the worst-case scenario is the same as width (it checks every single one)

So the time complexity is O(4*|V|)


-A*

This implementation of A* has the same big o as width-first, but since it is optimized with heuristics, it is always faster or atleast as fast as it. O(4*|V|)


# What does the program lack?

The drawing algorithm lags a bit, this is because the pathfinding-algorithms are run during the animation, but they could apparently be ran beforehand, and saved in an array and passed onto timelines.

This would also allow for an easy implementation of skipable animations, but i am pretty sure i am not going to have the time to make this improvement.


Another thing that could be maybe made better is the animation and io garbage collection. when they are used and new labyrinth is generated, they are supposed to be thrown to the garbage collection. I am not 100% sure if this happens, though.
