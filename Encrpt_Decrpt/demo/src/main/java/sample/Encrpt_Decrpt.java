package sample;
import org.jasypt.util.text.BasicTextEncryptor;
public class Encrpt_Decrpt
{
public static void main(String[] args) 
{
String secretKey = "Santhoshini@Key123"; // shared key
String originalText = "Sheela keep all my pics safely";

	        // Encrypt
BasicTextEncryptor encryptor = new BasicTextEncryptor();
encryptor.setPassword(secretKey);
String encryptedMessage = encryptor.encrypt(originalText);
String encryptedText = encryptor.encrypt(originalText);

	        // Decrypt
BasicTextEncryptor decryptor = new  BasicTextEncryptor();
decryptor.setPassword(secretKey);
String decryptedMessage = decryptor.decrypt(encryptedMessage);
String decryptedText = decryptor.decrypt(encryptedText);
System.out.println("Original Message      : " + originalText);
System.out.println("🔐 Encrypted Text     : " + encryptedText);
System.out.println("🔓 Decrypted Message  : " + decryptedText);
}
}