package Encrpt_Decrpt.demo;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.Security;
import java.util.Base64;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import org.springframework.stereotype.Service;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
@Service
public class CryptoService 
{
	    // AES encryption using javax.crypto
	    public byte[] encryptAES(String data, SecretKey key) throws Exception {
	        Cipher cipher = Cipher.getInstance("AES");
	        cipher.init(Cipher.ENCRYPT_MODE, key);
	        return cipher.doFinal(data.getBytes(StandardCharsets.UTF_8));
	    }

	    // Hashing using Bouncy Castle SHA-512
	    public String hashWithBouncy(String input) throws Exception {
	        Security.addProvider(new BouncyCastleProvider());
	        MessageDigest digest = MessageDigest.getInstance("SHA-512", "BC");
	        byte[] hashed = digest.digest(input.getBytes(StandardCharsets.UTF_8));
	        return Base64.getEncoder().encodeToString(hashed);
	    }
	 // AES decryption
	    public String decryptAES(byte[] encryptedData, SecretKey key) throws Exception {
	        Cipher cipher = Cipher.getInstance("AES");
	        cipher.init(Cipher.DECRYPT_MODE, key);
	        byte[] decrypted = cipher.doFinal(encryptedData);
	        return new String(decrypted, StandardCharsets.UTF_8);
	    }
	    public SecretKey getSecretKey() throws Exception {
	        javax.crypto.KeyGenerator keyGen = javax.crypto.KeyGenerator.getInstance("AES");
	        keyGen.init(128);
	        return keyGen.generateKey();
	    }
	}
