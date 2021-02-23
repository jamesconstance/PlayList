import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

public class Playlist {
    private static Scanner scanner = new Scanner(System.in);
    private String name;
    private boolean goingForward = true;
    LinkedList<Song> playlist;


    public Playlist(String name) {
        this.name = name;
        playlist = new LinkedList<Song>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static void printOptions() {
        System.out.println("Options:");
        System.out.printf("\t%s%n\t%s%n\t%s%n\t%s%n\t%s%n\t%s%n",
                "0 - Quit",
                "1 - Play Next",
                "2 - Play Previous",
                "3 - Replay",
                "4 - List Songs in Playlist",
                "5 - Print Options");
    }

    public void play() {
        ListIterator<Song> songListIterator = playlist.listIterator();
        printOptions();
        boolean exit = false;
        while (!exit) {
            System.out.print("Enter option (5 to see list of options)\n:");
            switch (getChoice()) {
                case 0:
                    exit = true;
                    break;
                case 1:
                    nextSong(songListIterator);
                    break;
                case 2:
                    previousSong(songListIterator);
                    break;
                case 3:
                    replaySong(songListIterator);
                    break;
                case 4:
                    printSongList();
                    break;
                case 5:
                    printOptions();
                    break;
            }
        }

    }

    private void printSongList() {
        for (Song song : playlist) {
            int trackNumber = playlist.indexOf(song) + 1;
            System.out.println(trackNumber + ". " + song);
        }
    }

    private int getChoice() {
        int choice = Integer.parseInt(scanner.nextLine());
        return choice;
    }

    public void addSong(Song song) {
        if (findSong(song.getTitle()) == null) {
            playlist.add(song);
            System.out.println(song.getTitle() + " added to " + name);
        } else {
            System.out.println("Song already added");
        }
    }

    private Song findSong(String title) {
        for (Song song : playlist) {
            String songTitle = song.getTitle();
            if (songTitle.equalsIgnoreCase(title)) {
                return song;
            }
        }
        return null;
    }


    public void removeCurrentSong(ListIterator songListIterator) {
        songListIterator.remove();
    }

    public void nextSong(ListIterator songListIterator) {
        if (!goingForward) {
            if (songListIterator.hasNext()) {
                songListIterator.next();
            }
        }
        if (songListIterator.hasNext()) {
            System.out.println("Now playing " + songListIterator.next());
            goingForward = true;
        } else {
            System.out.println("Reached end of playlist");
            goingForward = false;
        }
    }

    public void previousSong(ListIterator songListIterator) {
        if (goingForward) {
            if (songListIterator.hasPrevious()) {
                songListIterator.previous();
            }
        }
        if (songListIterator.hasPrevious()) {
            System.out.println("Now playing " + songListIterator.previous());
            goingForward = false;
        } else {
            System.out.println("Beginning of playlist");
            goingForward = true;
        }
    }

    public void replaySong(ListIterator songListIterator) {
        if (goingForward) {
            songListIterator.previous();
            System.out.println("Playing " + songListIterator.next());
        } else {
            songListIterator.next();
            System.out.println("Playing " + songListIterator.previous());
        }
    }
}
