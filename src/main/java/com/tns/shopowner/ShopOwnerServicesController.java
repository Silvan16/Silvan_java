package com.tns.shopowner;

import java.util.List;

import javax.persistence.NoResultException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ShopOwnerServicesController {
	@Autowired
	private ShopOwnerServices a;
	
	
	@GetMapping(("/ShopOwnerServices"))
	public List<ShopOwner> list()
	{
		return a.listAll();
	}
	@GetMapping("/ShopOwnerServices/(sh_id)")
	public ResponseEntity<ShopOwner> get (@PathVariable Integer sh_id)
	{
		try
		{
			ShopOwner sh=a.get(sh_id);
			return new ResponseEntity<ShopOwner>(sh,HttpStatus.OK);
		}
		catch(NoResultException e)
		{
			return new ResponseEntity<ShopOwner>(HttpStatus.NOT_FOUND);
		}
	}
	@PostMapping("/ShopOwnerServices")
	public void add(@RequestBody ShopOwner spr)
	{
		a.save(spr);
	}
	@PutMapping("/ShopOwnerServices/(sh_id)")
	public ResponseEntity<?> update(@RequestBody ShopOwner spr,@PathVariable Integer sh_id)
	{
		ShopOwner existshopowner=a.get(sh_id);
		a.save(spr);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	@DeleteMapping("/ShopOwnerServices/(ad_id)")
	public void delete (@PathVariable Integer sh_id)
	{
		a.delete(sh_id);
	}

}
