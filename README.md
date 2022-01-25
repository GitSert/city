# city
This is the outcome of the program SDE assignment.
I was planning to do this assignment with a teammate but they ended up not having enough time to make this program. Because of this I asked Andries if I could do this alone, which he said was okay.

# the program
This is a command line program in which you can build a city by selecting buildings and utilities which you customize.
After customizing the city, the total inhabitants are shown and all of the buildings and utilities with their customizations.

# assignment
Part of the assignment was to incorporate creational, structural and behavioral design patterns.
For the creational patterns, I made 2 factories. One for buildings and another for utilities. In these factories a switch is used to determine which building/utility to make.
For the structural patterns, I made 2 facades. One for Buildings and another for utilities.
For the behavioral patterns, I made an observer. This observer tells the user that they successfully chose a building/utility, it tells them the config they chose and when the building/utility is built.
