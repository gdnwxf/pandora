package com.wch;

import com.aliware.edas.EchoService;
import com.google.common.collect.Lists;
import com.meeruu.sg.mall.product.product.facade.StockSyncService;
import com.meeruu.sg.mall.product.product.facade.model.StockSyncDTO;
import com.taobao.hsf.app.api.util.HSFApiConsumerBean;

import java.util.List;

public class StockSyncTest {

    public static void main(String[] args) throws Throwable {
        HSFApiConsumerBean hsfApiConsumerBean = new HSFApiConsumerBean();
        hsfApiConsumerBean.setConfigserverCenter(null);
        hsfApiConsumerBean.setInterfaceClass(StockSyncService.class);

        hsfApiConsumerBean.init();
        StockSyncService stockSyncService = (StockSyncService) hsfApiConsumerBean.getObject();

        List<StockSyncDTO> stockSyncList = Lists.newArrayList();
        StockSyncDTO e = new StockSyncDTO();
        e.setOutWarehouseCode("dsad");
        e.setSupplierSkuCode("sku1111");
        e.setStock(50L);
        stockSyncList.add(e);

        List<StockSyncDTO> stockSyncDTOS = stockSyncService.stockSync("dsadash", "321321", "kkkk", stockSyncList);
        System.out.println(stockSyncDTOS);
        
    }
}
