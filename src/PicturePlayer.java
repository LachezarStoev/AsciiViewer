import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class PicturePlayer extends FilePlayer {
	
	private BufferedImage image;

	public PicturePlayer(File path) throws IOException {
		super.path = path;
		image = ImageIO.read(super.path);
	}

	public void setPath(File path) throws IOException {
		this.path = path;
		image = ImageIO.read(path);
	}

	@Override
	public void play() {
		RenderUtils.printImage(image);
	}


}
