package User;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.SQLException;

import javax.swing.Timer;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;
import javax.swing.plaf.BorderUIResource;

import Commonclasses.ItemDAO;
import Commonclasses.Item;
import Commonclasses.*;

public class AddItem extends JPanel {
    public JLabel Intro_FIll, Item_Name, first_name, last_name, Reserve_Price, Image_Path, lblSelected,
            lblThisChoiceIs2, lblThisChoiceIs5;
    public JButton butt_additem, get_image;
    public String path;
    public File file;
    public int status = 11, height, width;
    public FileInputStream file_input;
    public JFileChooser file_chooser;
    public ImageIcon image;
    public Boolean selected = false, flag;
    public JTextField getfirst, getlast, getreserve, getitem;

    AddItem() throws Exception {
        Border glassyBorder = new BorderUIResource(
                BorderFactory.createEtchedBorder(EtchedBorder.RAISED, Color.WHITE, new Color(180, 180, 180)));

        file_chooser = new JFileChooser();
        Intro_FIll = new JLabel("Fill out the Following fields");
        Intro_FIll.setForeground(new Color(0, 0, 255));
        Intro_FIll.setFont(new Font("Arial", Font.PLAIN, 25));
        Intro_FIll.setBackground(new Color(35, 59, 97));
        Intro_FIll.setOpaque(true);
        Intro_FIll.setForeground(Color.white);
        Intro_FIll.setHorizontalAlignment(JLabel.CENTER);
        Intro_FIll.setBorder(glassyBorder);
        Intro_FIll.setBounds(100, 50, 500, 50);

        add(Intro_FIll);
        setLayout(null);
        setBounds(0, 0, 1060, 564);

        Item_Name = new JLabel("Item Name");
        Item_Name.setBounds(50, 150, 100, 30);
        add(Item_Name);

        getitem = new JTextField();
        getitem.setBounds(150, 150, 300, 30);
        add(getitem);

        first_name = new JLabel("First Name");
        first_name.setBounds(50, 200, 100, 30);
        add(first_name);

        getfirst = new JTextField();
        getfirst.setBounds(150, 200, 300, 30);
        add(getfirst);

        last_name = new JLabel("Last Name");
        last_name.setBounds(50, 250, 100, 30);
        add(last_name);

        getlast = new JTextField();
        getlast.setBounds(150, 250, 300, 30);
        add(getlast);

        Reserve_Price = new JLabel("Reserve Price");
        Reserve_Price.setBounds(50, 300, 100, 30);
        add(Reserve_Price);

        getreserve = new JTextField();
        getreserve.setBounds(150, 300, 300, 30);
        add(getreserve);

        Image_Path = new JLabel("Image Path");
        Image_Path.setBounds(50, 350, 100, 30);
        add(Image_Path);

        lblSelected = new JLabel("Selected");
        lblSelected.setForeground(new Color(0, 128, 0));
        lblSelected.setIcon(new ImageIcon("/home/ashish/Downloads/mark.png"));
        lblSelected.setBounds(534, 381, 121, 43);
        lblSelected.setVisible(false);
        add(lblSelected);

        lblThisChoiceIs2 = new JLabel("Please select valid choice");
        lblThisChoiceIs2.setForeground(Color.RED);
        lblThisChoiceIs2.setBounds(395, 236, 211, 15);
        add(lblThisChoiceIs2);
        lblThisChoiceIs2.setVisible(false);

        lblThisChoiceIs5 = new JLabel("Please upload a valid image ");
        lblThisChoiceIs5.setForeground(Color.RED);
        lblThisChoiceIs5.setBounds(395, 423, 211, 15);
        add(lblThisChoiceIs5);
        lblThisChoiceIs5.setVisible(false);

        get_image = new JButton("Upload");
        get_image.setForeground(new Color(0, 0, 255));
        get_image.setFont(new Font("Arial", Font.PLAIN, 25));
        get_image.setBackground(new Color(35, 59, 97));
        get_image.setOpaque(true);
        get_image.setForeground(Color.white);
        get_image.setHorizontalAlignment(JLabel.CENTER);
        get_image.setBorder(glassyBorder);
        get_image.setBounds(150, 350, 300, 30);
        get_image.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent Ac_ev) {
                status = file_chooser.showOpenDialog(null);
                if (status == JFileChooser.APPROVE_OPTION) {
                    lblSelected.setVisible(true);
                    file = file_chooser.getSelectedFile();
                    path = file.getAbsolutePath();
                    image = new ImageIcon(path);
                    height = image.getIconHeight();
                    width = image.getIconWidth();
                    if (height > 200 || width > 200) {
                        lblThisChoiceIs5.setVisible(true);
                        Timer t = new Timer(2000, new ActionListener() {
                            public void actionPerformed(ActionEvent e) {
                                lblThisChoiceIs5.setVisible(false);
                            }
                        });

                        t.setRepeats(false);
                        t.start();
                        status = 11;
                        lblSelected.setVisible(false);
                        return;
                    }
                    try {
                        file = new File(path);
                        file_input = new FileInputStream(file);
                        selected = true;
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    }

                } else if (status == JFileChooser.CANCEL_OPTION) {
                    if (selected == true) {
                        status = JFileChooser.APPROVE_OPTION;
                    }
                }
            }

        });
        add(get_image);

        butt_additem = new JButton("Add Item");
        butt_additem.setForeground(new Color(0, 0, 255));
        butt_additem.setFont(new Font("Arial", Font.PLAIN, 25));
        butt_additem.setBackground(new Color(35, 59, 97));
        butt_additem.setOpaque(true);
        butt_additem.setForeground(Color.white);
        butt_additem.setHorizontalAlignment(JLabel.CENTER);
        butt_additem.setBorder(glassyBorder);
        butt_additem.setBounds(150, 400, 150, 50);
        add(butt_additem);

        butt_additem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ev) {
                Item i_tem = new Item(getitem.getText(), "General", path, "Electronics",
                        Double.parseDouble(getreserve.getText()), "Active",
                        1);

                ItemDAO in = new ItemDAO();
                try {
                    in.insert(i_tem);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        });

        setVisible(true);

    }

}
