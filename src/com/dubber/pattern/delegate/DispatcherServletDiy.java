package com.dubber.pattern.delegate;

import com.dubber.pattern.delegate.controller.SystemAction;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by dubber on 2018/5/5.
 */
public class DispatcherServletDiy {


    private List<Handler> handlerMapping = new ArrayList<>();

    public DispatcherServletDiy() {

        try {
            Class<SystemAction> clazz = SystemAction.class;
            Handler handler = new Handler();
            handler.setController(clazz.newInstance());
            handler.setMethod(clazz.getMethod("loginIn"));
            handler.setUrl("/loginIn.htm");
            handlerMapping.add(handler);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }


    public void doService(HttpServletRequest request, HttpServletResponse response) {
        doDispatcher(request, response);
    }

    public void doDispatcher(HttpServletRequest request, HttpServletResponse response) {

        // 1、获得用户请求的url
        // 如果按照J2EE的标准，每个URl对应一个Servlet，url由浏览器输入

        String uri = request.getRequestURI();
        //2、servlet 拿到 url 之后，要权衡（要做判断，要做选择）
        // 根据用户的请求的 url ，去先找到 url 对应的每一个java类的方法。
        // 3、通过url 去 HandlerMapping 查找 （我们把这认为是策略常量）
        Handler handler = null;
        for(Handler h:handlerMapping){
            if(uri.equals(h.getUrl())){
                handler = h;
            }
        }
        // 4、 将具体的任务分发给 Method(通过反射去调用其对应的方法),

        Object object = null;
        try {
            object = handler.getMethod().invoke(handler.getController(),request.getParameter("mid"));
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

        // 5、 获取到Method 执行的结果，通过 Response 返回。

        //response.getWriter().write();

    }


    class Handler {
        private Object controller;
        private Method method;
        private String url;

        public Object getController() {
            return controller;
        }

        public void setController(Object controller) {
            this.controller = controller;
        }

        public Method getMethod() {
            return method;
        }

        public void setMethod(Method method) {
            this.method = method;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }
    }
}
