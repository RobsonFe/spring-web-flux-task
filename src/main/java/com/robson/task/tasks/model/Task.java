package com.robson.task.tasks.model;

import com.robson.task.tasks.service.TaskService;

public class Task {
    private String title;
    private String description;
    private int priority;
    private TaskState state;

    public Task(Builder builder) {
        this.title = builder.title;
        this.description = builder.description;
        this.priority = builder.priority;
        this.state = builder.state;
    }

    public Task() {
    }

    public Task newTask(Task task) {
        TaskService.taskList.add(this);
        return this;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public TaskState getState() {
        return state;
    }

    public void setState(TaskState state) {
        this.state = state;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static Builder builderFrom(Task task) {
        return new Builder(task);
    }

    public static class Builder {
        private String title;
        private String description;
        private int priority;
        private TaskState state;

        public Builder(Task task) {
            this.title = task.title;
            this.description = task.description;
            this.priority = task.priority;
            this.state = task.state;
        }

        public Builder() {
        }

        public Builder withTitle(String title) {
            this.title = title;
            return this;
        }

        public Builder withDescription(String description) {
            this.description = description;
            return this;
        }

        public Builder withPriority(int priority) {
            this.priority = priority;
            return this;
        }

        public Builder withState(TaskState state) {
            this.state = state;
            return this;
        }

        public Task build() {
            return new Task(this);
        }
    }
}
