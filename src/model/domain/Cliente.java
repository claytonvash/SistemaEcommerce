package model.domain;


import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import util.ValidacaoException;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Clayton
 */
@Entity
@Table(name = "TB_CLIENTE")
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CD_CLIENTE")
    private Integer Codigo;
    @Column(name = "NM_CLIENTE",length = 255, nullable = false)
    private String nome;
  
  public Cliente(){
      
  }

    public Integer getCodigo() {
        return Codigo;
    }

    public String getNome() {
        return nome;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 97 * hash + Objects.hashCode(this.Codigo);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Cliente other = (Cliente) obj;
        if (!Objects.equals(this.Codigo, other.Codigo)) {
            return false;
        }
        return true;
    }
    public void validar() throws ValidacaoException {
        if(this.nome == null || this.nome.equals(""))
            throw new ValidacaoException("Campo nome não preenchido");
    }
  
}
