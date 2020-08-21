package com.elasticsearch.service;


/**
 * Created by gyq on 2020/08/21
 */
public interface ElasticSearchService {

    void insertById(String index, String type, String id, String jsonStr);

    void updateById(String index, String type, String id, String jsonStr);

    void deleteById(String index, String type, String id);

}
