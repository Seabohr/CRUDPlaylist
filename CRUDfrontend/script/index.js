'use strict';

const baseURL = "http://localhost:8081";

axios.get(`${baseURL}/`)
.then(res => {
    console.log(res);
    console.log("data: ", res.data);
}).catch(err => console.log(err));

const playlistdiv = document.querySelector("#playlist")

const renderSongs = (song, location) => {
    const nextSong = document.createElement('div');
    nextSong.setAttribute("class", "row");

    const name = document.createElement('div');
    name.setAttribute("class", "col");
    name.innerText = `${song.songName}`;
    nextSong.appendChild(name);

    const art = document.createElement('div');
    art.setAttribute("class", "col");
    art.innerText = `${song.artist}`;
    nextSong.appendChild(art);

    const dur = document.createElement('div');
    dur.setAttribute("class", "col");
    dur.innerText = `${song.duration}`;
    nextSong.appendChild(dur);

    const options = document.createElement('div');
    options.setAttribute("class", "row");

    const updateDiv = document.createElement('div');
    updateDiv.setAttribute("class", "col");
    const updateButton = document.createElement('button');
    updateButton.innerText = "Update";
    updateButton.addEventListener('click', () => replaceSong(song.id));
    updateDiv.appendChild(updateButton);
    options.appendChild(updateDiv);

    const delDiv = document.createElement('div');
    delDiv.setAttribute("class", "col");
    const delButton = document.createElement('button');
    delButton.innerText = "Delete";
    delButton.addEventListener('click', () => deleteSong(song.id));
    delDiv.appendChild(delButton);
    options.appendChild(delDiv);

    location.appendChild(nextSong);
    location.appendChild(options);
}

const getAll = () => {
    axios.get(`${baseURL}/getAllSongs`)
    .then(res => {
        const music = res.data;
        playlistdiv.innerHTML = "";
        music.forEach(song => renderSongs(song, playlistdiv));
    }).catch(err => console.log(err));
}

const deleteSong = (id) => {
    axios.delete(`${baseURL}/deleteSong/${id}`)
    .then(res => {
        console.log(res);
        getAll();
    }).catch(err => console.log(err));
}

getAll();

const ups = document.querySelector("form#updateForm");
const replaceSong = (id) => {
    
    const rep = {
        songName: ups.songName.value,
        artist: ups.artist.value,
        duration: ups.duration.value
    }
    console.log("Data: ", rep);

    axios.put(`${baseURL}/replaceSong/${id}`, rep)
    .then(res => {
        console.log(res);
        getAll();
    }).catch(err => console.log(err));
}

document.querySelector("form#addSongForm").addEventListener('submit', function(e) {
    e.preventDefault();
    console.log("Add: ", this);

    const data = {
        songName: this.songName.value,
        artist: this.artist.value,
        duration: this.duration.value
    }
    console.log("Data: ", data);

    axios.post(`${baseURL}/addSong`, data)
    .then(res => {
        console.log(res);
        getAll();
        this.reset();
        this.songName.focus();
    }).catch(err => console.log(err));
})

const artistInput = document.querySelector("#fartistname");
const results = document.querySelector("#searchResult")
const searchButton = document.querySelector("#searchArtist")

const findByArtist = () => {

    const artistName = artistInput.value;
    axios.get(`${baseURL}/getArtist/${artistName}`)
    .then(res => {
        console.log("search");
        const music = res.data;
        results.innerHTML = "";
        music.forEach(music => renderSongs(music, results));
    }).catch(err => {
        console.log(err);
    })
}

searchButton.addEventListener('click', findByArtist)