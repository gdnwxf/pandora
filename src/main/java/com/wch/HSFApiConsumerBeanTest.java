package com.wch;

import com.aliware.edas.EchoService;
import com.google.common.collect.Lists;
import com.taobao.hsf.app.api.util.HSFApiConsumerBean;
import com.taobao.hsf.invocation.*;
import com.taobao.hsf.model.ApplicationModel;
import com.taobao.hsf.model.ConsumerMethodModel;
import com.taobao.hsf.model.metadata.ServiceMetadata;
import com.taobao.hsf.protocol.ServiceURL;
import com.taobao.hsf.protocol.ServiceURLRawData;
import com.taobao.hsf.remoting.service.HSFServiceURL;
import com.taobao.hsf.util.HSFServiceContainer;
import com.taobao.hsf.util.concurrent.ListenableFuture;

import java.util.concurrent.Executors;

public class HSFApiConsumerBeanTest {

    public static void main(String[] args) throws Throwable {
        HSFApiConsumerBean hsfApiConsumerBean = new HSFApiConsumerBean();
        hsfApiConsumerBean.setConfigserverCenter(null);
        hsfApiConsumerBean.setInterfaceClass(EchoService.class);

        hsfApiConsumerBean.init();
        EchoService echoService = (EchoService) hsfApiConsumerBean.getObject();

        for ( ;; ) {
            String echo = echoService.echo("hdshadhsa ");

            System.out.println(echo);
        }
    }
}
