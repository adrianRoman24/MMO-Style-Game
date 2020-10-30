MMO style action game

Description of the first part of the project:

    I used Double-Dispatch like this: Hero is a class
abstract that is extended by the four races of heroes (Knight, Pyromancer, Rogue,
Wizard). Each hero will visit (attack) another hero of any type, and each hero
another hero will be attacked (accepted). The Hero class will have visiting methods
(visit Pyromancer, visit Knight etc), these being overwritten in each subclass
(Knight, Pyromancer, Rogue, Wizard). Each subclass has a method to visit
for all 4 races, and each subclass has an accept method (hero) {hero.
visit (this);}, so when the hero calls the visit method it will look at the instance
they at runtime and not at the reference of the current class, thus realizing the polymorphism
dynamic or double-dispatch. Methods are called in the Game class (example hero1.accept (hero2))
without having to specify the race of hero1 or hero2 because I used polymorphism
dynamic. I left the name visit and I accept to be clear, but I accept the method
could be translated as "the hero receives damage" and the visit method as "the hero gives damage".

#    The program has three main stages:
    
1. Reading / retrieving input data
2. Development of the game
3. Writing output data

1. Reading / retrieving input data

    This is done thanks to the GameInputLoader class that reads the data
input from the args input file [0] using the load function. He takes over
heroes [], map matrix (map [] []), number of lines on the map
(mapRows), the number of columns in the map (mapColumns), the number of players (noHeroes),
the number of rounds (nrRounds) of the game and the total number of moves of players in
heroesMoves string vector (each string represents the changes in order of
players).
    The loadGame function loads a game, meaning it assigns the data read and mentioned above.
    
    2. Development of the game
    This happens in the play function of the Game class. Initially, all players are assigned
in memory and have the initial coordinates, so we know where it is on the initial map. The first forum is
to go through each round (line 69). In the second forum (line 71) each hero
execute the move from that round if it is still alive, and then the damage is activated
overtime if they exist (eg ignite or paralysis). In case the hero is still alive he is
added to the list of map heroes at the respective coordinates. With the following two forums (lines
91 and 92) the map matrix is ​​traversed and in case two players are found in one place it takes place
the fight between the two. Hero1.accept (hero2) means that hero2 will calculate the damage that
he will give it to hero1 and vice versa. If both heroes are alive, then they calculate
the damage they will give each other and then subtract that damage from their current hp.
If one of them dies and the other survives, then the latter will be added appropriate experience and will
level up in case the experience is sufficient. Methods of visit are transposing the formulas from the
requirement into the code, but it is important to mention that satisfied double-dispatch (mentioned above)
each hero has a specialized method for everything race so in the Game class all you have to do is call the
accept method, and it will know how to use it the correct type of visit because in the method I accept the
visitor (in the class I accept the visitor's court is known) knows which instance is the current class thanks
to the "this" keyword. Next, if a hero dies we will not consider it for anything during the game.

3. Writing output data
    This is done by the GameOutputWriter class which receives the game as a parameter and writes
in the output file the status (race / type level experience hp coordinateX coordinateY) of each
hero on each line.

    Description of the second stage of the project

    I used the Constants class to retain the constants.
    The map class is just a unit of the entire map and retains a list of players who are in one
certain moment in the respective unit and the type of land (ex Volcanic).
    The Point2D class is used to retain the coordinates of a point.
    The Buffs class can contain both over time damage that will be deducted from the hero's hp at
the beginning of the round, but also disabilities that will be reduced when the move from method is used
Hero class, and the hero will remain at the same coordinates at that time.
    The allocation of heroes is done with HeroesFactory.
    Description of new added classes and features:
    
    -The angels package that contains an abstract "basic" class for angels who
contains abstract methods that will be implemented by each type of angel that will
expand this class. AngelsFactory creates (spawns) angels according to
the type and coordinates received as parameters. Every angel extends this
abstract class
