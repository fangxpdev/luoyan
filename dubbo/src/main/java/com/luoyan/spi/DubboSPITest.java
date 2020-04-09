package com.luoyan.spi;

import org.apache.dubbo.common.extension.ExtensionLoader;
import org.apache.dubbo.rpc.Protocol;
import org.apache.dubbo.rpc.ProxyFactory;

public class DubboSPITest {

    public static void main(String[] args) {

//        Protocol p = ExtensionLoader.getExtensionLoader(Protocol.class).getAdaptiveExtension();

       ProxyFactory PROXY_FACTORY = ExtensionLoader.getExtensionLoader(ProxyFactory.class).getAdaptiveExtension();

    }

}
