import java.util.Random;

public class Podaci {

    private static final String CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
    private static final String DIGITS = "0123456789";
    private static final int PASSWORD_LENGTH = 12;
    private static final int NAME_LENGTH = 6; // Duzina nasumicnog imena/prezimena
    private static final int ACCOUNT_COUNT = 20; // Broj racuna za generirati

    public static void main(String[] args) {
        for (int i = 0; i < ACCOUNT_COUNT; i++) {
            String firstName = generateRandomName(NAME_LENGTH);
            String lastName = generateRandomName(NAME_LENGTH);
            String email = generateEmail(firstName, lastName);
            String password = generatePassword();
            String birthDate = generateBirthDate();

            System.out.println("Account " + (i + 1) + ":");
            System.out.println("First Name: " + firstName);
            System.out.println("Last Name: " + lastName);
            System.out.println("Email: " + email);
            System.out.println("Password: " + password);
            System.out.println("Birth Date: " + birthDate);
            System.out.println();
        }
    }

    private static String generateRandomName(int length) {
        Random random = new Random();
        StringBuilder name = new StringBuilder(length);

        // Prvo slovo veliko
        name.append(CHARACTERS.charAt(random.nextInt(26)));

        // Ostala slova mala
        for (int i = 1; i < length; i++) {
            name.append(CHARACTERS.toLowerCase().charAt(random.nextInt(26)));
        }

        return name.toString();
    }

    private static String generateEmail(String firstName, String lastName) {
        return firstName.toLowerCase() + "." + lastName.toLowerCase() + "@gmail.com";
    }

    private static String generatePassword() {
        Random random = new Random();
        StringBuilder password = new StringBuilder(PASSWORD_LENGTH);

        for (int i = 0; i < PASSWORD_LENGTH; i++) {
            int index = random.nextInt(CHARACTERS.length() + DIGITS.length());
            if (index < CHARACTERS.length()) {
                password.append(CHARACTERS.charAt(index));
            } else {
                password.append(DIGITS.charAt(index - CHARACTERS.length()));
            }
        }

        return password.toString();
    }

    private static String generateBirthDate() {
        Random random = new Random();
        int day = random.nextInt(28) + 1; // Day 1-28 to keep it simple
        int month = random.nextInt(12) + 1; // Month 1-12
        int year = random.nextInt(22) + 1980; // Year between 1980 and 2001

        return String.format("%02d/%02d/%d", day, month, year);
    }
}
