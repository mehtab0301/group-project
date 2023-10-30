package src.interface_adapter;

public class GenerateState {
    private String prompt = "";
    private String promptError = null;

    public GenerateState(GenerateState copy) {
        prompt = copy.prompt;
        promptError = copy.promptError;;
    }

    public GenerateState() {
    }

    public String getPrompt() {
        return prompt;
    }

    public String getPromptError() {
        return promptError;
    }

    public void setPrompt(String prompt) { this.prompt = prompt; }

    public void setPromptError(String promptError) { this.promptError = promptError; }

    @Override
    public String toString() {
        return "GenerateState{" +
                "prompt='" + prompt + '}';
    }
}
