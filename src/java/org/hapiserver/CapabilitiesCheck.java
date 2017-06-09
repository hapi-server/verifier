/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.hapiserver;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Checks that a capabilities request returns a valid capabilities response.
 * @author jbf
 */
public class CapabilitiesCheck extends Check {
    
    public CapabilitiesCheck( URL hapi ) {
        super(hapi,"capabilities");
    }
    
    @Override
    public CheckStatus doCheck( ) throws MalformedURLException, IOException, JSONException {
        URL cap= hapiURL( hapi, "capabilities", null );
        JSONObject jo= getJSONObject(cap);
        jo.getString("HAPI");
        jo.get("status");
        jo.getJSONArray("outputFormats");
        
        return new CheckStatus(0);
    }
}