import java.io.File;
import java.io.IOException;

public class Main {
	public static void main(String[] args) throws IOException {

		int dotIndex = args[0].lastIndexOf(".");
		String fileExtention = args[0].substring(dotIndex + 1);

		Player player = null;
		if (fileExtention.equals("png") || fileExtention.equals("jpg")
				|| fileExtention.equals("bmp") || fileExtention.equals("tiff")) {
			player = new PicturePlayer(new File(args[0]));
		} else if (fileExtention.equals("mp4")) {
			player = new VideoPlayer(new File(args[0]));
		} else if (fileExtention.equals("gif")) {
			player = new GifPlayer(new File(args[0]));
		}
		player.play();
	}

}
