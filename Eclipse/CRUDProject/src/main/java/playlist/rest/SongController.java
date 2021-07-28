package playlist.rest;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import playlist.services.SongService;

@RestController
@CrossOrigin
public class SongController {

	private SongService service;

	public SongController(SongService service) {
		super();
		this.service = service;
	}

}
