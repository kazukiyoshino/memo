package com.example.mybatis3.dataaccess;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.mybatis3.model.Pet;

@Repository
public class PetDaoImpl implements PetDao {
	@Autowired
	private PetMapper petMapper;

	public Pet findPetById(int id) {
		return petMapper.selectPet(id);
	}

}
