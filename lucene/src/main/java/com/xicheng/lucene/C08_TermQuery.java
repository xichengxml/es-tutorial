package com.xicheng.lucene;

import com.alibaba.fastjson.JSON;
import com.xicheng.lucene.common.IndexConstant;
import lombok.extern.slf4j.Slf4j;
import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.index.Term;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.search.TermQuery;
import org.apache.lucene.search.TopDocs;
import org.apache.lucene.store.FSDirectory;

import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * description 词项查询
 *
 * @author xichengxml
 * @date 2020-09-06 23:29
 */
@Slf4j
public class C08_TermQuery {

    public static void main(String[] args) throws Exception {
        // 路径
        Path path = Paths.get(IndexConstant.INDEX_PATH);
        FSDirectory fsDirectory = FSDirectory.open(path);
        // 构建搜索对象
        DirectoryReader directoryReader = DirectoryReader.open(fsDirectory);
        IndexSearcher indexSearcher = new IndexSearcher(directoryReader);
        // 分词器
        Analyzer analyzer = new C02_IKAnalyzer4Lucene7();
        // 词项查询
        Term term = new Term("title", "北大");
        TermQuery termQuery = new TermQuery(term);
        log.info("C08_TermQuery main termQuery: {}", JSON.toJSONString(termQuery));
        // 获取查询结果
        TopDocs topDocs = indexSearcher.search(termQuery, 10);
        ScoreDoc[] scoreDocs = topDocs.scoreDocs;
        for (ScoreDoc scoreDoc : scoreDocs) {
            Document document = indexSearcher.doc(scoreDoc.doc);
            log.info("C08_TermQuery main document: {}", document);
        }
    }
}
