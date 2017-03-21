package ImageEncryption;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import javax.imageio.ImageIO;
import java.util.ArrayList;

public class Encrypt {
	
	private BufferedImage img;
	private Progress loading;
	
	public Encrypt(File file) throws IOException
	{
		loading = new Progress();
		loading.setTitle("Encrypter");
		loading.setLabelTxt("Encrypting...");
		loading.update(loading.getGraphics());
		
		img = ImageIO.read(file.getAbsoluteFile());
		
		ArrayList<RGB> RGBValues = new ArrayList<RGB>();
		
		String dirPath = file.getAbsoluteFile().getParentFile().getAbsolutePath();
		dirPath = dirPath + "\\" + file.getName() + ".txt";
		File encryptedTxt = new File(dirPath);
		
		Writer print = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(encryptedTxt.getAbsolutePath()), "Unicode"));
		
		print.write(String.valueOf(img.getWidth()));
		print.write(System.getProperty("line.separator"));
		print.write(String.valueOf(img.getHeight()));
		print.write(System.getProperty("line.separator"));
		print.flush();
		 
		Color color;
		RGB values;
		for (int y = 0; y < img.getHeight(); y++)
		{
			for (int x = 0; x < img.getWidth(); x++)
			{
			    color = new Color(img.getRGB(x, y));
			    values = new RGB(color.getRed(), color.getGreen(), color.getBlue());
			    RGBValues.add(values);
			}
		}
		file.delete();
		
		int index = 0;
		String line = "";
		String encryptedData = "";
		int zero = 0;
		int redundancy = 1;
		int index2 = 0;
		String red = "";
		while(index < RGBValues.size())
		{
			 encryptedData = "";
			 encryptedData += encryptRGBValues(RGBValues.get(index).getRed());
			 encryptedData += encryptRGBValues(RGBValues.get(index).getGreen());
			 encryptedData += encryptRGBValues(RGBValues.get(index).getBlue());
			 
			 zero = 0;
			 redundancy = 1;
			 index2 = index;
			 while(redundancy > zero && index2 < RGBValues.size() - 1)
			 {
				 if(RGBValues.get(index2).getRed() == RGBValues.get(index2 + 1).getRed() &&
						 RGBValues.get(index2).getGreen() == RGBValues.get(index2 + 1).getGreen() &&
						 RGBValues.get(index2).getBlue() == RGBValues.get(index2 + 1).getBlue())
				 {
					 redundancy++;
					 index2++;
					 zero++;
				 }
				 else
					 zero++;
			 }
			 
			 
			 if(line.length() >= 1015)
			 {
				 print.write(line);
				 print.write(System.getProperty("line.separator"));
				 print.flush();
				 line = "";
			 }
			 
			 if(redundancy >= 2)
			 {
				 red = String.valueOf(redundancy);
				 line += red;
			 }
			 
			 line += encryptedData;

			 if(index == RGBValues.size() - 1 || index2 == RGBValues.size() -1)
			 {
				 print.write(line);
				 print.flush();
			 }
			 
			 if(redundancy <= 1)
				 index++;
			 else
				 index += (redundancy);
			 
		 }
		 	
		 print.flush();
		 print.close();
		 encryptedTxt.setReadOnly();
		 
		 loading.setLabelTxt("Encryption Complete!");
		 loading.setBtnVisibility(true);
	}
	
	public String encryptRGBValues(int value)
	{
		if(value == 0)
		{
			return " ";
		}
		else if (value == 1)
		{
			return "!";
		}
		else if(value == 2)
		{
			return "@";
		}
		else if(value == 3)
		{
			return "#";
		}
		else if(value == 4)
		{
			return "$";
		}
		else if(value == 5)
		{
			return "%";
		}
		else if(value == 6)
		{
			return "^";
		}
		else if(value == 7)
		{
			return "&";
		}
		else if(value == 8)
		{
			return "*";
		}
		else if(value == 9)
		{
			return "(";
		}
		else if(value == 10)
		{
			return ")";
		}
		else if(value == 11)
		{
			return "_";
		}
		else if(value == 12)
		{
			return "-";
		}
		else if(value == 13)
		{
			return "+";
		}
		else if(value == 14)
		{
			return "=";
		}
		else if(value == 15)
		{
			return "q";
		}
		else if(value == 16)
		{
			return "w";
		}
		else if(value == 17)
		{
			return "e";
		}
		else if(value == 18)
		{
			return "r";
		}
		else if(value == 19)
		{
			return "t";
		}
		else if(value == 20)
		{
			return "y";
		}
		else if(value == 21)
		{
			return "u";
		}
		else if(value == 22)
		{
			return "i";
		}
		else if(value == 23)
		{
			return "o";
		}
		else if(value == 24)
		{
			return "p";
		}
		else if(value == 25)
		{
			return "{";
		}
		else if(value == 26)
		{
			return "[";
		}
		else if(value == 27)
		{
			return "}";
		}
		else if(value == 28)
		{
			return "]";
		}
		else if(value == 29)
		{
			return "|";
		}
		else if(value == 30)
		{
			return "O";
		}
		else if(value == 31)
		{
			return "`";
		}
		else if(value == 32)
		{
			return "~";
		}
		else if(value == 33)
		{
			return "a";
		}
		else if(value == 34)
		{
			return "s";
		}
		else if(value == 35)
		{
			return "d";
		}
		else if(value == 36)
		{
			return "f";
		}
		else if(value == 37)
		{
			return "g";
		}
		else if(value == 38)
		{
			return "h";
		}
		else if(value == 39)
		{
			return "j";
		}
		else if(value == 40)
		{
			return "k";
		}
		else if(value == 41)
		{
			return "l";
		}
		else if(value == 42)
		{
			return ";";
		}
		else if(value == 43)
		{
			return ":";
		}
		else if(value == 44)
		{
			return "M";
		}
		else if(value == 45)
		{
			return "N";
		}
		else if(value == 46)
		{
			return "z";
		}
		else if(value == 47)
		{
			return "x";
		}
		else if(value == 48)
		{
			return "c";
		}
		else if(value == 49)
		{
			return "v";
		}
		else if(value == 50)
		{
			return "b";
		}
		else if(value == 51)
		{
			return "n";
		}
		else if(value == 52)
		{
			return "m";
		}
		else if(value == 53)
		{
			return "<";
		}
		else if(value == 54)
		{
			return ",";
		}
		else if(value == 55)
		{
			return ">";
		}
		else if(value == 56)
		{
			return ".";
		}
		else if(value == 57)
		{
			return "?";
		}
		else if(value == 58)
		{
			return "/";
		}
		else if(value == 59)
		{
			return "Ç";
		}
		else if(value == 60)
		{
			return "¿";
		}
		else if(value == 61)
		{
			return "À";
		}
		else if(value == 62)
		{
			return "Á";
		}
		else if(value == 63)
		{
			return "Â";
		}
		else if(value == 64)
		{
			return "Ã";
		}
		else if(value == 65)
		{
			return "Ä";
		}
		else if(value == 66)
		{
			return "Å";
		}
		else if(value == 67)
		{
			return "Æ";
		}
		else if(value == 68)
		{
			return "È";
		}
		else if(value == 69)
		{
			return "É";
		}
		else if(value == 70)
		{
			return "Ê";
		}
		else if(value == 71)
		{
			return "Ë";
		}
		else if(value == 72)
		{
			return "Ì";
		}
		else if(value == 73)
		{
			return "Í";
		}
		else if(value == 74)
		{
			return "Î";
		}
		else if(value == 75)
		{
			return "Ï";
		}
		else if(value == 76)
		{
			return "Ð";
		}
		else if(value == 77)
		{
			return "Ñ";
		}
		else if(value == 78)
		{
			return "Ò";
		}
		else if(value == 79)
		{
			return "Ó";
		}
		else if(value == 80)
		{
			return "Ô";
		}
		else if(value == 81)
		{
			return "Õ";
		}
		else if(value == 82)
		{
			return "Ö";
		}
		else if(value == 83)
		{
			return "Ø";
		}
		else if(value == 84)
		{
			return "Ù";
		}
		else if(value == 85)
		{
			return "Ú";
		}
		else if(value == 86)
		{
			return "Û";
		}
		else if(value == 87)
		{
			return "Ü";
		}
		else if(value == 88)
		{
			return "Ý";
		}
		else if(value == 89)
		{
			return "Þ";
		}
		else if(value == 90)
		{
			return "ß";
		}
		else if(value == 91)
		{
			return "à";
		}
		else if(value == 92)
		{
			return "á";
		}
		else if(value == 93)
		{
			return "â";
		}
		else if(value == 94)
		{
			return "ã";
		}
		else if(value == 95)
		{
			return "ä";
		}
		else if(value == 96)
		{
			return "å";
		}
		else if(value == 97)
		{
			return "æ";
		}
		else if(value == 98)
		{
			return "ç";
		}
		else if(value == 99)
		{
			return "è";
		}
		else if(value == 100)
		{
			return "é";
		}
		else if(value == 101)
		{
			return "ê";
		}
		else if(value == 102)
		{
			return "ë";
		}
		else if(value == 103)
		{
			return "ì";
		}
		else if(value == 104)
		{
			return "í";
		}
		else if(value == 105)
		{
			return "î";
		}
		else if(value == 106)
		{
			return "ï";
		}
		else if(value == 107)
		{
			return "ð";
		}
		else if(value == 108)
		{
			return "ñ";
		}
		else if(value == 109)
		{
			return "ò";
		}
		else if(value == 110)
		{
			return "ó";
		}
		else if(value == 111)
		{
			return "ô";
		}
		else if(value == 112)
		{
			return "õ";
		}
		else if(value == 113)
		{
			return "ö";
		}
		else if(value == 114)
		{
			return "÷";
		}
		else if(value == 115)
		{
			return "ø";
		}
		else if(value == 116)
		{
			return "ù";
		}
		else if(value == 117)
		{
			return "ú";
		}
		else if(value == 118)
		{
			return "û";
		}
		else if(value == 119)
		{
			return "ü";
		}
		else if(value == 120)
		{
			return "ý";
		}
		else if(value == 121)
		{
			return "ÿ";
		}
		else if(value == 122)
		{
			return "Œ";
		}
		else if(value == 123)
		{
			return "Š";
		}
		else if(value == 124)
		{
			return "š";
		}
		else if(value == 125)
		{
			return "¢";
		}
		else if(value == 126)
		{
			return "£";
		}
		else if(value == 127)
		{
			return "¤";
		}
		else if(value == 128)
		{
			return "¥";
		}
		else if(value == 129)
		{
			return "¦";
		}
		else if(value == 130)
		{
			return "§";
		}
		else if(value == 131)
		{
			return "©";
		}
		else if(value == 132)
		{
			return "ª";
		}
		else if(value == 133)
		{
			return "«";
		}
		else if(value == 134)
		{
			return "¬";
		}
		else if(value == 135)
		{
			return "®";
		}
		else if(value == 136)
		{
			return "°";
		}
		else if(value == 137)
		{
			return "±";
		}
		else if(value == 138)
		{
			return "²";
		}
		else if(value == 139)
		{
			return "¯";
		}
		else if(value == 140)
		{
			return "³";
		}
		else if(value == 141)
		{
			return "¶";
		}
		else if(value == 142)
		{
			return "¹";
		}
		else if(value == 143)
		{
			return "»";
		}
		else if(value == 144)
		{
			return "¼";
		}
		else if(value == 145)
		{
			return "½";
		}
		else if(value == 146)
		{
			return "¾";
		}
		else if(value == 147)
		{
			return "☺";
		}
		else if(value == 148)
		{
			return "☻";
		}
		else if(value == 149)
		{
			return "♥";
		}
		else if(value == 150)
		{
			return "♦";
		}
		else if(value == 151)
		{
			return "♣";
		}
		else if(value == 152)
		{
			return "♠";
		}
		else if(value == 153)
		{
			return "•";
		}
		else if(value == 154)
		{
			return "◘";
		}
		else if(value == 155)
		{
			return "○";
		}
		else if(value == 156)
		{
			return "◙";
		}
		else if(value == 157)
		{
			return "♀";
		}
		else if(value == 158)
		{
			return "♪";
		}
		else if(value == 159)
		{
			return "♫";
		}
		else if(value == 160)
		{
			return "☼";
		}
		else if(value == 161)
		{
			return "►";
		}
		else if(value == 162)
		{
			return "◄";
		}
		else if(value == 163)
		{
			return "↕";
		}
		else if(value == 164)
		{
			return "‼";
		}
		else if(value == 165)
		{
			return "L";
		}
		else if(value == 166)
		{
			return "↑";
		}
		else if(value == 167)
		{
			return "▬";
		}
		else if(value == 168)
		{
			return "↓";
		}
		else if(value == 169)
		{
			return "→";
		}
		else if(value == 170)
		{
			return "←";
		}
		else if(value == 171)
		{
			return "↔";
		}
		else if(value == 172)
		{
			return "▲";
		}
		else if(value == 173)
		{
			return "▼";
		}
		else if(value == 174)
		{
			return "╚";
		}
		else if(value == 175)
		{
			return "╟";
		}
		else if(value == 176)
		{
			return "╞";
		}
		else if(value == 177)
		{
			return "┼";
		}
		else if(value == 178)
		{
			return "├";
		}
		else if(value == 179)
		{
			return "┬";
		}
		else if(value == 180)
		{
			return "┴";
		}
		else if(value == 181)
		{
			return "╔";
		}
		else if(value == 182)
		{
			return "╩";
		}
		else if(value == 183)
		{
			return "╦";
		}
		else if(value == 184)
		{
			return "╠";
		}
		else if(value == 185)
		{
			return "═";
		}
		else if(value == 186)
		{
			return "╬";
		}
		else if(value == 187)
		{
			return "╧";
		}
		else if(value == 188)
		{
			return "╨";
		}
		else if(value == 189)
		{
			return "╤";
		}
		else if(value == 190)
		{
			return "╥";
		}
		else if(value == 191)
		{
			return "╙";
		}
		else if(value == 192)
		{
			return "╘";
		}
		else if(value == 193)
		{
			return "╒";
		}
		else if(value == 194)
		{
			return "╓";
		}
		else if(value == 195)
		{
			return "╫";
		}
		else if(value == 196)
		{
			return "╪";
		}
		else if(value == 197)
		{
			return "┘";
		}
		else if(value == 198)
		{
			return "█";
		}
		else if(value == 199)
		{
			return "▄";
		}
		else if(value == 200)
		{
			return "▌";
		}
		else if(value == 201)
		{
			return "▐";
		}
		else if(value == 202)
		{
			return "▀";
		}
		else if(value == 203)
		{
			return "π";
		}
		else if(value == 204)
		{
			return "Σ";
		}
		else if(value == 205)
		{
			return "α";
		}
		else if(value == 206)
		{
			return "σ";
		}
		else if(value == 207)
		{
			return "µ";
		}
		else if(value == 208)
		{
			return "Φ";
		}
		else if(value == 209)
		{
			return "Θ";
		}
		else if(value == 210)
		{
			return "Ω";
		}
		else if(value == 211)
		{
			return "δ";
		}
		else if(value == 212)
		{
			return "∞";
		}
		else if(value == 213)
		{
			return "ε";
		}
		else if(value == 214)
		{
			return "∩";
		}
		else if(value == 215)
		{
			return "≡";
		}
		else if(value == 216)
		{
			return "K";
		}
		else if(value == 217)
		{
			return "≥";
		}
		else if(value == 218)
		{
			return "≤";
		}
		else if(value == 219)
		{
			return "⌠";
		}
		else if(value == 220)
		{
			return "⌡";
		}
		else if(value == 221)
		{
			return "’";
		}
		else if(value == 222)
		{
			return "≈";
		}
		else if(value == 223)
		{
			return "√";
		}
		else if(value == 224)
		{
			return "ⁿ";
		}
		else if(value == 225)
		{
			return "■";
		}
		else if(value == 226)
		{
			return "™";
		}
		else if(value == 227)
		{
			return "ƒ";
		}
		else if(value == 228)
		{
			return "…";
		}
		else if(value == 229)
		{
			return "—";
		}
		else if(value == 230)
		{
			return "–";
		}
		else if(value == 231)
		{
			return "“";
		}
		else if(value == 232)
		{
			return "”";
		}
		else if(value == 233)
		{
			return "›";
		}
		else if(value == 234)
		{
			return "‹";
		}
		else if(value == 235)
		{
			return "€";
		}
		else if(value == 236)
		{
			return "‘";
		}
		else if(value == 237)
		{
			return "×";
		}
		else if(value == 238)
		{
			return "„";
		}
		else if(value == 239)
		{
			return "†";
		}
		else if(value == 240)
		{
			return "‡";
		}
		else if(value == 241)
		{
			return "¸";
		}
		else if(value == 242)
		{
			return "Ž";
		}
		else if(value == 243)
		{
			return "ž";
		}
		else if(value == 244)
		{
			return "Ÿ";
		}
		else if(value == 245)
		{
			return "‰";
		}
		else if(value == 246)
		{
			return "A";
		}
		else if(value == 247)
		{
			return "B";
		}
		else if(value == 248)
		{
			return "C";
		}
		else if(value == 249)
		{
			return "D";
		}
		else if(value == 250)
		{
			return "E";
		}
		else if(value == 251)
		{
			return "F";
		}
		else if(value == 252)
		{
			return "G";
		}
		else if(value == 253)
		{
			return "H";
		}
		else if(value == 254)
		{
			return "I";
		}
		else if(value == 255)
		{
			return "J";
		}
		else
			return " ";
	}
}