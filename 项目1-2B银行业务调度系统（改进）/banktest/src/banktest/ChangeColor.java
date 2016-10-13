package banktest;

import java.awt.Color;


public class ChangeColor {
	public static Color getChangeColor(String color){
		switch(color){
		case "黑色":
			return Color.BLACK; 
		case "蓝色":
			return Color.BLUE;
		case "青色":
			return Color.CYAN;
		case "暗灰":
			return Color.DARK_GRAY;
		case "灰色":
			return Color.GRAY;
		case "绿色":
			return Color.GREEN;
		case "亮灰":
			return Color.LIGHT_GRAY;
		case "品红":
			return Color.MAGENTA;
		case "橙色":
			return Color.ORANGE;
		case "粉色":
			return Color.PINK;
		case "红色":
			return Color.RED;
		case "白色":
			return Color.WHITE;
		case "黄色":
			return Color.YELLOW;
		}
		return Color.BLACK;
	}
}
