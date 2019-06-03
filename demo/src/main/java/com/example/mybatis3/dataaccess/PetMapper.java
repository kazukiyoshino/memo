package com.example.mybatis3.dataaccess;

import com.example.mybatis3.model.Pet;
@MyMapper
public interface PetMapper {
	Pet selectPet(int petId);

}
