import java.util.ArrayList;

public class Driver {
    public static void main(String[] args) {
        Song s1 = new Song(0,"myTitle","myArtist","myAlbum", 3);
        Song s2 = new Song(1, "Ride The Lightning","Metallica","Ride The Lightning", 5);
        Song s3 = new Song(2,"Mr Majestic","Calibre","Mr Majestic", 4);
        Song s4 = new Song(3,"Im So Sick","Flyleaf","Flyleaf", 3);
        Song s5 = new Song(4,"Hell Hath No Fury","Klute","The Emperor's New Clothes", 9);
        Song s6 = new Song(5,"Days Go By","High Contrast","Days Go By", 6);

        ArrayList<Song> songsList = new ArrayList<>();
        songsList.add(s1);
        songsList.add(s2);
        songsList.add(s3);
        songsList.add(s4);
        songsList.add(s5);
        songsList.add(s6);

        ServerSongService server = new ServerSongService();
        server.setSongs(songsList);

        ProxySongService proxy = new ProxySongService(server);

        Song song1 = proxy.searchById(1);
        Song song2 = proxy.searchByTitle("Im So Sick").get(0);
        Song song3 = proxy.searchByAlbum("The Emperor's New Clothes").get(0);

        System.out.println(song1.toString());
        System.out.println(song2.toString());
        System.out.println(song3.toString());
    }
}
