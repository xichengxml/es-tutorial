package com.xicheng.elasticsearch.common;


import lombok.extern.slf4j.Slf4j;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.elasticsearch.transport.client.PreBuiltTransportClient;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * description
 *
 * @author xichengxml
 * @date 2020-09-20 21:34
 */
@Slf4j
public class EsConfigUtil {

    public static TransportClient getClient() {
        Settings esSettings = Settings.builder()
                .put("cluster.name", "es")
                .build();
        TransportClient transportClient = new PreBuiltTransportClient(esSettings);
        try {
            InetSocketTransportAddress inetSocketTransportAddress = new InetSocketTransportAddress(InetAddress.getByName(EsConstant.HOST), EsConstant.PORT);
            transportClient.addTransportAddress(inetSocketTransportAddress);
        } catch (UnknownHostException e) {
            log.error("EsConfigUtil getClient error: ", e);
        }
        return transportClient;
    }
}
