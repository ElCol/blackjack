import java.util.ArrayList;

import java.util.*;
import java.util.Random;
import java.util.Scanner;
import java.util.List;

public class card {
    public static void main(String[] args) {

        PlayingCard H1 = new PlayingCard("ace", "hearts", 11);
        PlayingCard H2 = new PlayingCard("2", "hearts", 2);
        PlayingCard H3 = new PlayingCard("3", "hearts", 3);
        PlayingCard H4 = new PlayingCard("4", "hearts", 4);
        PlayingCard H5 = new PlayingCard("5", "hearts", 5);
        PlayingCard H6 = new PlayingCard("6", "hearts", 6);
        PlayingCard H7 = new PlayingCard("7", "hearts", 7);
        PlayingCard H8 = new PlayingCard("8", "hearts", 8);
        PlayingCard H9 = new PlayingCard("9", "hearts", 9);
        PlayingCard H10 = new PlayingCard("10", "hearts", 10);
        PlayingCard H11 = new PlayingCard("jack", "hearts", 10);
        PlayingCard H12 = new PlayingCard("queen", "hearts", 10);
        PlayingCard H13 = new PlayingCard("king", "hearts", 10);


        PlayingCard S1 = new PlayingCard("ace", "spades", 11);
        PlayingCard S2 = new PlayingCard("2", "spades", 2);
        PlayingCard S3 = new PlayingCard("3", "spades", 3);
        PlayingCard S4 = new PlayingCard("4", "spades", 4);
        PlayingCard S5 = new PlayingCard("5", "spades", 5);
        PlayingCard S6 = new PlayingCard("6", "spades", 6);
        PlayingCard S7 = new PlayingCard("7", "spades", 7);
        PlayingCard S8 = new PlayingCard("8", "spades", 8);
        PlayingCard S9 = new PlayingCard("9", "spades", 9);
        PlayingCard S10 = new PlayingCard("10", "spades", 10);
        PlayingCard S11 = new PlayingCard("jack", "spades", 10);
        PlayingCard S12 = new PlayingCard("queen", "spades", 10);
        PlayingCard S13 = new PlayingCard("king", "spades", 10);


        PlayingCard D1 = new PlayingCard("ace", "diamonds", 11);
        PlayingCard D2 = new PlayingCard("2", "diamonds", 2);
        PlayingCard D3 = new PlayingCard("3", "diamonds", 3);
        PlayingCard D4 = new PlayingCard("4", "diamonds", 4);
        PlayingCard D5 = new PlayingCard("5", "diamonds", 5);
        PlayingCard D7 = new PlayingCard("7", "diamonds", 7);
        PlayingCard D6 = new PlayingCard("6", "diamonds", 6);
        PlayingCard D8 = new PlayingCard("8", "diamonds", 8);
        PlayingCard D9 = new PlayingCard("9", "diamonds", 9);
        PlayingCard D10 = new PlayingCard("10", "diamonds", 10);
        PlayingCard D11 = new PlayingCard("jack", "diamonds", 10);
        PlayingCard D12 = new PlayingCard("queen", "diamonds", 10);
        PlayingCard D13 = new PlayingCard("king", "diamonds", 10);



        PlayingCard C1 = new PlayingCard("ace", "clubs", 11);
        PlayingCard C2 = new PlayingCard("2", "clubs", 2);
        PlayingCard C3 = new PlayingCard("3", "clubs", 3);
        PlayingCard C4 = new PlayingCard("4", "clubs", 4);
        PlayingCard C5 = new PlayingCard("5", "clubs", 5);
        PlayingCard C7 = new PlayingCard("7", "clubs", 7);
        PlayingCard C6 = new PlayingCard("6", "clubs", 6);
        PlayingCard C8 = new PlayingCard("8", "clubs", 8);
        PlayingCard C9 = new PlayingCard("9", "clubs", 9);
        PlayingCard C10 = new PlayingCard("10", "clubs", 10);
        PlayingCard C11 = new PlayingCard("jack", "clubs", 10);
        PlayingCard C12 = new PlayingCard("queen", "clubs", 10);
        PlayingCard C13 = new PlayingCard("king", "clubs", 10);



        Collections.shuffle(PlayingCard.deck);
        System.out.println("The dealer shows you the shuffled deck...");
        showHands(PlayingCard.deck);
        Collections.shuffle(PlayingCard.deck);
        System.out.println("...then reshuffles it and gives you two cards:");
        List<PlayingCard> playersHand = new ArrayList<PlayingCard>();
        playersHand = dealHand(PlayingCard.deck, 2);
        showHands(playersHand);
        System.out.println("Your hand is worth " + points(playersHand) +" points.");

        List<PlayingCard> dealersHand = new ArrayList<PlayingCard>();
        dealersHand = dealHand(PlayingCard.deck, 2);
        System.out.println("This the card you are allowed to see from the dealer's hand:");
        showHandsDealer(dealersHand);
        System.out.println("Would you like one more card ('k'), pass ('p') or quit ('q')?");

        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        char inputChar = input.charAt(0);

        playerChoice(playersHand,PlayingCard.deck,  inputChar);










    }
    public static <E> List<E> dealHand(List<E> deck, int n) {
        int deckSize = deck.size();
        List<E> handView = deck.subList(deckSize - n, deckSize);
        List<E> hand = new ArrayList<E>(handView);
        handView.clear();
        return hand;
    }
    public static  List<String> showHands(List<PlayingCard> cards){
        ArrayList<String> dtest = new ArrayList<String>();
        for (int i = 0; i <  cards.size() ; i++  ){
        dtest.add(cards.get(i).rank +" of "+ cards.get(i).suit);
    }
    System.out.println(dtest);
        return dtest;}


    public static  List<String> showHandsDealer(List<PlayingCard> cards){
        ArrayList<String> dtest = new ArrayList<String>();
        for (int i = 0; i <  cards.size() - 1 ; i++  ){
            dtest.add(cards.get(i).rank +" of "+ cards.get(i).suit);
        }
        System.out.println(dtest);
        return dtest;}

        public static void playerChoice(List<PlayingCard> playerhand, List<PlayingCard> cards, char a){
            List<PlayingCard> extraCard = new ArrayList<PlayingCard>();
            List<PlayingCard> emptyList = new ArrayList<PlayingCard>();
            if (a == 'k'){
               extraCard = dealHand(cards, 1);
               showHands(extraCard);
               showHands(playerhand);
               System.out.println("Your hand is now worth " + (points(playerhand) + points(extraCard)) +" points.");
            }
            else if (a == 'q'){
                System.exit(0);

            }
        }




    public static int points(List<PlayingCard> list) {

        int sum = 0;
        for (int i =0; i < list.size(); i++) {

        sum += list.get(i).value;
        }
        return sum;
    }

}
    class PlayingCard {
       public static ArrayList<PlayingCard> deck = new ArrayList<PlayingCard>();
        String rank;
        String suit;
        int value;
        PlayingCard(String Rank, String Suit, int Value){
            rank = Rank;
            suit = Suit;
            value = Value;
            deck.add(this);
        }






    }


