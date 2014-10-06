package models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;

import play.data.validation.Constraints.Required;
import play.db.ebean.Model;

@Entity
public class Task extends Model {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	public Long id = 0L;

	@Required
	public String label;

	public static Finder<Long,Task> find = new Finder<Long, Task>(
			Long.class, Task.class
		  );
	
	public Task() {}

	public Task(String label) {
		this.label = label;
	}
	
	public Task(Long id, String label) {
		this.id = id;
		this.label = label;
	}

	public static List<Task> all() {
		return find.where().findList();
		
		/*
		ArrayList<Task> list = new ArrayList<Task>();
		BufferedReader br = null;
		try {
			String sCurrentLine;
			br = new BufferedReader(new FileReader("files\\tasks.txt"));

			while ((sCurrentLine = br.readLine()) != null) {
				String tab[] = sCurrentLine.split(":");
				list.add(new Task(Long.parseLong(tab[0], 10), tab[1]));
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (br != null)br.close();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
		return list;
		*/
	}

	public static void create(Task task) {
		/*
		BufferedWriter bw = null;
		try {
			FileWriter fileWriter = new FileWriter("files\\tasks.txt", true);
			bw = new BufferedWriter(fileWriter);
			PrintWriter out = new PrintWriter(bw);
			out.println(task.id + ":" + task.label);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (bw != null)
					bw.close();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
		*/
		
		task.save();
	}

	public static void delete(Long id) {
		/*
		ArrayList<Task> list = new ArrayList<Task>();
		BufferedReader br = null;
		BufferedWriter bw = null;
		try {
			String sCurrentLine;
			FileReader fileReader = new FileReader("files\\tasks.txt");
			br = new BufferedReader(fileReader);

			while ((sCurrentLine = br.readLine()) != null) {
				String tab[] = sCurrentLine.split(":");
				long parsedId = Long.parseLong(tab[0], 10);
				if (parsedId != id) {
					list.add(new Task(parsedId, tab[1]));
				}
			}

			if (br != null)
				br.close();

			FileWriter fileWriter = new FileWriter("files\\tasks.txt");
			bw = new BufferedWriter(fileWriter);
			for (Task t : list) {
				bw.write(t.id + ":" + t.label);
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (br != null)
					br.close();
				if (bw != null)
					bw.close();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
		*/
		Task ref = find.ref(id);
		ref.delete();
	}
}
