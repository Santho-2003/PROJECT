package Encrpt_Decrpt.demo;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class SendController 
{
	@PostMapping("/send")
    public ResponseEntity<String> sendMessage(@RequestBody SomeRequest request) {
        // process request
        return ResponseEntity.ok("Message sent!");
    }
}
