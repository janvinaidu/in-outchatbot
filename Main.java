import java.util.Scanner;
import java.util.Random;

public class Main {
    static String[] goodBye = {"bye", "goodbye", "exit", "quit", "thanks", "thank you", "thx"};
    static String[] hiKeywords = {"hi", "hello", "hey", "howdy", "hai", "hii"};
    static String[] howAreYouKeywords = {"how are you", "how are you doing", "you"};
    static String[] menuKeywords = {"menu", "burger", "fries", "drink", "burgers", "drinks", "milkshake", "soda", "lemonade"};
    static String[] hoursKeywords = {"hours", "time", "opens", "open", "close", "closes"};
    static String[] locationKeywords = {"location", "where", "locations", "california"};
    static String[] historyKeywords = {"history", "when did", "backstory", "founder", "founded", "began"};
    static String[] randomResponses = {
        "I'm not sure what you mean! Could you try asking something else?",
        "Oops! I didn't quite catch that. Can you clarify?",
        "Sorry, I didn’t understand. Could you please rephrase?",
        "Hmm, I didn't quite get that. Can you ask something else?",
        "Sorry, I can only help with In-N-Out Burger related questions!"
    };
    static int unclearInputCount = 0;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Welcome to In-N-Out Burger! How can I help you today?");

        Food hamburger = new Food("Hamburger", 3.99, "burger");
        Food cheeseburger = new Food("Cheeseburger", 4.29, "burger");
        Food fries = new Food("Fries", 2.79, "side");

        while (true) {
            String userInput = in.nextLine().toLowerCase();

            if (checkKeywords(userInput, hiKeywords)) {
                System.out.println("Hello! You can ask about our menu, hours, or locations. What would you like to know?");
            } else if (checkKeywords(userInput, howAreYouKeywords)) {
                System.out.println("I'm just a chatbot, but I'm here to help! What would you like to know?");
            } else if (checkKeywords(userInput, goodBye)) {
                System.out.println("Goodbye! Thanks for chatting!");
                break;
            } else if (checkKeywords(userInput, menuKeywords)) {
                showMenu(hamburger, cheeseburger, fries);
            } else if (checkKeywords(userInput, hoursKeywords)) {
                showHours();
            } else if (checkKeywords(userInput, locationKeywords)) {
                showLocations();
            } else if (checkKeywords(userInput, historyKeywords)) {
                showHistory();
            } else {
                System.out.println(getRandomResponse());
                unclearInputCount++;
                if (unclearInputCount == 3) {
                    surpriseFeature();
                    unclearInputCount = 0;
                }
            }
        }
    }

    public static boolean checkKeywords(String userInput, String[] keywords) {
        for (String keyword : keywords) {
            // Check if the user's input contains the keyword
            if (userInput.contains(keyword)) {
                return true;
            }
        }
        return false;
    }

    public static void showMenu(Food food1, Food food2, Food food3) {
        System.out.println("Here are our menu options:");
        food1.displayInfo();
        food2.displayInfo();
        food3.displayInfo();
        System.out.println("4. Protein Style - Any burger wrapped in lettuce instead of a bun.");
        System.out.println("5. Animal Style Fries - Fries topped with cheese, grilled onions, and spread.");
    }

    public static void showHours() {
        System.out.println("Our operating hours are:");
        System.out.println("Sunday to Thursday: 10:30 AM - 1:00 AM");
        System.out.println("Friday and Saturday: 10:30 AM - 1:30 AM");
    }

    public static void showLocations() {
        System.out.println("We have locations in California, Nevada, Arizona, Utah, Texas, Oregon, and Colorado.");
        System.out.println("Use our store locator on the website for exact addresses!");
    }

    public static void showHistory() {
        System.out.println("In-N-Out Burger was founded in 1948 by Harry and Esther Snyder in Baldwin Park, California.");
        System.out.println("It was the first drive-thru hamburger stand in California.");
        System.out.println("The company remains family-owned and is famous for its fresh ingredients and simple menu.");
    }

    public static String getRandomResponse() {
        Random rand = new Random();
        int index = rand.nextInt(randomResponses.length);
        return randomResponses[index];
    }

    public static void surpriseFeature() {
        System.out.println("Want to know a funny joke? Why did the frog take the bus to work? His car got toad!");
    }
}
