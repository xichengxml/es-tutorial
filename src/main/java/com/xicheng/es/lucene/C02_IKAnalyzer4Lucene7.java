package com.xicheng.es.lucene;

import org.apache.lucene.analysis.Analyzer;

/**
 * description 重写ik分析器
 *
 * @author xichengxml
 * @date 2020-08-29 18:01
 */
public class C02_IKAnalyzer4Lucene7 extends Analyzer {

    private boolean useSmart = false;

    public C02_IKAnalyzer4Lucene7() {
        this(false);
    }

    public C02_IKAnalyzer4Lucene7(boolean useSmart) {
        super();
        this.useSmart = useSmart;
    }

    public boolean isUseSmart() {
        return useSmart;
    }

    public void setUseSmart(boolean useSmart) {
        this.useSmart = useSmart;
    }

    @Override
    protected TokenStreamComponents createComponents(String fieldName) {
        C02_IKTokenizer4Lucene7 tk = new C02_IKTokenizer4Lucene7(this.useSmart);
        return new TokenStreamComponents(tk);
    }
}
