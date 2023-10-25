package com.cropDetails.payment;

import java.util.Map;

import org.json.JSONObject;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.razorpay.*;
@RestController
public class PaymentController {
	
	@PostMapping("/create-order")
	public  String createOrder(@RequestBody Map<String,Object>data) throws RazorpayException {
		int amt=Integer.parseInt(data.get("amount").toString());
		 var client=new RazorpayClient("rzp_test_00CnfyN35ZxJtm", "Kzc4sWAK0sjBmUYLvL22ECJx");
		 JSONObject ob=new JSONObject();
		 ob.put("amount",amt*100 );
		 ob.put("currency", "INR");
		 ob.put("receipt", "txn_123456");
		 
		 
		 
		return "done";
	}

}
