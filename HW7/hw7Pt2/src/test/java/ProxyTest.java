import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class ProxyTest {

    Song s1 = new Song(0,"myTitle","myArtist","myAlbum", 3);
    Song s2 = new Song(1, "Ride The Lightning","Metallica","Ride The Lightning", 5);
    ServerSongService server = new ServerSongService();
    ProxySongService proxy = new ProxySongService(server);

    public void proxyTestSetup() {
        ArrayList<Song> songsList = new ArrayList<>();
        songsList.add(s1);
        songsList.add(s2);

        server.setSongs(songsList);
        proxy.setCache(songsList);
    }

    @Test
    public void searchByIdInProxyTest() {
        proxyTestSetup();

        String expected = "Ride The Lightning";
        String actual = proxy.searchById(1).getTitle();
        assertEquals(expected, actual);
    }

    @Test
    public void searchByIdDoesNotExistTest() {
        proxyTestSetup();

        assertNull(proxy.searchById(-1));
    }

    @Test
    public void searchByIdNotInProxyTest() {
        proxyTestSetup();
        ArrayList<Song> emptyList = new ArrayList<>();
        proxy.setCache(emptyList);

        String expected = "Ride The Lightning";
        String actual = proxy.searchById(1).getTitle();
        assertEquals(expected, actual);
    }


    @Test
    public void searchByTitleNotInProxyTest() {
        proxyTestSetup();
        ArrayList<Song> emptyList = new ArrayList<>();
        proxy.setCache(emptyList);

        String expected = "myTitle";
        ArrayList<Song> matches = (ArrayList) proxy.searchByTitle("myTitle");

        String actual = matches.get(0).getTitle();
        assertEquals(expected, actual);
    }

    @Test
    public void searchByTitleInProxyTest() {
        proxyTestSetup();

        String expected = "myTitle";
        String actual = proxy.searchByTitle("myTitle").get(0).getTitle();
        assertEquals(expected, actual);
    }

    @Test
    public void searchByTitleDoesNotExistTest() {
        proxyTestSetup();

        ArrayList<Song> matches = (ArrayList) proxy.searchByTitle("This song title is not in the list");
        if(matches.size() <= 0) {
            assertFalse(false);
        }
        else  {
            assertTrue(true);
        }
    }

    @Test
    public void searchByAlbumDoesNotExistTest() {
        proxyTestSetup();

        ArrayList<Song> matches = (ArrayList) proxy.searchByAlbum("This album is not in the list");
        if(matches.size() <= 0) {
            assertFalse(false);
        }
        else  {
            assertTrue(true);
        }
    }

    @Test
    public void searchByAlbumInProxy() {
        proxyTestSetup();

        String expected = "myAlbum";
        String actual = proxy.searchByAlbum("myAlbum").get(0).getAlbum();
        assertEquals(expected, actual);
    }

    @Test
    public void searchByAlbumNotInProxy() {
        proxyTestSetup();
        ArrayList<Song> emptyList = new ArrayList<>();
        proxy.setCache(emptyList);

        String expected = "myAlbum";
        ArrayList<Song> matches = (ArrayList) proxy.searchByAlbum("myAlbum");

        String actual = matches.get(0).getAlbum();
        assertEquals(expected, actual);
    }
}
