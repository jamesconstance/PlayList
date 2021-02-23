import java.util.ArrayList;
import java.util.Locale;

public class Album {
    private final String artist;
    private final String albumName;
    private final ArrayList<Song> songList;

    public Album(String albumName, String artist) {
        this.albumName = albumName;
        this.artist = artist;
        songList = new ArrayList<Song>();
    }

    public boolean addSong(String title, double duration) {
        if (findSong(title) == null) {
            songList.add(new Song(title, duration));
            return true;
        } else {
            System.out.println("Song already added");
            return false;
        }
    }

    private Song findSong(String title) {
        for (Song song : songList) {
            String songTitle = song.getTitle();
            if (songTitle.equalsIgnoreCase(title)) {
                return song;
            }
        }
        return null;
    }


    public Song getSong(String name) {
        for (Song song : songList) {
            String songName = song.getTitle().toLowerCase(Locale.ROOT);
            if (songName.equals(name.toLowerCase(Locale.ROOT))) {
                return song;
            }
        }
        return null;
    }

    public String getArtist() {
        return artist;
    }

    public String getAlbumName() {
        return albumName;
    }
}
