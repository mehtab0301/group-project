package view;

import interface_adapter.generate.GenerateController;
import interface_adapter.generate.GenerateState;
import interface_adapter.generate.GenerateViewModel;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.HyperlinkEvent;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.IOException;
import java.awt.Color;
import java.awt.Font;

public class GenerateView extends JPanel implements ActionListener, PropertyChangeListener, ChangeListener {
    public final String viewName = "generate";

    private final GenerateViewModel generateViewModel;

    private final JComboBox genre;
    private final JSlider popularity = new JSlider(0, 0, 100, 0);
    private final JLabel popularity_index = new JLabel();
    private final JSlider danceability = new JSlider(0 ,0, 100, 0);
    private final JLabel danceability_index = new JLabel();
    private final JSlider valence = new JSlider(0, 0, 100, 0);
    private final JLabel valence_index = new JLabel();
    private final JSlider speechiness = new JSlider(0, 0, 100, 0);
    private final JLabel speechiness_index = new JLabel();
    private final JSlider energy = new JSlider(0, 0, 100, 0);
    private final JLabel energy_index = new JLabel();

    private final JTextField numTracksField = new JTextField(15);

    private final JButton generate;

    public int selectedPopularityLevel;

    public int selectedDanceability;

    public double selectedValence;

    public double selectedSpeechiness;

    public double selectedEnergy;

    private final GenerateController generateController;


    public GenerateView(GenerateController controller, GenerateViewModel generateViewModel) {
        this.generateController = controller;
        this.generateViewModel = generateViewModel;
        generateViewModel.addPropertyChangeListener(this);
        this.setBackground(new Color(213, 249,121));
        this.setForeground(new Color(22,23,46));
        this.setFont(new Font("Poppins", Font.BOLD, 13));

        // Title for the pop-up
        JLabel title = new JLabel(GenerateViewModel.TITLE_LABEL);
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        String genreList[] = {"acoustic", "afrobeat", "alt-rock", "alternative", "ambient", "anime", "black-metal",
                "bluegrass", "blues", "bossanova", "brazil", "breakbeat", "british", "cantopop", "chicago-house",
                "children", "chill", "classical", "club", "comedy", "country", "dance", "dancehall", "death-metal",
                "deep-house", "detroit-techno", "disco", "disney", "drum-and-bass", "dub", "dubstep", "edm", "electro",
                "electronic", "emo", "folk", "forro", "french", "funk", "garage", "german", "gospel", "goth",
                "grindcore", "groove", "grunge", "guitar", "happy", "hard-rock", "hardcore", "hardstyle", "heavy-metal",
                "hip-hop", "holidays", "honky-tonk", "house", "idm", "indian", "indie", "indie-pop", "industrial",
                "iranian", "j-dance", "j-idol", "j-pop", "j-rock", "jazz", "k-pop", "kids", "latin", "latino", "malay",
                "mandopop", "metal", "metal-misc", "metalcore", "minimal-techno", "movies", "mpb", "new-age",
                "new-release", "opera", "pagode", "party", "philippines-opm", "piano", "pop", "pop-film",
                "post-dubstep", "power-pop", "progressive-house", "psych-rock", "punk", "punk-rock", "r-n-b",
                "rainy-day", "reggae", "reggaeton", "road-trip", "rock", "rock-n-roll", "rockabilly", "romance",
                "sad", "salsa", "samba", "sertanejo", "show-tunes", "singer-songwriter", "ska", "sleep", "songwriter",
                "soul", "soundtracks", "spanish", "study", "summer", "swedish", "synth-pop", "tango", "techno"};

        genre = new JComboBox(genreList);

        JLabel genreLabel = new JLabel(GenerateViewModel.GENRE_LABEL);
        genreLabel.setFont(new Font("Poppins", Font.BOLD, 13));
        genreLabel.setForeground(new Color(22,23,46));
        JPanel genreBox = new JPanel();
        genreBox.add(genreLabel);
        genreBox.setBackground(new Color(169, 245,180));
        genreBox.add(genre);
        genreBox.setAlignmentX(Component.CENTER_ALIGNMENT);

        final Boolean[] isButtonClickedGenre = {false};
        genre.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        isButtonClickedGenre[0] = true;
                        GenerateState currentState = generateViewModel.getState();
                        String genreSelected = (String) genre.getSelectedItem();
                        currentState.setGenre(genreSelected);
                        generateViewModel.setState(currentState);
                    }
                }
        );
        if (!isButtonClickedGenre[0]){
            GenerateState currentState = generateViewModel.getState();
            genre.setSelectedItem("Acoustic");
            String genreSelected = (String) genre.getSelectedItem();
            currentState.setGenre(genreSelected);
            generateViewModel.setState(currentState);
        }

        // Popularity Index Slider
        popularity.setBorder(BorderFactory.createTitledBorder("Choose desired Popularity index:"));
        popularity.setForeground(new Color(22,23,46));
        popularity.setFont(new Font("Poppins", Font.BOLD, 13));
        popularity_index.setForeground(new Color(22,23,46));
        popularity_index.setFont(new Font("Poppins", Font.BOLD, 13));
        popularity.setMinorTickSpacing(1);
        popularity.setMajorTickSpacing(10);
        popularity.setPaintTicks(true);
        popularity.setPaintLabels(true);

        popularity.addChangeListener(
                new ChangeListener() {
                    @Override
                    public void stateChanged(ChangeEvent e) {
                        popularity_index.setText("value of Popularity chosen is = " + popularity.getValue());
                        popularity_index.setForeground(new Color(22,23,46));
                        popularity_index.setFont(new Font("Poppins", Font.BOLD, 13));
                        selectedPopularityLevel = popularity.getValue();

                        GenerateState currentState = generateViewModel.getState();
                        int popularitySelected = popularity.getValue();
                        currentState.setPopularity(popularitySelected);
                        generateViewModel.setState(currentState);
                    }
                }
        );

        popularity_index.setText("value of Popularity chosen is = " + popularity.getValue());
        popularity_index.setForeground(new Color(22,23,46));
        popularity_index.setAlignmentX(Component.CENTER_ALIGNMENT);

        // Danceability Index Slider
        danceability.setBorder(BorderFactory.createTitledBorder("Choose desired Danceability index:"));
        danceability.setForeground(new Color(22,23,46));
        danceability.setFont(new Font("Poppins", Font.BOLD, 13));
        danceability_index.setForeground(new Color(22,23,46));
        danceability_index.setFont(new Font("Poppins", Font.BOLD, 13));
        java.util.Hashtable labelTable = new java.util.Hashtable();
        labelTable.put(100, new JLabel("1.0"));
        labelTable.put(75, new JLabel("0.75"));
        labelTable.put(50, new JLabel("0.50"));
        labelTable.put(25, new JLabel("0.25"));
        labelTable.put(0, new JLabel("0.0"));
        danceability.setMinorTickSpacing(1);
        danceability.setMajorTickSpacing(10);
        danceability.setLabelTable(labelTable);
        danceability.setPaintTicks(true);
        danceability.setPaintLabels(true);

        danceability.addChangeListener(
                new ChangeListener() {
                    @Override
                    public void stateChanged(ChangeEvent e) {
                        danceability_index.setText("value of Danceability chosen is = " +
                                (double) danceability.getValue() / 100);
                        selectedDanceability = danceability.getValue();
                        danceability_index.setForeground(new Color(169, 245,180));

                        GenerateState currentState = generateViewModel.getState();
                        float danceabilitySelected = danceability.getValue() * 0.01F;
                        currentState.setDanceability(danceabilitySelected);
                        generateViewModel.setState(currentState);
                    }
                }
        );

        danceability_index.setText("value of Danceability chosen is = " + (double) danceability.getValue() / 100);
        danceability_index.setForeground(new Color(22,23,46));
        danceability_index.setAlignmentX(Component.CENTER_ALIGNMENT);

        // Valence Index Slider
        valence.setBorder(BorderFactory.createTitledBorder("Choose desired Valence index:"));
        valence.setMinorTickSpacing(1);
        valence.setMajorTickSpacing(10);
        valence.setLabelTable(labelTable);
        valence.setPaintTicks(true);
        valence.setFont(new Font("Poppins", Font.BOLD, 13));
        valence.setPaintLabels(true);

        valence.addChangeListener(
                new ChangeListener() {
                    @Override
                    public void stateChanged(ChangeEvent e) {
                        valence_index.setText("value of Valence chosen is = " + (double) valence.getValue() / 100);
                        selectedValence = valence.getValue();
                        valence_index.setForeground(new Color(169, 245,180));

                        GenerateState currentState = generateViewModel.getState();
                        float valenceSelected = valence.getValue() * 0.01F;
                        currentState.setValence(valenceSelected);
                        generateViewModel.setState(currentState);
                    }
                }
        );

        valence_index.setText("value of Valence chosen is = " + (double) valence.getValue() / 100);
        valence_index.setFont(new Font("Poppins", Font.BOLD, 13));
        valence_index.setForeground(new Color(22,23,46));
        valence_index.setAlignmentX(Component.CENTER_ALIGNMENT);

        // Speechiness Index Slider
        speechiness.setBorder(BorderFactory.createTitledBorder("Choose desired Speechiness index:"));
        speechiness.setMinorTickSpacing(1);
        speechiness.setMajorTickSpacing(10);
        speechiness.setFont(new Font("Poppins", Font.BOLD, 13));
        speechiness.setLabelTable(labelTable);
        speechiness.setPaintTicks(true);
        speechiness.setPaintLabels(true);

        speechiness.addChangeListener(
                new ChangeListener() {
                    @Override
                    public void stateChanged(ChangeEvent e) {
                        speechiness_index.setText("value of Speechiness chosen is = " +
                                (double) speechiness.getValue() / 100);
                        selectedSpeechiness = speechiness.getValue();


                        GenerateState currentState = generateViewModel.getState();
                        float speechinessSelected = speechiness.getValue() * 0.01F;
                        currentState.setSpeechiness(speechinessSelected);
                        generateViewModel.setState(currentState);
                    }
                }
        );

        speechiness_index.setText("value of Speechiness chosen is = " + (double) speechiness.getValue() / 100);
        speechiness_index.setForeground(new Color(22,23,46));
        speechiness_index.setFont(new Font("Poppins", Font.BOLD, 13));
        speechiness_index.setAlignmentX(Component.CENTER_ALIGNMENT);

        // Energy Index Slider
        TitledBorder energyIndex = BorderFactory.createTitledBorder("Choose desired Energy index:");
        energyIndex.setTitleColor(new Color(22,23,46));
        energy.setFont(new Font("Poppins", Font.BOLD, 13));
        energy.setBorder(energyIndex);
        energy.setMinorTickSpacing(1);
        energy.setForeground(new Color(22,23,46));
        energy.setMajorTickSpacing(10);
        energy.setLabelTable(labelTable);
        energy.setPaintTicks(true);
        energy.setPaintLabels(true);

        energy.addChangeListener(
                new ChangeListener() {
                    @Override
                    public void stateChanged(ChangeEvent e) {
                        energy_index.setText("value of Energy chosen is = " + (double) energy.getValue() / 100);
                        energy_index.setForeground(new Color(22,23,46));
                        selectedEnergy = energy.getValue();


                        GenerateState currentState = generateViewModel.getState();
                        float energySelected = energy.getValue() * 0.01F;
                        currentState.setEnergy(energySelected);
                        generateViewModel.setState(currentState);
                    }
                }
        );

        energy_index.setText("value of Energy chosen is = " + (double) energy.getValue() / 100);
        energy_index.setForeground(new Color(22,23,46));
        energy_index.setFont(new Font("Poppins", Font.BOLD, 13));
        energy_index.setAlignmentX(Component.CENTER_ALIGNMENT);

        // Input field for user to enter number of tracks they want in the playlist
        JLabel trackNumLabel = new JLabel(GenerateViewModel.NUM_TACKS_LABEL);
        trackNumLabel.setForeground(new Color(22,23,46));
        trackNumLabel.setBackground(new Color(213, 249,121));
        LabelTextPanel numTracks = new LabelTextPanel(trackNumLabel, numTracksField);
        numTracks.setBackground(new Color(169, 245,180));
        numTracks.setForeground(new Color(22,23,46));
        numTracks.setAlignmentX(Component.CENTER_ALIGNMENT);

        final Boolean[] isButtonClickedTracks = {false};
        numTracksField.addKeyListener(
                new KeyListener() {
                    @Override
                    public void keyTyped(KeyEvent  e) {
                        GenerateState currentState = generateViewModel.getState();
                        int numberOfTracks = Integer.valueOf(numTracksField.getText() + e.getKeyChar());
                        currentState.setNumberOfTracks(numberOfTracks);
                        generateViewModel.setState(currentState);
                    }

                    @Override
                    public void keyPressed(KeyEvent e) {
                    }

                    @Override
                    public void keyReleased(KeyEvent e) {
                    }
                }
        );
        if (!isButtonClickedTracks[0]){
            GenerateState currentState = generateViewModel.getState();
            int numberOfTracks = 1;
            currentState.setNumberOfTracks(numberOfTracks);
            generateViewModel.setState(currentState);
        }


        // Button for generating the playlist
        JPanel buttons = new JPanel();
        buttons.setForeground(new Color(22,23,46));
        buttons.setBackground(new Color(213, 249,121));
        generate = new JButton(GenerateViewModel.GENERATE_BUTTON_LABEL);
        generate.setForeground(new Color(22,23,46));
        generate.setBackground(new Color(213, 249,121));
        buttons.add(generate);

        generate.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if (e.getSource().equals(generate)) {
                            GenerateState currentState = generateViewModel.getState();

                            try {
                                generateController.execute(
                                        currentState.getGenre(),
                                        currentState.getPopularity(),
                                        currentState.getDanceability(),
                                        currentState.getValence(),
                                        currentState.getSpeechiness(),
                                        currentState.getEnergy(),
                                        currentState.getNumberOfTracks()
                                );
                            } catch (IOException ex) {
                                throw new RuntimeException(ex);
                            }
                        }
                    }
                }
        );

        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        this.add(title);
        this.add(genreBox);
        this.add(popularity, BorderLayout.SOUTH);
        this.add(popularity_index);
        this.add(danceability, BorderLayout.SOUTH);
        this.add(danceability_index);
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
    }


}
