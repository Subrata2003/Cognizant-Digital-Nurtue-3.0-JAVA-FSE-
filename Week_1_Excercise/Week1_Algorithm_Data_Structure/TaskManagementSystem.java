class Task {
    String taskId;
    String taskName;
    String status;
    Task next;

    public Task(String taskId, String taskName, String status) {
        this.taskId = taskId;
        this.taskName = taskName;
        this.status = status;
        this.next = null;
    }
}

class TaskManagementSystem {
    private Task head;

    public TaskManagementSystem() {
        head = null;
    }

    public void addTask(Task task) {
        if (head == null) {
            head = task;
        } else {
            Task current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = task;
        }
    }

    public Task searchTask(String taskId) {
        Task current = head;
        while (current != null) {
            if (current.taskId.equals(taskId)) {
                return current;
            }
            current = current.next;
        }
        return null;
    }

    public Task[] traverseTasks() {
        int size = 0;
        Task current = head;
        while (current != null) {
            size++;
            current = current.next;
        }

        Task[] tasks = new Task[size];
        current = head;
        int index = 0;
        while (current != null) {
            tasks[index] = current;
            index++;
            current = current.next;
        }
        return tasks;
    }

    public void deleteTask(String taskId) {
        if (head == null) return;

        if (head.taskId.equals(taskId)) {
            head = head.next;
            return;
        }

        Task current = head;
        while (current.next != null && !current.next.taskId.equals(taskId)) {
            current = current.next;
        }

        if (current.next != null) {
            current.next = current.next.next;
        }
    }

    public static void main(String[] args) {
        TaskManagementSystem system = new TaskManagementSystem();
        Task t1 = new Task("1", "Task 1", "Pending");
        Task t2 = new Task("2", "Task 2", "Completed");
        system.addTask(t1);
        system.addTask(t2);

        System.out.println("Added tasks:");
        for (Task task : system.traverseTasks()) {
            System.out.println(task.taskName + ": " + task.status);
        }

        system.deleteTask("1");
        System.out.println("After deleting task 1:");
        for (Task task : system.traverseTasks()) {
            System.out.println(task.taskName + ": " + task.status);
        }
    }
}
