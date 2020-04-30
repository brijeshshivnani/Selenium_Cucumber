package stepDefinitions;

import cucumber.api.java.After;
import cucumber.api.java.Before;
 
public class Hooks {
 
 @After
    public void afterScenario(){
        System.out.println("This will run after every Scenario");
    } 
 @Before
    public void beforeScenario(){
        System.out.println("This will run before every Scenario");
    } 
 
 @Before("@Second")
    public void beforeSecond(){
        System.out.println("This will run only before the Second Scenario");
    } 
 @Before("@First,@Third")
    public void beforeFirstAndThird(){
        System.out.println("This will run before both First & Third Scenario");
    }
 @Before("@First,")
 public void beforeFirst(){
     System.out.println("This will run only before First $$ Scenario");
 }
 
 @After("@First")
    public void afterFirst(){
        System.out.println("This will run only after the First Scenario");   
    } 
 @After("@Second")
    public void afterSecond(){
        System.out.println("This will run only after the Second Scenario");   
    } 
 @After("@Third")
    public void afterThird(){
        System.out.println("This will run only after the Third Scenario");   
    } 
 
}