package APP;

import java.io.IOException;

public class MediaPlayer {

    public void cPlay(Boolean b, String fileName) throws IOException {

        ProcessBuilder pb = new ProcessBuilder("VLCpath", "filesPath"+fileName);
        Process VLCgo = pb.start();

    }
}

