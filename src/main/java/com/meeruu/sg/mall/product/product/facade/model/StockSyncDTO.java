package com.meeruu.sg.mall.product.product.facade.model;

import lombok.Data;

import java.io.Serializable;

@Data
public class StockSyncDTO implements Serializable {

    /**
     * 外部仓库code
     */
    String outWarehouseCode;
    /**
     * 供应商skucode
     */
    String supplierSkuCode;
    /**
     * 库存code
     * 调用的时候 无须传此参数
     */
    String stockCode;
    /**
     * 库存
     */
    Long stock;
}
