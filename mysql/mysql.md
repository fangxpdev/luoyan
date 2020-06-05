# mysql回忆梳理

### 1、架构

连接器

分析器

优化器

执行器

存储引擎

### 2、行格式

变长类表信息|null值列表|头信息|实际数据

变长：不定长度的确定长度

null：为null的列

头信息：delete_mask/record_type/next_record/n_owed

record_type:0：普通记录   1.B+ 非叶子节点、2最小记录 3最大记录

实际数据：row_id、tx_id、roll_pointer、数据列

### 3、页结构

File header

页校验和、页号、上一页、下一页、
页的类型：undo日志页、系统页......

Page hader
层级、页记录数量、槽数量、最大事务id

Min/max

Free spaces

User records

page directory:将记录分组、加快查询
1、 对于最小记录所在的分组只能有 1 条记录，最大记录所在的分组拥有的记录条数只能在 1~8 条之间，剩下的分组中记录的条数范围只能在是 4~8 条之间

file tailer

校验和



### 4、索引

#### 4.1 聚簇索引

主键索引，包含所有记录

B+数结构



#### 4.2 二级索引

包含页号、主键值、索引列值

查询：先查询索引，拿到主键值，回表查询

#### 4.3 覆盖索引

索引包含所需要的所有列



### 5、explian

type、extra、possible keys 、key

### 6、锁

#### 全局锁

flush tables with read lock

set read_only = true



表锁：

lock table ... read/write

IX

IS

MDL锁



行锁：

X锁:select for update  /delete/update/create

s锁：select ... lock in share mode

### 7、日志

binlog：server端日志

Sync_binlog

redo log： prepare  commit  二阶段提交

undo log

relay log

### 8、主从同步

client 请求 ---> redo log prepare --->bin log ---->redo log commit 
binlog --->dump 线程 ---> slave I/O线程 ---> relay log ---> sql thread ---> 执行操作

### 9、慢查询

show status 

慢查询日志  show_slow_query

### 10、隔离级别

read uncommited

read commited

repeatble

serial

### 11、MVCC

ReadView:

m_ids

min_txs_id

Max_txs_id

Create_txs_id



read commited/repeatble的MVCC区别就是read view生成的时机不一样

### 12、页分裂

使用自增主键的好处，减少存储空间、二级索引会保存主键；自增新增不会产生也分裂

