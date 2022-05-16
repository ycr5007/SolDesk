package com.study.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.study.dto.ItemDTO;
import com.study.mapper.ItemMapper;

@Service("service")
public class ItemServiceImpl implements ItemService{

	@Autowired
	private ItemMapper mapper;
	
	@Override
	public boolean insert(ItemDTO insertDto) {
		return mapper.insert(insertDto) > 0 ? true : false;
	}

	@Override
	public boolean update(int num, String psize, int price) {
		return mapper.update(num, psize, price) > 0 ? true : false;
	}

	@Override
	public boolean delete(int num) {
		return mapper.delete(num) > 0 ? true : false;
	}
	
	@Override
	public List<ItemDTO> select() {
		return mapper.select();
	}
	
	@Override
	public ItemDTO getRow(int num) {
		return mapper.searchOne(num);
	}
}
