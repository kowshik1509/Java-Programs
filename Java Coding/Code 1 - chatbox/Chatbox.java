import java.util.Scanner;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

class Chatbox {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("EEE MMM dd HH:mm:ss yyyy");

        System.out.println("Chatbot: Hi! I'm a simple chatbot, I'm here to assist you!");

        while (true) {
            System.out.print("Me: ");
            String userInput = scanner.nextLine().toLowerCase();

            if (userInput.equals("bye")) {
                System.out.println("Chatbot: Bye! Have a nice day!");
                break;
            }

            String response = chatbotResponse(userInput, dtf);
            System.out.println("Chatbot: " + response);
        }

        scanner.close();
    }

    public static String chatbotResponse(String userInput, DateTimeFormatter dtf) {
        LocalDateTime now = LocalDateTime.now();

        if (userInput.contains("hi") || userInput.contains("hello")) {
            return "Hi there! I'm a chatbot here to assist you.";
        } else if (userInput.contains("what is your name")) {
            return "I'm just a chatbot, so I don't have a name, but you can call me chatbot.";
        } else if (userInput.contains("where are you from")) {
            return "I'm from the digital world, always ready to chat!";
        } else if (userInput.contains("how are you")) {
            return "I'm fine.what about you?";
        }else if (userInput.contains("good")){
	    return "That's great.";
	} else if (userInput.contains("do you have any hobbies") || userInput.contains("interests")) {
            return "I'm always busy helping my users, so my hobby is chatting with people like you!";
        } else if (userInput.contains("what did you eat today") || userInput.contains("what do you like to eat")) {
            return "I don't eat, but I can help you find delicious recipes and food-related information.";
        } else if (userInput.contains("favorite color")) {
            return "Blue is .";
        } else if (userInput.contains("do you enjoy listening to music")) {
            return "I can't listen to music, but I'm here to chat about it!";
        } else if (userInput.contains("tell me a joke") || userInput.contains("another joke")) {
            return "Why don't skeletons fight each other? They don't have the guts!";
        } else if (userInput.contains("tell me an intresting fact")) {
            return "How about aliens.";
        } else if (userInput.contains("interesting")){
	    return "Aliens or extraterrestrial life, are beings thought to exist beyond Earth.";
	} else if (userInput.contains("weather in")) {
            return "I'm sorry, I don't have real-time weather data at present.";
        } else if (userInput.contains("latest news")) {
            return "I'm sorry, I don't have real-time news updates at present.";
        } else if (userInput.contains("translate")) {
            return "I don't support real-time language translation like other translators.";
        } else if (userInput.contains("what is the time now")) {
            return dtf.format(now);
        } else {
            return "I'm sorry, I didn't understand that. Can you please rephrase your sentence?";
        }
    }
}
