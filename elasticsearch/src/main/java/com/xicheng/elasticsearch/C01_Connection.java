package com.xicheng.elasticsearch;

import com.xicheng.elasticsearch.common.EsConstant;
import lombok.extern.slf4j.Slf4j;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.cluster.node.DiscoveryNode;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.elasticsearch.transport.client.PreBuiltTransportClient;

import java.net.InetAddress;
import java.util.List;

/**
 * description 测试连通性
 *
 * @author xichengxml
 * @date 2020-09-20 13:38
 */
@Slf4j
public class C01_Connection {

    public static void main(String[] args) throws Exception {
        TransportClient transportClient = new PreBuiltTransportClient(Settings.EMPTY);
        InetSocketTransportAddress inetSocketTransportAddress = new InetSocketTransportAddress(InetAddress.getByName(EsConstant.HOST), EsConstant.PORT);
        transportClient.addTransportAddress(inetSocketTransportAddress);
        List<DiscoveryNode> nodeList = transportClient.listedNodes();
        log.info("C01_Connection main nodeList: {}", nodeList);
    }
}
