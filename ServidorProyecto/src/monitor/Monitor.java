/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package monitor;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author camm
 */
public class Monitor {
	public String resultCommands(){
		String resultUptime = filtrar(resultadoComando("uptime"), "load average:\\s*((?:(?:\\d,\\d{2}), *){2}\\d,\\d{2})");
		resultUptime = resultUptime.replaceAll(",\\s", " ");
		resultUptime = resultUptime.replaceAll(",", ".");
		String resultFree = filtrar(resultadoComando("free"), "Mem:\\s*\\d.*?\\s+\\d+\\s*(\\d+)");
		return resultFree + " " + resultUptime;
	}

	private String resultadoComando(String comando){
		String ret = "";
		try {
			Runtime r = Runtime.getRuntime();
			Process p = r.exec(comando);
			p.waitFor();
			BufferedReader b = new BufferedReader(new InputStreamReader(p.getInputStream()));
			String line;
			while ((line = b.readLine()) != null) {
				ret = ret + line + "\n";
			}
			b.close();
		}
		catch(IOException | InterruptedException e2) {}
		return ret;
	}
	
	private String filtrar(String cadena, String patron){
		String ret;
		Pattern r = Pattern.compile(patron);
		Matcher m = r.matcher(cadena);
		if (m.find()) {
			ret = m.group(1);
		} else {
			ret = "NO MATCH";
		}
		return ret;
	}
}
