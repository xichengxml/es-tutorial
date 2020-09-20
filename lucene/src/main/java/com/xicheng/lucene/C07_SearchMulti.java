package com.xicheng.lucene;

import com.google.gson.Gson;
import com.xicheng.lucene.common.IndexConstant;
import lombok.extern.slf4j.Slf4j;
import org.apache.lucene.document.Document;
import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.queryparser.classic.MultiFieldQueryParser;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.search.TopDocs;
import org.apache.lucene.store.FSDirectory;

import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * description
 *
 * @author xichengxml
 * @date 2020-09-04 21:50
 */
@Slf4j
public class C07_SearchMulti {

    private static final Gson GSON = new Gson();

    public static void main(String[] args) throws Exception {
        // 路径
        Path indexPath = Paths.get(IndexConstant.INDEX_PATH);
        FSDirectory fsDirectory = FSDirectory.open(indexPath);

        // 创建搜索对象
        DirectoryReader directoryReader = DirectoryReader.open(fsDirectory);
        IndexSearcher indexSearcher = new IndexSearcher(directoryReader);

        C02_IKAnalyzer4Lucene7 analyzer = new C02_IKAnalyzer4Lucene7();

        // 构建查询条件
        String[] fields = {"title", "sell_point"};
        MultiFieldQueryParser multiFieldQueryParser = new MultiFieldQueryParser(fields, analyzer);
        Query query = multiFieldQueryParser.parse("江湖夜雨");
        log.info("C07_SearchMulti main query: {}", GSON.toJson(query));

        // 查询10条数据, 处理返回结果
        TopDocs topDocs = indexSearcher.search(query, 10);
        ScoreDoc[] scoreDocs = topDocs.scoreDocs;
        for (ScoreDoc scoreDoc : scoreDocs) {
            Document document = indexSearcher.doc(scoreDoc.doc);
            log.info("C07_SearchMulti main scoreDoc: {}", GSON.toJson(document));
        }
    }
}
