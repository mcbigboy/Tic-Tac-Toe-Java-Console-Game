import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;

public class Game {

    public HashMap<Integer,String> square;
    public Scanner userInput;
    public String player;
    public String computer;
    public boolean whosTurn;
    public Random rnd;

    public Game() {

        this.square = new HashMap<>();
        this.userInput = new Scanner(System.in);
        this.rnd = new Random();
        this.player = "";
        this.computer = "";
        this.whosTurn = false;

        genSqaureData();

        runGame();
    }

    public static void main(String[] args) {

        Game game = new Game();

    }

    public void runGame(){
        boolean done = false;
        int rounds = 1;

        pickSides();
        pickWhoTurn();

        while (!done){

            System.out.println("Round: " + rounds);
            System.out.println();

            displayBoard();

            if(whosTurn){
                playerMove();
                if(checkWin(player)){
                    System.out.println("You win!");
                    done = true;
                }
            } else {
                computerMove();
                if(checkWin(computer)){
                    System.out.println("Computer win!");
                    done = true;
                }
            }

            whosTurn = !whosTurn;
            rounds++;

            if(rounds > 9){
                done = true;
                System.out.println("Sorry, no one win.");
            }
        }

    }

    public String addColor(String square){

        if(Character.isDigit(square.charAt(0))) {
            return square;
        }

        String buildColor = "";

        if(square.equalsIgnoreCase("X")){
            buildColor = "\u001B[31m";
        } else {
            buildColor = "\u001B[35m";
        }

        buildColor += square + "\u001B[0m";

        return buildColor;
    }

    public int blockPlayer(){
        for(int i = 1; i < 9; i++){
            switch (i){
                case 1:
                    if(square.get(1).equalsIgnoreCase(player) &&
                       square.get(2).equalsIgnoreCase(player) &&
                       Character.isDigit(square.get(3).charAt(0))){
                        return 3;
                    }

                    if(Character.isDigit(square.get(1).charAt(0)) &&
                       square.get(2).equalsIgnoreCase(player) &&
                       square.get(3).equalsIgnoreCase(player) ){
                       return 1;
                    }

                    if(square.get(1).equalsIgnoreCase(player) &&
                       Character.isDigit(square.get(2).charAt(0)) &&
                       square.get(3).equalsIgnoreCase(player) ){
                        return 2;
                    }
                    break;

                case 2:
                    if(square.get(4).equalsIgnoreCase(player) &&
                       square.get(5).equalsIgnoreCase(player) &&
                       Character.isDigit(square.get(6).charAt(0))){
                        return 6;
                    }

                    if(Character.isDigit(square.get(4).charAt(0)) &&
                       square.get(5).equalsIgnoreCase(player) &&
                       square.get(6).equalsIgnoreCase(player) ){
                        return 4;
                    }

                    if(square.get(4).equalsIgnoreCase(player) &&
                       Character.isDigit(square.get(5).charAt(0)) &&
                       square.get(6).equalsIgnoreCase(player) ){
                        return 2;
                    }
                    break;

                case 3:
                    if(square.get(7).equalsIgnoreCase(player) &&
                            square.get(8).equalsIgnoreCase(player) &&
                            Character.isDigit(square.get(9).charAt(0))){
                        return 9;
                    }

                    if(Character.isDigit(square.get(7).charAt(0)) &&
                            square.get(8).equalsIgnoreCase(player) &&
                            square.get(9).equalsIgnoreCase(player) ){
                        return 7;
                    }

                    if(square.get(7).equalsIgnoreCase(player) &&
                            Character.isDigit(square.get(8).charAt(0)) &&
                            square.get(9).equalsIgnoreCase(player) ){
                        return 8;
                    }
                    break;

                case 4:
                    if(square.get(1).equalsIgnoreCase(player) &&
                            square.get(4).equalsIgnoreCase(player) &&
                            Character.isDigit(square.get(7).charAt(0))){
                        return 7;
                    }

                    if(Character.isDigit(square.get(1).charAt(0)) &&
                            square.get(4).equalsIgnoreCase(player) &&
                            square.get(7).equalsIgnoreCase(player) ){
                        return 1;
                    }

                    if(square.get(1).equalsIgnoreCase(player) &&
                            Character.isDigit(square.get(4).charAt(0)) &&
                            square.get(7).equalsIgnoreCase(player) ){
                        return 4;
                    }
                    break;

                case 5:
                    if(square.get(2).equalsIgnoreCase(player) &&
                            square.get(5).equalsIgnoreCase(player) &&
                            Character.isDigit(square.get(8).charAt(0))){
                        return 8;
                    }

                    if(Character.isDigit(square.get(2).charAt(0)) &&
                            square.get(5).equalsIgnoreCase(player) &&
                            square.get(9).equalsIgnoreCase(player) ){
                        return 2;
                    }

                    if(square.get(2).equalsIgnoreCase(player) &&
                            Character.isDigit(square.get(5).charAt(0)) &&
                            square.get(8).equalsIgnoreCase(player) ){
                        return 5;
                    }
                    break;


                case 6:
                    if(square.get(3).equalsIgnoreCase(player) &&
                            square.get(6).equalsIgnoreCase(player) &&
                            Character.isDigit(square.get(9).charAt(0))){
                        return 9;
                    }

                    if(Character.isDigit(square.get(3).charAt(0)) &&
                            square.get(6).equalsIgnoreCase(player) &&
                            square.get(9).equalsIgnoreCase(player) ){
                        return 3;
                    }

                    if(square.get(3).equalsIgnoreCase(player) &&
                            Character.isDigit(square.get(6).charAt(0)) &&
                            square.get(9).equalsIgnoreCase(player) ){
                        return 6;
                    }
                    break;

                case 7:
                    if(square.get(1).equalsIgnoreCase(player) &&
                            square.get(5).equalsIgnoreCase(player) &&
                            Character.isDigit(square.get(9).charAt(0))){
                        return 9;
                    }

                    if(Character.isDigit(square.get(1).charAt(0)) &&
                            square.get(5).equalsIgnoreCase(player) &&
                            square.get(9).equalsIgnoreCase(player) ){
                        return 1;
                    }

                    if(square.get(1).equalsIgnoreCase(player) &&
                            Character.isDigit(square.get(5).charAt(0)) &&
                            square.get(9).equalsIgnoreCase(player) ){
                        return 5;
                    }
                    break;

                case 8:
                    if(square.get(3).equalsIgnoreCase(player) &&
                            square.get(5).equalsIgnoreCase(player) &&
                            Character.isDigit(square.get(7).charAt(0))){
                        return 7;
                    }

                    if(Character.isDigit(square.get(3).charAt(0)) &&
                            square.get(5).equalsIgnoreCase(player) &&
                            square.get(7).equalsIgnoreCase(player) ){
                        return 3;
                    }

                    if(square.get(3).equalsIgnoreCase(player) &&
                            Character.isDigit(square.get(5).charAt(0)) &&
                            square.get(7).equalsIgnoreCase(player) ){
                        return 5;
                    }

            }
        }

        return 0;
    }

    public boolean checkWin(String letter){

        for(int i = 1; i < 9; i++){
            switch (i){
                case 1:
                    if(square.get(1).equalsIgnoreCase(letter) &&
                       square.get(2).equalsIgnoreCase(letter) &&
                       square.get(3).equalsIgnoreCase(letter)){
                        return true;
                    }
                    break;

                case 2:
                    if(square.get(4).equalsIgnoreCase(letter) &&
                       square.get(5).equalsIgnoreCase(letter) &&
                       square.get(6).equalsIgnoreCase(letter)){
                        return true;
                    }
                    break;

                case 3:
                    if(square.get(7).equalsIgnoreCase(letter) &&
                       square.get(8).equalsIgnoreCase(letter) &&
                       square.get(9).equalsIgnoreCase(letter)){
                        return true;
                    }
                    break;

                case 4:
                    if(square.get(1).equalsIgnoreCase(letter) &&
                       square.get(4).equalsIgnoreCase(letter) &&
                       square.get(7).equalsIgnoreCase(letter)){
                        return true;
                    }
                    break;

                case 5:
                    if(square.get(2).equalsIgnoreCase(letter) &&
                       square.get(5).equalsIgnoreCase(letter) &&
                       square.get(8).equalsIgnoreCase(letter)){
                        return true;
                    }
                    break;

                case 6:
                    if(square.get(3).equalsIgnoreCase(letter) &&
                       square.get(6).equalsIgnoreCase(letter) &&
                       square.get(9).equalsIgnoreCase(letter)){
                        return true;
                    }
                    break;

                case 7:
                    if(square.get(1).equalsIgnoreCase(letter) &&
                       square.get(5).equalsIgnoreCase(letter) &&
                       square.get(9).equalsIgnoreCase(letter)){
                        return true;
                    }
                    break;

                case 8:
                    if(square.get(3).equalsIgnoreCase(letter) &&
                       square.get(5).equalsIgnoreCase(letter) &&
                       square.get(7).equalsIgnoreCase(letter)){
                        return true;
                    }
            }
        }

        return false;
    }

    public void computerMove(){

        boolean doItAgain = false;
        int num = 0;

        do {
            doItAgain = false;


            num = blockPlayer();

            if(num == 0) {
                num = rnd.nextInt(9) + 1;
            }
            if(checkSquare(num)){
                square.replace(num,computer);
            } else {
                doItAgain = true;
            }


        } while (doItAgain);


    }

    public void playerMove(){

        boolean doItAgain = false;
        int num = 0;

        do {
            doItAgain = false;

            System.out.print("Enter square number: ");
            num = getInt();

            if(checkSquare(num)){
                square.replace(num,player);
            } else {
                System.out.println("Invalid input, try again!");
                doItAgain = true;
            }


        } while (doItAgain);


    }

    public boolean checkSquare(int checkSquare){

        return Character.isDigit(square.get(checkSquare).charAt(0));
    }

    public void pickWhoTurn(){
        boolean doItAgain = false;
        int num = 0;

        System.out.println("Do you want to be Heads or Tails");
        System.out.println("1: Heads");
        System.out.println("2: Tails");
        System.out.print("Enter 1-2: ");

        do {

            num = getInt();

            if(num != 1 && num != 2){
                doItAgain = true;
                System.out.print("Can't you read, only 1 or 2: ");
            }

        } while (doItAgain);

        if(rnd.nextInt(100) < 50){
            whosTurn = false;
        }
    }

    public void pickSides(){
        boolean doItAgain = false;
        int num = 0;

        System.out.println("Do you want to be X or O");
        System.out.println("1: X");
        System.out.println("2: O");
        System.out.print("Enter 1-2: ");

        do {

            num = getInt();

            if(num != 1 && num != 2){
                doItAgain = true;
                System.out.print("Dick head, only 1 or 2: ");
            }

        } while (doItAgain);

        if(num == 1){
            player = "X";
            computer = "O";
        } else {
            player = "O";
            computer = "X";
        }
    }

    public int getInt(){

        boolean doItAgain = false;
        int num = 0;
        String numData = "";

        do {
            doItAgain = false;

            numData = userInput.nextLine();

            try {
                num = Integer.parseInt(numData);
            } catch (NumberFormatException e){
                System.out.print("Numbers only, try again: ");
                doItAgain = true;
            }

        } while (doItAgain);

        return num;
    }
    public void genSqaureData(){
        for(int i = 1; i < 10; i++){
            square.put(i,String.valueOf(i));
        }
    }

    public void displayBoard(){
        StringBuilder sb = new StringBuilder();

        sb.append(" ");
        sb.append(addColor(square.get(1)));
        sb.append(" ║ ");
        sb.append(addColor(square.get(2)));
        sb.append(" ║ ");
        sb.append(addColor(square.get(3)));
        sb.append("\n");
        sb.append("═══╬═══╬═══\n");
        sb.append(" ");
        sb.append(addColor(square.get(4)));
        sb.append(" ║ ");
        sb.append(addColor(square.get(5)));
        sb.append(" ║ ");
        sb.append(addColor(square.get(6)));
        sb.append("\n");
        sb.append("═══╬═══╬═══\n");
        sb.append(" ");
        sb.append(addColor(square.get(7)));
        sb.append(" ║ ");
        sb.append(addColor(square.get(8)));
        sb.append(" ║ ");
        sb.append(addColor(square.get(9)));
        sb.append("\n");

        System.out.println(sb);
    }
}