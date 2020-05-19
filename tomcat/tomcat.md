# tomcat 



### Tomcat整体架构

![image-20200519105000346](./image/tomcat架构.png)

一个service单独对外提供服务，包括多个连接器一个容器；即一个容器对应多个连接器



### 连接器

Coyote主要功能：协议解析

![image-20200519105703692](./image/coyote.png)

![image-20200519104819967](./image/connector.png)

1. EndPoint 通信端点，提供的接口AbstractEndPoint；是具体socket连接和发送处理器，用来是实现TCP/IP协议

2. Processor 处理http/ajp协议，用来接受endpoint中的socket，读取字节流解析成Tomcat Request和Response对象；通过Adapter提交给

   容器处理，是对应用层协议的抽象。

3. adpter使用适配器模式，将request转化为ServletRequest



### 容器 - Catalina

![image-20200519110523963](./image/tomcat逻辑分层结构.png)

![image-20200519110755184](./image/catalina.png)

单servlet实例，多线程；线程不安全



#### 容器分层结构

![image-20200519111440955](./image/容器组件.png)

**engine:**表示Catalina的servlet引擎，用来管理多个虚拟站点(Host)，一个service只能用一个Engine

**Host:**表示一个虚拟主机，或者说一个站点

**Context:**表示一个Web应用程序，一个Web应用程序包含多个Wrapper

**Wrapper:**表示一个Servlet，Wrapper作为容器中的最底层，不能包含子容器



### Tomcat启动流程

![image-20200519113923833](./image/tomcat启动流程.png)

#### LifeCycle

![tomcat类图](./image/tomcat类图.png)



### Tomcat处理请求流程

![image-20200519140723650](./image/处理请求.png)

![image-20200519141002642](./image/tomcat请求处理时序图.png)

![image-20200519142353652](./image/请求流程示意图.png)s

