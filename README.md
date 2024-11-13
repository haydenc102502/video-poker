# Video Poker Game

Created By: Hayden Cabral
## About
This is a game based on common casino five-card draw poker games. The player will start with a balance of $100, and bet $5 per hand. When dealt a hand, the player may choose to hold any of their cards, and the other cards will be redrawn.
The resulting poker hand will give a score based on the hand type, and play repeats until the player runs out of money or quits.

To hold cards: simply type <y/n> at the prompt for each card. The CLI will indicate how each card is numbered.

## UML Class Diagram
There are two subsystems within the game that warranted design patterns. The first was the Game State subsystem, which used the state design pattern. There are multiple distinct states throughout a poker game- dealing the five cards, selecting and
dealing redraws, and scoring the hand. Because the same shoe of cards is used throughout each phase of play, it is important to maintain the same game object throughout this process and reset the shoe at the end,
as each hand is independent.

The second subsystem is the Poker Hand subsystem. Each poker hand has a different name, score, and most importantly conditions for creation. The factory method design pattern worked well for this because of the ability to manage the creation of the hands and the various conditions needed for correctly evaluating them. Not only does this make it easier to evaluate certain hands (straight flush being a combination of a straight and a flush), but also adds flexibility for more hand options down the line, such as four of a kind hands with kickers that you see in real video poker games.


[UML class.pdf](https://github.com/user-attachments/files/17388069/UML.class.pdf)

## Requirements Diagram
The requirements illustrated within this diagram correlate well with the existing subsystems noted above.

Scoring hands was an important requirement for a video poker game, and ensuring that each hand was scored correctly to promote balanced gameplay. These hands are related in a composite relationship to
Requirement 1: Hand Scoring.

Requirement 2: Player Token Balance is derived from Requirement 1 due to the necessity of the hand score to update a player's token balance. Another derivation relationship is seen from Requirement 3.3: Scoring State due to the necessity of hand scoring to keep track of a player's balance. The rest of the game states are modeled in a composite relationship within Requirement 3: Game States. Requirements 2 and 3 are also related to the overarching Player Betting Requirement, which is necessary to facilitate game states or hand scores.

The diagram does a good job of relating to the two subsystems described above: The Poker Hand subsystem with the factory method pattern and the Game State subsystem using the state pattern. Although the two diagrams are different, these two subsystems are still recognizable throughout them.

[Requirements Diagram.pdf](https://github.com/user-attachments/files/17724920/Requirements.Diagram.pdf)
