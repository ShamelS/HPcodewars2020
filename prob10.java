import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class prob10 {
    public static void main(String[] args) throws FileNotFoundException {
        /**
         * Story sentence
         * NOUNS
         * noun
         * ADVERBS
         * adverb
         * VERBS
         * verb
         * ADJECTIVES
         * adjective
         * END
         *
         * [N] = nouns [AV] = adverbs [V] = verbs [AJ] = adjectives
         */

        ArrayList<String> nouns = new ArrayList<String>();
        ArrayList<String> adverbs = new ArrayList<String>();
        ArrayList<String> verbs = new ArrayList<String>();
        ArrayList<String> adjectives = new ArrayList<String>();
        Scanner in = new Scanner(new File("input.txt"));

        String StorySentence = in.nextLine();
        String StorySentenceTemp = StorySentence;
        String temp = in.nextLine();
        while(!temp.equals("ADVERBS")) {
            temp = in.nextLine();
            if(!temp.equals("ADVERBS"))
                nouns.add(temp);
        }
        while(!temp.equals("VERBS")) {
            temp = in.nextLine();
            if(!temp.equals("VERBS"))
                adverbs.add(temp);
        }
        while(!temp.equals("ADJECTIVES")) {
            temp = in.nextLine();
            if(!temp.equals("ADJECTIVES"))
                verbs.add(temp);
        }
        while(!temp.equals("END")) {
            temp = in.nextLine();
            if(!temp.equals("END"))
                adjectives.add(temp);
        }

        while(StorySentence.contains("[N]")) {
            StorySentence = StorySentence.replaceFirst("\\[N\\]", nouns.get(0));
            nouns.remove(0);
        }

        while(StorySentence.contains("[AV]")) {
            StorySentence = StorySentence.replaceFirst("\\[AV\\]", adverbs.get(0));
            adverbs.remove(0);
        }

        while(StorySentence.contains("[V]")) {
            StorySentence = StorySentence.replaceFirst("\\[V\\]", verbs.get(0));
            verbs.remove(0);
        }

        while(StorySentence.contains("[AJ]")) {
            StorySentence = StorySentence.replaceFirst("\\[AJ\\]", adjectives.get(0));
            adjectives.remove(0);
        }

        System.out.println(StorySentence);

        //sentence 2
        StorySentence = StorySentenceTemp;
        while(StorySentence.contains("[N]")) {
            StorySentence = StorySentence.replaceFirst("\\[N\\]", nouns.get(0));
            nouns.remove(0);
        }

        while(StorySentence.contains("[AV]")) {
            StorySentence = StorySentence.replaceFirst("\\[AV\\]", adverbs.get(0));
            adverbs.remove(0);
        }

        while(StorySentence.contains("[V]")) {
            StorySentence = StorySentence.replaceFirst("\\[V\\]", verbs.get(0));
            verbs.remove(0);
        }

        while(StorySentence.contains("[AJ]")) {
            StorySentence = StorySentence.replaceFirst("\\[AJ\\]", adjectives.get(0));
            adjectives.remove(0);
        }
        System.out.println(StorySentence);
    }
}
