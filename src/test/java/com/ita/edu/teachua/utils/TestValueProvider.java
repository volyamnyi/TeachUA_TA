package com.ita.edu.teachua.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.Map;

public class TestValueProvider {
    Properties properties;

    public TestValueProvider(){
        try {
            FileInputStream fileInputStream = new FileInputStream("src/test/resources/data.properties");
            properties = new Properties();
            properties.load(fileInputStream);
        } catch (IOException e) {
            System.out.println(e.getMessage());
            System.out.println("Use systen env");
        }
    }

    public String getBaseUrl() {
        return  properties != null ? properties.getProperty("baseURL") : System.getenv("BASE_URL");
    }

    public String getAdminPassword() {
         return  properties != null ? properties.getProperty("adminPassword") : System.getenv("ADMIN_PASSWORD");
        
    }
    public String getAdminEmail() {
        return  properties != null ? properties.getProperty("adminEmail") : System.getenv("ADMIN_EMAIL");

    }

    public String getTestTeachUaMetaEmail() {
        return  properties != null ? properties.getProperty("TestTeachUaMetaEmail") : System.getenv("TEST_TEACH_UA_META_EMAIL");
    }
    public String getTestTeachUaMetaPassword() {
        return  properties != null ? properties.getProperty("TestTeachUaMetaPassword") : System.getenv("TEST_TEACH_UA_META_PASSWORD");
    }
    public boolean getHeadlessMode() {
        return  properties != null ?
                Boolean.parseBoolean(properties.getProperty("HeadlessMode")) :
                Boolean.parseBoolean(System.getenv("TEST_TEACH_UA_HEADLESS_MODE"));
    }

}
//