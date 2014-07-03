import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class PicturePlayer extends FilePlayer {
	
	private BufferedImage image;
	private int consoleCols;

	public PicturePlayer(File path) throws IOException {
		this(path, 150);
	}

	public PicturePlayer(File path, int consoleCols) throws IOException {
		super.path = path;
		this.consoleCols = consoleCols;
		image = ImageIO.read(path);
	}

	public void setConsoleColumns(int cols) {
		this.consoleCols = cols;
	}

	public void setPath(File path) throws IOException {
		this.path = path;
		image = ImageIO.read(path);
	}

	@Override
	public void play() {
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
					printSymbol(getIntensitySubmatrix(i, j, scale));
				}

			}
			System.out.println();
		}
	}

	private int intensity(int x, int y) {
		Color col = new Color(image.getRGB(y, x), false);
		int red = col.getRed();
		int blue = col.getBlue();
		int green = col.getGreen();
		int intensity = (red + blue + green) / 3;
		return intensity;
	}

	private int getIntensitySubmatrix(int x, int y, int scale) {
		int intensity = 0;
		for (int i = x; i < x + scale; i++) {
			for (int j = y; j < y + scale; j++) {
				intensity += intensity(i, j);
			}
		}
		return intensity / (scale * scale);

	}

	private void printSymbol(int intensity) {
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
}
