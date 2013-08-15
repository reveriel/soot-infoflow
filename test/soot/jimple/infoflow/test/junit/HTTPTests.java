/*******************************************************************************
 * Copyright (c) 2012 Secure Software Engineering Group at EC SPRIDE.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the GNU Lesser Public License v2.1
 * which accompanies this distribution, and is available at
 * http://www.gnu.org/licenses/old-licenses/gpl-2.0.html
 * 
 * Contributors: Christian Fritz, Steven Arzt, Siegfried Rasthofer, Eric
 * Bodden, and others.
 ******************************************************************************/
package soot.jimple.infoflow.test.junit;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import soot.jimple.infoflow.Infoflow;
/**
 * test taint propagation within java.net.URL and java.net.HttpURLConnection classes
 */
@Ignore
public class HTTPTests extends JUnitTests {
	
    @Test
    public void testURL() throws IOException{
    	Infoflow infoflow = initInfoflow();
    	List<String> epoints = new ArrayList<String>();
    	epoints.add("<soot.jimple.infoflow.test.HTTPTestCode: void testURL()>");
		infoflow.computeInfoflow(path, epoints,sources, sinks);
		
		checkInfoflow(infoflow, 1);
    }
    
    @Test
    public void testConnection() throws IOException{
//    	this.taintWrapper = true;
    	Infoflow infoflow = initInfoflow();
    	List<String> epoints = new ArrayList<String>();
    	epoints.add("<soot.jimple.infoflow.test.HTTPTestCode: void method1()>");
    	infoflow.computeInfoflow(path, epoints,sources, sinks);
		
		checkInfoflow(infoflow, 1);
    }

}
