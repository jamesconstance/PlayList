public class Main {
    public static void main(String[] args) {
        Album Chiaroscuro = new Album("Chiaroscuro", "Ocean Alley");
        Chiaroscuro.addSong("The Comedown", 4.44);
        Chiaroscuro.addSong("Confidence", 4.13);
        Chiaroscuro.addSong("Knees", 4.47);

        Album Dreamland = new Album("Dreamland", "Glass Animals");
        Dreamland.addSong("Tangerine", 3.21);
        Dreamland.addSong("Heat Waves", 3.59);
        Dreamland.addSong("Helium", 5.28);

        Playlist myPlaylist = new Playlist("My Playlist");
        myPlaylist.addSong(Dreamland.getSong("Heat Waves"));
        myPlaylist.addSong(Dreamland.getSong("Tangerine"));
        myPlaylist.addSong(Chiaroscuro.getSong("Confidence"));

        myPlaylist.play();

    }
}
