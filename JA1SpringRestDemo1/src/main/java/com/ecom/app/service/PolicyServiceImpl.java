package com.ecom.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecom.app.entity.Policy;
import com.ecom.app.repository.IPolicyRepository;

@Service
public class PolicyServiceImpl implements IPolicyService {

	@Autowired
	IPolicyRepository policyRepository;
	
	
	@Override
	public boolean createPolicy(Policy policy) {
		Policy saveData =  policyRepository.save(policy);
		return saveData!=null?true:false;
	}

	@Override
	public Policy getPolicyById(int searchPolicyId) {
		
		return policyRepository.findById(searchPolicyId).get();
	}

	@Override
	public List<Policy> getAllPolicy() {
		
		return (List<Policy>)(policyRepository.findAll());
	}

	@Override
	public List<Policy> getPolicybySumAssuredRange(int range1, int range2) {
		
		// JPQL or HQL
		return null;
	}

}
