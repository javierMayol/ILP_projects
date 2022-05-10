package com.utilities;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;

public abstract class SuperMockDAO<T> {

	private HashMap<Integer, T> objectMap = new HashMap<Integer, T>();
	
	// We'll make the insert work
	public T save(T obj) { 
		// find getId
		Method method = findMethod(obj, "get");
		try {
			Object value = method.invoke(obj);
			int id = (Integer) value;
			// All IDs start at 1
			if (id == 0) {
				 // we have a new object and need a new Id
				id=objectMap.size()+1;
				method = findMethod(obj, "set");
				method.invoke(obj, id);
			}
			objectMap.put(id,obj);
		} catch (IllegalAccessException|IllegalArgumentException|InvocationTargetException e) {
			e.printStackTrace();
		}
		return obj;
	}
	
	// We'll make the update really work as well
	public void update(T obj) {
		// find getId
		Method method = findMethod(obj, "get");
		try {
			Object value = method.invoke(obj);
			int id = (Integer) value;
			// Only update the record if it exists.
			if (objectMap.containsKey(id)) {
				objectMap.replace(id, obj);	
			}
		} catch (IllegalAccessException|IllegalArgumentException|InvocationTargetException e) {
			e.printStackTrace();
		}
	}
	
	public ArrayList<T> findAll() {
		return new ArrayList<T>(objectMap.values());
	}
	
	public T findById(int id) {
		return objectMap.get(id);
	}

	public void deleteById(int id) {
		objectMap.remove(id);
	}
	
	// finds getId and setId
	private Method findMethod(T obj, String startsWith) {
		Class<?> cls = obj.getClass();
		Method[] methods = cls.getMethods();
		boolean found=false;
		Method method = null;
		int index=0;
		while (!found && index < methods.length) {
			String methodName = methods[index].getName();
			if (methodName.startsWith(startsWith) &&
					methodName.contains("Id")) {
				method=methods[index];
				found=true;
			}
			index++;
		}
		return method;
	}
}
