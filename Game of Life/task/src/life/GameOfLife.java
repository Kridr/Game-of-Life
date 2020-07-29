package life;

import javax.swing.*;
import java.awt.*;

public class GameOfLife extends JFrame {
    Color color;
    int size = 10;
    int newSize = size;
    Generation generation = new Generation(size, true);

    public GameOfLife() {
        setSize(600, 554);
        setTitle("Game of Life");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setLayout(new BorderLayout());


        JLabel GenerationLabel = new JLabel();
        JLabel AliveLabel = new JLabel();
        GenerationLabel.setName("GenerationLabel");
        AliveLabel.setName("AliveLabel");

        JPanel panelForLabels = new JPanel();
        panelForLabels.add(GenerationLabel);
        panelForLabels.add(AliveLabel);

        add(panelForLabels, BorderLayout.NORTH);

        JButton colorButton = new JButton("Change Color");
        colorButton.addActionListener(actionEvent -> color = JColorChooser.showDialog(this, "Color", Color.BLACK));

        JButton sizeButton = new JButton("Change Size");
        sizeButton.addActionListener(actionEvent -> {
            JDialog dialog = new JDialog(this, "Change Size");
            dialog.setSize(50, 100);
            dialog.setVisible(true);

            JSpinner sizeSpinner = new JSpinner();
            sizeSpinner.setValue(size);
            dialog.add(sizeSpinner);

            JButton okButton = new JButton("OK");
            okButton.addActionListener(actionEvent1 -> {
                try {
                    int tempSize = (int) sizeSpinner.getValue();
                    newSize = tempSize > 0 ? tempSize : newSize;
                } catch (ClassCastException ignored) {}
                dialog.dispose();
            });
            dialog.add(okButton);
            dialog.setLayout(new BoxLayout(dialog.getContentPane(), BoxLayout.Y_AXIS));
        });

        JPanel panel = new JPanel() {
            @Override
            public void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2 = (Graphics2D) g;
                g2.setColor(color);

                int step = getWidth() / size;
                for (int i = 0; i < size; i++) {
                    for (int j = 0; j < size; j++) {
                        g2.drawRect(i * step, j * step, step, step);
                        if (generation.getFieldValue(i, j) == Cell.ALIVE) {
                            g2.fillRect(i * step, j * step, step, step);
                        }
                    }
                }
            }
        };
        add(panel, BorderLayout.CENTER);

        JToggleButton PlayToggleButton = new JToggleButton("Pause", false);
        PlayToggleButton.setName("PlayToggleButton");
        PlayToggleButton.addActionListener(actionEvent -> {
            if (PlayToggleButton.isSelected()) {
                PlayToggleButton.setText("Resume");
            } else {
                PlayToggleButton.setText("Pause");
            }
        });

        JButton ResetButton = new JButton();
        ResetButton.setName("ResetButton");
        ResetButton.setText("Restart");
        ResetButton.addActionListener(actionEvent -> {
            size = newSize;
            generation = new Generation(size, true);
        });

        JSlider slider = new JSlider(10, 2000, 1000);

        JPanel panelForButtons = new JPanel();
        panelForButtons.add(ResetButton);
        panelForButtons.add(PlayToggleButton);
        panelForButtons.add(colorButton);
        panelForButtons.add(sizeButton);

        panelForButtons.setLayout(new GridLayout(4, 1, 10, 10));

        add(panelForButtons, BorderLayout.EAST);


        add(slider, BorderLayout.PAGE_END);

        setVisible(true);

        for (int i = 0; i < 1000000; i++) {
            if (!PlayToggleButton.isSelected()) {
                GenerationLabel.setText("Generation #" + generation.getGeneration());
                AliveLabel.setText("Alive: " + generation.countAlive());
                panel.repaint();
                generation.nextGeneration();
                PlayToggleButton.setText("Pause");
            } else {
                i--;
            }

            try {
                Thread.sleep(slider.getValue());
            } catch (InterruptedException ignored) {}
        }
    }
}
