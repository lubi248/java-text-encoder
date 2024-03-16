import java.util.Scanner;

public class encoderer {

    public static void main(String[] args) { //user input
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter 0 to encode or 1 to decode: ");
        int a = sc.nextInt();
        sc.nextLine(); 

        if (a < 2) { // string reverser
            String str;
            StringBuilder reversedText = new StringBuilder();
            System.out.print("Enter a string : ");
            str = sc.nextLine(); 
            String[] words = str.split(" ");
            for (int i = words.length - 1; i >= 0; i--) {
                reversedText.append(words[i]);
                reversedText.append(" ");
            }
            String encryptedText = encrypt(reversedText.toString().trim(), 3);
            System.out.println("Encrypted Text: " + encryptedText);
        }
        sc.close(); 
    }

    public static String encrypt(String text, int shift) { //this is the ceasar cipher
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);

            if (Character.isLetter(ch)) {
                char shiftedChar = (char) (ch + shift);

                if (Character.isUpperCase(ch)) {
                    if (shiftedChar > 'Z') {
                        shiftedChar = (char) ('A' + (shiftedChar - 'Z' - 1));
                    }
                } else {
                    if (shiftedChar > 'z') {
                        shiftedChar = (char) ('a' + (shiftedChar - 'z' - 1));
                    }
                }

                result.append(shiftedChar);
            } else {
                result.append(ch);
            }
        }

        return result.toString();
    }
}

// in an upcoming patch i will make the decoder section of the project using the user input at the begining and a GUI likely in react