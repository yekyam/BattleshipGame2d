/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package battleship;

import java.util.Random; 
import java.util.Scanner;
/**
 *
 * @author ManuelM
 * Todo: Let users pick amount of ships, size of board,
 */
public class Battleship {
    
    static char ocean[][] = new char[5][5];
    static char enemyShips[][] = new char[5][5];
    static int hits;
    static int misses;
    
    static void generateBoard() {
        for (int i =0; i < ocean.length; i++) {
            ocean[0][i] = '.';
            ocean[1][i] = '.';
            ocean[2][i] = '.';
            ocean[3][i] = '.';
            ocean[4][i] = '.';
            
            enemyShips[0][i] = '.';
            enemyShips[1][i] = '.';
            enemyShips[2][i] = '.';
            enemyShips[3][i] = '.';
            enemyShips[4][i] = '.';
        }
    }
    
    static void printBoard() {
        System.out.println("012345");
        System.out.print("1");
        for (int i=0; i< ocean.length; i++) {
            System.out.print(ocean[0][i]);
        }
        System.out.println();
        System.out.print("2");
        for (int i=0; i< ocean.length; i++) {
            System.out.print(ocean[1][i]);
        }
        System.out.println();
        System.out.print("3");
        for (int i=0; i< ocean.length; i++) {
            System.out.print(ocean[2][i]);
        }
        System.out.println();
        System.out.print("4");
        for (int i=0; i< ocean.length; i++) {
            System.out.print(ocean[3][i]);
        }
        System.out.println();
        System.out.print("5");
        for (int i=0; i< ocean.length; i++) {
            System.out.print(ocean[4][i]);
        }
        System.out.println();
    }
    
    static void userInput() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter two numbers: x y");
        int pos1 = scan.nextInt()-1;
        int pos2 = scan.nextInt()-1;
        if (pos1 > 4 || pos2 > 4) {
            System.out.println("Out of bound shot, try again.");
        }
        else if (enemyShips[pos2][pos1] == 'X') {
            hits++;
            System.out.println("Good shot!");
            enemyShips[pos2][pos1] = ' ';
            ocean[pos2][pos1] = 'X';
        }
        else if (enemyShips[pos1][pos2] == ' ') {
            System.out.println("You've already hit there!!");
        }
        else if (enemyShips[pos1][pos2] == 'O') {
            System.out.println("You've already shot there!!");
        }
        else {
            misses++;
            System.out.println("Try again!");
            enemyShips[pos2][pos1] = 'O';
            ocean[pos2][pos1] = 'O';
        }
        
    }
    
    static void generateShips() {
        Random rand = new Random();
        for (int i = 0; i <=4; i++) {
            enemyShips[rand.nextInt(5)][rand.nextInt(5)] = 'X';
            
        }
    }
    static boolean checkWin() {
        if (hits >= 4){
            System.out.println("You win!");
            return false;
        }
        else {
            return true;
        }
    }
    public static void main(String[] args) {
        generateBoard();
        generateShips();
        boolean running = true;
        while (running == true){
            printBoard();
            userInput();
            running = checkWin();
        }
        System.out.println("You had " + misses + " misses.");
        
    }
    
}
