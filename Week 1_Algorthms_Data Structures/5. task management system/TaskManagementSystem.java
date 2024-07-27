import java.util.Scanner;

public class TaskManagementSystem {
    
    private static class Node {
        Task task;
        Node next;

        Node(Task task) {
            this.task = task;
            this.next = null;
        }
    }

    private Node head = null;

    public void addTask(int taskId, String taskName, String status) {
        Task newTask = new Task(taskId, taskName, status);
        Node newNode = new Node(newTask);
        if (head == null) {
            head = newNode;
        } else {
            Node temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newNode;
        }
    }

    public Task searchTask(int taskId) {
        Node temp = head;
        while (temp != null) {
            if (temp.task.getTaskId() == taskId) {
                return temp.task;
            }
            temp = temp.next;
        }
        return null;
    }

    public void traverseTasks() {
        Node temp = head;
        while (temp != null) {
            System.out.println(temp.task);
            temp = temp.next;
        }
    }

    public boolean deleteTask(int taskId) {
        if (head == null) {
            return false;
        }

        if (head.task.getTaskId() == taskId) {
            head = head.next;
            return true;
        }

        Node temp = head;
        while (temp.next != null && temp.next.task.getTaskId() != taskId) {
            temp = temp.next;
        }

        if (temp.next == null) {
            return false;
        }

        temp.next = temp.next.next;
        return true;
    }

    public static void main(String[] args) {
        TaskManagementSystem taskList = new TaskManagementSystem();
        Scanner sc = new Scanner(System.in);
        int id = 1;
        
        while (true) {
            System.out.print("1. Add Task\n2. Search Task\n3. Traverse Tasks\n4. Delete Task\n-1 to Exit\nYour choice: ");
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    System.out.print("Enter Task Name: ");
                    String taskName = sc.next();
                    System.out.print("Enter Status: ");
                    String status = sc.next();
                    taskList.addTask(id++, taskName, status);
                    break;
                case 2:
                    System.out.print("Enter Task ID to search: ");
                    int searchId = sc.nextInt();
                    Task task = taskList.searchTask(searchId);
                    if (task != null) {
                        System.out.println("Task Found: " + task);
                    } else {
                        System.out.println("Task with ID " + searchId + " not found.");
                    }
                    break;
                case 3:
                    taskList.traverseTasks();
                    break;
                case 4:
                    System.out.print("Enter Task ID to delete: ");
                    int deleteId = sc.nextInt();
                    boolean deleted = taskList.deleteTask(deleteId);
                    if (deleted) {
                        System.out.println("Task with ID " + deleteId + " has been deleted.");
                    } else {
                        System.out.println("Task with ID " + deleteId + " not found.");
                    }
                    break;
                case -1:
                    System.out.println("Thank you!");
                    sc.close();
                    return;
                default:
                    System.out.println("Incorrect choice, please try again.");
                    break;
            }
        }
    }
}
