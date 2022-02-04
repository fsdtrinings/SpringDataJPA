package com.ecom.app.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ecom.app.entity.Policy;

@Service
public interface IPolicyService {

	public boolean createPolicy(Policy policy);
	public Policy getPolicyById(int searchPolicyId);
	public List<Policy> getAllPolicy();
	public List<Policy> getPolicybySumAssuredRange(int range1,int range2);
}
