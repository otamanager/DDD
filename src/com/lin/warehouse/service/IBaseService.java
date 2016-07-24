package com.lin.warehouse.service;

import java.util.List;

public interface IBaseService<T> { 
	
	public void create(T t);
	
	public T read(int key);
	
	public void update(T t);
	
	public void delete(int key);
	
	public List<T> readAll();

}
