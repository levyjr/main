package seedu.task.testutil;

import seedu.task.commons.exceptions.IllegalValueException;
import seedu.task.model.tag.UniqueTagList;
import seedu.task.model.task.Address;
import seedu.task.model.task.TaskDate;
import seedu.task.model.task.Email;
import seedu.task.model.task.TaskName;
import seedu.task.model.task.Phone;
import seedu.task.model.task.ReadOnlyTask;
import seedu.task.model.task.TaskTime;

/**
 * A mutable task object. For testing only.
 */
public class TestTask implements ReadOnlyTask {

	/*
    private TaskName name;
    private Address address;
    private Email email;
    private Phone phone;
    */
    private UniqueTagList tags;
    private TaskName taskName;
    private TaskDate taskDate;
    private TaskTime taskStartTime;
    private TaskTime taskEndTime;
    private String taskDescription;
    
    public TestTask() {
        tags = new UniqueTagList();
    }

    /**
     * Creates a copy of {@code taskToCopy}.
     */
    public TestTask(TestTask taskToCopy) {
        this.taskName = taskToCopy.getTaskName();
        this.taskDate = taskToCopy.getTaskDate();
        this.taskStartTime = taskToCopy.getTaskStartTime();
        this.taskEndTime = taskToCopy.getTaskEndTime();
        this.taskDescription = taskToCopy.getTaskDescription();
        this.tags = taskToCopy.getTags();
    }

    @Override
    public TaskName getTaskName() {
        return taskName;
    }
    
    public void setTaskName(TaskName name) {
        this.taskName = name;
    }
    
    @Override
    public TaskDate getTaskDate() {
    	return taskDate;
    }
    
    public void setTaskDate(TaskDate taskDate) {
    	this.taskDate = taskDate;
    }
   
    @Override
    public TaskTime getTaskStartTime() {
    	return taskStartTime;
    }
    
    public void setTaskStartTime(TaskTime taskStartTime) {
    	this.taskStartTime = taskStartTime;
    }
    
    @Override
    public TaskTime getTaskEndTime() {
    	return taskEndTime;
    }
    
    public void setTaskEndTime(TaskTime taskEndTime) {
    	this.taskEndTime = taskEndTime;
    }
    
    @Override
    public String getTaskDescription() {
    	return taskDescription;
    }

    public void setTaskDescription(String taskDescription) {
    	this.taskDescription = taskDescription;
    }
    @Override
    public UniqueTagList getTags() {
        return tags;
    }
    
    public void setTags(UniqueTagList tags) {
        this.tags = tags;
    }

    @Override
    public String toString() {
        return getAsText();
    }

    public String getAddCommand() {
        StringBuilder sb = new StringBuilder();
        sb.append("add " + this.getTaskName().fullName + " ");
        sb.append("d/" + this.getTaskDate().value + " ");
        sb.append("s/" + this.getTaskStartTime().value + " ");
        sb.append("e/" + this.getTaskEndTime().value + " ");
        sb.append("m/" + this.getTaskDescription() + " ");
        this.getTags().asObservableList().stream().forEach(s -> sb.append("t/" + s.tagName + " "));
        return sb.toString();
    }


}
