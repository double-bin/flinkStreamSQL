
CREATE TABLE MyTable(
    message varchar,
    offset bigint
 )WITH(
    type ='kafka',
    bootstrapServers ='ckafka1:9092,ckafka2:9092,ckafka3:9092',
    zookeeperQuorum ='ckafka1:2181,ckafka2:2181,ckafka3:2181',
    offsetReset ='latest',
    topic ='appLogTest',
    parallelism ='1'
 );

CREATE TABLE MyResult(
    message varchar,
    offset bigint
 )WITH(
    type ='mysql',
    url ='jdbc:mysql://10.202.234.244:3308/flinktest?charset=utf8',
    userName ='root',
    password ='12345678',
    tableName ='logtest',
    parallelism ='1'
 );


insert
into
    MyResult
    select
        message,
        `offset`
    from
        MyTable