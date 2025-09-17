package com.example.AvayaODPractice.Controller;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.Random;
import org.json.simple.JSONObject;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
@RestController

public class WebService 
{
    @GetMapping("/Details")
	public JSONObject validateDetails(@RequestParam(name ="dob", required=true, defaultValue="null")String dob, @RequestParam(name ="EmpNo", required=true, defaultValue="null")String EmpNo)  			   
 {
	 JSONObject respObj = new JSONObject();
     if(dob.equalsIgnoreCase("20030605")&& EmpNo.equalsIgnoreCase("1001"))	
     {
    	 respObj.put("Result", "true");
     }
     else
     {
    	 respObj.put("Result", "false");    	     
     }
	 return respObj;
 }
    @GetMapping("/Password")
	public JSONObject Password(@RequestParam(name ="dob", required=true, defaultValue="null")String dob, @RequestParam(name ="EmpNo", required=true, defaultValue="null")String EmpNo)  			   
    {
	 
    	int leftLimit = 97; // letter 'a'
        int rightLimit = 122; // letter 'z'
        int targetStringLength = 5;
        Random random = new Random();

        String generatedString = random.ints(leftLimit, rightLimit + 1)
          .limit(targetStringLength)
          .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
          .toString();
	
     JSONObject respObj = new JSONObject();     
     respObj.put("Result", generatedString);    	     
	 return respObj;
     }
    @GetMapping("/getDate")
	public ResponseEntity<JSONObject> getDate()
	{
		
		ArrayList<String> dateList = new ArrayList<String>();
		Random randomNum = new Random();
		int numberOfDate = randomNum.nextInt(4)+1;
		System.out.println(numberOfDate);
		
		for(int i =0;i<numberOfDate;i++)
		{
			GregorianCalendar gc = new GregorianCalendar();

	        int year = randBetween(2025, 2024);

	        gc.set(gc.YEAR, year);

	        int dayOfYear = randBetween(1, gc.getActualMaximum(gc.DAY_OF_YEAR));

	        gc.set(gc.DAY_OF_YEAR, dayOfYear);

	        dateList.add(gc.get(gc.YEAR) + "-" + (gc.get(gc.MONTH) + 1) + "-" + gc.get(gc.DAY_OF_MONTH));
//	        System.out.println(gc.get(gc.YEAR) + "-" + (gc.get(gc.MONTH) + 1) + "-" + gc.get(gc.DAY_OF_MONTH));
			
		}
		
		JSONObject respObj = new JSONObject();
		respObj.put("Result",dateList);
		return new ResponseEntity<>( respObj, HttpStatus.OK );
	}
	 public static int randBetween(int start, int end) {
	        return start + (int)Math.round(Math.random() * (end - start));
	    }
	
	@GetMapping("/dss1")
	public ResponseEntity<JSONObject> dss1()
	{
		JSONObject respObj = new JSONObject();
		respObj.put("Result","dss1");
		return new ResponseEntity<>( respObj, HttpStatus.NOT_FOUND );
	}
	
	@GetMapping("/dss2")
	public ResponseEntity<JSONObject> dss2()
	{
		JSONObject respObj = new JSONObject();
		respObj.put("Result","dss2");
		return new ResponseEntity<>( respObj, HttpStatus.NOT_FOUND );
	}
}
