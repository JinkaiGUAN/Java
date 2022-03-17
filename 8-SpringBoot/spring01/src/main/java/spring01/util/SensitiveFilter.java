package spring01.util;

import org.apache.commons.lang3.CharUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/**
 * Copyright (C), Peter GUAN
 * FileName: SensitiveFilter
 * Author:   Peter
 * Date:     16/03/2022 22:33
 * Description:
 * History:
 * Version:
 */

@Component
public class SensitiveFilter {

    private static final Logger logger = LoggerFactory.getLogger(SensitiveFilter.class);

    // 替换字符
    private static final String REPLACEMENT = "***";

    private TrieNode root = new TrieNode();

    @PostConstruct // 在服务器开启之后 Bean注入容器中改方法就被调用， 也即铭感词的前缀树就被实例化
    public void init() {
        try (
                InputStream is = this.getClass().getClassLoader().getResourceAsStream("sensitive-words.txt"); // 字节流
                // 缓冲流
                BufferedReader reader  = new BufferedReader(new InputStreamReader(is));
                ) {
            String keyword;
            while ((keyword = reader.readLine()) != null) {
                // 添加到前缀树
                this.addKeyword(keyword);
            }

        } catch (IOException e) {
            logger.error("加载铭感词文件失败" + e.getMessage());
        }
    }

    /**
     *将一个敏感词添加到前缀树中
     * @param keyword
     */
    private void addKeyword(String keyword) {
        TrieNode tempNode = root;
        for (int i = 0; i < keyword.length(); i++) {
            char c = keyword.charAt(i);

            // 首次按查看当前目录下有没有字符c， 没有新建节点， 有的话 temp更新
            TrieNode subNode = tempNode.getSubNode(c);
            if (subNode == null) {
                subNode = new TrieNode();
                tempNode.addSubNode(c, subNode);
            }
            tempNode = subNode;

            // 设置结尾标记
            if (i == keyword.length() - 1) {
                tempNode.setKeyWordEnd(true);
            }
        }
    }

    /**
     * 过滤敏感词
     * @param text 带过滤文本
     * @return 过滤后的文本
     */
    public String filter(String text) {
        if (StringUtils.isBlank(text)) {
            return null;
        }

        TrieNode tempNode = root; // first pointer
        int  begin = 0; // second pointer
        int position = 0; // third pointer
        StringBuilder res = new StringBuilder();  // result

        while (position < text.length()) {
            char c = text.charAt(position);

            // 判断当前是否为符号, 跳过符号
            if (isSymbol(c)) {
                if (tempNode == root) {
                    res.append(c);
                    begin++;
                }
                position++;
                continue;
            }

            // 检查下级节点
            tempNode = tempNode.getSubNode(c);
            if (tempNode == null) {
                res.append(text.charAt(begin));
                position = ++begin;
                tempNode = root;
            } else if (tempNode.isKeyWordEnd()) {
                // 此时处于敏感词结尾
                res.append(REPLACEMENT);
                begin = ++position;
                tempNode = root;
            } else {
                position++;
            }
        }
        // position到达最后时， 可能begin还未到达最后， 此时中间的字符串需要添加
        res.append(text.substring(begin));

        return res.toString();
    }

    // 判断是否为符号
    private boolean isSymbol(Character c) {
        // 0x2E80 ~ 0x9FFF 是东亚文字范围
        return !CharUtils.isAsciiAlphanumeric(c) && (c < 0x2E80 || c > 0x9FFF);
    }


    // 前缀树
    private class TrieNode {

        // 关键词结束标识
        private boolean isKeyWordEnd = false;

        // 当前节点的子节点, key 是下级字符， value是下级节点
        private Map<Character, TrieNode> subNodes = new HashMap<>();

        public boolean isKeyWordEnd() {
            return isKeyWordEnd;
        }

        public void setKeyWordEnd(boolean keyWordEnd) {
            isKeyWordEnd = keyWordEnd;
        }

        // add node
        public void addSubNode(Character c, TrieNode node) {
            subNodes.put(c, node);
        }

        // get sub-node
        public TrieNode getSubNode(Character c) {
            return subNodes.get(c);
        }
    }
}


