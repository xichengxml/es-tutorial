package com.xicheng.es.lucene;

import com.xicheng.es.lucene.common.IndexConstant;
import lombok.extern.slf4j.Slf4j;
import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.index.Term;
import org.apache.lucene.search.*;
import org.apache.lucene.store.FSDirectory;

import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * description 布尔查询
 *
 * @author xichengxml
 * @date 2020-09-07 22:51
 */
@Slf4j
public class C09_BooleanQuery {

    public static void main(String[] args) throws Exception {
        Path path = Paths.get(IndexConstant.INDEX_PATH);
        FSDirectory fsDirectory = FSDirectory.open(path);

        DirectoryReader directoryReader = DirectoryReader.open(fsDirectory);
        IndexSearcher indexSearcher = new IndexSearcher(directoryReader);

        Analyzer analyzer = new C02_IKAnalyzer4Lucene7();
        TermQuery termQuery1 = new TermQuery(new Term("title", "晓说"));
        TermQuery termQuery2 = new TermQuery(new Term("title", "晓说"));

        BooleanClause booleanClause1 = new BooleanClause(termQuery1, BooleanClause.Occur.MUST);
        BooleanClause booleanClause2 = new BooleanClause(termQuery2, BooleanClause.Occur.MUST_NOT);
        BooleanQuery booleanQuery = new BooleanQuery.Builder().add(booleanClause1).add(booleanClause2).build();
        log.info("C09_BooleanQuery main booleanQuery: {}", booleanQuery);

        TopDocs topDocs = indexSearcher.search(booleanQuery, 10);
        for (ScoreDoc scoreDoc : topDocs.scoreDocs) {
            Document document = indexSearcher.doc(scoreDoc.doc);
            log.info("C09_BooleanQuery main document: {}", document);
        }
    }
}
