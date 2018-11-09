# Overview

In this project, i am going to make a program that generates labyrinths randomly, and then solves them using three different path-finding algorithms; breadth-first, depth-first and A* algorithms.
User can observe the labyrinth be solved in a gui, and after the program is done, user can observe how many steps each algorithm took to solve the labyrinth.
After this, the program can be made to do it all over again without having to close it in between.


## What data structures do i need?

for breadth-first algorithm i am going to need a queue data-structure to parse through the nodes in order.

for depth-first algorithm i am going to need a stack data-structure to know what nodes come after the handled node.

for A* i am going to need a heap data-structure to keep an eye on the node with the lowest assosiated values.

Some possible extra ones if i get fancy with the labyrinth generation (the brute-force solution i have in mind currently does not require anything, but i might want to upgrade it at some point)


## Why did i choose this topic?

I was torn between choosing this and the randomly generated dungeon crawler map, so i figured i could somehow combine them in some way.

I also have some experience in making the needed data-structures, since i have played around in unity and actually made a heap data-structure myself since unity does not come with one.


## What inputs does the program use?

The program is going to have a gui with only one button that generates a new labyrinth and starts to solve it using different algorithms, so that one button is the input.


## Target time and space complexities

The first labyrinth generation algorithm is going to have horrible time complexity, since i am going to brute force it, but all the other algorithms are going to (hopefully) have their respective worst-case

scenario time complexities;

![image](https://user-images.githubusercontent.com/32302869/47970084-58d07d00-e089-11e8-89d6-ff54cc7ae6e3.png)

## Sources

Picture: http://bigocheatsheet.com/
