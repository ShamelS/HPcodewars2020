import java.io.File;
import java.io.FileNotFoundException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Scanner;

public class prob24 {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner in = new Scanner(new File("input.txt"));
        ArrayList<String> rawBlanks = new ArrayList<String>();
        ArrayList<String> rawClues = new ArrayList<String>();
        ArrayList<String> words = new ArrayList<String>();
        String newBlank = "";
        String newClue = "";

        do {
            newBlank = in.nextLine();
            if(!newBlank.equals("-------"))
                rawBlanks.add(newBlank);
        } while(!newBlank.equals("-------"));
//        System.out.println(rawBlanks);

        do {
            newClue = in.nextLine();
            if(!newClue.equals("-------"))
                rawClues.add(newClue);
        } while(!newClue.equals("-------"));
//        System.out.println(rawClues);

        while(in.hasNext()) {
            words.add(in.next());
        }
//        System.out.println(words);

        //process the word banks
        int totalBlanks = rawBlanks.size();
        char[][] blanks = new char[totalBlanks][];
        int[] xCoords = new int[totalBlanks];
        int[] yCoords = new int[totalBlanks];
        char[] orientations = new char[totalBlanks];
        String[] tempInfo;

        for(int i = 0; i < totalBlanks; i++) {
            tempInfo = rawBlanks.get(i).split(" ");
            orientations[i] = tempInfo[1].charAt(0);
            int blankSize = Integer.parseInt(tempInfo[2]);
            blanks[i] = new char[blankSize];
            xCoords[i] = Integer.parseInt(tempInfo[3]);
            yCoords[i] = Integer.parseInt(tempInfo[4]);
        }

        //used to debug: show word bank info
//        for(int i = 0; i < totalBlanks; i++) {
//            System.out.println(orientations[i] + " " + blanks[i].length + " " + xCoords[i]  + " " + yCoords[i]);
//        }

        //process rawClues
        int totalClues = rawClues.size();

        Clue[] clues = new Clue[totalClues];
        for(int i = 0; i < totalClues; i++) {
            int clueXCoord = Integer.parseInt("" + rawClues.get(i).charAt(0));
            int clueYCoord = Integer.parseInt("" + rawClues.get(i).charAt(2));
            char clueLetter = rawClues.get(i).charAt(4);
            clues[i] = new Clue(clueLetter, clueXCoord, clueYCoord);
        }

        //used to debug: show clue info
//        for(int i = 0; i < totalClues; i++) {
//            System.out.println(clues[i]);
//        }

        //fill clues into word bank
        //horizontal word banks:
        int[] cluePerBanks = new int[totalBlanks];

        for(int k = 0; k < totalClues; k++) {
            for(int i = 0; i < totalBlanks; i++) {
                if (orientations[i] == 'H' && yCoords[i] == clues[k].yCoord                                          //checks for 1: horizontal 2: same yCoord
                        && xCoords[i] <= clues[k].xCoord && (xCoords[i] + blanks[i].length -1) >= clues[k].xCoord) { //3: if xCoord of clue is within the x range of the word bank|||  if all conditions met, insert clue into proper location
                    int index = clues[k].xCoord - xCoords[i];
                    blanks[i][index] = clues[k].letter;
                    cluePerBanks[i]++;
                } else if (orientations[i] == 'V' && xCoords[i] == clues[k].xCoord                                          //checks for 1: vertical 2: same xCoord
                        && yCoords[i] <= clues[k].yCoord && (yCoords[i] + blanks[i].length -1) >= clues[k].yCoord) { //3: if yCoord of clue is within the y range of the word bank|||  if all conditions met, insert clue into proper location
                    int index = clues[k].yCoord - yCoords[i];
                    blanks[i][index] = clues[k].letter;
                    cluePerBanks[i]++;
                }
            }
        }

        //used to debug: show filled in word banks (ignore the . after letter)
//        for(int i = 0; i < totalBlanks; i++) {
//            for(int j = 0; j < blanks[i].length; j++) {
//                System.out.print(blanks[i][j] + ".");
//            }
//            System.out.println(cluePerBanks[i]);
//        }

        //test all words in banks
        String[] filledBlanks = new String[totalBlanks];

        for(int k = 0; k < words.size(); k++) {
            for(int i = 0; i < blanks.length; i++) {
                if(blanks[i].length == words.get(k).length()) { //check if there is a blank the same size as word
                    int matchCount = 0;
                    for(int j = 0; j < blanks[i].length; j++) {
                        if(blanks[i][j] == words.get(k).charAt(j)) {
                            matchCount++;
                        }
                    }

                    if(matchCount == cluePerBanks[i]) {
                        filledBlanks[i] = words.get(k);
                    }
                }
            }
        }

        DecimalFormat df = new DecimalFormat("00");
        for(int i = 0; i < totalBlanks; i++) {
            System.out.println(df.format(i+1) + " is " + filledBlanks[i]);
        }
    }
}

class Clue {
    char letter;
    int xCoord, yCoord;
    public Clue(char letter, int xCoord, int yCoord) {
        this.letter = letter;
        this.xCoord = xCoord;
        this.yCoord = yCoord;
    }

    @Override
    public String toString() {
        return "Clue{" +
                "letter=" + letter +
                ", xCoord=" + xCoord +
                ", yCoord=" + yCoord +
                '}';
    }
}
