import javax.swing.*;
import java.awt.Toolkit;
import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.GridLayout;

public class main {
    public static void main(String[] args) {

        //initialize Frame
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600,600);

        // Get screen size and set frame location to the center
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (screenSize.width - frame.getWidth()) / 2;
        int y = (screenSize.height - frame.getHeight()) / 2;
        frame.setLocation(x, y); // Set the location to the center of the screen

        //Overall main Panel, Container
        CardLayout cardLayout = new CardLayout();
        JPanel mainPanel = new JPanel(cardLayout);

        //main panel with buttons
        JPanel panelOverview = new JPanel();
        panelOverview.setLayout(new GridLayout(2,2));
        //Buttons to Navigate to each window
        JButton buttonAssignments = new JButton("Assignments");
        JButton buttonScripts = new JButton("Scripts");
        JButton buttonNotes = new JButton("Notes");
        JButton buttonLinks = new JButton("Links");
        panelOverview.add(buttonAssignments);panelOverview.add(buttonScripts);panelOverview.add(buttonNotes);panelOverview.add(buttonLinks);

        //Assignment Panel
        JPanel panelAssignments = new JPanel();
        panelAssignments.add(new JLabel("This is the Assignments panel"));
        //Buttons to navigate
        JButton buttonBack = new JButton("Back");
        panelAssignments.add(buttonBack);


        //add panels to the main panel
        mainPanel.add(panelOverview, "Overview Panel");
        mainPanel.add(panelAssignments, "Assignment Panel");


        //Actions for the Buttons to work
        buttonAssignments.addActionListener(e -> cardLayout.show(mainPanel, "Assignment Panel"));
        buttonBack.addActionListener(e -> cardLayout.show(mainPanel, "Overview Panel"));


        frame.add(mainPanel);
        frame.setVisible(true);
    }
}