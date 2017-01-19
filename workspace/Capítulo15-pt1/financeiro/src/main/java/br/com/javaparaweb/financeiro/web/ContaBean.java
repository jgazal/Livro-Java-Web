package br.com.javaparaweb.financeiro.web;

import java.util.List;

import javax.faces.bean.*;
import br.com.javaparaweb.financeiro.conta.Conta;
import br.com.javaparaweb.financeiro.conta.ContaRN;
import org.primefaces.model.StreamedContent;
import javax.faces.context.FacesContext;
import javax.faces.application.FacesMessage;
import br.com.javaparaweb.financeiro.web.util.RelatorioUtil;
import br.com.javaparaweb.financeiro.util.UtilException;
import java.util.HashMap;

@ManagedBean
@RequestScoped
public class ContaBean {
	private Conta selecionada = new Conta();
	private List<Conta> lista = null;
	@ManagedProperty(value = "#{contextoBean}")
	private ContextoBean contextoBean;
	private StreamedContent	arquivoRetorno;
	private int tipoRelatorio;
	
	public String salvar() {
		this.selecionada.setUsuario(this.contextoBean.getUsuarioLogado());
		ContaRN contaRN = new ContaRN();
		contaRN.salvar(this.selecionada);
		this.selecionada = new Conta();
		this.lista = null;
		return null;
	}

	public String excluir() {
		ContaRN contaRN = new ContaRN();
		contaRN.excluir(this.selecionada);
		this.selecionada = new Conta();
		this.lista = null;
		return null;
	}

	public String tornarFavorita() {
		ContaRN contaRN = new ContaRN();
		contaRN.tornarFavorita(this.selecionada);
		this.selecionada = new Conta();
		return null;
	}
	
	public StreamedContent getArquivoRetorno() {
		FacesContext context = FacesContext.getCurrentInstance();
		String usuario = contextoBean.getUsuarioLogado().getLogin();
		String nomeRelatorioJasper = "contas"; //(_1_)
		String nomeRelatorioSaida = usuario + "_contas"; //(_2_)
		RelatorioUtil relatorioUtil = new RelatorioUtil();
		HashMap parametrosRelatorio = new HashMap(); //(_3_)
		parametrosRelatorio.put("codigoUsuario", contextoBean.getUsuarioLogado().getCodigo());
		try {
			this.arquivoRetorno = relatorioUtil.geraRelatorio(parametrosRelatorio, nomeRelatorioJasper,
				nomeRelatorioSaida, this.tipoRelatorio);
		} catch (UtilException e) {
			context.addMessage(null, new FacesMessage(e.getMessage()));
			return null;
		} 
		return this.arquivoRetorno;
	}

	public int getTipoRelatorio() {
		return tipoRelatorio;
	}
	
	public void setTipoRelatorio(int tipoRelatorio) {
		this.tipoRelatorio = tipoRelatorio;
	}

	public Conta getSelecionada() {
		return selecionada;
	}

	public void setSelecionada(Conta selecionada) {
		this.selecionada = selecionada;
	}

	public List<Conta> getLista() {
		if (this.lista == null) {
			ContaRN contaRN = new ContaRN();
			this.lista = contaRN.listar(this.contextoBean.getUsuarioLogado());
		}
		return this.lista;

	}

	public void setLista(List<Conta> lista) {
		this.lista = lista;
	}

	public ContextoBean getContextoBean() {
		return contextoBean;
	}

	public void setContextoBean(ContextoBean contextoBean) {
		this.contextoBean = contextoBean;
	}

	public void setArquivoRetorno(StreamedContent arquivoRetorno) {
		this.arquivoRetorno = arquivoRetorno;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((arquivoRetorno == null) ? 0 : arquivoRetorno.hashCode());
		result = prime * result + ((contextoBean == null) ? 0 : contextoBean.hashCode());
		result = prime * result + ((lista == null) ? 0 : lista.hashCode());
		result = prime * result + ((selecionada == null) ? 0 : selecionada.hashCode());
		result = prime * result + tipoRelatorio;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ContaBean other = (ContaBean) obj;
		if (arquivoRetorno == null) {
			if (other.arquivoRetorno != null)
				return false;
		} else if (!arquivoRetorno.equals(other.arquivoRetorno))
			return false;
		if (contextoBean == null) {
			if (other.contextoBean != null)
				return false;
		} else if (!contextoBean.equals(other.contextoBean))
			return false;
		if (lista == null) {
			if (other.lista != null)
				return false;
		} else if (!lista.equals(other.lista))
			return false;
		if (selecionada == null) {
			if (other.selecionada != null)
				return false;
		} else if (!selecionada.equals(other.selecionada))
			return false;
		if (tipoRelatorio != other.tipoRelatorio)
			return false;
		return true;
	}

}