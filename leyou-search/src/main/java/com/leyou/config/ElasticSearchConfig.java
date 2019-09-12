package com.leyou.config;/**
 * Created by nicajonh on 2019/9/12.
 * Description ${TEXT}
 */

import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.elasticsearch.xpack.client.PreBuiltXPackTransportClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import java.net.InetAddress;
import java.net.UnknownHostException;


/**
 * @ClassName ElasticSearchConfig
 * @Description es xpack配置
 * @Author nicajonh
 * @Date 2019/9/12 19:17
 * @Version 1.0
 **/
@Configuration
public class ElasticSearchConfig {

    @Value("${spring.data.elasticsearch.cluster-name}")
    private String clusterName;

    @Value("${spring.data.elasticsearch.xpack-security}")
    private String xPackSecurity;
    @Value("${spring.data.elasticsearch.cluster-nodes}")
    private String clusterNodes;

    @Value("${spring.data.elasticsearch.port}")
    private Integer port;

    @Bean
    public TransportClient transportClient() throws UnknownHostException {
        TransportClient client = new PreBuiltXPackTransportClient(Settings.builder()
                .put("cluster.name", this.clusterName)
                .put("xpack.security.user", this.xPackSecurity)
                .build());
        String[] ips = this.clusterNodes.split(",");
        for(String ip : ips) {
            client.addTransportAddress(new InetSocketTransportAddress(InetAddress.getByName(ip), port));
        }

        return client;
    }
}

