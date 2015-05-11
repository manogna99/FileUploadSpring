package com.ccs.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SingletonPrototypeInjection {

	
	public static  void print(){
		
		
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		SingletonPrototypeInjection.print();
		
		ApplicationContext context = 
		    	 new ClassPathXmlApplicationContext(new String[] {"singletonPrototypeInjection.xml"});
		
		StudentSingleton custA = (StudentSingleton)context.getBean("student");
		    	custA.setMessage("Message by custA");
		    	
		    	custA.getAddress().setMessage("This is address");
		    	
		    	System.out.println("Message : " + custA.getMessage());
		 	    System.out.println(custA.getAddress().getMessage());
		    	
		    	//retrieve it again
		    	StudentSingleton custB = (StudentSingleton)context.getBean("student");
		    	custB.getAddress().setMessage("This is address 222");
		    	System.out.println("Message : " + custB.getMessage());
		    	System.out.println(custB.getAddress().getMessage());
		    	System.out.println(custA.getAddress().getMessage());
	}

}
