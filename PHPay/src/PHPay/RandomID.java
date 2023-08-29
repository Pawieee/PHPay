package PHPay;
import javax.swing.*;
import java.util.HashSet;
import java.util.Random;

public class RandomID {

	  public static class RandomIdGenerator {
	        private HashSet<Integer> usedIds;
	        private Random random;

	        public RandomIdGenerator() {
	            usedIds = new HashSet<>();
	            random = new Random();
	        }

	        public int generateId() {
	            int id = random.nextInt(100000000 - 100000 + 1) + 100000;
	            while (usedIds.contains(id)) {
	                id = random.nextInt(100000000 - 100000 + 1) + 100000;
	            }
	            usedIds.add(id);
	            return id;
	        }
	    }

	    public static void main(String[] args) {
	        RandomIdGenerator generator = new RandomIdGenerator();
	        int id = generator.generateId();
	        System.out.println("Generated id: " + id);

	        JTextField idField = new JTextField(String.valueOf(id));
	        idField.setEditable(false);
	        idField.setBounds(88, 262, 290, 30);

	        JFrame frame = new JFrame();
	        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        frame.setSize(500, 500);
	        frame.setLayout(null);
	        frame.add(idField);
	        frame.setVisible(true);
	    }
	}