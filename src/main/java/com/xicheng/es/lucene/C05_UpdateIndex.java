package com.xicheng.es.lucene;

import lombok.extern.slf4j.Slf4j;
import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.document.StringField;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.index.Term;
import org.apache.lucene.store.FSDirectory;

import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * description 本质上是先删除，再新建
 *
 * @author xichengxml
 * @date 2020-09-02 22:25
 */
@Slf4j
public class C05_UpdateIndex {

    public static void main(String[] args) throws Exception {
        Path indexPath = Paths.get("src\\main\\resources\\c04_index");
        FSDirectory fsDirectory = FSDirectory.open(indexPath);

        Analyzer analyzer = new C02_IKAnalyzer4Lucene7();
        IndexWriterConfig indexWriterConfig = new IndexWriterConfig(analyzer);

        Document documentAfterUpdate = new Document();
        documentAfterUpdate.add(new StringField("id", "3", Field.Store.YES));
        documentAfterUpdate.add(new StringField("title", "after update", Field.Store.YES));
        documentAfterUpdate.add(new StringField("sell_point", "用于测试更新", Field.Store.YES));

        IndexWriter indexWriter = new IndexWriter(fsDirectory, indexWriterConfig);
        indexWriter.updateDocument(new Term("id", "3"), documentAfterUpdate);
        indexWriter.commit();

        indexWriter.close();
        fsDirectory.close();
    }
}
