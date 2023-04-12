package com.tns.shopowner;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class ShopOwnerServices {
	
	@Autowired
	
	private ShopOwnerServicesRepository repo;
	public List <ShopOwner> listAll()
	{
		return repo.findAll();
	}
	public ShopOwner get(Integer sh_id)
	{
		return repo.findById(sh_id).get();
	}
	public void delete(Integer sh_id)
	{
		repo.deleteById(sh_id);
	}
	public void save (ShopOwner spr)
	{
		repo.save(spr);
	}

}
