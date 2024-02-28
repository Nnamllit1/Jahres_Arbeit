/**
 *
 * Beschreibung
 *
 * @version 1.0 vom 17.01.2024
 * @author 
 */
import java.io.*;
import java.lang.*;

public class main {
  static int max_uboot = 10;
  static int max_x = 10;
  static int max_y = 10;
  static int [] [] game_field = new int [max_x] [max_y];
  
  public static void println(String text) {
    System.out.println(text);
  }
  
  public static void println_int(int text) {
    System.out.println(text);
  }
  
  public static void print(String text) {
    System.out.print(text);
  }
  
  public static void print_int(int text) {
    System.out.print(text);
  }
    
  public static String input(String lul){
    print(lul);
    return System.console().readLine();
  }
  
  public static void test() {
    String output = input("Test: ");
    println(output);
  }
  
  public static void print_game() {

    String leer = " ";
    String x_unter = "-";
    String y_unter = "|";
    String plus = "+";
    String end_line = "\n";
    
    for (int i = 0; i < 4; i++) {
      print(String.valueOf(leer));
    }
    print(String.valueOf(y_unter));
    print(String.valueOf(leer));
      
    for (int y = 0; y < max_y; y++) {
      print(String.valueOf(y));
      print(String.valueOf(leer));
      print(String.valueOf(y_unter));
      print(String.valueOf(leer));
    }
    print(String.valueOf(end_line));
    new_line();
    
    for (int y = 0; y < max_y; y++) {
      
      print(String.valueOf(y_unter));
      print(String.valueOf(leer));
      print(String.valueOf(y));
      print(String.valueOf(leer));
      print(String.valueOf(y_unter));
      
      for (int x = 0; x < max_x; x++) {
        print(" ");
        if (game_field [x] [y] == 2) {
          print("~");
        } else if (game_field [x] [y] == 3) {
          print("#"); 
        } else {
          print(String.valueOf(game_field [x] [y]));
        } // end of if-else
        print(" |");
      }
      print("\n");
      new_line();
    }
    
  }
  
  public static void new_line() {
    print("+");
    for (int x = 0; x < (max_x + 1); x++) {
      print("---");
      print("+");
    }
    print("\n");
  }
  
  public static void game_field_fill() {
    for (int x = 0; x < max_x; x++) {
      for (int y = 0; y < max_y; y++) {
        game_field [x] [y] = 0;
      }
    }
  }
  
  public static void random_uboot_gen() {
    int anzahl = 0;
    do {
      int zu1 = (int) (Math.random() *10);
      int zu2 = (int) (Math.random() *10);
    
      if (game_field [zu1] [zu2] == 0) {
        game_field [zu1] [zu2] = 1;
        anzahl = anzahl + 1;
      } // end of if
    } while (anzahl < max_uboot); // end of do-while
  }
  
  public static void user_input() {
    int treffer = 0;
    do {
      print_game();
      int x = Integer.valueOf(input("Zeile: "));
      int y = Integer.valueOf(input("Spalte: "));
      
      if (game_field [x] [y] == 1) {
        println("Treffer versengt");
        game_field [x] [y] = 3;
        treffer++;
      } else {
        println("Verfehlt");
        game_field [x] [y] = 2;
      } // end of if-else
    } while (treffer < max_uboot); // end of do-while
  }
  
  public static void game_logik() {
    game_field_fill();
    random_uboot_gen();
    user_input();
  }
 
  public static void main(String[] args) {
    game_logik();
  } // end of main

} // end of class main

