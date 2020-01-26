import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.AbstractButton;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class Gui extends JFrame {

	private JButton b[] = new JButton[9];
	private int player = 1;


	Gui() {
		init();
	}

	private void init() {
		setTitle("TicTacToe");

		getContentPane().setLayout(new GridLayout(3, 3, 10, 10));

		for (int i = 0; i < 9; i++) {
			b[i] = new JButton();
			b[i].setFont(new Font("Arial", Font.PLAIN, 150));
			b[i].addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if (((AbstractButton) e.getSource()).getText() == "") {
						player++;

						if (player % 2 == 0) {
							((AbstractButton) e.getSource()).setText("X");
							winnerX();
							
							
						} else if(player % 1 == 0){
							((AbstractButton) e.getSource()).setText("O");
							winnerO();
							
						}
					}
				}
			});
			getContentPane().add(b[i]);

		}

		setVisible(true);
	}

	private void winnerX() {
		if (b[0].getText().contentEquals("X") && b[1].getText().contentEquals("X")
				&& b[2].getText().contentEquals("X")) {
			winnerGui("X");
		} else if (b[0].getText().contentEquals("X") && b[3].getText().contentEquals("X")
				&& b[6].getText().contentEquals("X")) {
			winnerGui("X");
		} else if (b[0].getText().contentEquals("X") && b[4].getText().contentEquals("X")
				&& b[8].getText().contentEquals("X")) {
			winnerGui("X");
		} else if (b[2].getText().contentEquals("X") && b[5].getText().contentEquals("X")
				&& b[8].getText().contentEquals("X")) {
			winnerGui("X");
		} else if (b[6].getText().contentEquals("X") && b[7].getText().contentEquals("X")
				&& b[8].getText().contentEquals("X")) {
			winnerGui("X");
		} else if (b[3].getText().contentEquals("X") && b[4].getText().contentEquals("X")
				&& b[5].getText().contentEquals("X")) {
			winnerGui("X");
		} else if (b[1].getText().contentEquals("X") && b[4].getText().contentEquals("X")
				&& b[7].getText().contentEquals("X")) {
			winnerGui("X");
		} else if (b[2].getText().contentEquals("X") && b[4].getText().contentEquals("X")
				&& b[6].getText().contentEquals("X")) {
			winnerGui("X");
		} else if(player == 10) {
			draw();
		}
		

	}

	private void winnerO() {
		if (b[0].getText().contentEquals("O") && b[1].getText().contentEquals("O")
				&& b[2].getText().contentEquals("O")) {
			winnerGui("O");
		} else if (b[0].getText().contentEquals("O") && b[3].getText().contentEquals("O")
				&& b[6].getText().contentEquals("O")) {
			winnerGui("O");
		} else if (b[0].getText().contentEquals("O") && b[4].getText().contentEquals("O")
				&& b[8].getText().contentEquals("O")) {
			winnerGui("O");
		} else if (b[2].getText().contentEquals("O") && b[5].getText().contentEquals("O")
				&& b[8].getText().contentEquals("O")) {
			winnerGui("O");
		} else if (b[6].getText().contentEquals("O") && b[7].getText().contentEquals("O")
				&& b[8].getText().contentEquals("O")) {
			winnerGui("O");
		} else if (b[3].getText().contentEquals("O") && b[4].getText().contentEquals("O")
				&& b[5].getText().contentEquals("O")) {
			winnerGui("O");
		} else if (b[1].getText().contentEquals("O") && b[4].getText().contentEquals("O")
				&& b[7].getText().contentEquals("O")) {
			winnerGui("O");
		} else if (b[2].getText().contentEquals("O") && b[4].getText().contentEquals("O")
				&& b[6].getText().contentEquals("O")) {
			winnerGui("O");
		} else if(player == 10) {
			draw();
		}

	}

	private void winnerGui(String winner) {
		for (int i = 0; i < 9; i++) {
			b[i].setEnabled(false);
		}
		JFrame f = new JFrame();
		JLabel l = new JLabel("The winner is " + winner, SwingConstants.CENTER);
		Timer t = new Timer();
		l.setFont(new Font("Arial", Font.PLAIN, 40));
		f.add(l);
		f.setTitle("Winner is " + winner);
		f.setSize(400, 300);
		f.setVisible(true);
		t.schedule(new TimerTask() {

			public void run() {
				dispose();
				f.dispose();
				Main.main(null);
			}

		}, 2500);
	}

	private void draw() {
		for (int i = 0; i < 9; i++) {
			b[i].setEnabled(false);
		}
		JFrame f = new JFrame();
		JLabel l = new JLabel("Draw", SwingConstants.CENTER);
		Timer t = new Timer();
		l.setFont(new Font("Arial", Font.PLAIN, 40));
		f.add(l);
		f.setTitle("Draw");
		f.setSize(400, 300);
		f.setVisible(true);
		t.schedule(new TimerTask() {

			public void run() {
				dispose();
				f.dispose();
				Main.main(null);
			}

		}, 2500);
	}

}
