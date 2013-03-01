package ru.fivestarter.orion.model.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import ru.fivestarter.orion.model.auth.entity.User;
import ru.fivestarter.orion.model.common.BaseEntity;
import ru.fivestarter.orion.model.common.ModelConstraints;

/**
 * @author <a href='mailto:ystartsev@wiley.com'>Yury Startsev</a>
 * @version 01.03.13
 */
@Entity
@Table(name = "Purpose")
public class Purpose extends BaseEntity{
    private static final long serialVersionUID = 1L;

    @ManyToOne
    @JoinColumn(name = "userId", nullable = false, updatable = false, insertable = false)
    private User user;

    @Column(name = "title", length = ModelConstraints.STRING_VARCHAR_255_LENGTH, nullable = false)
    private String title;

    @Lob
    @Column(name = "content", nullable = false)
    private String content;

    @Column(name = "hasRoot", nullable = false)
    private Boolean hasRoot = false;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true)
    private List<Purpose> children;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Purpose> getChildren() {
        return children;
    }

    public void setChildren(List<Purpose> children) {
        this.children = children;
    }

    public Boolean getHasRoot() {
        return hasRoot;
    }

    public void setHasRoot(Boolean hasRoot) {
        this.hasRoot = hasRoot;
    }
}
