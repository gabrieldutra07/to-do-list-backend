package com.example.todolist.dto;

public class ListTaskCountDTO {
    private Long listCount;
    private Long taskCount;
    private Long completedTaskCount;

    public ListTaskCountDTO(Long listCount, Long taskCount, Long completedTaskCount) {
        this.listCount = listCount;
        this.taskCount = taskCount;
        this.completedTaskCount = completedTaskCount;
    }
    
    public ListTaskCountDTO() {
       
    }

	public Long getListCount() {
		return listCount;
	}

	public void setListCount(Long listCount) {
		this.listCount = listCount;
	}

	public Long getTaskCount() {
		return taskCount;
	}

	public void setTaskCount(Long taskCount) {
		this.taskCount = taskCount;
	}

	public Long getCompletedTaskCount() {
		return completedTaskCount;
	}

	public void setCompletedTaskCount(Long completedTaskCount) {
		this.completedTaskCount = completedTaskCount;
	}

    
}
