package com.xicheng.elasticsearch;

import com.xicheng.elasticsearch.common.EsConfigUtil;
import com.xicheng.elasticsearch.common.EsConstant;
import lombok.extern.slf4j.Slf4j;
import org.elasticsearch.action.admin.indices.exists.indices.IndicesExistsResponse;
import org.elasticsearch.client.IndicesAdminClient;
import org.elasticsearch.client.transport.TransportClient;

/**
 * description 查看索引是否存在
 *
 * @author xichengxml
 * @date 2020-09-20 22:00
 */
@Slf4j
public class C03_CheckIndex {

    public static void main(String[] args) {
        TransportClient client = EsConfigUtil.getClient();
        IndicesAdminClient indices = client.admin().indices();
        IndicesExistsResponse fakeResponse = indices.prepareExists("fake_index").get();
        IndicesExistsResponse existsResponse = indices.prepareExists(EsConstant.INDEX_NAME).get();
        log.info("fakeResponse: {}, existResponse: {}", fakeResponse.isExists(), existsResponse.isExists());
    }
}
