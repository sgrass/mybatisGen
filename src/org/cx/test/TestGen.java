package org.cx.test;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.internal.DefaultShellCallback;

public class TestGen {

	public static void main(String[] args) throws Exception {
		List<String> warnings = new ArrayList<String>();

		File configFile = new File(TestGen.class.getClassLoader().getResource("generatorConfig.xml").getFile());

		Configuration config = new ConfigurationParser(warnings).parseConfiguration(configFile);

		DefaultShellCallback callback = new DefaultShellCallback(true);

		MyBatisGenerator myBatisGenerator = new MyBatisGenerator(config, callback, warnings);
		
		myBatisGenerator.generate(null);  
	}

}
