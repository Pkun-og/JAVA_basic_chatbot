import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BasicChatbot {

    private static String userName = "";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Hello! I'm a smarter chatbot. What's your name?");

        while (true) {
            String input = scanner.nextLine().toLowerCase();

            // If the chatbot doesn't know the user's name
            if (userName.isEmpty()) {
                userName = extractName(input);
                if (!userName.isEmpty()) {
                    System.out.println("Nice to meet you, " + userName + "! How can I help you today?");
                } else {
                    System.out.println("I didn't catch your name. Could you tell me your name?");
                }
                continue;
            }

            // Basic conversation patterns
            if (input.contains("hi") || input.contains("hello")) {
                System.out.println("Hello, " + userName + "! How can I assist you today?");
            } else if (input.contains("how are you")) {
                System.out.println("I'm doing great, " + userName + "! Thanks for asking. How about you?");
            } else if (input.contains("name")) {
                System.out.println("You can call me ChatBot. What else would you like to know?");
            } else if (input.contains("what can you do")) {
                System.out.println("I can chat with you, answer some simple questions, and help you with basic queries.");
            } else if (input.contains("bye")) {
                System.out.println("Goodbye, " + userName + "! It was nice talking to you.");
                break;
            } else if (matchesPattern(input, "what is your favorite (.+)")) {
                System.out.println("I don't have personal preferences like humans, but I do enjoy chatting with you!");
            } else if (matchesPattern(input, "how old are you")) {
                System.out.println("I'm ageless, " + userName + ". I exist in the digital realm, beyond time.");
            } else if (matchesPattern(input, "(tell|give) me a joke")) {
                System.out.println("Why don't scientists trust atoms? Because they make up everything!");
            } else {
                System.out.println("Sorry, I didn't quite understand that. Could you ask me something else?");
            }
        }

        scanner.close();
    }

    // Method to extract name from user input
    private static String extractName(String input) {
        // Looks for patterns like "my name is Priyansh" or "i'm Priyansh"
        Pattern pattern = Pattern.compile("(my name is|i am|i'm)\\s+([a-z]+)");
        Matcher matcher = pattern.matcher(input);
        if (matcher.find()) {
            return capitalize(matcher.group(2));
        }
        return "";
    }

    // Method to check if the input matches a pattern
    private static boolean matchesPattern(String input, String regex) {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);
        return matcher.find();
    }

    // Helper method to capitalize first letter
    private static String capitalize(String str) {
        return str.substring(0, 1).toUpperCase() + str.substring(1);
    }
}
