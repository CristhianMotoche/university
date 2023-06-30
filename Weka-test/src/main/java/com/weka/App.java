/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.weka;

import java.io.BufferedReader;
import java.io.FileReader;
import weka.classifiers.bayes.NaiveBayes;
import weka.core.Instance;
import weka.core.Instances;

/**
 *
 * @author camm
 */
public class App {
	public static void main(String[] args){
		try {
			BufferedReader brTrain = new BufferedReader(new FileReader("src/main/java/com/weka/supermarket.arff"));
			BufferedReader brTest = new BufferedReader(new FileReader("src/main/java/com/weka/test.arff"));

			Instances trainInstancias = new Instances(brTrain);
			Instances testInstance = new Instances(brTest);

			trainInstancias.setClassIndex(trainInstancias.numAttributes() - 1);
			testInstance.setClassIndex(testInstance.numAttributes() - 1);

			brTest.close();
			brTrain.close();

			for (int i = 0; i < trainInstancias.numClasses(); i++) {
				String classValue = trainInstancias.classAttribute().value(i);
				System.out.println("Class value " + i + " es " + classValue);
			}

			NaiveBayes nb = new NaiveBayes();
			nb.buildClassifier(trainInstancias);

			System.out.println("=== Resultados ===");
			System.out.println("Actual | Prediction");
			for (int i = 0; i < testInstance.numInstances(); i++) {
				double actualClass = testInstance.instance(i).classValue();
				String actual = testInstance.classAttribute().value((int) actualClass);
				Instance newInstance = testInstance.instance(i);
				double predNB = nb.classifyInstance(newInstance);
				String prediction = testInstance.classAttribute().value((int) predNB);
				System.out.println(actual + " | " + prediction);
			}
		} catch (Exception ex) {
			System.err.println(ex);
			System.exit(1);
		}
	}
}
