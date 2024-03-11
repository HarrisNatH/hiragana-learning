# HIRAGANA LEARNING 

## Description
a hiragana learning platform. A personal project I created to help me (and for people) to learn hiragana.

## Running the binary
Simply press run the program.

## Code details
The main works happens in `LearningApp()` in `Main.java`. 

The program starts by presenting a game title and main menu that consists: Start game and Exit using a `Switch Case`.

In `LearningApp.java` a class that utilises `Collections`, `HashMap`, `Map`, `Scanner`, `List`, `ArrayList` combined. 

First, the class creates a few private fields and initalises them.
```
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
```

Next,`initWordBank()` is where hiragana alphabat and words are added (over time) using key-value pair. From this bank, `initLevels()` uses an ArrayList<> to add keys as elements on each levels.

Finally, `start()` it creates a `List<String>` that takes in level from `initLevels` then shuffles the elements. the learning begins with boolean `allCorrect` as true, if a player is wrong on any of one word in certain level it will change `allCorrect` to false, it will repeat the whole level until all are correct.

When player completes a level, the system adds the next level's elements to existing element pool. Increasing the difficulty and complexity of learning, increases `currentLevel` by 1.

The learning ends when `currentLevel` has reached `levels.size()` and sends out a congratulation message.
__
Thank you for reading and happy learning!

## LICENSE
This project has a MIT license.
