
package com.dat076.blogbox.utils;

import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Base class for all entities (later to be stored in database), 
 * Product, Order, etc
 * @author hajo
 */
@Entity
public abstract class AbstractEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id; 

    protected AbstractEntity(){

    }
    
    protected AbstractEntity(Long id){
        this.id = id;
    }
    
    
    public Long getId(){
        return id;
    }

    
    public int hashCode() {
        int hash = 5;
        hash = 71 * hash + Objects.hashCode(this.id);
        return hash;
    }

    
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final AbstractEntity other = (AbstractEntity) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }
}
