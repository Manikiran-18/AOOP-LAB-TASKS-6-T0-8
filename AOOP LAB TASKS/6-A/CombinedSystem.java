import java.util.*;

public class CombinedSystem {

    // Task Management System Using ArrayList
    static class TaskManagement {
        private ArrayList<String> tasks = new ArrayList<>();

        public void addTask(String task) {
            tasks.add(task);
        }

        public void updateTask(int index, String newTask) {
            if (index >= 0 && index < tasks.size()) {
                tasks.set(index, newTask);
            } else {
                System.out.println("Invalid index!");
            }
        }

        public void removeTask(int index) {
            if (index >= 0 && index < tasks.size()) {
                tasks.remove(index);
            } else {
                System.out.println("Invalid index!");
            }
        }

        public void displayTasks() {
            for (int i = 0; i < tasks.size(); i++) {
                System.out.println((i + 1) + ". " + tasks.get(i));
            }
        }
    }

    // To-Do List Application Using List Interface (ArrayList Implementation)
    static class ToDoListApp {
        private List<String> toDoList = new ArrayList<>();

        public void addTask(String task) {
            toDoList.add(task);
        }

        public void updateTask(int index, String newTask) {
            if (index >= 0 && index < toDoList.size()) {
                toDoList.set(index, newTask);
            } else {
                System.out.println("Invalid index!");
            }
        }

        public void removeTask(int index) {
            if (index >= 0 && index < toDoList.size()) {
                toDoList.remove(index);
            } else {
                System.out.println("Invalid index!");
            }
        }

        public void displayTasks() {
            for (int i = 0; i < toDoList.size(); i++) {
                System.out.println((i + 1) + ". " + toDoList.get(i));
            }
        }
    }

    // Customer Support Ticket System Using Queue Interface (LinkedList)
    static class SupportTicketSystem {
        private Queue<String> ticketQueue = new LinkedList<>();

        public void addTicket(String ticket) {
            ticketQueue.offer(ticket);
        }

        public void processTicket() {
            if (!ticketQueue.isEmpty()) {
                System.out.println("Processing ticket: " + ticketQueue.poll());
            } else {
                System.out.println("No tickets to process.");
            }
        }

        public void displayTickets() {
            if (ticketQueue.isEmpty()) {
                System.out.println("No pending tickets.");
            } else {
                System.out.println("Pending tickets: " + ticketQueue);
            }
        }
    }

    // Browsing History Using Deque (ArrayDeque)
    static class BrowsingHistory {
        private Deque<String> history = new ArrayDeque<>();
        private Deque<String> forwardStack = new ArrayDeque<>();
        private String currentPage = null;

        public void visitPage(String page) {
            if (currentPage != null) {
                history.push(currentPage);
            }
            currentPage = page;
            forwardStack.clear();
            System.out.println("You are now visiting: " + currentPage);
        }

        public void goBack() {
            if (!history.isEmpty()) {
                forwardStack.push(currentPage);
                currentPage = history.pop();
                System.out.println("You are now on: " + currentPage);
            } else {
                System.out.println("No more pages in history.");
            }
        }

        public void goForward() {
            if (!forwardStack.isEmpty()) {
                history.push(currentPage);
                currentPage = forwardStack.pop();
                System.out.println("You are now on: " + currentPage);
            } else {
                System.out.println("No more forward pages.");
            }
        }

        public void displayCurrentPage() {
            if (currentPage == null) {
                System.out.println("No page is open.");
            } else {
                System.out.println("Current page: " + currentPage);
            }
        }
    }

    // Music Playlist Using LinkedList
    static class MusicPlaylist {
        private LinkedList<String> playlist = new LinkedList<>();

        public void addSong(String song) {
            playlist.add(song);
        }

        public void removeSong(String song) {
            if (playlist.remove(song)) {
                System.out.println("Song removed: " + song);
            } else {
                System.out.println("Song not found!");
            }
        }

        public void moveSong(int oldIndex, int newIndex) {
            if (oldIndex >= 0 && oldIndex < playlist.size() && newIndex >= 0 && newIndex < playlist.size()) {
                String song = playlist.remove(oldIndex);
                playlist.add(newIndex, song);
                System.out.println("Moved song to position: " + (newIndex + 1));
            } else {
                System.out.println("Invalid positions!");
            }
        }

        public void displayPlaylist() {
            for (int i = 0; i < playlist.size(); i++) {
                System.out.println((i + 1) + ". " + playlist.get(i));
            }
        }
    }

    // Main Menu to access all the systems
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TaskManagement taskManager = new TaskManagement();
        ToDoListApp toDoListApp = new ToDoListApp();
        SupportTicketSystem ticketSystem = new SupportTicketSystem();
        BrowsingHistory browsingHistory = new BrowsingHistory();
        MusicPlaylist musicPlaylist = new MusicPlaylist();
        int choice;

        do {
            System.out.println("\n--- Combined System Menu ---");
            System.out.println("1. Task Management System");
            System.out.println("2. To-Do List Application");
            System.out.println("3. Support Ticket System");
            System.out.println("4. Browsing History");
            System.out.println("5. Music Playlist");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    taskManagementMenu(scanner, taskManager);
                    break;
                case 2:
                    toDoListMenu(scanner, toDoListApp);
                    break;
                case 3:
                    supportTicketMenu(scanner, ticketSystem);
                    break;
                case 4:
                    browsingHistoryMenu(scanner, browsingHistory);
                    break;
                case 5:
                    musicPlaylistMenu(scanner, musicPlaylist);
                    break;
                case 6:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice!");
            }
        } while (choice != 6);
    }

    // Task Management Menu
    private static void taskManagementMenu(Scanner scanner, TaskManagement taskManager) {
        int choice;
        do {
            System.out.println("\n--- Task Management ---");
            System.out.println("1. Add Task");
            System.out.println("2. Update Task");
            System.out.println("3. Remove Task");
            System.out.println("4. Display Tasks");
            System.out.println("5. Back to Main Menu");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.println("Enter Task: ");
                    String task = scanner.nextLine();
                    taskManager.addTask(task);
                    break;
                case 2:
                    System.out.println("Enter task number to update: ");
                    int updateIndex = scanner.nextInt() - 1;
                    scanner.nextLine();
                    System.out.println("Enter new task description: ");
                    String newTask = scanner.nextLine();
                    taskManager.updateTask(updateIndex, newTask);
                    break;
                case 3:
                    System.out.println("Enter task number to remove: ");
                    int removeIndex = scanner.nextInt() - 1;
                    taskManager.removeTask(removeIndex);
                    break;
                case 4:
                    taskManager.displayTasks();
                    break;
                case 5:
                    System.out.println("Returning to main menu...");
                    break;
                default:
                    System.out.println("Invalid choice!");
            }
        } while (choice != 5);
    }

    // To-Do List Menu
    private static void toDoListMenu(Scanner scanner, ToDoListApp toDoListApp) {
        int choice;
        do {
            System.out.println("\n--- To-Do List ---");
            System.out.println("1. Add Task");
            System.out.println("2. Update Task");
            System.out.println("3. Remove Task");
            System.out.println("4. Display Tasks");
            System.out.println("5. Back to Main Menu");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.println("Enter Task: ");
                    String task = scanner.nextLine();
                    toDoListApp.addTask(task);
                    break;
                case 2:
                    System.out.println("Enter task number to update: ");
                    int updateIndex = scanner.nextInt() - 1;
                    scanner.nextLine();
                    System.out.println("Enter new task description: ");
                    String newTask = scanner.nextLine();
                    toDoListApp.updateTask(updateIndex, newTask);
                    break;
                case 3:
                    System.out.println("Enter task number to remove: ");
                    int removeIndex = scanner.nextInt() - 1;
                    toDoListApp.removeTask(removeIndex);
                    break;
                case 4:
                    toDoListApp.displayTasks();
                    break;
                case 5:
                    System.out.println("Returning to main menu...");
                    break;
                default:
                    System.out.println("Invalid choice!");
            }
        } while (choice != 5);
    }

    // Support Ticket System Menu
    private static void supportTicketMenu(Scanner scanner, SupportTicketSystem ticketSystem) {
        int choice;
        do {
            System.out.println("\n--- Support Ticket System ---");
            System.out.println("1. Add Ticket");
            System.out.println("2. Process Ticket");
            System.out.println("3. Display Pending Tickets");
            System.out.println("4. Back to Main Menu");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.println("Enter Ticket Description: ");
                    String ticket = scanner.nextLine();
                    ticketSystem.addTicket(ticket);
                    break;
                case 2:
                    ticketSystem.processTicket();
                    break;
                case 3:
                    ticketSystem.displayTickets();
                    break;
                case 4:
                    System.out.println("Returning to main menu...");
                    break;
                default:
                    System.out.println("Invalid choice!");
            }
        } while (choice != 4);
    }

    // Browsing History Menu
    private static void browsingHistoryMenu(Scanner scanner, BrowsingHistory browsingHistory) {
        int choice;
        do {
            System.out.println("\n--- Browsing History ---");
            System.out.println("1. Visit Page");
            System.out.println("2. Go Back");
            System.out.println("3. Go Forward");
            System.out.println("4. Display Current Page");
            System.out.println("5. Back to Main Menu");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.println("Enter Page URL: ");
                    String url = scanner.nextLine();
                    browsingHistory.visitPage(url);
                    break;
                case 2:
                    browsingHistory.goBack();
                    break;
                case 3:
                    browsingHistory.goForward();
                    break;
                case 4:
                    browsingHistory.displayCurrentPage();
                    break;
                case 5:
                    System.out.println("Returning to main menu...");
                    break;
                default:
                    System.out.println("Invalid choice!");
            }
        } while (choice != 5);
    }

    // Music Playlist Menu
    private static void musicPlaylistMenu(Scanner scanner, MusicPlaylist musicPlaylist) {
        int choice;
        do {
            System.out.println("\n--- Music Playlist ---");
            System.out.println("1. Add Song");
            System.out.println("2. Remove Song");
            System.out.println("3. Move Song");
            System.out.println("4. Display Playlist");
            System.out.println("5. Back to Main Menu");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.println("Enter Song: ");
                    String song = scanner.nextLine();
                    musicPlaylist.addSong(song);
                    break;
                case 2:
                    System.out.println("Enter Song to Remove: ");
                    String removeSong = scanner.nextLine();
                    musicPlaylist.removeSong(removeSong);
                    break;
                case 3:
                    System.out.println("Enter current song position: ");
                    int oldIndex = scanner.nextInt() - 1;
                    System.out.println("Enter new song position: ");
                    int newIndex = scanner.nextInt() - 1;
                    musicPlaylist.moveSong(oldIndex, newIndex);
                    break;
                case 4:
                    musicPlaylist.displayPlaylist();
                    break;
                case 5:
                    System.out.println("Returning to main menu...");
                    break;
                default:
                    System.out.println("Invalid choice!");
            }
        } while (choice != 5);
    }
}
