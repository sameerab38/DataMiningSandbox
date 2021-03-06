package classifier.KNN;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.junit.Before;
import org.junit.Test;

public class KNNTest {

	/**
	 * Things for the KNN
	 */
	private List<KNNInstance> trainingSet;
	private KNNInstance instanceTest;
	
	/**
	 * Unit test preperation
	 */
	@Before
	public void unitTest_Prep() {
		
		KNNInstance instance1 = new KNNInstance();
		instance1.add(3.0);
		instance1.add(2.5);
		instance1.add(2.7);
		instance1.setRef(new String("instance1"));
		
		KNNInstance instance2 = new KNNInstance();
		instance2.add(15.0);
		instance2.add(17.2);
		instance2.add(12.0);
		instance2.setRef(new String("instance2"));
		
		KNNInstance instance3 = new KNNInstance();
		instance3.add(50.5);
		instance3.add(55.1);
		instance3.add(49.1);
		instance3.setRef(new String("instance3"));
		
		trainingSet = new ArrayList<KNNInstance>();
		trainingSet.add(instance1);
		trainingSet.add(instance2);
		trainingSet.add(instance3);
		
		instanceTest = new KNNInstance();
		instanceTest.add(15.0);
		instanceTest.add(17.2);
		instanceTest.add(12.0);
		instanceTest.setRef(new String("instanceTest"));
	}
	
	
	/**
	 * Unit test to make sure it works YO
	 */
	@Test
	public void unitTest_1() {
		
		// init KNN with Euclidean Space
		KNNDist dist = new KNNDistEuclidean();
		KNN knn = new KNN(dist,1);
		knn.train(trainingSet);
		
		// find nearest neighbor
		List<KNNInstance> nearestNeighbors = knn.findKNN(instanceTest);
		
		// Make sure we good
		assertEquals(1, nearestNeighbors.size());
		assertEquals("instance2",(String) nearestNeighbors.get(0).getRef());
	}
	
	/**
	 * Unit test to make sure it works YO
	 */
	@Test
	public void unitTest_2() {
		
		// init KNN with Euclidean Space
		KNNDist dist = new KNNDistEuclidean();
		KNN knn = new KNN(dist,2);
		knn.train(trainingSet);
		
		// find nearest neighbor
		List<KNNInstance> nearestNeighbors = knn.findKNN(instanceTest);
		
		// Make sure we good
		assertEquals(2, nearestNeighbors.size());
		assertEquals("instance2",(String) nearestNeighbors.get(0).getRef());
		assertEquals("instance1",(String) nearestNeighbors.get(1).getRef());
	}
	
	/**
	 * Unit test to make sure it works YO
	 */
	@Test
	public void unitTest_3() {
		
		// init KNN with Euclidean Space
		KNNDist dist = new KNNDistEuclidean();
		KNN knn = new KNN(dist,3);
		knn.train(trainingSet);
		
		// find nearest neighbor
		List<KNNInstance> nearestNeighbors = knn.findKNN(instanceTest);
		
		// Make sure we good
		assertEquals(3, nearestNeighbors.size());
		assertEquals("instance2",(String) nearestNeighbors.get(0).getRef());
		assertEquals("instance1",(String) nearestNeighbors.get(1).getRef());
		assertEquals("instance3",(String) nearestNeighbors.get(2).getRef());
	}
	
	/**
	 * Unit test to make sure it works YO
	 */
	@Test
	public void unitTest_4() {
		
		// init KNN with Euclidean Space
		KNNDist dist = new KNNDistEuclidean();
		KNN knn = new KNN(dist,40000);
		knn.train(trainingSet);
		
		// find nearest neighbor
		List<KNNInstance> nearestNeighbors = knn.findKNN(instanceTest);
		
		// Make sure we good
		assertEquals(3, nearestNeighbors.size());
		assertEquals("instance2",(String) nearestNeighbors.get(0).getRef());
		assertEquals("instance1",(String) nearestNeighbors.get(1).getRef());
		assertEquals("instance3",(String) nearestNeighbors.get(2).getRef());
	}
	
	/**
	 * Unit test to make sure it works YO
	 */
	@Test
	public void unitTest_5() {
		
		// Brute for test
		Random rand = new Random();
		trainingSet.clear();
		for ( int i = 0; i < 1000000; ++i ) {
			KNNInstance instance = new KNNInstance();
			instance.add(rand.nextDouble()*100.0);
			instance.add(rand.nextDouble()*100.0);
			instance.add(rand.nextDouble()*100.0);
			instance.setRef(new String("instance" + i));
			trainingSet.add(instance);
		}
		
		// init KNN with Euclidean Space
		KNNDist dist = new KNNDistEuclidean();
		KNN knn = new KNN(dist,10);
		knn.train(trainingSet);
		
		// find nearest neighbor
		List<KNNInstance> nearestNeighbors = knn.findKNN(instanceTest);
		
		// Make sure we good
		assertEquals(10, nearestNeighbors.size());
	}
	
	/**
	 * Unit test to make sure it works YO
	 */
	@Test
	public void unitTest_6() {
		
		// init KNN with Euclidean Space
		KNNDist dist = new KNNDistZScore();
		KNN knn = new KNN(dist,1);
		knn.train(trainingSet);
		
		// find nearest neighbor
		List<KNNInstance> nearestNeighbors = knn.findKNN(instanceTest);
		
		// Make sure we good
		assertEquals(1, nearestNeighbors.size());
		assertEquals("instance2",(String) nearestNeighbors.get(0).getRef());
	}
	
	/**
	 * Unit test to make sure it works YO
	 */
	@Test
	public void unitTest_7() {
		
		// init KNN with Euclidean Space
		KNNDist dist = new KNNDistZScore();
		KNN knn = new KNN(dist,2);
		knn.train(trainingSet);
		
		// find nearest neighbor
		List<KNNInstance> nearestNeighbors = knn.findKNN(instanceTest);
		
		// Make sure we good
		assertEquals(2, nearestNeighbors.size());
		assertEquals("instance2",(String) nearestNeighbors.get(0).getRef());
		assertEquals("instance1",(String) nearestNeighbors.get(1).getRef());
	}
	
	/**
	 * Unit test to make sure it works YO
	 */
	@Test
	public void unitTest_8() {
		
		// init KNN with Euclidean Space
		KNNDist dist = new KNNDistZScore();
		KNN knn = new KNN(dist,3);
		knn.train(trainingSet);
		
		// find nearest neighbor
		List<KNNInstance> nearestNeighbors = knn.findKNN(instanceTest);
		
		// Make sure we good
		assertEquals(3, nearestNeighbors.size());
		assertEquals("instance2",(String) nearestNeighbors.get(0).getRef());
		assertEquals("instance1",(String) nearestNeighbors.get(1).getRef());
		assertEquals("instance3",(String) nearestNeighbors.get(2).getRef());
	}
	
	/**
	 * Unit test to make sure it works YO
	 */
	@Test
	public void unitTest_9() {
		
		// init KNN with Euclidean Space
		KNNDist dist = new KNNDistZScore();
		KNN knn = new KNN(dist,40000);
		knn.train(trainingSet);
		
		// find nearest neighbor
		List<KNNInstance> nearestNeighbors = knn.findKNN(instanceTest);
		
		// Make sure we good
		assertEquals(3, nearestNeighbors.size());
		assertEquals("instance2",(String) nearestNeighbors.get(0).getRef());
		assertEquals("instance1",(String) nearestNeighbors.get(1).getRef());
		assertEquals("instance3",(String) nearestNeighbors.get(2).getRef());
	}
	
	/**
	 * Unit test to make sure it works YO
	 */
	@Test
	public void unitTest_10() {
		
		// Brute for test
		Random rand = new Random();
		trainingSet.clear();
		for ( int i = 0; i < 1000000; ++i ) {
			KNNInstance instance = new KNNInstance();
			instance.add(rand.nextDouble()*100.0);
			instance.add(rand.nextDouble()*100.0);
			instance.add(rand.nextDouble()*100.0);
			instance.setRef(new String("instance" + i));
			trainingSet.add(instance);
		}
		
		// init KNN with Euclidean Space
		KNNDist dist = new KNNDistZScore();
		KNN knn = new KNN(dist,10);
		knn.train(trainingSet);
		
		// find nearest neighbor
		List<KNNInstance> nearestNeighbors = knn.findKNN(instanceTest);
		
		// Make sure we good
		assertEquals(10, nearestNeighbors.size());
	}
}
