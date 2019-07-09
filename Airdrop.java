package airdrop;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Set;
import java.util.TreeSet;

public class Airdrop {

	public static void main(String[] args) throws IOException {
		Set<String> addresses = new TreeSet<String>();
		
		BufferedReader br = new BufferedReader(new FileReader("<path-to-file-containing-list>"));
		
		String line;
		
		while(!((line = br.readLine()).equals("exitnow"))) {
			if(line.contains("bnb1")) {
				int i = line.indexOf("bnb1");
				String address = line.substring(i, i+42);
				addresses.add(address);
				System.out.println(address);
			}
		}
		
		BufferedWriter writer = new BufferedWriter(new FileWriter("<path-to-save-json-output>"));
		
		int count = 1;
		int size = addresses.size();
		System.out.println(size);
		
		for(String address : addresses) {
			
			String thisLine = "";
			
			if(count == 1) {
				thisLine += "[{\n";
			}
			else {
				thisLine += "{\n";
			}
			
			thisLine += "\"to\":";
			thisLine += "\"" + address + "\",\n";
			thisLine += "\"amount\":\"200000000000:GIV-94E\"\n";
			
			if(count == size) {
				thisLine += "}]";
			}
			else {
				thisLine += "},\n";
			}
			
			writer.write(thisLine);
			count++;
			
		}
		writer.close();
	}

}
