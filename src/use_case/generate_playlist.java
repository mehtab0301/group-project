package use_case;
import interface_adapter.generate.GenerateController;
import interface_adapter.generate.GenerateViewModel;
import view.GenerateView;

public class generate_playlist extends GenerateView {


    public int popularityLevel;

    public int loudness;

    public double valence;

    public double speechiness;

    public double energy;

    public String genre;


    public generate_playlist(GenerateController controller, GenerateViewModel generateViewModel) {
        super(controller, generateViewModel);
        this.popularityLevel = selectedPopularityLevel;
        //this.loudness = selectedLoudness;
        this.valence = selectedValence;
        this.speechiness = selectedSpeechiness;
        this.energy = selectedEnergy;
    }
}