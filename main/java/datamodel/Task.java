package datamodel;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "tasks")
public class Task{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	
	@Column(name = "task")
	private String task;
	
	@Column(name = "description")
	private String description;
	
	public Task() {
	}
	
	public Task(Integer id, String task, String description) {
		this.id = id;
		this.task = task;
		this.description = description;
	}
	
	public Task(String task, String description) {
		this.task = task;
		this.description = description;
	}
	
	
	public String getTask() {
		return task;
	}
	
	public void setTask(String task) {
		this.task = task;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	 @Override
	   public String toString() {
	      return "Task #" + this.id + " - " + this.task + ": " + this.description;
	   }
}