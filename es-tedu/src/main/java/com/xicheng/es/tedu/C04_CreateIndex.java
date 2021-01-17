package com.xicheng.es.tedu;

import com.alibaba.fastjson.JSON;
import com.xicheng.es.tedu.common.EsConfigUtil;
import lombok.extern.slf4j.Slf4j;
import org.elasticsearch.action.admin.indices.create.CreateIndexResponse;
import org.elasticsearch.client.IndicesAdminClient;
import org.elasticsearch.client.transport.TransportClient;

/**
 * description
 *
 * @author xichengxml
 * @date 2020-09-23 21:59
 */
@Slf4j
public class C04_CreateIndex {

    public static void main(String[] args) {
        TransportClient client = EsConfigUtil.getClient();
        IndicesAdminClient adminClient = client.admin().indices();
        CreateIndexResponse response = adminClient.prepareCreate("index05").get();
        log.info("C04_CreateIndex main response: {}", JSON.toJSONString(response));
    }
}
