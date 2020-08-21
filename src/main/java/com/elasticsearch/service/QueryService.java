package com.elasticsearch.service;

import com.elasticsearch.Model.Es;

import java.util.List;
import java.util.Map;

/**
 * Created by gyq on 2020/08/21
 */
public interface QueryService {

    List<Map<String, Object>> queryListFromES(Es es, int storeId, String storeName, String startDate, String endDate);

}
