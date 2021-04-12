package java112.project3;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

/**
 *  This is a JavaBean to demonstrate using beans with JSP.
 *
 *@author    fRaisbeck
 */
public class HttpRequestData {

    private String remoteComputer;
    private String remoteAddress;
    private String requestMethod;
    private String requestURI;
    private StringBuffer requestURL;
    private String protocolRequest;
    private String serverName;
    private int serverPortNumber;
    private Locale localeServer;
    private String stringQuery;
    private String queryParameter;
    private String userAgent;

    public String getRemoteComputer() {
        return remoteComputer;
    }

    public void setRemoteComputer(String newRemoteComputer) {
        this.remoteComputer = newRemoteComputer;
    }

    public String getRemoteAddress() {
        return remoteAddress;
    }

    public void setRemoteAddress(String newRemoteAddress) {
        this.remoteAddress = newRemoteAddress;
    }

    public String getRequestMethod() {
        return requestMethod;
    }

    public void setRequestMethod(String newRequestMethod) {
        this.requestMethod = newRequestMethod;
    }

    public String getRequestURI() {
        return requestURI;
    }

    public void setRequestURI(String newRequestURI) {
        this.requestURI = newRequestURI;
    }

    public StringBuffer getRequestURL() {
        return requestURL;
    }

    public void setRequestURL(StringBuffer newRequestURL) {
        this.requestURL = newRequestURL;
    }

    public String getProtocolRequest() {
        return protocolRequest;
    }

    public void setProtocolRequest(String newProtocolRequest) {
        this.protocolRequest = newProtocolRequest;
    }

    public String getserverName() {
        return serverName;
    }

    public void setServerName(String newServerName) {
        this.serverName = newServerName;
    }

    public int getServerPortNumber() {
        return serverPortNumber;
    }

    public void setServerPortNumber(int newServerPortNumber) {
        this.serverPortNumber = newServerPortNumber;
    }

    public Locale getLocaleServer() {
        return localeServer;
    }

    public void setLocaleServer(Locale newLocaleServer) {
        this.localeServer = newLocaleServer;
    }

    public String getStringQuery() {
        return stringQuery;
    }

    public void setStringQuery(String newQueryString) {
        this.stringQuery = newQueryString;
    }

    public String getQueryParameter() {
        return queryParameter;
    }

    public void setQueryParameter(String newQueryParameter) {
        this.queryParameter = newQueryParameter;
    }

    public String getUserAgent() {
        return userAgent;
    }

    public void setUserAgent(String newUserAgent) {
        this.userAgent = newUserAgent;
    }

}
