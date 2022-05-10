package com.service;

import java.util.ArrayList;

public interface ServiceInterface<T> {
	
	public ArrayList<T> findAll();

	public T findById(int id);
	
	public void update(T obj);
	
	public T save(T obj);
	
	public void deleteById(int id);
	
	public ArrayList<T> sort(String sorting);
}

