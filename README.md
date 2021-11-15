## 抽奖系统

### 使用到的技术

Spring Boot 、MyBatis、Dubbo、ELK、Redis、定时任务、Kafka 



### DDD 领域驱动设计

* **lottery-infrastructure** ：基础层，提供基础的功能服务，包括：数据库、Redis、ES
* **lottery-domain** ：领域层，封装具体的领域功能实现，它们是聚合的、充血的
* **lottery-application** ：应用层，逻辑包装，编排，任务、领域事件的发布和订阅（MQ）
* **lottery-interfaces** ：接口层，实现 RPC 接口定义，引入应用层（*application*）服务，封装具体的接口
* **lottery-common** ：通用包，定义通用返回对象、常量、枚举、异常
* **lottery-rpc** ：描述 RPC 接口文件，用于打包后外部引入 pom 配置





