package com.xicheng.es.tedu;

import com.xicheng.es.tedu.common.EsConfigUtil;
import com.xicheng.es.tedu.common.EsConstant;
import lombok.extern.slf4j.Slf4j;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.index.query.MatchQueryBuilder;
import org.elasticsearch.index.query.Operator;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;

/**
 * description
 *
 * @author xichengxml
 * @date 2020-09-23 22:33
 */
@Slf4j
public class C07_MatchQuery {

    public static void main(String[] args) {
        TransportClient client = EsConfigUtil.getClient();
        MatchQueryBuilder matchQueryBuilder = QueryBuilders.matchQuery("title", "苹果").operator(Operator.OR);
        SearchResponse response = client.prepareSearch(EsConstant.INDEX_NAME).setQuery(matchQueryBuilder).setSize(10).get();
        log.info("C07_MatchQuery main response: {}", response);
        SearchHits hits = response.getHits();
        for (SearchHit hit : hits) {
            log.info("C07_MatchQuery main hit: {}", hit.getSource());
        }
    }
}
