package banktest;

import java.awt.Color;


public class ChangeColor {
	public static Color getChangeColor(String color){
		switch(color){
		case "��ɫ":
			return Color.BLACK; 
		case "��ɫ":
			return Color.BLUE;
		case "��ɫ":
			return Color.CYAN;
		case "����":
			return Color.DARK_GRAY;
		case "��ɫ":
			return Color.GRAY;
		case "��ɫ":
			return Color.GREEN;
		case "����":
			return Color.LIGHT_GRAY;
		case "Ʒ��":
			return Color.MAGENTA;
		case "��ɫ":
			return Color.ORANGE;
		case "��ɫ":
			return Color.PINK;
		case "��ɫ":
			return Color.RED;
		case "��ɫ":
			return Color.WHITE;
		case "��ɫ":
			return Color.YELLOW;
		}
		return Color.BLACK;
	}
}
