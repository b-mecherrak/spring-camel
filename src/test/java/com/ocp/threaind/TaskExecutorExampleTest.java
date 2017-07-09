package com.ocp.threaind;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ocp.threading.TaskExecutorExample;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:hibernate-beans.xml", "classpath:spring-beans.xml" })
public class TaskExecutorExampleTest {
	
	@Autowired
	
	TaskExecutorExample taskExecutorExample ; 
	
	
	@Test 
	public void  test1 () {
		
		taskExecutorExample.printMessages();		
	}

}
