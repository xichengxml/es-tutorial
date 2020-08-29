package com.xicheng.es.lucene;

import com.xicheng.es.lucene.common.AnalyzerConstant;
import com.xicheng.es.lucene.common.AnalyzerUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.lucene.analysis.cn.smart.SmartChineseAnalyzer;
import org.apache.lucene.analysis.core.SimpleAnalyzer;
import org.apache.lucene.analysis.standard.StandardAnalyzer;

/**
 * description 各种分词器测试
 *
 * @author xichengxml
 * @date 2020-08-29 17:11
 */
@Slf4j
public class C01_Analyzer {

    public static void main(String[] args) throws Exception {
        SimpleAnalyzer simpleAnalyzer = new SimpleAnalyzer();
        StandardAnalyzer standardAnalyzer = new StandardAnalyzer();
        SmartChineseAnalyzer smartChineseAnalyzer = new SmartChineseAnalyzer();

        AnalyzerUtil.getAnalyzerResult(simpleAnalyzer, AnalyzerConstant.MESSAGE);
        AnalyzerUtil.getAnalyzerResult(standardAnalyzer, AnalyzerConstant.MESSAGE);
        AnalyzerUtil.getAnalyzerResult(smartChineseAnalyzer, AnalyzerConstant.MESSAGE);
    }


}
