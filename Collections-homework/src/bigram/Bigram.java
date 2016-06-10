package bigram;

import java.util.HashMap;
import java.util.Iterator;

public class Bigram {
	
	public int brojPonavljanjaBigramaUStringu(String bigram, String string){
		int brojac = 0;
		if(bigram.length()!=2){
			throw new RuntimeException("Bigram mora imati tacno 2 slova!");
		}
		for (int i = 0; i < string.length()-1; i++) {
			if(string.substring(i, i+2).equals(bigram)){
				brojac++;
			}
		}
		return brojac;
	}

	public void ubaciBigrameIzStringaUMapu(String string, HashMap <String, Integer> hashMapa){
		for (int i = 0; i < string.length()-1; i++) {
			String bigram = string.substring(i, i+2);
			if(!hashMapa.containsKey(bigram)){
				hashMapa.put(bigram, brojPonavljanjaBigramaUStringu(bigram, string));
			}
		}
	}
	
	public void stampajHashMapu(HashMap <String, Integer> hashMapa){
		Iterator<?> i = hashMapa.entrySet().iterator();
		while(i.hasNext()){
			HashMap.Entry pair = (HashMap.Entry)i.next();
	        System.out.println(pair.getKey() + " " + pair.getValue());
		}
	}
	
	
	
}
