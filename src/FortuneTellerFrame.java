import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.net.URL;
import java.util.ArrayList;
import java.util.Random;

public class FortuneTellerFrame extends JFrame {
    private int lastIndex = -1;
    private final JTextArea textArea;
    private final ArrayList<String> fortunes;

    public FortuneTellerFrame() {
        setTitle("Fortune Teller");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setLayout(new BorderLayout());

        // Top Panel
        JPanel topPanel = new JPanel();

        URL imageUrl = getClass().getResource("fortune.png");
        ImageIcon imageIcon = new ImageIcon(imageUrl);

        // Resize the image icon because otherwise it's way too big
        Image image = imageIcon.getImage();
        Image scaledImage = image.getScaledInstance(100, 100, java.awt.Image.SCALE_SMOOTH);  // set the width and height
        imageIcon = new ImageIcon(scaledImage);

        JLabel label = new JLabel("Fortune Teller", imageIcon, JLabel.CENTER);
        label.setFont(new Font("Arial", Font.BOLD, 36));

        // Position text below image
        label.setVerticalTextPosition(JLabel.BOTTOM);
        label.setHorizontalTextPosition(JLabel.CENTER);

        topPanel.add(label);
        add(topPanel, BorderLayout.NORTH);

        // Middle Panel
        textArea = new JTextArea(10, 40);
        textArea.setFont(new Font("Verdana", Font.PLAIN, 24));
        JScrollPane scrollPane = new JScrollPane(textArea);
        add(scrollPane, BorderLayout.CENTER);

        // Bottom Panel
        JPanel bottomPanel = new JPanel();
        JButton readButton = new JButton("Read My Fortune!");
        JButton quitButton = new JButton("Quit");
        readButton.setFont(new Font("Arial", Font.PLAIN, 24));
        quitButton.setFont(new Font("Arial", Font.PLAIN, 24));
        bottomPanel.add(readButton);
        bottomPanel.add(quitButton);
        add(bottomPanel, BorderLayout.SOUTH);

        // Fortunes
        fortunes = new ArrayList<>();
        fortunes.add("Your future involves a lot of snacks—probably more than you can handle.");
        fortunes.add("A great adventure awaits you, but first, a nap is required.");
        fortunes.add("You will soon find the remote control you’ve been searching for—right where you left it.");
        fortunes.add("This week, you’ll discover that your coffee is stronger than your willpower.");
        fortunes.add("Someone will make you laugh today; try not to snort in public.");
        fortunes.add("Your ability to avoid adulting will reach new heights; congrats on your promotion!");
        fortunes.add("A surprise is headed your way: it’s your own socks, finally reuniting after laundry day.");
        fortunes.add("You will soon impress someone with your amazing skill of procrastination.");
        fortunes.add("This month, you’ll discover that 'just one more episode' leads to poor life choices.");
        fortunes.add("A new hobby will bring you joy—right up until it requires actual effort.");
        fortunes.add("Beware of free food; it may come with unsolicited advice.");
        fortunes.add("Your pet will soon teach you a lesson in relaxation that you won’t forget… or take seriously.");

        readButton.addActionListener((ActionEvent e) -> readFortune());
        quitButton.addActionListener((ActionEvent e) -> System.exit(0));
    }

    private void readFortune() {
        Random random = new Random();
        int index;
        do {
            index = random.nextInt(fortunes.size());
        } while (index == lastIndex);
        lastIndex = index;
        String fortune = fortunes.get(index);
        textArea.append(fortune + "\n"); // add new line to end of fortune for readability
    }
}