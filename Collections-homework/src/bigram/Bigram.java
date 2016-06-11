package bigram;

import java.util.HashMap;
import java.util.Iterator;

public class Bigram {

	public int brojPonavljanjaBigramaUStringu(String bigram, String string) {
		int brojac = 0;
		if (bigram.length() != 2) {
			throw new RuntimeException("Bigram mora imati tacno 2 slova!");
		}
		for (int i = 0; i < string.length() - 1; i++) {
			if (string.substring(i, i + 2).equals(bigram)) {
				brojac++;
			}
		}
		return brojac;
	}

	public void ubaciBigrameIzStringaUMapu(String string, HashMap<String, Integer> hashMapa) {
		for (int i = 0; i < string.length() - 1; i++) {
			String bigram = string.substring(i, i + 2);
			if (!hashMapa.containsKey(bigram)) {
				hashMapa.put(bigram, brojPonavljanjaBigramaUStringu(bigram, string));
			}
		}
	}

	public void stampajHashMapu(HashMap<String, Integer> hashMapa) {
		Iterator<?> i = hashMapa.entrySet().iterator();
		while (i.hasNext()) {
			HashMap.Entry p = (HashMap.Entry) i.next();
			System.out.println(p.getKey() + " " + p.getValue());
		}
	}

	public String kojaTriKaraktera(HashMap<String, Integer> hashMapa, String string) {
		for (int i = 0; i < 3; i++) {

			String kraj = string.substring(string.length()-1);
			Iterator<?> it = hashMapa.entrySet().iterator();
			int max = 0;
			String bigram = null;
			while (it.hasNext()) {
				HashMap.Entry p = (HashMap.Entry) it.next();
				String key = (String)p.getKey();
				if (key.startsWith(kraj)) {
					if ((Integer) p.getValue() > max) {
						bigram = (String) p.getKey();
						max = (Integer) p.getValue();
					}
				}
			}

			string = string.concat(bigram.substring(1));

		}
		return string;
	}

}
