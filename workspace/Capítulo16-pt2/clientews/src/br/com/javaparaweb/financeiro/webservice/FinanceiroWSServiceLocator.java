/**
 * FinanceiroWSServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package br.com.javaparaweb.financeiro.webservice;

public class FinanceiroWSServiceLocator extends org.apache.axis.client.Service implements br.com.javaparaweb.financeiro.webservice.FinanceiroWSService {

    public FinanceiroWSServiceLocator() {
    }


    public FinanceiroWSServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public FinanceiroWSServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for FinanceiroWSPort
    private java.lang.String FinanceiroWSPort_address = "http://localhost:8080/financeiro/webservice/financeiroWS";

    public java.lang.String getFinanceiroWSPortAddress() {
        return FinanceiroWSPort_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String FinanceiroWSPortWSDDServiceName = "FinanceiroWSPort";

    public java.lang.String getFinanceiroWSPortWSDDServiceName() {
        return FinanceiroWSPortWSDDServiceName;
    }

    public void setFinanceiroWSPortWSDDServiceName(java.lang.String name) {
        FinanceiroWSPortWSDDServiceName = name;
    }

    public br.com.javaparaweb.financeiro.webservice.FinanceiroWS getFinanceiroWSPort() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(FinanceiroWSPort_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getFinanceiroWSPort(endpoint);
    }

    public br.com.javaparaweb.financeiro.webservice.FinanceiroWS getFinanceiroWSPort(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            br.com.javaparaweb.financeiro.webservice.FinanceiroWSPortBindingStub _stub = new br.com.javaparaweb.financeiro.webservice.FinanceiroWSPortBindingStub(portAddress, this);
            _stub.setPortName(getFinanceiroWSPortWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setFinanceiroWSPortEndpointAddress(java.lang.String address) {
        FinanceiroWSPort_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (br.com.javaparaweb.financeiro.webservice.FinanceiroWS.class.isAssignableFrom(serviceEndpointInterface)) {
                br.com.javaparaweb.financeiro.webservice.FinanceiroWSPortBindingStub _stub = new br.com.javaparaweb.financeiro.webservice.FinanceiroWSPortBindingStub(new java.net.URL(FinanceiroWSPort_address), this);
                _stub.setPortName(getFinanceiroWSPortWSDDServiceName());
                return _stub;
            }
        }
        catch (java.lang.Throwable t) {
            throw new javax.xml.rpc.ServiceException(t);
        }
        throw new javax.xml.rpc.ServiceException("There is no stub implementation for the interface:  " + (serviceEndpointInterface == null ? "null" : serviceEndpointInterface.getName()));
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(javax.xml.namespace.QName portName, Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        if (portName == null) {
            return getPort(serviceEndpointInterface);
        }
        java.lang.String inputPortName = portName.getLocalPart();
        if ("FinanceiroWSPort".equals(inputPortName)) {
            return getFinanceiroWSPort();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://webservice.financeiro.javaparaweb.com.br/", "FinanceiroWSService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://webservice.financeiro.javaparaweb.com.br/", "FinanceiroWSPort"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("FinanceiroWSPort".equals(portName)) {
            setFinanceiroWSPortEndpointAddress(address);
        }
        else 
{ // Unknown Port Name
            throw new javax.xml.rpc.ServiceException(" Cannot set Endpoint Address for Unknown Port" + portName);
        }
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(javax.xml.namespace.QName portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        setEndpointAddress(portName.getLocalPart(), address);
    }

}
