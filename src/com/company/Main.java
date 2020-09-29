package com.company;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;
import java.lang.String;

public class Main {

    public static void main(String[] args) {
        Deque<Integer> FirstPlayerCard = new ArrayDeque<>();
        Deque<Integer> SecondPlayerCard = new ArrayDeque<>();
        int count = 0;
        Scanner sc = new Scanner(System.in);
        for (String part : sc.nextLine().split(" ")) {
            FirstPlayerCard.offerLast(Integer.parseInt(part));
        }
        for (String part : sc.nextLine().split(" ")) {
            SecondPlayerCard.offerLast(Integer.parseInt(part));
        }

        while (FirstPlayerCard.peek() != null || SecondPlayerCard.peek() != null) {
            Integer cardFirstPlayer = FirstPlayerCard.poll();
            Integer cardSecondPlayer = SecondPlayerCard.poll();
            count++;
            if (cardFirstPlayer == 0 && cardSecondPlayer == 9) {
                FirstPlayerCard.addLast(cardFirstPlayer);
                FirstPlayerCard.addLast(cardSecondPlayer);
                break;
            }
            if (cardFirstPlayer == 9 && cardSecondPlayer == 0) {
                SecondPlayerCard.addLast(cardFirstPlayer);
                SecondPlayerCard.addLast(cardSecondPlayer);
                break;
            }
            if (cardFirstPlayer > cardSecondPlayer) {
                FirstPlayerCard.addLast(cardFirstPlayer);
                FirstPlayerCard.addLast(cardSecondPlayer);
            }
            else {
                SecondPlayerCard.addLast(cardFirstPlayer);
                SecondPlayerCard.addLast(cardSecondPlayer);
            }
            if (count == 106) {
                System.out.println("Draw");
                System.exit(0);
            }
        }
        if (FirstPlayerCard.peek() == null) {
            System.out.println("Second " + count);
        } else {
            System.out.println("First " + count);
        }
    }
}
