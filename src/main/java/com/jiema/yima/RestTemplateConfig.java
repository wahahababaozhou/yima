package com.jiema.yima;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

import javax.net.ssl.*;
import java.io.InputStream;
import java.security.KeyStore;

@Configuration
public class RestTemplateConfig {

    @Bean
    public RestTemplate restTemplate(ClientHttpRequestFactory requestFactory) {
        try {
         //   initSSLConfigForOneWay();
           // initSSLConfigForTwoWay(ResourceUtils.getURL(systemConfig.getSelfCertPath()).openStream(), systemConfig.getSelfCertPassword(), ResourceUtils.getURL(systemConfig.getTrustCaPath()).openStream(), systemConfig.getTrustCaPassword());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new RestTemplate(requestFactory);
    }

    @Bean
    public ClientHttpRequestFactory simpleClientHttpRequestFactory() {
        SimpleClientHttpRequestFactory factory = new SimpleClientHttpRequestFactory();
        factory.setReadTimeout(30000);//ms
        factory.setConnectTimeout(30000);//ms
        return factory;
    }

    private void initSSLConfigForTwoWay(InputStream selfCertFile, String slefCertPassword, InputStream trustCaFile, String trustCaPassword) throws Exception {
        //1、导入自己证书
        KeyStore selfCert = KeyStore.getInstance("pkcs12");
        selfCert.load(selfCertFile, slefCertPassword.toCharArray());
        KeyManagerFactory kmf = KeyManagerFactory.getInstance("sunx509");
        kmf.init(selfCert, slefCertPassword.toCharArray());

        //2、导入服务器CA证书
        KeyStore caCert = KeyStore.getInstance("jks");
        caCert.load(trustCaFile, trustCaPassword.toCharArray());
        TrustManagerFactory tmf = TrustManagerFactory.getInstance("sunx509");
        tmf.init(caCert);

        SSLContext sc = SSLContext.getInstance("TLS");
        sc.init(kmf.getKeyManagers(), tmf.getTrustManagers(), null);

        SSLSocketFactory ssf = sc.getSocketFactory();
        HttpsURLConnection.setDefaultSSLSocketFactory(ssf);

        //3、关闭证书域名校验
        //(联调测试环境中，一般没有申请域名，而是使用ip进行访问的，这种场景下必须关闭证书的域名校验功能)
        HostnameVerifier allHostsValid = new HostnameVerifier() {
            @Override
            public boolean verify(String hostname, SSLSession session) {
                return true;
            }
        };
        HttpsURLConnection.setDefaultHostnameVerifier(allHostsValid);
    }

    @SuppressWarnings("unused")
    private void initSSLConfigForOneWay(InputStream trustCaFile, String trustCaPassword) throws Exception {
        //1、导入服务器CA证书
        KeyStore caCert = KeyStore.getInstance("jks");
        caCert.load(trustCaFile, trustCaPassword.toCharArray());
        TrustManagerFactory tmf = TrustManagerFactory.getInstance("sunx509");
        tmf.init(caCert);

        SSLContext sc = SSLContext.getInstance("TLS");
        sc.init(null, tmf.getTrustManagers(), null);

        SSLSocketFactory ssf = sc.getSocketFactory();
        HttpsURLConnection.setDefaultSSLSocketFactory(ssf);

        //2、关闭证书域名校验
        //(联调测试环境中，一般没有申请域名，而是使用ip进行访问的，这种场景下必须关闭证书的域名校验功能)
        HostnameVerifier allHostsValid = new HostnameVerifier() {
            @Override
            public boolean verify(String hostname, SSLSession session) {
                return true;
            }
        };
        HttpsURLConnection.setDefaultHostnameVerifier(allHostsValid);
    }

}  