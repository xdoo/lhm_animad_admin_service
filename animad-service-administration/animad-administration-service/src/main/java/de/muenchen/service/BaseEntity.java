package de.muenchen.service;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;
import org.hibernate.search.annotations.IndexedEmbedded;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;
import java.util.UUID;

/**
 * @author claus.straube
 */
@MappedSuperclass
public abstract class BaseEntity implements Cloneable, Serializable {

    @Column(name = "OID")
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    @Type(type="uuid-char")
    UUID oid;

    public UUID getOid() {
        return oid;
    }

    public void setOid(UUID oid) {
        this.oid = oid;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BaseEntity that = (BaseEntity) o;

        return getOid() != null ? getOid().equals(that.getOid()) : that.getOid() == null;
    }

    @Override
    public int hashCode() {
        return 31* (getOid() != null ? getOid().hashCode() : 0);
    }
}
