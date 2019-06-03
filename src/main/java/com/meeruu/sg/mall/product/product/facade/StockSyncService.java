package com.meeruu.sg.mall.product.product.facade;

import com.meeruu.sg.mall.product.product.facade.model.StockSyncDTO;

import java.util.List;

/**
 * #author qinghao
 * #date 2019-05-28 23:03
 */
public interface StockSyncService {

    /**
     * 库存同步接口
     * @param outSideSystemCode 外部系统code
     * @param supplierCode 外部供应商code
     * @param stockSyncDTOList
     * @return 返回无法同步的参数
     */
    List<StockSyncDTO> stockSync(String bizCode,
                                 String supplierCode,
                                 String outSideSystemCode,
                                 List<StockSyncDTO> stockSyncDTOList);
}
