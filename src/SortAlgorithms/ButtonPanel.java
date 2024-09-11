package SortAlgorithms;

import javax.swing.*;
import java.awt.event.*;
public class ButtonPanel extends JPanel {
    public static final long serialVersionUID = 1L;
    private static final int BUTTON_WIDTH = 200, BUTTON_HEIGHT = 70;
    private JLabel[] buttons;
    private SortButtonListener listener;
    private int number = 7;
    private JPopupMenu popupMenu;

    public ButtonPanel(SortButtonListener listener) {
        super();

        this.listener = listener;

        buttons = new JLabel[number];
        for (int i = 0; i < buttons.length; i++)
            buttons[i] = new JLabel();

        // initButtons(SortAlgorithms.buttons[0], "ramdom_button", 0);
        initButtons(buttons[0], "bubble_button", 0);
        initButtons(buttons[1], "selection_button", 1);
        initButtons(buttons[2], "insertion_button", 2);
        initButtons(buttons[3], "quick_button", 3);
        initButtons(buttons[4], "heap_button", 4);
        initButtons(buttons[5], "export_button", 9);
        initButtons(buttons[6], "compare_button", 10);

        // initButtons(SortAlgorithms.buttons[6], "create_button", 6);

        // add button to the panel
        setLayout(null);
        for (int i = 0; i < buttons.length; i++) {
            buttons[i].setBounds(20, 10 + (BUTTON_HEIGHT) * i, BUTTON_WIDTH, BUTTON_HEIGHT);
            add(buttons[i]);
        }

    }

    public ButtonPanel(SortButtonListener listener, String name, int id) {
        super();

        JLabel btn = new JLabel();
        this.listener = listener;
        initButtons(btn, name, id);
        setLayout(null);
        // btn.setBounds(0, 0, 60, 20);
        btn.setBounds(0, 0, BUTTON_WIDTH, BUTTON_HEIGHT);
        add(btn);
    }

    public ButtonPanel(SortButtonListener listener, String name, int id, int H, int W) {
        super();

        JLabel btn = new JLabel();
        this.listener = listener;
        initButtons(btn, name, id);
        setLayout(null);
        btn.setBounds(0, 0, H, W);
        // btn.setBounds(idx, idy, BUTTON_WIDTH, BUTTON_HEIGHT);
        add(btn);
    }

    private void initButtons(JLabel button, String name, int id) {
        final JLabel finalButton = button;
        final String name1 = name;
        final int stt = id;
        button.setIcon(new ImageIcon(String.format("src/SortAlgorithms/buttons/%s.png", name)));
        button.addMouseListener(new MouseListener() {
            public void mouseClicked(MouseEvent e) {
            }

            public void mouseEntered(MouseEvent e) {
                finalButton.setIcon(new ImageIcon(String.format("src/SortAlgorithms/buttons/%s_entered.png", name1)));
            }

            public void mouseExited(MouseEvent e) {
                finalButton.setIcon(new ImageIcon(String.format("src/SortAlgorithms/buttons/%s.png", name1)));
            }

            public void mousePressed(MouseEvent e) {
                finalButton.setIcon(new ImageIcon(String.format("src/SortAlgorithms/buttons/%s_pressed.png", name1)));
            }

            public void mouseReleased(MouseEvent e) {
                listener.sortButtonClicked(stt);
                finalButton.setIcon(new ImageIcon(String.format("buttons/%s_entered.png", name1)));
            }
        });
    }

    public interface SortButtonListener {
        void sortButtonClicked(int id);
    }
}
