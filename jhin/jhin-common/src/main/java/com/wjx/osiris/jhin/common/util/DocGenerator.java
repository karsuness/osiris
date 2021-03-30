package com.wjx.osiris.jhin.common.util;

import io.github.yedaxia.apidocs.Docs;
import io.github.yedaxia.apidocs.DocsConfig;

/**
 * @author wangjinxin
 * @date 2021/3/30 22:48
 * @mail wjxScott@iCloud.com
 * @description 生成文档
 */
public class DocGenerator {
    public static void main(String[] args) {
        DocsConfig config = new DocsConfig();
        // 项目根目录
        config.setProjectPath(System.getProperty("user.dir") + "/jhin");
        System.out.println(System.getProperty("user.dir") + "/jhin");
        //项目名称
        config.setProjectName("jhin");
        // 声明该API的版本
        config.setApiVersion("V1.0");
        // 生成API 文档所在目录
        config.setDocsPath(System.getProperty("user.home") + "/Desktop/doc");
        // 配置自动生成
        config.setAutoGenerate(Boolean.TRUE);
        // 执行生成文档
        Docs.buildHtmlDocs(config);
    }
}
