#Distributed ID Service

## 1. UUID

## 6. SnowFlake 雪花算法
Long类型ID (8 Byte)= 
符号位(1 bit) + 时间戳(41 bit) +( 机器ID(5 bit) + 数据中心(5 bit)) + 自增值(12 bit)
- 符号位: 一般ID为正数,默认为0
- 时间戳(41 bit): 毫秒级.使用 (当前时间戳 - 固定时间戳)差值 固定时间戳设置成项目开始时间,转化成时间戳后最长可以支持69年(41 bit 全1)
- 机器ID + 数据中心 (5 + 5 bit) : workID ,灵活配置,机房或者机器组合
- 序列号部分(12 bit): 自增值支持同一毫秒同一节点生成2^12 = 4096个ID

[雪花算法](../Distributed-ID-Services/src/SnowFlake.java)
