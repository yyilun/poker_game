# Poker Game

## Function

This program simulates a poker game. There are 2 ways of playing the game:

1. The default way - the program will prompt you through the game

2. Command line way - select specific cards in order to test the program. E.g.

`h3 s5 c2 d6 d7`

would mean a 3 of heart, 5 of spade, 2 of club, 6 of diamond and 7 of diamond will be placed into the player's hand.

## Game play

The deck is first shuffled at the start of the game. The player will then be presented the top 5 cards from the deck. They will have the option to discard up to 5 cards and re-draw from the top of the deck. After that, the 5 cards will be revealed and the player will be informed if he/ she has received some card combination. After that, the player can decide to end the game or continue with another hand.

## Dependencies (OOP)

PokerTest.java - takes in the arguments and instantiates a version of the game

Game.java - instantiates a player object, and a deck object. Main method that runs the game.

Player.java - contains the 5 cards that the player has picked. Contains methods to add and discard cards to the cards the player currently holds.

Deck.java - contains the 52 cards in the deck. Contains methods to shuffle and deal cards.

Card.java - contains the value of each individual card. Contains methods to translate suit and value into encoded integers.
