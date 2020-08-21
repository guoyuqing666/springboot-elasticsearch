package com.elasticsearch.service;

import java.util.List;
import java.util.Map;

import com.elasticsearch.Model.Es;

/**
 * Created by gyq on 2020/8/21
 */
public interface ApproxMatchService {
	
	List<Map<String, Object>> queryListFromES(Es es, String keyword);

}
