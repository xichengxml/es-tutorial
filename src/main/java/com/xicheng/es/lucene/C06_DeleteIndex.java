package com.xicheng.es.lucene;

import com.xicheng.es.lucene.common.IndexConstant;
import lombok.extern.slf4j.Slf4j;
import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.index.Term;
import org.apache.lucene.store.FSDirectory;

import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * description 物理删除
 *
 * @author xichengxml
 * @date 2020-09-02 23:08
 */
@Slf4j
public class C06_DeleteIndex {

    public static void main(String[] args) throws Exception {
        Path indexPath = Paths.get(IndexConstant.INDEX_PATH);
        FSDirectory fsDirectory = FSDirectory.open(indexPath);

        Analyzer analyzer = new C02_IKAnalyzer4Lucene7();
        IndexWriterConfig indexWriterConfig = new IndexWriterConfig(analyzer);

        IndexWriter indexWriter = new IndexWriter(fsDirectory, indexWriterConfig);
        indexWriter.deleteDocuments(new Term("id", "4"));

        indexWriter.close();
        fsDirectory.close();
    }
}
