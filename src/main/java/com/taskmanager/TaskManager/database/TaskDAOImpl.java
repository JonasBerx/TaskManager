package com.taskmanager.TaskManager.database;

import com.taskmanager.TaskManager.domain.Task;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

@Repository
public class TaskDAOImpl implements TaskDAO {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void add(Task task) {
        entityManager.persist(task);
    }

    @Override
    public List<Task> listTasks() {
        CriteriaQuery<Task> criteriaQuery = entityManager.getCriteriaBuilder().createQuery(Task.class);
        @SuppressWarnings("unused")
        Root<Task> root = criteriaQuery.from(Task.class);
        return entityManager.createQuery(criteriaQuery).getResultList();
    }
}
