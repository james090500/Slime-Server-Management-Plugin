package com.james090500.SlimeServerManagement.Web;

import java.io.IOException;

import fi.iki.elonen.NanoHTTPD;

public class WebServer extends NanoHTTPD {
	
	public WebServer() throws IOException {
		super(8080);
		addMappings();
        System.out.println("\nRunning! Point your browsers to http://localhost:8080/ \n");
	}

}
