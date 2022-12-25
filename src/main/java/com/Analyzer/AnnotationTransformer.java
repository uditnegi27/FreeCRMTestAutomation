package com.Analyzer;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import org.testng.IAnnotationTransformer;
import org.testng.annotations.ITestAnnotation;

public class AnnotationTransformer implements IAnnotationTransformer{
	
	public void transform(ITestAnnotation testAnnotation, Class testClass, Constructor constructor, Method testMethod) {
		
		testAnnotation.setRetryAnalyzer(RetryAnalyzer.class);
	}

}
