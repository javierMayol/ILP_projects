package com.dal;

import java.util.ArrayList;

public interface DAOInterface<T> {
	public ArrayList<T> findAll();

	public T findById(int id);
	
	public void update(T obj);
	
	public T save(T obj);
	
	public void deleteById(int id);
	
	public ArrayList<T> sort(String sorting);

}
