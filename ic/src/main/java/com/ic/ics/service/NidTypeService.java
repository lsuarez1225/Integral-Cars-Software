package com.ic.ics.service;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ic.ics.model.NidType;
import com.ic.ics.repository.NidTypeRepository;

@Service
public class NidTypeService {

	@Autowired
	private NidTypeRepository nidTypeRepository;
	
	public void addTypes() {
		NidType nidType1 = new NidType("Cédula");
		NidType nidType2 = new NidType("NIT");
		
		Set<NidType> types = new HashSet<NidType>();
		types.add(nidType1);
		types.add(nidType2);
		
		nidTypeRepository.saveAll(types);
	}
}
