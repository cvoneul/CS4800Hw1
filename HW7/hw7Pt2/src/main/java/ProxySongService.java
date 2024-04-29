import java.util.ArrayList;
import java.util.List;

public class ProxySongService implements SongService {
    private SongService songService;
    private ArrayList<Song> cache = new ArrayList<>();

    public ProxySongService(SongService songService) {
        this.songService = songService;
    }

    @Override
    public Song searchById(Integer songId) {
        for (Song s : cache) {
            if (s.getId() == songId) {
                return s;
            }
        }

        Song song = songService.searchById(songId);
        cache.add(song);
        return song;
    }

    @Override
    public List<Song> searchByTitle(String title) {
        ArrayList<Song> matches = new ArrayList<>();
        for (Song s : cache) {
            if (s.getTitle() == title) {
                matches.add(s);
            }
        }

        if(matches.size() > 0) {
            return matches;
        }

        matches = (ArrayList) songService.searchByTitle(title);
        for(Song s: matches) {
            if(!cache.contains(s)) {
                cache.add(s);
            }
        }

        return matches;
    }

    @Override
    public List<Song> searchByAlbum(String album) {
        ArrayList<Song> matches = new ArrayList<>();
        for(Song s: cache) {
            if(s.getAlbum() == album) {
                matches.add(s);
            }
        }

        if(matches.size() > 0) {
            return matches;
        }

        matches = (ArrayList) songService.searchByAlbum(album);
        for(Song s: matches) {
            if(!cache.contains(s)) {
                cache.add(s);
            }
        }

        return matches;
    }

    public SongService getSongService() {
        return songService;
    }

    public void setSongService(SongService songService) {
        this.songService = songService;
    }

    public ArrayList<Song> getCache() {
        return cache;
    }

    public void setCache(ArrayList<Song> cache) {
        this.cache = cache;
    }
}
