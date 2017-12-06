package br.edu.ctp.ads.controller;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;


import br.edu.ctp.ads.dao.PassagemDAO;

import br.edu.ctp.ads.entity.Passagem;

@ManagedBean(name = "mBeanPass")
public class MBeanPassagem {

	private ArrayList<Passagem> passagens = new ArrayList<Passagem>();

	private Integer id;
	private String tipo;
	private String destino;
	private Integer assento;
	private Date data;
	private BigDecimal valor;
	private String descricao;

	@PostConstruct
	public void carregar() {
		passagens = new PassagemDAO().listar();
	}

	public void Salvar() {

		Passagem passagem = new Passagem();
		passagem.setId(this.id);
		passagem.setTipo(tipo);
		passagem.setDestino(destino);
		passagem.setAssento(assento);
		passagem.setDate(data);
		passagem.setValor(valor);
		passagem.setDescricao(descricao);

		new PassagemDAO().inserir(passagem);
		
		passagens = new PassagemDAO().listar();

	}
	
	public void alterar(Passagem passagem) {
		this.id = passagem.getId();
		this.tipo = passagem.getTipo();
		this.destino = passagem.getDestino();
		this.assento = passagem.getAssento();
		this.data = passagem.getDate();
		this.valor = passagem.getValor();
		this.descricao = passagem.getDescricao();
	}
	
	public void excluir(Passagem passagem) {
		new PassagemDAO().excluir(passagem.getId());
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getDestino() {
		return destino;
	}

	public void setDestino(String destino) {
		this.destino = destino;
	}

	public Integer getAssento() {
		return assento;
	}

	public void setAssento(Integer assento) {
		this.assento = assento;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public ArrayList<Passagem> getPassagens() {
		return passagens;
	}

	public void setPassagens(ArrayList<Passagem> passagens) {
		this.passagens = passagens;
	}

}
