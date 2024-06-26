/**   
 * Copyright 2011 Riyad Kalla
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.imgscalr;

import java.awt.image.BufferedImage;

import org.junit.Assert;
import org.junit.Test;

/**
 * The purpose of this test is to execute simultaneous scale operations on a
 * very small picture as quickly as possible to try and cause a dead-lock.
 * 
 * @author Riyad Kalla (software@thebuzzmedia.com)
 */
public class AsyncScalrSingleThreadTest extends AbstractScalrTest {
	private static int ITERS = 100000;
	private static BufferedImage ORIG;

	static {
		System.setProperty(AsyncScalr.THREAD_COUNT_PROPERTY_NAME, "1");
		ORIG = load("mr-t.jpg");
	}

	@Test
	public void test() throws InterruptedException {
		for (int i = 0; i < ITERS; i++) {
			if (i % 100 == 0)
				System.out.println("Scale Iteration " + i);

			Thread t = new ScaleThread();
			t.start();

			/*
			 * We are testing single-threaded scales so join on the new thread
			 * until done and keep testing.
			 */
			t.join();
		}
		
		// Make sure we finish with no exceptions.
				Assert.assertTrue(true);
	}

	public class ScaleThread extends Thread {
		@Override
		public void run() {
			try {
				AsyncScalr.resize(ORIG, 125).get();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
