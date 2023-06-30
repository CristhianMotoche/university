/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package soporte;

import twitter4j.FilterQuery;
import twitter4j.StatusListener;
import twitter4j.TwitterStream;
import twitter4j.TwitterStreamFactory;

/**
 *
 * @author camm
 */
public class GetTweets {
	private TwitterStream twitterStream;

	public GetTweets() {
		ConfigTwitterStream configuracion = new ConfigTwitterStream();
		this.twitterStream = new TwitterStreamFactory(configuracion.getCb().build()).getInstance();
	}
	
	public void addListener(StatusListener listener){
		this.twitterStream.addListener(listener);
	}

	public void filtrar(){
		FilterQuery fq = new FilterQuery();
        String keywords[] = {"quito"};
        fq.track(keywords);
		this.twitterStream.filter(fq);
	}
}
