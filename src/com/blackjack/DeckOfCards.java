package com.blackjack;

//***************************************************************

//Author: Billy Suttlemyre            Class: COP2551 Intro to OOP   *

//Date: 03/23/2015                Hours Worked: 15 hours         *

//                                                              *

//I, Billy Suttlemyre, hereby pledge on my honor that this code is  *

//solely that of my own. I received no help whatsoever with this*

//project other than with general concepts and debugging.       *

//I did not code this alongside any friend and I did not copy   *

//any lines of code from either the web or from a friend. I can *

//explain the logic of every single line of this code without   *

//hesitation when asked and I understand that I may be asked to *

//do so by the professor. If I am found to be in violation of   *

//this contract, which is based on the Academic Misconduct      *

//policy found in the syllabus, I understand that I will receive*

//an unforgiveable "F" for this course regardless of my prior   *

//grades. I used the textbook's Card and DeckOfCards classes.                                                       *

//***************************************************************
import com.blackjack.Card;
import java.security.SecureRandom;
public class DeckOfCards 
{
    private Card[] deck; //create an array of card objects
    private int currentCard; //index of next Card to be dealt (0-51)
    private static final int NUMBER_OF_CARDS = 52; //constant number of cards
    //random number generator
    private static final SecureRandom randomNumbers = new SecureRandom();
    
    //constructor fills deck with cards
    public DeckOfCards()
    {
        String[] faces = {"Ace", "Deuce", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Jack", "Queen", "King"};
        String[] suits = {"Hearts", "Diamonds", "Clubs", "Spades"};
        
        deck = new Card[NUMBER_OF_CARDS]; //Create an array of card objects
        currentCard = 0; //first card dealt will be deck[0]
        
        //fill the deck with cards
        for(int count = 0; count<deck.length; count++ )
        deck[count] = new Card(faces[count % 13], suits[count / 13]);
                
    }
    //Shuffle the deck
    public void shuffle()
    {
        currentCard = 0;
        for (int first = 0; first < deck.length; first++)
        {
            int second = randomNumbers.nextInt(NUMBER_OF_CARDS);
        //Swap current card with random card
            Card temp = deck[first];
            deck[first] = deck[second];
            deck[second] = temp;
            }
        
        
        }
       //Deal a card
    public Card dealCard()
    {
        if (currentCard < deck.length)
            return deck[currentCard ++];
        else
            return null;
    
    
    
    }
    
    }
    

