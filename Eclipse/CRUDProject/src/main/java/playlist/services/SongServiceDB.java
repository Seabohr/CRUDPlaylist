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
		return this.repo.save(s);
	}

	@Override
	public List<Song> getAllSongs() {
		return this.repo.findAll();
	}

	@Override
	public Song getSongById(int i) {
		return this.repo.findById(i).get();
	}

	@Override
	public List<Song> getByArtist(String artist) {
		return this.repo.findByArtist(artist);
	}

	@Override
	public Song replaceSong(int i, Song s) {
		Song found = this.repo.findById(i).get();
		found.setSongName(s.getSongName());
		found.setArtist(s.getArtist());
		found.setDuration(s.getDuration());
		Song replaced = this.repo.save(found);
		return replaced;
	}

	@Override
	public String deleteSong(int i) {
		this.repo.deleteById(i);
		return "Deleted: " + i;
	}

}
