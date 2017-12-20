package com.ipartek.MVCompleto.service;

import java.util.List;

import com.ipartek.MVCompleto.domain.Cd;

public interface CdService {
	
	public List<Cd> getCds();
	public void addCd(Cd cd);

}
