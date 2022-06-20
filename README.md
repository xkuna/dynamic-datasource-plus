# springboot实现动态数据源+atomikos多事务管理

> tips:将若依中动态数据源+atomikos多事务管理的代码单独拿了出来,方便以后使用
### 若依官网:[http://ruoyi.vip/](http://ruoyi.vip/)

- service方法内 调用多个声明@DataSource注解的本类方式时,查看 [手动切换数据源](https://doc.ruoyi.vip/ruoyi/document/htsc.html#%E6%89%8B%E5%8A%A8%E5%88%87%E6%8D%A2%E6%95%B0%E6%8D%AE%E6%BA%90) 下面的**提示**