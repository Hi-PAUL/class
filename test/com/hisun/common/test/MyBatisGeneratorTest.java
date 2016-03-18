package com.hisun.common.test;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.exception.InvalidConfigurationException;
import org.mybatis.generator.exception.XMLParserException;
import org.mybatis.generator.internal.DefaultShellCallback;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

/**
 * 
 * @类名： GeneratorSqlMapTest.java
 * 
 * @描述：自动生成Mapper配置文件的单元测试类 @作者： yan_js @修改日期： 2015年11月27日
 */
@Transactional
public class MyBatisGeneratorTest extends AbstractJUnitTest
{
	
    @Before
    public void init()
    {
        System.out.println("开始生成配置文件!!!");
    }


    @Test
    @Rollback(false)
    public void testGeneratorSqlMap()
    {
        List<String> warnings = new ArrayList<String>();
        boolean overwrite = true;
        String projectPath=System.getProperty("user.dir");
        String myBatisConfigPath=projectPath+"/src/config/mybatis-Generator.xml";
        System.out.println(myBatisConfigPath);
        File configFile = new File(myBatisConfigPath);
        ConfigurationParser cp = new ConfigurationParser(warnings);
        Configuration config = null;
        try
        {
            config = cp.parseConfiguration(configFile);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        catch (XMLParserException e)
        {
            e.printStackTrace();
        }
        DefaultShellCallback callback = new DefaultShellCallback(overwrite);
        MyBatisGenerator myBatisGenerator = null;
        try
        {
            myBatisGenerator = new MyBatisGenerator(config, callback, warnings);
        }
        catch (InvalidConfigurationException e)
        {
            e.printStackTrace();
        }
        try
        {
            myBatisGenerator.generate(null);
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }
    }


    @After
    public void destory()
    {
        System.out.println("配置文件生成完成!!!");
    }

}
