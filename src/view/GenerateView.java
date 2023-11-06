package src.view;

import src.interface_adapter.GenerateViewModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class GenerateView extends JPanel implements ActionListener, PropertyChangeListener {
    public final String viewName = "generate";

    private final GenerateViewModel generateViewModel;

    private JSlider popularity = new JSlider(0, 0, 100, 1);
    private final JTextField numTracksField = new JTextField(15);
    private final JButton generate;

    public GenerateView(GenerateViewModel generateViewModel) {
        this.generateViewModel = generateViewModel;
        generateViewModel.addPropertyChangeListener(this);

        JLabel title = new JLabel(GenerateViewModel.TITLE_LABEL);
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        LabelTextPanel numTracks = new LabelTextPanel(new JLabel(GenerateViewModel.PROMPT_LABEL), numTracksField);

        popularity.setPaintTrack(true);
        popularity.setPaintTicks(true);
        popularity.setPaintLabels(true);

        JPanel buttons = new JPanel();
        generate = new JButton(GenerateViewModel.GENERATE_BUTTON_LABEL);
        buttons.add(generate);

        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        this.add(title);
        this.add(popularity);
        this.add(numTracks);
        this.add(buttons);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {

    }
}
