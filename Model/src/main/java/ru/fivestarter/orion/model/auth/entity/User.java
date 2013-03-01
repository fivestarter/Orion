package ru.fivestarter.orion.model.auth.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

import ru.fivestarter.orion.model.common.BaseEntity;

/**
 * @author <a href='mailto:ystartsev@wiley.com'>Yury Startsev</a>
 * @version 01.03.13
 */
@Entity
@Table(name = "User")
public class User extends BaseEntity{

}
