# SkyList

SkyList is a modern Android local music player by **SSteveXD** with a redesigned Material 3 interface and architecture inspired by MetroList playback concepts.

## Features
- Local library scanning (songs, albums, artists)
- Background playback service with queue controls
- Playlist-ready library structure and search screen
- Karaoke-style synchronized LRC lyrics and line highlighting
- Listen Together room sync scaffolding via Firebase Realtime Database
- Listening statistics dashboard (total time, top songs/artists/albums, weekly summary)
- Discord Rich Presence integration abstraction for now-playing updates

## Build
```bash
./gradlew assembleDebug
```

APK output:
`app/build/outputs/apk/debug/app-debug.apk`

## Credits
SkyList acknowledges the following open-source inspirations:

- MetroList
- InnerTune
- OuterTune
- Kizzy
- Better Lyrics
- SimpMusic Lyrics API
- metroserver
- MusicRecognizer

> SkyList does not copy branding, logos, or visual assets from MetroList.
