package com.guo.ssm.repositories;

import java.util.List;

public interface Repository<T> {
	
	public List<T> getAll();
	
	public void saveObject(T object);

}