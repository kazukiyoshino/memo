package com.example.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

@Repository
public class GroupDaoImpl implements GroupDao {

    @PersistenceContext
    private EntityManager em;

    public List<Group> findGroupByName(String name) {
        Query query = em.createQuery("select x FROM Group x where x.name like ?1");
        query.setParameter(1, "%"+name+"%");
        List<Group> groups = query.getResultList();
        for (Group group : groups) {
            for (Member member : group.getMembers()) {
                member.getId();
            }
        }
        return groups;
    }

    public void insertGroup(Group group) {
        em.persist(group);
    }

    public void removeGroup(Group group) {
        em.remove(em.merge(group));
    }

}