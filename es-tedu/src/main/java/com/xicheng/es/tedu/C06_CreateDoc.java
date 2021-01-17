package com.xicheng.es.tedu;

import com.alibaba.fastjson.JSON;
import com.xicheng.es.tedu.common.EsConfigUtil;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;
import org.elasticsearch.action.index.IndexRequestBuilder;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.client.transport.TransportClient;

/**
 * description
 *
 * @author xichengxml
 * @date 2020-09-23 22:27
 */
@Slf4j
public class C06_CreateDoc {

    public static void main(String[] args) {
        User user = new User();
        user.setName("东方不败");
        user.setAge(18);

        TransportClient client = EsConfigUtil.getClient();
        IndexRequestBuilder indexRequestBuilder = client.prepareIndex("index06", "type", "1");
        IndexResponse response = indexRequestBuilder.setSource(JSON.toJSONString(user)).execute().actionGet();
        log.info("C06_CreateDoc main response: {}", response);
    }

    @Getter
    @Setter
    @ToString
    private static class User {

        private String name;

        private int age;
    }
}
