/******************************************************************************

                            Online Java Compiler.
                Code, Compile, Run and Debug java program online.
Write your code in this editor and press "Run" button to execute it.

*******************************************************************************/

	

import java.util.Scanner;

public class String {

    public static java.lang.String filterText(java.lang.String text, java.lang.String alphabet, java.lang.String mode) {
        if (mode.equals("normal")) {
            alphabet += alphabet.toUpperCase() + "abcdefghijklmnopqrstuvwxyz";
        } else if (mode.equals("with_space")) {
            alphabet += alphabet.toUpperCase() + "abcdefghijklmnopqrstuvwxyz";
        } else {
            throw new IllegalArgumentException("Invalid mode. Please choose 'normal' or 'with_space'.");
        }

        if (mode.equals("normal")) {
            // Заміна всіх символів, крім літер з алфавіту, на пробіли
            java.lang.String filteredText = text.replaceAll("[^" + alphabet + "]", "");
            // Заміна прописних літер на строчні
            filteredText = filteredText.toLowerCase();
            return filteredText;
        } else if (mode.equals("with_space")) {
            // Заміна всіх символів, крім літер з алфавіту, на пробіли
            java.lang.String filteredText = text.replaceAll("[^" + alphabet + "]", " ");
            // Заміна послідовності з декількох пробілів на один пробіл
            filteredText = filteredText.replaceAll("\\s+", " ");
            // Видалення пробілів на початку та в кінці тексту
            filteredText = filteredText.trim();
            // Заміна прописних літер на строчні
            filteredText = filteredText.toLowerCase();
            return filteredText;
        } else {
            throw new IllegalArgumentException("Invalid mode. Please choose 'normal' or 'with_space'.");
        }
    }

    public static void main(java.lang.String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {
            System.out.println("Enter the text:");
            java.lang.String text = scanner.nextLine();

            java.lang.String ukrainianAlphabet = "абвгґдеєжзиіїйклмнопрстуфхцчшщьюя";
            java.lang.String englishAlphabet = "abcdefghijklmnopqrstuvwxyz";

            System.out.println("Choose the filtering mode:");
            System.out.println("1. Normal alphabet");
            System.out.println("2. Alphabet with spaces");
            int modeChoice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            java.lang.String filteredText;
            if (modeChoice == 1) {
                filteredText = filterText(text, ukrainianAlphabet + englishAlphabet, "normal");
            } else if (modeChoice == 2) {
                filteredText = filterText(text, ukrainianAlphabet + englishAlphabet, "with_space");
            } else {
                System.out.println("Invalid mode choice. Using default mode (Normal alphabet).");
                filteredText = filterText(text, ukrainianAlphabet + englishAlphabet, "normal");
            }

            System.out.println("Filtered text:");
            System.out.println(filteredText);

            System.out.println("Do you want to continue? (yes/no)");
            java.lang.String choice = scanner.nextLine();
            if (!choice.equalsIgnoreCase("yes")) {
                exit = true;
            }
        }

        scanner.close();
    }
}
