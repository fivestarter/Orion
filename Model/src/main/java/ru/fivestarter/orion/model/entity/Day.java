package ru.fivestarter.orion.model.entity;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import ru.fivestarter.orion.model.auth.entity.User;
import ru.fivestarter.orion.model.common.BaseEntity;

/**
 * @author <a href='mailto:ystartsev@wiley.com'>Yury Startsev</a>
 * @version 01.03.13
 */
@Entity
@Table(name = "Day")
public class Day extends BaseEntity{
    private static final long serialVersionUID = 1L;

    @ManyToOne
    @JoinColumn(name = "userId", nullable = false, updatable = false, insertable = false)
    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
