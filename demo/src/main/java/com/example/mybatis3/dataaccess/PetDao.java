package com.example.mybatis3.dataaccess;

import com.example.mybatis3.model.Pet;

public interface PetDao {
	Pet findPetById(int id);

}
