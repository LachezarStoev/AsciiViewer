import java.io.File;
import java.io.IOException;

public class Main {

	public static void main(String[] args) throws IOException {
		RenderUtils.CONSOLECOLUMNS = 50;
//		PicturePlayer pic = new PicturePlayer(new File("/home/svetla/tmp/butterfly.jpeg"));
//		PicturePlayer pic = new PicturePlayer(new File(args[0]));
//		pic.play();
		
		GifPlayer gif = new GifPlayer(new File(args[0]));
//		GifPlayer gif = new GifPlayer(new File("/home/svetla/tmp/parrot.gif"));
		gif.play();

	}

}
