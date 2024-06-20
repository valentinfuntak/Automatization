import java.io.*;
import java.util.Random;

public class Podaci implements Serializable {

    private static final long serialVersionUID = 1L;
    private static final String CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
    private static final String DIGITS = "0123456789";
    private static final int PASSWORD_LENGTH = 12;
    private static final int ACCOUNT_COUNT = 20; // Number of accounts to generate
    private static final String FILE_PATH = "C:\\Users\\valen\\Documents\\NetBeansProjects\\Automatization\\Podaci\\InformacijeORacunima.txt";

    // Syllables for generating more realistic names
    private static final String[] FIRST_NAME_SYLLABLES = {"An", "Be", "Cal", "Dan", "El", "Fa", "Ga", "Ha", "In", "Ja", "Ka", "La", "Ma", "Na", "O", "Pa", "Qu", "Ra", "Sa", "Ta", "Ur", "Va", "Wa", "Xa", "Ya", "Za"};
    private static final String[] LAST_NAME_SYLLABLES = {"son", "ford", "field", "ton", "ham", "man", "well", "land", "wood", "brook", "stone", "hall", "berg", "wall", "port", "dale", "ridge", "brook", "croft", "hart"};

    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String birthDate;

    public Podaci(String firstName, String lastName, String email, String password, String birthDate) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.birthDate = birthDate;
    }

    public static void main(String[] args) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_PATH))) {
            for (int i = 0; i < ACCOUNT_COUNT; i++) {
                String firstName = generateRandomFirstName();
                String lastName = generateRandomLastName();
                String email = generateEmail(firstName, lastName);
                String password = generatePassword();
                String birthDate = generateBirthDate();

                Podaci account = new Podaci(firstName, lastName, email, password, birthDate);
                oos.writeObject(account);

                System.out.println("Account " + (i + 1) + ":");
                System.out.println("First Name: " + firstName);
                System.out.println("Last Name: " + lastName);
                System.out.println("Email: " + email);
                System.out.println("Password: " + password);
                System.out.println("Birth Date: " + birthDate);
                System.out.println();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String generateRandomFirstName() {
        Random random = new Random();
        StringBuilder firstName = new StringBuilder();

        // Combine 2-3 random syllables for the first name
        int syllableCount = random.nextInt(2) + 2; // 2 or 3 syllables
        for (int i = 0; i < syllableCount; i++) {
            firstName.append(FIRST_NAME_SYLLABLES[random.nextInt(FIRST_NAME_SYLLABLES.length)]);
        }

        // Capitalize the first letter
        firstName.setCharAt(0, Character.toUpperCase(firstName.charAt(0)));
        return firstName.toString();
    }

    private static String generateRandomLastName() {
        Random random = new Random();
        StringBuilder lastName = new StringBuilder();

        // Combine 1-2 random syllables for the last name
        int syllableCount = random.nextInt(2) + 1; // 1 or 2 syllables
        for (int i = 0; i < syllableCount; i++) {
            lastName.append(LAST_NAME_SYLLABLES[random.nextInt(LAST_NAME_SYLLABLES.length)]);
        }

        // Capitalize the first letter
        lastName.setCharAt(0, Character.toUpperCase(lastName.charAt(0)));
        return lastName.toString();
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

    // Getters for deserialization
    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getBirthDate() {
        return birthDate;
    }
}
