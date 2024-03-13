package main;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class LearningApp {
    private final Map<String, String> wordBank = new HashMap<>();
    private final List<List<String>> levels = new ArrayList<>();
    private final Scanner scanner = new Scanner(System.in);

    //initialization
    public LearningApp() {
        initApp();
    }

    /**
     * A private storage for words made using addWord methods
     */
    private void initApp() {
        // Define word translations and level organization together
        addWord("あ", "a", 1);
        addWord("い", "i", 1);
        addWord("う", "u", 1);
        addWord("え", "e", 1);
        addWord("お", "o", 1);
        addWord("ん", "n", 1);
        addWord("え?", "huh?", 1);
        addWord("おい!", "hey!", 1);    
        addWord("いいえ", "no", 1);
        addWord("うん", "yeah", 1);
        addWord("ええ", "yes", 1);
        //level 2
        addWord("か", "ka", 2);
        addWord("き", "ki", 2);
        addWord("く", "ku", 2);
        addWord("け", "ke", 2);
        addWord("こ", "ko", 2);
        addWord("いく", "will go", 2);
        addWord("いこく", "let's go", 2);
        addWord("いけ!", "go!", 2);
        addWord("こわい", "scary", 2);
        addWord("かわいい", "cute", 2);
        addWord("かあさん", "mother", 2);
        //level 3
        addWord("さ", "sa", 3);
        addWord("し", "shi", 3);
        addWord("す", "su", 3);
        addWord("せ", "se", 3);
        addWord("そ", "so", 3);
        addWord("わ", "wa", 3);
        // addWord("が", "ga", );
        // addWord("ぎ", "gi", );
        // addWord("ぐ", "gu", );
        // addWord("げ", "ge", );
        // addWord("ご", "go", );
        // Add more words and levels as needed
    }

    /**
     * A method to add words to wordBank hashMap, and restrict some words based on current level.
     * @param hiragana hiragana character
     * @param english literal meaning of hiragana characters
     * @param level learning difficulty of hiragana characters
     */
    private void addWord(String hiragana, String english, int level) {
        //allows game to retrieve the English translation of any hiragana word stored in the word bank.
        //a key-value pair
        wordBank.put(hiragana, english);
        // Ensure there are enough levels, adds an empty ArrayList to receive new word
        while (levels.size() < level) {
            levels.add(new ArrayList<>());
        }
        //adds hiragana corresponds to each level in levels ArrayList<>
        levels.get(level - 1).add(hiragana);
    }

    /**
     * A method to start game by making a copy ArrayList consists of hiragana based on current level.
     * when all words are correctly guessed, proceed to next level. Else, repeat the level.
     * every time next level achieved, adds new words.
     */
    public void start(int currentLevel) {
        while (currentLevel < levels.size()) {
            System.out.println("Level " + (currentLevel));
            //creates a copy of ArrayList<> consists hiragana based on levels 
            List<String> currentWords = new ArrayList<>(levels.get(currentLevel));
            Collections.shuffle(currentWords); // Shuffle words for random order
            
            boolean levelCompleted = false;
            while (!levelCompleted) {
                Collections.shuffle(currentWords); // Shuffle words for random order if restart level
                boolean allCorrect = true;
                for (String word : currentWords) {
                    System.out.print("What is the English word for '" + word + "'? ");
                    String answer = scanner.nextLine();
                    //retrieving values in wordBank to match answer
                    if (wordBank.get(word).equalsIgnoreCase(answer)) {
                        System.out.println("Correct!");
                    } else {
                        System.out.println("Incorrect, the right answer is: " + wordBank.get(word));
                        allCorrect = false;
                    }
                }

                //based on above's for loop statement. if all words are correctly answered, proceed to next level
                if (allCorrect) {
                    levelCompleted = true;
                    System.out.println("Level " + (currentLevel) + " completed!");
                } else {
                    System.out.println("Some answers were incorrect. Let's try the level again.");
                }
            }
            //increase currentLevel until last level possible.
            currentLevel++;
            if (currentLevel >= levels.size()) {
                System.out.println("Congratulations, you've completed all levels!\n\n");
                break;
            }
        }
    }
}
