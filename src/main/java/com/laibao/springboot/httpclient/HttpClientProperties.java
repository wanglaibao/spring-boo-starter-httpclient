package com.laibao.springboot.httpclient;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author laibao wang
 */
@ConfigurationProperties(prefix = "spring.httpclient")
public class HttpClientProperties {


    /**
     * server host or ip
     */
    private String serverHost;

    /**
     * server port
     */
    private Integer serverPort;

    /**
     *
     * timeout for client to try to connect to the server
     */
    private Integer connectTimeout;

    /**
     * After establishing the connection, timeout for  the client socket to wait for response after sending the request
     */
    private Integer socketTimeout;


    /**
     * pooling connection manager max connection in the pool.
     */
    private Integer maxConnTotal;

    /**
     * max connections for pre route.
     */
    private Integer maxConnPerRoute;

    /**
     * metric name strategy: METHOD_ONLY, HOST_AND_METHOD(default), QUERYLESS_URL_AND_METHOD
     */
    private String metricNameStrategy = "HOST_AND_METHOD";

    public String getServerHost() {
        return serverHost;
    }

    public void setServerHost(String serverHost) {
        this.serverHost = serverHost;
    }

    public Integer getServerPort() {
        return serverPort;
    }

    public void setServerPort(Integer serverPort) {
        this.serverPort = serverPort;
    }

    public Integer getConnectTimeout() {
        return connectTimeout;
    }

    public void setConnectTimeout(Integer connectTimeout) {
        this.connectTimeout = connectTimeout;
    }

    public Integer getSocketTimeout() {
        return socketTimeout;
    }

    public void setSocketTimeout(Integer socketTimeout) {
        this.socketTimeout = socketTimeout;
    }

    public Integer getMaxConnTotal() {
        return maxConnTotal;
    }

    public void setMaxConnTotal(Integer maxConnTotal) {
        this.maxConnTotal = maxConnTotal;
    }

    public Integer getMaxConnPerRoute() {
        return maxConnPerRoute;
    }

    public void setMaxConnPerRoute(Integer maxConnPerRoute) {
        this.maxConnPerRoute = maxConnPerRoute;
    }

    public String getMetricNameStrategy() {
        return metricNameStrategy;
    }

    public void setMetricNameStrategy(String metricNameStrategy) {
        this.metricNameStrategy = metricNameStrategy;
    }
}
