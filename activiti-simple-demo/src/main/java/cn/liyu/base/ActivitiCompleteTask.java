package cn.liyu.base;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.TaskService;
import org.activiti.engine.task.Task;

import java.util.List;

/**
 * 处理当前用户的任务
 * 背后操作的表：
 * act_hi_actinst
 * act_hi_identitylink
 * act_hi_taskinst
 * act_ru_identitylink
 * act_ru_task
 *
 * @author lenovo
 */
public class ActivitiCompleteTask {

    /**
     * 查询当前用户wangwu的任务并处理掉
     *
     * @param args
     */
    public static void main(String[] args) {
        //1.得到ProcessEngine对象
        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();

        //2.得到TaskService对象
        TaskService taskService = processEngine.getTaskService();

        //3.查询当前用户的任务
        Task task = taskService.createTaskQuery()
                .processDefinitionKey("holiday")
                .taskAssignee("王五")
                .singleResult();

        //4.处理任务,结合当前用户任务列表的查询操作的话,任务ID:task.getId()
        taskService.complete(task.getId());

        //5.输出任务的id
        System.out.println(task.getId());
    }


    //lishi完成自己的任务
//    public static void main(String[] args) {
//        //1.得到ProcessEngine对象
//        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
//
//        //2.得到TaskService对象
//        TaskService taskService = processEngine.getTaskService();
//        List<Task> list = taskService.createTaskQuery()
//                .taskAssignee("李四")
//                .processDefinitionKey("holiday")
//                .list();
//        for (Task task : list) {
//            //3.处理任务,结合当前用户任务列表的查询操作的话,任务ID:5002
//            taskService.complete(task.getId());
//            System.out.println("task.getId() = " + task.getId());
//        }
//
//
//    }


    //zhangsan完成自己的任务
//    public static void main(String[] args) {
//        //1.得到ProcessEngine对象
//        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
//
//        //2.得到TaskService对象
//        TaskService taskService = processEngine.getTaskService();
//
//        //3.处理任务,结合当前用户任务列表的查询操作的话,任务ID:5005
//        taskService.complete("5005");
//
//
//    }
}
