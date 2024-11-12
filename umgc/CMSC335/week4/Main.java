import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class Main extends JFrame {
  private int clickCount = 0;
  private JLabel scoreLabel;
  private Random random = new Random();

  public Main() {
    setTitle("Color Change");
    setSize(400, 300);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setLayout(new BorderLayout());
    getContentPane().setBackground(Color.WHITE);

    JButton colorButton = new JButton("Click me!");
    scoreLabel = new JLabel("Clicks: 0");
    scoreLabel.setHorizontalAlignment(JLabel.CENTER);

    colorButton.addActionListener(e -> {
      clickCount++;
      scoreLabel.setText("Clicks: " + clickCount);
      // Generate random color
      Color randomColor = new Color(random.nextInt(256), random.nextInt(256), random.nextInt(256));
      getContentPane().setBackground(randomColor);
    });

    add(colorButton, BorderLayout.CENTER);
    add(scoreLabel, BorderLayout.NORTH);

    // Center the window on screen
    setLocationRelativeTo(null);
  }

  public static void main(String[] args) {
    SwingUtilities.invokeLater(() -> {
      Main app = new Main();
      app.setVisible(true);
    });
  }
}
