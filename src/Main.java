import java.io.File;
import java.io.IOException;

public class Main {

	public static void main(String[] args) throws IOException {
		//PicturePlayer pic = new PicturePlayer(new File("/tmp/monster.jpeg"), 50);
		PicturePlayer pic = new PicturePlayer(new File(args[0]));
		pic.play();

	}

}
