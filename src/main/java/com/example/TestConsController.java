package com.example;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.client.RestTemplate;

@Controller
public class TestConsController {

	public void getEmployee() {
		String url="http://producer:8088/employee";
		RestTemplate rest=new RestTemplate();
		ResponseEntity<String> response=null;
		response=rest.exchange(url, HttpMethod.GET,getheader(),String.class);
		System.out.println(response.getBody());
	}

	private HttpEntity getheader() {
		HttpHeaders headers=new HttpHeaders();
		headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);		
		return new HttpEntity<>(headers);
	}
	
}
