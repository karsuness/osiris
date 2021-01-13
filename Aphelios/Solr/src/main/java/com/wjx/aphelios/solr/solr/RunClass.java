package com.wjx.aphelios.solr.solr;

import org.apache.solr.common.SolrDocumentList;
import wjx.entity.Productor;

/**
 * @author WJX
 * @since 2018/4/13 13:55
 */
public class RunClass {
    public static void main(String[] args) throws Exception {
        //测试solrj添加功能
        Productor productor = new Productor();
        productor.setName("华为荣耀9");
        productor.setPrice(2700L);
        productor.setDescription("华为2017年荣耀新手机");
        productor.setPicture("手机图片");

        SolrService solrService = new SolrService();

        solrService.update(productor);

        SolrDocumentList list = solrService.query();

        list.stream().forEach(e -> {
            System.out.println(e);
        });

        solrService.delete();
    }
}
