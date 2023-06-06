package com.progress.telerik.core;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


/*
		This the custom annotation. It'll help defining the test case description.
		@Target() tells us where we can use the this annotation
		ElementType.TYPE means usage for the classes
		@Retention(RetentionPolicy.RUNTIME) tells java to keep this annotation around 
		through the actual running of the program and other code can actually look at 
		the annotation and use it while the program is running 		
 */


@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD, ElementType.TYPE})
public @interface TestCaseSummary {
	String value();
}
