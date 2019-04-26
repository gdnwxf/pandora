package com.wch;

import com.taobao.hsf.invocation.*;
import com.taobao.hsf.model.ApplicationModel;
import com.taobao.hsf.model.ConsumerMethodModel;
import com.taobao.hsf.model.metadata.ServiceMetadata;
import com.taobao.hsf.protocol.ServiceURL;
import com.taobao.hsf.protocol.ServiceURLRawData;
import com.taobao.hsf.remoting.service.HSFServiceURL;
import com.taobao.hsf.remoting.service.RemotingRPCProtocolComponent;
import com.taobao.hsf.util.AppServiceContainer;
import com.taobao.hsf.util.HSFServiceContainer;
import com.taobao.hsf.util.concurrent.ListenableFuture;

import java.util.concurrent.Executors;

public class Main {

    public static void main(String[] args) throws Throwable {
	// write your code here

        InvocationHandler component = HSFServiceContainer.getInstance(InvocationHandler.class);
        ApplicationModel applicationModel = new ApplicationModel("abc",ClassLoader.getSystemClassLoader(), true);
        ServiceMetadata serviceMetadata = new ServiceMetadata(applicationModel)
                ;
        serviceMetadata.setConnectionNum(1);
        ConsumerMethodModel consumerMethodModel
                = new ConsumerMethodModel( "getStockById" ,new String[]{"java.lang.Long"},   serviceMetadata );
        component = HSFServiceContainer.getInstance(InvocationHandler.class);
        Invocation invocation
                 = new Invocation();
        invocation.setExecutor(Executors.newSingleThreadExecutor());

        invocation.setApplicationModel(ApplicationModel.instance());
        invocation.setServerSide(false);
        invocation.setInvokeType(InvokeMode.SYNC);
        invocation.setPeerIP("172.18.7.189");
//        invocation.setBroadcastFutures();
//        invocation.setRouterState();
//        invocation.setBroadcastAddressList();
//String protocol, String host, int port, String path, String parameterString) {
        ServiceURLRawData serviceURLRaw = new ServiceURLRawData("hsf", "172.18.7.189", 12200,"com.meeruu.sg.mall.stock.facade.StockService", null);

        ServiceURL serverUrl = new HSFServiceURL(serviceMetadata, serviceURLRaw);
        invocation.setTargetAddress(serverUrl);
        invocation.setSerializeType((byte)14);
        invocation.setTargetServiceUniqueName("com.meeruu.sg.mall.stock.facade.StockService");
        invocation.setMethodArgs( new Object[] {131L});
//        invocation.setRequestProps();
//        invocation.setMethodArgSigs();
        invocation.setMethodName("getStockById");
//        invocation.setLocalAddr();
        invocation.setParameterClasses(new Class[]{Long.class});
        invocation.setNeedReliableCallback(false);
//        invocation.setReturnClass();
//        invocation.setInvokeContext();
//        invocation.setResponseStatus();
        invocation.setInvocationType(InvocationType.BIZ);




        invocation.getClientInvocationContext().setMethodModel(consumerMethodModel);

        ListenableFuture<RPCResult> invoke =
                component.invoke(invocation);

        RPCResult rpcResult = invoke.get();
        Object appResponse = rpcResult.getAppResponse();
        System.out.println(appResponse);
    }
}
