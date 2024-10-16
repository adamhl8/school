package src;

import java.util.List;
import java.util.Scanner;

import src.exceptions.MediaNotFoundException;
import src.exceptions.MediaRentedException;
import src.media.Media;

public class MediaRentalSystem {
  private static Manager manager;
  private static Scanner scanner = new Scanner(System.in);

  public static void main(String[] args) {
    loadMediaFromUserPath();

    while (true) {
      System.out.println("""
          Main Menu
          (1) Find media by title
          (2) Rent media
          (3) Load media data
          (4) Exit""");
      String selection = scanner.nextLine().strip();

      System.out.println();
      switch (selection) {
        case "1":
          findMediaByTitle();
          break;
        case "2":
          rentMedia();
          break;
        case "3":
          loadMediaFromUserPath();
          break;
        case "4":
          System.out.println("Exiting...");
          scanner.close();
          return;
        default:
          System.out.println("Invalid selection.\n");
      }
    }
  }

  private static void findMediaByTitle() {
    System.out.println("Enter the title of the media:");
    String title = scanner.nextLine();
    List<Media> mediaList = manager.findMediaByTitle(title);
    if (mediaList.isEmpty()) {
      System.out.println("\nNo media found with the title '" + title + "'.\n");
    } else {
      System.out.println("\nFound the following media:\n");
      for (Media media : mediaList) {
        System.out.println(media + "\n");
      }
    }
  }

  private static void rentMedia() {
    System.out.println("Enter the ID of the media to rent:");
    int id = scanner.nextInt();
    scanner.nextLine();
    try {
      double fee = manager.rentMedia(id);
      System.out.println(String.format("%nMedia rented successfully. The rental fee is $%.2f.%n", fee));
    } catch (MediaNotFoundException | MediaRentedException e) {
      System.out.println("\n" + e.getMessage() + "\n");
    }
  }

  private static void loadMediaFromUserPath() {
    while (true) {
      System.out.println("Enter the file path of the media data:");
      String filePath = scanner.nextLine();
      manager = new Manager(filePath);
      try {
        manager.loadMedia();
        System.out.println("Media data loaded successfully.\n");
        break;
      } catch (Exception e) {
        System.out.println("Failed to load media data from file.");
        System.out.println(e + "\n");
      }
    }
  }
}
