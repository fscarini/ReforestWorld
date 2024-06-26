package RW.forms;
import uk.co.caprica.vlcj.factory.MediaPlayerFactory;
import uk.co.caprica.vlcj.player.base.MediaPlayer;
import uk.co.caprica.vlcj.player.base.MediaPlayerEventAdapter;
import uk.co.caprica.vlcj.player.embedded.EmbeddedMediaPlayer;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class InicioTela extends JPanel {
    
    private InicioTela inicioTela;
    private List<VideosOverlay> locations;
    private int index = 0;
    private InicioOverlay homeOverlay;

    private MediaPlayerFactory factory;
    private EmbeddedMediaPlayer mediaPlayer;

    public InicioTela() {
        init();
        testData();
    }

    private void init() {
        factory = new MediaPlayerFactory();
        mediaPlayer = factory.mediaPlayers().newEmbeddedMediaPlayer();
        Canvas canvas = new Canvas();
        mediaPlayer.videoSurface().set(factory.videoSurfaces().newVideoSurface(canvas));
        mediaPlayer.events().addMediaPlayerEventListener(new MediaPlayerEventAdapter() {
            @Override
            public void timeChanged(MediaPlayer mediaPlayer, long newTime) {
                if (newTime >= mediaPlayer.status().length() - 1000) {
                    mediaPlayer.controls().setPosition(0);
                }
            }
        });
        setLayout(new BorderLayout());
        add(canvas);
    }

    private void testData() {
        locations = new ArrayList<>();
        locations.add(new VideosOverlay("",
                "Onde cada árvore é um novo começo.",            
                "src/main/resources/imagens/video1.mp4"));

        locations.add(new VideosOverlay("",
                "Semeando mudança para um amanhã sustentável.",
                "src/main/resources/imagens/video2.mp4"));

        locations.add(new VideosOverlay("",
                "A cada árvore, um legado de esperança.",
                "src/main/resources/imagens/video3.mp4"));
    }

    public void initOverlay(JFrame frame) {
        homeOverlay = new InicioOverlay(frame, this, locations);
        homeOverlay.getOverlay().setEventHomeOverlay(index1 -> {
            play(index1);
        });
        mediaPlayer.overlay().set(homeOverlay);
        mediaPlayer.overlay().enable(true);
    }

    public void play(int index) {
        this.index = index;
        VideosOverlay location = locations.get(index);
        if (mediaPlayer.status().isPlaying()) {
            mediaPlayer.controls().stop();
        }
        mediaPlayer.media().play(location.getVideoPath());
        mediaPlayer.controls().play();
        homeOverlay.getOverlay().setIndex(index);
    }

    public void stop() {
        mediaPlayer.controls().stop();
        mediaPlayer.release();
        factory.release();
    }

    void dispose() {
        mediaPlayer.release();
        factory.release();
        homeOverlay.closeMainWindow();
    }
    
}
