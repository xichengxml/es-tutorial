package com.xicheng.es.lucene;

import com.xicheng.es.lucene.common.AnalyzerConstant;
import com.xicheng.es.lucene.common.AnalyzerUtil;
import lombok.extern.slf4j.Slf4j;

/**
 * description 测试ik分词器基本功能
 *
 * @author xichengxml
 * @date 2020-08-29 18:06
 */
@Slf4j
public class C02_IKAnalyzer {

    public static void main(String[] args) throws Exception {

        // 细粒度切分
        C02_IKAnalyzer4Lucene7 ikAnalyzer = new C02_IKAnalyzer4Lucene7();
        // 智能切分
        C02_IKAnalyzer4Lucene7 smartIkAnalyzer = new C02_IKAnalyzer4Lucene7(true);

        AnalyzerUtil.getAnalyzerResult(ikAnalyzer, AnalyzerConstant.MESSAGE);
        AnalyzerUtil.getAnalyzerResult(smartIkAnalyzer, AnalyzerConstant.MESSAGE);
    }
}
