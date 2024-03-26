package com.driver;

import java.util.*;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("spotify")
public class SpotifyController {

    SpotifyService spotifyService = new SpotifyService();

    @PostMapping("/add-user")
    public String createUser(@RequestParam(name = "name") String name, @RequestParam(name = "mobile") String mobile){
        return spotifyService.createUser(name, mobile);
    }

    @PostMapping("/add-artist")
    public String createArtist(@RequestParam(name = "name") String name){
        return spotifyService.createArtist(name);
    }

    @PostMapping("/add-album")
    public String createAlbum(@RequestParam(name = "title") String title, @RequestParam(name = "artistName") String artistName){
        return spotifyService.createAlbum(title, artistName);
    }

    @PostMapping("/add-song")
    public String createSong(@RequestParam(name = "title") String title, @RequestParam(name = "albumName") String albumName, @RequestParam(name = "length") int length) throws Exception{
        return spotifyService.createSong(title, albumName, length);
    }

    @PostMapping("/add-playlist-on-length")
    public String createPlaylistOnLength(@RequestParam(name = "mobile") String mobile, @RequestParam(name = "title") String title, @RequestParam(name = "length") int length) throws Exception{
        return spotifyService.createPlaylistOnLength(mobile, title, length);
    }

    @PostMapping("/add-playlist-on-name")
    public String createPlaylistOnName(@RequestParam(name = "mobile") String mobile, @RequestParam(name = "title") String title, @RequestParam(name = "songTitles") List<String> songTitles) throws Exception{
        return spotifyService.createPlaylistOnName(mobile, title, songTitles);
    }

    @PutMapping("/find-playlist")
    public String findPlaylist(@RequestParam(name = "mobile") String mobile, @RequestParam(name = "playlistTitle") String playlistTitle) throws Exception{
        return spotifyService.findPlaylist(mobile, playlistTitle);
    }

    @PutMapping("/like-song")
    public String likeSong(@RequestParam(name = "mobile") String mobile, @RequestParam(name = "songTitle") String songTitle) throws Exception{
        return spotifyService.likeSong(mobile, songTitle);
    }

    @GetMapping("/popular-artist")
    public String mostPopularArtist(){
        return spotifyService.mostPopularArtist();
    }

    @GetMapping("/popular-song")
    public String mostPopularSong(){
        return spotifyService.mostPopularSong();
    }
}

