import javax.swing.BorderFactory;
import javax.swing.ButtonModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.plaf.BorderUIResource;
<<<<<<< Updated upstream:Java_UI/Java_connection/Administrator/Frame.java
=======
import javax.swing.table.TableColumn;

>>>>>>> Stashed changes:Java_UI/Administrator/Frame.java
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Frame extends JFrame {
    JPanel panel3;
    JLabel label2;
    JButton button1, button2, button3, button4, button5, button6, button7;
    ArrayList<JButton> buttons;

    Frame() {
        ImageIcon welcome = new ImageIcon("Welcome.jpg");
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension screensize = toolkit.getScreenSize();
        JPanel Panel1 = new JPanel(new BorderLayout());
        JLabel label1 = new JLabel();
        ImageIcon icon = new ImageIcon("auction2.jpg");
        Border glassyBorder = new BorderUIResource(
                BorderFactory.createEtchedBorder(EtchedBorder.RAISED, Color.WHITE, new Color(180, 180, 180)));
<<<<<<< Updated upstream:Java_UI/Java_connection/Administrator/Frame.java
        ImageIcon icon = new ImageIcon("auction2.jpg");
        JLabel label1 = new JLabel();
=======
        JPanel panel2 = new JPanel();
        JLabel contentLabel = new JLabel();
        contentLabel.setPreferredSize(new Dimension(700, 700));
        contentLabel.setIcon(welcome);

        button1 = CustomButton("Home");
        button2 = CustomButton("Add Item");
        button3 = CustomButton("Show Item");
        button4 = CustomButton("Start Auction");
        button5 = CustomButton("Show Customers");
        button6 = CustomButton("Show Sold Items");
        button7 = CustomButton("Logout");

        buttons = new ArrayList<>(7);
        buttons.add(button1);
        buttons.add(button2);
        buttons.add(button3);
        buttons.add(button4);
        buttons.add(button5);
        buttons.add(button6);
        buttons.add(button7);

>>>>>>> Stashed changes:Java_UI/Administrator/Frame.java
        label1.setBounds(5, 5, 990, 80);
        label1.setBackground(Color.white);
        label1.setOpaque(true);
        label1.setHorizontalAlignment(JLabel.CENTER);
        label1.setText("AUCTION DAILY");
        label1.setFont(new Font(Font.SERIF, Font.BOLD, 35));

        label2 = new JLabel();
        label2.setFont(new Font(Font.MONOSPACED, Font.BOLD, 15));
        label2.setBounds(5, 85, screensize.width - 10, 25);
        label2.setBorder(glassyBorder);
        label2.setBackground(new Color(35, 59, 97));
        label2.setForeground(Color.white);
        label2.setOpaque(true);
        label2.setHorizontalAlignment(JLabel.CENTER);
        label2.setPreferredSize(new Dimension(screensize.width - 10, 25));

        Panel1.setBounds(0, 0, screensize.width, 80);
        Panel1.setBackground(Color.white);
        Panel1.setPreferredSize(new Dimension(screensize.width, 80));

        panel2.setBackground(new Color(167, 192, 232));
        panel2.setLayout(null);
        panel2.setPreferredSize(new Dimension(300, 200));

        panel3 = new JPanel();
        panel3.setLayout(new BorderLayout());
        panel3.setBackground(new Color(167, 192, 232));
        panel3.setPreferredSize(new Dimension(1060, 700));

        Panel1.add(label2, BorderLayout.SOUTH);
        Panel1.add(label1, BorderLayout.NORTH);
        panel3.add(contentLabel, BorderLayout.CENTER);
        panel3.revalidate();

        this.setLayout(new BorderLayout(5, 5));
        this.setMinimumSize(new Dimension(1000, 600));
        this.setSize(screensize.width, screensize.height);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.getContentPane().setBackground(new Color(113, 163, 240));
        this.add(Panel1, BorderLayout.NORTH);
<<<<<<< Updated upstream:Java_UI/Java_connection/Administrator/Frame.java
        Panel1.setPreferredSize(new Dimension(screensize.width, 80));
        Panel1.add(label2, BorderLayout.SOUTH);
        Panel1.add(label1, BorderLayout.NORTH);
        label2.setPreferredSize(new Dimension(screensize.width - 10, 25));
=======
>>>>>>> Stashed changes:Java_UI/Administrator/Frame.java
        this.add(panel2, BorderLayout.WEST);
        this.add(panel3, BorderLayout.EAST);
        this.setVisible(true);

        for (int i = 0; i < 7; i++) {
            buttons.get(i).setBounds(0, i * 55, 300, 50);
            panel2.add(buttons.get(i));
        }

    }

    public JButton CustomButton(String text) {
        JButton button = new JButton(text);
        button.setFont(new Font("Arial", Font.BOLD, 25));
        button.setBackground(new Color(35, 59, 97));
        button.setForeground(Color.white);
        button.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
        button.setFocusable(false);
        button.getModel().addChangeListener(new ChangeListener() {
            @Override
            // a state change for what happens to button when the button is clicked
            public void stateChanged(ChangeEvent e) {
                ButtonModel model = (ButtonModel) e.getSource();
                if (model.isRollover()) {
                    button.setBackground(new Color(60, 123, 240));
                } else {
                    button.setBackground(new Color(35, 59, 97));
                }
            }
        });
        return button;
    }

    public static void setColumnsWidth(JTable table, int tablePreferredWidth,
            double... percentages) {
        double total = 0;
        for (int i = 0; i < table.getColumnModel().getColumnCount(); i++) {
            total += percentages[i];
        }

        for (int i = 0; i < table.getColumnModel().getColumnCount(); i++) {
            TableColumn column = table.getColumnModel().getColumn(i);
            column.setPreferredWidth((int) (tablePreferredWidth * (percentages[i] / total)));
        }
    }

    public static void main(String[] args) {
        new Frame();
    }
}