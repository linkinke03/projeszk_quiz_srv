/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author pafuaai
 */
@Entity
public class quiz implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    public String kerdes;
    public String helyesValasz;
    public String valasz_2;
    public String valasz_3;
    public String valasz_4;
    
    
    /**
     * Adatbázis, kérdéslekérdező függvény
     * @return 
     */
    public String getKerdes() {
        return kerdes;
    }

    public void setKerdes(String kerdes) {
        this.kerdes = kerdes;
    }

    public String getHelyesValasz() {
        return helyesValasz;
    }

    public void setHelyesValasz(String helyesValasz) {
        this.helyesValasz = helyesValasz;
    }

    public String getValasz_2() {
        return valasz_2;
    }

    public void setValasz_2(String valasz_2) {
        this.valasz_2 = valasz_2;
    }

    public String getValasz_3() {
        return valasz_3;
    }

    public void setValasz_3(String valasz_3) {
        this.valasz_3 = valasz_3;
    }

    public String getValasz_4() {
        return valasz_4;
    }

    public void setValasz_4(String valasz_4) {
        this.valasz_4 = valasz_4;
    }
    
    
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof quiz)) {
            return false;
        }
        quiz other = (quiz) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.quiz[ id=" + id + " ]: "+getKerdes()+": "+getHelyesValasz()+"/"+
                getValasz_2()+"/"+getValasz_3()+"/"+getValasz_4();
    }
    
}
