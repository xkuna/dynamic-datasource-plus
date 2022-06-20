package top.coolbreeze4j.dynamicdatasource.test.service.impl;

import cn.hutool.core.util.IdUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import top.coolbreeze4j.dynamicdatasource.annotation.DataSource;
import top.coolbreeze4j.dynamicdatasource.enums.DataSourceType;
import top.coolbreeze4j.dynamicdatasource.test.domain.Test;
import top.coolbreeze4j.dynamicdatasource.test.mapper.TestMapper;
import top.coolbreeze4j.dynamicdatasource.test.service.TestService;
import top.coolbreeze4j.dynamicdatasource.utils.SpringUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author CoolBreeze
 * @date 2022/6/20 14:32.
 */
@Service
@Slf4j
public class TestServiceImpl implements TestService {
    @Autowired
    TestMapper testMapper;

    /**
     * 主库 从库查询测试
     * tip: 在主库test和 从库 test2中都建了一张test表
     */
    @Override
    public void testDynamicDataSourceSelect() {
        log.info("开始查询主库数据");
        List<Test> list = testMapper.selectByMasterDataSource();
        log.info("查询到主库数据共【{}】条, 内容如下:\n{}", list.size(), list);

        log.info("开始查询从库数据");
        List<Test> list2 = testMapper.selectBySlaveDataSource();
        log.info("查询到从库数据共【{}】条, 内容如下:\n{}", list2.size(), list2);
    }

    /**
     * 主库 从库数据插入测试
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public void testDynamicDataSourceInsert() {
        Test test = new Test();
        test.setId(IdUtil.fastSimpleUUID());
        test.setName("测试插入");

        log.info("开始插入主库数据");
        testMapper.insert2MasterDataSource(test);
        log.info("主库成功插入数据");

        log.info("开始插入从库数据");
        testMapper.insert2SlaveDataSource(test);
        log.info("从库成功插入数据");
    }

    /**
     * 主库 从库多数据源事务测试
     */
    @Transactional
    @Override
    public void testDynamicDataSourceTransactional() {
        Test test = new Test();
        test.setId(IdUtil.fastSimpleUUID());
        test.setName("测试插入2");

        log.info("开始插入主库数据");
        testMapper.insert2MasterDataSource(test);
        log.info("主库成功插入数据");

        //异常
        int num = 1/0;

        log.info("开始查询从库数据");
        testMapper.insert2SlaveDataSource(test);
        log.info("从库成功插入数据");
    }
}
