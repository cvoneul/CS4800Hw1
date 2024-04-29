import java.util.ArrayList;
import java.util.List;

public class ServerSongService implements SongService {
    private ArrayList<Song> songs = new ArrayList<>();

    public ServerSongService() { }

    @Override
    public Song searchById(Integer songId) {
        sleep();
        for(Song s: songs) {
            if(s.getId() == songId) {
                return s;
            }
        }
        return null;
    }

    @Override
    public List<Song> searchByTitle(String title) {
        sleep();
        ArrayList<Song> matches = new ArrayList<>();
        for(Song s: songs) {
            if(s.getTitle().equals(title)) {
                matches.add(s);
            }
        }
        return matches;
    }

    @Override
    public List<Song> searchByAlbum(String album) {
        sleep();
        ArrayList<Song> matches = new ArrayList<>();
        for(Song s: songs) {
            if(s.getAlbum().equals(album)) {
                matches.add(s);
            }
        }
        return matches;
    }

    public ArrayList<Song> getSongs() {
        return songs;
    }

    public void setSongs(ArrayList<Song> songs) {
        this.songs = songs;
    }

    public void printMatches(ArrayList<Song> matches) {
        for(Song s: matches) {
            System.out.println(s.toString());
        }
    }

    public void sleep() {
        try {
            Thread.sleep(1000);
        }catch(Exception e) {}
    }
}
