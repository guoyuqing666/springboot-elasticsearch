package com.elasticsearch.Model;

import lombok.Data;

/**
 * Created by gyq on 2020/08/21
 */
@Data
public class Es {

    private String index;

    private String type;

    public Es(String index, String type) {
        this.index = index;
        this.type = type;
    }
}
