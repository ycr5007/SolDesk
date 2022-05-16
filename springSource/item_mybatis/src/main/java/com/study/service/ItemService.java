package com.study.service;

import java.util.List;

import com.study.dto.ItemDTO;

public interface ItemService {
	public boolean insert(ItemDTO insertDto);
	public boolean delete(int num);
	public boolean update(int num, String psize, int price);
	public ItemDTO getRow(int num);
	public List<ItemDTO> select();
}
