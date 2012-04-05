//   **************************************************************************
//   *                                                                        *
//   *  This program is free software: you can redistribute it and/or modify  *
//   *  it under the terms of the GNU General Public License as published by  *
//   *  the Free Software Foundation, either version 3 of the License, or     *
//   * (at your option) any later version.                                    *
//   *                                                                        *
//   *  This program is distributed in the hope that it will be useful,       *  
//   *  but WITHOUT ANY WARRANTY; without even the implied warranty of        *
//   *  MERCHANTABILITY || FITNESS FOR A PARTICULAR PURPOSE.  See the         *
//   *  GNU General Public License for more details.                          *
//   *                                                                        *
//   *  You should have received a copy of the GNU General Public License     *
//   *  along with this program.  If not, see <http://www.gnu.org/licenses/>. *
//   *                                                                        *
//   *         (C) Arvind Kumar 2012 . All rights reserved                    *
//   **************************************************************************

import java.io.*;

public class EnCaeser{
	public static void main(String args[])throws IOException{
		BufferedReader b=new BufferedReader(new InputStreamReader(System.in));
		System.out.print("************************ENCAESER V1.0************************\n\nEncode\\Decode to\\from the Ceaser's Cipher\\Ceaser's Square\n\nVisit http://github.com/EnKrypt/EnCaeser to learn more \nThe above link also provides you with its source code\n\nAuthor: EnKrypt\n\nPress enter to continue ");
		String trash=b.readLine();
		String inp="";
		while (!inp.equals("5")){
			System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
			System.out.print("************************ENCAESER V1.0************************\n\n1. Encode to Ceaser's Cipher\n2. Decode from Caeser's Cipher\n3. Encode to Ceaser's Square\n4. Decode from Caeser's Square\n5. Exit\n\nEnter a choice : ");
			inp=b.readLine();
			if (inp.equals("1")){
				System.out.print("Enter Plaintext : ");
				String pt=b.readLine();
				System.out.print("Enter Shift : ");
				int shift=0;
				try{
					shift=Math.abs(Integer.parseInt(b.readLine()));
				}
				catch(Exception e){
					System.out.println("Error. Shift will be assumed as 0");
				}
				System.out.println("\nCipher : "+encipher(pt,shift));
				System.out.print("\nPress enter to continue ");
				trash=b.readLine();
			}
			if (inp.equals("2")){
				System.out.print("Enter Cipher : ");
				String pt=b.readLine();
				System.out.print("Enter Shift (just press enter if you are not aware of the shift): ");
				String shifty=b.readLine();
				if (shifty.equals("")||shifty.equals(" ")){
					System.out.print("\nSince you are not aware of the shift,\nwe will display the plaintexts of all possible shifts\nBe alert. If the cipher was ecrypted correctly using the ceaser's cipher,\nthen one of the plaintexts will be the right one,\nprobably the one making more sense\n\nOk? Good to go? Press enter ");
					trash=b.readLine();
					System.out.println("\n");
					decipher(pt);
					System.out.print("\nPress enter to continue ");
					trash=b.readLine();
				}
				else{
					int shift=0;
					try{
						shift=Math.abs(Integer.parseInt(shifty));
					}
					catch(Exception e){
						System.out.println("Error. Shift will be assumed as 0");
					}
					System.out.println("\nCipher : "+decipher(pt,shift));
					System.out.print("\nPress enter to continue ");
					trash=b.readLine();
				}
			}
			if (inp.equals("3")){
				System.out.print("Enter Plaintext (spaces not recommended) : ");
				String pt=b.readLine();
				if (((int)Math.sqrt(pt.length()))==Math.sqrt(pt.length())){
					System.out.println("\nCipher : "+ensquare(pt));
					System.out.print("\nPress enter to continue ");
					trash=b.readLine();
				}
				else{
					System.out.println("Error. Number of characters in plaintext must be a perfect square");
					System.out.print("\nPress enter to continue ");
					trash=b.readLine();
				}
			}
			if (inp.equals("4")){
				System.out.print("Enter Cipher : ");
				String pt=b.readLine();
				if (((int)Math.sqrt(pt.length()))==Math.sqrt(pt.length())){
					System.out.println("\nPlaintext : "+desquare(pt));
					System.out.print("\nPress enter to continue ");
					trash=b.readLine();
				}
				else{
					System.out.println("Error. Number of characters in cipher should be a perfect square\nAre you sure the cipher is correct?");
					System.out.print("\nPress enter to continue ");
					trash=b.readLine();
				}
			}
		}
		System.out.println("\nMail me at arvind@enkrypt.in for any doubts\\questions");
	}
	public static String encipher(String pt,int shift){
		String encrypted="";
		for (int i=0;i<pt.length();i++){
			int c=pt.charAt(i);
			if (Character.isUpperCase(c)){
				c=c+(shift%26);
				if (c>'Z')
					c=c-26;
			} 
			else if (Character.isLowerCase(c)){
				c=c+(shift%26);
				if (c>'z')
					c=c-26;
			}
			encrypted+=(char)c;
		}
		return encrypted;
	}
	public static String decipher(String pt,int shift){
		String decrypted="";
		for (int i=0;i<pt.length();i++){
			int c=pt.charAt(i);
			if (Character.isUpperCase(c)){
				c=c-(shift%26);
				if (c<'A')
					c=c+26;
			} 
			else if (Character.isLowerCase(c)){
				c=c-(shift%26);
				if (c<'a')
					c=c+26;
			}
			decrypted+=(char)c;
		}
		return decrypted;
	}
	public static void decipher(String pt){
		for (int i=0;i<=26;i++){
			System.out.println(decipher(pt,i));
		}
	}
	public static String ensquare(String pt){
		String encrypted="";
		int root=(int)Math.sqrt(pt.length());
		char[][] grid=new char[root][root];
		for (int i=0;i<pt.length();i++){
			grid[i/root][i%root]=pt.charAt(i);
		}
		for (int i=0;i<pt.length();i++){
			encrypted+=grid[i%root][i/root];
		}
		return encrypted;
	}
	public static String desquare(String pt){
		String encrypted="";
		int root=(int)Math.sqrt(pt.length());
		char[][] grid=new char[root][root];
		for (int i=0;i<pt.length();i++){
			grid[i%root][i/root]=pt.charAt(i);
		}
		for (int i=0;i<pt.length();i++){
			encrypted+=grid[i/root][i%root];
		}
		return encrypted;
	}
}