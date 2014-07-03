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
		image = ImageIO.read(super.path);
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
					RenderUtils.printSymbol(RenderUtils.getIntensitySubmatrix(
							i, j, scale, image));
				}

			}
			System.out.println();
		}
	}


}
