package playlist.services;

import java.util.List;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import playlist.data.Song;
import playlist.data.repo.SongRepo;

@Service
@Primary
public class SongServiceDB implements SongService {

	private SongRepo repo;

	public SongServiceDB(SongRepo repo) {
		super();
		this.repo = repo;
	}

	@Override
	public Song addSong(Song s) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Song> getAllSongs() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Song getSongById(int i) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Song> getByArtist(String artist) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Song replaceSong(int i, Song s) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String deleteSong(int i) {
		// TODO Auto-generated method stub
		return null;
	}

}
