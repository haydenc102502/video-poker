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
