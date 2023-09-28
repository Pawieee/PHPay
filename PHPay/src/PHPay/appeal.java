package PHPay;


import javax.swing.*;
import java.awt.event.*;
import javax.swing.text.*;
import javax.swing.event.*;


public class appeal {

	private String session;
	private JFrame frame;
	private final int maxChar = 300;

	public appeal(String ID) {
		this.session = ID;
		initialize();
	}

	private void initialize(){
		 frame = new JFrame();
		    frame.setBounds(100, 100, 429, 455);
		    frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		    frame.getContentPane().setLayout(null);

		    JLabel lblNewLabel = new JLabel("Appeal Message");
		    lblNewLabel.setBounds(42, 45, 96, 13);
		    frame.getContentPane().add(lblNewLabel);

		    JButton btnNewButton = new JButton("Submit Appeal");
		    
		    JLabel charCountLabel = new JLabel("300 characters max");
		    charCountLabel.setHorizontalAlignment(SwingConstants.CENTER);
		    charCountLabel.setBounds(173, 309, 155, 13);
		    frame.getContentPane().add(charCountLabel);
		    frame.setVisible(true);
		    
		    JScrollPane scrollPane = new JScrollPane();
		    scrollPane.setBounds(71, 68, 257, 237);
		    frame.getContentPane().add(scrollPane);
		    JTextPane textPane = new JTextPane();
		    scrollPane.setViewportView(textPane);

		    btnNewButton.addActionListener(new ActionListener() {
		        public void actionPerformed(ActionEvent e) {
		            String message = textPane.getText();
		            SQLQuery.createAppeal(session, message);
		            frame.dispose();
		        }
		    });
		    btnNewButton.setBounds(241, 348, 117, 21);
		    frame.getContentPane().add(btnNewButton);
		    

		    // Create a DocumentFilter to limit the number of characters
		    AbstractDocument doc = (AbstractDocument) textPane.getDocument();
		    doc.setDocumentFilter(new DocumentSizeFilter(maxChar));
		    
		    doc.addDocumentListener(new DocumentListener() {
		        @Override
		        public void insertUpdate(DocumentEvent e) {
		            updateCharCountLabel();
		        }

		        @Override
		        public void removeUpdate(DocumentEvent e) {
		            updateCharCountLabel();
		        }

		        @Override
		        public void changedUpdate(DocumentEvent e) {
		            updateCharCountLabel();
		        }

		        private void updateCharCountLabel() {
		            int remainingChars = maxChar - textPane.getDocument().getLength();
		            charCountLabel.setText(remainingChars + " characters remaining");
		        }
		    });
		}
}
