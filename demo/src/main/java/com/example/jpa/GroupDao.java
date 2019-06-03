package com.example.jpa;

import java.util.List;

public interface GroupDao {
	List<Group> findGroupByName(String name);
    void insertGroup(Group group);
    void removeGroup(Group group);
}
