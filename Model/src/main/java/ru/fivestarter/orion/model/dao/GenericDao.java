package ru.fivestarter.orion.model.dao;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;

/**
 * @author <a href='mailto:ystartsev@wiley.com'>Yury Startsev</a>
 * @version 04.03.13
 * @param <T> the type of a persistent domain object
 * @param <S> the type of an object's identifier
 */
public interface GenericDao<T extends Serializable, S extends Serializable> {
    /**
     * Saves the object.
     *
     * @param object the object
     */
    void saveObject(T object);

    /**
     * Updates the object.
     *
     * @param object the object
     */
    void updateObject(T object);

    /**
     * Deletes the object.
     *
     * @param object a persistent domain object
     */
    void deleteObject(T object);

    /**
     * Deletes the object by id.
     *
     * @param id    the object identifier
     */
    void deleteObjectById(S id);

    /**
     * Finds the object by id.
     *
     * @param id the object identifier
     * @return the object
     */
    T findObject(S id);

    /**
     * Finds all the objects of a type.
     *
     * @return the object
     */
    List<T> findAllObjects();

    EntityManager getEntityManager();
}
