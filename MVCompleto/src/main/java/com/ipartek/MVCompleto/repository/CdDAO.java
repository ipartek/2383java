package com.ipartek.MVCompleto.repository;

import java.util.List;

import com.ipartek.MVCompleto.domain.Cd;

public interface CdDAO {

	public List<Cd> getCds();
	public void addCd(Cd cd);
	
}
