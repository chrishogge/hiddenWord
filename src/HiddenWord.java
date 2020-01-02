import java.util.Scanner;

public class HiddenWord {

    private int length;
    private String string;
    private String[] array;

    String resultString = "";
    boolean checker = false;
    int hiddenWordLength;

    private static Scanner in = new Scanner(System.in);

    public HiddenWord(String word){
        this.length = word.length();
        this.string = word;
        this.array = word.split("");
    }

    public int getLength(){
        return length;
    }

    public String getString(){
        return string;
    }

    public String[] getArray(){
        return array;
    }

    public String getHint(String guess){
        resultString = "";

        String[] guessArray = new String[getLength()];

        guessArray = guess.split("");

        String[] hiddenArray = getArray();

        for(int i = 0; i < getLength(); i ++){
            checker = false;

            for(int j = 0; j < getLength(); j++){

                if(guessArray[i].equals(hiddenArray[j])){
                    if(i == j){
                        resultString += guessArray[i];
                    }else if(i != j){
                        resultString += "+";
                    }
                    checker = true;
                    break;
                }
            }
            if(checker == false){
                resultString += "*";
            }
        }

        return resultString;

    }

    public static void main(String args[]){
        System.out.print("\nEnter hidden word: ");
        String inputHidden = in.next();

        inputHidden = inputHidden.toUpperCase();

        HiddenWord puzzle = new HiddenWord(inputHidden);

        System.out.print("\nEnter guess: ");
        String inputGuess = in.next();
        inputGuess = inputGuess.toUpperCase();

        System.out.println("\n" + puzzle.getHint(inputGuess) + "\n");

    }

}
