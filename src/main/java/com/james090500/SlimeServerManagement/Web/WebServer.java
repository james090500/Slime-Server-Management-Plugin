package com.james090500.SlimeServerManagement.Web;

import java.io.IOException;
import java.util.Map;

import fi.iki.elonen.NanoHTTPD;
import fi.iki.elonen.NanoHTTPD.Response.Status;

public class WebServer extends NanoHTTPD {
	
	public WebServer() throws IOException {
		super(8080);
		start(NanoHTTPD.SOCKET_READ_TIMEOUT, false);
        System.out.println("\nRunning! Point your browsers to http://localhost:8080/ \n");
	}
	
	@Override
	public Response serve(IHTTPSession session) {
		return newFixedLengthResponse(Status.OK, MIME_PLAINTEXT, "Yeet");
	}	

}
