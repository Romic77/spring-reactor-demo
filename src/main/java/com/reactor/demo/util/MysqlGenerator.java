package com.reactor.demo.util;

import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.FileOutConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.TemplateConfig;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.lang3.StringUtils;

/**
 * @author liumeifang1052
 * @date 2021/10/26
 */
public class MysqlGenerator {
    /**
     * RUN THIS
     */
    public void generator(String packageName, String moduleName, String db, String... tables) {
        // 代码生成器
        AutoGenerator mpg = new AutoGenerator();

        // 全局配置
        GlobalConfig gc = new GlobalConfig();
        final String projectPath = System.getProperty("user.dir");

        gc.setOutputDir(projectPath + "/src/main/java/");
        gc.setAuthor("system");
        gc.setOpen(false);
        gc.setFileOverride(true);
        gc.setSwagger2(false);
        gc.setBaseColumnList(false);
        gc.setBaseResultMap(false);
        gc.setServiceName("%sService");
        mpg.setGlobalConfig(gc);

        // 数据源配置 saas_call_test
        DataSourceConfig dsc = new DataSourceConfig();
        dsc.setUrl("jdbc:mysql://10.4.5.139:3306/" + db
                + "?useUnicode=true&characterEncoding=UTF-8&serverTimezone=GMT%2B8&verifyServerCertificate=false&useSSL=false");
        // dsc.setSchemaName("public");
        dsc.setDriverName("com.mysql.cj.jdbc.Driver");
        dsc.setUsername("root");
        dsc.setPassword("uWXf87plmQGz8zMM");
        mpg.setDataSource(dsc);

        // 包配置
        final PackageConfig pc = new PackageConfig();
        if (!StringUtils.isEmpty(moduleName)) {
            pc.setModuleName(moduleName);
        }
        pc.setParent(packageName);
        pc.setEntity("domain.entity");
        mpg.setPackageInfo(pc);

        // 自定义配置
        InjectionConfig cfg = new InjectionConfig() {
            @Override
            public void initMap() {
                // to do nothing
            }
        };
        List<FileOutConfig> focList = new ArrayList<FileOutConfig>();
        focList.add(new FileOutConfig("/templates/mapper.xml.ftl") {
            @Override
            public String outputFile(TableInfo tableInfo) {
                // 自定义输入文件名称
                return projectPath + "/src/main/resources/mapper/" + pc.getModuleName() + "/"
                        + tableInfo.getEntityName() + "Mapper" + StringPool.DOT_XML;
            }
        });
        cfg.setFileOutConfigList(focList);
        mpg.setCfg(cfg);
        mpg.setTemplate(new TemplateConfig().setXml(null));

        // 策略配置
        StrategyConfig strategy = new StrategyConfig();
        strategy.setNaming(NamingStrategy.underline_to_camel);
        strategy.setColumnNaming(NamingStrategy.underline_to_camel);
        strategy.setSuperEntityClass("com.reactor.demo.base.BaseEntity");
        strategy.setSuperEntityColumns("create_time", "update_time");
        strategy.setEntityLombokModel(true);
        strategy.setSuperControllerClass("com.reactor.demo.base.BaseController");
        strategy.setInclude(tables);
        strategy.setControllerMappingHyphenStyle(true);
        strategy.setSuperServiceClass("com.reactor.demo.base.BaseService");
        strategy.setSuperServiceImplClass("com.reactor.demo.base.BaseServiceImpl");

        // strategy.setTablePrefix(pc.getModuleName() + "_");
        // strategy.setTablePrefix("sys_");
        strategy.setRestControllerStyle(true);
        // strategy.setEntityBooleanColumnRemoveIsPrefix(true);
        // strategy.setVersionFieldName("version");
        mpg.setStrategy(strategy);
        // 选择 freemarker 引擎需要指定如下加，注意 pom 依赖必须有！
        mpg.setTemplateEngine(new FreemarkerTemplateEngine());
        mpg.execute();
    }
}
