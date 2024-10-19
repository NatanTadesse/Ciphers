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

        List<Character> list = new ArrayList<>();
        for (int i = MIN_CHAR; i <= MAX_CHAR; i++) {
            list.add((char) i);
        }

        String shifter = "";
        int totalChars = list.size();
        for (int i = 0; i < totalChars; i++) {
            shifter += list.get((i + shift) % totalChars);
        }

        setShifter(shifter);
    }
}
