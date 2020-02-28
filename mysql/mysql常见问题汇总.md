1. mysql 日志
binlog / redo log /undo log
 
* redo log 是 InnoDB 引擎特有的；binlog 是 MySQL 的 Server 层实现的，所有引擎都可以使用。
* redo log 是物理日志，记录的是“在某个数据页上做了什么修改”；binlog 是逻辑日志，记录的是这个语句的原始逻辑，比如“给 ID=2 这一行的 c 字段加 1 ”。
* redo log 是循环写的，空间固定会用完；binlog 是可以追加写入的。“追加写”是指 binlog 文件写到一定大小后会切换到下一个，并不会覆盖以前的日志。
* undo log 用户事务回滚日志，MVCC会使用undo log的版本链

2. mysql如何保证数据不丢失
https://time.geekbang.org/column/article/76161

3. 
