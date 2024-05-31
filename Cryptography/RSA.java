package Cryptography;
import java.math.BigInteger;
import java.security.SecureRandom;

public class RSA {
    private BigInteger n, d, e;

    /** Create an instance that can both encrypt and decrypt. */
    public RSA(int bits) {
        // Length of the key in bits
        SecureRandom r = new SecureRandom();
        BigInteger p = new BigInteger(bits / 2, 100, r);
        BigInteger q = new BigInteger(bits / 2, 100, r);
        n = p.multiply(q);
        BigInteger m = (p.subtract(BigInteger.ONE)).multiply(q.subtract(BigInteger.ONE));
        e = new BigInteger("65537"); // Commonly used prime exponent
        d = e.modInverse(m);
    }

    /** Encrypt the given plaintext message. */
    public synchronized String encrypt(String message) {
        return (new BigInteger(message.getBytes())).modPow(e, n).toString();
    }

    /** Decrypt the given ciphertext message. */
    public synchronized String decrypt(String message) {
        return new String((new BigInteger(message)).modPow(d, n).toByteArray());
    }

    /** Return the modulus. */
    public synchronized BigInteger getN() {
        return n;
    }

    /** Return the public key. */
    public synchronized BigInteger getE() {
        return e;
    }

    /** Return the private key. */
    public synchronized BigInteger getD() {
        return d;
    }

    public static void main(String[] args) {
        RSA rsa = new RSA(1024);

        String plaintext = "HELLO";
        System.out.println("Plaintext: " + plaintext);

        String ciphertext = rsa.encrypt(plaintext);
        System.out.println("Ciphertext: " + ciphertext);

        String decryptedText = rsa.decrypt(ciphertext);
        System.out.println("Decrypted text: " + decryptedText);
    }
}
