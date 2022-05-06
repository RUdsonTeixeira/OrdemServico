package com.edu.ifms.ordem.dto;

import java.io.Serializable;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import com.edu.ifms.ordem.entities.Equipamento;
import com.edu.ifms.ordem.entities.OrdemDeServico;
import com.edu.ifms.ordem.entities.Tecnico;
import com.edu.ifms.ordem.entities.enums.Prioridade;
import com.edu.ifms.ordem.entities.enums.Status;

public class OrdemDeServicoDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	
	private Long id;
	

	private String descricaoProblema;
	private String descricaoSolucao;
	private Date dataCadastro;
	private Status status;
	private Prioridade prioridade;
	private Tecnico tecnico;
	private List<EquipamentoDTO> equipamentos = new ArrayList<>();
	
	public OrdemDeServicoDTO() {
		// TODO Auto-generated constructor stub
	}

	public OrdemDeServicoDTO(OrdemDeServico entity) {
		this.id = entity.getId();
		this.descricaoProblema = entity.getDescricaoProblema();
		this.descricaoSolucao = entity.getDescricaoSolucao();
		this.dataCadastro = entity.getDataCadastro();
		this.status = entity.getStatus();
		this.prioridade = entity.getPrioridade();
		this.tecnico = entity.getTecnico();
	}
	
	public OrdemDeServicoDTO(OrdemDeServico entity, Set<Equipamento> equipamentos) {
		this(entity);
		equipamentos.forEach(equipamento -> new EquipamentoDTO(equipamento));
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescricaoProblema() {
		return descricaoProblema;
	}

	public void setDescricaoProblema(String descricaoProblema) {
		this.descricaoProblema = descricaoProblema;
	}

	public String getDescricaoSolucao() {
		return descricaoSolucao;
	}

	public void setDescricaoSolucao(String descricaoSolucao) {
		this.descricaoSolucao = descricaoSolucao;
	}

	public Date getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(Date dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public Prioridade getPrioridade() {
		return prioridade;
	}

	public void setPrioridade(Prioridade prioridade) {
		this.prioridade = prioridade;
	}

	public Tecnico getTecnico() {
		return tecnico;
	}

	public void setTecnico(Tecnico tecnico) {
		this.tecnico = tecnico;
	}

	public List<EquipamentoDTO> getEquipamentos() {
		return equipamentos;
	}
	
	
}
