package ru.fivestarter.orion.model.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

import ru.fivestarter.orion.model.common.BaseEntity;

/**
 * @author <a href='mailto:ystartsev@wiley.com'>Yury Startsev</a>
 * @version 01.03.13
 */
@Entity
@Table(name = "Purpose")
public class Purpose extends BaseEntity{
    private static final long serialVersionUID = 1L;

}
