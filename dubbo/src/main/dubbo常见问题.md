# 问题汇总

1. dubbo遇到的坑
   捕获不到服务端抛出的对应异常，dubbo封存成了RuntimeException；
   目的是为了防止客户端识别不了provider对应的异常导致报错

   详见：FilterException.invoke

2. hostname问题导致获取ip错误



