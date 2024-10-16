import java.awt.BorderLayout;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JTextArea;
import javax.swing.Timer;
import javax.swing.WindowConstants;

/*
 * Adam Langbert | June 7, 2023 | CMIS 242
 * This program displays an animation of a dancing stick figure in a Swing GUI.
 * The speed of the animation is controllable by the slider.
 */
public class DancingStickFigureGUI {

    private JFrame frame;
    private JPanel panel;
    private JTextArea textArea;
    private JSlider slider;
    private String[] stickFigureFrames;
    private int currentFrame;
    private Timer timer;
    private final int minDelay = 10; // Minimum delay when slider is all the way to the right
    private final int maxDelay = 490; // Maximum delay when slider is all the way to the left

    public static void main(String[] args) {
        System.out.println("==== Adam Langbert | June 7, 2023 | CMIS 242 ====\n");
        DancingStickFigureGUI window = new DancingStickFigureGUI();
        window.frame.setVisible(true);
    }

    public DancingStickFigureGUI() {
        initialize();
    }

    private void initialize() {
        textArea = new JTextArea();
        textArea.setFont(new Font("monospaced", Font.PLAIN, 18));
        textArea.setEditable(false);

        slider = new JSlider(minDelay, maxDelay);
        slider.setValue((minDelay + maxDelay) / 2); // Set default value to the middle of the slider
        /*
         * We want the animation to move faster when the slider is moved to the right
         * which means the timer delay needs to get smaller
         * e.g. slider is at 300: 490 - 300 + 10 = 200
         * say slider is moved to the right to 400: 490 - 400 + 10 = 100
         * timer delay gets smaller so animation speed increases
         * We add minDelay so the timer delay can never be 0: 490 - 490 + 10
         */
        slider.addChangeListener(e -> timer.setDelay(maxDelay - slider.getValue() + minDelay));

        panel = new JPanel(new BorderLayout());
        panel.add(slider, BorderLayout.NORTH);
        panel.add(textArea, BorderLayout.CENTER);

        frame = new JFrame("Dancing Stick Figure");
        frame.setContentPane(panel);
        frame.setBounds(100, 100, 300, 300);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        stickFigureFrames = new String[] {
                "  O\n" +
                        " /|\\\n" +
                        " / \\",

                "  O\n" +
                        " <|\\\n" +
                        " /\\",

                "  O\n" +
                        " /|\\\n" +
                        " / \\",

                "  O\n" +
                        " /|>\n" +
                        "  /\\",
        };
        currentFrame = 0;

        // Timer that will advance the animation to the next frame after the delay
        timer = new Timer(maxDelay - slider.getValue() + minDelay, e -> {
            textArea.setText(stickFigureFrames[currentFrame]);
            // By doing % stickFigureFrames.length, currentFrame rolls back to 0 at the right time.
            // stickFigureFrames.length = 4
            // 1 % 4 = 1 -> 2 % 4 = 2 -> 3 % 4 = 3 -> 4 % 4 = 0
            currentFrame = (currentFrame + 1) % stickFigureFrames.length;
        });
        timer.start();
    }
}
