package src;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import src.exceptions.MediaNotFoundException;
import src.exceptions.MediaRentedException;
import src.media.EBook;
import src.media.Media;
import src.media.MovieDVD;
import src.media.MusicCD;

public class Manager {
  private List<Media> mediaList;
  private String filePath;

  public Manager(String filePath) {
    this.mediaList = new ArrayList<>();
    this.filePath = filePath;
  }

  public void loadMedia() throws IOException {
    Path path = Paths.get(filePath);
    try (Stream<String> lines = Files.lines(path)) {
      List<Media> loadedMedia = lines.map(line -> {
        String[] data = line.split(",");
        int id = Integer.parseInt(data[1]);
        String title = data[2];
        int year = Integer.parseInt(data[3]);
        boolean isRented = Boolean.parseBoolean(data[4]);

        switch (data[0]) {
          case "EBook":
            int numChapters = Integer.parseInt(data[5]);
            return new EBook(id, title, year, isRented, numChapters);
          case "MovieDVD":
            double size = Double.parseDouble(data[5]);
            return new MovieDVD(id, title, year, isRented, size);
          case "MusicCD":
            int length = Integer.parseInt(data[5]);
            return new MusicCD(id, title, year, isRented, length);
          default:
            return null;
        }
      }).collect(Collectors.toList());
      this.mediaList.addAll(loadedMedia);
    }
  }

  public void saveMedia() throws IOException {
    List<String> lines = this.mediaList.stream().map(media -> {
      String mediaType = media.getClass().getSimpleName();
      String id = String.valueOf(media.getId());
      String title = media.getTitle();
      String year = String.valueOf(media.getYear());
      String isRented = String.valueOf(media.isRented());
      String specificProperty = "";

      if (media instanceof EBook) {
        specificProperty = String.valueOf(((EBook) media).getNumChapters());
      } else if (media instanceof MovieDVD) {
        specificProperty = String.valueOf(((MovieDVD) media).getSize());
      } else if (media instanceof MusicCD) {
        specificProperty = String.valueOf(((MusicCD) media).getLength());
      }

      return String.join(",", mediaType, id, title, year, isRented, specificProperty);
    }).collect(Collectors.toList());
    Path path = Paths.get(filePath);
    Files.write(path, lines);
  }

  public void addMedia(Media media) {
    mediaList.add(media);
  }

  public List<Media> findMediaByTitle(String title) {
    List<Media> result = new ArrayList<>();
    for (Media media : mediaList) {
      if (media.getTitle().equalsIgnoreCase(title)) {
        result.add(media);
      }
    }
    return result;
  }

  public double rentMedia(int id) {
    for (Media media : mediaList) {
      if (media.getId() == id) {
        if (media.isRented()) {
          throw new MediaRentedException(id);
        }
        media.setRented(true);
        try {
          saveMedia(); // update the file after renting a media item
        } catch (Exception e) {
          System.out.println("Failed to save media data to file.");
          System.out.println(e);
        }
        return media.getRentalFee();
      }
    }
    throw new MediaNotFoundException(id);
  }
}
