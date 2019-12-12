package com.test.springmvctest.controller;

import com.test.springmvctest.entity.Student;
import com.test.springmvctest.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Writer;
import java.util.Arrays;
import java.util.Date;
import java.util.Map;

@Controller
@SessionAttributes(value={"user"},types = {String.class})
public class MyController {

    private static final String SUCCESS="success";

    /**
     * 1. 有 @ModelAttribute 标记的方法, 会在每个目标方法执行之前被 SpringMVC 调用!
     * 2. @ModelAttribute 注解也可以来修饰目标方法 POJO 类型的入参, 其 value 属性值有如下的作用:
     * 1). SpringMVC 会使用 value 属性值在 implicitModel 中查找对应的对象, 若存在则会直接传入到目标方法的入参中.
     * 2). SpringMVC 会一 value 为 key, POJO 类型的对象为 value, 存入到 request 中.
     */
    @ModelAttribute
    public void getStudent(@RequestParam("id") Integer id,
                           Map<String,Object> map){
        System.out.println("this is ModelAttribute");
        if(id!=null){
            //模拟从数据库中获取对象
            Student student=new Student(1,"January","1234",18);
            System.out.println("从数据库中获取一个对象: " + student);
            map.put("student",student);
        }
    }

    @RequestMapping("/testModelAttribute")
    public String testModelAttribute(Student student){
        System.out.println("修改: "+student);
        return SUCCESS;
    }

    /**
     * @SessionAttributes 除了可以通过属性名指定需要放到会话中的属性外(实际上使用的是 value 属性值),
     * 还可以通过模型属性的对象类型指定哪些模型属性需要放到会话中(实际上使用的是 types 属性值)
     *
     * 注意: 该注解只能放在类的上面. 而不能修饰放方法.
     */
    @RequestMapping("/testSessionAttributes")
    public String testSessionAttributes(Map<String,Object> map){
        User user=new User("Jan.","123","男",11,"12345");
        map.put("user", user);
        map.put("country","china");
        return SUCCESS;
    }

    /**
     * 目标方法可以添加 Map 类型(实际上也可以是 Model 类型或 ModelMap 类型)的参数.
     * @param map
     * @return
     */
    @RequestMapping("/testMap")
    public String testMap(Map<String,Object> map){
        map.put("names", Arrays.asList("Jan.","Feb","Mar"));
        return SUCCESS;
    }

    /**
     * 目标方法的返回值可以是 ModelAndView 类型。
     * 其中可以包含视图和模型信息
     * SpringMVC 会把 ModelAndView 的 model 中数据放入到 request 域对象中.
     * @return
     */
    @RequestMapping("/testModelAndView")
    public ModelAndView testModelAndView(){
        String viewName= SUCCESS;
        ModelAndView modelAndView=new ModelAndView(viewName);
        //添加模型数据到 ModelAndView 中
        modelAndView.addObject("time",new Date());
        return modelAndView;
    }

    /**
     * 可以使用 Serlvet 原生的 API 作为目标方法的参数 具体支持以下类型
     *
     * HttpServletRequest
     * HttpServletResponse
     * HttpSession
     * java.security.Principal
     * Locale InputStream
     * OutputStream
     * Reader
     * Writer
     * @throws IOException
     */
    @RequestMapping("/testServletAPI")
    public void testServletAPI(HttpServletRequest request,
                               HttpServletResponse response, Writer out) throws IOException {
        System.out.println("testServletAPI, " + request + ", " + response);
        out.write("hello springmvc");
//		return SUCCESS;
    }

    /**
     * Spring MVC 会按请求参数名和 POJO 属性名进行自动匹配， 自动为该对象填充属性值。支持级联属性。
     * 如：dept.deptId、dept.address.tel 等
     */
    @RequestMapping("/testPojo")
    public String testPojo(User user) {
        System.out.println("testPojo: " + user);
        return SUCCESS;
    }

    /**
     * 了解:
     *
     * @CookieValue: 映射一个 Cookie 值. 属性同 @RequestParam
     */
    @RequestMapping("/testCookieValue")
    public String testCookieValue(@CookieValue("JSESSIONID") String sessionId) {
        System.out.println("testCookieValue: sessionId: " + sessionId);
        return SUCCESS;
    }

    /**
     * 了解
     * 映射请求头信息
     * 用法同@RequestParam
     */
    @RequestMapping("/testRequestHeader")
    public String testRequestHeader(@RequestHeader(value = "Accept") String al){
        System.out.println("testRequestHeader: "+al);
        return SUCCESS;
    }

    /**
     * Rest 风格的 URL. 以 CRUD 为例:
     * 新增: /order POST
     * 修改: /order/1 PUT             update?id=1
     * 获取:/order/1 GET              get?id=1
     * 删除: /order/1 DELETE          delete?id=1
     *
     * 如何发送 PUT 请求和 DELETE 请求呢 ?
     * 1. 需要配置 HiddenHttpMethodFilter
     * 2. 需要发送 POST 请求
     * 3. 需要在发送 POST 请求时携带一个 name="_method" 的隐藏域, 值为 DELETE 或 PUT
     *
     * 在 SpringMVC 的目标方法中如何得到 id 呢? 使用 @PathVariable 注解
     *
     */
    @RequestMapping(value = "/testDelete/{id}",method = RequestMethod.DELETE)
    public String testDelete(@PathVariable("id") Integer id){
        System.out.println("testDelete: "+id);
        return SUCCESS;
    }

    @RequestMapping(value = "/testPut/{id}",method = RequestMethod.PUT)
    public String testPut(@PathVariable("id") Integer id){
        System.out.println("testPut: "+id);
        return SUCCESS;
    }

    @RequestMapping(value = "/testPost",method = RequestMethod.POST)
    public String testPost(){
        System.out.println("testPost");
        return SUCCESS;
    }

    @RequestMapping(value = "/testGet/{id}",method = RequestMethod.GET)
    public String testGet(@PathVariable("id") Integer id){
        System.out.println("testGet: "+id);
        return SUCCESS;
    }

    /**
     * 可以映射URL中的占位符到目标方法的参数中
     * @param id
     * @return
     */
    @RequestMapping("/testPathVariable/{id}")
    public String testPathVariable(@PathVariable("id") Integer id){
        System.out.println("testPathVariable: "+id);
        return SUCCESS;
    }

//    params，headers支持简单的表达式来更加精确映射请求
    @RequestMapping(value = "/testParamHeads",method = RequestMethod.GET,
            params = {"use","pwd!=123"},headers = {"Connection=keep-alive"})
    public String testParamHeads(){
        System.out.println("this is testParamHeads");
        return SUCCESS;
    }

//    指定为post请求方式时，页面也需要指定post方式请求
    @RequestMapping(value = "/testMethod",method = RequestMethod.POST)
    public String testMethod(){
        System.out.println("this is testMethod");
        return SUCCESS;
    }

    @RequestMapping("/helloworld")
    public String HelloController(){
        System.out.println("hello world");
//        经过视图解析器的prefix前缀+返回值+suffix后缀转发到形视图，/WEB-INF/view/+success+.jsp
        return SUCCESS;
    }
}
