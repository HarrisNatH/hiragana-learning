package main;

public class Main{
    public static void main(String[] args) {
        boolean finished = false;
        while(!finished){
            try{
                TitleASCII.gameTitle();
                System.out.println("Main menu: \n   1. Start game\n   2. Level select\n   3. Exit\n");
                int pick = Integer.parseInt(System.console().readLine());
                LearningApp app = new LearningApp();
                switch(pick){
                    case 1:
                        app.start(1);
                        break;
                    case 2:
                        System.out.println("Please input level you wish to start with: (level 1 - 3)");
                        int pickLevel = Integer.parseInt(System.console().readLine());
                        app.start(pickLevel);
                        break;
                    case 3:
                        System.out.println("Thank you for participating");
                        finished=true;
                        break;
                    default:
                        System.out.println("Please choose a number");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid, please input a number\n");
            }
        }
    }
}
