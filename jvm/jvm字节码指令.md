#### 加载和存储指令
加载和存储指令用于将数据在帧栈中的局部变量表和操作数栈之间来回传输。这些指令包括如下内容：
1：将一个局部变量加载到操作栈：iload、iload_<n>、lload、lload_<n>、fload、fload_<n>、dload、dload_<n>、aload、aload_<n>。    
2：将一个数值从操作数栈存储到局部变量表：istore、istore_<n>、lstore、lstore_<n>、fstore、fstore_<n>、dstore、dstore_<n>、astore、astore_<n>；  
3：将一个常量加载到操作数栈：bipush、sipush、ldc、ldc_w、ldc2_w、aconst_null、iconst_ml、iconst_<i>、lconst_<l>、fconst_<f>、dconst_<d>；    
4：扩充局部变量表的访问索引指令：wide。  

存储数据的操作数栈和局部变量表主要就是由加载和存储指令进行操作，除此之外，还有少量指令，如访问对象的字段或数组元素的指令也会向操作数栈传输数据。

注意：上面类似这样的格式：iload_<n>：代表了iload_0、iload_1、iload_2和iload_3这几条指令

#### 运算指令 
运算或算数指令用于对两个操作数栈上的值进行某种特定运算，并把结果重新存入到操作栈顶。大体上算数指令可以分为两种：对整型数据进行运算的指令和对浮点型数据进行运算的指令，无论哪种算数指令，都使用Java虚拟机的数据类型，由于没有直接支持byte、short、char和boolean类型的算术指令，对于这类数据的运算，应使用操作int类型的指令代替。整数和浮点数的算数指令在溢出和被除零的时候也有各自不相同的行为表现。所有的算术指令如下：

加法指令：iadd、ladd、fadd、dadd；   
减法指令：isub、lsub、fsub、dsub；   
乘法指令：imul、lmul、fmul、dmul；   
除法指令：idiv、ldiv、fdiv、ddiv；   
求余指令：irem、lrem、frem、drem；   
取反指令：ineg、lneg、fneg、dneg；   
位移指令：ishl、lshl、fshl、dshl；   
按位或指令：ior、lor；  
按位与指令：iand、land；    
按位异或指令：ixor、lxor；   
局部变量自增指令：iinc；  
比较指令：dcmpg、dcmpl、fcmpg、fcmpl、lcmp。  

#### 类型转换指令
类型转换指令可以将两种不同的数值类型的进行相互转换，这些转换操作一般用于实现用户代码中的显示类型转换操作或者用来处理字节码指令集中数据类型相关指令无法与数据类型一一对应的问题。

JVM直接支持（即转换时无需显示的转换指令）以下数值类型的宽化类型转换（Widening Numberic Conversions，即小范围类型向大范围类型的安全转换）：
int类型到long、float、或者double类型；
long类型到float、double类型；
float类型到double类型。
相对的，处理窄化类型转换（Narrowing Numberic Conversions）时 ，必须显示地使用转换指令来完成，这些转换指令包括：i2b、i2c、i2s、l2i、f2i、f2l、d2i、d2l、d2f。窄化类型转换可能导致转换结果产生不同的正负号、不同的数量级情况、转换过程很可能导致数值的精确度丢失。
注意：数值类型的窄化处理永远不可能导致虚拟机抛出运行时异常。

#### 对象创建与访问指令
虽然类实例和数组都是对象，但JVM对类实例和数组的创建与操作采用了不同的字节码指令。对象创建后，就可以通过对象访问指令获取对象实例或者数组中的字段或者数组元素，这些指令如下： 
1，创建类实例的指令：new；  
2，创建数组的指令：newarray、anewarray、multianewarray；        
3，访问类字段（static字段，或者成为类变量）和实例字段（非static字段，或者称为实例变量）的指令：getfield、putfield、getstatic、putstatic；        
4，把一个数组元素加载到操作数栈的指令：baload、caload、saload、iaload、laload、faload、daload、aaload；    
5，将一个操作数栈的值存储到数组元素中的指令：bastore、castore、sastore、iastore、fastore、dastore、aastore；  
6，取数组长度的指令：arraylength；     
7，检查类实例类型的指令：instanceof、checkcast。    

#### 操作数栈管理指令
如同操作一个普通数据结构中的堆栈那样，JVM直接提供了一些用于直接操作操作数栈的指令，包括：
1，将操作数栈的栈顶一个或两个元素出栈：pop、pop2；`
2，复制栈顶一个或两个数值并将复制值或双份的复制值重新压入栈顶：dup、dup2、dup_x1、dup2_x1、dup_x2、dup2_x2； 
3，将栈最顶端的两个数值互换：swap。    

#### 控制转移指令
控制转移指令可以让JVM有条件或者无条件地从指定的位置指令而不是控制转移指令的下一条指令继续执行程序，从概念模型上理解，可以认为控制转移指令就是在有条件或者无条件地修改PC寄存器的值。控制转移指令如下：
条件分支：ifeq、iflt、ifle、ifne、ifgt、ifge、ifnull、ifnonnull、if_icmpeq、if_icmpne、if_icmplt、if_icmpgt、if_icmple、if_icmpge、if_acmpeq和if_acmpne；
复合条件分支：tableswitch、lookupswitch；
无条件分支：goto、goto_w、jsr、jsr_w、ret；

在JVM中有专门的指令集用来处理int（boolean型、byte型、char型和short型的条件分支比较也都用int型，对于float型、double型的条件分支比较操作则会先执行相应类型的比较运算指令，它会返回一个整型值到操作数栈中，然后按int型执行）和reference类型的条件分支比较操作，为了可以无需明显标识一个实体值是否为null，也有专门的指令来检测null值。

#### 方法调用和返回指令
方法调用指令举例：
invokevirtual指令用于调用对象的实例方法，根据对象的实际类型进行分派（虚方法分派），这也是java语言最常见的方法分派方式；    
invokeinterface指令用于调用接口方法，它会在运行时搜索一个实现了这个接口方法的对象，找出适合的方法进行调用；   
invokespecial指令用于调用一些需要特殊处理的实例方法，包括实例初始化方法，私有方法和父类方法；   
invokestatic指令用于调用类方法（static方法）；    
invokedynamic指令用于在运行时动态解析出调用点限定符所引用的方法并执行该方法，前面4条调用指令的分派逻辑都固话在JVM内部，而invokedynamic指令的分派逻辑是由用户所设定的引导方法决定的。   
方法调用指令与数据类型无关，而方法返回指令是根据返回值的类型区分的，包括ireturn（当返回值是boolean、byte、char、short和int类型使用）、lreturn、freturn、dreturn和areturn，另外还有一条return指令供声明为void的方法、实例初始化方法以及类和接口的类初始化方法使用。 

#### 异常处理指令
在Java程序中显示抛出异常的操作（throw语句）都有athrow指令来实现，除了用throw语句显示抛出异常的情况之外，JVM规范还规定了许多运行时异常会在其他Java虚拟机指令检测到异常时自动抛出。而在Java虚拟机之中，处理异常不是由字节码指令来实现的，而是采用异常表来完成的。

#### 同步指令
JVM可以支持方法级的同步和方法内部一段指令序列的同步，这两种同步都使用管程（Monitor）来支持的。



存储数据的操作数栈和局部变量表主要就是由加载和存储指令进行操作，除此之外，还有少量指令，如访问对象的字段或数组元素的指令也会向操作数栈传输数据。

