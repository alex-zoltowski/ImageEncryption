package ImageEncryption;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import javax.imageio.ImageIO;

public class Decrypt {
	
	private File inputFile;
	private BufferedImage img;
	private Progress loading;
	
	public Decrypt(File file) throws IOException
	{
		loading = new Progress();
		loading.setTitle("Decrypter");
		loading.setLabelTxt("Decrypting...");
		loading.update(loading.getGraphics());
		
		inputFile = file;
		String nameOfImg = inputFile.getName();
		nameOfImg = nameOfImg.substring(0, nameOfImg.length() - 4);
		String fileDir = inputFile.getParentFile().getAbsolutePath();
		
		BufferedReader info = new BufferedReader(new InputStreamReader(new FileInputStream(inputFile), "Unicode"));

		String w = info.readLine();
		int width = (int) Integer.parseInt(w);
		String h = info.readLine();
		int height = (int) Integer.parseInt(h);
	
		ArrayList<String> encryptedLines = new ArrayList<>();
		String line = null;
		while((line = info.readLine()) != null)
		{
			encryptedLines.add(line);
		}
		
		info.close();
		
		ArrayList<String> decryptedLines = new ArrayList<>();
		String encryptedLine;
		String decryptedLine;
		String number;
		String RGB;
		int redundancy;
		for(int x = 0; x < encryptedLines.size(); x++)
		{
			encryptedLine = encryptedLines.get(x);
			decryptedLine = "";
			
			for(int y = 0; y < encryptedLine.length(); y++)
			{
				number = "";
				
				char ch = encryptedLine.charAt(y);
				
				while(Integer.valueOf(ch) >= 48 && Integer.valueOf(ch) <= 57)
				{
					number += String.valueOf(ch);
					
					y++;
					
					if(y == encryptedLine.length())
						break;
					
					ch = encryptedLine.charAt(y);
				}
				
				RGB = encryptedLine.substring(y, y + 3);
				
				if(number.length() > 0)
				{
					redundancy = Integer.valueOf(number);
					while(redundancy != 0)
					{
						decryptedLine += RGB;
						redundancy--;
					}
				}
				else
				{
					decryptedLine += RGB;
				}
				y += 2;
			}
			
			decryptedLines.add(decryptedLine);
		}
		
		String rgbLine;
		ArrayList<RGB> RGBValues = new ArrayList<>();
		RGB value;
		for(int x = 0; x < decryptedLines.size(); x++)
		{
			rgbLine = decryptedLines.get(x);
			
			for(int y = 0; y < rgbLine.length(); y++)
			{
				String r = String.valueOf(rgbLine.charAt(y));
				y++;
				String g = String.valueOf(rgbLine.charAt(y));
				y++;
				String b = String.valueOf(rgbLine.charAt(y));
				
				value = new RGB(decryptValues(r), decryptValues(g), decryptValues(b));
				RGBValues.add(value);
			}
		}
		
		img = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		
		Color color;
		int index = 0;
		int rgb;
		for (int y = 0; y < height; y++)
		{
		    for (int x = 0; x < width; x++)
		    {
		    	color = new Color(RGBValues.get(index).getRed(),
		    							RGBValues.get(index).getGreen(),
		    							RGBValues.get(index).getBlue());
		    	index++;
		    	rgb = color.getRGB();
		    	img.setRGB(x, y, rgb);
		    }
		}

		File outputfile = new File(fileDir + "\\" + nameOfImg);
		ImageIO.write(img, "jpg", outputfile);
		inputFile.delete();
		
		loading.setLabelTxt("Decryption Complete!");
		loading.setBtnVisibility(true);
	}
	
	public int decryptValues(String ch)
	{
		
		int RGBValue = 0;
		
		switch (ch) {
		
			case " " : RGBValue = 0;
			break;
			case "!" : RGBValue = 1;
			break;
			case "@" : RGBValue = 2;
			break;
			case "#" : RGBValue = 3;
			break;
			case "$" : RGBValue = 4;
			break;
			case "%" : RGBValue = 5;
			break;
			case "^" : RGBValue = 6;
			break;
			case "&" : RGBValue = 7;
			break;
			case "*" : RGBValue = 8;
			break;
			case "(" : RGBValue = 9;
			break;
			case ")" : RGBValue = 10;
			break;
			case "_" : RGBValue = 11;
			break;
			case "-" : RGBValue = 12;
			break;
			case "+" : RGBValue = 13;
			break;
			case "=" : RGBValue = 14;
			break;
			case "q" : RGBValue = 15;
			break;
			case "w" : RGBValue = 16;
			break;
			case "e" : RGBValue = 17;
			break;
			case "r" : RGBValue = 18;
			break;
			case "t" : RGBValue = 19;
			break;
			case "y" : RGBValue = 20;
			break;
			case "u" : RGBValue = 21;
			break;
			case "i" : RGBValue = 22;
			break;
			case "o" : RGBValue = 23;
			break;
			case "p" : RGBValue = 24;
			break;
			case "{" : RGBValue = 25;
			break;
			case "[" : RGBValue = 26;
			break;
			case "}" : RGBValue = 27;
			break;
			case "]" : RGBValue = 28;
			break;
			case "|" : RGBValue = 29;
			break;
			case "O" : RGBValue = 30;
			break;
			case "`" : RGBValue = 31;
			break;
			case "~" : RGBValue = 32;
			break;
			case "a" : RGBValue = 33;
			break;
			case "s" : RGBValue = 34;
			break;
			case "d" : RGBValue = 35;
			break;
			case "f" : RGBValue = 36;
			break;
			case "g" : RGBValue = 37;
			break;
			case "h" : RGBValue = 38;
			break;
			case "j" : RGBValue = 39;
			break;
			case "k" : RGBValue = 40;
			break;
			case "l" : RGBValue = 41;
			break;
			case ";" : RGBValue = 42;
			break;
			case ":" : RGBValue = 43;
			break;
			case "M" : RGBValue = 44;
			break;
			case "N" : RGBValue = 45;
			break;
			case "z" : RGBValue = 46;
			break;
			case "x" : RGBValue = 47;
			break;
			case "c" : RGBValue = 48;
			break;
			case "v" : RGBValue = 49;
			break;
			case "b" : RGBValue = 50;
			break;
			case "n" : RGBValue = 51;
			break;
			case "m" : RGBValue = 52;
			break;
			case "<" : RGBValue = 53;
			break;
			case "," : RGBValue = 54;
			break;
			case ">" : RGBValue = 55;
			break;
			case "." : RGBValue = 56;
			break;
			case "?" : RGBValue = 57;
			break;
			case "/" : RGBValue = 58;
			break;
			case "Ç" : RGBValue = 59;
			break;
			case "¿" : RGBValue = 60;
			break;
			case "À" : RGBValue = 61;
			break;
			case "Á" : RGBValue = 62;
			break;
			case "Â" : RGBValue = 63;
			break;
			case "Ã" : RGBValue = 64;
			break;
			case "Ä" : RGBValue = 65;
			break;
			case "Å" : RGBValue = 66;
			break;
			case "Æ" : RGBValue = 67;
			break;
			case "È" : RGBValue = 68;
			break;
			case "É" : RGBValue = 69;
			break;
			case "Ê" : RGBValue = 70;
			break;
			case "Ë" : RGBValue = 71;
			break;
			case "Ì" : RGBValue = 72;
			break;
			case "Í" : RGBValue = 73;
			break;
			case "Î" : RGBValue = 74;
			break;
			case "Ï" : RGBValue = 75;
			break;
			case "Ð" : RGBValue = 76;
			break;
			case "Ñ" : RGBValue = 77;
			break;
			case "Ò" : RGBValue = 78;
			break;
			case "Ó" : RGBValue = 79;
			break;
			case "Ô" : RGBValue = 80;
			break;
			case "Õ" : RGBValue = 81;
			break;
			case "Ö" : RGBValue = 82;
			break;
			case "Ø" : RGBValue = 83;
			break;
			case "Ù" : RGBValue = 84;
			break;
			case "Ú" : RGBValue = 85;
			break;
			case "Û" : RGBValue = 86;
			break;
			case "Ü" : RGBValue = 87;
			break;
			case "Ý" : RGBValue = 88;
			break;
			case "Þ" : RGBValue = 89;
			break;
			case "ß" : RGBValue = 90;
			break;
			case "à" : RGBValue = 91;
			break;
			case "á" : RGBValue = 92;
			break;
			case "â" : RGBValue = 93;
			break;
			case "ã" : RGBValue = 94;
			break;
			case "ä" : RGBValue = 95;
			break;
			case "å" : RGBValue = 96;
			break;
			case "æ" : RGBValue = 97;
			break;
			case "ç" : RGBValue = 98;
			break;
			case "è" : RGBValue = 99;
			break;
			case "é" : RGBValue = 100;
			break;
			case "ê" : RGBValue = 101;
			break;
			case "ë" : RGBValue = 102;
			break;
			case "ì" : RGBValue = 103;
			break;
			case "í" : RGBValue = 104;
			break;
			case "î" : RGBValue = 105;
			break;
			case "ï" : RGBValue = 106;
			break;
			case "ð" : RGBValue = 107;
			break;
			case "ñ" : RGBValue = 108;
			break;
			case "ò" : RGBValue = 109;
			break;
			case "ó" : RGBValue = 110;
			break;
			case "ô" : RGBValue = 111;
			break;
			case "õ" : RGBValue = 112;
			break;
			case "ö" : RGBValue = 113;
			break;
			case "÷" : RGBValue = 114;
			break;
			case "ø" : RGBValue = 115;
			break;
			case "ù" : RGBValue = 116;
			break;
			case "ú" : RGBValue = 117;
			break;
			case "û" : RGBValue = 118;
			break;
			case "ü" : RGBValue = 119;
			break;
			case "ý" : RGBValue = 120;
			break;
			case "ÿ" : RGBValue = 121;
			break;
			case "Œ" : RGBValue = 122;
			break;
			case "Š" : RGBValue = 123;
			break;
			case "š" : RGBValue = 124;
			break;
			case "¢" : RGBValue = 125;
			break;
			case "£" : RGBValue = 126;
			break;
			case "¤" : RGBValue = 127;
			break;
			case "¥" : RGBValue = 128;
			break;
			case "¦" : RGBValue = 129;
			break;
			case "§" : RGBValue = 130;
			break;
			case "©" : RGBValue = 131;
			break;
			case "ª" : RGBValue = 132;
			break;
			case "«" : RGBValue = 133;
			break;
			case "¬" : RGBValue = 134;
			break;
			case "®" : RGBValue = 135;
			break;
			case "°" : RGBValue = 136;
			break;
			case "±" : RGBValue = 137;
			break;
			case "²" : RGBValue = 138;
			break;
			case "¯" : RGBValue = 139;
			break;
			case "³" : RGBValue = 140;
			break;
			case "¶" : RGBValue = 141;
			break;
			case "¹" : RGBValue = 142;
			break;
			case "»" : RGBValue = 143;
			break;
			case "¼" : RGBValue = 144;
			break;
			case "½" : RGBValue = 145;
			break;
			case "¾" : RGBValue = 146;
			break;
			case "☺" : RGBValue = 147;
			break;
			case "☻" : RGBValue = 148;
			break;
			case "♥" : RGBValue = 149;
			break;
			case "♦" : RGBValue = 150;
			break;
			case "♣" : RGBValue = 151;
			break;
			case "♠" : RGBValue = 152;
			break;
			case "•" : RGBValue = 153;
			break;
			case "◘" : RGBValue = 154;
			break;
			case "○" : RGBValue = 155;
			break;
			case "◙" : RGBValue = 156;
			break;
			case "♀" : RGBValue = 157;
			break;
			case "♪" : RGBValue = 158;
			break;
			case "♫" : RGBValue = 159;
			break;
			case "☼" : RGBValue = 160;
			break;
			case "►" : RGBValue = 161;
			break;
			case "◄" : RGBValue = 162;
			break;
			case "↕" : RGBValue = 163;
			break;
			case "‼" : RGBValue = 164;
			break;
			case "L" : RGBValue = 165;
			break;
			case "↑" : RGBValue = 166;
			break;
			case "▬" : RGBValue = 167;
			break;
			case "↓" : RGBValue = 168;
			break;
			case "→" : RGBValue = 169;
			break;
			case "←" : RGBValue = 170;
			break;
			case "↔" : RGBValue = 171;
			break;
			case "▲" : RGBValue = 172;
			break;
			case "▼" : RGBValue = 173;
			break;
			case "╚" : RGBValue = 174;
			break;
			case "╟" : RGBValue = 175;
			break;
			case "╞" : RGBValue = 176;
			break;
			case "┼" : RGBValue = 177;
			break;
			case "├" : RGBValue = 178;
			break;
			case "┬" : RGBValue = 179;
			break;
			case "┴" : RGBValue = 180;
			break;
			case "╔" : RGBValue = 181;
			break;
			case "╩" : RGBValue = 182;
			break;
			case "╦" : RGBValue = 183;
			break;
			case "╠" : RGBValue = 184;
			break;
			case "═" : RGBValue = 185;
			break;
			case "╬" : RGBValue = 186;
			break;
			case "╧" : RGBValue = 187;
			break;
			case "╨" : RGBValue = 188;
			break;
			case "╤" : RGBValue = 189;
			break;
			case "╥" : RGBValue = 190;
			break;
			case "╙" : RGBValue = 191;
			break;
			case "╘" : RGBValue = 192;
			break;
			case "╒" : RGBValue = 193;
			break;
			case "╓" : RGBValue = 194;
			break;
			case "╫" : RGBValue = 195;
			break;
			case "╪" : RGBValue = 196;
			break;
			case "┘" : RGBValue = 197;
			break;
			case "█" : RGBValue = 198;
			break;
			case "▄" : RGBValue = 199;
			break;
			case "▌" : RGBValue = 200;
			break;
			case "▐" : RGBValue = 201;
			break;
			case "▀" : RGBValue = 202;
			break;
			case "π" : RGBValue = 203;
			break;
			case "Σ" : RGBValue = 204;
			break;
			case "α" : RGBValue = 205;
			break;
			case "σ" : RGBValue = 206;
			break;
			case "µ" : RGBValue = 207;
			break;
			case "Φ" : RGBValue = 208;
			break;
			case "Θ" : RGBValue = 209;
			break;
			case "Ω" : RGBValue = 210;
			break;
			case "δ" : RGBValue = 211;
			break;
			case "∞" : RGBValue = 212;
			break;
			case "ε" : RGBValue = 213;
			break;
			case "∩" : RGBValue = 214;
			break;
			case "≡" : RGBValue = 215;
			break;
			case "K" : RGBValue = 216;
			break;
			case "≥" : RGBValue = 217;
			break;
			case "≤" : RGBValue = 218;
			break;
			case "⌠" : RGBValue = 219;
			break;
			case "⌡" : RGBValue = 220;
			break;
			case "’" : RGBValue = 221;
			break;
			case "≈" : RGBValue = 222;
			break;
			case "√" : RGBValue = 223;
			break;
			case "ⁿ" : RGBValue = 224;
			break;
			case "■" : RGBValue = 225;
			break;
			case "™" : RGBValue = 226;
			break;
			case "ƒ" : RGBValue = 227;
			break;
			case "…" : RGBValue = 228;
			break;
			case "—" : RGBValue = 229;
			break;
			case "–" : RGBValue = 230;
			break;
			case "“" : RGBValue = 231;
			break;
			case "”" : RGBValue = 232;
			break;
			case "›" : RGBValue = 233;
			break;
			case "‹" : RGBValue = 234;
			break;
			case "€" : RGBValue = 235;
			break;
			case "‘" : RGBValue = 236;
			break;
			case "×" : RGBValue = 237;
			break;
			case "„" : RGBValue = 238;
			break;
			case "†" : RGBValue = 239;
			break;
			case "‡" : RGBValue = 240;
			break;
			case "¸" : RGBValue = 241;
			break;
			case "Ž" : RGBValue = 242;
			break;
			case "ž" : RGBValue = 243;
			break;
			case "Ÿ" : RGBValue = 244;
			break;
			case "‰" : RGBValue = 245;
			break;
			case "A" : RGBValue = 246;
			break;
			case "B" : RGBValue = 247;
			break;
			case "C" : RGBValue = 248;
			break;
			case "D" : RGBValue = 249;
			break;
			case "E" : RGBValue = 250;
			break;
			case "F" : RGBValue = 251;
			break;
			case "G" : RGBValue = 252;
			break;
			case "H" : RGBValue = 253;
			break;
			case "I" : RGBValue = 254;
			break;
			case "J" : RGBValue = 255;
			break;

		}
		
		return RGBValue;
	}
}
