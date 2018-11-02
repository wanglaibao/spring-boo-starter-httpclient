package com.laibao.springboot.httpclient;

import com.codahale.metrics.MetricRegistry;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.fluent.Executor;
import org.apache.http.client.fluent.Request;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.util.EntityUtils;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.nio.charset.Charset;

/**
 * @author laibao wang
 */

@Configuration
public class HttpClientAutoConfigurationTests {

    /*
            spring-boot-start-httpclient提供的服务：
                        org.apache.http.client.HttpClient: HttpClient
                        org.apache.http.client.fluent.Executor: Executor

            引用方式如下：
                        @Autowired
                        private HttpClient httpClient;

                        @Autowired
                        private Executor executor;
     */

    private static AnnotationConfigApplicationContext annotationConfigApplicationContext;

    // Run once, e.g. Database connection, connection pool
    @BeforeClass
    public static void setUp() {
        annotationConfigApplicationContext = new AnnotationConfigApplicationContext(
                HttpClientAutoConfigurationTests.class, HttpClientAutoConfiguration.class);
    }

    // Run once, e.g close connection, cleanup
    @AfterClass
    public static void runOnceAfterClass() {
        annotationConfigApplicationContext.registerShutdownHook();
    }

    @Bean
    public MetricRegistry registry() {
        return new MetricRegistry();
    }

    @Test
    public void testHttpClient() throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();
        HttpClient httpClient = annotationConfigApplicationContext.getBean(HttpClient.class);
        HttpGet httpGet = new HttpGet("https://www.sina.com.cn/");
        HttpResponse response = httpClient.execute(httpGet);
        EntityUtils.toString(response.getEntity());
        Thread.sleep(2000);
        HttpClientEndpoint endpoint = annotationConfigApplicationContext.getBean(HttpClientEndpoint.class);
        System.out.println(objectMapper.writeValueAsString(endpoint));
    }

    @Test
    public void testExecutor() throws Exception {
        Executor executor = annotationConfigApplicationContext.getBean(Executor.class);
        String content = executor.execute(Request.Get("https://www.sina.com.cn/")).returnContent().asString();
        System.out.println(new String(content.getBytes("UTF-8")));
    }
}
