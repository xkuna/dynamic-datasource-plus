package top.coolbreeze4j.dynamicdatasource.test;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import top.coolbreeze4j.dynamicdatasource.test.service.TestService;
import top.coolbreeze4j.dynamicdatasource.utils.SpringUtils;

/**
 * @author CoolBreeze
 * @date 2022/6/20 14:56.
 */
@SpringBootTest
public class DynamicDataSourceTest {
    @Autowired
    TestService testService;

    /**
     * 测试动态数据源 查询
     */
    @Test
    public void testDynamicDataSourceSelect(){
        testService.testDynamicDataSourceSelect();
    }

    /**
     * 测试动态数据源 插入
     */
    @Test
    public void testDynamicDataSourceInsert(){
        testService.testDynamicDataSourceInsert();
    }

    /**
     * 测试动态数据源 事务回滚
     */
    @Test
    public void testDynamicDataSourceTransactional(){
        testService.testDynamicDataSourceTransactional();
    }
}
