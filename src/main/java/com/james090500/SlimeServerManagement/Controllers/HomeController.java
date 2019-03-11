package com.james090500.SlimeServerManagement.Controllers;

import fi.iki.elonen.NanoHTTPD;
import fi.iki.elonen.NanoHTTPD.Response;

public class HomeController {
	
	public static Response index() {
		Response res = NanoHTTPD.newFixedLengthResponse("Yeet");
		return res;
	}

}
