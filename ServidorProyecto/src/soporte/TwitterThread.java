/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package soporte;

/**
 *
 * @author camm
 */
public class TwitterThread extends Thread{
	@Override
	public void run(){
		GetTweets obtenedorDeTweets = new GetTweets();
		obtenedorDeTweets.addListener(new TwitterListener());
		obtenedorDeTweets.filtrar();
	}
}
