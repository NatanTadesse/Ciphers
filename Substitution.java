// Natan Tadesse
// 10/9/2024
// Ciphers
/* This class represents a substitution cipher. It allows for setting a shifter string
   and provides methods to encrypt and decrypt strings using the substitution cipher. */
import java.util.*;

public class Substitution extends Cipher {
   private String shifter;

   // Constructor that initializes the shifter to null
   public Substitution() {
       this.shifter = null;
   }

   // Constructor that initializes the shifter with the provided string
   // Parameters:
   //   - shifter: String representing the shifter to be used for the substitution cipher
   // Exceptions:
   //   - Throws an IllegalArgumentException if the shifter length does not match the total number
   //     of encodable characters
   //   - Throws an IllegalArgumentException if the shifter contains characters outside the
   //     encodable range
   //   - Throws an IllegalArgumentException if the shifter contains duplicate characters
   public Substitution(String shifter) {
       setShifter(shifter);
   }

   // Sets the shifter string for the substitution cipher
   // Parameters:
   //   - shifter: String representing the shifter to be used for the substitution cipher
   // Exceptions:
   //   - Throws an IllegalArgumentException if the shifter length does not match the total number
   //     of encodable characters
   //   - Throws an IllegalArgumentException if the shifter contains characters outside the
   //     encodable range
   //   - Throws an IllegalArgumentException if the shifter contains duplicate characters
   public void setShifter(String shifter) {
       if (shifter.length() != TOTAL_CHARS) {
           throw new IllegalArgumentException("Shifter length must match the total number of " +
                                              "encodable characters.");
       }
       Set<Character> charSet = new HashSet<>();
       for (int i = 0; i < shifter.length(); i++) {
           char c = shifter.charAt(i);
           if (c < MIN_CHAR || c > MAX_CHAR) {
               throw new IllegalArgumentException("Shifter contains characters outside the " +
                                                  "encodable range.");
           }
           if (!charSet.add(c)) {
               throw new IllegalArgumentException("Shifter contains duplicate characters.");
           }
       }
       this.shifter = shifter;
   }

   // Encrypts the input string using the substitution cipher
   // Parameters:
   //   - input: String representing the input to be encrypted
   // Returns:
   //   - String representing the encrypted result
   // Exceptions:
   //   - Throws an IllegalStateException if the shifter has not been set
   //   - Input string should be non-null and all characters should be within the encodable range
   @Override
   public String encrypt(String input) {
       if (shifter == null) {
           throw new IllegalStateException("Shifter has not been set.");
       }
       String encrypted = "";
       for (int i = 0; i < input.length(); i++) {
           char c = input.charAt(i);
           int index = c - MIN_CHAR;
           encrypted += shifter.charAt(index);
       }
       return encrypted;
   }

   // Decrypts the input string using the substitution cipher
   // Parameters:
   //   - input: String representing the input to be decrypted
   // Returns:
   //   - String representing the decrypted result
   // Exceptions:
   //   - Throws an IllegalStateException if the shifter has not been set
   //   - Input string should be non-null and all characters should be within the encodable range
   @Override
   public String decrypt(String input) {
       if (shifter == null) {
           throw new IllegalStateException("Shifter has not been set.");
       }
       String decrypted = "";
       for (int i = 0; i < input.length(); i++) {
           char c = input.charAt(i);
           int index = shifter.indexOf(c);
           decrypted += (char) (index + MIN_CHAR);
       }
       return decrypted;
   }
}
