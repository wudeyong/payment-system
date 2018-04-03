package com.davin.xml;

import com.davin.domain.User;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import java.io.FileInputStream;
import java.io.FileOutputStream;

public class SimpleXMLResolver {

    private static XStream xStream;
    static {
        xStream = new XStream(new DomDriver());
        xStream.alias("user",User.class);
    }

    public static User getUser(){
        User user = new User();
        user.setAge(10);
        user.setUserId("1001");
        user.setUserName("davin.Wu");
        return user;
    }

    public static void XMLtoObject() throws Exception{
        Resource resource = new ClassPathResource("com/davin/simple-xml-example.xml");
        FileInputStream in = new FileInputStream(resource.getFile());
        User user = (User)xStream.fromXML(in);
        System.out.println(user.getUserName());
    }

    public static void objectToXml() throws Exception{
        User user = getUser();
        Resource resource = new ClassPathResource("com/davin/simple-xml-example-out.xml");
        FileOutputStream fOut = new FileOutputStream(resource.getFile());
        xStream.toXML(user,fOut);
    }
}
