package com.davin;

// import com.davin.xml.SimpleXMLResolver;


import com.davin.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) throws Exception {
//        SimpleXMLResolver.objectToXml();
//        SimpleXMLResolver.XMLtoObject();
        ApplicationContext context = new ClassPathXmlApplicationContext("com/davin/applicationContext.xml");
        UserService userService = (UserService) context.getBean("userService");
        userService.getUserById("abc");
        userService.getUserById("abc");
        userService.getUserById("abc");
        userService.getUserById("abc");
    }
}
