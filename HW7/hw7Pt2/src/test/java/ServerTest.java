import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class ServerTest {
    Song s1 = new Song(0,"myTitle","myArtist","myAlbum", 3);
    Song s2 = new Song(1,"Ride The Lightning","Metallica","Ride The Lightning", 5);
    ServerSongService server = new ServerSongService();

    public void serverTestSetup() {
        ArrayList<Song> songsList = new ArrayList<>();
        songsList.add(s1);
        songsList.add(s2);

        server.setSongs(songsList);
    }

    @Test
    public void searchByIDTest() {
        serverTestSetup();

        String expected = "Ride The Lightning";
        String actual = server.searchById(1).getTitle();
        assertEquals(expected, actual);
    }

    @Test
    public void searchByTitleTest() {
        serverTestSetup();

        ArrayList<Song> matches = (ArrayList<Song>) server.searchByTitle("Ride The Lightning");
        assertNotNull(matches);

        server.printMatches(matches);
    }

    @Test
    public void searchByAlbumTest() {
        serverTestSetup();

        ArrayList<Song> matches = (ArrayList<Song>) server.searchByAlbum("Ride The Lightning");
        assertNotNull(matches);

        server.printMatches(matches);
    }
}
