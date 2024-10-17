// Natan Tadesse
// 10/9/2024
// Ciphers
/* This class represents a Caesar cipher with a shift value. It extends the Substitution class
   and provides a constructor to initialize the shifter string based on the provided shift value. */
import java.util.*;

public class CaesarShift extends Substitution {

    // Constructor that initializes the shifter string based on the provided shift value
    // Parameters:
    //   - shift: int representing the shift value to be used for the Caesar cipher
    // Exceptions:
    //   - Throws an IllegalArgumentException if the shift value is less than or equal to 0
    public CaesarShift(int shift) {
        if (shift <= 0) {
            throw new IllegalArgumentException("Shift must be greater than 0!");
        }

        Queue<Character> queue = new LinkedList<>();
        for (int i = MIN_CHAR; i <= MAX_CHAR; i++) {
            queue.add((char) i);
        }

        for (int i = 0; i < shift; i++) {
            char c = queue.poll();
            queue.add(c);
        }

        String shifter = "";
        
        for (char c : queue) {
            shifter += c;
        }

        setShifter(shifter);
    }
}
