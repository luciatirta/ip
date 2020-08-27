import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Storage {
	String filePath;

	public Storage(String filePath) {
		this.filePath = filePath;
	}

	public ArrayList<Task> loadData() throws FileNotFoundException {
		ArrayList<Task> taskList = new ArrayList<>();
		File f = new File(filePath);
		Scanner s = new Scanner(f);
		while (s.hasNextLine()) {
			String input = s.nextLine();
			String[] inputs = input.split("#");
			Commands command = Commands.valueOf(inputs[0]);
			if (command.equals(Commands.TODO)){
				taskList.add(new Todo(inputs[1], Boolean.parseBoolean(inputs[2])));
			} else if (command.equals(Commands.EVENT)) {
				taskList.add(new Event(inputs[1], Boolean.parseBoolean(inputs[2]), inputs[3]));
			} else {
				taskList.add(new Event(inputs[1], Boolean.parseBoolean(inputs[2]), inputs[3]));
			}
		}
		return taskList;
	}

	public void writeData(TaskList taskList) throws IOException {
		File f = new File(filePath);
		if (!f.exists()) {
			f.getParentFile().mkdirs();
			f.createNewFile();
		}
		FileWriter fw = new FileWriter(filePath);
		StringBuilder textToAdd = new StringBuilder();
		for (Task task : taskList.getTask()) {
			textToAdd.append(task.getData()).append("\n");
		}
		fw.write(textToAdd.toString());
		fw.close();
	}
}
