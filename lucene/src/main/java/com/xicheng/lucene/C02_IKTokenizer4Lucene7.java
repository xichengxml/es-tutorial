package com.xicheng.lucene;

import org.apache.lucene.analysis.Tokenizer;
import org.apache.lucene.analysis.tokenattributes.CharTermAttribute;
import org.apache.lucene.analysis.tokenattributes.OffsetAttribute;
import org.apache.lucene.analysis.tokenattributes.TypeAttribute;
import org.wltea.analyzer.core.IKSegmenter;
import org.wltea.analyzer.core.Lexeme;

import java.io.IOException;

/**
 * description 重写ik分词器
 *
 * @author xichengxml
 * @date 2020-08-29 18:02
 */
public class C02_IKTokenizer4Lucene7 extends Tokenizer {

    // IK分词器实现
    private IKSegmenter ikSegmenter;

    // 词元文本属性
    private CharTermAttribute charTermAttribute = null;
    // 词元位移属性
    private OffsetAttribute offsetAttribute = null;
    // 词元分类属性（该属性分类参考org.wltea.analyzer.core.Lexeme中的分类常量）
    private TypeAttribute typeAttribute = null;
    // 记录最后一个词元的结束位置
    private int endPosition;

    /**
     * @param useSmart
     */
    public C02_IKTokenizer4Lucene7(boolean useSmart) {
        super();
        offsetAttribute = addAttribute(OffsetAttribute.class);
        charTermAttribute = addAttribute(CharTermAttribute.class);
        typeAttribute = addAttribute(TypeAttribute.class);
        ikSegmenter = new IKSegmenter(input, useSmart);
    }

    /*
     * (non-Javadoc)
     *
     * @see org.apache.lucene.analysis.TokenStream#incrementToken()
     */
    @Override
    public boolean incrementToken() throws IOException {
        // 清除所有的词元属性
        clearAttributes();
        Lexeme nextLexeme = ikSegmenter.next();
        if (nextLexeme != null) {
            // 将Lexeme转成Attributes
            // 设置词元文本
            charTermAttribute.append(nextLexeme.getLexemeText());
            // 设置词元长度
            charTermAttribute.setLength(nextLexeme.getLength());
            // 设置词元位移
            offsetAttribute.setOffset(nextLexeme.getBeginPosition(),
                    nextLexeme.getEndPosition());
            // 记录分词的最后位置
            endPosition = nextLexeme.getEndPosition();
            // 记录词元分类
            typeAttribute.setType(nextLexeme.getLexemeTypeString());
            // 返会true告知还有下个词元
            return true;
        }
        // 返会false告知词元输出完毕
        return false;
    }

    /*
     * (non-Javadoc)
     *
     * @see org.apache.lucene.analysis.Tokenizer#reset(java.io.Reader)
     */
    @Override
    public void reset() throws IOException {
        super.reset();
        ikSegmenter.reset(input);
    }

    @Override
    public final void end() {
        // set final offset
        int finalOffset = correctOffset(this.endPosition);
        offsetAttribute.setOffset(finalOffset, finalOffset);
    }
}
