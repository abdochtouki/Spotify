import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class SpotifyApp {

    public static void clearTerminal() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public static void printSpotifyLogo() {
        System.out.println("\u001B[32m\n               ⢀⣠⣤⣤⣶⣶⣶⣶⣤⣤⣄⡀\n            ⢀⣤⣾⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣷⣤⡀\n        ⠀⠀⠀⣴⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣦\n        ⠀⢀⣾⣿⡿⠿⠛⠛⠛⠉⠉⠉⠉⠛⠛⠛⠿⠿⣿⣿⣿⣿⣿⣷⡀\n        ⠀⣾⣿⣿⣇⠀⣀⣀⣠⣤⣤⣤⣤⣤⣀⣀⠀⠀⠀⠈⠙⠻⣿⣿⣷ \n        ⢠⣿⣿⣿⣿⡿⠿⠟⠛⠛⠛⠛⠛⠛⠻⠿⢿⣿⣶⣤⣀⣠⣿⣿⣿⡄\n        ⢸⣿⣿⣿⣿⣇⣀⣀⣤⣤⣤⣤⣤⣄⣀⣀⠀⠀⠉⠛⢿⣿⣿⣿⣿⡇  sPOOtify\n        ⠘⣿⣿⣿⣿⣿⠿⠿⠛⠛⠛⠛⠛⠛⠿⠿⣿⣶⣦⣤⣾⣿⣿⣿⣿⠃  by: @A.CHTOUKI\n        ⠀⢿⣿⣿⣿⣿⣤⣤⣤⣤⣶⣶⣦⣤⣤⣄⡀⠈⠙⣿⣿⣿⣿⣿⡿\n        ⠀⠈⢿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣷⣾⣿⣿⣿⣿⡿⠁\n        ⠀⠀⠀⠻⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⠟\n        ⠀⠀⠀⠀⠈⠛⢿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡿⠛⠁\n        ⠀⠀⠀⠀⠀⠀⠀⠈⠙⠛⠛⠿⠿⠿⠿⠛⠛⠋⠁⠀⠀⠀⠀⠀⠀⠀\n\n");
    }

    public static void pressEnter(Scanner dataScanner) {
        System.out.println("==================================================================================+++---");
        System.out.println("Press 'ENTER' to go to menu");
        System.out.println("==================================================================================+++---");
        dataScanner.nextLine();
    }

    public static void closeScanner(Scanner scanner) {
        scanner.close();
    }

    public static SpootifyMusic createMusic(Scanner dataScanner) {
        Scanner stringSplitter;
        String title;
        int duration;
        List<String> songwriters = new ArrayList<String>();
        String songwritersInput;
        List<String> performers = new ArrayList<String>();
        String performersInput;
        String genre;

        System.out.println("Title:");
        title = dataScanner.nextLine();

        System.out.println("Duration (in seconds):");
        duration = dataScanner.nextInt();
        dataScanner.nextLine();

        System.out.println("Genre:");
        genre = dataScanner.nextLine();

        System.out.println("Songwriters (separate with ;):");
        songwritersInput = dataScanner.nextLine();

        System.out.println("Performers (separate with ;):");
        performersInput = dataScanner.nextLine();

        stringSplitter = new Scanner(songwritersInput);
        stringSplitter.useDelimiter(";");

        while(stringSplitter.hasNext()) {
            songwriters.add(stringSplitter.next().trim());
        }
        stringSplitter.close();

        stringSplitter = new Scanner(performersInput);
        stringSplitter.useDelimiter(";");

        while(stringSplitter.hasNext()) {
            performers.add(stringSplitter.next().trim());
        }
        stringSplitter.close();

        return new SpootifyMusic(title, duration, songwriters, performers, genre);
    }

    public static SpootifyPodcast createPodcast(Scanner dataScanner) {
        String title;
        int duration;
        String host;
        String description;

        System.out.println("Title:");
        title = dataScanner.nextLine();

        System.out.println("Duration (in seconds):");
        duration = dataScanner.nextInt();
        dataScanner.nextLine();

        System.out.println("Host:");
        host = dataScanner.nextLine();

        System.out.println("Description:");
        description = dataScanner.nextLine();

        return new SpootifyPodcast(title, duration, host, description);
    }

    public static SpootifyAudiobook createAudiobook(Scanner dataScanner) {
        Scanner stringSplitter;
        String title;
        int duration;
        List<String> authors = new ArrayList<String>();
        String authorsInput;
        String narrator;
        String publisher;
        String synopsis;

        System.out.println("Title:");
        title = dataScanner.nextLine();

        System.out.println("Duration (in seconds):");
        duration = dataScanner.nextInt();
        dataScanner.nextLine();

        System.out.println("Publisher:");
        publisher = dataScanner.nextLine();

        System.out.println("Authors (separate with ;):");
        authorsInput = dataScanner.nextLine();

        System.out.println("Narrator:");
        narrator = dataScanner.nextLine();

        System.out.println("Synopsis:");
        synopsis = dataScanner.nextLine();

        stringSplitter = new Scanner(authorsInput);
        stringSplitter.useDelimiter(";");

        while(stringSplitter.hasNext()) {
            authors.add(stringSplitter.next().trim());
        }
        stringSplitter.close();

        return new SpootifyAudiobook(title, duration, narrator, synopsis, authors, publisher);
    }

    public static void addToPlaylist(Scanner dataScanner, String playlistTitle, SpootifyMenu menu) {
        boolean wantToAdd = true;
        int userChoice;

        while(wantToAdd) {
            clearTerminal();
            printSpotifyLogo();
            System.out.println("What type of content would you like to add?");
            System.out.println("==================================================================================+++---");
            System.out.println("1. Music | 2. Podcast | 3. Audiobook");
            userChoice = dataScanner.nextInt();
            dataScanner.nextLine();

            switch (userChoice) {
                case 1:
                    try {
                        menu.getPlaylist(playlistTitle).addContent(createMusic(dataScanner));
                        System.out.println("Music added successfully!");
                    } catch(InputMismatchException e) {
                        clearTerminal();
                        System.out.println("Invalid input!\nCould not add content!\nPress ENTER to continue");
                        dataScanner.nextLine();
                        clearTerminal();
                    }
                    break;

                case 2:
                    try {
                        menu.getPlaylist(playlistTitle).addContent(createPodcast(dataScanner));
                        System.out.println("Podcast added successfully!");
                    } catch(InputMismatchException e) {
                        clearTerminal();
                        System.out.println("Invalid input!\nCould not add content!\nPress ENTER to continue");
                        dataScanner.nextLine();
                        clearTerminal();
                    }
                    break;

                case 3:
                    try {
                        menu.getPlaylist(playlistTitle).addContent(createAudiobook(dataScanner));
                        System.out.println("Audiobook added successfully!");
                    } catch(InputMismatchException e) {
                        clearTerminal();
                        System.out.println("Invalid input!\nCould not add content!\nPress ENTER to continue");
                        dataScanner.nextLine();
                        clearTerminal();
                    }
                    break;

                default:
                    System.out.println("Invalid option!");
                    break;
            }

            System.out.println("==================================================================================+++---");
            System.out.println("Do you want to add more content?");
            System.out.println("==================================================================================+++---");
            System.out.println("1. Yes | 2. Back to menu");
            userChoice = dataScanner.nextInt();
            dataScanner.nextLine();
            if(userChoice != 1) wantToAdd = false;
        }
    }

    public static void showPlaylistContent(Scanner dataScanner, String playlistTitle, SpootifyMenu menu) {
        List<SpootifyContent> filteredList = new ArrayList<SpootifyContent>();
        int userChoice;
        int counter;

        clearTerminal();
        System.out.println("What would you like to list?");
        System.out.println("==================================================================================+++---");
        System.out.println("1. Music | 2. Podcasts | 3. Audiobooks | 4. All");
        System.out.println("==================================================================================+++---");
        userChoice = dataScanner.nextInt();
        dataScanner.nextLine();

        switch(userChoice) {
            case 1:
                filteredList = menu.getPlaylist(playlistTitle).filterBy(true, false, false);
                break;
            case 2:
                filteredList = menu.getPlaylist(playlistTitle).filterBy(false, true, false);
                break;
            case 3:
                filteredList = menu.getPlaylist(playlistTitle).filterBy(false, false, true);
                break;
            case 4:
                filteredList = menu.getPlaylist(playlistTitle).getContentList();
                break;
            default:
                System.out.println("Invalid option!");
                pressEnter(dataScanner);
                return;
        }

        counter = 1;

        clearTerminal();
        if(!filteredList.isEmpty()) {
            System.out.println("==================================================================================+++---");
            System.out.println("Here are your contents");
            System.out.println("==================================================================================+++---");
            for (SpootifyContent content : filteredList) {
                System.out.printf("%d | %s\n", counter, content.toString());
                counter += 1;
            }
        } else {
            System.out.println("No content meets this requirement :(");
        }
        pressEnter(dataScanner);
    }

    public static void createPlaylist(Scanner dataScanner, SpootifyMenu menu) {
        String playlistTitle;

        printSpotifyLogo();
        System.out.println("==================================================================================+++---");
        System.out.println("Enter the playlist name");
        System.out.println("==================================================================================+++---");
        playlistTitle = dataScanner.nextLine();

        if(!menu.playlistExists(playlistTitle)) {
            menu.addPlaylist(playlistTitle);
            System.out.println("Playlist " + playlistTitle + " was created successfully!\n");
        } else {
            System.out.println("A playlist named " + playlistTitle + " already exists!");
        }

        pressEnter(dataScanner);
    }

    public static void deletePlaylist(Scanner dataScanner, SpootifyMenu menu) {
        String playlistTitle;

        printSpotifyLogo();
        System.out.println("==================================================================================+++---");
        System.out.println("Enter the playlist name");
        System.out.println("==================================================================================+++---");
        playlistTitle = dataScanner.nextLine();

        if(menu.playlistExists(playlistTitle) && !playlistTitle.equals("library")) {
            menu.removePlaylist(playlistTitle);
            System.out.println("Playlist " + playlistTitle + " was removed successfully!\n");
        } else if(playlistTitle.equals("library")) {
            System.out.println("Cannot delete the library!");
        } else {
            System.out.println("No playlist named " + playlistTitle + " exists!");
        }

        pressEnter(dataScanner);
    }

    public static void showPlaylists(Scanner dataScanner, SpootifyMenu menu) {
        int counter = 1;

        if(menu.getPlaylists().size() > 1) {
            System.out.println("==================================================================================+++---");
            System.out.println("Here are your playlists");
            System.out.println("==================================================================================+++---");

            for(String playlistTitle : menu.getPlaylists().keySet()) {
                if(!playlistTitle.equals("library")) {
                    System.out.printf("%d | %s\n", counter, playlistTitle);
                    counter += 1;
                }
            }
        } else {
            System.out.println("You don't have any playlists :(");
        }

        pressEnter(dataScanner);
    }

    public static void main(String[] args) {
        SpootifyMenu myMenu = new SpootifyMenu();
        Scanner dataScanner = new Scanner(System.in);
        int userChoice = 0;
        String playlistTitle;

        // Creating playlist with user data
        clearTerminal();
        printSpotifyLogo();
        System.out.println("Hello, welcome to sPOOtify!\n");
        pressEnter(dataScanner);

        while(userChoice != 8) {
            clearTerminal();
            printSpotifyLogo();
            System.out.println("Select an option");
            System.out.println("==================================================================================+++---");
            System.out.println("1. Fill your Library              | 2. List Library contents\n3. Display Library information    | 4. Create a new Playlist");
            System.out.println("5. Delete a Playlist              | 6. Add content to Playlist\n7. List Playlists                 | 8. Exit");
            System.out.println("==================================================================================+++---");

            try {
                userChoice = dataScanner.nextInt();
            } catch (InputMismatchException e) {
                userChoice = 0; // Invalid choice
            }
            dataScanner.nextLine();

            clearTerminal();
            printSpotifyLogo();

            switch(userChoice) {
                // Add content to library
                case 1:
                    addToPlaylist(dataScanner, "library", myMenu);
                    break;

                // List library contents
                case 2:
                    showPlaylistContent(dataScanner, "library", myMenu);
                    break;

                // Display library information
                case 3:
                    System.out.println(myMenu.getPlaylist("library").getDescription());
                    pressEnter(dataScanner);
                    break;

                // Create new playlist
                case 4:
                    try {
                        createPlaylist(dataScanner, myMenu);
                    } catch(InputMismatchException e) {
                        System.out.println("Invalid input!\nCould not add content!\nPress ENTER to continue");
                        dataScanner.nextLine();
                        clearTerminal();
                    }
                    break;

                // Delete playlist
                case 5:
                    deletePlaylist(dataScanner, myMenu);
                    break;

                // Add to a playlist
                case 6:
                    System.out.println("==================================================================================+++---");
                    System.out.println("Enter the playlist name");
                    System.out.println("==================================================================================+++---");
                    playlistTitle = dataScanner.nextLine();
                    if(myMenu.playlistExists(playlistTitle)) {
                        addToPlaylist(dataScanner, playlistTitle, myMenu);
                    } else {
                        System.out.println("This playlist doesn't exist!");
                        pressEnter(dataScanner);
                        clearTerminal();
                    }
                    break;

                // List playlists
                case 7:
                    showPlaylists(dataScanner, myMenu);
                    break;

                // Exit
                case 8:
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid option! Please try again.");
                    pressEnter(dataScanner);
                    break;
            }
        }
        closeScanner(dataScanner);
    }
}
