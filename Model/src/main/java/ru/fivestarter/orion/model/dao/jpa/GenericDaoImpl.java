package ru.fivestarter.orion.model.dao.jpa;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import ru.fivestarter.orion.model.dao.GenericDao;

/**
 * @author <a href='mailto:ystartsev@wiley.com'>Yury Startsev</a>
 * @version 04.03.13
 * @param <T> the type of a persistent domain object
 * @param <S> the type of an object's identifier
 */
public class GenericDaoImpl<T extends Serializable, S extends Serializable> implements GenericDao<T, S> {

    /**
     * Entity Manager.
     */
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public void saveObject(T object) {
        entityManager.persist(object);
        entityManager.flush();
    }

    @Override
    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public void updateObject(T object) {
        entityManager.merge(object);
        entityManager.flush();
    }

    @Override
    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public void deleteObject(T object) {
        entityManager.remove(object);
        entityManager.flush();
    }

    @Override
    public void deleteObjectById(S id) {
        T object = findObject(id);
        deleteObject(object);
    }

    @SuppressWarnings("unchecked")
    @Override
    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public T findObject(S id) {
        Class<T> clazz = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass())
                .getActualTypeArguments()[0];
        T object = entityManager.find(clazz, id);
        return object;
    }

    @SuppressWarnings("unchecked")
    @Override
    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public List<T> findAllObjects() {
        Class<T> clazz = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass())
                .getActualTypeArguments()[0];
        return entityManager.createQuery("from " + clazz.getName()).getResultList();
    }

    @Override
    public EntityManager getEntityManager() {
        return entityManager;
    }
}
