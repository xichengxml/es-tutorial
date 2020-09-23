package com.xicheng.elasticsearch;

import com.alibaba.fastjson.JSON;
import com.xicheng.elasticsearch.common.EsConfigUtil;
import lombok.extern.slf4j.Slf4j;
import org.elasticsearch.action.admin.indices.delete.DeleteIndexResponse;
import org.elasticsearch.client.IndicesAdminClient;
import org.elasticsearch.client.transport.TransportClient;

/**
 * description
 *
 * @author xichengxml
 * @date 2020-09-23 22:07
 */
@Slf4j
public class C05_DeleteIndex {

    public static void main(String[] args) {
        TransportClient client = EsConfigUtil.getClient();
        IndicesAdminClient adminClient = client.admin().indices();
        DeleteIndexResponse response = adminClient.prepareDelete("index04").get();
        log.info("C05_DeleteIndex main response: {}", JSON.toJSONString(response));
    }
}
