package cn.liyu;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngineConfiguration;
import org.junit.Test;

/**
 * @author liyu
 * @date 2020/5/27 10:16
 * @description 测试activiti所需要的25张表的生成
 */
public class ActivitiTest {
    @Test
    public void testGenTable(){
        //1.创建ProcessEngineConfiguration对象
        ProcessEngineConfiguration processEngineConfigurationFromResource =
                ProcessEngineConfiguration.createProcessEngineConfigurationFromResource("activiti.cfg.xml");
        //2.创建ProcessEngine对象
        ProcessEngine processEngine = processEngineConfigurationFromResource.buildProcessEngine();
        //3.输出对象
        System.out.println("processEngine = " + processEngine);
    }
}
