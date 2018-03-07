package iftm.extensao.model.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="TB_PROJETO")
public class Projeto implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="CD_PROJETO")
	private Integer id;
	
	@Column(name="DS_NOME",nullable=false,length=200)
	private String nome;
	
	@Temporal(TemporalType.DATE)
	@Column(name="DT_INICIO")
	private Date dataInicio;
	
	@Temporal(TemporalType.DATE)
	@Column(name="DT_FIM")
	private Date dataFim;
	
	@Column(name="QT_HORAS",nullable=false)
	private Integer quantidadeHoras;
	
	@ManyToOne
	@JoinColumn(name="CD_AUTOR",referencedColumnName="CD_PESSOA")
	private Pessoa autor;
	
	@ManyToMany
	@JoinTable(name="TB_PARTICIPANTE_PROJETO",
	           joinColumns=
	                 @JoinColumn(name="CD_PROJETO",
	                 referencedColumnName="CD_PARTICIPANTE"))
	private List<Pessoa> participantes;
	
	

}
