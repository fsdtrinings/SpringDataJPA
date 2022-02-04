package com.ecom.app.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ecom.app.entity.Policy;
import com.ecom.app.service.IPolicyService;

@RestController
@RequestMapping("/policy")
public class PolicyRestController {

	@Autowired
	IPolicyService policyService;
	
	@PostMapping("/")
	public ResponseEntity<Boolean> insertPolicy(@RequestBody Policy policy)
	{
		boolean isInserted = false;
		
		isInserted = policyService.createPolicy(policy);
		
				
		return new ResponseEntity<Boolean>(isInserted,
				 isInserted==true?HttpStatus.OK:HttpStatus.EXPECTATION_FAILED);
	}
	
	@GetMapping("/{searchPolicyId}")
	public ResponseEntity<Policy> getPolicy(@PathVariable int searchPolicyId)
	{
		Policy p =  policyService.getPolicyById(searchPolicyId);
		return new ResponseEntity<Policy>(p,HttpStatus.OK);
	
	}
	
	@GetMapping("/policies")
	public ResponseEntity<List<Policy>> getAllPolicy()
	{
		List<Policy> list = policyService.getAllPolicy();
		return new ResponseEntity<List<Policy>>(list!=null?list:null,HttpStatus.OK);
	
	}
	
	
	
}
