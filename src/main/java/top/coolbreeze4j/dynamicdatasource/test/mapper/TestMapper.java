package top.coolbreeze4j.dynamicdatasource.test.mapper;

import top.coolbreeze4j.dynamicdatasource.annotation.DataSource;
import top.coolbreeze4j.dynamicdatasource.enums.DataSourceType;
import top.coolbreeze4j.dynamicdatasource.test.domain.Test;

import java.util.List;
import java.util.Map;

/**
 * @author CoolBreeze
 * @date 2022/6/20 14:31.
 */
public interface TestMapper {
    /**
     * 主库查询数据
     */
    @DataSource(DataSourceType.MASTER)
    List<Test> selectByMasterDataSource();

    /**
     * 从库查询数据
     */
    @DataSource(DataSourceType.SLAVE)
    List<Test> selectBySlaveDataSource();

    /**
     * 主库数据插入
     */
    @DataSource(DataSourceType.MASTER)
    int insert2MasterDataSource(Test test);

    /**
     * 从库数据插入
     */
    @DataSource(DataSourceType.SLAVE)
    int insert2SlaveDataSource(Test test);

}
