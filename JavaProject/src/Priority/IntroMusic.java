package Priority;

public class IntroMusic {
	public static final int SCREEN_WIDTH = 1200;
	public static final int SCREEN_HEIGHT = 720;
	
	 
	
	public static void main(String[] args) {
		new IntroMusic();
//		Music introMusic = new Music("bensound-creepy.mp3", true);
//		introMusic.start();
		
//		Music win = new Music("YEAH!.mp3", false);
//		win.start();
		
//		Music lose = new Music("MP_실패 불안 (jingle).mp3", false);
//		lose.start();
	
		Music playing = new Music("MP_Code Number B.mp3", true);
		playing.start();
		
//		playing.close();
	}
}
