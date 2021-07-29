package playlist.rest;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import playlist.data.Song;
import playlist.services.SongService;

@RestController
@CrossOrigin
public class SongController {

	private SongService service;

	public SongController(SongService service) {
		super();
		this.service = service;
	}

	@GetMapping("/")
	public String hello() {
		return "Hello there";
	}

	@PostMapping("/addSong")
	public ResponseEntity<Song> addSong(@RequestBody Song s) {
		Song made = this.service.addSong(s);
		return new ResponseEntity<>(made, HttpStatus.CREATED);
	}

	@GetMapping("/getAllSongs")
	public ResponseEntity<List<Song>> getAllSongs() {
		List<Song> found = this.service.getAllSongs();
		return new ResponseEntity<>(found, HttpStatus.OK);
	}

	@GetMapping("/getSong/{i}")
	public ResponseEntity<Song> getSong(@PathVariable int i) {
		Song found = this.service.getSongById(i);
		return new ResponseEntity<>(found, HttpStatus.OK);
	}

	@GetMapping("/getArtist/{artist}")
	public ResponseEntity<List<Song>> getArtist(@PathVariable String artist) {
		List<Song> found = this.service.getByArtist(artist);
		return new ResponseEntity<>(found, HttpStatus.OK);
	}

	@PutMapping("/replaceSong/{i}")
	public ResponseEntity<Song> replaceSong(@PathVariable int i, @RequestBody Song s) {
		Song replaced = this.service.replaceSong(i, s);
		return new ResponseEntity<>(replaced, HttpStatus.ACCEPTED);
	}

	@DeleteMapping("/deleteSong/{i}")
	public ResponseEntity<String> deleteSong(@PathVariable int i) {
		String deleted = this.service.deleteSong(i);
		return new ResponseEntity<>(deleted, HttpStatus.ACCEPTED);
	}
}
