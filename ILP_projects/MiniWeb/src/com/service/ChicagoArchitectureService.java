package com.service;

import java.util.ArrayList;
import com.bean.ChicagoArchitecture;
import com.dal.ChicagoArchitectureDao;

public class ChicagoArchitectureService implements ServiceInterface<ChicagoArchitecture> {
	
	private static ChicagoArchitectureDao dao;
	
	public ChicagoArchitectureService()
	{
		dao = new ChicagoArchitectureDao();
	}
	

	@Override
	public ArrayList<ChicagoArchitecture> findAll() {
		// TODO Auto-generated method stub
		return dao.findAll();
	}

	@Override
	public ChicagoArchitecture findById(int id) {
		// TODO Auto-generated method stub
		return dao.findById(id);
	}

	@Override
	public void update(ChicagoArchitecture obj) {
		// TODO Auto-generated method stub
		dao.update(obj);
		
	}

	@Override
	public ChicagoArchitecture save(ChicagoArchitecture obj) {
		// TODO Auto-generated method stub
		return dao.save(obj);
	}

	@Override
	public void deleteById(int id) {
		// TODO Auto-generated method stub
		dao.deleteById(id);
		
	}


	@Override
	public ArrayList<ChicagoArchitecture> sort(String sorting) {
		return dao.sort(sorting);
	}
	
	
}
