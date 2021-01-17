package com.xicheng.es.tedu;

import com.xicheng.es.tedu.common.EsConfigUtil;
import com.xicheng.es.tedu.common.EsConstant;
import lombok.extern.slf4j.Slf4j;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.client.transport.TransportClient;

/**
 * description 根据id获取文档对象
 *
 * @author xichengxml
 * @date 2020-09-20 21:37
 */
@Slf4j
public class C02_GetData {

    public static void main(String[] args) {
        TransportClient client = EsConfigUtil.getClient();
        GetResponse response = client.prepareGet(EsConstant.INDEX_NAME, EsConstant.TYPE_NAME, "830972").get();
        String result = response.getSourceAsString();
        log.info("C02_GetData main result: {}", result);
    }
}
