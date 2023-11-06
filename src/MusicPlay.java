import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.io.File;

public class MusicPlay{
    private Clip clip;

    public MusicPlay(String filePath) {
        try {
            File audioFile = new File(filePath); // 음악 파일의 경로로 변경해주세요.
            clip = AudioSystem.getClip();
            clip.open(AudioSystem.getAudioInputStream(audioFile));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void musicPlay() {
        if (clip != null) {
            clip.start();
        }
    }

    public void musicStop() {
        if (clip != null && clip.isRunning()) {
            clip.stop();
            clip.close();//must be closed.
        }
    }
}
