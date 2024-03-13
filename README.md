# HIRAGANA LEARNING 

## Description
THIS IS AN ONGOING PROJECT - adding hiragana characters and words.

A hiragana learning platform. A personal project I created to help me (and for people) to learn hiragana.

## Running the binary
If you run the program on Windows PowerShell.
Before running the program, enter this on the terminal console.

    $OutputEncoding = [Console]::InputEncoding = [Console]::OutputEncoding = New-Object System.Text.UTF8Encoding


## Code details
The main works happens in `LearningApp()` in `Main.java`. 

The program starts by presenting a game title and main menu that consists: Start game and Exit using a `Switch Case`.

In `LearningApp.java` a class that utilises `Collections`, `HashMap`, `Map`, `Scanner`, `List`, `ArrayList` combined. 

First, the class creates a few private fields and initalises them.
```
public class LearningApp {
    private final Map<String, String> wordBank = new HashMap<>();
    private final List<List<String>> levels = new ArrayList<>();
    private final Scanner scanner = new Scanner(System.in);

    public LearningApp() {
        initApp();
    }
}
```

Next,`addWord()` is a method to add hiragana, its English meaning and level structured together in one initialization.
For each addWord, respective hiragana and English are added in `wordBank`.

The game starts with `levels` at zero, taking the max level from `addWord()` it will add every empty `ArrayList<>` until match level available. `levels` then adds hiragana based on level

Each `addWord()` is added to `initApp()` which is already initialised by `LearningApp()`

Finally, `start()` it creates a copy `List<String>` based on `levels` then shuffles the hiragana elements. the learning begins with boolean `allCorrect` as true, if a player is wrong on any of one word in certain level it will change `allCorrect` to false, it will repeat the whole level until all are correct.

When player completes a level, the system adds the next level's elements to existing element pool. Increasing the difficulty and complexity of learning, increases `currentLevel` by 1.

The learning ends when `currentLevel` has reached `levels.size()` and sends out a congratulation message.
__
Thank you for reading and happy learning!

## LICENSE
This project has a MIT license.
