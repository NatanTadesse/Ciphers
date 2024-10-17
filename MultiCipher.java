// Natan Tadesse
// 10/9/2024
// TA: Esha Kunisetty
// P0: Ciphers
/* This class represents a multi-cipher that applies multiple ciphers sequentially.
   It extends the Cipher class and provides methods to encrypt and decrypt strings
   using the list of provided ciphers. */
import java.util.*;

public class MultiCipher extends Cipher {
    private List<Cipher> ciphers;

    // Constructor that initializes the list of ciphers
    // Parameters:
    //   - ciphers: List<Cipher> representing the list of ciphers to be used
    // Exceptions:
    //   - Throws an IllegalArgumentException if the cipher list is null
    public MultiCipher(List<Cipher> ciphers) {
        if (ciphers == null) {
            throw new IllegalArgumentException("Cipher list cannot be null!");
        }
        this.ciphers = ciphers;
    }

    // Encrypts the input string using the list of ciphers sequentially
    // Parameters:
    //   - input: String representing the input to be encrypted
    // Returns:
    //   - String representing the encrypted result
    @Override
    public String encrypt(String input) {
        String result = input;
        for (Cipher cipher : ciphers) {
            result = cipher.encrypt(result);
        }
        return result;
    }

    // Decrypts the input string using the list of ciphers in reverse order
    // Parameters:
    //   - input: String representing the input to be decrypted
    // Returns:
    //   - String representing the decrypted result
    @Override
    public String decrypt(String input) {
        String result = input;
        for (int i = ciphers.size() - 1; i >= 0; i--) {
            result = ciphers.get(i).decrypt(result);
        }
        return result;
    }
}
