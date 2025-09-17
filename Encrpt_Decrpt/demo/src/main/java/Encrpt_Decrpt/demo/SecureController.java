package Encrpt_Decrpt.demo;
import java.util.Base64;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/secure")
public class SecureController 
{
	    @Autowired
	    private CryptoService cryptoService;
	    private static final String secretKey = "1234567812345678"; // 16-char key for AES

	    private SecretKey getSecretKey() {
	        return new SecretKeySpec(secretKey.getBytes(), "AES");
	    }

	    @GetMapping("/hash")
	    public String getHash(@RequestParam String input) throws Exception {
	        return cryptoService.hashWithBouncy(input);
	    }

//	    @GetMapping("/encrypt")
//	    public String encrypt(@RequestParam String input) throws Exception {
//	        SecretKey key = keyGen.generateKey();//will generate different keys for security
//	        byte[] encrypted = cryptoService.encryptAES(input, key);
//	        return Base64.getEncoder().encodeToString(encrypted);
//	    }
	 
	 // ✅ Encrypt with a shared key
	    @GetMapping("/encrypt")
	    public String encrypt(@RequestParam String input) throws Exception {
	        byte[] encrypted = cryptoService.encryptAES(input, getSecretKey());
	        return Base64.getEncoder().encodeToString(encrypted);
	    }
	    
	    @GetMapping("/decrypt")
	    public String decrypt(@RequestParam String encryptedText) throws Exception {
	        byte[] decoded = Base64.getDecoder().decode(encryptedText);
	        return cryptoService.decryptAES(decoded, getSecretKey());
	    }
	}

