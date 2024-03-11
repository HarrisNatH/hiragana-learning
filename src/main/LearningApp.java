package main;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class LearningApp {
    private final Map<String, String> wordBank;
    private int currentLevel;
    private final List<List<String>> levels;
    private final Scanner scanner;

    public LearningApp() {
        this.wordBank = new HashMap<>();
        this.levels = new ArrayList<>();
        this.currentLevel = 0;
        this.scanner = new Scanner(System.in);
        initWordBank();
        initLevels();
    }

    private void initWordBank() {
        wordBank.put("あ", "a");
        wordBank.put("い", "i");
        wordBank.put("う", "u");
        wordBank.put("え", "e");
        wordBank.put("お", "o");
        wordBank.put("ん", "n");
        wordBank.put("か", "ka");
        wordBank.put("き", "ki");
        wordBank.put("く", "ku");
        wordBank.put("け", "ke");
        wordBank.put("こ", "ko");
        wordBank.put("が", "ga");
        wordBank.put("ぎ", "gi");
        wordBank.put("ぐ", "gu");
        wordBank.put("げ", "ge");
        wordBank.put("ご", "go");
        wordBank.put("さ", "sa");
        wordBank.put("し", "shi");
        wordBank.put("す", "su");
        wordBank.put("せ", "se");
        wordBank.put("そ", "so");
        wordBank.put("わ", "wa");

        wordBank.put("え？", "huh?");
        wordBank.put("おい！", "hey!");
        wordBank.put("いいえ", "no");
        wordBank.put("うん", "yeah");
        wordBank.put("ええ", "yes");
        wordBank.put("いく", "will go");
        wordBank.put("いこく", "let's go");
        wordBank.put("いけ！", "go!");
        wordBank.put("こわい", "scary");
        wordBank.put("かわいい", "cute");
        wordBank.put("かあさん", "mother");
        // Add more words as needed
    }

    private void initLevels() {
        levels.add(new ArrayList<>(List.of("あ","い","う","え","お","ん","え？","おい！","いいえ","うん","ええ"))); // Level 1
        levels.add(new ArrayList<>(List.of("か","き", "く","け","こ","わ","いく","いこく","いけ！","こわい","かわいい","かあさん"))); // Level 2
        // Add more levels as needed
    }

    public void start() {
        while (currentLevel < levels.size()) {
            System.out.println("Level " + (currentLevel + 1));
            List<String> currentWords = new ArrayList<>(levels.get(currentLevel));
            Collections.shuffle(currentWords); // Shuffle words for random order
            boolean levelCompleted = false;

            while (!levelCompleted) {
                Collections.shuffle(currentWords); // Shuffle words for random order
                boolean allCorrect = true;
                for (String word : currentWords) {
                    System.out.print("What is the English word for '" + word + "'? ");
                    String answer = scanner.nextLine();
                    if (wordBank.get(word).equalsIgnoreCase(answer)) {
                        System.out.println("Correct!");
                    } else {
                        System.out.println("Incorrect, the right answer is: " + wordBank.get(word));
                        allCorrect = false;
                    }
                }

                if (allCorrect) {
                    levelCompleted = true;
                    System.out.println("Level " + (currentLevel + 1) + " completed!");
                } else {
                    System.out.println("Some answers were incorrect. Let's try the level again.");
                }
            }
            
            currentLevel++;
            if (currentLevel >= levels.size()) {
                System.out.println("Congratulations, you've completed all levels!\n\n");
                break;
            }
        }
    }
}
