/**
 * FinanceiroWS.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package br.com.javaparaweb.financeiro.webservice;

public interface FinanceiroWS extends java.rmi.Remote {
    public br.com.javaparaweb.financeiro.webservice.LancamentoItem[] extrato(int conta, java.util.Calendar de, java.util.Calendar ate) throws java.rmi.RemoteException;
    public float saldo(int conta, java.util.Calendar dataSaldo) throws java.rmi.RemoteException;
}
