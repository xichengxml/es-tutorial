package com.xicheng.lucene;

import com.xicheng.lucene.common.IndexConstant;
import lombok.extern.slf4j.Slf4j;
import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.document.StringField;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.store.FSDirectory;

import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * description
 *
 * @author xichengxml
 * @date 2020-09-02 21:54
 */
@Slf4j
public class C04_CreateIndex {

    public static void main(String[] args) throws Exception {
        // 索引目录文件
        Path indexPath = Paths.get(IndexConstant.INDEX_PATH);
        FSDirectory fsDirectory = FSDirectory.open(indexPath);
        // 引入分词计算器
        Analyzer analyzer = new C02_IKAnalyzer4Lucene7();

        // lucene配置
        IndexWriterConfig indexWriterConfig = new IndexWriterConfig(analyzer);
        indexWriterConfig.setOpenMode(IndexWriterConfig.OpenMode.CREATE);

        // 创建文档对象
        Document document01 = new Document();
        document01.add(new StringField("id", "1", Field.Store.NO));
        document01.add(new StringField("title", "香帅的北大金融学课", Field.Store.YES));
        document01.add(new StringField("sell_point", "帮你站在高处，重新理解财富", Field.Store.YES));

        Document document02 = new Document();
        document02.add(new StringField("id", "2", Field.Store.YES));
        document02.add(new StringField("title", "晓说", Field.Store.YES));
        document02.add(new StringField("sell_point", "世事上下千年，却偏要说出瞬间", Field.Store.YES));

        Document document03 = new Document();
        document03.add(new StringField("id", "3", Field.Store.YES));
        document03.add(new StringField("title", "for update", Field.Store.YES));
        document03.add(new StringField("sell_point", "用于测试更新", Field.Store.YES));

        Document document04 = new Document();
        document04.add(new StringField("id", "4", Field.Store.YES));
        document04.add(new StringField("title", "for delete", Field.Store.YES));
        document04.add(new StringField("sell_point", "用于测试删除", Field.Store.YES));

        // 将数据写入索引文件
        IndexWriter indexWriter = new IndexWriter(fsDirectory, indexWriterConfig);
        indexWriter.addDocument(document01);
        indexWriter.addDocument(document02);
        indexWriter.addDocument(document03);
        indexWriter.addDocument(document04);
        indexWriter.commit();

        // 关闭流资源
        indexWriter.close();
        fsDirectory.close();
    }
}
