package com.wjx.aphelios.solr.solr;

import com.wjx.aphelios.solr.entity.Productor;
import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.impl.HttpSolrClient;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocumentList;
import org.apache.solr.common.SolrInputDocument;

import java.util.UUID;

/**
 * @author WJX
 * @since 2018/4/13 13:56
 */
public class SolrService {
    /**
     * solr连接的url地址
     */
    private final String URL = "http://localhost:8080/solr";

    /**
     * 更新或添加索引库，当id相同时为更新，否则就是添加
     *
     * @param productor 产品信息
     * @throws Exception
     */
    public void update(Productor productor) throws Exception {
        SolrClient solrClient = new HttpSolrClient(URL);
        //创建一个文档对象
        SolrInputDocument document = new SolrInputDocument();
        //向文档中添加域
        //第一个参数：域的名称，域的名称必须是在schema.xml中定义的
        //第二个参数：域的值
        document.addField("id", UUID.randomUUID());
        document.addField("product_name", productor.getName());
        document.addField("product_price", productor.getPrice());
        document.addField("product_description", productor.getDescription());
        document.addField("product_picture", productor.getPicture());

        //把document对象添加到索引库中
        solrClient.add(document);
        //提交修改
        solrClient.commit();
    }

    /**
     * 查询所有的索引信息
     *
     * @return
     * @throws Exception
     */
    public SolrDocumentList query() throws Exception {

        SolrClient solrClient = new HttpSolrClient(URL);
        SolrQuery query = new SolrQuery();
        query.setQuery("*:*");

        QueryResponse response = solrClient.query(query);

        return response.getResults();
    }

    public void delete() throws Exception {
        SolrClient solrClient = new HttpSolrClient(URL);
        solrClient.deleteByQuery("*:*", 1000);
    }
}