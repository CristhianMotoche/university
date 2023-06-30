/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package soporte;

import twitter4j.conf.ConfigurationBuilder;

/**
 *
 * @author camm
 */
public class ConfigTwitterStream {
	private ConfigurationBuilder cb;
	private String OAUTHCONSUMERKEY = "";
	private String OAUTHCONSUMERSECRET = "";
	private String OAUTHACCESSTOKEN = "";
	private String OAUTHACCESSTOKENSECRET = "";

	public ConfigTwitterStream() {
		cb = new ConfigurationBuilder();
		cb.setDebugEnabled(true);
		cb.setOAuthConsumerKey(OAUTHCONSUMERKEY);
		cb.setOAuthConsumerSecret(OAUTHCONSUMERSECRET);
		cb.setOAuthAccessToken(OAUTHACCESSTOKEN);
		cb.setOAuthAccessTokenSecret(OAUTHACCESSTOKENSECRET);
	}

	public ConfigurationBuilder getCb() {
		return cb;
	}
}
