package br.com.javaparaweb.financeiro.webservice;

public class FinanceiroWSProxy implements br.com.javaparaweb.financeiro.webservice.FinanceiroWS {
  private String _endpoint = null;
  private br.com.javaparaweb.financeiro.webservice.FinanceiroWS financeiroWS = null;
  
  public FinanceiroWSProxy() {
    _initFinanceiroWSProxy();
  }
  
  public FinanceiroWSProxy(String endpoint) {
    _endpoint = endpoint;
    _initFinanceiroWSProxy();
  }
  
  private void _initFinanceiroWSProxy() {
    try {
      financeiroWS = (new br.com.javaparaweb.financeiro.webservice.FinanceiroWSServiceLocator()).getFinanceiroWSPort();
      if (financeiroWS != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)financeiroWS)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)financeiroWS)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (financeiroWS != null)
      ((javax.xml.rpc.Stub)financeiroWS)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public br.com.javaparaweb.financeiro.webservice.FinanceiroWS getFinanceiroWS() {
    if (financeiroWS == null)
      _initFinanceiroWSProxy();
    return financeiroWS;
  }
  
  public br.com.javaparaweb.financeiro.webservice.LancamentoItem[] extrato(int conta, java.util.Calendar de, java.util.Calendar ate) throws java.rmi.RemoteException{
    if (financeiroWS == null)
      _initFinanceiroWSProxy();
    return financeiroWS.extrato(conta, de, ate);
  }
  
  public float saldo(int conta, java.util.Calendar dataSaldo) throws java.rmi.RemoteException{
    if (financeiroWS == null)
      _initFinanceiroWSProxy();
    return financeiroWS.saldo(conta, dataSaldo);
  }
  
  
}