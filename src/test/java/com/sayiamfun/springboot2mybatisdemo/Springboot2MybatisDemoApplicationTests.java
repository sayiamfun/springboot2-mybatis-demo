package com.sayiamfun.springboot2mybatisdemo;


import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.github.pagehelper.PageInfo;
import com.sayiamfun.springboot2mybatisdemo.common.requestentity.QueryAccount;
import com.sayiamfun.springboot2mybatisdemo.common.requestentity.QueryTeacher;
import com.sayiamfun.springboot2mybatisdemo.entity.TTeacher;
import com.sayiamfun.springboot2mybatisdemo.entity.TbAccount;
import com.sayiamfun.springboot2mybatisdemo.service.TTeacherService;
import com.sayiamfun.springboot2mybatisdemo.service.TbAccountService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest
public class Springboot2MybatisDemoApplicationTests {


    final static String  dirPath = "F://";

    @Autowired
    private TbAccountService tbAccountService;
    @Autowired
    private TTeacherService tTeacherService;

    @Test
    public void tbAccountTest(){
        PageInfo<TbAccount> allUser = tbAccountService.findAllAccount(1, 2, new QueryAccount());
        System.out.println(allUser.toString());
    }

    @Test
    public void addAccountTest(){
        TbAccount tbAccount = new TbAccount();
        tbAccount.setName("test");
        tbAccount.setBalance(200F);
        tbAccount.setDeleted(0);
        tbAccountService.addAccount(tbAccount);
    }

    @Test
    public void tTeacherTest(){
        PageInfo<TTeacher> allUser = tTeacherService.findAllUser(1, 2, new QueryTeacher());
        System.out.println(allUser.toString());
    }


    @Test
    public void test() {

        AutoGenerator mpg = new AutoGenerator();

        // 全局配置
        GlobalConfig gc = new GlobalConfig();
        gc.setOutputDir("F://");//输出文件路径
        gc.setFileOverride(true);
        gc.setActiveRecord(false);// 不需要ActiveRecord特性的请改为false
        gc.setEnableCache(false);// XML 二级缓存
        gc.setBaseResultMap(true);// XML ResultMap
        gc.setBaseColumnList(false);// XML columList
        gc.setAuthor("sayiamfun");// 作者

        // 自定义文件命名，注意 %s 会自动填充表实体属性！
        gc.setControllerName("%sController");
        gc.setServiceName("%sService");
        gc.setServiceImplName("%sServiceImpl");
        gc.setMapperName("%sMapper");
        gc.setXmlName("%sMapper");
        mpg.setGlobalConfig(gc);

        // 数据源配置
        DataSourceConfig dsc = new DataSourceConfig();
        dsc.setDbType(DbType.MYSQL);
        dsc.setDriverName("com.mysql.cj.jdbc.Driver");
        dsc.setUsername("root");
        dsc.setPassword("jiazhangjia217");
        dsc.setUrl("jdbc:mysql://127.0.0.1:3306/mytestcopy?useUnicode=true&characterEncoding=UTF-8&allowMultiQueries=true&autoReconnect=true&serverTimezone=UTC&useSSL=false");
        mpg.setDataSource(dsc);

        // 策略配置
        StrategyConfig strategy = new StrategyConfig();
        // strategy.setTablePrefix(new String[] { "sys_" });// 此处可以修改为您的表前缀
        strategy.setNaming(NamingStrategy.underline_to_camel);// 表名生成策略
        strategy.setInclude(new String[] { "tb_account" }); // 需要生成的表

        strategy.setSuperServiceClass(null);
        strategy.setSuperServiceImplClass(null);
        strategy.setSuperMapperClass(null);

        mpg.setStrategy(strategy);

        // 包配置
        PackageConfig pc = new PackageConfig();
        pc.setParent("com.sayiamfun.springboot2mybatisdemo");
        pc.setController("controller");
        pc.setService("service");
        pc.setServiceImpl("service.impl");
        pc.setMapper("mapper.mytestcopy");
        pc.setEntity("entity");
        pc.setXml("xml");
        mpg.setPackageInfo(pc);

        // 执行生成
        mpg.execute();
    }

}
