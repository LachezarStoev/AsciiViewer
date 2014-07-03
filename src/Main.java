import java.io.File;
import java.io.IOException;

public class Main {

	public static void main(String[] args) throws IOException {
		RenderUtils.CONSOLECOLUMNS = 50;
		PicturePlayer pic = new PicturePlayer(new File("/tmp/monster.jpeg"));
		// PicturePlayer pic = new PicturePlayer(new File(args[0]));
		pic.play();

	}

}
