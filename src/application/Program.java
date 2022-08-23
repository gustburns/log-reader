package application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Date;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

import entities.LogEntry;

public class Program {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter file full path: ");
		String path = sc.nextLine();
		try (BufferedReader br = new BufferedReader(new FileReader(path))) {
			Set<LogEntry> set = new HashSet<>();
			String line = br.readLine();
			while (line != null) {
				String[] parsedString = line.split(" ");
				LogEntry oLogEntry = new LogEntry(parsedString[0], Date.from(Instant.parse(parsedString[1])));
				set.add(oLogEntry);
				line = br.readLine();
			}
			System.out.print("\nTotal users: " + set.size());
		} catch (IOException e) {
			System.out.println("Error: " + e.getMessage());
		}
		finally {
			sc.close();
		}
	}

}
