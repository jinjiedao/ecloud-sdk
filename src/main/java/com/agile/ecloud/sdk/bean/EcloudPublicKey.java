package com.agile.ecloud.sdk.bean;

/**
 * 
 * @author sjh
 */
public class EcloudPublicKey {

    private String app_key = "";

    private String secret = "";

    private String v = "";

    private String url = "";

    public static EcloudPublicKey instance;
    
    public static void init(String app_key, String secret, String v, String url) {
    	instance = new EcloudPublicKey(app_key, secret, v, url);
    }

    public EcloudPublicKey(String app_key, String secret, String v, String url) {
        this.app_key = app_key;
        this.secret = secret;
        this.v = v;
        this.url = url;
    }
    public EcloudPublicKey() {

    }

	public String getApp_key() {
		return app_key;
	}

	public void setApp_key(String app_key) {
		this.app_key = app_key;
	}

	public String getSecret() {
		return secret;
	}

	public void setSecret(String secret) {
		this.secret = secret;
	}

	public String getV() {
		return v;
	}

	public void setV(String v) {
		this.v = v;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
}