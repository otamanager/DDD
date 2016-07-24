package com.lin.warehouse.service.impl;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;

import com.lin.warehouse.dao.Mapper;
import com.lin.warehouse.service.IBaseService;

public abstract class BaseServiceImpl<T> implements IBaseService<T> {
	
	private Mapper<T> mapper;
	
	private SqlSessionTemplate sqlSessionTemplate;

	public BaseServiceImpl(Mapper<T> mapper) { 
		super();
		this.mapper = mapper;
	}

	public Mapper<T> getMapper() {
		return mapper;
	}

	public void setMapper(Mapper<T> mapper) {
		this.mapper = mapper;
	}

	@Override
	public void create(T t) {
		
		if(t != null)
		{
			mapper.create(t);
		}
	}

	@Override
	public T read(int key) {
		
		return mapper.read(key);
	}

	@Override
	public void update(T t) {
		
		if(t != null)
		{
			mapper.update(t);
		}
	}

	@Override
	public void delete(int key) {
		
		mapper.delete(key);
	}

	@Override
	public List<T> readAll() {
		
		return mapper.readAll();
	}

}
