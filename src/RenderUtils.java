import java.awt.Color;
import java.awt.image.BufferedImage;


public class RenderUtils {
	public static final int CONSOLECOLUMNS = 150;

	private static int intensity(int x, int y, BufferedImage image) {
		Color col = new Color(image.getRGB(y, x), false);
		int red = col.getRed();
		int blue = col.getBlue();
		int green = col.getGreen();
		int intensity = (red + blue + green) / 3;
		return intensity;
	}

	private static int getIntensitySubmatrix(int x, int y, int scale,
			BufferedImage image) {
		int intensity = 0;
		for (int i = x; i < x + scale; i++) {
			for (int j = y; j < y + scale; j++) {
				intensity += RenderUtils.intensity(i, j, image);
			}
		}
		return intensity / (scale * scale);

	}

	private static void printSymbol(int intensity) {
		if (intensity > 210) {
			System.out.print("  ");
		} else if (intensity > 170) {
			System.out.print("..");
		} else if (intensity > 130) {
			System.out.print("--");
		} else if (intensity > 90) {
			System.out.print("**");
		} else if (intensity > 50) {
			System.out.print("$$");
		} else {
			System.out.print("##");
		}
	}

	public static void printImage(BufferedImage image) {
		printImage(image, CONSOLECOLUMNS);
	}

	private static void printImage(BufferedImage image, int consoleCols) {
		int height = image.getHeight();
		int width = image.getWidth();
		int scale = width / consoleCols;
		if (scale == 0) {
			scale = 1;
		} else if (width % consoleCols != 0) {
			scale += 1;
		}
		for (int i = 0; i < height; i += scale) {
			for (int j = 0; j < width; j += scale) {
				if (i + scale < height && j + scale < width) {
					printSymbol(getIntensitySubmatrix(i, j, scale, image));
				}

			}
			System.out.println();
		}
	}
	

}
