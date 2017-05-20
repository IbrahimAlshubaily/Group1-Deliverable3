import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class theGUI {

	private JFrame frame;
	JPanel signInPanel;
	JPanel subProgramPanel;
	JPanel AuthorPanel;
	private JButton btnSignOut;
	private JLabel lblWellcomeSubprogramChair;
	private JButton AssignReviewer;
	private JLabel AssignManuscript;
	private JLabel lblTo;
	private JButton SubmitRecomendation;
	private JButton btnClickHere_2;
	private JLabel lblToRemoveA;
	private JButton btnClickHere_3;
	private JLabel lblToSubmitA;
	private JLabel lblWellcomeAuthor;
	private JButton btnSignOut_1;

	private JTextField SignInText;
	private JLabel lblToAssignA;
	private JLabel lblWellcomeSubprogramChair_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					theGUI window = new theGUI();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public theGUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 472, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		signInPanel = new JPanel();
		frame.getContentPane().add(signInPanel);
		signInPanel.setVisible(true);

		
		subProgramPanel = new JPanel();
		frame.getContentPane().add(subProgramPanel);
		subProgramPanel.setLayout(null);
		
	
		
		lblTo = new JLabel("To submit a recommendation for a manuscript:");
		lblTo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblTo.setBounds(20, 131, 307, 31);
		subProgramPanel.add(lblTo);
		
		
		
		AuthorPanel = new JPanel();
		frame.getContentPane().add(AuthorPanel);
		AuthorPanel.setLayout(null);
		
		
		
		btnClickHere_2 = new JButton("Click Here");
		btnClickHere_2.setBounds(278, 64, 89, 23);
		AuthorPanel.add(btnClickHere_2);
		
		lblToRemoveA = new JLabel("To Remove A paper you have submitted to a Conference:");
		lblToRemoveA.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblToRemoveA.setBounds(10, 117, 344, 37);
		AuthorPanel.add(lblToRemoveA);
		
		btnClickHere_3 = new JButton("Click Here");
		btnClickHere_3.setBounds(345, 125, 101, 22);
		AuthorPanel.add(btnClickHere_3);
		
		lblToSubmitA = new JLabel("To submit a manuscript to a conference:");
		lblToSubmitA.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblToSubmitA.setBounds(10, 68, 258, 19);
		AuthorPanel.add(lblToSubmitA);
		
		lblWellcomeAuthor = new JLabel("Wellcome Author");
		lblWellcomeAuthor.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblWellcomeAuthor.setBounds(109, 11, 159, 23);
		AuthorPanel.add(lblWellcomeAuthor);
		
		signInPanel.setVisible(true);
		frame.getContentPane().add(signInPanel);
		
		JLabel lblUserName = new JLabel("User name:");
		lblUserName.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblUserName.setBounds(35, 112, 97, 21);
		signInPanel.add(lblUserName);
		
		/**																		Action Listeners                          */
		
		JButton btnSignIn = new JButton("Sign In");
		btnSignIn.setBounds(122, 159, 117, 38);
		btnSignIn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
				if (SignInText.getText().equals("SubProgramChair")) {
					signInPanel.setVisible(false);
					frame.getContentPane().add(subProgramPanel);
					subProgramPanel.setVisible(true);
				} else if (SignInText.getText().equals("Author") || SignInText.getText().equals("Author1") || SignInText.getText().equals("Author2")) {
					signInPanel.setVisible(false);
					frame.getContentPane().add(AuthorPanel);
					AuthorPanel.setVisible(true);
				}
			}
		});
		signInPanel.setLayout(null);
		signInPanel.add(btnSignIn);
		
		SignInText = new JTextField();
		SignInText.setBounds(122, 114, 117, 19);
		signInPanel.add(SignInText);
		SignInText.setColumns(10);

		AssignReviewer = new JButton("Click Here");
		AssignReviewer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
				
			}
		});
		AssignReviewer.setBounds(284, 54, 102, 32);
		subProgramPanel.add(AssignReviewer);
		
		SubmitRecomendation = new JButton("Click Here");
		SubmitRecomendation.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		SubmitRecomendation.setBounds(322, 131, 102, 32);
		subProgramPanel.add(SubmitRecomendation);
		
		
		
		
		btnSignOut_1 = new JButton("Sign Out");
		btnSignOut_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AuthorPanel.setVisible(false);
				signInPanel.setVisible(true);
				frame.getContentPane().add(signInPanel);
			}
		});
		btnSignOut_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnSignOut_1.setBounds(151, 213, 98, 37);
		AuthorPanel.add(btnSignOut_1);
		
		signInPanel.setVisible(false);
		frame.getContentPane().add(subProgramPanel);
		
		lblToAssignA = new JLabel("To assign a reviewer to a manuscript:");
		lblToAssignA.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblToAssignA.setBounds(20, 63, 262, 20);
		subProgramPanel.add(lblToAssignA);
		
		lblWellcomeSubprogramChair_1 = new JLabel("WellCome Subprogram Chair");
		lblWellcomeSubprogramChair_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblWellcomeSubprogramChair_1.setBounds(102, 11, 225, 20);
		subProgramPanel.add(lblWellcomeSubprogramChair_1);
		subProgramPanel.setVisible(true);
	}
}
