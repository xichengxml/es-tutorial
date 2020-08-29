package com.xicheng.es.lucene;

import com.xicheng.es.lucene.common.AnalyzerConstant;
import com.xicheng.es.lucene.common.AnalyzerUtil;
import lombok.extern.slf4j.Slf4j;

/**
 * description 测试Ik stopword和ext
 *
 * @author xichengxml
 * @date 2020-08-29 18:16
 */
@Slf4j
public class C03_IKAnalyzer {

    public static void main(String[] args) throws Exception {
        C02_IKAnalyzer4Lucene7 ikAnalyzer4Lucene7 = new C02_IKAnalyzer4Lucene7();
        AnalyzerUtil.getAnalyzerResult(ikAnalyzer4Lucene7, AnalyzerConstant.MESSAGE);
    }
}
