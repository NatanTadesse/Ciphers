// Natan Tadesse
// 10/9/2024
// TA: Esha Kunisetty
// P0: Ciphers
/* This class represents a Caesar cipher with a key. It extends the Substitution class
   and provides a constructor to initialize the shifter string based on the provided key. */
import java.util.*;

public class CaesarKey extends Substitution {

   // Constructor that initializes the shifter string based on the provided key
   // Parameters:
   //   - key: String representing the key to be used for the Caesar cipher
   // Exceptions:
   //   - Throws an IllegalArgumentException if the key is empty
   //   - Throws an IllegalArgumentException if the key contains characters outside the encodable range
   //   - Throws an IllegalArgumentException if the key contains duplicate characters
   public CaesarKey(String key) {
       if (key.isEmpty()) {
           throw new IllegalArgumentException("Key cannot be empty!");
       }

       Set<Character> charSet = new HashSet<>();
       ArrayList<Character> shifterList = new ArrayList<>();
       
       for (int i = 0; i < key.length(); i++) {
           char c = key.charAt(i);

           if (c < MIN_CHAR || c > MAX_CHAR) {
               throw new IllegalArgumentException("Key contains characters outside the encodable range!");
           }

           if (!charSet.add(c)) {
               throw new IllegalArgumentException("Key contains duplicate characters!");
           }
           shifterList.add(c);
       }

       for (int i = MIN_CHAR; i <= MAX_CHAR; i++) {
           if (!charSet.contains((char) i)) {
               shifterList.add((char) i);
           }
       }

       String shifter = "";

       for (char c : shifterList) {
           shifter += c;
       }
       setShifter(shifter);
   }
}
