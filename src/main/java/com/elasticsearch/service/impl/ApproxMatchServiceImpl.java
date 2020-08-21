package com.elasticsearch.service.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.script.Script;
import org.elasticsearch.script.ScriptType;
import org.elasticsearch.search.aggregations.AggregationBuilders;
import org.elasticsearch.search.aggregations.BucketOrder;
import org.elasticsearch.search.aggregations.bucket.terms.Terms;
import org.elasticsearch.search.aggregations.metrics.sum.Sum;
import org.elasticsearch.search.aggregations.pipeline.PipelineAggregatorBuilders;
import org.springframework.stereotype.Service;

import com.elasticsearch.Model.Es;
import com.elasticsearch.service.ApproxMatchService;

/**
 * Created by gyq on 2020/8/21
 */
@Service
public class ApproxMatchServiceImpl implements ApproxMatchService{
	
	@Resource
	TransportClient transportClient;//注入es操作对象

	@Override
	public List<Map<String, Object>> queryListFromES(Es es, String keyword) {

        List<Map<String, Object>> list = new ArrayList<>();

        Map<String,Object> map = Collections.emptyMap();

        Script script = new Script(ScriptType.INLINE, "painless","params._value0 > 0",map);  //提前定义好查询销量是否大于1000的脚本，类似SQL里面的having

        long beginTime = System.currentTimeMillis();

        SearchResponse sr = transportClient.prepareSearch(es.getIndex()).setTypes(es.getType()) //要查询的表
        		.setQuery(QueryBuilders.boolQuery()
                        .should(QueryBuilders.termQuery("store_id", 2))  //挨个设置查询条件，没有就不加，如果是字符串类型的，要加keyword后缀
                        .should(QueryBuilders.wildcardQuery("store_name.keyword", "*"+keyword+"*"))
        		//.setQuery(QueryBuilders.wildcardQuery("store_name.keyword", "*"+keyword+"*")
                //.setQuery(QueryBuilders.fuzzyQuery("store_name.keyword", keyword)
                		
                ).execute().actionGet();

        System.out.println("gyq"+sr.toString());
       
        long endTime = System.currentTimeMillis();
        System.out.println("查询耗时" + ( endTime - beginTime ) + "毫秒");

        return list;
    }

}
