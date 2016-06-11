package bigram.main;

import java.util.HashMap;

import bigram.Bigram;

public class BigramMethods {
	public static void main(String[] args) {
		Bigram b = new Bigram();
		HashMap <String, Integer> hashMapa = new HashMap<>();
		String string = "abbcceeeeeeabcc";
		b.ubaciBigrameIzStringaUMapu(string, hashMapa);
		b.stampajHashMapu(hashMapa);
		System.out.println("Rezultat: " +b.kojaTriKaraktera(hashMapa, "ja"));
		
	}
}
