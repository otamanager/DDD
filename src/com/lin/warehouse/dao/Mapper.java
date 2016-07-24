package com.lin.warehouse.dao;

import java.util.List;

/**
 * 注意方法名称要和配置文件中的<select>/<insert>/<update>/<delete>的 id 一致 
 * @author lin
 *
 * @param <T>
 */
public interface Mapper<T> {
	
	public void create(T t);
	
	public T read(int id);
	
	public void update(T t);
	
	public void delete(int id);
	
	public List<T> readAll();

}
