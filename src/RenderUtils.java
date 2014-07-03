import java.awt.Color;
import java.awt.image.BufferedImage;


public class RenderUtils {
	public static int intensity(int x, int y, BufferedImage image) {
		Color col = new Color(image.getRGB(y, x), false);
		int red = col.getRed();
		int blue = col.getBlue();
		int green = col.getGreen();
		int intensity = (red + blue + green) / 3;
		return intensity;
	}

	public static int getIntensitySubmatrix(int x, int y, int scale,
			BufferedImage image) {
		int intensity = 0;
		for (int i = x; i < x + scale; i++) {
			for (int j = y; j < y + scale; j++) {
				intensity += RenderUtils.intensity(i, j, image);
			}
		}
		return intensity / (scale * scale);

	}

	public static void printSymbol(int intensity) {
		if (intensity > 240) {
			System.out.print(" ");
		} else if (intensity > 200) {
			System.out.print(".");
		} else if (intensity > 160) {
			System.out.print("*");
		} else if (intensity > 120) {
			System.out.print("+");
		} else if (intensity > 80) {
			System.out.print("X");
		} else {
			System.out.print("M");
		}
	}

	public static void printImage(BufferedImage image, int consoleCols) {

	}
}
