package com.driver;

import java.util.*;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("spotify")
public class SpotifyController {

    // Autowire will not work in this case, no need to change this and add autowire
    SpotifyService spotifyService = new SpotifyService();

    @PostMapping("/add-user")
    public String createUser(@RequestParam(name = "name") String name, @RequestParam(name = "mobile") String mobile){
        spotifyService.createUser(name, mobile);
        return "Success";
    }

    @PostMapping("/add-artist")
    public String createArtist(@RequestParam(name = "name") String name){
        spotifyService.createArtist(name);
        return "Success";
    }

    @PostMapping("/add-album")
    public String createAlbum(@RequestParam(name = "title") String title, @RequestParam(name = "artistName") String artistName){
        spotifyService.createAlbum(title, artistName);
        return "Success";
    }

    @PostMapping("/add-song")
    public String createSong(@RequestParam(name = "title") String title, @RequestParam(name = "albumName") String albumName, @RequestParam(name = "length") int length) {
        try {
            spotifyService.createSong(title, albumName, length);
            return "Success";
        } catch (Exception e) {
            return "Failed: " + e.getMessage();
        }
    }

    @PostMapping("/add-playlist-on-length")
    public String createPlaylistOnLength(@RequestParam(name = "mobile") String mobile, @RequestParam(name = "title") String title, @RequestParam(name = "length") int length) {
        try {
            spotifyService.createPlaylistOnLength(mobile, title, length);
            return "Success";
        } catch (Exception e) {
            return "Failed: " + e.getMessage();
        }
    }

    @PostMapping("/add-playlist-on-name")
    public String createPlaylistOnName(@RequestParam(name = "mobile") String mobile, @Request
