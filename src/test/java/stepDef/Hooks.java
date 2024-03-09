package stepDef;

import io.cucumber.java.*;

import java.util.Objects;

import static helper.Utility.quitDriver;
import static helper.Utility.startDriver;

public class Hooks {

    String tagsRunning = null;

    @BeforeAll
    public static void setUp(){
        System.out.println("Before All");
    }
    @AfterAll
    public static void tearDown(){
        System.out.println("After All");
    }

//  API HOOK
//    @Before
//    public void beforeTestApi(){//
//    }
//    @After
//    public void afterTestApi(){//
//    }

//  WEB HOOKS
    @Before
    public void beforeTest(Scenario scenario){
        String[] tags = scenario.getSourceTagNames().toArray(new String[0]);
        tagsRunning = tags[0];
        if (Objects.equals(tagsRunning, "@web")){
            startDriver();
        }
    }
    @After
    public void afterTest(Scenario scenario) throws InterruptedException{
        if (Objects.equals(tagsRunning, "@web")){
            Thread.sleep(4000);
            quitDriver();
        }
    }

}
