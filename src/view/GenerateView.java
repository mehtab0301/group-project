package view;

import interface_adapter.GenerateViewModel;
import view.LabelTextPanel;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class GenerateView extends JPanel implements ActionListener, PropertyChangeListener, ChangeListener {
    public final String viewName = "generate";

    private final GenerateViewModel generateViewModel;

    private final JSlider popularity = new JSlider(0, 0, 100, 0);
    private final JLabel popularity_index = new JLabel();
    private final JSlider loudness = new JSlider(0 ,-60, 0, -60);
    private final JLabel loudness_index = new JLabel();
    private final JSlider valence = new JSlider(0, 0, 100, 0);
    private final JLabel valence_index = new JLabel();
    private final JSlider speechiness = new JSlider(0, 0, 100, 0);
    private final JLabel speechiness_index = new JLabel();
    private final JSlider energy = new JSlider(0, 0, 100, 0);
    private final JLabel energy_index = new JLabel();
    private final JTextField numTracksField = new JTextField(15);

    private final JButton generate;

    public GenerateView(GenerateViewModel generateViewModel) {
        this.generateViewModel = generateViewModel;
        generateViewModel.addPropertyChangeListener(this);

        JLabel title = new JLabel(GenerateViewModel.TITLE_LABEL);
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        LabelTextPanel numTracks = new LabelTextPanel(new JLabel(GenerateViewModel.NUM_TACKS_LABEL), numTracksField);
        numTracks.setAlignmentX(Component.CENTER_ALIGNMENT);

        // Popularity Index Slider
        popularity.setBorder(BorderFactory.createTitledBorder("Choose desired Popularity index:"));
        popularity.setMinorTickSpacing(1);
        popularity.setMajorTickSpacing(10);
        popularity.setPaintTicks(true);
        popularity.setPaintLabels(true);

        popularity.addChangeListener(this);

        popularity_index.setText("value of Popularity chosen is = " + popularity.getValue());
        popularity_index.setAlignmentX(Component.CENTER_ALIGNMENT);

        // Loudness Index Slider
        loudness.setBorder(BorderFactory.createTitledBorder("Choose desired Loudness index:"));
        loudness.setMinorTickSpacing(1);
        loudness.setMajorTickSpacing(10);
        loudness.setPaintTicks(true);
        loudness.setPaintLabels(true);

        loudness.addChangeListener(this);

        loudness_index.setText("value of Loudness chosen is = " + loudness.getValue());
        loudness_index.setAlignmentX(Component.CENTER_ALIGNMENT);

        // Valence Index Slider
        valence.setBorder(BorderFactory.createTitledBorder("Choose desired Valence index:"));
        java.util.Hashtable labelTable = new java.util.Hashtable();
        labelTable.put(100, new JLabel("1.0"));
        labelTable.put(75, new JLabel("0.75"));
        labelTable.put(50, new JLabel("0.50"));
        labelTable.put(25, new JLabel("0.25"));
        labelTable.put(0, new JLabel("0.0"));
        valence.setMinorTickSpacing(1);
        valence.setMajorTickSpacing(10);
        valence.setLabelTable(labelTable);
        valence.setPaintTicks(true);
        valence.setPaintLabels(true);

        valence.addChangeListener(this);

        valence_index.setText("value of Valence chosen is = " + (double) valence.getValue() / 100);
        valence_index.setAlignmentX(Component.CENTER_ALIGNMENT);

        // Speechiness Index Slider
        speechiness.setBorder(BorderFactory.createTitledBorder("Choose desired Speechiness index:"));
        speechiness.setMinorTickSpacing(1);
        speechiness.setMajorTickSpacing(10);
        speechiness.setLabelTable(labelTable);
        speechiness.setPaintTicks(true);
        speechiness.setPaintLabels(true);

        speechiness.addChangeListener(this);

        speechiness_index.setText("value of Speechiness chosen is = " + (double) speechiness.getValue() / 100);
        speechiness_index.setAlignmentX(Component.CENTER_ALIGNMENT);

        // Energy Index Slider
        energy.setBorder(BorderFactory.createTitledBorder("Choose desired Energy index:"));
        energy.setMinorTickSpacing(1);
        energy.setMajorTickSpacing(10);
        energy.setLabelTable(labelTable);
        energy.setPaintTicks(true);
        energy.setPaintLabels(true);

        energy.addChangeListener(this);

        energy_index.setText("value of Energy chosen is = " + (double) energy.getValue() / 100);
        energy_index.setAlignmentX(Component.CENTER_ALIGNMENT);


        JPanel buttons = new JPanel();
        generate = new JButton(GenerateViewModel.GENERATE_BUTTON_LABEL);
        buttons.add(generate);

        generate.addActionListener(this);

        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        this.add(title);
        this.add(popularity, BorderLayout.SOUTH);
        this.add(popularity_index);
        this.add(loudness, BorderLayout.SOUTH);
        this.add(loudness_index);
        this.add(valence, BorderLayout.SOUTH);
        this.add(valence_index);
        this.add(speechiness, BorderLayout.SOUTH);
        this.add(speechiness_index);
        this.add(energy, BorderLayout.SOUTH);
        this.add(energy_index);
        this.add(numTracks);
        this.add(buttons);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {

    }

    @Override
    public void stateChanged(ChangeEvent e) {
        popularity_index.setText("value of Popularity chosen is = " + popularity.getValue());
        loudness_index.setText("value of Loudness chosen is = " + loudness.getValue());
        valence_index.setText("value of Valence chosen is = " + (double) valence.getValue() / 100);
        speechiness_index.setText("value of Speechiness chosen is = " + (double) speechiness.getValue() / 100);
        energy_index.setText("value of Energy chosen is = " + (double) energy.getValue() / 100);
    }
}
