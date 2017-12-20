package com.ipartek.MVCompleto.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ipartek.MVCompleto.domain.Cd;
import com.ipartek.MVCompleto.repository.CdDAO;
import com.ipartek.MVCompleto.service.CdService;

@Service
public class CdServiceImpl implements CdService{
	
	@Autowired
	CdDAO cdDAO;

	public List<Cd> getCds() {
		return cdDAO.getCds();
	}

	public void addCd(Cd cd) {
		cdDAO.addCd(cd);
	}

}
