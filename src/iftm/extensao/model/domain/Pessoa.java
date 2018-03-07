package iftm.extensao.model.domain;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="TB_PESSOA")
public class Pessoa implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="CD_PESSOA")
	private Integer id;
	
	@Column(name="NM_PESSOA",nullable=false,length=200)
	private String nome;
	
	@OneToMany(mappedBy="autor")
	private List<Projeto> projetosAutor;
	
	@ManyToMany(mappedBy="participantes")
	private List<Projeto> participacoes;
	
	
	
	

}
