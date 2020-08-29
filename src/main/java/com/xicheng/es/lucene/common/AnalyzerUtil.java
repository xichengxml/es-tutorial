package com.xicheng.es.lucene.common;

import lombok.extern.slf4j.Slf4j;
import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.TokenStream;
import org.apache.lucene.analysis.tokenattributes.CharTermAttribute;

import java.io.StringReader;

/**
 * description
 *
 * @author xichengxml
 * @date 2020-08-29 18:08
 */
@Slf4j
public class AnalyzerUtil {

    public static void getAnalyzerResult(Analyzer analyzer, String message) throws Exception {
        StringReader stringReader = new StringReader(message);

        TokenStream tokenStream = analyzer.tokenStream(null, stringReader);
        tokenStream.reset();
        CharTermAttribute charTermAttribute = tokenStream.getAttribute(CharTermAttribute.class);

        log.info("-----------------{}----------------", analyzer.getClass().getSimpleName());
        while (tokenStream.incrementToken()) {
            log.info("result: {}", charTermAttribute.toString());
        }
    }
}
