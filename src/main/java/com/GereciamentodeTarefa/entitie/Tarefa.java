package com.GereciamentodeTarefa.entitie;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity 
@Table(name = "TarefaRepository")

public class Tarefa {
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private Long id;
		 
		@Column(name = "nome")
		private String nome;
		
		@Column(name= "dataLimiteExecucao")
		private String dataLimiteExecucao;
		
		@Column(name= "StatusTarefa")
		private String detalhesTarefa;
		
		@Column(name = "statusTarefa")
		private String statusTarefa;
		
		@Column(name = "telefone")
		private String telefone;
		
		public Long getId() {
			return id;
		}
		public void setId(Long id) {
			this.id = id;
		}
		public String getNome(){
			return nome;
		}
		public void setNome(String nome) {
			this.nome = nome;
		}
		public String getdataLimiteExecucao() {
			return dataLimiteExecucao;
		}
		public void setdataLimiteExecucao(String dataLimiteExecucao) {
			this.dataLimiteExecucao= dataLimiteExecucao;
		}
		public String getdetalhesTarefa() {
			return detalhesTarefa;
		}
		public void setdetalhesTarefa(String detalhesTarefa) {
			this.detalhesTarefa= detalhesTarefa;
		}
		public String getStatusTarefa() {
			return statusTarefa;
		}
		public void setStatus(String statusTarefa) {
			this.statusTarefa= statusTarefa;
		}
}
